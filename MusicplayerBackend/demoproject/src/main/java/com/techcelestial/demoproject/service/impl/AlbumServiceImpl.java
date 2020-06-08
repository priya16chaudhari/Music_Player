package com.techcelestial.demoproject.service.impl;

import com.techcelestial.demoproject.dao.AdminDao;
import com.techcelestial.demoproject.dao.AlbumDao;
import com.techcelestial.demoproject.dto.AdminDto;
import com.techcelestial.demoproject.dto.AlbumDto;
import com.techcelestial.demoproject.model.AdminModel;
import com.techcelestial.demoproject.model.AlbumModel;
import com.techcelestial.demoproject.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumDao albumDao;


    @Override
    public boolean insertAlbumController(AlbumDto albumDto) {
        AlbumModel albumModel=new AlbumModel();
//        artistModel.setArtistId(artistDto.getArtistId());


        albumModel.setAlbumName(albumDto.getAlbumName());
        albumModel.setAlbumYear(albumDto.getAlbumYear());
        albumModel.setAlbumstatus(albumDto.getAlbumstatus());


        boolean flag=albumDao.insertAlbumService(albumModel);
        return flag;
    }

    @Override
    public List getActiveAlbumList() {
        List list=albumDao.getActiveAlbumDao();
        return list;
    }

    @Override
    public List getActiveAlbumWiseControllerList(AlbumDto albumDto) {
        List list=albumDao.getActiveAlbumWiseSongDao(albumDto.getAlbumId());
        return list;
    }
}
