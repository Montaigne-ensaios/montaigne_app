package com.montaigne.montaigneapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

    protected abstract void handleNavigation(FragmentManager manager);

    protected abstract void updateProjeto(Project projeto);

    public abstract Project getProjeto();
}
