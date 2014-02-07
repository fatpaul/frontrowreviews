package com.youngstrategieslimited.frontrow.core.movie;

public class MovieReview {

    private final ResourceKey movieKey;
    private final String movieReviewText;
    private final ResourceKey movieReviewKey;

    public MovieReview(ResourceKey movieReviewKey, ResourceKey movieKey, String movieReviewText) {
        this.movieKey = movieKey;
        this.movieReviewText = movieReviewText;
        this.movieReviewKey = movieReviewKey;
    }

    public MovieReview(ResourceKey movieKey, String movieReviewText) {
        this.movieKey = movieKey;
        this.movieReviewText = movieReviewText;
        this.movieReviewKey = new ResourceKey();
    }

    public ResourceKey getMovieKey() {
        return movieKey;
    }
  
    public ResourceKey getKey() {
        return movieReviewKey;
    }

    public String getMovieReviewText() {
        return movieReviewText;
    }

    public void save(MovieReviewRespository movieReviewRespository) {
        movieReviewRespository.save(this);
    }
}
