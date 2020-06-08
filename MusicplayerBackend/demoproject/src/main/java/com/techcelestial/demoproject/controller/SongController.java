package com.techcelestial.demoproject.controller;


import com.techcelestial.demoproject.dto.LanguageDto;
import com.techcelestial.demoproject.dto.ResponseVO;
import com.techcelestial.demoproject.dto.SongDto;
import com.techcelestial.demoproject.service.LanguageSevice;
import com.techcelestial.demoproject.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class SongController {

    @Autowired
    private SongService songService;

    @RequestMapping(value = "/insertSongRecord",method = RequestMethod.POST)
    public ResponseVO insertSongRecord(@RequestBody SongDto songDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=songService.insertSongController(songDto);

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



    @RequestMapping(value="getSongs",method=RequestMethod.GET)
    public List getSongs()
    {
        ResponseVO  responseVO=new ResponseVO();

        List list=songService.getSongsDetails();
        if (list!= null) {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("get Successfully");
            responseVO.setResult(list);
        }
        else

        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage(" failed");
            responseVO.setResult(list);
        }
        return list;
    }


    @RequestMapping(value = "getsongidwiseurl/{songId}",method = RequestMethod.GET)
    public List getsongidwiseurl(@PathVariable Integer songId)
    {
        ResponseVO responseVO=new ResponseVO();

        List list=songService.getSongUrl(songId);
        responseVO.setResult(list);
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return list;
    }
}
