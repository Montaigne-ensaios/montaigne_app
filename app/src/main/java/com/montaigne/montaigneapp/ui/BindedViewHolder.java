package com.montaigne.montaigneapp.ui;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

public class BindedViewHolder<BindingClass extends ViewBinding> extends RecyclerView.ViewHolder {
    public BindingClass binding;

    public BindedViewHolder(BindingClass binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
