package com.montaigne.montaigneapp.data.dao.spt;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.montaigne.montaigneapp.model.spt.FuroSpt;

import java.util.HashMap;

public class FuroSptDao {
    private DatabaseReference dbReference;

    public FuroSptDao() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        dbReference = firebaseDatabase.getReference(FuroSpt.class.getSimpleName());
    }

    public DatabaseReference getDbReference() {
        return dbReference;
    }

    public void setDbReference(DatabaseReference dbReference) {
        this.dbReference = dbReference;
    }

    public Query getFuros() {
        return dbReference.orderByKey();
    }

    public Task<Void> insertFuro(FuroSpt furo) {
        furo.setId(dbReference.push().getKey());
        return dbReference.child(furo.getId()).setValue(furo);
    }

    public Task<Void> updateFuro(String id, HashMap<String, Object> hashMap) {
        return dbReference.child(id).setValue(hashMap);
    }

    public Task<Void> deleteFuroById(String id) {
        return dbReference.child(id).removeValue();
    }
}
