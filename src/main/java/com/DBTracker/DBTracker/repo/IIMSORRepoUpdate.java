package com.DBTracker.DBTracker.repo;

import com.DBTracker.DBTracker.model.*;

public interface IIMSORRepoUpdate {

    public Return clean(String user);
    public Return cleanAll();
    public Return AddMe(String user);
    public String RemoveMe(String user);
}
