package com.techcelestial.demoproject.dao.impl;

import com.techcelestial.demoproject.dao.ArtistDao;
import com.techcelestial.demoproject.model.ArtistModel;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtistDaoImpl implements ArtistDao
{

       @Autowired
    private SessionFactory sessionFactory;

//    @Override
//    public boolean insertService(CompanyModel companyModel)
//    {
//        Session session=null;
//        try
//        {
//            session=sessionFactory.openSession();
//            Transaction tr=session.beginTransaction();
//            session.save(companyModel);
//
//            tr.commit();
//            return true;
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            return false;
//        }
//        finally
//        {
//            session.close();
//        }
//    }

    @Override
    public boolean insertArtistService(ArtistModel artistModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(artistModel);

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
    public List getActiveArtistDao() {
        List list=null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select arm.artistId as artistId,arm.artistName as artistName,arm.artistDesc as artistDesc,arm.artistStatus as artistStatus from ArtistModel as arm where arm.artistStatus='Active'");
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
    public List getActiveArtistwiseSongDao(String artistName) {
        List list=null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select sm.songName as songName,sm.songId as songId from SongModel as sm where sm.artistModel.artistName=:artistName");
            query.setParameter("artistName",artistName);

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
    public List getDao(String songName) {
        List list=null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select sm.songUrl as songUrl from SongModel as sm where sm.songName=:songName");
            query.setParameter("songName",songName);
            System.out.println("In Songgggggggggggggggggggggggg daooooooooooo "+songName);
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


//    @Override
//    public List getCompanyDao() {
//
//        Session session=null;
//        List list1=null;
//
//
//
//        try
//        {
//            session=sessionFactory.openSession();
//            Criteria criteria1=session.createCriteria(CompanyModel.class);
//            list1=criteria1.list();
//            System.out.println("list1 is"+list1.size());
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        finally
//        {
//            session.close();
//        }
//        return list1;
//    }
//
//    @Override
//    public CompanyDto editCompany(Integer companyId) {
//        Session session = null;
//        CompanyDto companyDto = new CompanyDto();
//        try {
//            session = sessionFactory.openSession();
//            CompanyModel companyModel = session.load(CompanyModel.class, companyId);
//            companyDto.setCompanyId(companyModel.getCompanyId());
//            companyDto.setComapnyName(companyModel.getComapnyName());
//            companyDto.setCompanyDesc(companyModel.getCompanyDesc());
//            companyDto.setComapnyCnumber(companyModel.getComapnyCnumber());
//            companyDto.setCompanyWebsite(companyModel.getCompanyWebsite());
//            companyDto.setComapnyMailid(companyModel.getComapnyMailid());
//            companyDto.setComapnyMobile(companyModel.getComapnyMobile());
//            companyDto.setCompanyAddress(companyModel.getCompanyAddress());
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return companyDto;
//    }
//
//    @Override
//    public boolean updateCompany(CompanyModel companyModel) {
//        Session session = null;
//        try {
//            session = sessionFactory.openSession();
//            Transaction tr = session.beginTransaction();
//            session.update(companyModel);
//
//            tr.commit();
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        } finally {
//            session.close();
//        }
//    }
//
//
//
//    @Override
//    public boolean deleteRecord(Integer companyId)
//    {
//        Session session=null;
//        try
//        {
//            session=sessionFactory.openSession();
//            Transaction tr=session.beginTransaction();
//
//            Query query=session.createQuery("delete from CompanyModel as am where am.companyId=:companyId");
//            query.setParameter("companyId",+companyId);
//            query.executeUpdate();
//
//            tr.commit();
//            return true;
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            return false;
//        }
//        finally
//        {
//            session.close();
//        }
//    }



}
