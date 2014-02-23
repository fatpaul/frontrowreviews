package com.youngstrategieslimited.frontrow.shell.rest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.youngstrategieslimited.frontrow.core.movie.Movie;
import com.youngstrategieslimited.frontrow.core.movie.MovieRespository;

@XmlRootElement
public class MoviesViewModel {

	private final List<MovieViewModel> movies = new ArrayList<MovieViewModel>();

	public MoviesViewModel() {
	}

	public MoviesViewModel(MovieRespository movieRepository, List<Movie> movies) {
		for (Movie movie : movies) {
			add(new MovieViewModel(movieRepository.getKey(movie), movie));
		}
	}

	private void add(MovieViewModel movie) {
		movies.add(movie);
	}

	public MovieViewModel getAt(int index) {
		return movies.get(index);
	}
	
	public List<MovieViewModel> getMovies(){
		return movies;
	}
}
