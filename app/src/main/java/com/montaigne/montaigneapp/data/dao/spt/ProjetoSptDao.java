package com.montaigne.montaigneapp.data.dao.spt;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.HashMap;
import java.util.List;

public class ProjetoSptDao {
    private DatabaseReference dbReference;

    public ProjetoSptDao() {
        dbReference = FirebaseDatabase.getInstance().getReference().child("projetos").child("spt");
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
