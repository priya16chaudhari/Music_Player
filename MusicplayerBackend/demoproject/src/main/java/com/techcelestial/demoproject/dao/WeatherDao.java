package com.techcelestial.demoproject.dao;

import com.techcelestial.demoproject.model.WeatherModel;

import java.util.List;

public interface WeatherDao {
    boolean insertWeatherService(WeatherModel weatherModel);

    List getActiveWeatherDao();

    List getWeatherDao();
}
