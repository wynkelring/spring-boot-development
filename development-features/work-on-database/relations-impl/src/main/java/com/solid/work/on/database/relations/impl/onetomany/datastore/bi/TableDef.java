package com.solid.work.on.database.relations.impl.onetomany.datastore.bi;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TableDef {
    @UtilityClass
    public static class TableName {
        public static final String BI_ONE_TO_MANY_A = "BI_ONE_TO_MANY_A";
        public static final String BI_ONE_TO_MANY_B = "BI_ONE_TO_MANY_B";
    }

    @UtilityClass
    public static class ColumnDef {
        @UtilityClass
        public static class BiOneToManyA {
            public static final String EXAMPLE_COL = "EXAMPLE_COL";
        }

        @UtilityClass
        public static class BiOneToManyB {
            public static final String BI_ONE_TO_MANY_A_ID = "BI_ONE_TO_MANY_A_ID";
            public static final String EXAMPLE_COL = "EXAMPLE_COL";
        }
    }
}
