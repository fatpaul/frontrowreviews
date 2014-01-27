package com.youngstrategieslimited.frontrow.rest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.youngstrategieslimited.frontrow.core.movie.Movie;

@XmlRootElement
public class MoviesViewModel {

	private List<MovieViewModel> movies = new ArrayList<MovieViewModel>();

	public MoviesViewModel() {
	}

	public MoviesViewModel(List<Movie> movies) {
		for (Movie movie : movies) {
			add(new MovieViewModel(movie));
		}
	}

	public void add(MovieViewModel movie) {
		movies.add(movie);
	}

	public MovieViewModel getAt(int index) {
		return movies.get(index);
	}
	
	public List<MovieViewModel> getMovies(){
		return movies;
	}
}
