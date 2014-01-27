/* Copyright 2011 B4rc0ll0

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
 
var CoverFlow = $.Class.create({
	// constructor
	initialize : function(element) {

		/* Initialization */
		var handle = this;
		this._element = element;
		this._width = element.width();
		this._height = element.height();
	
		/* Parameters */
		this._snapshotClass = ".snapshot";
		this._snapshotDistance = this._width / 7;
		this._smoothness = 1;
		this._timeAnimation = 300;

		/* Finds & Binds snapshots */
		var list = []
		this._element.children(this._snapshotClass).each(function(index, value) {
			var snap = new Snapshot($(this));
			snap.getElement().attr('cindex', index);
			list[index] = snap;
		});
		this._snapshotList = list;
		this._selectedSnapshot = null;
	
		/* Setup */
		this.dispose();
		var middle = Math.floor(this._snapshotList.length / 2);
		this._index=middle;
		this.centerSnapshot(middle);
		this.bindsMouseEvents();
		this.bindsMouseWheelEvents();
			
		// resize, move to method
		$(window).resize(function() {
			handle._width = handle._element.width();
			handle._height = handle._element.height();
			handle._snapshotDistance = handle._width / 7;
			var index = handle.nearestSnapshot();
			handle.centerSnapshot(index);
		});
		
		// handle keyboard events
		$(window).on('keydown', function(event) {
			switch (event.which) {
				case 36:	// home
					break;
				case 35:	// end
					break;
				case 38:	// up
				case 37:	// left
					handle.applyDelta(-1);
					break;
				case 40:	// down
				case 39:	// right
					handle.applyDelta(+1);
					break;
				case 33:	// page up (towards home)
					break;
				case 34:	// page down (towards end)
					break;
			}
		});
	},
	/* Binds Mouse Wheel Events */
	bindsMouseWheelEvents : function() {
		var handle = this;
		this._element.on('mousewheel', function(event, delta) {
			handle.applyDelta(delta);
		});
	},
	/* apply any deltas */
	applyDelta : function(delta){
		var handle = this;
		var new_index = handle.calculateIndexAfter(delta);
		if(new_index===handle._index){
			// do nothing if already there....
			return;
		}
		handle.centerSnapshot(new_index);
	},
	/* Work out what the index should be after applying the delta */
	calculateIndexAfter : function(delta) {
		var handle = this;
		var new_index = handle._index+delta;
		if(new_index<0){
			new_index=0;
		}
		if(new_index >handle._snapshotList.length-1){
			new_index = handle._snapshotList.length-1;
		}
		return new_index;
	},
	/* Binds Mouse Dragging */
	bindsMouseEvents : function() {
	
		var handle = this;
		this._dragging = false;
		this._lastPageX = 0;
		this._element.mousedown(function(event) {
			handle._dragging = true;
		});
		this._element.mouseup(function(event) {
			handle._dragging = false;
			handle.stopDragging(event);
		});
		this._element.mouseleave(function(event) {
			if(handle._dragging) {
				handle._dragging = false;
				handle.stopDragging();
			}
		});
		this._element.mousemove(function(event) {
			if(handle._dragging) {
				var dx = event.pageX - handle._lastPageX;
				handle.rotate(dx);
			}
			handle._lastPageX = event.pageX;
		});
	},
	/* Gets middle Y point of CoverFlow */
	middleY : function() {
		return this._height / 2;
	},
	/* Gets middle X point of CoverFlow */
	middleX : function() {
		return this._width / 2;
	},
	/* Gets a number between [0,1] by distance from middleX */
	getRatio : function(x) {
		var distance = Math.abs(x - this.middleX());
		var smooth = this._smoothness;
		var bound = (this._width / 2) * smooth;
		var ratio = 1 - (distance / bound);
		
		return ratio;
	},
	/* Handles stop dragging event, centering nearest snapshot on screen */
	stopDragging : function(event) {
		var index = this.nearestSnapshot();
		this.centerSnapshot(index);
	},
	/* Finds index of nearest snapshot to center */
	nearestSnapshot : function() {
		var handle = this;
		var nearest = null;
		var minDistance = this._width;
		var distance = 0;
		$.each(this._snapshotList, function(index, value) {
			distance = Math.abs(value.getX() - handle.middleX());
			if(distance < minDistance) {
				minDistance = distance;
				nearest = index;
			}
		});
		handle._index=nearest;
		return nearest;
	},
	/* Puts Snapshot in X location modifying its style*/
	placeSnapshot : function(snapshot, x) {
		var ratio = this.getRatio(x);
		var y = this.middleY();
		var h = this._height+10;
		var w = h;
		snapshot.setSize(w, h);
		snapshot.morphByRatio(ratio);
		snapshot.setPosition(x, y);
	},
	/* Moves all snapshots */
	rotate : function(dx) {
		var handle = this;
		$.each(this._snapshotList, function(index, value) {
			var x = value.getX();
			handle.placeSnapshot(value, (x + dx));
		});
	},
	/* Center selected Snapshot with animation */
	centerSnapshot : function(index) {
		var handle = this;
		this._selectedSnapshot = index;
		var snapshot = this._snapshotList[index];
		if(!snapshot){
			return;
		}
		snapshot.getElement().css('z-index', 100);
		var x = snapshot.getX();
		var distance = handle.middleX() - x;
		var y = this.middleY();
		
		$.each(this._snapshotList, function(i, value) {
			
			var nx = value.getX() + distance;
			var ratio = handle.getRatio(nx);
			var w = handle._height * ratio;
			var h = handle._height * ratio;
		
			if(index != i) {
				value.getElement().css('z-index', 1);
			}
			value.animate(nx, y, w, h, ratio, handle._timeAnimation, 'swing', function(){
			});
		});
		handle._index=index;
	},
	/* Disposes snapshot in container */
	dispose : function() {
		var px = 0;
		var handle = this;
		$.each(this._snapshotList, function(index, value) {
			handle.placeSnapshot(value, px);
			px += handle._snapshotDistance;
			// value.getElement().mousedown(function(){
			// handle.centerSnapshot(value.getElement().attr('cindex'));
			// });
		});
	}
}, {
	// properties
	getset : [['Width', '_width'], ['Height', '_height'], ['Element', '_element']]
});
