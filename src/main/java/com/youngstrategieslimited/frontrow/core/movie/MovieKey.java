package com.youngstrategieslimited.frontrow.core.movie;

public class MovieKey {

	private long id = -1;

	public MovieKey(long id) {
		this.id = id;
	}

	public String appendKeyTo(String resource) {
		return resource + this.id;
	}
}
