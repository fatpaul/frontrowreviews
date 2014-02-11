package com.youngstrategieslimited.frontrow.shell.rest;

import com.youngstrategieslimited.frontrow.shell.rest.MovieReviewViewModel;
import com.youngstrategieslimited.frontrow.shell.rest.ResourceIdentifier;
import com.youngstrategieslimited.frontrow.shell.rest.MovieReviewResource;
import com.sun.jersey.api.JResponse;
import com.youngstrategieslimited.frontrow.core.movie.MovieReview;
import com.youngstrategieslimited.frontrow.core.movie.MovieReviewRespository;
import com.youngstrategieslimited.frontrow.core.movie.ResourceKey;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MovieReviewResourceTest {

    @Mock
    private MovieReviewRespository movieReviewRespository;

    @Test
    public void testSaveMovieReview() throws Exception {

        MovieReviewResource movieReviewResource = new MovieReviewResource(movieReviewRespository);

        ResourceKey movieReviewKey = new ResourceKey("1");

        Mockito.when(movieReviewRespository.save(Mockito.any(MovieReview.class)))
                .thenReturn(movieReviewKey);

        ResourceKey movieKey = new ResourceKey("1");
        String movieReviewText = "Movie review text";
        String reviewerEmailAddress = "pauls@nightmare.com";
        MovieReviewViewModel review = new MovieReviewViewModel("1", movieReviewText, reviewerEmailAddress);

        Response saveMovieReviewResponse = movieReviewResource
                .saveMovieReview(review);

        Mockito.verify(movieReviewRespository).save(Mockito.any(MovieReview.class));

        ResourceIdentifier resourceIdentifier = (ResourceIdentifier) saveMovieReviewResponse
                .getEntity();

        Assert.assertTrue(resourceIdentifier.getUrl().startsWith("/rest/review/"));
    }

    @Test
    public void testFindAllReviewsForAMovie() throws Exception {

        List<MovieReview> reviews = new ArrayList<MovieReview>();
        final ResourceKey movieKey = new ResourceKey("21");
        final String reviewText = "review of movie 21";
        final String reviewerEmailAddress = "pauls@hotmail.com";
        reviews.add(new MovieReview(movieKey, reviewText, reviewerEmailAddress));

        Mockito.when(movieReviewRespository.findBy(movieKey)).thenReturn(reviews);

        MovieReviewResource movieReviewResource = new MovieReviewResource(movieReviewRespository);
        JResponse<List<MovieReviewViewModel>> reviewsResponse = movieReviewResource.getAllReviewsForMovie("21");
        List<MovieReviewViewModel> reviewEntity = reviewsResponse.getEntity();
        Assert.assertEquals(reviewText, reviewEntity.get(0).getMovieReviewText());
		Assert.assertEquals(movieKey, reviewEntity.get(0).getMovieKeyAsResource());

    }
}
