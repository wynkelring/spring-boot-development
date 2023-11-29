package com.solid.work.on.database.relations.impl.onetomany.datastore.bi;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BiOneToManyBFactory {

    public static BiOneToManyB build(String exampleCol) {
        return BiOneToManyB.newInstance(exampleCol);
    }
}
