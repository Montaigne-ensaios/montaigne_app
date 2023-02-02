package com.montaigne.montaigneapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.navigation.fragment.NavHostFragment;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.model.Projeto;
import com.montaigne.montaigneapp.ui.home.HomeActivity;

import java.util.Objects;

public abstract class AbstractProjectViewModel <Project extends Projeto> extends ViewModel {
    protected abstract void setUp(Projeto projeto, FragmentManager supportFragmentManager);

    protected void intentHome(@NonNull View view) {
        Intent intent = new Intent(view.getContext(), HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
    }

    protected abstract void handleNavigation(FragmentManager manager);

    protected Fragment getCurrentFragment(@NonNull FragmentManager manager) {
        return Objects.requireNonNull(
                manager.getPrimaryNavigationFragment()
        ).getChildFragmentManager().getFragments().get(0);
    }

    public static void navigateFragments(int actionId, @NonNull FragmentManager manager, Bundle args) {
        ((NavHostFragment) Objects.requireNonNull(manager.findFragmentById(R.id.containerSpt)))
                .getNavController().navigate(actionId, args);
    }

    public static void navigateFragments(int actionId, FragmentManager manager) {
        navigateFragments(actionId, manager, null);
    }

    protected abstract void updateProjeto(Project projeto);

    public abstract Project getProjeto();
}
