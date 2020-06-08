package com.techcelestial.demoproject.service.impl;


import com.techcelestial.demoproject.dao.ArtistDao;
import com.techcelestial.demoproject.dto.ArtistDto;
import com.techcelestial.demoproject.model.ArtistModel;
import com.techcelestial.demoproject.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService
{
    @Autowired
    private ArtistDao artistDao;



    @Override
    public boolean insertArtistController(ArtistDto artistDto) {


        ArtistModel artistModel=new ArtistModel();



        artistModel.setArtistName(artistDto.getArtistName());
        artistModel.setArtistDesc(artistDto.getArtistDesc());
        artistModel.setArtistStatus(artistDto.getArtistStatus());


        boolean flag=artistDao.insertArtistService(artistModel);
        return flag;

    }

    @Override
    public List getActiveArtistList() {
        List list=artistDao.getActiveArtistDao();
        return list;
    }

    @Override
    public List getArtistWiseSongController(String artistName) {
        List list=artistDao.getActiveArtistwiseSongDao(artistName);
        return list;
    }

    @Override
    public List getSongUrlBySongnameWIseGenere(String songName) {
        System.out.println("In Songgggggggggggggggggggggggg serviceeeeeee "+songName);
        List list=artistDao.getDao(songName);
        return list;
    }


//    @Override
//    public List getCompanyDetails() {
//
//        List list=companyDao.getCompanyDao();
//        return list;
//    }
//
//    @Override
//    public boolean updateCompanyService(CompanyDto companyDto) {
//        CompanyModel companyModel=new CompanyModel();
//
//        companyModel.setCompanyId(companyDto.getCompanyId());
//        companyModel.setComapnyName(companyDto.getComapnyName());
//        companyModel.setCompanyDesc(companyDto.getCompanyDesc());
//        companyModel.setComapnyCnumber(companyDto.getComapnyCnumber());
//        companyModel.setComapnyMailid(companyDto.getComapnyMailid());
//        companyModel.setComapnyMobile(companyDto.getComapnyMobile());
//
//
//        companyModel.setCompanyWebsite(companyDto.getCompanyWebsite());
//
//        companyModel.setCompanyAddress(companyDto.getCompanyAddress());
//
//        boolean flag=companyDao.updateCompany(companyModel);
//
//        return flag;
//    }
//
//    @Override
//    public CompanyDto editCompanyService(Integer companyId) {
//        CompanyDto companyDto=companyDao.editCompany(companyId);
//        return companyDto;
//    }
//
//    @Override
//    public boolean deleteCompanyService(Integer companyId)
//    {
//
//
//        boolean flag=companyDao.deleteRecord(companyId);
//        return flag;
//
//    }


}
