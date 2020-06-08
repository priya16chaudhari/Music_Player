package com.techcelestial.demoproject.dao.impl;

import com.techcelestial.demoproject.dao.PlayListDao;
import com.techcelestial.demoproject.dto.PlayListDto;
import com.techcelestial.demoproject.model.LanguageModel;
import com.techcelestial.demoproject.model.PlayListModel;
import com.techcelestial.demoproject.model.WeatherModel;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PlayListDaoImpl implements PlayListDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean insertPlayListService(PlayListModel playListModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(playListModel);

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
    public List getActivePlayListDao() {
        List list=null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select pm.playlistID as playlistID,pm.playlistName as playlistName,pm.playlistDesc as playlistDesc,pm.playliststatus as playliststatus from PlayListModel as pm where pm.playliststatus='Active'");
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
    public List getActivePlayListDao(Integer playlistID) {
        List list=null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select sm.songName as songName,sm.songUrl as songUrl from SongModel as sm where sm.playListModel.playlistID=:playlistID");
            query.setParameter("playlistID",playlistID);
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
