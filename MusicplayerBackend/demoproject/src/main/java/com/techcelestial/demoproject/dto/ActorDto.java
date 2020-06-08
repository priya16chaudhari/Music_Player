package com.techcelestial.demoproject.dto;

public class ActorDto {

    private Integer actorID;

    private String actorName;

    private String actorDesc;


    private String actorstatus;

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
}
