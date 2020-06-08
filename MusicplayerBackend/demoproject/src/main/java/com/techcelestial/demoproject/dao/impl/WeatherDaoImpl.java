package com.techcelestial.demoproject.dao.impl;


import com.techcelestial.demoproject.dao.WeatherDao;
import com.techcelestial.demoproject.model.ArtistModel;
import com.techcelestial.demoproject.model.WeatherModel;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WeatherDaoImpl implements WeatherDao{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public boolean insertWeatherService(WeatherModel weatherModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(weatherModel);

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

    @Override
    public List getActiveWeatherDao() {
        List list=null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select wm.weatherId as weatherId,wm.weatherName as weatherName,wm.weatherStatus as weatherStatus,wm.weatherdescription as weatherdescription from WeatherModel as wm where wm.weatherStatus='Active'");
            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            list=query.list();

        }
        catch(Exception e){
            e.printStackTrace();

        }
        finally {
            session.close();
        }
        return list;
    }

    @Override
    public List getWeatherDao() {
        Session session=null;
        List list1=null;

        try
        {
            session=sessionFactory.openSession();
            Criteria criteria1=session.createCriteria(WeatherModel.class);
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
