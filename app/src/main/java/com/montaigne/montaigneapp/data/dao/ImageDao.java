package com.montaigne.montaigneapp.data.dao;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;
import com.montaigne.montaigneapp.model.ImageModel;

public class ImageDao {

    private DatabaseReference databaseReference;
    private StorageReference storageReference;
    public ImageDao() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("imagens");
    }

    public Task<DataSnapshot> getImagesUri() {
        return databaseReference.get();
    }

    public Task<Void> addImageUri(ImageModel imageModel) {
        imageModel.setId(databaseReference.push().getKey());
        return databaseReference.child(imageModel.getId()).setValue(imageModel);
    }

    public Task<Void> removeImageUri(ImageModel imageModel) {
        imageModel.setId(databaseReference.push().getKey());
        return databaseReference.child(imageModel.getId()).removeValue();
    }

    public Task<Void> updateImageUri(ImageModel imageModel) {
        imageModel.setId(databaseReference.push().getKey());
        return databaseReference.child(imageModel.getId()).setValue(imageModel);
    }
}
