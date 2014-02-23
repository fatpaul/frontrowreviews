package com.youngstrategieslimited.frontrow.core.movie;

import java.util.List;

public interface MovieReviewRespository {

	void save(MovieReview movie);

    List<MovieReview> findBy(ResourceKey movieKey);

    ResourceKey getKey(MovieReview movie);
}
