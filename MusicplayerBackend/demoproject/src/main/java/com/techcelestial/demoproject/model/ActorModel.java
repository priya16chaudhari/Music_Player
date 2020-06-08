package com.techcelestial.demoproject.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "actorMaster")
public class ActorModel
{

    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    private Integer actorID;

    @Column(name = "actor_name")
    private String actorName;

    @Column(name = "actor_desc")
    private String actorDesc;


    @Column(name = "actor_status")
    private String actorstatus;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "actorModel")
    private List<SongModel> songModelList;




    public Integer getActorID() {
        return actorID;
    }

    public void setActorID(Integer actorID) {
        this.actorID = actorID;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorDesc() {
        return actorDesc;
    }

    public void setActorDesc(String actorDesc) {
        this.actorDesc = actorDesc;
    }

    public String getActorstatus() {
        return actorstatus;
    }

    public void setActorstatus(String actorstatus) {
        this.actorstatus = actorstatus;
    }


    public List<SongModel> getSongModelList() {
        return songModelList;
    }

    public void setSongModelList(List<SongModel> songModelList) {
        this.songModelList = songModelList;
    }
}
