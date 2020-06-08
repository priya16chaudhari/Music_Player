package com.techcelestial.demoproject.controller;


import com.techcelestial.demoproject.dto.ResponseVO;
import com.techcelestial.demoproject.dto.UserDto;
import com.techcelestial.demoproject.dto.WeatherDto;
import com.techcelestial.demoproject.service.UserService;
import com.techcelestial.demoproject.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/insertWeatherRecord",method = RequestMethod.POST)
    public ResponseVO insertWeatherRecord(@RequestBody WeatherDto weatherDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=weatherService.insertWeatherController(weatherDto);

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



    @RequestMapping(value = "/getActiveWeather",method = RequestMethod.GET)
    public ResponseVO<List> getActiveWeather(){
        ResponseVO<List> responseVO=new ResponseVO<>();
        List list=weatherService.getActiveWeatherList();
        responseVO.setResult(list);
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return responseVO;
    }



    @RequestMapping(value="getWeatherRecord",method=RequestMethod.GET)
    public List getWeatherRecord()
    {
        ResponseVO  responseVO=new ResponseVO();

        List list=weatherService.getWeatherDetails();
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

}
