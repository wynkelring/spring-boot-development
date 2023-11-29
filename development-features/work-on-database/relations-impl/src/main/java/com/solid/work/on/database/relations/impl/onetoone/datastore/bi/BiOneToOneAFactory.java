package com.solid.work.on.database.relations.impl.onetoone.datastore.bi;

import com.solid.work.on.database.relations.impl.onetomany.datastore.bi.BiOneToManyA;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BiOneToOneAFactory {

    public static BiOneToOneA build(String exampleCol) {
        return BiOneToOneA.newInstance(exampleCol);
    }
}
