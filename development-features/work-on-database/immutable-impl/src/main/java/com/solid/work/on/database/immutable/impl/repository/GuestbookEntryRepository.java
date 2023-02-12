package com.solid.work.on.database.immutable.impl.repository;

import com.solid.work.on.database.immutable.impl.datastore.GuestbookEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GuestbookEntryRepository extends JpaRepository<GuestbookEntry, UUID> {

    @Modifying
    @Query("UPDATE GuestbookEntry e SET e.fullName = :fullName WHERE e.id = :id")
    void updateFullNameById(@Param("fullName") String fullName, @Param("id") UUID id);

    @Modifying
    @Query(value = "UPDATE guestbook_entry e SET e.full_name = :fullName WHERE e.id = :id", nativeQuery = true)
    void updateFullNameByIdNative(@Param("fullName") String fullName, @Param("id") UUID id);
}
