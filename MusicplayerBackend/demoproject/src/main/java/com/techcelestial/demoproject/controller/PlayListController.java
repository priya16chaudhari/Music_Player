package com.techcelestial.demoproject.controller;


import com.techcelestial.demoproject.dto.AlbumDto;
import com.techcelestial.demoproject.dto.PlayListDto;
import com.techcelestial.demoproject.dto.ResponseVO;
import com.techcelestial.demoproject.service.AlbumService;
import com.techcelestial.demoproject.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class PlayListController {

    @Autowired
    private PlayListService playListService;

    @RequestMapping(value = "/insertPlayListRecord",method = RequestMethod.POST)
    public ResponseVO insertPlayListRecord(@RequestBody PlayListDto playListDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=playListService.insertPlayListController(playListDto);

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

    @RequestMapping(value = "/getActivePlayList",method = RequestMethod.GET)
    public ResponseVO<List> getActivePlayList(){
        ResponseVO<List> responseVO=new ResponseVO<>();
        List list=playListService.getActivePlayListList();
        responseVO.setResult(list);
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return responseVO;
    }

    @RequestMapping(value = "/getPlayListWiseActiveSong",method = RequestMethod.POST)
    public ResponseVO<List> getPlayListWiseActiveSong(@RequestBody PlayListDto playListDto)
    {
        ResponseVO<List> responseVO=new ResponseVO();

        List list=playListService.getPlayListWiseSongController(playListDto);

        responseVO.setResult(list);
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return responseVO;

    }


}
