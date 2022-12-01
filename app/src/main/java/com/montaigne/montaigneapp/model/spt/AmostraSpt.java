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

    public AmostraSpt() {
    }

    public AmostraSpt(String id, String idFuro,
                      int golpe1, int golpe2, int golpe3,
                      float penatracao1, float penatracao2, float penatracao3,
                      float profundidade) {
        this.id = id;
        this.idFuro = idFuro;
        this.golpe1 = golpe1;
        this.golpe2 = golpe2;
        this.golpe3 = golpe3;
        this.penatracao1 = penatracao1;
        this.penatracao2 = penatracao2;
        this.penatracao3 = penatracao3;
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

    public float getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(float profundidade) {
        this.profundidade = profundidade;
    }
}
