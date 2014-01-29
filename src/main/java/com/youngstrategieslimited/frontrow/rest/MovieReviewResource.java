package com.youngstrategieslimited.frontrow.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/review")
public class MovieReviewResource {

	public MovieReviewResource() {
	}

	@POST
	@Consumes("application/json")
	public Response saveMovieReview() {

        // need to pass ....
        
		ResourceIdentifier resourceIdentifier = new ResourceIdentifier();
		resourceIdentifier.setUrl("/rest/review/1");

		return Response.status(201).entity(resourceIdentifier).build();
	}
}