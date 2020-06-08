package com.techcelestial.demoproject.dao.impl;

import com.techcelestial.demoproject.dao.LanguageDao;
import com.techcelestial.demoproject.model.ArtistModel;
import com.techcelestial.demoproject.model.LanguageModel;
import com.techcelestial.demoproject.model.WeatherModel;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LanguageDaoImpl implements LanguageDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public boolean insertLanguageService(LanguageModel languageModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(languageModel);

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
    public List getActiveLangDao() {
        List list=null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select lm.languageId as languageId,lm.languageName as languageName,lm.languageStatus as languageStatus from LanguageModel as lm where lm.languageStatus='Active'");
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
    public List getActiveLangDao(Integer languageId) {

        List list=null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select sm.songName as songName,sm.songUrl as songUrl from SongModel as sm where sm.languageModel.languageId=:languageId");
            query.setParameter("languageId",languageId);

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
