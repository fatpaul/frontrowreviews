package com.youngstrategieslimited.frontrow.adapters.movierepository;

import java.util.ArrayList;
import java.util.List;

import com.youngstrategieslimited.frontrow.core.movie.Movie;
import com.youngstrategieslimited.frontrow.core.movie.MovieKey;
import com.youngstrategieslimited.frontrow.core.movie.MovieRespository;

public class InMemoryMovieRepository implements MovieRespository{

	private List<Movie> movieStore = new ArrayList<Movie>();
	
	@Override
	public MovieKey save(Movie movie) {
		movieStore.add(movie);
		return new MovieKey(movieStore.size());
	}

}