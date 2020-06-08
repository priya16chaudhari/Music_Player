package com.techcelestial.demoproject.service;

import com.techcelestial.demoproject.dto.AlbumDto;

import java.util.List;

public interface AlbumService {

    boolean insertAlbumController(AlbumDto albumDto);

    List getActiveAlbumList();

    List getActiveAlbumWiseControllerList(AlbumDto albumDto);
}
