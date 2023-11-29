package com.solid.work.on.database.relations.impl.onetomany.datastore.uni;

import com.solid.common.lib.datastore.BaseEntity;
import com.solid.work.on.database.relations.impl.onetomany.datastore.bi.TableDef;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = com.solid.work.on.database.relations.impl.onetomany.datastore.bi.TableDef.TableName.BI_ONE_TO_MANY_B)
@Getter
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class UniOneToManyB extends BaseEntity {

    @Column(name = TableDef.ColumnDef.BiOneToManyB.EXAMPLE_COL)
    private String exampleCol;

    @Builder(access = AccessLevel.PACKAGE)
    UniOneToManyB(String exampleCol) {
        super();
        this.exampleCol = exampleCol;
    }

    protected static UniOneToManyB newInstance(String exampleCol) {
        return new UniOneToManyB(exampleCol);
    }

    public UniOneToManyB update(String exampleCol) {
        this.exampleCol = exampleCol;

        return this;
    }
}
