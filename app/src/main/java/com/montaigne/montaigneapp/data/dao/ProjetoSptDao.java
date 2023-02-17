package com.montaigne.montaigneapp.data.dao;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class ProjetoSptDao {
    private final DatabaseReference dbReference;
    private static ProjetoSptDao singleton;

    private ProjetoSptDao(String userId) {
        FirebaseDatabase fdb = FirebaseDatabase.getInstance();
        fdb.setPersistenceEnabled(true);
        dbReference = fdb.getReference().child("projetos").child("spt").child(userId);
        dbReference.keepSynced(true);
    }

    public static ProjetoSptDao getInstance() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        if ((singleton == null) && (firebaseAuth.getCurrentUser() != null))
            singleton = new ProjetoSptDao(firebaseAuth.getUid());
        return singleton;
    }

    public DatabaseReference getDbReference() {
        return dbReference;
    }

    public Task<DataSnapshot> getProjetos() {
        return dbReference.get();
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
