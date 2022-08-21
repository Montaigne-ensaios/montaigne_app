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

    public Query getProjetos() {
        return dbReference.orderByKey();
    }

    public void insertProjeto(ProjetoSpt projeto) {
    }

    public Task<Void> updateProjeto(String id, HashMap<String, Object> hashMap) {
        return dbReference.child(id).setValue(hashMap);
    }

    public Task<Void> deleteProjetoById(String id) {
        return dbReference.child(id).removeValue();
    }
}
