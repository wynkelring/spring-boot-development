package com.solid.work.on.database.relations.impl.onetoone.datastore.bi;

import com.solid.common.lib.datastore.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = TableDef.TableName.BI_ONE_TO_ONE_A)
@Getter
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class BiOneToOneA extends BaseEntity {

    @OneToOne(
            mappedBy = "biOneToOneA",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false)
    private BiOneToOneB biOneToOneB;

    @Column(name = TableDef.ColumnDef.BiOneToOneA.EXAMPLE_COL)
    private String exampleCol;

    @Builder(access = AccessLevel.PACKAGE)
    BiOneToOneA(String exampleCol) {
        super();
        this.exampleCol = exampleCol;
    }

    protected static BiOneToOneA newInstance(String exampleCol) {
        return new BiOneToOneA(exampleCol);
    }

    public BiOneToOneA update(String exampleCol) {
        this.exampleCol = exampleCol;

        return this;
    }

    public BiOneToOneA updateB(BiOneToOneB biOneToOneB) {
        this.biOneToOneB = biOneToOneB;
        this.biOneToOneB.setBiOneToOneA(this);

        return this;
    }
}
