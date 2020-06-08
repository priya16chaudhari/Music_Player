package com.techcelestial.demoproject.service.impl;


import com.techcelestial.demoproject.dao.SongDao;

import com.techcelestial.demoproject.dto.SongDto;

import com.techcelestial.demoproject.model.SongModel;
import com.techcelestial.demoproject.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService{

    @Autowired
    private SongDao songDao;





    @Override
    public boolean insertSongController(SongDto songDto) {
        SongModel songModel=new SongModel();

        songModel.setSongName(songDto.getSongName());
        songModel.setSongDesc(songDto.getSongDesc());
        songModel.setSongstatus(songDto.getSongstatus());
        songModel.setSongUrl(songDto.getSongUrl());
        //songModel.setLanguageModel(songDto.getLanguageModel());

        songModel.setAlbumModel(songDto.getAlbumModel());

        songModel.setArtistModel(songDto.getArtistModel());

        songModel.setGenerModel(songDto.getGenerModel());

        songModel.setWeatherModel(songDto.getWeatherModel());

        songModel.setLanguageModel(songDto.getLanguageModel());

        songModel.setActorModel(songDto.getActorModel());

        songModel.setPlayListModel(songDto.getPlayListModel());

        boolean flag=songDao.insertSongService(songModel);
        return flag;
    }

    @Override
    public List getSongsDetails() {
        List list=songDao.getSongDao();
        return list;
    }

    @Override
    public List getSongDetails() {
        List list=songDao.getSongsDao();
        return list;
    }

    @Override
    public List getSongUrl(Integer songId) {
        System.out.println("In Songgggggggggggggggggggggggg serviceeeeeee "+songId);
        List list=songDao.getsongdao(songId);
        return list;
    }


}
