package com.solid.hibernate.cache.ehcache.impl.repository;

import com.solid.hibernate.cache.ehcache.impl.datastore.EhcacheTest;
import jakarta.persistence.QueryHint;
import org.hibernate.jpa.HibernateHints;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface EhcacheTestRepository extends CrudRepository<EhcacheTest, UUID> {

    @QueryHints({@QueryHint(name = HibernateHints.HINT_CACHEABLE, value = "true")})
    List<EhcacheTest> findAll();

}
