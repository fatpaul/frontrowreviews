package com.youngstrategieslimited.frontrow.core.movie;

import java.util.List;

public interface MovieRespository {

	MovieKey save(Movie movie);

	List<Movie> list();
}
