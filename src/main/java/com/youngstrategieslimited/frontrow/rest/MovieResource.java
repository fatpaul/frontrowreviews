package com.youngstrategieslimited.frontrow.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.youngstrategieslimited.frontrow.adapters.movierepository.InMemoryMovieRepository;
import com.youngstrategieslimited.frontrow.core.movie.Movie;
import com.youngstrategieslimited.frontrow.core.movie.MovieKey;
import com.youngstrategieslimited.frontrow.core.movie.MovieRespository;

@Path("/movie")
public class MovieResource {

	private MovieRespository movieRespository;

	public MovieResource(MovieRespository movieRespository){
		this.movieRespository = movieRespository;
	}
	
	public MovieResource(){
		this(new InMemoryMovieRepository());
	}
	
	@POST
	@Consumes("application/json")
	public Response saveMovieDetails(MovieViewModel movieViewModel) {

		Movie movie = movieViewModel.createDomainModel();
		MovieKey movieKey = movie.save(movieRespository);
		
		ResourceIdentifier resourceIdentifier = new ResourceIdentifier();
		resourceIdentifier.setUrl(movieKey.appendKeyTo("/rest/movie/"));
		
		return Response.status(201).entity(resourceIdentifier).build();
	}
}