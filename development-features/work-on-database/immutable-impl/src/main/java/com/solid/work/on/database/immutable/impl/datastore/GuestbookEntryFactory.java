package com.solid.work.on.database.immutable.impl.datastore;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GuestbookEntryFactory {

    public static GuestbookEntry build(String fullName) {
        return GuestbookEntry.newInstance(fullName);
    }
}
