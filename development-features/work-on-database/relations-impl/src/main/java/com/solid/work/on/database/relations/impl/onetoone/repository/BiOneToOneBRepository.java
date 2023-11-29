package com.solid.work.on.database.relations.impl.onetoone.repository;

import com.solid.work.on.database.relations.impl.onetoone.datastore.bi.BiOneToOneB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BiOneToOneBRepository extends JpaRepository<BiOneToOneB, UUID> {
}
