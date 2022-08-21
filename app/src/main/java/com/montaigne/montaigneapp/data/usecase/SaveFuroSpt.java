package com.montaigne.montaigneapp.data.usecase;

import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.model.spt.FuroSpt;

public class SaveFuroSpt {
    private static FuroSptDao furoSptDao = new FuroSptDao();

    public void saveFuroSpt(FuroSpt furoSpt) {
        furoSptDao.insertFuro(furoSpt).addOnCompleteListener(task -> {

        }).addOnFailureListener(exception -> {

        });
    }

    public void updateFuroSpt() {

    }
}
