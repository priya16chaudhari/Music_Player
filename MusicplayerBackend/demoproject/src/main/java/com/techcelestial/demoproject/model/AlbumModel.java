package com.techcelestial.demoproject.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "album")
public class AlbumModel
{

    @Id
    @GeneratedValue
    @Column(name = "album_id")
    private Integer albumId;

    @Column(name = "album_name")
    private String albumName;

    @Column(name = "album_year")
    private Integer albumYear;


    @Column(name = "album_status")
    private String albumstatus;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "albumModel")
    private List<SongModel> songModelList;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Integer getAlbumYear() {
        return albumYear;
    }

    public void setAlbumYear(Integer albumYear) {
        this.albumYear = albumYear;
    }

    public List<SongModel> getSongModelList() {
        return songModelList;
    }

    public void setSongModelList(List<SongModel> songModelList) {
        this.songModelList = songModelList;
    }

    public String getAlbumstatus() {
        return albumstatus;
    }

    public void setAlbumstatus(String albumstatus) {
        this.albumstatus = albumstatus;
    }


}
