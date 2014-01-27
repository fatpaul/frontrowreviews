package com.youngstrategieslimited.frontrow.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sun.jersey.api.JResponse;
import com.youngstrategieslimited.frontrow.core.movie.Movie;
import com.youngstrategieslimited.frontrow.core.movie.MovieKey;
import com.youngstrategieslimited.frontrow.core.movie.MovieRespository;

@RunWith(MockitoJUnitRunner.class)
public class MovieResourceTest {

	@Mock
	private MovieRespository movieRespository;

	@Test
	public void testSaveMovieDetails() throws Exception {

		MovieKey movieKey = new MovieKey(5L);
		Mockito.when(movieRespository.save(Mockito.any(Movie.class)))
				.thenReturn(movieKey);

		MovieResource movieResource = new MovieResource(movieRespository);
		MovieViewModel movieViewModel = new MovieViewModel();
		Response saveMovieDetailsResponse = movieResource
				.saveMovieDetails(movieViewModel);

		Mockito.verify(movieRespository).save(Mockito.any(Movie.class));

		ResourceIdentifier resourceIdentifier = (ResourceIdentifier) saveMovieDetailsResponse
				.getEntity();

		// don't mind what the id is at the end just that we have a url
		Assert.assertTrue(resourceIdentifier.getUrl()
				.startsWith("/rest/movie/"));
	}

	@Test
	public void testListMovieDetails() throws Exception {

		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie("title", "description"));

		Mockito.when(movieRespository.list()).thenReturn(movies);

		MovieResource movieResource = new MovieResource(movieRespository);
		JResponse saveMovieDetailsResponse = movieResource.getAllMovies();

		Mockito.verify(movieRespository).list();

		List<MovieViewModel> moviesViewModel = (List<MovieViewModel>) saveMovieDetailsResponse
				.getEntity();

		// don't mind what the id is at the end just that we have a url
		Assert.assertTrue(moviesViewModel.get(0).getTitle().equals("title"));
		Assert.assertTrue(moviesViewModel.get(0).getDescription()
				.equals("description"));
	}
}
