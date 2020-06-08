package com.techcelestial.demoproject.dao;

import com.techcelestial.demoproject.model.GenerModel;

import java.util.List;

public interface GenerDao {
    boolean insertGenerService(GenerModel generModel);
    List getActiveGenreDao();

    List getGenreListsDao();
    List getActiveGenrewiseSongDao(Integer generId);


    List getActiveSongUrlDao(Integer songId);
    List getActiveSongsUrlDao();

    List getActiveSongsNamesDao();
}
