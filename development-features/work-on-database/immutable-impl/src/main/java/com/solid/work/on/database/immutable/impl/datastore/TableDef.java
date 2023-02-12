package com.solid.work.on.database.immutable.impl.datastore;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TableDef {
    @UtilityClass
    public static class TableName {
        public static final String GUESTBOOK_ENTRY = "GUESTBOOK_ENTRY";
    }

    @UtilityClass
    public static class ColumnDef {
        @UtilityClass
        public static class EhcacheTest {
            public static final String VISIT_TIME = "VISIT_TIME";
            public static final String FULL_NAME = "FULL_NAME";
        }
    }
}
