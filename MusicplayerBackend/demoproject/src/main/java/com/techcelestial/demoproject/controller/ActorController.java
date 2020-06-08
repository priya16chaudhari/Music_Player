package com.techcelestial.demoproject.controller;


import com.techcelestial.demoproject.dto.ActorDto;
import com.techcelestial.demoproject.dto.AdminDto;
import com.techcelestial.demoproject.dto.ResponseVO;
import com.techcelestial.demoproject.service.ActorService;
import com.techcelestial.demoproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @RequestMapping(value = "/insertActorRecord",method = RequestMethod.POST)
    public ResponseVO insertActorRecord(@RequestBody ActorDto actorDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=actorService.insertActorController(actorDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("insert Successfully");
            responseVO.setResult(flag);

        }
        else {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("failed");
            responseVO.setResult(flag);
        }
        return responseVO;

    }


    @RequestMapping(value = "/getActiveActor",method = RequestMethod.GET)
    public ResponseVO<List> getActiveActor(){
        ResponseVO<List> responseVO=new ResponseVO<>();
        List list=actorService.getActiveActorList();
        responseVO.setResult(list);
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return responseVO;
    }
    @RequestMapping(value = "/getActiveActorWiseSong",method = RequestMethod.POST)
    public ResponseVO<List> getActiveActorWiseSong(@RequestBody ActorDto actorDto)
    {
        ResponseVO<List> responseVO=new ResponseVO<>();
        List list=actorService.getActiveActorWiseSongController(actorDto);
        responseVO.setResult(list);
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return responseVO;

    }

}
