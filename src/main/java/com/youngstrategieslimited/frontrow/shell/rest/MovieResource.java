package com.youngstrategieslimited.frontrow.shell.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.JResponse;
import com.youngstrategieslimited.frontrow.shell.adapters.movierepository.InMemoryMovieRepository;
import com.youngstrategieslimited.frontrow.core.movie.Movie;
import com.youngstrategieslimited.frontrow.core.movie.ResourceKey;
import com.youngstrategieslimited.frontrow.core.movie.MovieRespository;

@Path("/movie")
public class MovieResource {

	private MovieRespository movieRespository;

	public MovieResource(MovieRespository movieRespository) {
		this.movieRespository = movieRespository;
	}

	public MovieResource() {
		this(new InMemoryMovieRepository());
	}

	@POST
	@Consumes("application/json")
	public Response saveMovieDetails(MovieViewModel movieViewModel) {

		Movie movie = movieViewModel.createDomainModel();
		ResourceKey resourceKey = movie.getKey();
        movie.save(movieRespository);

		ResourceIdentifier resourceIdentifier = new ResourceIdentifier();
		resourceIdentifier.setUrl(resourceKey.appendKeyTo("/rest/movie/"));

		return Response.status(201).entity(resourceIdentifier).build();
	}

	@GET
	@Produces("application/json")
	public JResponse<List<MovieViewModel>> getAllMovies() {
		MoviesViewModel movies = new MoviesViewModel(movieRespository.list());
		return JResponse.ok(movies.getMovies()).build();
	}
}