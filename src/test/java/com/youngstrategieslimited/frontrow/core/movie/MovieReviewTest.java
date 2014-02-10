package com.youngstrategieslimited.frontrow.core.movie;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MovieReviewTest {

    @Mock
    private MovieReviewRespository movieReviewRespository;

    @Test
    public void saveMovieReviewCallsRepository() {
        Movie movie = new Movie("movie title", "description of movie");
        String reviewerEmailAddress = "pauls@address.com";
        MovieReview movieReview = new MovieReview(movie.getKey(), "movie review", reviewerEmailAddress);
        movieReviewRespository.save(movieReview);
        Mockito.verify(movieReviewRespository).save(movieReview);
    }

    @Test
    public void newlyCreatedMovieReviewHasGeneratedKey() {
        Movie movie = new Movie("movie title", "description of movie");
        String reviewerEmailAddress = "pauls@address.com";
        MovieReview movieReview = new MovieReview(movie.getKey(), "movie review", reviewerEmailAddress);
        Assert.assertNotNull(movieReview.getKey());
    }

    @Test
    public void movieReviewCanBeCreatedWithUserDefinedKey() {
        final ResourceKey movieKey = new ResourceKey("21");
        final ResourceKey resourceKey = new ResourceKey("221");
        String reviewerEmailAddress = "pauls@address.com";
        MovieReview movieReview = new MovieReview(resourceKey, movieKey, "movie review", reviewerEmailAddress);
        Assert.assertEquals(resourceKey, movieReview.getKey());
    }

    @Test
    public void movieReviewStoresData() {
        final ResourceKey movieKey = new ResourceKey("21");
        final ResourceKey resourceKey = new ResourceKey("221");
        String reviewerEmailAddress = "pauls@address.com";
        final String movieReviewText = "movie review";
        MovieReview movieReview = new MovieReview(resourceKey, movieKey, movieReviewText, reviewerEmailAddress);
        Assert.assertEquals(reviewerEmailAddress, movieReview.getReviewerEmailAddress());
        Assert.assertEquals(movieReviewText, movieReview.getMovieReviewText());
    }
}
