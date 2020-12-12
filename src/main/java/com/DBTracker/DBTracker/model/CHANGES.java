package com.DBTracker.DBTracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class CHANGES {
    private String ID;
    private String   IIMSORACT;
    private String IIMSORCOL;
    private Date DATETIME;
}
