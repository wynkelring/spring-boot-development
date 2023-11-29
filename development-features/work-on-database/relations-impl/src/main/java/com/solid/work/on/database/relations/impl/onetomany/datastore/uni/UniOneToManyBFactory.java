package com.solid.work.on.database.relations.impl.onetomany.datastore.uni;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UniOneToManyBFactory {

    public static UniOneToManyB build(String exampleCol) {
        return UniOneToManyB.newInstance(exampleCol);
    }
}
