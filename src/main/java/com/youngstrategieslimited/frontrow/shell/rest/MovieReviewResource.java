package com.youngstrategieslimited.frontrow.shell.rest;

import com.sun.jersey.api.JResponse;
import com.youngstrategieslimited.frontrow.shell.adapters.movierepository.InMemoryMovieReviewRepository;
import com.youngstrategieslimited.frontrow.core.movie.MovieReview;
import com.youngstrategieslimited.frontrow.core.movie.MovieReviewRespository;
import com.youngstrategieslimited.frontrow.core.movie.ResourceKey;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/review")
public class MovieReviewResource {

    private static MovieReviewRespository movieReviewRespository = new InMemoryMovieReviewRepository();

    public MovieReviewResource(){
    }
    
    MovieReviewResource(MovieReviewRespository movieReviewRespository) {
        MovieReviewResource.movieReviewRespository = movieReviewRespository;
    }

    @POST
    @Consumes("application/json")
    public Response saveMovieReview(MovieReviewViewModel movieReviewViewModel) {

        MovieReview movieReview = movieReviewViewModel.createDomainModel();
        movieReview.save(movieReviewRespository);
        ResourceKey key = movieReviewRespository.getKey(movieReview);
        ResourceIdentifier resourceIdentifier = new ResourceIdentifier();

        resourceIdentifier.setUrl(key.appendKeyTo("/rest/review/"));

        return Response.status(201).entity(resourceIdentifier).build();
    }

    @GET
    @Produces("application/json")
    @Path("{movieResourceId}")
    public JResponse<List<MovieReviewViewModel>> getAllReviewsForMovie(@PathParam("movieResourceId") String movieResourceId) {
        List<MovieReview> reviews = movieReviewRespository.findBy(new ResourceKey(movieResourceId));
        MovieReviewsViewModel reviewViews = new MovieReviewsViewModel(reviews);
        return JResponse.ok(reviewViews.getMovieReviews()).build();
    }
}
