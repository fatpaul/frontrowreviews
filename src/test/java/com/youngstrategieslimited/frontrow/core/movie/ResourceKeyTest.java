package com.youngstrategieslimited.frontrow.core.movie;

import junit.framework.Assert;

import org.junit.Test;

public class ResourceKeyTest {

    @Test
    public void defaultResourceKeyHasGeneratedKey() {
        ResourceKey key = new ResourceKey();
        Assert.assertNotSame("", key.appendKeyTo(""));
    }

    @Test
    public void resourceKeyHasPassedKey() {
        ResourceKey key = new ResourceKey("12");
        Assert.assertNotSame("12", key.appendKeyTo(""));
    }

    @Test
    public void resourceKeysAreEqual() {
        ResourceKey key1 = new ResourceKey("12");
        ResourceKey key2 = new ResourceKey("12");
        Assert.assertEquals(key1, key2);
    }
    
    @Test
    public void nullResourceKeysAreEqual() {
        ResourceKey key1 = new ResourceKey(null);
        ResourceKey key2 = new ResourceKey(null);
        Assert.assertEquals(key1, key2);
    }
    
    @Test
    public void nullAndPopulatedAreUnEqual() {
        ResourceKey key1 = new ResourceKey(null);
        ResourceKey key2 = new ResourceKey("");
        Assert.assertFalse(key1.equals(key2));
        Assert.assertFalse(key2.equals(key1));
    }
}
