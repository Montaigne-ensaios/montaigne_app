package com.montaigne.montaigneapp.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import androidx.core.content.FileProvider;

import java.io.File;

public class ExportFile {

    final static String mimeType =
            "application/excel";

    private static File diretorio;
    private static File xlsxDir;
    private static File[] arquivoxlsx;

    public static Uri getUri(Activity activity) {
        Uri getUri = null;
        //concertar erro do null exeption
        try {
            xlsxDir = new File(activity.getCacheDir(), "xlsx");
            arquivoxlsx = xlsxDir.listFiles();
            if (arquivoxlsx != null) {
                getUri = FileProvider.getUriForFile(activity,
                        "com.montaigne.montaigneapp.fileprovider", arquivoxlsx[0]);
            }else{
                throw new NullPointerException("Sem arquivos no diretorio");
            }
        }catch (NullPointerException e){
            e.fillInStackTrace();
        }

        return getUri;

    }

    public static void shareXlsx(Activity activity){

        Uri arquivoUri = getUri(activity);

        Intent sendIntent = new Intent().setAction(Intent.ACTION_SEND);
        //sendIntent.putExtra(Intent.EXTRA_TEXT,"PLANILHA");
        sendIntent.setType("application/*");
        sendIntent.putExtra(Intent.EXTRA_MIME_TYPES,mimeType);
        sendIntent.addCategory(Intent.CATEGORY_OPENABLE);

        if(arquivoUri != null){
            sendIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            sendIntent.putExtra(Intent.EXTRA_STREAM, arquivoUri);
        }

        Intent shareIntent = Intent.createChooser(sendIntent,"Compartilhar Xlsx");
        activity.startActivity(shareIntent);

    }

}
