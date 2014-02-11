package com.youngstrategieslimited.frontrow.shell.rest;

import com.youngstrategieslimited.frontrow.core.movie.MovieReview;
import com.youngstrategieslimited.frontrow.core.movie.ResourceKey;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MovieReviewViewModel {
    private String movieKey;
    private String movieReviewText;
    private String reviewerEmailAddress;

    public MovieReviewViewModel(String movieKey, String movieReviewText, String reviewerEmailAddress) {
        this.movieKey = movieKey;
        this.movieReviewText = movieReviewText;
        this.reviewerEmailAddress = reviewerEmailAddress;
    }

    public MovieReviewViewModel(MovieReview movieReview) {
        this.movieKey = movieReview.getMovieKey().appendKeyTo("");
        this.movieReviewText = movieReview.getMovieReviewText();
        this.reviewerEmailAddress = movieReview.getReviewerEmailAddress();
    }

    // for jackson support
    public MovieReviewViewModel() {
    }

    public MovieReview createDomainModel() {
        return new MovieReview(new ResourceKey(movieKey), movieReviewText, reviewerEmailAddress);
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
    
     public String getReviewerEmailAddress() {
        return reviewerEmailAddress;
    }

    public void setReviewerEmailAddress(String movieReviewText) {
        this.reviewerEmailAddress = movieReviewText;
    }
}
