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

	private MovieRespository movieRespository = new InMemoryMovieRepository();
	
	@POST
	@Consumes("application/json")
	public Response saveMoviewDetails(MovieViewModel movieViewModel) {

		Movie movie = movieViewModel.createDomainModel();
		MovieKey movieKey = movie.save(movieRespository);
		
		StringBuilder responseMessage = new StringBuilder();
		responseMessage.append("{");
		appendJsonAttribute(responseMessage, "url", movieKey.appendKeyTo("/rest/movie/"));
		responseMessage.append(",");
		appendJsonAttribute(responseMessage, "responseText",movieViewModel.getTitle() + " - " 
				+ movieViewModel.getDescription());
		responseMessage.append("}");

		System.out.println(responseMessage.toString());

		return Response.status(201).entity(responseMessage.toString()).build();
	}
	
	private void appendJsonAttribute(StringBuilder builder, String attribute, String value){
		builder.append("\"");
		builder.append(attribute);
		builder.append("\":\"");
		builder.append(value);
		builder.append("\"");
		
	}
}