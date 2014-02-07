package com.youngstrategieslimited.frontrow.adapters.movierepository;

import com.youngstrategieslimited.frontrow.core.movie.MovieReview;
import com.youngstrategieslimited.frontrow.core.movie.MovieReviewRespository;
import com.youngstrategieslimited.frontrow.core.movie.ResourceKey;
import java.util.ArrayList;
import java.util.List;

public class InMemoryMovieReviewRepository implements MovieReviewRespository {

    private static List<MovieReview> movieReviewStore = new ArrayList<MovieReview>();

    @Override
    public ResourceKey save(MovieReview review) {
        movieReviewStore.add(review);
        ResourceKey movieKey = new ResourceKey(Long.toString(movieReviewStore.size()));
        return movieKey;
    }

    @Override
    public List<MovieReview> findBy(ResourceKey movieKey) {

        List<MovieReview> reviews = new ArrayList<MovieReview>();
        for (MovieReview review : movieReviewStore) {
            if (review.getMovieKey() != null && 
                    review.getMovieKey().equals(movieKey)) {
                reviews.add(review);
            }
        }

        return reviews;
    }
}
