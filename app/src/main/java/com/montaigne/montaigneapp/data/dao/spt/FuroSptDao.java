package com.montaigne.montaigneapp.data.dao.spt;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.HashMap;
import java.util.List;

public class FuroSptDao {
    private DatabaseReference dbReference;
    private ProjetoSpt projetoSpt;

    public FuroSptDao(ProjetoSpt projetoSpt) {
        ProjetoSptDao projetoSptDao = new ProjetoSptDao();
        this.projetoSpt = projetoSpt;
        dbReference = projetoSptDao.getDbReference()
                                    .child(projetoSpt.getId())
                                    .child("listaDeFuros");
    }

    public DatabaseReference getDbReference() {
        return dbReference;
    }

    public Task<Void> insertListaDeFuros(List<FuroSpt> listaDeFuros) {
        return dbReference.child(projetoSpt.getId()).child("listaDeFuros").setValue(listaDeFuros);
    }

    public Query readListaDeFuros() {
        return dbReference.child(projetoSpt.getId()).child("listaDeFuros").orderByKey();
    }
    public Task<Void> updateListaDeFuros(List<FuroSpt> listaDeFuros) {
        return dbReference.child(projetoSpt.getId()).child("listaDeFuros").setValue(listaDeFuros);
    }

    public Task<Void> deleteListaDeFuros() {
        return dbReference.child(projetoSpt.getId()).child("listaDeFuros").removeValue();
    }
}
