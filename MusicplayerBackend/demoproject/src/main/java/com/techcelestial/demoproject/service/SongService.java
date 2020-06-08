package com.techcelestial.demoproject.service;

import com.techcelestial.demoproject.dto.SongDto;

import java.util.List;

public interface SongService {
    boolean insertSongController(SongDto songDto);


    List getSongsDetails();

    List getSongDetails();

    List getSongUrl(Integer songId);
}
