package com.montaigne.montaigneapp.ui.auth;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.ui.home.HomeActivity;

public class AuthVM extends ViewModel {
    private final String TAG = "AuthActivity";

    protected void toHome(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }
}
