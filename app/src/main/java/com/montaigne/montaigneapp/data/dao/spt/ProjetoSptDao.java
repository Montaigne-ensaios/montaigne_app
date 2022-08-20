package com.montaigne.montaigneapp.data.dao.spt;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.HashMap;

public class ProjetoSptDao {
    protected DatabaseReference dbReference;
    protected ProjetoSptDao() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        dbReference = firebaseDatabase.getReference(ProjetoSpt.class.getSimpleName());
    }

    protected Query getProjects() {
        return dbReference.orderByKey();
    }

    protected void insertProject(ProjetoSpt projeto) {
    }

    protected Task<Void> updateProject(String id, HashMap<String, Object> hashMap) {
        return dbReference.child(id).setValue(hashMap);
    }

    protected Task<Void> deleteProjectById(String id) {
        return dbReference.child(id).removeValue();
    }
}
