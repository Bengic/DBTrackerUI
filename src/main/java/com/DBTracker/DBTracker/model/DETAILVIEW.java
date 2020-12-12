package com.DBTracker.DBTracker.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.NUMBER;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Types.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@SqlResultSetMapping(name="PrettyResult", classes = {
        @ConstructorResult(targetClass = DETAILVIEW.class,
                columns = {@ColumnResult(name="id"), @ColumnResult(name="table"), @ColumnResult(name="col"),  @ColumnResult(name="oldVal"),  @ColumnResult(name="newVal")
                        ,  @ColumnResult(name="action")
                        ,  @ColumnResult(name="datemodified")
        })
})
@SqlResultSetMapping(name="PrettyResult1", classes = {
        @ConstructorResult(targetClass = DETAILVIEW.class,
                columns = {@ColumnResult(name="id"), @ColumnResult(name="table")
                        ,  @ColumnResult(name="action")
                        ,  @ColumnResult(name="datemodified")
                })
})

public class DETAILVIEW  implements Comparable< DETAILVIEW >  {
    @Id
    private String id;

    private String table ;

    public Long getId() {
        return Long.parseLong(id);
    }

    private  String col ;

    public DETAILVIEW(String id){ this.id = id;}

    public DETAILVIEW(String id, String table, String col, String oldVal, String newVal, String action, String datemodified) {
        this.id = id;
        this.table = table;
        this.col = col;
        this.oldVal = oldVal;
        this.newVal = newVal;
        this.action = action;
        this.datemodified = datemodified;
    }
    public DETAILVIEW(String id, String table, String action, String datemodified) {
        this.id = id;
        this.table = table;
        this.action = action;
        this.datemodified = datemodified;
    }








    private String oldVal;
    private  String newVal;
    private String action;
    private String datemodified;









    @Override
    public int compareTo(DETAILVIEW o) {
        return this.getId().compareTo( o.getId());
    }
}
