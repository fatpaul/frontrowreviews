package com.youngstrategieslimited.frontrow.core.movie;

import java.util.List;

public interface MovieRespository {

	void save(Movie movie);

	List<Movie> list();
    
    ResourceKey getKey(Movie movie);
}
