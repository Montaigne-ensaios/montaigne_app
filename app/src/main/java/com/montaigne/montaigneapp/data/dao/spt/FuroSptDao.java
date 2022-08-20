package com.montaigne.montaigneapp.data.dao.spt;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.montaigne.montaigneapp.model.spt.FuroSpt;

import java.util.HashMap;

public class FuroSptDao {
    protected DatabaseReference dbReference;
    protected FuroSptDao() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        dbReference = firebaseDatabase.getReference(FuroSpt.class.getSimpleName());
    }

    protected Query getPolls() {
        return dbReference.orderByKey();
    }

    protected Task<Void> insertPoll(FuroSpt furo) {
        furo.setId(dbReference.push().getKey());
        return dbReference.child(furo.getId()).setValue(furo);
    }

    protected Task<Void> updatePoll(String id, HashMap<String, Object> hashMap) {
        return dbReference.child(id).setValue(hashMap);
    }

    protected Task<Void> deletePollById(String id) {
        return dbReference.child(id).removeValue();
    }
}
