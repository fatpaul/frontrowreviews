package com.youngstrategieslimited.frontrow.shell.adapters.movierepository;

import com.youngstrategieslimited.frontrow.core.movie.Movie;
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
    
     @Test
	public void repositoryFindsMovieReviewResourceKey(){
        
        InMemoryMovieReviewRepository inMemoryMovieReviewRepository = new InMemoryMovieReviewRepository();
        ResourceKey movieKey = new ResourceKey("1");
        String reviewerEmailAddress = "pauls@wibble.com";
        inMemoryMovieReviewRepository.save(new MovieReview(movieKey, "review1", reviewerEmailAddress));
        inMemoryMovieReviewRepository.save(new MovieReview(movieKey, "review2", reviewerEmailAddress));
        inMemoryMovieReviewRepository.save(new MovieReview(movieKey, "review3", reviewerEmailAddress));
        inMemoryMovieReviewRepository.save(new MovieReview(movieKey, "review4", reviewerEmailAddress));
        inMemoryMovieReviewRepository.save(new MovieReview(movieKey, "review5", reviewerEmailAddress));
        MovieReview movieReviewToFind = new MovieReview(movieKey, "review6", reviewerEmailAddress);
        inMemoryMovieReviewRepository.save(movieReviewToFind);
        
        // get it twice so that we know its the same key, that they are equal
        ResourceKey resourceKey1 = inMemoryMovieReviewRepository.getKey(movieReviewToFind);
        ResourceKey resourceKey2 = inMemoryMovieReviewRepository.getKey(movieReviewToFind);
        
		Assert.assertEquals(resourceKey1, resourceKey2);
    }

    @Test
	public void repositoryDoesNotFindMovieResourceKey(){
        
    InMemoryMovieReviewRepository inMemoryMovieReviewRepository = new InMemoryMovieReviewRepository();
        ResourceKey movieKey = new ResourceKey("1");
        String reviewerEmailAddress = "pauls@wibble.com";
        inMemoryMovieReviewRepository.save(new MovieReview(movieKey, "review1", reviewerEmailAddress));
        inMemoryMovieReviewRepository.save(new MovieReview(movieKey, "review2", reviewerEmailAddress));
        inMemoryMovieReviewRepository.save(new MovieReview(movieKey, "review3", reviewerEmailAddress));
        inMemoryMovieReviewRepository.save(new MovieReview(movieKey, "review4", reviewerEmailAddress));
        inMemoryMovieReviewRepository.save(new MovieReview(movieKey, "review5", reviewerEmailAddress));
        MovieReview movieReviewToFind = new MovieReview(movieKey, "review6", reviewerEmailAddress);
        ResourceKey resourceKey = inMemoryMovieReviewRepository.getKey(movieReviewToFind);
        
		Assert.assertEquals("", resourceKey.appendKeyTo(""));
    }
}
