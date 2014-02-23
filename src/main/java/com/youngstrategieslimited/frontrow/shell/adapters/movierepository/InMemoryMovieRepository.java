package com.youngstrategieslimited.frontrow.shell.adapters.movierepository;

import java.util.List;

import com.youngstrategieslimited.frontrow.core.movie.Movie;
import com.youngstrategieslimited.frontrow.core.movie.MovieRespository;
import com.youngstrategieslimited.frontrow.core.movie.ResourceKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class InMemoryMovieRepository implements MovieRespository {

    private Map<String, Movie> movieStore = new HashMap<String, Movie>();

    @Override
    public void save(Movie movie) {
        movieStore.put(UUID.randomUUID().toString(), movie);
    }

    @Override
    public List<Movie> list() {
        Set<String> keySet = movieStore.keySet();
        Iterator<String> iterator = keySet.iterator();
        List<Movie> movies = new ArrayList<Movie>();
        while (iterator.hasNext()) {
            movies.add(movieStore.get(iterator.next()));
        }
        return movies;
    }

    @Override
    public ResourceKey getKey(Movie movieToFind) {

        Set<String> keySet = movieStore.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Movie movie = movieStore.get(key);
            if (movie.equals(movieToFind)) {
                return new ResourceKey(key);
            }
        }
        return new ResourceKey("");
    }
}
