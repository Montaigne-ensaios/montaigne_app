package com.montaigne.montaigneapp.model.granulometria;

public class Peneira {
    private float abertura;
    private float massaRetida;
    private float fracaoRetida;
    private float porcentagemRetida;
    private float fracaoPassante;
    private float porcentagemPassante;

    public Peneira() {
    }

    public Peneira(float abertura, float massaRetida, float fracaoRetida, float porcentagemRetida,
                   float fracaoPassante, float porcentagemPassante) {
        this.abertura = abertura;
        this.massaRetida = massaRetida;
        this.fracaoRetida = fracaoRetida;
        this.porcentagemRetida = porcentagemRetida;
        this.fracaoPassante = fracaoPassante;
        this.porcentagemPassante = porcentagemPassante;
    }

    public float getAbertura() {
        return abertura;
    }

    public void setAbertura(float abertura) {
        this.abertura = abertura;
    }

    public float getMassaRetida() {
        return massaRetida;
    }

    public void setMassaRetida(float massaRetida) {
        this.massaRetida = massaRetida;
    }

    public float getFracaoRetida() {
        return fracaoRetida;
    }

    public void setFracaoRetida(float fracaoRetida) {
        this.fracaoRetida = fracaoRetida;
    }

    public float getPorcentagemRetida() {
        return porcentagemRetida;
    }

    public void setPorcentagemRetida(float porcentagemRetida) {
        this.porcentagemRetida = porcentagemRetida;
    }

    public float getFracaoPassante() {
        return fracaoPassante;
    }

    public void setFracaoPassante(float fracaoPassante) {
        this.fracaoPassante = fracaoPassante;
    }

    public float getPorcentagemPassante() {
        return porcentagemPassante;
    }

    public void setPorcentagemPassante(float porcentagemPassante) {
        this.porcentagemPassante = porcentagemPassante;
    }
}
