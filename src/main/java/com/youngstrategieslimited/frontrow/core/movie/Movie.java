package com.youngstrategieslimited.frontrow.core.movie;

public class Movie {

	private final String title;
	private final String description;
    private ResourceKey resourceKey;

	public Movie(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	public ResourceKey save(MovieRespository movieRespository) {
        resourceKey = movieRespository.save(this);
		return resourceKey;
	}

	public String getTitle() {
		return this.title;
	}

	public String getDescription() {
		return this.description;
	}

    public ResourceKey getKey() {
        return resourceKey;
    }
}
