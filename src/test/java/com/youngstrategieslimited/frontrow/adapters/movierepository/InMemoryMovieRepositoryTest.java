package com.youngstrategieslimited.frontrow.adapters.movierepository;

import com.youngstrategieslimited.frontrow.core.movie.Movie;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

public class InMemoryMovieRepositoryTest {

    @Test
	public void movieKeyAppendsToString(){
        
        InMemoryMovieRepository inMemoryMovieRepository = new InMemoryMovieRepository();
        inMemoryMovieRepository.save(new Movie("title", "description"));
        List<Movie> movies = inMemoryMovieRepository.list();
        
		Assert.assertEquals(movies.get(0).getTitle(),"title");
		Assert.assertEquals(movies.get(0).getDescription(),"description");
    }
}
