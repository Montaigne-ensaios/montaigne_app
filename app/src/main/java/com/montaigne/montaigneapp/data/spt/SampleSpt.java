package com.montaigne.montaigneapp.data.spt;

public class SampleSpt {
    private long id, idSondagem;
    private int blows1, blows2, blows3, nspt;

    public SampleSpt() {
    }

    public SampleSpt(long id, long idSondagem, int blows1, int blows2, int blows3, int nspt) {
        this.id = id;
        this.idSondagem = idSondagem;
        this.blows1 = blows1;
        this.blows2 = blows2;
        this.blows3 = blows3;
        this.nspt = nspt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdSondagem() {
        return idSondagem;
    }

    public void setIdSondagem(long idSondagem) {
        this.idSondagem = idSondagem;
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
