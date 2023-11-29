package com.solid.work.on.database.relations.impl.onetoone.datastore.bi;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TableDef {
    @UtilityClass
    public static class TableName {
        public static final String BI_ONE_TO_ONE_A = "BI_ONE_TO_ONE_A";
        public static final String BI_ONE_TO_ONE_B = "BI_ONE_TO_ONE_B";
    }

    @UtilityClass
    public static class ColumnDef {
        @UtilityClass
        public static class BiOneToOneA {
            public static final String EXAMPLE_COL = "EXAMPLE_COL";
        }

        @UtilityClass
        public static class BiOneToOneB {
            public static final String EXAMPLE_COL = "EXAMPLE_COL";
            public static final String BI_ONE_TO_ONE_A_ID = "BI_ONE_TO_ONE_A_ID";
        }
    }
}
