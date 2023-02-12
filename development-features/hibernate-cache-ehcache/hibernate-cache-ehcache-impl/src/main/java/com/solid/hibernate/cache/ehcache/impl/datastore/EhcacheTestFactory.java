package com.solid.hibernate.cache.ehcache.impl.datastore;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EhcacheTestFactory {

    public static EhcacheTest build(String name, String description) {
        //return EhcacheTest.builder().name(name).description(description).build();
        return EhcacheTest.newInstance(name, description);
    }

    public static EhcacheTest build(String name) {
        return EhcacheTest.newInstance(name, name);
    }
}
