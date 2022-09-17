package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;

public class DeleteAmostraSpt {

    public static void deleteAmostraSpt(AmostraSpt amostraSpt) {
        AmostraSptDao amostraSptDao = new AmostraSptDao(amostraSpt.getIdFuro());
        amostraSptDao.deleteAmostraById(amostraSpt.getId()).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao deletar amostra");
        }).addOnFailureListener(exception ->  {
            Log.e("Firebase", "Falha ao deletar amostra");
        });
    }
}
