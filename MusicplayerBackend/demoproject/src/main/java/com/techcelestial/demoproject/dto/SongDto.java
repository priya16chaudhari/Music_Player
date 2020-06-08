package com.techcelestial.demoproject.dto;

import com.techcelestial.demoproject.model.*;

import java.util.Date;
import java.util.List;

public class SongDto
{
    private Integer songId;
    private String songName;
    private String songDesc;
    private String songstatus;
    private String songUrl;


    private LanguageModel languageModel;
    private ArtistModel artistModel;
    private AlbumModel albumModel;
    private WeatherModel weatherModel;
    private ActorModel actorModel;
    private GenerModel generModel;
    private PlayListModel playListModel;

    private List urlList;
    private List nameList;

    public List getUrlList() {
        return urlList;
    }

    public void setUrlList(List urlList) {
        this.urlList = urlList;
    }

    public List getNameList() {
        return nameList;
    }

    public void setNameList(List nameList) {
        this.nameList = nameList;
    }

    public LanguageModel getLanguageModel() {
        return languageModel;
    }

    public void setLanguageModel(LanguageModel languageModel) {
        this.languageModel = languageModel;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongDesc() {
        return songDesc;
    }

    public void setSongDesc(String songDesc) {
        this.songDesc = songDesc;
    }



    public ArtistModel getArtistModel() {
        return artistModel;
    }

    public void setArtistModel(ArtistModel artistModel) {
        this.artistModel = artistModel;
    }

    public AlbumModel getAlbumModel() {
        return albumModel;
    }

    public void setAlbumModel(AlbumModel albumModel) {
        this.albumModel = albumModel;
    }

    public WeatherModel getWeatherModel() {
        return weatherModel;
    }

    public void setWeatherModel(WeatherModel weatherModel) {
        this.weatherModel = weatherModel;
    }

    public GenerModel getGenerModel() {
        return generModel;
    }

    public void setGenerModel(GenerModel generModel) {
        this.generModel = generModel;
    }

    public String getSongstatus() {
        return songstatus;
    }

    public void setSongstatus(String songstatus) {
        this.songstatus = songstatus;
    }


    public ActorModel getActorModel() {
        return actorModel;
    }

    public void setActorModel(ActorModel actorModel) {
        this.actorModel = actorModel;
    }

    public PlayListModel getPlayListModel() {
        return playListModel;
    }

    public void setPlayListModel(PlayListModel playListModel) {
        this.playListModel = playListModel;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }
}
