package com.solid.common.lib.datastore;

import lombok.experimental.UtilityClass;

public class TableDef {

    @UtilityClass
    public static class ColumnDef {
        @UtilityClass
        public static class BaseEntity {
            public static final String ID = "ID";
            public static final String CREATION_TIME = "CREATION_TIME";
            public static final String UPDATE_TIME = "UPDATE_TIME";
        }
    }
}
