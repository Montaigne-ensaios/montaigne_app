package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;

public class SaveAmostraSpt {
    private static AmostraSptDao amostraSptDao = new AmostraSptDao();

    public static void saveAmostraSpt(AmostraSpt amostraSpt) {
        amostraSptDao.insertAmostra(amostraSpt).addOnCompleteListener(task -> {
            Log.i("Firebase", "Amostra inserida com sucesso");
        }).addOnFailureListener(exception -> {
            Log.e("Firebase", "Falha ao inserir amostra");
        });
    }
}
