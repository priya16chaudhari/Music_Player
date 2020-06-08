package com.techcelestial.demoproject.service.impl;

import com.techcelestial.demoproject.dao.PlayListDao;
import com.techcelestial.demoproject.dto.PlayListDto;
import com.techcelestial.demoproject.model.PlayListModel;
import com.techcelestial.demoproject.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayListServiceImpl implements PlayListService {

    @Autowired
    private PlayListDao playListDao;


    @Override
    public boolean insertPlayListController(PlayListDto playListDto) {


        PlayListModel playListModel=new PlayListModel();
        playListModel.setPlaylistName(playListDto.getPlaylistName());
        playListModel.setPlaylistDesc(playListDto.getPlaylistDesc());
        playListModel.setPlayliststatus(playListDto.getPlayliststatus());


        boolean flag=playListDao.insertPlayListService(playListModel);
        return flag;
    }

    @Override
    public List getActivePlayListList() {
        List list=playListDao.getActivePlayListDao();
        return list;
    }

    @Override
    public List getPlayListWiseSongController(PlayListDto playListDto) {

        List list=playListDao.getActivePlayListDao(playListDto.getPlaylistID());
        return list;
    }

}
