package com.montaigne.montaigneapp.ui.home;

import android.content.Context;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.BindedViewHolder;
import com.montaigne.montaigneapp.ui.IClickListener;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.databinding.AdapterHomeProjetosBinding;
import com.montaigne.montaigneapp.model.Projeto;

import java.util.ArrayList;
import java.util.List;

public class ProjetosSalvosAdapter extends RecyclerView.Adapter<BindedViewHolder<AdapterHomeProjetosBinding>> {
    private List<Projeto> projetoList;
    private List<Boolean> isCheckedList;
    private SparseBooleanArray selectedItems = new SparseBooleanArray();
    private int selectedProjects = 0;
    private boolean isItemLongClicked = false;
    private IClickListener clickListener;
    private int currentSelectedPosition = -1;
    public ProjetosSalvosAdapter() {
        projetoList = new ArrayList<>();
    }

    public void setClickListener(IClickListener clickListener) {
        this.clickListener = clickListener;
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
            if (clickListener != null)
                clickListener.onItemClick(position);
            System.out.println(selectedProjects);
            if (isItemLongClicked && selectedProjects > 0 && !selectedItems.get(position)) {
                isCheckedList.set(position, true);
                selectedItems.put(position, true);
                holder.binding.cardView.setBackgroundResource(R.color.hint);
            } else if (selectedItems.get(position)) {
                selectedProjects--;
                if (selectedProjects == 0) isItemLongClicked = false;
                isCheckedList.set(position, false);
                selectedItems.delete(position);
                holder.binding.cardView.setBackgroundResource(R.color.white);
            } else if (!isItemLongClicked && selectedProjects == 0) {
                Intent intent = new Intent(v.getContext(), SptActivity.class);
                intent.putExtra(HomeVM.PROJETO, projeto);
                v.getContext().startActivity(intent);
            }
        });

        holder.binding.cardView.setOnLongClickListener(v -> {
            if (clickListener != null)
                clickListener.onItemLongClick(position);
            if (!selectedItems.get(position)) {
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

        if (currentSelectedPosition == position) currentSelectedPosition = -1;
    }

    public void setProjetoList(List<Projeto> projetoList){
        this.projetoList = projetoList;
        this.isCheckedList = new ArrayList<>();
        for (Boolean selecionado : isCheckedList) {
            isCheckedList.add(false);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() { return projetoList.size();}

    public SparseBooleanArray getIsCheckedList() {
        return selectedItems;
    }


    public void togglePositions(int position) {
        currentSelectedPosition = position;
        if (selectedItems.get(position)) {
            selectedItems.delete(position);
        } else {
            selectedItems.put(position, true);
        }
    }
}
