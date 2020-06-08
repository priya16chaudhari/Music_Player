package com.techcelestial.demoproject.service;

import com.techcelestial.demoproject.dto.PlayListDto;

import java.util.List;

public interface PlayListService {

    boolean insertPlayListController(PlayListDto playListDto);

    List getActivePlayListList();

    List getPlayListWiseSongController(PlayListDto playListDto);
}
