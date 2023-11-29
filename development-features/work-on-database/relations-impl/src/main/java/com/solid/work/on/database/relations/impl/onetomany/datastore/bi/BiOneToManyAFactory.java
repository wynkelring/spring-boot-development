package com.solid.work.on.database.relations.impl.onetomany.datastore.bi;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BiOneToManyAFactory {

    public static BiOneToManyA build(String exampleCol) {
        return BiOneToManyA.newInstance(exampleCol);
    }
}
