package com.montaigne.montaigneapp.activity.spt.projeto;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.spt.furo.FuroActivity;
import com.montaigne.montaigneapp.model.Projeto;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.ArrayList;
import java.util.List;

public class FurosAdapter extends RecyclerView.Adapter<FurosAdapter.ViewHolder> {
    protected ProjetoSpt projetoSpt;
    protected List<FuroSpt> furos;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_projeto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // TODO: verificar se vai ser realmente o código que será exibido e como gerá-lo
        holder.textView.setText(furos.get(position).getCodigo());

        int id = position;

        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), FuroActivity.class);
            intent.putExtra("idFuro", id);
            intent.putExtra("projetoSpt", projetoSpt);

            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return furos.size();
    }

    // TODO: seria bom pensarmos no caso de utilizar um construtor para recebimento desses dados
    public void setFuros(List<FuroSpt> furos) {
        this.furos = furos;
    }

    public void setProjetoSpt(ProjetoSpt projetoSpt) {
        this.projetoSpt = projetoSpt;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{
        protected final CardView cardView;
        protected final CheckBox checkBox;
        protected final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            textView = itemView.findViewById(R.id.textFuroName);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }
}
