package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;

public class SaveAmostraSpt {

    public void saveAmostraSpt(AmostraSpt amostraSpt) {
        AmostraSptDao amostraSptDao = new AmostraSptDao(amostraSpt.getIdFuro());
        amostraSptDao.insertAmostra(amostraSpt).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao salvar amostra");
        }).addOnFailureListener(exception -> {
            Log.e("Firebase", "Falha ao salvar amostra");
        });
    }
}
