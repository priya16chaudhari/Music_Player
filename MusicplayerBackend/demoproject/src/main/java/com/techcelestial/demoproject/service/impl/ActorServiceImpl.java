package com.techcelestial.demoproject.service.impl;

import com.techcelestial.demoproject.dao.ActorDao;
import com.techcelestial.demoproject.dao.AdminDao;
import com.techcelestial.demoproject.dto.ActorDto;
import com.techcelestial.demoproject.dto.AdminDto;
import com.techcelestial.demoproject.model.ActorModel;
import com.techcelestial.demoproject.model.AdminModel;
import com.techcelestial.demoproject.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActorServiceImpl implements ActorService{

    @Autowired
    private ActorDao actorDao;



    @Override
    public boolean insertActorController(ActorDto actorDto) {

        ActorModel actorModel=new ActorModel();

        actorModel.setActorName(actorDto.getActorName());
        actorModel.setActorDesc(actorDto.getActorDesc());
        actorModel.setActorstatus(actorDto.getActorstatus());


        boolean flag=actorDao.insertActorService(actorModel);
        return flag;
    }

    @Override
    public List getActiveActorList() {
        List list=actorDao.getActiveActorDao();
        return list;
    }

    @Override
    public List getActiveActorWiseSongController(ActorDto actorDto) {
        List list=actorDao.getActiveActorSongsDao(actorDto.getActorID());
        return list;
    }
}
