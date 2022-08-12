package com.montaigne.montaigneapp.data.spt;

import java.util.Date;

public class PollSpt {
    private long id, idProject;
    private float waterLevel, holeLevel;
    private String poll;
    private Date startDate;

    public PollSpt() {
    }

    public PollSpt(long id, long idProject, float waterLevel, float holeLevel, String poll, Date startDate) {
        this.id = id;
        this.idProject = idProject;
        this.waterLevel = waterLevel;
        this.holeLevel = holeLevel;
        this.poll = poll;
        this.startDate = startDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdProject() {
        return idProject;
    }

    public void setIdProject(long idProject) {
        this.idProject = idProject;
    }

    public float getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(float waterLevel) {
        this.waterLevel = waterLevel;
    }

    public float getHoleLevel() {
        return holeLevel;
    }

    public void setHoleLevel(float holeLevel) {
        this.holeLevel = holeLevel;
    }

    public String getPoll() {
        return poll;
    }

    public void setPoll(String poll) {
        this.poll = poll;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
