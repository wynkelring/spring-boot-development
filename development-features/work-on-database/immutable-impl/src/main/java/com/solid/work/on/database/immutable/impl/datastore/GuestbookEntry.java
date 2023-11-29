package com.solid.work.on.database.immutable.impl.datastore;

import com.solid.common.lib.datastore.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = TableDef.TableName.GUESTBOOK_ENTRY)
@Getter
@Immutable
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class GuestbookEntry extends BaseEntity {

    @Column(name = TableDef.ColumnDef.EhcacheTest.FULL_NAME)
    private String fullName;

    @Column(name = TableDef.ColumnDef.EhcacheTest.VISIT_TIME)
    private Long visitTime = System.currentTimeMillis();

    @Builder(access = AccessLevel.PACKAGE)
    GuestbookEntry(String fullName) {
        super();
        this.fullName = fullName;
        this.visitTime = System.currentTimeMillis();
    }

    protected static GuestbookEntry newInstance(String fullName) {
        return new GuestbookEntry(fullName);
    }

    public void update(String fullName) {
        this.fullName = fullName;
    }
}
