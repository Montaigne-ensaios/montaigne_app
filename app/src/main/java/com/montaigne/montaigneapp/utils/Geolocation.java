package com.montaigne.montaigneapp.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.google.android.material.snackbar.Snackbar;
import com.montaigne.montaigneapp.model.Coordenada;

import java.io.IOException;
import java.util.List;

public class Geolocation {
    public static String TAG = "GEOLOCATION";

    public static Coordenada getLatlog(View view) {
        Activity activity = (Activity) view.getContext();
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            PermissionsManager.checkPermissions(
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    activity,
                    1);
        }

        LocationManager locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location == null){
            Snackbar.make(activity, view,
                    "Não foi possível capturar localização", Snackbar.LENGTH_SHORT).show();
        } else {
            Log.d(TAG,location.toString());
            return new Coordenada(location.getLatitude(), location.getLongitude());
        }

        return null;
    }


    public static String geocoder(Context context, @NonNull Coordenada coordenada) throws IOException {
        Geocoder geocoder = new Geocoder(context.getApplicationContext());

        double latitude = coordenada.getN();
        double longitude = coordenada.getL();

        List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);

        Address address;
        if (addresses.size() > 0) {
            address = addresses.get(0);
            String sublocality = address.getSubLocality();
            String locality = address.getLocality();

            Log.d(TAG,sublocality);
            return sublocality + ", " + locality;
        } else {
            throw new IOException("Endereço não encontrado.");
        }
    }
}

