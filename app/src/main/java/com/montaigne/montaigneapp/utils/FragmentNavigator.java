package com.montaigne.montaigneapp.utils;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;
import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.ui.home.HomeActivity;

import java.util.HashSet;
import java.util.Objects;

public class FragmentNavigator {
    private static final String TAG = "Navigation Lock Handler";
    private static final HashSet<String> emptyRequiredFields = new HashSet<>();
    // hashset garante que os campos não vão se repetir. Única variável global do projeto

    public static void addEmptyFieldId(String fieldId) {
        Log.d(TAG, "Adicionando ao set: " + fieldId);
        emptyRequiredFields.add(fieldId);
    }

    public static void removeEmptyFieldId(String fieldId) {
        Log.d(TAG, "Removendo do set: " + fieldId);
        emptyRequiredFields.remove(fieldId);
    }

    public static boolean hasEmptyFields() {
        return emptyRequiredFields.size() != 0;
    }

    public static void notifyEmptyFields(View view) {
        Snackbar.make(view,
                R.string.msg_snackbar_campos_vazios,
                Snackbar.LENGTH_LONG).show();
    }

    public static void intentHome(@NonNull View view) {
        if (emptyRequiredFields.size() == 0) {
            Intent intent = new Intent(view.getContext(), HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            view.getContext().startActivity(intent);
        } else {
            notifyEmptyFields(view);
        }
    }

    public static Fragment getCurrentFragment(@NonNull FragmentManager manager) {
        return Objects.requireNonNull(
                manager.getPrimaryNavigationFragment()
        ).getChildFragmentManager().getFragments().get(0);
    }

    public static void navigate(int actionId, @NonNull FragmentManager manager,
                                int containerId,
                                Bundle args) {
        if (emptyRequiredFields.size() == 0)
            ((NavHostFragment) Objects.requireNonNull(manager.findFragmentById(containerId)))
                    .getNavController().navigate(actionId, args);
        else {
            notifyEmptyFields(getCurrentFragment(manager).requireView());
        }
    }

    public static void navigate(int actionId, FragmentManager manager, int containerId) {
        navigate(actionId, manager, containerId, null);
    }

}
