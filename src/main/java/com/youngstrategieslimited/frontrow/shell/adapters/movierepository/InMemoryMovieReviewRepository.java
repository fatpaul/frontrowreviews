package com.youngstrategieslimited.frontrow.shell.adapters.movierepository;

import com.youngstrategieslimited.frontrow.core.movie.MovieReview;
import com.youngstrategieslimited.frontrow.core.movie.MovieReviewRespository;
import com.youngstrategieslimited.frontrow.core.movie.ResourceKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class InMemoryMovieReviewRepository implements MovieReviewRespository {

    private Map<String, MovieReview> movieReviewStore = new HashMap<String, MovieReview>();

    @Override
    public void save(MovieReview review) {
        movieReviewStore.put(UUID.randomUUID().toString(), review);
    }

    @Override
    public List<MovieReview> findBy(ResourceKey movieKey) {

        Set<String> keySet = movieReviewStore.keySet();
        Iterator<String> iterator = keySet.iterator();
        List<MovieReview> movieReviews = new ArrayList<MovieReview>();
        while (iterator.hasNext()) {
            MovieReview movieReview = movieReviewStore.get(iterator.next());
            if (movieReview.getMovieKey() != null
                    && movieReview.getMovieKey().equals(movieKey)) {
                movieReviews.add(movieReview);
            }
        }
        return movieReviews;
    }

    @Override
    public ResourceKey getKey(MovieReview movieReviewToFind) {
        Set<String> keySet = movieReviewStore.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            MovieReview movieReview = movieReviewStore.get(key);
            if (movieReview.equals(movieReviewToFind)) {
                return new ResourceKey(key);
            }
        }
        return new ResourceKey("");
    }
}
