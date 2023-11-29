package com.solid.work.on.database.relations.impl.onetoone.datastore.uni;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TableDef {
    @UtilityClass
    public static class TableName {
        public static final String UNI_ONE_TO_ONE_A = "UNI_ONE_TO_ONE_A";
        public static final String UNI_ONE_TO_ONE_B = "UNI_ONE_TO_ONE_B";
    }

    @UtilityClass
    public static class ColumnDef {
        @UtilityClass
        public static class UniOneToOneA {
            public static final String EXAMPLE_COL = "EXAMPLE_COL";
        }

        @UtilityClass
        public static class UniOneToOneB {
            public static final String EXAMPLE_COL = "EXAMPLE_COL";
        }
    }
}
