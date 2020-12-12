package com.DBTracker.DBTracker.model;



import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

public class BASICVIEW {
    String id;
    String user ;
    String status ;
   List< DETAILVIEW > details;

}
