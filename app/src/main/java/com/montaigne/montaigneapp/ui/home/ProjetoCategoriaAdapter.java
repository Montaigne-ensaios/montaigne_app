package com.montaigne.montaigneapp.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.databinding.AdapterHomeProjetoCategoriaBinding;

import java.util.ArrayList;

public class ProjetoCategoriaAdapter extends RecyclerView.Adapter<ProjetoCategoriaAdapter.ViewHolder>{
    private ArrayList<Object[]> categoriasProjeto = new ArrayList<>();
    // lista com: nome, referência da imagem
    // não pode ser um hash map pois não é acessível por posição

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        AdapterHomeProjetoCategoriaBinding binding = AdapterHomeProjetoCategoriaBinding
                .inflate(inflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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

    protected static class ViewHolder extends RecyclerView.ViewHolder{
        private final AdapterHomeProjetoCategoriaBinding binding;

        public ViewHolder(AdapterHomeProjetoCategoriaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
