package com.montaigne.montaigneapp.model;

import java.io.Serializable;

public class Coordenada implements Serializable {
    private double L;
    private double N;
    public Coordenada(double N, double L) {
        this.L = L;
        this.N = N;
    }

    public Coordenada() {}

    public double getL() {
        return L;
    }

    public void setL(double l) {
        L = l;
    }

    public double getN() {
        return N;
    }

    public void setN(double n) {
        N = n;
    }
}
