package com.techcelestial.demoproject.service.impl;

import com.techcelestial.demoproject.dao.ArtistDao;
import com.techcelestial.demoproject.dao.GenerDao;
import com.techcelestial.demoproject.dto.ArtistDto;
import com.techcelestial.demoproject.dto.GenerDto;
import com.techcelestial.demoproject.dto.SongDto;
import com.techcelestial.demoproject.model.ArtistModel;
import com.techcelestial.demoproject.model.GenerModel;
import com.techcelestial.demoproject.service.GenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerServiceImpl implements GenerService {
    @Autowired
    private GenerDao generDao;


    @Override
    public boolean insertGenerController(GenerDto generDto) {

        GenerModel generModel=new GenerModel();

        generModel.setGenerName(generDto.getGenerName());
        generModel.setGenerDesc(generDto.getGenerDesc());
        generModel.setGenerStatus(generDto.getGenerStatus());


        boolean flag=generDao.insertGenerService(generModel);
        return flag;
    }

    @Override
    public List getActiveGenreList() {
        List list=generDao.getActiveGenreDao();
        return list;
    }

    @Override
    public List getGenreRecords() {
        List list=generDao.getGenreListsDao();
        return list;
    }

    @Override
    public List getGenerWiseSongController(GenerDto generDto) {

        List list=generDao.getActiveGenrewiseSongDao(generDto.getGenerId());
        return list;
    }

    @Override
    public List getSongUrlBySongIdWIseGenere(Integer songId) {
        System.out.println("In Songgggggggggggggggggggggggg serviceeeeeee "+songId);
        List list=generDao.getActiveSongUrlDao(songId);
        return list;
    }
    @Override
    public SongDto getSongsUrlBySongIdWIseGenere() {
       // System.out.println("In Songgs service "+songId);
        List list=generDao.getActiveSongsUrlDao();

        List list1=generDao.getActiveSongsNamesDao();

        SongDto songDto=new SongDto();
        songDto.setUrlList(list);
        songDto.setNameList(list1);

        return songDto;
    }
}
