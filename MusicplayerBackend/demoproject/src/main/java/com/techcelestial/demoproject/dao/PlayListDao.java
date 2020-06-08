package com.techcelestial.demoproject.dao;

import com.techcelestial.demoproject.dto.PlayListDto;
import com.techcelestial.demoproject.model.PlayListModel;

import java.util.List;

public interface PlayListDao {
    boolean insertPlayListService(PlayListModel playListModel);

    List getActivePlayListDao();

    List getActivePlayListDao(Integer playlistID);
}
