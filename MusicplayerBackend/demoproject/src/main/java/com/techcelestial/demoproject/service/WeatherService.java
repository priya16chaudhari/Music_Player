package com.techcelestial.demoproject.service;

import com.techcelestial.demoproject.dto.WeatherDto;

import java.util.List;

public interface WeatherService {
    boolean insertWeatherController(WeatherDto weatherDto);

    List getActiveWeatherList();

    List getWeatherDetails();
}
