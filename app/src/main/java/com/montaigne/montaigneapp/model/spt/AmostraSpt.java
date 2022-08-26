package com.montaigne.montaigneapp.model.spt;

public class AmostraSpt {
    private String id;
    private int blows1, blows2, blows3, nspt;

    public AmostraSpt() {
    }

    public AmostraSpt(String id, int blows1, int blows2, int blows3, int nspt) {
        this.id = id;
        this.blows1 = blows1;
        this.blows2 = blows2;
        this.blows3 = blows3;
        this.nspt = nspt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBlows1() {
        return blows1;
    }

    public void setBlows1(int blows1) {
        this.blows1 = blows1;
    }

    public int getBlows2() {
        return blows2;
    }

    public void setBlows2(int blows2) {
        this.blows2 = blows2;
    }

    public int getBlows3() {
        return blows3;
    }

    public void setBlows3(int blows3) {
        this.blows3 = blows3;
    }

    public int getNspt() {
        return nspt;
    }

    public void setNspt(int nspt) {
        this.nspt = nspt;
    }
}
