package com.solid.starter;

import com.solid.work.on.database.immutable.impl.datastore.GuestbookEntry;
import com.solid.work.on.database.immutable.impl.datastore.GuestbookEntryFactory;
import com.solid.work.on.database.immutable.impl.repository.GuestbookEntryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class ImmutableImplGuestEntryTest {

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
        // given
        GuestbookEntry entry = GuestbookEntryFactory.build("Łukasz Bielak");
        entry = guestbookEntryRepository.save(entry);
        final String newFullName = "Łukasz Bielaj";

        //when
        entry = guestbookEntryRepository.save(entry.update(newFullName));

        assert entry.getId() != null;
        Optional<GuestbookEntry> foundEntryAfterUpdate = guestbookEntryRepository.findById(entry.getId());

        System.out.println(newFullName);
        System.out.println(foundEntryAfterUpdate.map(GuestbookEntry::getFullName).orElse(null));
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