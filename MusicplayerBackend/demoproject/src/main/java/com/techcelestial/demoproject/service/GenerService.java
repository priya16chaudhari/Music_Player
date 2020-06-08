package com.techcelestial.demoproject.service;

import com.techcelestial.demoproject.dto.GenerDto;
import com.techcelestial.demoproject.dto.SongDto;

import java.util.List;

public interface GenerService {
    boolean insertGenerController(GenerDto generDto);
    List getActiveGenreList();

    List getGenreRecords();

    List getGenerWiseSongController(GenerDto generDto);

    List getSongUrlBySongIdWIseGenere(Integer songId);
    SongDto getSongsUrlBySongIdWIseGenere();
}
