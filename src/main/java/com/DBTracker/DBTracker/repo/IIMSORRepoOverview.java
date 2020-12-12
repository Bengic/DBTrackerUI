package com.DBTracker.DBTracker.repo;

import com.DBTracker.DBTracker.model.*;

import java.util.List;

public interface IIMSORRepoOverview {
    public List<DETAILVIEW> getOVerviewforALL();
    public List<DETAILVIEW> getOVerviewforID(String id);
    public List<DETAILVIEW> getOVerviewforUser(String user);
    public List<DETAILVIEW> get1DetailsAll();
    public List<DETAILVIEW> get1Details(String id);
    public List<DETAILVIEW> get2DetailsAll();
    public List<DETAILVIEW> get2Details(String id);
    public List<DETAILVIEW> get3DetailsAll();
    public List<DETAILVIEW> get3Details(String id);
    public List<DETAILVIEW> get4DetailsAll();
    public List<DETAILVIEW> get4Details(String id);
    public List<DETAILVIEW> get5DetailsAll();
    public List<DETAILVIEW> get5Details(String id);
    public List<DETAILVIEW> get6DetailsAll();
    public List<DETAILVIEW> get6Details(String id);
    public List<DETAILVIEW> get7DetailsAll();
    public List<DETAILVIEW> get7Details(String id);
    public List<DETAILVIEW> get8DetailsAll();
    public List<DETAILVIEW> get8Details(String id);


    public List<PRIMEVIEW> get1prime(String id);
    public List<PRIMEVIEW> get2prime(String id);
    public List<PRIMEVIEW> get3prime(String id);
    public List<PRIMEVIEW> get4prime(String id);
    public List<PRIMEVIEW> get5prime(String id);

}
