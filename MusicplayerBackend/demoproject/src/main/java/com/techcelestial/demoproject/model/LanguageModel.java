package com.techcelestial.demoproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "language")
public class LanguageModel
{
    @Id
    @GeneratedValue
    @Column(name = "language_id")
    private Integer languageId;

    @Column(name = "language_name")
    private String languageName;

    @Column(name = "language_status")
    private String languageStatus;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "languageModel")
    private List<SongModel> songModelList;


    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }


    public List<SongModel> getSongModelList() {
        return songModelList;
    }

    public void setSongModelList(List<SongModel> songModelList) {
        this.songModelList = songModelList;
    }

    public String getLanguageStatus() {
        return languageStatus;
    }

    public void setLanguageStatus(String languageStatus) {
        this.languageStatus = languageStatus;
    }


}
