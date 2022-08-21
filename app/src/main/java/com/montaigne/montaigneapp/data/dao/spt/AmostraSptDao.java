package com.montaigne.montaigneapp.data.dao.spt;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;

import java.util.HashMap;

public class AmostraSptDao {
    private DatabaseReference dbReference;

    public AmostraSptDao() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        dbReference = firebaseDatabase.getReference(AmostraSpt.class.getSimpleName());
    }

    public Query getSamples() {
        return dbReference.orderByKey();
    }

    public Task<Void> insertSample(AmostraSpt amostra) {
        amostra.setId(dbReference.push().getKey());
        return dbReference.child(amostra.getId()).setValue(amostra);
    }

    public Task<Void> updateSample(String id, HashMap<String, Object> hashMap) {
        return dbReference.child(id).setValue(hashMap);
    }

    public Task<Void> deleteSample(String id) {
        return dbReference.child(id).removeValue();
    }
}
