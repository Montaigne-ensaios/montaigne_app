package com.montaigne.montaigneapp.activity.carimboDefinitivo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.google.firebase.storage.FirebaseStorage;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.montaigne.montaigneapp.activity.home.HomeActivity;
import com.montaigne.montaigneapp.activity.spt.carimboUnico.CarimboUnicoActivity;
import com.montaigne.montaigneapp.data.usecase.ImageUseCase;
import com.montaigne.montaigneapp.model.ImageModel;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.Map;

public class CarimboDefinitivoVM extends ViewModel {
    // método de getData (validação de entradas)

    protected void continuarCarimboButtonListener(View view, Map<String, EditText> fields, Uri imagemUri) {
        Intent intent = new Intent(view.getContext(), CarimboUnicoActivity.class);

        /*
        intent.putExtra("Tecnico", activity.fields.get ("Tecnico"). getText(). toString());
        intent.putExtra("Empresa", activity.fields.get ("Empresa"). getText(). toString());
        intent.putExtra("Contato", activity.fields.get ("Contato"). getText(). toString());
        intent.putExtra("Cliente", activity.fields.get ("Cliente"). getText(). toString());
        intent.putExtra("LocalObra", activity.fields.get ("LocalObra"). getText(). toString());
        intent.putExtra("nFuros", activity.fields.get ("QuantidadeFuros"). getText(). toString());
        intent.putExtra("ReferenciaNivel", activity.fields.get ("ReferenciaNivel"). getText(). toString());
        intent.putExtra("NomeProjeto", activity.fields.get ("NomeProjeto"). getText(). toString());
         */

        String nome = fields.get("NomeProjeto").getText().toString();
        String empresa = fields.get("Empresa").getText().toString();
        String tecnico = fields.get("Tecnico").getText().toString();
        String cotato = fields.get("Contato").getText().toString();
        String cliente = fields.get("Cliente").getText().toString();
        String local = fields.get("LocalObra").getText().toString();
        //String nFuros = fields.get("nFuros").getText().toString();
        String referenciaNivel = fields.get("ReferenciaNivel").getText().toString();


        ProjetoSpt projetoSpt = new ProjetoSpt();
        projetoSpt.setNome(nome);
        projetoSpt.setEmpresa(empresa);
        projetoSpt.setCliente(cliente);
        projetoSpt.setTecnico(tecnico);
        projetoSpt.setNumeroDeTelefone(cotato);
        projetoSpt.setEmpresa(empresa);

        intent.putExtra("ProjetoSpt", projetoSpt);

        view.getContext().startActivity(intent);
        if (imagemUri != null) {
            ImageModel imageModel = new ImageModel();
            imageModel.setUriImagem(imagemUri.toString());
            uploadImagem(imageModel);
        }
    }

    protected void homeButtonListener(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), HomeActivity.class));
        //todo:limpar tasks;
    }

    protected void addPhotoButtonListener(Activity activity) {
        Dexter.withContext(activity.getApplicationContext())
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        Intent intentGaleria = new Intent();
                        intentGaleria.setType("image/*");
                        intentGaleria.setAction(Intent.ACTION_GET_CONTENT);
                        activity.startActivityForResult(intentGaleria, 100);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
    }

    protected void uploadImagem(ImageModel imageModel) {
        ImageUseCase.saveImage(imageModel);
    }
}
