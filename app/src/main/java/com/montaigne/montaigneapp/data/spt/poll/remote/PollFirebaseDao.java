package com.montaigne.montaigneapp.data.spt.poll.remote;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.montaigne.montaigneapp.data.spt.Furo;

import java.util.HashMap;

public class PollFirebaseDao {
    protected DatabaseReference dbReference;
    protected PollFirebaseDao() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        dbReference = firebaseDatabase.getReference(Furo.class.getSimpleName());
    }

    protected Query getPolls() {
        return dbReference.orderByKey();
    }

    protected Task<Void> insertPoll(Furo furo) {
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
