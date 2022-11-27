package com.montaigne.montaigneapp.model.granulometria;

public class Peneira {
    private float abertura;
    private float massaRetida;
    private float massaInicial;

    public Peneira() {
    }

    public Peneira(float massa, float abertura, float massaRetida) {
        this.massaInicial = massa;
        this.abertura = abertura;
        this.massaRetida = massaRetida;
    }

    public float getMassaInicial() {
        return massaInicial;
    }

    public void setMassaInicial(float massaInicial) {
        this.massaInicial = massaInicial;
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
}
