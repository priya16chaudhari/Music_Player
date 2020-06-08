package com.techcelestial.demoproject.service.impl;

import com.techcelestial.demoproject.dao.WeatherDao;
import com.techcelestial.demoproject.dto.WeatherDto;
import com.techcelestial.demoproject.model.WeatherModel;
import com.techcelestial.demoproject.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService{

    @Autowired
    private WeatherDao weatherDao;


    @Override
    public boolean insertWeatherController(WeatherDto weatherDto) {
        WeatherModel weatherModel=new WeatherModel();
        weatherModel.setWeatherName(weatherDto.getWeatherName());
        weatherModel.setWeatherdescription(weatherDto.getWeatherdescription());
        weatherModel.setWeatherStatus(weatherDto.getWeatherStatus());


        boolean flag=weatherDao.insertWeatherService(weatherModel);
        return flag;
    }

    @Override
    public List getActiveWeatherList() {
        List list=weatherDao.getActiveWeatherDao();
        return list;
    }

    @Override
    public List getWeatherDetails() {
        List list=weatherDao.getWeatherDao();
        return list;

    }
}
