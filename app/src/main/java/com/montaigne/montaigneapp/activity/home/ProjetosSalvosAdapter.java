package com.montaigne.montaigneapp.activity.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProjetosSalvosAdapter extends RecyclerView.Adapter<ProjetosSalvosAdapter.ViewHolder> {
    // todo: passar esta array list para a entity
    private final ArrayList<String> projetos;
    private final Context context;

    public ProjetosSalvosAdapter(Context context, ArrayList<String> projetos) {
        this.context = context;
        this.projetos = projetos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_projeto_salvo, parent, false);
        //new ViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textNomeProjeto.setText(projetos.get(position));
    }

    @Override
    public int getItemCount() { return projetos.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageProjeto;
        protected TextView textNomeProjeto, textDescricaoProjeto, textTipoProjeto, textDateProjeto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // todo: initialize views
        }
    }
}
