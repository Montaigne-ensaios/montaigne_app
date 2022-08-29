package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.model.spt.FuroSpt;

public class SaveFuroSpt {
    private static FuroSptDao furoSptDao = new FuroSptDao();

    public void saveFuroSpt(FuroSpt furoSpt) {
        furoSptDao.insertFuro(furoSpt).addOnCompleteListener(task -> {
            Log.i("Firebae", "Sucesso ao salvar furo");
        }).addOnFailureListener(exception -> {
            Log.e("Firebase", "Erro ao salvar furo");
        });
    }
}
