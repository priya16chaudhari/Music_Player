package com.techcelestial.demoproject.dao.impl;


import com.techcelestial.demoproject.dao.SongDao;
import com.techcelestial.demoproject.model.SongModel;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongDaoImpl implements SongDao{

    @Autowired
    private SessionFactory sessionFactory;




    @Override
    public boolean insertSongService(SongModel songModel) {
        Session session=null;
        try
        {

            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
           // session.evict(songModel);
                     session.save(songModel);

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
    public List getSongDao() {

        Session session=null;
        List list1=null;

        try
        {
            session=sessionFactory.openSession();
//            Query query=session.createQuery("select sm.songId as songId,sm.songName as songName,sm.songUrl as songUrl,sm.songstatus as songstatus from SongModel as sm where sm.songModel.songId=:songId");
////            query.setParameter("songId",songId);
            Query query=session.createQuery("select sm.songId as songId,sm.songName as songName,sm.songUrl as songUrl,sm.songstatus as songstatus from SongModel as sm");

            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            list1=query.list();
            return list1;
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
    public List getSongsDao() {
        Session session=null;
        List list1=null;



        try
        {
            session=sessionFactory.openSession();
            Criteria criteria1=session.createCriteria(SongModel.class);
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
    public List getsongdao(Integer songId) {
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


}
