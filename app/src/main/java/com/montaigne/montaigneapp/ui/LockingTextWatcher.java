package com.montaigne.montaigneapp.ui;

import android.text.Editable;
import android.text.TextWatcher;

public abstract class LockingTextWatcher implements TextWatcher {
    private final boolean obligatory;  // if true, asserts never will save blank strings
    private final String fieldId;  // non displayed id to lockingFields list

    protected LockingTextWatcher(boolean obligatory, String fieldId) {
        this.obligatory = obligatory;
        this.fieldId = fieldId;
    }

    /*
    o text watcher precisa:
    - atualizar a lista interna de amostras -> usar observável;
    - detecetar se um campo é obrigatório, no construtor;
    - bloquar atualização se o campo estiver vazio e for obrigatório e desbloquea-lo;
    - cada field constrói seu próprio text watcher e implementa observável;
     */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String string = s.toString().trim();
        if (string.isEmpty() && obligatory) {
            AbstractProjectViewModel.addLockingField(fieldId);
        } else if (obligatory){
            AbstractProjectViewModel.removeLockingField(fieldId);
            afterValidChangeListener(string);
        }
    }

    public abstract void afterValidChangeListener(String string);
}
