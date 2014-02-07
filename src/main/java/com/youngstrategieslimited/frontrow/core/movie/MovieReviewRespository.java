package com.youngstrategieslimited.frontrow.core.movie;

import java.util.List;

public interface MovieReviewRespository {

	ResourceKey save(MovieReview movie);

    List<MovieReview> findBy(ResourceKey movieKey);
}
