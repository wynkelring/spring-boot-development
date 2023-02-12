package com.solid.hibernate.cache.ehcache.impl.datastore;


import com.solid.common.lib.datastore.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Table(name = TableDef.TableName.EHCACHE_TEST)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Getter
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class EhcacheTest extends BaseEntity {
    @Column(name = TableDef.ColumnDef.EhcacheTest.NAME)
    private String name;
    @Column(name = TableDef.ColumnDef.EhcacheTest.DESCRIPTION)
    private String description;

    @Builder(access = AccessLevel.PACKAGE)
    EhcacheTest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    protected static EhcacheTest newInstance(String name, String description) {
        return new EhcacheTest(name, description);
    }
}
