package com.solid.work.on.database.relations.impl.onetomany.repository;

import com.solid.work.on.database.relations.impl.onetomany.datastore.uni.UniOneToManyA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UniOneToManyARepository extends JpaRepository<UniOneToManyA, UUID> {
}
