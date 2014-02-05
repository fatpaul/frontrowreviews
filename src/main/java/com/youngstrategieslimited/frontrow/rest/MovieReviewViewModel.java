package com.youngstrategieslimited.frontrow.rest;

import com.youngstrategieslimited.frontrow.core.movie.MovieReview;
import com.youngstrategieslimited.frontrow.core.movie.ResourceKey;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MovieReviewViewModel {
    private ResourceKey movieKey;
    private String movieReviewText;

    public MovieReviewViewModel(ResourceKey movieKey, String movieReviewText) {
        this.movieKey = movieKey;
        this.movieReviewText = movieReviewText;
    }

    // for jackson support
    public MovieReviewViewModel() {
    }

    public MovieReview createDomainModel() {
        return new MovieReview(getMovieKey(), getMovieReviewText());
    }

    public ResourceKey getMovieKey() {
        return movieKey;
    }

    public void setMovieKey(ResourceKey movieKey) {
        this.movieKey = movieKey;
    }

    public String getMovieReviewText() {
        return movieReviewText;
    }

    public void setMovieReviewText(String movieReviewText) {
        this.movieReviewText = movieReviewText;
    }
}
