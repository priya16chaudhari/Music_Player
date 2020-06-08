package com.techcelestial.demoproject.dao;

import com.techcelestial.demoproject.model.SongModel;

import java.util.List;

public interface SongDao {
    boolean insertSongService(SongModel songModel);


    List getSongDao();

    List getSongsDao();

    List getsongdao(Integer songId);
}
