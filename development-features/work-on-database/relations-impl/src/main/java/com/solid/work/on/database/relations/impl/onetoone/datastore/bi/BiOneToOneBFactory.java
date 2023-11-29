package com.solid.work.on.database.relations.impl.onetoone.datastore.bi;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BiOneToOneBFactory {

    public static BiOneToOneB build(String exampleCol) {
        return BiOneToOneB.newInstance(exampleCol);
    }
}
