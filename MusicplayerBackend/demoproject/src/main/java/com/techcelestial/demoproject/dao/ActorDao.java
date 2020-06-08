package com.techcelestial.demoproject.dao;

import com.techcelestial.demoproject.model.ActorModel;

import java.util.List;

public interface ActorDao {
    boolean insertActorService(ActorModel actorModel);

    List getActiveActorDao();

    List getActiveActorSongsDao(Integer actorID);
}
