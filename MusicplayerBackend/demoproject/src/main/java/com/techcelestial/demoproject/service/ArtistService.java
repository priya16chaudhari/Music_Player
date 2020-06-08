package com.techcelestial.demoproject.service;

import com.techcelestial.demoproject.dto.ArtistDto;

import java.util.List;


public interface ArtistService {
//     boolean insertController(CompanyDto companyDto);

    boolean insertArtistController(ArtistDto artistDto);

    List getActiveArtistList();

    List getArtistWiseSongController(String artistName);

    List getSongUrlBySongnameWIseGenere(String songName);

//    List getArtistWiseSongController();

//
//    List getCompanyDetails();
//
//    boolean updateCompanyService(CompanyDto companyDto);
//
//    CompanyDto editCompanyService(Integer companyId);
//
//    boolean deleteCompanyService(Integer companyId);
//
//    boolean insertArtistController(ArtistDto artistDto);
}
