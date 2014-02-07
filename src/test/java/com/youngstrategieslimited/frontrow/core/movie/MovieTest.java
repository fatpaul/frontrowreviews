package com.youngstrategieslimited.frontrow.core.movie;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MovieTest {
	
	@Mock
	private MovieRespository movieRespository;
	
	@Test
	public void saveMovieCallsRepository(){
		Movie movie = new Movie("movie title","description of movie");
		movieRespository.save(movie);
		Mockito.verify(movieRespository).save(movie);
	}

	@Test
	public void newlyCreatedMovieHasGeneratedKey(){
		Movie movie = new Movie("movie title","description of movie");
		Assert.assertNotNull(movie.getKey());
	}

    @Test
	public void movieCanBeCreatedWithUserDefinedKey(){
        final ResourceKey resourceKey = new ResourceKey("1");
		Movie movie = new Movie(resourceKey, "movie title","description of movie");
        movie.save(movieRespository);
		Assert.assertEquals(resourceKey, movie.getKey());
	}
}
