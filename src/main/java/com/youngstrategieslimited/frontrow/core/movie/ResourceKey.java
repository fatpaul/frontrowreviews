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
        
        if(id == null && that == null){
            return true;
        }
        if(id == null || that == null){
            return false;
        }
        
        String thatId = ((ResourceKey)that).appendKeyTo("");
        return id.equals(thatId);
    }
}
