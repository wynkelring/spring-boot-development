package com.solid.starter;

import com.solid.work.on.database.relations.impl.onetoone.datastore.bi.BiOneToOneA;
import com.solid.work.on.database.relations.impl.onetoone.datastore.bi.BiOneToOneAFactory;
import com.solid.work.on.database.relations.impl.onetoone.datastore.bi.BiOneToOneBFactory;
import com.solid.work.on.database.relations.impl.onetoone.repository.BiOneToOneARepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RelationsBiOneToOneTest implements ApplicationUnitTest {

    @Autowired
    private BiOneToOneARepository biOneToOneARepository;

    @Test
    public void testSaveEntry() {
        // given
        BiOneToOneA entry = BiOneToOneAFactory.build("exampleText");

        //when
        entry = biOneToOneARepository.save(entry);

        //then
        assertNotNull(entry.getId());
    }

    @Test
    public void testUpdateEntryGettingEntity() {
        // given
        BiOneToOneA entry = BiOneToOneAFactory.build("exampleText");
        final String exampleColTextAfterUpdate = "exampleUpdated";

        //when
        entry = biOneToOneARepository.save(entry.update(exampleColTextAfterUpdate));
        Optional<BiOneToOneA> foundEntryAfterUpdate = biOneToOneARepository.findById(entry.getId());

        //then
        assertEquals(
                exampleColTextAfterUpdate,
                foundEntryAfterUpdate.map(BiOneToOneA::getExampleCol).orElse(null)
        );
    }

    @Test
    public void testSelectWithRelation() {
        // given
        BiOneToOneA entry = BiOneToOneAFactory.build("exampleText");
        entry.updateB(BiOneToOneBFactory.build("exampleText"));

        //when
        entry = biOneToOneARepository.save(entry);

        assert entry.getId() != null;
        Optional<BiOneToOneA> foundEntryAfterUpdate = biOneToOneARepository.findById(entry.getId());

        //then
        assertNotNull(entry.getId());
        assertNotNull(entry.getBiOneToOneB().getId());
    }
}