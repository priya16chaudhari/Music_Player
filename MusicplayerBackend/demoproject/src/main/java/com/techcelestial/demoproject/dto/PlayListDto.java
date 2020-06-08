package com.techcelestial.demoproject.dto;

public class PlayListDto
{
    private Integer playlistID;

    private String playlistName;


    private String playlistDesc;


    private String playliststatus;

    public Integer getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(Integer playlistID) {
        this.playlistID = playlistID;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistDesc() {
        return playlistDesc;
    }

    public void setPlaylistDesc(String playlistDesc) {
        this.playlistDesc = playlistDesc;
    }

    public String getPlayliststatus() {
        return playliststatus;
    }

    public void setPlayliststatus(String playliststatus) {
        this.playliststatus = playliststatus;
    }
}
