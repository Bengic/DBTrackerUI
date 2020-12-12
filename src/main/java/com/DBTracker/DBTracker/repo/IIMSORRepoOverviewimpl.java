package com.DBTracker.DBTracker.repo;

import com.DBTracker.DBTracker.model.*;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


@Repository
public class IIMSORRepoOverviewimpl implements IIMSORRepoOverview {
    @PersistenceContext
    protected  EntityManager entityManager;


    public List<DETAILVIEW> getOVerviewforALL(){
        String sqlman = "select to_char(P.id) \"id\", P.IIMSORCOL \"table\"  , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from  IIMSOR P ";

        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult1");

        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }


    public List<DETAILVIEW> getOVerviewforID(String id){
        String sqlman = "select to_char(P.id) \"id\", P.IIMSORCOL \"table\" , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from IIMSOR P where to_char(P.id ) = ?1";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult1");
        query.setParameter(1,id);
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }

    public List<DETAILVIEW> getOVerviewforUser(String user){
        String sqlman = "select to_char(P.id) \"id\", P.IIMSORCOL \"table\" , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from IIMSOR P where to_char(P.iimsorhn ) = ?1";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult1");
        query.setParameter(1,user);
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }


    public List<DETAILVIEW> get1DetailsAll(){
        String sqlman = "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",COLNAME \"col\", C.OLDVAL \"oldVal\", C.NEWVAL \"newVal\" , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from IIMSOR_VARCHARVALUES C, IIMSOR P where C.id = P.id";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult");

        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }

    public List<DETAILVIEW> get1Details(String id){
        String sqlman = "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",COLNAME \"col\", C.OLDVAL \"oldVal\", C.NEWVAL \"newVal\" , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from IIMSOR_VARCHARVALUES C, IIMSOR P where C.id = P.id and P.id = ?1 ";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult");
        query.setParameter(1,id);
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }



    public List<DETAILVIEW> get2DetailsAll(){
        String sqlman = "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",C.COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\"  , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from IIMSOR_TIMESTAMPVALUES C, IIMSOR P  where C.id = P.id";
                Query query = entityManager.createNativeQuery(sqlman,"PrettyResult");
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }

    public List<DETAILVIEW> get2Details(String id){
        String sqlman = "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",C.COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\"  , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from IIMSOR_TIMESTAMPVALUES C, IIMSOR P  where C.id = P.id and P.id = ?1 ";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult");
        query.setParameter(1,id);
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }


    public List<DETAILVIEW> get3DetailsAll(){
        String sqlman = "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",C.COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\"  , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from IIMSOR_NVARCHARVALUES C, IIMSOR P where C.id = P.id";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult");
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }

    public List<DETAILVIEW> get3Details(String id){
        String sqlman = "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",C.COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\"  , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from IIMSOR_NVARCHARVALUES C, IIMSOR P  where C.id = P.id and P.id = ?1 ";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult");
        query.setParameter(1,id);
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }

    public List<DETAILVIEW> get4DetailsAll(){
        String sqlman = "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",C.COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\"  , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from iimsor_numbervalues C, IIMSOR P where C.id = P.id";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult");
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }

    public List<DETAILVIEW> get4Details(String id){
        String sqlman = "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",C.COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\"  , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from iimsor_numbervalues C, IIMSOR P  where C.id = P.id and P.id = ?1 ";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult");
        query.setParameter(1,id);
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }

    public List<DETAILVIEW> get5DetailsAll(){
        String sqlman = "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",C.COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\"  , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from IIMSOR_NCLOBVALUES C, IIMSOR P where C.id = P.id";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult");
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }

    public List<DETAILVIEW> get5Details(String id){
        String sqlman = "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",C.COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\"  , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from IIMSOR_NCLOBVALUES C, IIMSOR P  where C.id = P.id and P.id = ?1 ";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult");
        query.setParameter(1,id);
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }

    public List<DETAILVIEW> get6DetailsAll(){
        String sqlman = "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",C.COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\"  , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from IIMSOR_DATEVALUES  C, IIMSOR P where C.id = P.id";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult");
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }

    public List<DETAILVIEW> get6Details(String id){
        String sqlman = "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",C.COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\"  , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from IIMSOR_DATEVALUES C, IIMSOR P  where C.id = P.id and P.id = ?1 ";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult");
        query.setParameter(1,id);
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }

    public List<DETAILVIEW> get7DetailsAll(){
        String sqlman = "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",C.COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\"  , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from IIMSOR_CLOBVALUES C , IIMSOR P where C.id = P.id";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult");
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }

    public List<DETAILVIEW> get7Details(String id){
        String sqlman = "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",C.COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\"  , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from IIMSOR_CLOBVALUES C, IIMSOR P   where C.id = P.id and P.id = ?1 ";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult");
        query.setParameter(1,id);
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }

    public List<DETAILVIEW> get8DetailsAll(){
        String sqlman = "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",C.COLNAME \"col\", 'Large Val' \"oldVal\", 'Large Val' \"newVal\" , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from IIMSOR_BLOBVALUES  C, IIMSOR P where C.id = P.id";
                Query query = entityManager.createNativeQuery(sqlman,"PrettyResult");
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }

    public List<DETAILVIEW> get8Details(String id){
        String sqlman = "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",C.COLNAME \"col\", 'Large Val' \"oldVal\", 'Large Val' \"newVal\" , P.IIMSORACT  \"action\", to_char(P.datetime, 'dd-mm-yyyy hh24:mi:ss')  \"datemodified\" from IIMSOR_BLOBVALUES  C, IIMSOR P  where C.id = P.id and P.id = ?1 ";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyResult");
        query.setParameter(1,id);
        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }

    public List<PRIMEVIEW> get1prime(String id){
        String sqlman =  "select colname||' = '''||NVL(OLDVAL, NEWVAL) ||'''' as val from iimsor_primevarcharvalues  where id = ?1 ";
                Query query = entityManager.createNativeQuery(sqlman,"PrettyPrime");
        query.setParameter(1,id);
        @SuppressWarnings("unchecked")
        List<PRIMEVIEW> results = query.getResultList();
        return results;
    }

    public List<PRIMEVIEW> get2prime(String id){
        String sqlman ="select colname||' = '''||NVL(OLDVAL, NEWVAL) ||'''' as val from iimsor_primenvarcharvalues  where id = ?1 ";
                Query query = entityManager.createNativeQuery(sqlman,"PrettyPrime");
        query.setParameter(1,id);
        @SuppressWarnings("unchecked")
        List<PRIMEVIEW> results = query.getResultList();
        return results;
    }

    public List<PRIMEVIEW> get3prime(String id){
        String sqlman = "select colname||' = '''||NVL(OLDVAL, NEWVAL) ||'''' as val from iimsor_primedatevalues  where id = ?1 ";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyPrime");
        query.setParameter(1,id);
        @SuppressWarnings("unchecked")
        List<PRIMEVIEW> results = query.getResultList();
        return results;
    }

    public List<PRIMEVIEW> get4prime(String id){
        String sqlman = "select colname||' = '''||NVL(OLDVAL, NEWVAL) ||'''' as val from iimsor_primetimestampvalues  where id = ?1 ";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyPrime");
        query.setParameter(1,id);
        @SuppressWarnings("unchecked")
        List<PRIMEVIEW> results = query.getResultList();
        return results;
    }

    public List<PRIMEVIEW> get5prime(String id){
        String sqlman = "select colname||' = '||NVL(OLDVAL, NEWVAL) as val from iimsor_primenumbervalues  where id = ?1 ";
        Query query = entityManager.createNativeQuery(sqlman,"PrettyPrime");
        query.setParameter(1,id);
        @SuppressWarnings("unchecked")
        List<PRIMEVIEW> results = query.getResultList();
        return results;
    }


    /* @Override

    public List<DETAILVIEW> getprettyglobal(){
        Query query = entityManager.createNativeQuery("select to_char(C.id) \"id\", C.IIMSORTAB \"table\",COLNAME \"col\", OLDVAL \"oldVal\", NEWVAL \"newVal\" from IIMSOR_VARCHARVALUES union all\n" +
                "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\" from IIMSOR_TIMESTAMPVALUES union all\n" +
                "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\" from IIMSOR_NVARCHARVALUES union all\n" +
                "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\" from iimsor_numbervalues union all\n" +
                "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\" from IIMSOR_NCLOBVALUES union all\n" +
                "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\" from IIMSOR_DATEVALUES union all\n" +
                "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",COLNAME \"col\", to_char(C.OLDVAL) \"oldVal\", to_char(C.NEWVAL) \"newVal\" from IIMSOR_CLOBVALUES union all\n" +
                "select to_char(C.id) \"id\", C.IIMSORTAB \"table\",COLNAME \"col\", 'Large Val' \"oldVal\", 'Large Val' \"newVal\" from IIMSOR_BLOBVALUES","PrettyResult");

        @SuppressWarnings("unchecked")
        List<DETAILVIEW> results = query.getResultList();
        return results;
    }




    @Override
    public List<CHANGES> getIIMSOR(String hhh){
        Query query = entityManager.createNativeQuery("Select ID,IIMSORACT,IIMSORCOL,DATETIME from IIMSOR where iimsorhn = ?1 order by ID desc");
        query.setParameter(1,hhh);
        return query.getResultList();
    }

    @Override
    public List<DETAILVIEW> getDetails1(String id) {
        Query query = entityManager.createNativeQuery("select C.IIMSORTAB \"table\",COLNAME \"col\", OLDVAL \"oldVal\", NEWVAL \"newVal\" from IIMSOR_BLOBVALUES  where id = ?1");
        query.setParameter(1,id);
        return query.getResultList();
    }
    @Override
    public List<DETAILVIEW> getDetails2(String id) {
        Query query = entityManager.createNativeQuery("select C.IIMSORTAB \"table\",COLNAME \"col\", OLDVAL \"oldVal\", NEWVAL \"newVal\" from IIMSOR_CLOBVALUES  where id = ?1");
        query.setParameter(1,id);
        return query.getResultList();
    }
    @Override
    public List<DETAILVIEW> getDetails3(String id) {
        Query query = entityManager.createNativeQuery("select C.IIMSORTAB \"table\",COLNAME \"col\", OLDVAL \"oldVal\", NEWVAL \"newVal\" from IIMSOR_DATEVALUES  where id = ?1");
        query.setParameter(1,id);
        return query.getResultList();
    }
    @Override
    public List<DETAILVIEW> getDetails4(String id) {
        Query query = entityManager.createNativeQuery("select C.IIMSORTAB \"table\",COLNAME \"col\", \'Large Data\' \"oldVal\", \'Large Data\' \"newVal\" from IIMSOR_NCLOBVALUES  where id = ?1");
        query.setParameter(1,id);
        return query.getResultList();
    }
    @Override
    public List<DETAILVIEW> getDetails5(String id) {
        Query query = entityManager.createNativeQuery("select C.IIMSORTAB \"table\",COLNAME \"col\", OLDVAL \"oldVal\", NEWVAL \"newVal\" from iimsor_numbervalues  where id = ?1",
                "PrettyResult");

        List<DETAILVIEW> results = query.getResultList();
        return results;

    }
    @Override
    public List<DETAILVIEW> getDetails6(String id) {
        Query query = entityManager.createNativeQuery("select C.IIMSORTAB \"table\",COLNAME \"col\", OLDVAL \"oldVal\", NEWVAL \"newVal\" from IIMSOR_NVARCHARVALUES where id = ?1");
        query.setParameter(1,id);
        return query.getResultList();
    }
    @Override
    public List<DETAILVIEW> getDetails7(String id) {
        Query query = entityManager.createNativeQuery("select C.IIMSORTAB \"table\",COLNAME \"col\", OLDVAL \"oldVal\", NEWVAL \"newVal\" from IIMSOR_TIMESTAMPVALUES where id = ?1");
        query.setParameter(1,id);
        return query.getResultList();
    }*/

}
