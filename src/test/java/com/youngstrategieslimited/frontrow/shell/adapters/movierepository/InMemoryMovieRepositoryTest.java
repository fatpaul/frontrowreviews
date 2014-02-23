package com.youngstrategieslimited.frontrow.shell.adapters.movierepository;

import com.youngstrategieslimited.frontrow.core.movie.Movie;
import com.youngstrategieslimited.frontrow.core.movie.ResourceKey;
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

    @Test
	public void repositoryFindsMovieResourceKey(){
        
        InMemoryMovieRepository inMemoryMovieRepository = new InMemoryMovieRepository();
        inMemoryMovieRepository.save(new Movie("title1", "description"));
        inMemoryMovieRepository.save(new Movie("title2", "description"));
        inMemoryMovieRepository.save(new Movie("title3", "description"));
        inMemoryMovieRepository.save(new Movie("title4", "description"));
        inMemoryMovieRepository.save(new Movie("title5", "description"));
        Movie movieToFind = new Movie("title6", "description");
        inMemoryMovieRepository.save(movieToFind);
        
        // get it twice so that we know its the same key, that they are equal
        ResourceKey resourceKey1 = inMemoryMovieRepository.getKey(movieToFind);
        ResourceKey resourceKey2 = inMemoryMovieRepository.getKey(movieToFind);
        
		Assert.assertEquals(resourceKey1, resourceKey2);
    }

    @Test
	public void repositoryDoesNotFindMovieResourceKey(){
        
        InMemoryMovieRepository inMemoryMovieRepository = new InMemoryMovieRepository();
        inMemoryMovieRepository.save(new Movie("title1", "description"));
        inMemoryMovieRepository.save(new Movie("title2", "description"));
        inMemoryMovieRepository.save(new Movie("title3", "description"));
        inMemoryMovieRepository.save(new Movie("title4", "description"));
        inMemoryMovieRepository.save(new Movie("title5", "description"));
        Movie movieToFind = new Movie("title6", "description");
        ResourceKey resourceKey = inMemoryMovieRepository.getKey(movieToFind);
        
		Assert.assertEquals("", resourceKey.appendKeyTo(""));
    }
}
