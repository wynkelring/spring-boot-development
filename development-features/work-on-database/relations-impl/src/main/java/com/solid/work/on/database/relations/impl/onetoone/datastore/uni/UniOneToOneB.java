package com.solid.work.on.database.relations.impl.onetoone.datastore.uni;

import com.solid.common.lib.datastore.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = TableDef.TableName.UNI_ONE_TO_ONE_B)
@Getter
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class UniOneToOneB extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private UniOneToOneA uniOneToOneA;

    @Column(name = TableDef.ColumnDef.UniOneToOneB.EXAMPLE_COL)
    private String exampleCol;

    @Builder(access = AccessLevel.PACKAGE)
    UniOneToOneB(String exampleCol) {
        super();
        this.exampleCol = exampleCol;
    }

    protected static UniOneToOneB newInstance(String exampleCol) {
        return new UniOneToOneB(exampleCol);
    }

    public UniOneToOneB update(String exampleCol) {
        this.exampleCol = exampleCol;

        return this;
    }
}
