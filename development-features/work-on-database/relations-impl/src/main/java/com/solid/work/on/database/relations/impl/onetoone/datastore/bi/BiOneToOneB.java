package com.solid.work.on.database.relations.impl.onetoone.datastore.bi;

import com.solid.common.lib.datastore.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = TableDef.TableName.BI_ONE_TO_ONE_B)
@Getter
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class BiOneToOneB extends BaseEntity {

    @Column(name = TableDef.ColumnDef.BiOneToOneB.EXAMPLE_COL)
    private String exampleCol;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = TableDef.ColumnDef.BiOneToOneB.BI_ONE_TO_ONE_A_ID)
    private BiOneToOneA biOneToOneA;

    @Builder(access = AccessLevel.PACKAGE)
    BiOneToOneB(String exampleCol) {
        super();
        this.exampleCol = exampleCol;
    }

    protected static BiOneToOneB newInstance(String exampleCol) {
        return new BiOneToOneB(exampleCol);
    }

    public BiOneToOneB update(String exampleCol) {
        this.exampleCol = exampleCol;

        return this;
    }
}
