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

import java.util.ArrayList;

public class AmostraAdapter extends RecyclerView.Adapter<AmostraAdapter.ViewHolder>{
    private int idFuro;
    private ArrayList<String> amostras;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_projeto, parent, false);  // ver se o layout deve ser alterado
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(amostras.get(position));
        String nome = amostras.get(position);
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), EnsaioActivity.class);
            intent.putExtra("name", nome);
            intent.putExtra("nFuro", idFuro);
            intent.putExtra("nAmostra", position);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return amostras.size();
    }

    public void setAmostras(ArrayList<String> amostras) {
        this.amostras = amostras;
    }

    public void setIdFuro(int id) {
        this.idFuro = id;
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
