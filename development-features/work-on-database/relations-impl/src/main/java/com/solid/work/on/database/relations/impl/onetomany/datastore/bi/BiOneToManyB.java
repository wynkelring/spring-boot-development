package com.solid.work.on.database.relations.impl.onetomany.datastore.bi;

import com.solid.common.lib.datastore.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = TableDef.TableName.BI_ONE_TO_MANY_B)
@Getter
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class BiOneToManyB extends BaseEntity {

    @Column(name = TableDef.ColumnDef.BiOneToManyB.EXAMPLE_COL)
    private String exampleCol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = TableDef.ColumnDef.BiOneToManyB.BI_ONE_TO_MANY_A_ID)
    private BiOneToManyA biOneToManyA;

    @Builder(access = AccessLevel.PACKAGE)
    BiOneToManyB(String exampleCol) {
        super();
        this.exampleCol = exampleCol;
    }

    protected static BiOneToManyB newInstance(String exampleCol) {
        return new BiOneToManyB(exampleCol);
    }

    public BiOneToManyB update(String exampleCol) {
        this.exampleCol = exampleCol;

        return this;
    }
}
