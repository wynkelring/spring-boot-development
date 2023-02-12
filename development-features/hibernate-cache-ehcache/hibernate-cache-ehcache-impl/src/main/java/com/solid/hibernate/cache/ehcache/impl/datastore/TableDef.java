package com.solid.hibernate.cache.ehcache.impl.datastore;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TableDef {
    @UtilityClass
    public static class TableName {
        public static final String EHCACHE_TEST = "EHCACHE_TEST";
    }

    @UtilityClass
    public static class ColumnDef {
        @UtilityClass
        public static class EhcacheTest {
            public static final String NAME = "NAME";
            public static final String DESCRIPTION = "DESCRIPTION";
        }
    }
}
