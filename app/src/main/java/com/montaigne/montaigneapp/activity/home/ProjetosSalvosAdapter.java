package com.montaigne.montaigneapp.activity.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.spt.projeto.ProjetoActivity;
import com.montaigne.montaigneapp.databinding.AdapterHomeProjetosBinding;
import com.montaigne.montaigneapp.model.Projeto;

import java.util.ArrayList;
import java.util.List;

public class ProjetosSalvosAdapter extends RecyclerView.Adapter<ProjetosSalvosAdapter.ViewHolder> {
    // todo: passar esta array list para a entity
    private List<Projeto> projetoList;

    public ProjetosSalvosAdapter() {
        projetoList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_home_projetos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Projeto projeto = projetoList.get(position);

        holder.binding.textNameProjeto.setText( projeto.getNome() );

        holder.binding.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ProjetoActivity.class);
            intent.putExtra("projeto", projeto);
            //FIXME: java.lang.RuntimeException: Parcelable encountered IOException writing serializable object (name = com.montaigne.montaigneapp.model.spt.ProjetoSpt)
            v.getContext().startActivity(intent);
        });
    }

    public void setProjetoList(List<Projeto> projetoList){
        this.projetoList = projetoList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() { return projetoList.size();}

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private AdapterHomeProjetosBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
