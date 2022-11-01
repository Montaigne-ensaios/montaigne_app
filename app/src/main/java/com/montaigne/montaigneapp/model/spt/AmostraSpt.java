package com.montaigne.montaigneapp.model.spt;

import java.io.Serializable;

public class AmostraSpt implements Serializable {
    private String id;
    private String idFuro;
    private float profundidade;
    // profundidade dentro do furo, em que esta amostra está sendo retirada
    private int golpe1, golpe2, golpe3;
    // quantos golpes do martelo foram necessários para obter as penetrações abaixo
    private float penatracao1, penatracao2, penatracao3;
    // quanto cada segmento do amsotrador penetrou no solo, em cm
    private String tipoSolo1, tipoSolo2, tipoSolo3;  // opcional
    // string detalhando cor, cosnistência e detalhamento de solo

    public AmostraSpt() {
    }

    public AmostraSpt(String id, String idFuro,
                      int golpe1, int golpe2, int golpe3,
                      float penatracao1, float penatracao2, float penatracao3,
                      String tipoSolo1, String tipoSolo2, String tipoSolo3) {
        this.id = id;
        this.idFuro = idFuro;
        this.golpe1 = golpe1;
        this.golpe2 = golpe2;
        this.golpe3 = golpe3;
        this.penatracao1 = penatracao1;
        this.penatracao2 = penatracao2;
        this.penatracao3 = penatracao3;
        this.tipoSolo1 = tipoSolo1;
        this.tipoSolo2 = tipoSolo2;
        this.tipoSolo3 = tipoSolo3;
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
        return golpe2 + golpe3;
    }

    public float getPenatracao1() {
        return penatracao1;
    }

    public void setPenatracao1(float penatracao1) {
        this.penatracao1 = penatracao1;
    }

    public float getPenatracao2() {
        return penatracao2;
    }

    public void setPenatracao2(float penatracao2) {
        this.penatracao2 = penatracao2;
    }

    public float getPenatracao3() {
        return penatracao3;
    }

    public void setPenatracao3(float penatracao3) {
        this.penatracao3 = penatracao3;
    }

    public String getTipoSolo1() {
        return tipoSolo1;
    }

    public void setTipoSolo1(String tipoSolo1) {
        this.tipoSolo1 = tipoSolo1;
    }

    public String getTipoSolo2() {
        return tipoSolo2;
    }

    public void setTipoSolo2(String tipoSolo2) {
        this.tipoSolo2 = tipoSolo2;
    }

    public String getTipoSolo3() {
        return tipoSolo3;
    }

    public void setTipoSolo3(String tipoSolo3) {
        this.tipoSolo3 = tipoSolo3;
    }
}
