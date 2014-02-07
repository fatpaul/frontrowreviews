package com.youngstrategieslimited.frontrow.core.movie;

public class Movie {

    private final String title;
    private final String description;
    private final ResourceKey resourceKey;

    public Movie(ResourceKey resourceKey, String title, String description) {
        this.title = title;
        this.description = description;
        this.resourceKey = resourceKey;
    }

    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
        this.resourceKey = new ResourceKey();
    }

    public void save(MovieRespository movieRespository) {
        movieRespository.save(this);
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
