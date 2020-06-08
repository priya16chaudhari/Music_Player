package com.techcelestial.demoproject.dao;

import com.techcelestial.demoproject.model.AlbumModel;

import java.util.List;

public interface AlbumDao {
    boolean insertAlbumService(AlbumModel albumModel);

    List getActiveAlbumDao();

    List getActiveAlbumWiseSongDao(Integer albumId);
}
