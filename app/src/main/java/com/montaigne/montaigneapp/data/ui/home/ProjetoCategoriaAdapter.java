package com.montaigne.montaigneapp.data.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.databinding.AdapterHomeProjetoCategoriaBinding;
import com.montaigne.montaigneapp.data.ui.BindedViewHolder;

import java.util.ArrayList;

public class ProjetoCategoriaAdapter extends RecyclerView.Adapter<
        BindedViewHolder<AdapterHomeProjetoCategoriaBinding>>{
    private ArrayList<Object[]> categoriasProjeto = new ArrayList<>();
    // lista com: nome, referência da imagem
    // não pode ser um hash map pois não é acessível por posição

    @NonNull
    @Override
    public BindedViewHolder<AdapterHomeProjetoCategoriaBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        AdapterHomeProjetoCategoriaBinding binding = AdapterHomeProjetoCategoriaBinding
                .inflate(inflater, parent, false);

        return new BindedViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindedViewHolder<AdapterHomeProjetoCategoriaBinding> holder, int position) {
        holder.binding.buttonProjetoName.setText((String) categoriasProjeto.get(position)[0]);
        int drawableId = (Integer) categoriasProjeto.get(position)[1];
        holder.binding.imageProjeto.setImageResource(drawableId);

        // Aqui que se deve passar o listener
    }

    @Override
    public int getItemCount() {
        return categoriasProjeto.size();
    }

    public void setCategoriasProjeto(ArrayList<Object[]> categoriasProjeto) {
        this.categoriasProjeto = categoriasProjeto;
        notifyDataSetChanged();
    }
}
