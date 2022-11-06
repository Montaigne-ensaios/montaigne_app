package com.montaigne.montaigneapp.model;

import android.net.Uri;

public class ImageModel {
    private String uriImagem;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImageModel() {}

    public ImageModel(String uriImagem) {
        this.uriImagem = uriImagem;
    }

    public void setUriImagem(String uriImagem) {
        this.uriImagem = uriImagem;
    }

    public String getUriImagem() {
        return this.uriImagem;
    }
}
