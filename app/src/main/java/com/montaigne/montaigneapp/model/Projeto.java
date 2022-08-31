package com.montaigne.montaigneapp.model;

import java.io.Serializable;

public abstract class Projeto implements Serializable {

    private String id;
    private String name;
    private String client;
    private String company;
    private String technician;
    private String phoneNumber;
    private String starData;
    private Coordinate coordinate;

    public Projeto() {}

    public Projeto(String id, String name, String client, String company, String technician,
                   String phoneNumber, String starData, Coordinate coordinate) {

        this.id = id;
        this.name = name;
        this.client = client;
        this.company = company;
        this.technician = technician;
        this.phoneNumber = phoneNumber;
        this.starData = starData;
        this.coordinate = coordinate;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTechnician() {
        return technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStarData() {
        return starData;
    }

    public void setStarData(String starData) {
        this.starData = starData;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
