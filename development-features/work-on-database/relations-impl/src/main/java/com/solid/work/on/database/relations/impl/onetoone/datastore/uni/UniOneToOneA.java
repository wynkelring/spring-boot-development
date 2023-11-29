package com.solid.work.on.database.relations.impl.onetoone.datastore.uni;

import com.solid.common.lib.datastore.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = TableDef.TableName.UNI_ONE_TO_ONE_A)
@Getter
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class UniOneToOneA extends BaseEntity {

    @OneToOne(
            mappedBy = "uniOneToOneA",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false)
    private UniOneToOneB uniOneToOneB;

    @Column(name = TableDef.ColumnDef.UniOneToOneA.EXAMPLE_COL)
    private String exampleCol;

    @Builder(access = AccessLevel.PACKAGE)
    UniOneToOneA(String exampleCol) {
        super();
        this.exampleCol = exampleCol;
    }

    protected static UniOneToOneA newInstance(String exampleCol) {
        return new UniOneToOneA(exampleCol);
    }

    public UniOneToOneA update(String exampleCol) {
        this.exampleCol = exampleCol;

        return this;
    }
}
