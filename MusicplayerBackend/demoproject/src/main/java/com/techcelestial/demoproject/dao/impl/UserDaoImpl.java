package com.techcelestial.demoproject.dao.impl;


import com.techcelestial.demoproject.dao.UserDao;
import com.techcelestial.demoproject.model.UserRegistrationModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public String getUsername(String username)
    {
        Session session=null;
//List list=null;
        String name=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("select urm.username as username from UserRegistrationModel as urm where urm.username=:username");
            query.setParameter("username",username);
// query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            name=(String)query.uniqueResult();
// username=(String)query.uniqueResult();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return name;
    }

    @Override
    public String getPass(String password) {

        Session session=null;
//List list=null;
        String password1=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("select urm.password as password from UserRegistrationModel as urm where urm.password=:password");
            query.setParameter("password",password);
// query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            password1=(String)query.uniqueResult();
// username=(String)query.uniqueResult();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return password1;

    }

    @Override
    public List<UserRegistrationModel> getRegistrationRecord()
    {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from UserRegistrationModel");
// query.setParameter("status",status);
// query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            list=query.list();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return list;
    }

    @Override
    public Integer getUpdateInfo(UserRegistrationModel userRegistrationModel)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.update(userRegistrationModel);
            tr.commit();
            return 1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 0;

        }
        finally {
            session.close();
        }
    }

}
