package com.youngstrategieslimited.frontrow.adapters.movierepository;

import com.youngstrategieslimited.frontrow.core.movie.MovieReview;
import com.youngstrategieslimited.frontrow.core.movie.MovieReviewRespository;
import com.youngstrategieslimited.frontrow.core.movie.ResourceKey;
import java.util.ArrayList;
import java.util.List;

public class InMemoryMovieReviewRepository implements MovieReviewRespository {

    private static List<MovieReview> movieReviewStore = new ArrayList<MovieReview>();

    @Override
    public ResourceKey save(MovieReview movie) {
        movieReviewStore.add(movie);
        return new ResourceKey(Long.toString(movieReviewStore.size()));
    }

    @Override
    public List<MovieReview> list() {
        return movieReviewStore;
    }
}
