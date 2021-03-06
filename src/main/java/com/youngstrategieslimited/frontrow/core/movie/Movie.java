package com.youngstrategieslimited.frontrow.core.movie;

public class Movie {

    private final String title;
    private final String description;

    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
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
}
