package com.montaigne.montaigneapp.model;

import android.net.Uri;

public class ImageModel {
    private Uri uriImagem;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImageModel() {}

    public ImageModel(Uri uriImagem) {
        this.uriImagem = uriImagem;
    }

    public void setUriImagem(Uri uriImagem) {
        this.uriImagem = uriImagem;
    }

    public Uri getUriImagem() {
        return this.uriImagem;
    }
}
