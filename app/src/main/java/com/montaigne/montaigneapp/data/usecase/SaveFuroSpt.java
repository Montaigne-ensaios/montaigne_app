package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.model.spt.FuroSpt;

public class SaveFuroSpt {
    private static boolean result = false;
    private static FuroSptDao furoSptDao = new FuroSptDao();

    public static boolean saveFuroSpt(FuroSpt furoSpt) {
        result = false;

        furoSptDao.insertFuro(furoSpt).addOnCompleteListener(task -> {
            result = true;
        }).addOnFailureListener(exception -> {
            Log.e("Erro ao salvar", "Erro ao salvar furo de SPT");
        });

        return result;
    }

    public static void updateFuroSpt() {

    }
}
