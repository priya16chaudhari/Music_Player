package com.techcelestial.demoproject.dao.impl;

import com.techcelestial.demoproject.dao.UserRegistrationDao;
import com.techcelestial.demoproject.dto.UserRegistrationDto;
import com.techcelestial.demoproject.model.UserRegistrationModel;
import com.techcelestial.demoproject.model.WeatherModel;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRegistrationDaoImpl implements UserRegistrationDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean insertRegisterRecord(UserRegistrationModel userRegistrationModel)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(userRegistrationModel);
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
        finally {
            session.close();
        }
    }


    @Override
    public List<UserRegistrationModel> getCntListRecord() {
        Session session=null;
        List list1=null;

        try
        {
            session=sessionFactory.openSession();
            Criteria criteria1=session.createCriteria(UserRegistrationModel.class);
            list1=criteria1.list();
            System.out.println("list1 is"+list1.size());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return list1;


    }
}
