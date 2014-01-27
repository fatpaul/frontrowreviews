$(document).ready(function(){
	
	//Unbind Image Draggin in html. Avoids drag problems on CoverFlow
	$('img').bind('dragstart', function(event) { event.preventDefault(); });
	
	var coverFlow1 = new CoverFlow($('#coverFlow1'));
		
	var coverFlow2 = new CoverFlow($('#coverFlow2'));

});
