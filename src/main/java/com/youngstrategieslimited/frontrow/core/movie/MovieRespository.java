package com.youngstrategieslimited.frontrow.core.movie;

import java.util.List;

public interface MovieRespository {

	ResourceKey save(Movie movie);

	List<Movie> list();
}
