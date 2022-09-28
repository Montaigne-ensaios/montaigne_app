package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;
import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;

import java.util.HashMap;

public class UpdateAmostraSptUseCase {

    public static void updateAmostraSpt(AmostraSpt amostraSpt, FuroSptDao furoSptDao) {
        AmostraSptDao amostraSptDao = new AmostraSptDao(furoSptDao.getDbReference());

        amostraSptDao.updateAmostra(amostraSpt)
                .addOnSuccessListener(unused -> Log.i("Firebase", "Sucesso ao atualizar amostra"))
                .addOnFailureListener(e -> Log.e("Firebase", "Falha ao atualizar amostra"));
    }
}
