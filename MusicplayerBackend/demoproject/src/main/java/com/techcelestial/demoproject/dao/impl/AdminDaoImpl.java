package com.techcelestial.demoproject.dao.impl;


import com.techcelestial.demoproject.dao.AdminDao;
import com.techcelestial.demoproject.model.AdminModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl implements AdminDao{


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public boolean insertAdminService(AdminModel adminModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(adminModel);

            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            session.close();
        }
    }


}
