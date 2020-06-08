package com.techcelestial.demoproject.dao.impl;

import com.techcelestial.demoproject.dao.AlbumDao;
import com.techcelestial.demoproject.model.AdminModel;
import com.techcelestial.demoproject.model.AlbumModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumDaoImpl implements AlbumDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean insertAlbumService(AlbumModel albumModel) {

        Session session=null;
            try
            {
                session=sessionFactory.openSession();
                Transaction tr=session.beginTransaction();
                session.save(albumModel);

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
    public List getActiveAlbumDao() {
        List list=null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select alb.albumId as albumId,alb.albumName as albumName,alb.albumYear as albumYear,alb.albumstatus as albumstatus from AlbumModel as alb where alb.albumstatus='Active'");
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
    public List getActiveAlbumWiseSongDao(Integer albumId) {
        List list=null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select sm.songName as songName,sm.songId as songId from SongModel as sm where sm.albumModel.albumId=:albumId");
            query.setParameter("albumId",albumId);

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
}
