package com.montaigne.montaigneapp.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.BindedViewHolder;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.databinding.AdapterHomeProjetosBinding;
import com.montaigne.montaigneapp.model.Projeto;

import java.util.ArrayList;
import java.util.List;

public class ProjetosSalvosAdapter extends RecyclerView.Adapter<BindedViewHolder<AdapterHomeProjetosBinding>> {
    private List<Projeto> projetoList;
    private List<Boolean> isCheckedList;
    private int selectedProjects = 0;
    private boolean isItemLongClicked = false;

    public ProjetosSalvosAdapter() {
        projetoList = new ArrayList<>();
    }

    @NonNull
    @Override
    public BindedViewHolder<AdapterHomeProjetosBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        AdapterHomeProjetosBinding binding = AdapterHomeProjetosBinding
                .inflate(layoutInflater, parent, false);

        return new BindedViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindedViewHolder<AdapterHomeProjetosBinding> holder, int position) {
        Projeto projeto = projetoList.get(position);

        Context context = holder.binding.getRoot().getContext();

        holder.binding.textNameProjeto.setText( projeto.getNome() );
        holder.binding.textDateProjeto.setText(
                context.getString(R.string.adapter_projetos_savlos_data)+ projeto.getDataInicio());
        if (projeto.getClass() == ProjetoSpt.class)
                holder.binding.textTipoEnsaio.setText(
                        context.getString(R.string.adapter_projetos_savlos_projeto_label) +
                        context.getString(R.string.categoria_spt));
        // todo: add granulometria

        holder.binding.cardView.setOnClickListener(v -> {
            System.out.println(selectedProjects);
            if (isItemLongClicked && selectedProjects > 0 && !isCheckedList.get(position)) {
                isCheckedList.set(position, true);
                holder.binding.cardView.setBackgroundResource(R.color.hint);
                selectedProjects++;
            } else if (isCheckedList.get(position)) {
                selectedProjects--;
                if (selectedProjects == 0) isItemLongClicked = false;
                isCheckedList.set(position, false);
                holder.binding.cardView.setBackgroundResource(R.color.white);
            } else if (!isItemLongClicked && selectedProjects == 0) {
                Intent intent = new Intent(v.getContext(), SptActivity.class);
                intent.putExtra(HomeVM.PROJETO, projeto);
                v.getContext().startActivity(intent);
            }
        });

        holder.binding.cardView.setOnLongClickListener(v -> {
            if (!isCheckedList.get(position)) {
                isCheckedList.set(position, true);
                isItemLongClicked = true;
                selectedProjects++;
                holder.binding.cardView.setBackgroundResource(R.color.hint);
            } else {
                isCheckedList.set(position, false);
                selectedProjects--;
                holder.binding.cardView.setBackgroundResource(R.color.white);
            }
            return true;
        });
    }

    public void setProjetoList(List<Projeto> projetoList){
        this.projetoList = projetoList;
        this.isCheckedList = new ArrayList<>();
        for (int i = 0; i < getItemCount(); i++) {
            isCheckedList.add(false);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() { return projetoList.size();}

    public List<Boolean> getIsCheckedList() {
        return isCheckedList;
    }
}
