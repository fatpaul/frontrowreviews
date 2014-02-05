package com.youngstrategieslimited.frontrow.rest;

import com.youngstrategieslimited.frontrow.adapters.movierepository.InMemoryMovieReviewRepository;
import com.youngstrategieslimited.frontrow.core.movie.MovieReview;
import com.youngstrategieslimited.frontrow.core.movie.MovieReviewRespository;
import com.youngstrategieslimited.frontrow.core.movie.ResourceKey;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/review")
public class MovieReviewResource {

    private final MovieReviewRespository movieReviewRespository;

    public MovieReviewResource() {
        movieReviewRespository = new InMemoryMovieReviewRepository();
    }

    MovieReviewResource(MovieReviewRespository movieReviewRespository) {
        this.movieReviewRespository = movieReviewRespository;
    }

    @POST
    @Consumes("application/json")
    public Response saveMovieReview(MovieReviewViewModel movieReviewViewModel) {

        MovieReview movieReview = movieReviewViewModel.createDomainModel();
        ResourceKey movieReviewKey = movieReviewRespository.save(movieReview);

        ResourceIdentifier resourceIdentifier = new ResourceIdentifier();

        resourceIdentifier.setUrl(movieReviewKey.appendKeyTo("/rest/review/"));

        return Response.status(201).entity(resourceIdentifier).build();
    }
}
