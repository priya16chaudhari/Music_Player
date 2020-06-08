package com.techcelestial.demoproject.service;

import com.techcelestial.demoproject.dto.ActorDto;

import java.util.List;

public interface ActorService {
    boolean insertActorController(ActorDto actorDto);

    List getActiveActorList();

    List getActiveActorWiseSongController(ActorDto actorDto);
}
