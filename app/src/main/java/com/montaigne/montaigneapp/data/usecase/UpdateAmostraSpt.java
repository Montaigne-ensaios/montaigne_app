package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;

import java.util.HashMap;

public class UpdateAmostraSpt {
    public UpdateAmostraSpt() {}

    public void updateAmostraSpt(AmostraSpt amostraSpt) {
        AmostraSptDao amostraSptDao = new AmostraSptDao(amostraSpt.getIdFuro());
        HashMap<String, Object> hashMapAmostra = new HashMap<>();
        hashMapAmostra.put("golpe1", amostraSpt.getGolpe1());
        hashMapAmostra.put("golpe2", amostraSpt.getGolpe2());
        hashMapAmostra.put("golpe3", amostraSpt.getGolpe3());
        hashMapAmostra.put("nspt", amostraSpt.getNspt());
        amostraSptDao.updateAmostra(amostraSpt.getId(), hashMapAmostra)
                .addOnSuccessListener(unused -> Log.i("Firebase", "Sucesso ao atualizar amostra"))
                .addOnFailureListener(e -> Log.e("Firebase", "Falha ao atualizar amostra"));
    }
}
