package com.montaigne.montaigneapp.activity.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_home_projetos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textNomeProjeto.setText(projetos.get(position));

        // todo: passar o intent com listners por aqui. Pode passar com uma lista de intents
    }

    @Override
    public int getItemCount() { return projetos.size(); }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        protected final ImageView imageProjeto;
        protected final TextView textNomeProjeto, textDescricaoProjeto, textTipoEnsaio, textDateProjeto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // todo: initialize views
            textNomeProjeto = itemView.findViewById(R.id.textNomeProjeto);
            textDescricaoProjeto = itemView.findViewById(R.id.textDescricaoProjeto);
            textTipoEnsaio = itemView.findViewById(R.id.textTipoEnsaio);
            textDateProjeto = itemView.findViewById(R.id.textDateProjeto);
            imageProjeto = itemView.findViewById(R.id.imageProjeto);

           imageProjeto.setImageResource(R.drawable.icon_home);
        }
    }
}
