package com.montaigne.montaigneapp.model;

import java.io.Serializable;

public class Coordenada implements Serializable {
    private int L;
    private int N;
    public Coordenada(int L, int N) {
        this.L = L;
        this.N = N;
    }

    public Coordenada() {}

    public int getL() {
        return L;
    }

    public void setL(int l) {
        L = l;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }
}
