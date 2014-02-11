package com.youngstrategieslimited.frontrow.shell.adapters.movierepository;

import com.youngstrategieslimited.frontrow.shell.adapters.movierepository.InMemoryMovieReviewRepository;
import com.youngstrategieslimited.frontrow.core.movie.MovieReview;
import com.youngstrategieslimited.frontrow.core.movie.ResourceKey;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

public class InMemoryMovieReviewRepositoryTest {

    @Test
    public void movieKeyAppendsToString() {

        InMemoryMovieReviewRepository inMemoryMovieReviewRepository = new InMemoryMovieReviewRepository();
        ResourceKey movieKey = new ResourceKey("1");
        String reviewerEmailAddress = "pauls@wibble.com";
        inMemoryMovieReviewRepository.save(new MovieReview(movieKey, "review",reviewerEmailAddress));
        List<MovieReview> moviesReview = inMemoryMovieReviewRepository.findBy(movieKey);

        Assert.assertTrue(moviesReview.size()==1);
        Assert.assertEquals(movieKey, moviesReview.get(0).getMovieKey());
        Assert.assertEquals("review", moviesReview.get(0).getMovieReviewText());
    }
}