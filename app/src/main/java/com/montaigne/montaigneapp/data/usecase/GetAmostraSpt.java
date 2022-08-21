package com.montaigne.montaigneapp.data.usecase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Query;
import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;

import java.util.HashMap;
import java.util.Map;

public class GetAmostraSpt {
    public static AmostraSptDao amostraSptDao = new AmostraSptDao();

    public static void getProjetoSpt() {

    }

    public static Map<String, AmostraSpt> getProjetosSpt() {
        Map<String, AmostraSpt> amostras = new HashMap<>();
        Query amostraQuery = amostraSptDao.getAmostras();

        amostraQuery.get().addOnCompleteListener(dataSnapshotTask -> {
            for (DataSnapshot child : dataSnapshotTask.getResult().getChildren()) {
                AmostraSpt amostraSpt = child.getValue(AmostraSpt.class);
                amostras.put(child.getKey(), amostraSpt);
            }
        });

        return amostras;
    }
}
