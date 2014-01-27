package com.youngstrategieslimited.frontrow.core.movie;

import junit.framework.Assert;

import org.junit.Test;

public class MovieKeyTest {
	
	@Test
	public void movieKeyAppendsToString(){
		MovieKey movieKey = new MovieKey(new Movie("title","description"));
		String url = movieKey.appendKeyTo("baseurl:");
		Assert.assertEquals("baseurl:title",url);
	}

}
