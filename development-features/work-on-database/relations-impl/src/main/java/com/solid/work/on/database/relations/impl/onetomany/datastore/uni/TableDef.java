package com.solid.work.on.database.relations.impl.onetomany.datastore.uni;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TableDef {
    @UtilityClass
    public static class TableName {
        public static final String UNI_ONE_TO_MANY_A = "UNI_ONE_TO_MANY_A";
        public static final String UNI_ONE_TO_MANY_B = "UNI_ONE_TO_MANY_B";
    }

    @UtilityClass
    public static class ColumnDef {
        @UtilityClass
        public static class UniOneToManyA {
            public static final String EXAMPLE_COL = "EXAMPLE_COL";
        }

        @UtilityClass
        public static class UniOneToManyB {
            public static final String UNI_ONE_TO_MANY_A_ID = "UNI_ONE_TO_MANY_A_ID";
            public static final String EXAMPLE_COL = "EXAMPLE_COL";
        }
    }
}
