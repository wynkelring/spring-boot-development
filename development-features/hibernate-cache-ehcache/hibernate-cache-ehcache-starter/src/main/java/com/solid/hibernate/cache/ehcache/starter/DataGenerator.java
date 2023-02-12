package com.solid.hibernate.cache.ehcache.starter;

import com.solid.hibernate.cache.ehcache.impl.datastore.EhcacheTest;
import com.solid.hibernate.cache.ehcache.impl.datastore.EhcacheTestFactory;
import com.solid.hibernate.cache.ehcache.impl.repository.EhcacheTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataGenerator {

    private final EhcacheTestRepository ehcacheTestRepository;

    private final PredefinedCacheEntries predefinedCacheEntries;

    @Value("#{'${predefined.list}'.split(',')}")
    private List<String> predefinedNames;

    @EventListener
    void onApplicationReady(ApplicationReadyEvent event) {

        List<EhcacheTest> toSave = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            toSave.add(EhcacheTestFactory.build("Name" + i, "Test data"));
        }
        for (PredefinedCacheEntries.PredefinedEhcacheEntry entry : predefinedCacheEntries.getEntries()) {
            toSave.add(EhcacheTestFactory.build(entry.getName(), entry.getDescription()));
        }
        for (String name : predefinedNames) {
            toSave.add(EhcacheTestFactory.build(name));
        }

        ehcacheTestRepository.saveAll(toSave);
    }
}
