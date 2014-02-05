package com.youngstrategieslimited.frontrow.adapters.movierepository;

import com.youngstrategieslimited.frontrow.core.movie.MovieReview;
import com.youngstrategieslimited.frontrow.core.movie.ResourceKey;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

public class InMemoryMovieReviewRepositoryTest {

    @Test
	public void movieKeyAppendsToString(){
        
        InMemoryMovieReviewRepository inMemoryMovieReviewRepository = new InMemoryMovieReviewRepository();
        ResourceKey movieKey = new ResourceKey("1");
        inMemoryMovieReviewRepository.save(new MovieReview(movieKey, "review"));
        List<MovieReview> moviesReview = inMemoryMovieReviewRepository.list();
        
		//Assert.assertEquals(moviesReview.get(0).getTitle(),"title");
		//Assert.assertEquals(moviesReview.get(0).getDescription(),"description");
    }
}
