package com.techcelestial.demoproject.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "weather")
public class WeatherModel {

    @Id
    @GeneratedValue
    @Column(name = "weather_id")
    private Integer weatherId;

    @Column(name = "weather_name")
    private String weatherName;

    @Column(name = "weather_status")
    private String weatherStatus;


    @Column(name = "weather_descrip")
    private String weatherdescription;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "weatherModel")
    private List<SongModel> songModelList;


    public Integer getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(Integer weatherId) {
        this.weatherId = weatherId;
    }

    public String getWeatherName() {
        return weatherName;
    }

    public void setWeatherName(String weatherName) {
        this.weatherName = weatherName;
    }

    public String getWeatherStatus() {
        return weatherStatus;
    }

    public void setWeatherStatus(String weatherStatus) {
        this.weatherStatus = weatherStatus;
    }

    public List<SongModel> getSongModelList() {
        return songModelList;
    }

    public void setSongModelList(List<SongModel> songModelList) {
        this.songModelList = songModelList;
    }

    public String getWeatherdescription() {
        return weatherdescription;
    }

    public void setWeatherdescription(String weatherdescription) {
        this.weatherdescription = weatherdescription;
    }

}
