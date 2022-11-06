package com.montaigne.montaigneapp.data.usecase;

import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.montaigne.montaigneapp.data.dao.ImageDao;
import com.montaigne.montaigneapp.model.ImageModel;

public class ImageUseCase {

    private static FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
    private static StorageReference storageReference = firebaseStorage.getReference();
    public ImageUseCase() {}

    public static void saveImage(ImageModel imageModel) {
        storageReference
                .child(Long.toString(System.currentTimeMillis()))
                .putFile(Uri.parse(imageModel.getUriImagem()))
                .addOnSuccessListener(taskSnapshot -> {
                    ImageDao imageDao = new ImageDao();
                    imageDao.addImageUri(imageModel).addOnCompleteListener(unused -> Log.i("Firebase", "Sucesso ao salvar imagem")).addOnFailureListener(e -> Log.e("Firebase", "Falha ao salvar imagem"));

                })
                .addOnProgressListener(snapshot -> {

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("FirebaseStorage", "Erro ao salvar imagem");
                    }
                });
    }

    public static void deleteImage(String id) {
        storageReference.child(id).delete().addOnCompleteListener(unused -> {
            ImageDao imageDao = new ImageDao();
            imageDao.removeImageUri(id).addOnCompleteListener(unused1 -> Log.i("Firebase", "Sucesso ao deletar imagem")).addOnFailureListener(e -> Log.e("Firebase", "Falha ao deletar imagem"));
            Log.i("FirebaseStorage", "Sucesso ao deletar imagem");
        }).addOnFailureListener(e -> Log.e("FirebaseStorage", "Erro ao deletar imagem"));
    }
}
