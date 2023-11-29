package com.solid.common.lib.datastore;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter(AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseEntity implements Persistable<UUID>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = TableDef.ColumnDef.BaseEntity.ID,
            unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(name = TableDef.ColumnDef.BaseEntity.CREATION_TIME,
            nullable = false, updatable = false)
    private Long creationTime;

    @Column(name = TableDef.ColumnDef.BaseEntity.UPDATE_TIME,
            nullable = false)
    private Long updateTime;

    @PrePersist
    protected void onCreate() {
        creationTime = updateTime = System.currentTimeMillis();
    }

    @PreUpdate
    protected void onUpdate() {
        updateTime = System.currentTimeMillis();
    }

    @Builder(access = AccessLevel.PACKAGE)
    protected BaseEntity() {
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    @Transient
    public boolean isNew() {
        return this.id == null;
    }
}
