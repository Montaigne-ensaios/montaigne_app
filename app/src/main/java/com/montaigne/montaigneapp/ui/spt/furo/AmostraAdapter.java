package com.montaigne.montaigneapp.ui.spt.furo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.AdapterFuroBinding;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.BindedViewHolder;

import java.util.List;

public class AmostraAdapter extends RecyclerView.Adapter<BindedViewHolder<AdapterFuroBinding>>{
    private List<AmostraSpt> amostras;

    public void setAmostras(@NonNull List<AmostraSpt> amostras) {
        this.amostras = amostras;
    }

    @NonNull
    @Override
    public BindedViewHolder<AdapterFuroBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        AdapterFuroBinding binding = AdapterFuroBinding
                .inflate(inflater, parent, false);

        return new BindedViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindedViewHolder<AdapterFuroBinding> holder, int position) {
        Context context = holder.binding.getRoot().getContext();

        holder.binding.textFuroName.setText(context.getString(R.string.adapter_amostra_name) + (position + 1));

        holder.binding.cardView.setOnClickListener(v -> {
            // todo: implementar navigation
        });
    }

    @Override
    public int getItemCount() {
        return amostras.size();
    }
}
