package com.solid.work.on.database.relations.impl.onetomany.datastore.uni;

import com.solid.work.on.database.relations.impl.onetomany.datastore.bi.BiOneToManyA;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UniOneToManyAFactory {

    public static UniOneToManyA build(String exampleCol) {
        return UniOneToManyA.newInstance(exampleCol);
    }
}
