package com.montaigne.montaigneapp.data.usecase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Query;
import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.model.spt.FuroSpt;

import java.util.HashMap;
import java.util.Map;

public class GetFuroSpt {
    private static FuroSptDao furoSptDao = new FuroSptDao();

    public static void getFuroSpt() {

    }

    public static Map<String, FuroSpt> getProjetosSpt() {
        Map<String, FuroSpt> furos = new HashMap<>();
        Query furoQuery = furoSptDao.getFuros();

        furoQuery.get().addOnCompleteListener(dataSnapshotTask -> {
            for (DataSnapshot child : dataSnapshotTask.getResult().getChildren()) {
                FuroSpt furoSpt = child.getValue(FuroSpt.class);
                furos.put(child.getKey(), furoSpt);
            }
        });

        return furos;
    }
}
