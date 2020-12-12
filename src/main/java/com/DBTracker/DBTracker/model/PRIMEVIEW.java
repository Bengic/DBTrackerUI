package com.DBTracker.DBTracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@SqlResultSetMapping(name="PrettyPrime", classes = {
        @ConstructorResult(targetClass = PRIMEVIEW.class,
                columns = {@ColumnResult(name="val")

        })
})
public class PRIMEVIEW  {

    @Id
    private String id;
    private String val;
    public PRIMEVIEW(String val) {
        this.val = val;

    }

}
