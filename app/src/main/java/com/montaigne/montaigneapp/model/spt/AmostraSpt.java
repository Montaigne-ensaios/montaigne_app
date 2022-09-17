package com.montaigne.montaigneapp.model.spt;

public class AmostraSpt {
    private String id;
    private String idFuro;
    private int golpe1, golpe2, golpe3, nspt;

    public AmostraSpt() {
    }

    public AmostraSpt(String id, String idFuro, int golpe1, int golpe2, int golpe3, int nspt) {
        this.id = id;
        this.idFuro = idFuro;
        this.golpe1 = golpe1;
        this.golpe2 = golpe2;
        this.golpe3 = golpe3;
        this.nspt = golpe2 + golpe3;
    }

    public String getIdFuro() {
        return idFuro;
    }

    public void setIdFuro(String idFuro) {
        this.idFuro = idFuro;
    }

    public void setGolpe2(int golpe2) {
        this.golpe2 = golpe2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGolpe1() {
        return this.golpe1;
    }

    public void setGolpe1(int golpe1) {
        this.golpe1 = golpe1;
    }

    public int getGolpe2() {
        return golpe2;
    }

    public int getGolpe3() {
        return this.golpe3;
    }

    public void setGolpe3(int golpe3) {
        this.golpe3 = golpe3;
    }

    public int getNspt() {
        return nspt;
    }

    public void setNspt(int golpe2, int golpe3) {
        this.nspt = golpe2 + golpe3;
    }
}
