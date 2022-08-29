package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;

public class DeleteAmostraSpt {
    private static AmostraSptDao amostraSptDao = new AmostraSptDao();

    public static void deleteAmostraSpt(String id) {
        amostraSptDao.deleteAmostraById(id).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao deletar amostra");
        }).addOnFailureListener(exception ->  {
            Log.e("Firebase", "Erro ao deletar amostra");
        });
    }
}
