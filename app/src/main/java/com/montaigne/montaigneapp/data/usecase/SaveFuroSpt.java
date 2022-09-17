package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.model.spt.FuroSpt;

public class SaveFuroSpt {

    public void saveFuroSpt(FuroSpt furoSpt) {
        FuroSptDao furoSptDao = new FuroSptDao(furoSpt.getIdProjeto());
        furoSptDao.insertFuro(furoSpt).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao salvar furo");
        }).addOnFailureListener(exception -> {
            Log.e("Firebase", "Falha ao salvar furo");
        });
    }
}
