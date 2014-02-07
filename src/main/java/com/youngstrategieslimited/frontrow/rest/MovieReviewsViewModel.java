package com.youngstrategieslimited.frontrow.rest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.youngstrategieslimited.frontrow.core.movie.MovieReview;

@XmlRootElement
public class MovieReviewsViewModel {

	private List<MovieReviewViewModel> reviews = new ArrayList<MovieReviewViewModel>();

	public MovieReviewsViewModel() {
	}

	public MovieReviewsViewModel(List<MovieReview> reviews) {
		for (MovieReview review : reviews) {
			add(new MovieReviewViewModel(review));
		}
	}

	private void add(MovieReviewViewModel review) {
		reviews.add(review);
	}

	public MovieReviewViewModel getAt(int index) {
		return reviews.get(index);
	}
	
	public List<MovieReviewViewModel> getMovieReviews(){
		return reviews;
	}
}
