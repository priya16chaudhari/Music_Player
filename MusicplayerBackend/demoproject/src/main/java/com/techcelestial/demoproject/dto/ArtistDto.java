package com.techcelestial.demoproject.dto;


public class ArtistDto {
    private Integer artistId;
    private String artistName;
    private String artistDesc;
    private String artistStatus;


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

    public String getArtistStatus() {
        return artistStatus;
    }

    public void setArtistStatus(String artistStatus) {
        this.artistStatus = artistStatus;
    }
}