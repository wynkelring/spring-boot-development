package com.solid.work.on.database.relations.impl.onetomany.datastore.bi;

import com.solid.common.lib.datastore.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = TableDef.TableName.BI_ONE_TO_MANY_A)
@Getter
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class BiOneToManyA extends BaseEntity {

    @OneToMany(
            mappedBy = "biOneToManyA",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private final List<BiOneToManyB> biOneToManyBList = new ArrayList<>();

    @Column(name = TableDef.ColumnDef.BiOneToManyA.EXAMPLE_COL)
    private String exampleCol;

    @Builder(access = AccessLevel.PACKAGE)
    BiOneToManyA(String exampleCol) {
        super();
        this.exampleCol = exampleCol;
    }

    protected static BiOneToManyA newInstance(String exampleCol) {
        return new BiOneToManyA(exampleCol);
    }

    public BiOneToManyA update(String exampleCol) {
        this.exampleCol = exampleCol;

        return this;
    }
}
