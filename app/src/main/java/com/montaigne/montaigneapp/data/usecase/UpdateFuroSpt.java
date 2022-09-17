package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.model.spt.FuroSpt;

import java.util.HashMap;

public class UpdateFuroSpt {
    public UpdateFuroSpt() {
    }

    public void updateFuroSpt(FuroSpt furoSpt) {
        FuroSptDao furoSptDao = new FuroSptDao(furoSpt.getIdProjeto());
        HashMap<String, Object> hashMapFuro = new HashMap<>();
        hashMapFuro.put("codigo", furoSpt.getCodigo());
        hashMapFuro.put("nivelDAgua", furoSpt.getNivelDAgua());
        hashMapFuro.put("nivelDoFuro", furoSpt.getNivelDoFuro());
        hashMapFuro.put("listaDeAmostras", furoSpt.getListaDeAmostras());
        furoSptDao.updateFuro(furoSpt.getId(), hashMapFuro)
                .addOnSuccessListener(unused -> Log.i("Firebase", "Sucesso ao atualizar furo"))
                .addOnFailureListener(e -> Log.e("Firebase", "Falha ao atualizar furo"));
    }
}
