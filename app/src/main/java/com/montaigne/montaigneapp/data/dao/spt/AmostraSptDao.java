package com.montaigne.montaigneapp.data.dao.spt;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;

import java.util.HashMap;

public class AmostraSptDao {
    protected DatabaseReference dbReference;
    protected AmostraSptDao() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        dbReference = firebaseDatabase.getReference(AmostraSpt.class.getSimpleName());
    }

    protected Query getSamples() {
        return dbReference.orderByKey();
    }

    protected Task<Void> insertSample(AmostraSpt amostra) {
        amostra.setId(dbReference.push().getKey());
        return dbReference.child(amostra.getId()).setValue(amostra);
    }

    protected Task<Void> updateSample(String id, HashMap<String, Object> hashMap) {
        return dbReference.child(id).setValue(hashMap);
    }

    protected Task<Void> deleteSample(String id) {
        return dbReference.child(id).removeValue();
    }
}
