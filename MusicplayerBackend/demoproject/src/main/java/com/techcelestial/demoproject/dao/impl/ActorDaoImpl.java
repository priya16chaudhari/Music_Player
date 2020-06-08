package com.techcelestial.demoproject.dao.impl;

import com.techcelestial.demoproject.dao.ActorDao;
import com.techcelestial.demoproject.model.ActorModel;
import com.techcelestial.demoproject.model.AdminModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ActorDaoImpl implements ActorDao {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public boolean insertActorService(ActorModel actorModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(actorModel);

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
    public List getActiveActorDao() {
        List list=null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select am.actorID as actorID,am.actorName as actorName,am.actorDesc as actorDesc,am.actorstatus as actorstatus from ActorModel as am where am.actorstatus='Active'");
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
    public List getActiveActorSongsDao(Integer actorID) {
        List list=null;
        Session session=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("select sm.songName as songName,sm.songUrl as songUrl from SongModel as sm where sm.actorModel.actorID=:actorID");
            query.setParameter("actorID",actorID);
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
