package com.solid.starter;

import com.solid.work.on.database.immutable.impl.datastore.GuestbookEntry;
import com.solid.work.on.database.immutable.impl.datastore.GuestbookEntryFactory;
import com.solid.work.on.database.immutable.impl.repository.GuestbookEntryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ImmutableImplGuestEntryTest implements ApplicationUnitTest {

    @Autowired
    private GuestbookEntryRepository guestbookEntryRepository;

    @Test
    public void testSaveEntry() {
        // given
        GuestbookEntry entry = GuestbookEntryFactory.build("Łukasz Bielak");

        //when
        entry = guestbookEntryRepository.save(entry);

        //then
        assertNotNull(entry.getId());
    }

    @Test
    public void testUpdateEntryGettingEntity() {
        System.out.println("lllllllllllll");
        // given
        GuestbookEntry entry = GuestbookEntryFactory.build("Łukasz Bielaz");
        entry = guestbookEntryRepository.saveAndFlush(entry);
        final String newFullName = "Łukasz Bielaj";

        //when
        assert entry.getId() != null;
        entry.update(newFullName);
        guestbookEntryRepository.saveAndFlush(entry);
        Optional<GuestbookEntry> foundEntryAfterUpdate = guestbookEntryRepository.findById(entry.getId());

        //then
        assertNotEquals(
                newFullName,
                foundEntryAfterUpdate.map(GuestbookEntry::getFullName).orElse(null)
        );
    }

    @Test
    public void testUpdateEntryJPQL() {
        // given
        GuestbookEntry entry = GuestbookEntryFactory.build("Łukasz Bielak");
        entry = guestbookEntryRepository.save(entry);
        final String newFullName = "Łukasz Bielaj";
        boolean exceptionThrown = false;

        //when
        try {
            guestbookEntryRepository.updateFullNameById(newFullName, entry.getId());
        } catch (InvalidDataAccessApiUsageException e) {
            exceptionThrown = true;
        } catch (Exception ignored) {
        }

        //then
        assertTrue(exceptionThrown);
    }

    @Test
    public void testUpdateEntryNative() {
        // given
        GuestbookEntry entry = GuestbookEntryFactory.build("Łukasz Bielak");
        entry = guestbookEntryRepository.save(entry);
        final String newFullName = "Łukasz Bielaj";
        boolean exceptionThrown = false;

        //when
        try {
            guestbookEntryRepository.updateFullNameByIdNative(newFullName, entry.getId());
        } catch (InvalidDataAccessApiUsageException e) {
            exceptionThrown = true;
            System.out.println(e.getMessage());
        } catch (Exception ignored) {
        }

        //then
        assertTrue(exceptionThrown);
    }
}