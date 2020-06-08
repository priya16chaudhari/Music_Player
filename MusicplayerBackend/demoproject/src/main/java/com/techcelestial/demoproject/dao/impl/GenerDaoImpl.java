package com.techcelestial.demoproject.dao.impl;

import com.techcelestial.demoproject.dao.GenerDao;
import com.techcelestial.demoproject.model.ArtistModel;
import com.techcelestial.demoproject.model.GenerModel;
import com.techcelestial.demoproject.model.WeatherModel;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenerDaoImpl implements GenerDao {
    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public boolean insertGenerService(GenerModel generModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(generModel);

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
    public List getActiveGenreDao() {
        List list=null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select gm.generId as generId,gm.generName as generName,gm.generDesc as generDesc,gm.generStatus as generStatus from GenerModel as gm where gm.generStatus='Active'");
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
    public List getGenreListsDao() {
        Session session=null;
        List list1=null;

        try
        {
            session=sessionFactory.openSession();
            Criteria criteria1=session.createCriteria(GenerModel.class);
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
    @Override
    public List getActiveGenrewiseSongDao(Integer generId) {
        List list=null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select sm.songName as songName,sm.songId as songId from SongModel as sm where sm.generModel.generId=:generId");
            query.setParameter("generId",generId);

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
    public List getActiveSongUrlDao(Integer songId) {
        List list=null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select sm.songUrl as songUrl from SongModel as sm where sm.songId=:songId");
            query.setParameter("songId",songId);
            System.out.println("In Songgggggggggggggggggggggggg daooooooooooo "+songId);
//            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
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
    public List getActiveSongsUrlDao() {
        List list=null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select sm.songUrl as songUrl from SongModel as sm");
//            query.setParameter("songId",songId);
           // System.out.println("In Songgggggggggggggggggggggggg daooooooooooo "+songId);
            //query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
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
    public List getActiveSongsNamesDao() {
        List list=null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select sm.songName as songName from SongModel as sm");
//            query.setParameter("songId",songId);
            // System.out.println("In Songgggggggggggggggggggggggg daooooooooooo "+songId);
            //query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
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

}
