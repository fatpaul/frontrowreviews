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
        
		Assert.assertEquals("title", movies.get(0).getTitle());
		Assert.assertEquals("description", movies.get(0).getDescription());
    }
}
