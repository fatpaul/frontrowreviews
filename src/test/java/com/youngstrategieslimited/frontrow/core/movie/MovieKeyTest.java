package com.youngstrategieslimited.frontrow.core.movie;

import junit.framework.Assert;

import org.junit.Test;

public class MovieKeyTest {
	
	@Test
	public void movieKeyAppendsToString(){
		ResourceKey movieKey = new ResourceKey("id");
		String url = movieKey.appendKeyTo("baseurl:");
		Assert.assertEquals("baseurl:id",url);
    }
}
