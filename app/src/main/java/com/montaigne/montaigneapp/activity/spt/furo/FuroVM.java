package com.montaigne.montaigneapp.activity.spt.furo;

import android.view.View;

public class FuroVM {
    private final FuroActivity activity;

    public FuroVM(FuroActivity activity) {
        this.activity = activity;

        initializeAmostrasAdapter();

        activity.buttonDeleteAmostras.setOnClickListener(this::deleteAmostrasButtonListener);
    }

    private void initializeAmostrasAdapter() {
    }

    private void deleteAmostrasButtonListener(View view) {
    }
}
