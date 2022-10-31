package com.montaigne.montaigneapp.ui.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.ui.spt.projeto.ProjetoActivity;
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
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        AdapterHomeProjetosBinding binding = AdapterHomeProjetosBinding
                .inflate(layoutInflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Projeto projeto = projetoList.get(position);

        holder.binding.textNameProjeto.setText( projeto.getNome() );
        holder.binding.textDescricaoProjeto.setText(projeto.getCliente());

        holder.binding.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), SptActivity.class);
            intent.putExtra(HomeVM.PROJETO, projeto);
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

        public ViewHolder(AdapterHomeProjetosBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
