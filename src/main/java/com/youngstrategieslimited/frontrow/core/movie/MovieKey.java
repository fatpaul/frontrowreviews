package com.youngstrategieslimited.frontrow.core.movie;

public class MovieKey {

	private String id = null;

	public MovieKey(Movie movie) {
		this.id = movie.getTitle();
	}

	public String appendKeyTo(String resource) {
		return resource + this.id;
	}
}
