package com.solid.work.on.database.relations.impl.onetoone.datastore.uni;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UniOneToOneBFactory {

    public static UniOneToOneB build(String exampleCol) {
        return UniOneToOneB.newInstance(exampleCol);
    }
}
