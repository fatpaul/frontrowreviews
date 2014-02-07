package com.youngstrategieslimited.frontrow.rest;

import com.youngstrategieslimited.frontrow.core.movie.MovieReview;
import com.youngstrategieslimited.frontrow.core.movie.ResourceKey;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MovieReviewViewModel {
    private String movieKey;
    private String movieReviewText;

    public MovieReviewViewModel(String movieKey, String movieReviewText) {
        this.movieKey = movieKey;
        this.movieReviewText = movieReviewText;
    }

    public MovieReviewViewModel(MovieReview movieReview) {
        this.movieKey = movieReview.getMovieKey().appendKeyTo("");
        this.movieReviewText = movieReview.getMovieReviewText();
    }

    // for jackson support
    public MovieReviewViewModel() {
    }

    public MovieReview createDomainModel() {
        return new MovieReview(new ResourceKey(movieKey), movieReviewText);
    }

    public String getMovieKey() {
        return movieKey;
    }

    public ResourceKey getMovieKeyAsResource() {
        return new ResourceKey(movieKey);
    }

    public void setMovieKey(String movieKey) {
        this.movieKey = movieKey;
    }

    public String getMovieReviewText() {
        return movieReviewText;
    }

    public void setMovieReviewText(String movieReviewText) {
        this.movieReviewText = movieReviewText;
    }
}
