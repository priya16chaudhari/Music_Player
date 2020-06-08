package com.techcelestial.demoproject.dao;

import com.techcelestial.demoproject.model.ArtistModel;

import java.util.List;

public interface ArtistDao {
//    boolean insertService(CompanyModel companyModel);
//
//    List getCompanyDao();
//
//    CompanyDto editCompany(Integer companyId);
//
//    boolean updateCompany(CompanyModel companyModel);
//
//    boolean deleteRecord(Integer companyId);

    boolean insertArtistService(ArtistModel artistModel);

    List getActiveArtistDao();

    List getActiveArtistwiseSongDao(String artistName);

    List getDao(String songName);
}
