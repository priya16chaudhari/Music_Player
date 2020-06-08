package com.techcelestial.demoproject.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "playList")
public class PlayListModel
{


    @Id
    @GeneratedValue
    @Column(name = "playlist_id")
    private Integer playlistID;

    @Column(name = "playlist_name")
    private String playlistName;

    @Column(name = "playlist_desc")
    private String playlistDesc;

    @Column(name = "status")
    private String playliststatus;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "playListModel")
    private List<SongModel> songModelList;




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

    public List<SongModel> getSongModelList() {
        return songModelList;
    }

    public void setSongModelList(List<SongModel> songModelList) {
        this.songModelList = songModelList;
    }
}
