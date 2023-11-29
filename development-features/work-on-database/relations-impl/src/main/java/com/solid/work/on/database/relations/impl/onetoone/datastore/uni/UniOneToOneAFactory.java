package com.solid.work.on.database.relations.impl.onetoone.datastore.uni;

import com.solid.work.on.database.relations.impl.onetoone.datastore.bi.BiOneToOneA;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UniOneToOneAFactory {

    public static UniOneToOneA build(String exampleCol) {
        return UniOneToOneA.newInstance(exampleCol);
    }
}
