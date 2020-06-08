package com.techcelestial.demoproject.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "song")
public class SongModel {
    @Id
    @GeneratedValue
    @Column(name = "song_id")
    private Integer songId;

    @Column(name = "song_name")
    private String songName;

    @Column(name = "song_desc")
    private String songDesc;


    @Column(name = "song_status")
    private String songstatus;

    @Column(name="song_url")
    private String songUrl;



    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id",referencedColumnName = "actor_id")
    private ActorModel actorModel;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="album_id")
    private AlbumModel albumModel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id")
    private ArtistModel artistModel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="gener_id")
    private GenerModel generModel;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="language_id")
    private LanguageModel languageModel;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="playlist_id")
    private PlayListModel playListModel;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="weather_id")
    private WeatherModel weatherModel;



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


    public LanguageModel getLanguageModel() {
        return languageModel;
    }

    public void setLanguageModel(LanguageModel languageModel) {
        this.languageModel = languageModel;
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
