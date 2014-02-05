package com.youngstrategieslimited.frontrow.rest;

import com.youngstrategieslimited.frontrow.core.movie.MovieReview;
import com.youngstrategieslimited.frontrow.core.movie.MovieReviewRespository;
import com.youngstrategieslimited.frontrow.core.movie.ResourceKey;
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
        MovieReviewViewModel review = new MovieReviewViewModel(movieKey, movieReviewText);

        Response saveMovieReviewResponse = movieReviewResource
                .saveMovieReview(review);

        Mockito.verify(movieReviewRespository).save(Mockito.any(MovieReview.class));

        ResourceIdentifier resourceIdentifier = (ResourceIdentifier) saveMovieReviewResponse
                .getEntity();

        Assert.assertTrue(resourceIdentifier.getUrl().equals("/rest/review/1"));
    }
}
