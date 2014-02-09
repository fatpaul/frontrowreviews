package com.youngstrategieslimited.frontrow.core.movie;

import java.util.UUID;

public class ResourceKey {

	private String id = null;

	public ResourceKey(String id) {
		this.id = id;
	}

	public ResourceKey() {
		this.id = UUID.randomUUID().toString();
	}

    public String appendKeyTo(String resource) {
		return resource + this.id;
	}
    
    @Override
    public boolean equals(Object that){
        
        if(id == null && ((ResourceKey)that).id == null){
            return true;
        }
        if(id == null || ((ResourceKey)that).id == null){
            return false;
        }
        
        return id.equals(((ResourceKey)that).id);
    }
}
