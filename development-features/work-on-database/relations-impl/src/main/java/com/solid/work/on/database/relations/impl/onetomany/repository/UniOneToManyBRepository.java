package com.solid.work.on.database.relations.impl.onetomany.repository;

import com.solid.work.on.database.relations.impl.onetomany.datastore.uni.UniOneToManyB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UniOneToManyBRepository extends JpaRepository<UniOneToManyB, UUID> {
}
