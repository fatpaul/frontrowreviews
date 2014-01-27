package com.youngstrategieslimited.frontrow.rest;

import javax.ws.rs.core.Response;

import junit.framework.Assert;

import org.junit.Test;

public class MovieReviewResourceTest {

	@Test
	public void testSaveMovieReview() throws Exception {

		MovieReviewResource movieReviewResource = new MovieReviewResource();
		Response saveMovieReviewResponse = movieReviewResource
				.saveMovieReview();

		ResourceIdentifier resourceIdentifier = (ResourceIdentifier) saveMovieReviewResponse
				.getEntity();

		Assert.assertTrue(resourceIdentifier.getUrl().equals("/rest/review/1"));
	}
}
