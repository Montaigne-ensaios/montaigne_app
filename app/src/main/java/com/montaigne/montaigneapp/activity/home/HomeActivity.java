package com.montaigne.montaigneapp.activity.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {
    protected FloatingActionButton newProjectFab;
    protected RecyclerView projetoCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeViews();

        HomeVM viewModel = new HomeVM(this);
    }

    private void initializeViews() {

    }
}