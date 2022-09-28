package com.montaigne.montaigneapp.data.dao.spt;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.HashMap;

public class ProjetoSptDao {
    private DatabaseReference dbReference;

    public ProjetoSptDao() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        dbReference = firebaseDatabase.getReference(ProjetoSpt.class.getSimpleName());
    }

    public DatabaseReference getDbReference() {
        return dbReference;
    }

    public Query getProjetos() {
        return dbReference.orderByKey();
    }

    public Task<Void> insertProjeto(ProjetoSpt projeto) {
        projeto.setId(dbReference.push().getKey());
        return dbReference.child(projeto.getId()).setValue(projeto);
    }

    public Task<Void> updateProjeto(ProjetoSpt projetoSpt) {
        return dbReference.child(projetoSpt.getId()).setValue(projetoSpt);
    }

    public Task<Void> deleteProjetoById(String id) {
        return dbReference.child(id).removeValue();
    }
}
