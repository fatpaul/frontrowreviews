package com.youngstrategieslimited.frontrow.core.movie;

public class MovieReview {

    private final ResourceKey movieKey;
    private final String movieReviewText;
    private final ResourceKey movieReviewKey;
    private final String reviewerEmailAddress;

    public MovieReview(ResourceKey movieReviewKey, ResourceKey movieKey, String movieReviewText, String reviewerEmailAddress) {
        this.movieKey = movieKey;
        this.movieReviewText = movieReviewText;
        this.movieReviewKey = movieReviewKey;
        this.reviewerEmailAddress = reviewerEmailAddress;
    }

    public MovieReview(ResourceKey movieKey, String movieReviewText, String reviewerEmailAddress) {
        this.movieKey = movieKey;
        this.movieReviewText = movieReviewText;
        this.movieReviewKey = new ResourceKey();
        this.reviewerEmailAddress = reviewerEmailAddress;
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
    
    public String getReviewerEmailAddress(){
        return reviewerEmailAddress;
    }

    public void save(MovieReviewRespository movieReviewRespository) {
        movieReviewRespository.save(this);
    }
}
