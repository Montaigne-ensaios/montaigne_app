package com.montaigne.montaigneapp.activity.spt.ensaio;

import android.widget.EditText;

public class EnsaioVM {
    private final EnsaioActivity activity;

    public EnsaioVM(EnsaioActivity activity) {

        this.activity = activity;

        setGolpeModfiersListners();
    }

    private void setGolpeModfiersListners(){
        for (int i = 0; i < 3; i++) {
            int finalI = i;  // finalização necessária para os lambdas
            activity.buttonsIncrementGolpes.get(i).setOnClickListener(v -> incrementGolpe(finalI));
            activity.buttonsDecrementGolpes.get(i).setOnClickListener(v -> decrementGolpe(finalI));
        }
    }

    private void incrementGolpe(int segmento) {
        setGolpe(segmento, getGolpe(segmento) + 1);
    }
    private void decrementGolpe(int segmento) {
        // garante que o valor jamais será menor que zero
        int v = getGolpe(segmento);
        v = (v > 0) ? (v - 1) : v;
        setGolpe(segmento, v);
    }

    private int getGolpe(int segmento) {
        return Integer.parseInt(String.valueOf(activity.golpes.get(segmento).getText()));
    }

    private void setGolpe(int segmento, int value) {
        activity.golpes.get(segmento).setText(String.valueOf(value));
    }
}
