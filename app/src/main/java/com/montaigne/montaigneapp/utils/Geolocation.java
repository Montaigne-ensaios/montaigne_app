package com.montaigne.montaigneapp.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;

import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.util.List;

public class Geolocation {

    private Location location;
    private LocationManager locationManager;
    private double latitude;
    private double longitude;
    String[] permissões = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
    double[] latlog;


    public double[] getLatlog(Activity activity) {


        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            PermissionsManager.checkPermissions(permissões,activity,1);
        } else {
            locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
            }
            latlog = new double[]{latitude, longitude};
        }

        return latlog;
    }


    public Address Geocoder(Activity activity, double[] latlog) throws IOException {
        Geocoder geocoder;
        Address address = null;
        List<Address> addresses;
        double latitude = latlog[1];
        double longitude = latlog[2];

        geocoder = new Geocoder(activity.getApplicationContext());

        addresses = geocoder.getFromLocation(latitude, longitude, 1);

        if (addresses.size() > 0) {
            address = addresses.get(0);
        }
        return address;
    }
}

