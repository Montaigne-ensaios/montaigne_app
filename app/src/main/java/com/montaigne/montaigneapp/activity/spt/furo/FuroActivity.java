package com.montaigne.montaigneapp.activity.spt.furo;

import android.os.Bundle;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.activity.AbstractActivity;

public class FuroActivity extends AbstractActivity {
    protected RecyclerView recyclerAmostras;
    protected Button buttonDeleteAmostras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FuroVM viewModel = new FuroVM(this);
    }

    @Override
    protected void initializeViews() {

    }
}