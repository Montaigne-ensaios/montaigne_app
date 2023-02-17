package com.montaigne.montaigneapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionsManager {

    public static Boolean checkPermissions(String[] Permissions, Activity activity, int requestcode){

        if(Build.VERSION.SDK_INT>=23){

            List<String> ListofcheckPermissions = new ArrayList<>();

            for(String permission:Permissions){

                Boolean thishavePermission = ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;

                if(!thishavePermission) ListofcheckPermissions.add(permission);
            }

            if(ListofcheckPermissions.isEmpty()) return true;

            String[] newsPermisions = new String[ListofcheckPermissions.size()];

            ListofcheckPermissions.toArray(newsPermisions);

            ActivityCompat.requestPermissions(activity,newsPermisions,requestcode);

        }

        return true;
    }


}
