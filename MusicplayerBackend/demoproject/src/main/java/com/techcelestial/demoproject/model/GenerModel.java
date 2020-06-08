package com.techcelestial.demoproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "generMaster")
public class GenerModel
{
    @Id
    @GeneratedValue
    @Column(name = "gener_id")
    private Integer generId;

    @Column(name = "gener_name")
    private String generName;

    @Column(name = "gener_desc")
    private String generDesc;

    @Column(name = "gener_status")
    private String generStatus;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "generModel")
    private List<SongModel> songModelList;


    public Integer getGenerId() {
        return generId;
    }

    public void setGenerId(Integer generId) {
        this.generId = generId;
    }

    public String getGenerName() {
        return generName;
    }

    public void setGenerName(String generName) {
        this.generName = generName;
    }

    public String getGenerDesc() {
        return generDesc;
    }

    public void setGenerDesc(String generDesc) {
        this.generDesc = generDesc;
    }

    public List<SongModel> getSongModelList() {
        return songModelList;
    }

    public void setSongModelList(List<SongModel> songModelList) {
        this.songModelList = songModelList;
    }

    public String getGenerStatus() {
        return generStatus;
    }

    public void setGenerStatus(String generStatus) {
        this.generStatus = generStatus;
    }


}
