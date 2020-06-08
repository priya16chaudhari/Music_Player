package com.techcelestial.demoproject.dto;

import javax.persistence.Column;
import java.util.Date;

public class AlbumDto {
    private Integer albumId;


    private String albumName;

    private Integer albumYear;



    private String albumstatus;


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

    public String getAlbumstatus() {
        return albumstatus;
    }

    public void setAlbumstatus(String albumstatus) {
        this.albumstatus = albumstatus;
    }
}
