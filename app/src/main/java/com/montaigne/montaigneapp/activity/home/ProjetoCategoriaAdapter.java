package com.montaigne.montaigneapp.activity.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;

import java.util.ArrayList;

public class ProjetoCategoriaAdapter extends RecyclerView.Adapter<ProjetoCategoriaAdapter.ViewHolder>{
    private ArrayList<Object[]> categoriasProjeto = new ArrayList<>();
    // lista com: nome, referência da imagem
    // não pode ser um hash map pois não é acessível por posição

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_home_projeto_categoria, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.buttonProjetoName.setText((String) categoriasProjeto.get(position)[0]);
        int drawableId = (Integer) categoriasProjeto.get(position)[1];
        holder.imageProjeto.setImageResource(drawableId);

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

    protected class ViewHolder extends RecyclerView.ViewHolder{
        protected final ImageView imageProjeto;
        protected final Button buttonProjetoName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            buttonProjetoName = itemView.findViewById(R.id.buttonProjetoName);
            imageProjeto = itemView.findViewById(R.id.imageProjeto);
        }
    }
}
