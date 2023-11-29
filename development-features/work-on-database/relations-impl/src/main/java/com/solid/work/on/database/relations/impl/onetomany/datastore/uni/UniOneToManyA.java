package com.solid.work.on.database.relations.impl.onetomany.datastore.uni;

import com.solid.common.lib.datastore.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = TableDef.TableName.UNI_ONE_TO_MANY_A)
@Getter
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class UniOneToManyA extends BaseEntity {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = TableDef.ColumnDef.UniOneToManyB.UNI_ONE_TO_MANY_A_ID)
    private final List<UniOneToManyB> uniOneToManyBList = new ArrayList<>();

    @Column(name = TableDef.ColumnDef.UniOneToManyA.EXAMPLE_COL)
    private String exampleCol;

    @Builder(access = AccessLevel.PACKAGE)
    UniOneToManyA(String exampleCol) {
        super();
        this.exampleCol = exampleCol;
    }

    protected static UniOneToManyA newInstance(String exampleCol) {
        return new UniOneToManyA(exampleCol);
    }

    public UniOneToManyA update(String exampleCol) {
        this.exampleCol = exampleCol;

        return this;
    }
}
