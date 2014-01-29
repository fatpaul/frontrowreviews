package com.youngstrategieslimited.frontrow.core.movie;

public class ResourceKey {

	private String id = null;

	public ResourceKey(String id) {
		this.id = id;
	}

    // TODO: double dispatch here?
	public String appendKeyTo(String resource) {
		return resource + this.id;
	}
}
