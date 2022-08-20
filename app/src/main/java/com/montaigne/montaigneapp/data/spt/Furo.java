package com.montaigne.montaigneapp.data.spt;

import java.util.Date;
import java.util.List;

public class Furo {
    private String id;
    private String code;
    private float waterLevel, holeLevel;
    private Date startDate, endDate;
    private List<AmostraSpt> samples;

    public Furo() {
    }

    public Furo(String id, String code, float waterLevel, float holeLevel, Date startDate, Date endDate, List<AmostraSpt> samples) {
        this.id = id;
        this.code = code;
        this.waterLevel = waterLevel;
        this.holeLevel = holeLevel;
        this.startDate = startDate;
        this.endDate = endDate;
        this.samples = samples;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<AmostraSpt> getSamples() {
        return samples;
    }

    public void setSamples(List<AmostraSpt> samples) {
        this.samples = samples;
    }
}
