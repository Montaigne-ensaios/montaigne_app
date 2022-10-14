package com.montaigne.montaigneapp.activity.spt.furo;

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
import com.montaigne.montaigneapp.activity.spt.ensaio.EnsaioActivity;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.ArrayList;
import java.util.List;

public class AmostraAdapter extends RecyclerView.Adapter<AmostraAdapter.ViewHolder>{
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_projeto, parent, false);  // ver se o layout deve ser alterado
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText("Amostra " + (position + 1));
        int idAmostra = position;

        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), EnsaioActivity.class);
            intent.putExtra("idAmostra", idAmostra);
            intent.putExtra("idFuro", idFuro);
            intent.putExtra("projetoSpt", projetoSpt);

            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return amostras.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{
        protected final CardView cardView;
        protected final CheckBox checkBox;
        protected final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            textView = itemView.findViewById(R.id.textFuroName);
            // todo: garantir que este nome sempre seja um int
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }
}
