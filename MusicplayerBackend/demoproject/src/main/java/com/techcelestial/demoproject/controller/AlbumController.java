package com.techcelestial.demoproject.controller;


import com.techcelestial.demoproject.dto.AdminDto;
import com.techcelestial.demoproject.dto.AlbumDto;
import com.techcelestial.demoproject.dto.ResponseVO;
import com.techcelestial.demoproject.service.AdminService;
import com.techcelestial.demoproject.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping(value = "/insertAlbumRecord",method = RequestMethod.POST)
    public ResponseVO insertAlbumRecord(@RequestBody AlbumDto albumDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=albumService.insertAlbumController(albumDto);

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


    @RequestMapping(value = "/getActiveAlbum",method = RequestMethod.GET)
    public ResponseVO<List> getActiveAlbum(){
        ResponseVO<List> responseVO=new ResponseVO<>();
        List list=albumService.getActiveAlbumList();
        responseVO.setResult(list);
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return responseVO;
    }


    @RequestMapping(value = "/getActiveAlbumwiseSong",method = RequestMethod.POST)
    public ResponseVO<List> getActiveAlbumwiseSong(@RequestBody AlbumDto albumDto)
    {
        ResponseVO<List> responseVO=new ResponseVO<>();
        List list=albumService.getActiveAlbumWiseControllerList(albumDto);
        responseVO.setResult(list);
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return responseVO;
    }

}
