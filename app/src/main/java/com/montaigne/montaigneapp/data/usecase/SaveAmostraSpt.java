package com.montaigne.montaigneapp.data.usecase;

import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;

public class SaveAmostraSpt {
    private static AmostraSptDao amostraSptDao = new AmostraSptDao();

    public void saveAmostraSpt(AmostraSpt amostraSpt) {
        amostraSptDao.insertAmostra(amostraSpt).addOnCompleteListener(task -> {

        }).addOnFailureListener(exception -> {

        });
    }

    public void updateAmostraSpt() {
        
    }
}
