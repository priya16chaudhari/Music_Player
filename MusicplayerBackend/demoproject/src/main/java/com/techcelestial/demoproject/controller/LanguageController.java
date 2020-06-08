package com.techcelestial.demoproject.controller;


import com.techcelestial.demoproject.dao.LanguageDao;
import com.techcelestial.demoproject.dto.GenerDto;
import com.techcelestial.demoproject.dto.LanguageDto;
import com.techcelestial.demoproject.dto.ResponseVO;
import com.techcelestial.demoproject.service.GenerService;
import com.techcelestial.demoproject.service.LanguageSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class LanguageController {
    @Autowired
    private LanguageSevice languageSevice;

    @RequestMapping(value = "/insertLanguageRecord",method = RequestMethod.POST)
    public ResponseVO insertLanguageRecord(@RequestBody LanguageDto languageDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=languageSevice.insertLanguageController(languageDto);

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


    @RequestMapping(value = "/getActiveLang",method = RequestMethod.GET)
    public ResponseVO<List> getActiveLang(){
        ResponseVO<List> responseVO=new ResponseVO<>();
        List list=languageSevice.getActiveLangList();
        responseVO.setResult(list);
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return responseVO;
    }


    @RequestMapping(value = "/getSongWiseActiveLanguage",method = RequestMethod.POST)
    public ResponseVO<List> getSongWiseActiveLanguage(@RequestBody LanguageDto languageDto)
    {
        ResponseVO<List> responseVO=new ResponseVO();

        List list=languageSevice.getLanguageWiseSongController(languageDto);

        responseVO.setResult(list);
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return responseVO;

    }
}
