package com.montaigne.montaigneapp.ui.spt.furo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.ui.spt.ensaio.EnsaioFragment;
import com.montaigne.montaigneapp.databinding.AdapterProjetoBinding;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.BindedViewHolder;

import java.util.List;

public class AmostraAdapter extends RecyclerView.Adapter<BindedViewHolder<AdapterProjetoBinding>>{
    private int idFuro;
    private ProjetoSpt projetoSpt;
    private List<AmostraSpt> amostras;

    public void setAmostras(List<AmostraSpt> amostras) {
        this.amostras = amostras;
    }

    public void setIdFuro(int id) {
        this.idFuro = id;
    }

    public void setProjetoSpt(ProjetoSpt projetoSpt) {
        this.projetoSpt = projetoSpt;
    }

    @NonNull
    @Override
    public BindedViewHolder<AdapterProjetoBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        AdapterProjetoBinding binding = AdapterProjetoBinding
                .inflate(inflater, parent, false);

        return new BindedViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindedViewHolder<AdapterProjetoBinding> holder, int position) {
        Context context = holder.binding.getRoot().getContext();

        holder.binding.textFuroName.setText(context.getString(R.string.adapter_amostra_name) + (position + 1));

        holder.binding.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), EnsaioFragment.class);
            intent.putExtra("idAmostra", position);
            intent.putExtra("idFuro", idFuro);
            intent.putExtra("projetoSpt", projetoSpt);

            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return amostras.size();
    }
}
