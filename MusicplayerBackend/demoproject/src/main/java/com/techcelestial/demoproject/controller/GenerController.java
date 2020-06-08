package com.techcelestial.demoproject.controller;


import com.techcelestial.demoproject.dto.ArtistDto;
import com.techcelestial.demoproject.dto.GenerDto;
import com.techcelestial.demoproject.dto.ResponseVO;
import com.techcelestial.demoproject.dto.SongDto;
import com.techcelestial.demoproject.service.ArtistService;
import com.techcelestial.demoproject.service.GenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class GenerController
{
    @Autowired
    private GenerService generService;

    @RequestMapping(value = "/insertGenerRecord",method = RequestMethod.POST)
    public ResponseVO insertGenerRecord(@RequestBody GenerDto generDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=generService.insertGenerController(generDto);

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

    @RequestMapping(value = "/getActiveGenre",method = RequestMethod.GET)
    public ResponseVO<List> getActiveGenre(){
        ResponseVO<List> responseVO=new ResponseVO<>();
        List list=generService.getActiveGenreList();
        responseVO.setResult(list);
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return responseVO;
    }


    @RequestMapping(value="getGenreRecord",method=RequestMethod.GET)
    public List getGenreRecord()
    {
        ResponseVO  responseVO=new ResponseVO();

        List list=generService.getGenreRecords();
        if (list!= null) {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("get Successfully");
            responseVO.setResult(list);
        }
        else

        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("insert Successfully");
            responseVO.setResult(list);
        }
        return list;
    }


    @RequestMapping(value = "/getSongWiseActiveGenere",method = RequestMethod.POST)
    public ResponseVO<List> getGenerWiseSong(@RequestBody GenerDto generDto)
    {
        ResponseVO<List> responseVO=new ResponseVO();
        System.out.println("In  Controllerrrrrrrrrrr"+generDto.getGenerId());
        List list=generService.getGenerWiseSongController(generDto);

        responseVO.setResult(list);
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return responseVO;

    }

    @RequestMapping(value = "getSongUrlBySongIdWIseAPI/{songId}",method = RequestMethod.GET)
    public List getSongUrlBySongIdWIse(@PathVariable Integer songId)
    {
        ResponseVO responseVO=new ResponseVO();
        System.out.println("In Songgggggggggggggggggggggggg controller"+songId);
        List list=generService.getSongUrlBySongIdWIseGenere(songId);
        responseVO.setResult(list);
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return list;
    }

    @RequestMapping(value = "getSongsUrlBySongIdWIse",method = RequestMethod.GET)
    public ResponseVO<SongDto> getSongsUrlBySongIdWIse()
    {
        ResponseVO<SongDto> responseVO=new ResponseVO<>();
       // System.out.println("In Songgggggggggggggggggggggggg controller"+songId);
       SongDto songDto=generService.getSongsUrlBySongIdWIseGenere();
        responseVO.setResult(songDto);
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return responseVO;

    }
}