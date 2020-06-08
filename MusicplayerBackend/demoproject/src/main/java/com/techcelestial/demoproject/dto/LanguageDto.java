package com.techcelestial.demoproject.dto;

public class LanguageDto {
    private Integer languageId;


    private String languageName;


    private String languageStatus;


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

    public String getLanguageStatus() {
        return languageStatus;
    }

    public void setLanguageStatus(String languageStatus) {
        this.languageStatus = languageStatus;
    }
}