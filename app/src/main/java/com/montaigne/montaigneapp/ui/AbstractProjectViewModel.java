package com.montaigne.montaigneapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;
import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.model.Projeto;
import com.montaigne.montaigneapp.ui.home.HomeActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public abstract class AbstractProjectViewModel <Project extends Projeto> extends ViewModel {
    protected abstract void setUp(Projeto projeto, FragmentManager supportFragmentManager);

    private static final HashSet<String> navLockingFields = new HashSet<>();
    // hashset garante que os campos não vão se repetir. Unica variável global do projeto

    public static void addLockingField(String fieldId) {
        navLockingFields.add(fieldId);
    }

    public static void removeLockingField(String fieldId) {
            navLockingFields.remove(fieldId);
    }

    protected static void intentHome(@NonNull View view) {
        if (navLockingFields.size() == 0) {
            Intent intent = new Intent(view.getContext(), HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            view.getContext().startActivity(intent);
        } else {
            Snackbar.make(view,
                    R.string.msg_snackbar_campos_vazios,
                    Snackbar.LENGTH_LONG).show();
        }
    }

    protected abstract void handleNavigation(FragmentManager manager);

    protected static Fragment getCurrentFragment(@NonNull FragmentManager manager) {
        return Objects.requireNonNull(
                manager.getPrimaryNavigationFragment()
        ).getChildFragmentManager().getFragments().get(0);
    }

    public static void navigateFragments(int actionId, @NonNull FragmentManager manager, Bundle args) {
        if (navLockingFields.size() == 0)
            ((NavHostFragment) Objects.requireNonNull(manager.findFragmentById(R.id.containerSpt)))
                .getNavController().navigate(actionId, args);
        else {
            Snackbar.make(getCurrentFragment(manager).requireView(),
                    R.string.msg_snackbar_campos_vazios,
                    Snackbar.LENGTH_LONG).show();
        }
    }

    public static void navigateFragments(int actionId, FragmentManager manager) {
        navigateFragments(actionId, manager, null);
    }

    protected abstract void updateProjeto(Project projeto);

    public abstract Project getProjeto();
}
