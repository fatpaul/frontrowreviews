package com.youngstrategieslimited.frontrow.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/movie")
public class MovieResource {

	@POST
	@Consumes("application/json")
	public Response saveMoviewDetails(MovieViewModel movie) {

		String responseMessage = "{\"responseText\" : \"Movie saved : " + movie.getTitle() + " - " 
				+ movie.getDescription()+"\"}";

		System.out.println(responseMessage);

		return Response.status(201).entity(responseMessage).build();
	}
}