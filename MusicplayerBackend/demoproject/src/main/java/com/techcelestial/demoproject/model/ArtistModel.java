package com.techcelestial.demoproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "artist")
public class ArtistModel {
    @Id
    @GeneratedValue
    @Column(name = "artist_id")
    private Integer artistId;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "artist_desc")
    private String artistDesc;

    @Column(name = "artist_status")
    private String artistStatus;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "artistModel")
    private List<SongModel> songModelList;


    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistDesc() {
        return artistDesc;
    }

    public void setArtistDesc(String artistDesc) {
        this.artistDesc = artistDesc;
    }

    public List<SongModel> getSongModelList() {
        return songModelList;
    }

    public void setSongModelList(List<SongModel> songModelList) {
        this.songModelList = songModelList;
    }

    public String getArtistStatus() {
        return artistStatus;
    }

    public void setArtistStatus(String artistStatus) {
        this.artistStatus = artistStatus;
    }


}