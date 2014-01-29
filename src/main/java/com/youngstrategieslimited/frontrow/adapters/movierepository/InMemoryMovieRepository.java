package com.youngstrategieslimited.frontrow.adapters.movierepository;

import java.util.ArrayList;
import java.util.List;

import com.youngstrategieslimited.frontrow.core.movie.Movie;
import com.youngstrategieslimited.frontrow.core.movie.ResourceKey;
import com.youngstrategieslimited.frontrow.core.movie.MovieRespository;

public class InMemoryMovieRepository implements MovieRespository{

	private static List<Movie> movieStore = new ArrayList<Movie>();
	
	@Override
	public ResourceKey save(Movie movie) {
		movieStore.add(movie);
		return new ResourceKey(Long.toString(movieStore.size()));
	}

	@Override
	public List<Movie> list() {
		return movieStore;
	}

}
