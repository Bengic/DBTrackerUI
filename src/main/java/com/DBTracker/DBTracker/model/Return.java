package com.DBTracker.DBTracker.model;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class Return  {
    String returnStatus ;
    String shortInfo;
    String longInfo;

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public String getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    public String getLongInfo() {
        return longInfo;
    }

    public void setLongInfo(String longInfo) {
        this.longInfo = longInfo;
    }
}


