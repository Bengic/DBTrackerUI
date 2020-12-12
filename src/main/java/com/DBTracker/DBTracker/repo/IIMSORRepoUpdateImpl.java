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


@Repository
@Transactional
public class IIMSORRepoUpdateImpl implements IIMSORRepoUpdate {
    @PersistenceContext
    protected EntityManager entityManager;
    public void check (Connection connection, String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(sql);

    }

    @Override
    @ModelAttribute("addme")
    public Return AddMe(String user) {
        // EntityTransaction t = entityManager.getTransaction();
        Return retunitem = new Return();
        Session session = entityManager.unwrap(Session.class);
        try {
            // session.beginTransaction();
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    check(connection, "select 1 from IIMSOR where 1=2");
                    check(connection, "select 1 from IIMSOR_varcharvalues where 1=2");
                    check(connection, "select 1 from IIMSOR_nvarcharvalues where 1=2");
                    check(connection, "select 1 from IIMSOR_numbervalues where 1=2");
                    check(connection, "select 1 from IIMSOR_clobvalues where 1=2");
                    check(connection, "select 1 from IIMSOR_nclobvalues where 1=2");
                    check(connection, "select 1 from IIMSOR_timestampvalues where 1=2");
                    check(connection, "select 1 from IIMSOR_datevalues where 1=2");
                    check(connection, "select 1 from IIMSOR_blobvalues where 1=2");
                    check(connection, "select 1 from IIMSORLIC where 1=2");
                    check(connection, "select 1 from iimsor_coloverride where 1=2");
                }
            });
        } catch (Exception e) {
            retunitem.setReturnStatus("FAILURE");
            retunitem.setLongInfo(e.getMessage().toString());
            retunitem.setShortInfo("Please install the auding utility..");
            return retunitem;

        }
        // session.getTransaction().commit();

        Query query = entityManager.createNativeQuery(" select 1 from IIMSORLIC where IIMLIC = ? ");
        query.setParameter(1, user);
        if ( query.getResultList().size() == 0) {


            Query query1 = entityManager.createNativeQuery("insert into IIMSORLIC (IIMLIC) values ( ? )");
            try {
                query1.setParameter(1, user);
                query1.executeUpdate();
            } catch (Exception e) {
                retunitem.setReturnStatus("FAILURE");
                retunitem.setLongInfo(e.getMessage().toString());
                retunitem.setShortInfo("Please check your DB user permission / Install the auding ");
                return retunitem;

            }
        }else{retunitem.setShortInfo("You have already been added ..");}
        retunitem.setReturnStatus("SUCCESS");
        return retunitem;


    }
    @Override
    @ModelAttribute("removeme")
    public String RemoveMe(String user) {
        Return retunitem =  new Return();
        String sqlman  = "delete from IIMSORLIC where IIMLIC = ?";

        Query query1 = entityManager.createNativeQuery(sqlman);
        try {
            query1.setParameter(1, user);
            query1.executeUpdate();
        } catch(Exception e){

            retunitem.setReturnStatus("FAILURE");
            retunitem.setLongInfo(e.getMessage().toString());
            retunitem.setShortInfo("Please check your DB user permission / Install the auding ");
            return "Failure - Please check your DB permission and reinstall the auditing - " +e.getMessage().toString();

        }
        retunitem.setReturnStatus("SUCCESS");
        return "SUCCESS";
    }

    @Override
    public Return clean(String user) {
        Return retunitem =  new Return();
        String sqlman = "";
        sqlman = "delete from IIMSOR_varcharvalues where id in (select id from IIMSOR where IIMSORHN = ?)";
        Query query1 = entityManager.createNativeQuery(sqlman);
        sqlman = "delete from  IIMSOR_nvarcharvalues where id in (select id from IIMSOR where IIMSORHN = ?)";
                Query query2 = entityManager.createNativeQuery(sqlman);
        sqlman =  "delete from IIMSOR_numbervalues where id in (select id from IIMSOR where IIMSORHN = ?)";
        Query query3 = entityManager.createNativeQuery(sqlman);
        sqlman = "delete from IIMSOR_clobvalues where id in (select id from IIMSOR where IIMSORHN = ?)";
        Query query4 = entityManager.createNativeQuery(sqlman);
        sqlman = "delete from  IIMSOR_timestampvalues where id in (select id from IIMSOR where IIMSORHN = ?)";
        Query query5 = entityManager.createNativeQuery(sqlman);
        sqlman = "delete from IIMSOR_datevalues where id in (select id from IIMSOR where IIMSORHN = ?)";
        Query query6 = entityManager.createNativeQuery(sqlman);
        sqlman = "delete from IIMSOR_nclobvalues where id in (select id from IIMSOR where IIMSORHN = ?)";
        Query query7 = entityManager.createNativeQuery(sqlman);
        sqlman = "delete from IIMSOR_blobvalues where id in (select id from IIMSOR where IIMSORHN = ?)";
        Query query8 = entityManager.createNativeQuery(sqlman);
        sqlman =  "delete from IIMSOR where IIMSORHN = ?";
        Query query9 = entityManager.createNativeQuery(sqlman);

        try {
            query1.setParameter(1, user);
            query2.setParameter(1, user);
            query3.setParameter(1, user);
            query4.setParameter(1, user);
            query5.setParameter(1, user);
            query6.setParameter(1, user);
            query7.setParameter(1, user);
            query8.setParameter(1, user);
            query9.setParameter(1, user);

            query1.executeUpdate();
            query2.executeUpdate();
            query3.executeUpdate();
            query4.executeUpdate();
            query5.executeUpdate();
            query6.executeUpdate();
            query7.executeUpdate();
            query8.executeUpdate();
            query9.executeUpdate();

        } catch(Exception e){

            retunitem.setReturnStatus("Failed to clean some records..");
            retunitem.setLongInfo(e.getMessage());
            retunitem.setShortInfo("Please check your DB user permission / Upgrade or reinstall to include all column types.");
            return retunitem;

        }
        retunitem.setReturnStatus("Audit details has been removed successfully .. ");
        return retunitem;

    }

    @Override
    public Return cleanAll() {
        Return retunitem =  new Return();
        String sqlman = "";
        sqlman =  "delete from IIMSOR_varcharvalues where id in (select id from IIMSOR )";
        Query query1 = entityManager.createNativeQuery(sqlman);
        sqlman = "delete from  IIMSOR_nvarcharvalues where id in (select id from IIMSOR )";
        Query query2 = entityManager.createNativeQuery(sqlman);
        sqlman =   "delete from IIMSOR_numbervalues where id in (select id from IIMSOR )";
        Query query3 = entityManager.createNativeQuery(sqlman);
        sqlman =  "delete from IIMSOR_clobvalues where id in (select id from IIMSOR )";
        Query query4 = entityManager.createNativeQuery(sqlman);
        sqlman =   "delete from  IIMSOR_timestampvalues where id in (select id from IIMSOR )";
        Query query5 = entityManager.createNativeQuery(sqlman);
        sqlman = "delete from IIMSOR_datevalues where id in (select id from IIMSOR )";
        Query query6 = entityManager.createNativeQuery(sqlman);
        sqlman =  "delete from IIMSOR_nclobvalues where id in (select id from IIMSOR )";
        Query query7 = entityManager.createNativeQuery(sqlman);
        sqlman =  "delete from IIMSOR_blobvalues where id in (select id from IIMSOR )";
        Query query8 = entityManager.createNativeQuery(sqlman);
        sqlman = "delete from IIMSOR";
        Query query9 = entityManager.createNativeQuery(sqlman);

        try {

            query1.executeUpdate();
            query2.executeUpdate();
            query3.executeUpdate();
            query4.executeUpdate();
            query5.executeUpdate();
            query6.executeUpdate();
            query7.executeUpdate();
            query8.executeUpdate();
            query9.executeUpdate();

        } catch(Exception e){

            retunitem.setReturnStatus("Failed to clean some records..");
            retunitem.setLongInfo(e.getMessage());
            retunitem.setShortInfo("Please check your DB user permission / Upgrade or reinstall to include all column types.");
            return retunitem;

        }
        retunitem.setReturnStatus("Audit details has been removed successfully .. ");
        return retunitem;

    }

}
