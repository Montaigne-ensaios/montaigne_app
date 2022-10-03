package com.montaigne.montaigneapp.data.dao.spt;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.HashMap;

public class AmostraSptDao {
    private DatabaseReference dbReference;

    public AmostraSptDao(FuroSpt furoSpt, ProjetoSpt projetoSpt) {
        FuroSptDao furoSptDao = new FuroSptDao(projetoSpt);
        dbReference = furoSptDao.getDbReference()
                .child(furoSpt.getId())
                .child("listaDeAmostras");
    }

    public DatabaseReference getDbReference() {
        return dbReference;
    }

    public Query getAmostras() {
        return dbReference.orderByKey();
    }

    public Task<Void> insertAmostra(AmostraSpt amostra) {
        amostra.setId(dbReference.push().getKey());
        return dbReference.child(amostra.getId()).setValue(amostra);
    }

    public Task<Void> updateAmostra(AmostraSpt amostraSpt) {
        return dbReference.child(amostraSpt.getId()).setValue(amostraSpt);
    }

    public Task<Void> deleteAmostraById(String id) {
        return dbReference.child(id).removeValue();
    }
}
