package com.montaigne.montaigneapp.ui.spt.furo;

import android.content.Context;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.AdapterFuroBinding;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.AbstracProjectActivity;
import com.montaigne.montaigneapp.ui.BindedViewHolder;
import com.montaigne.montaigneapp.ui.IClickListener;
import com.montaigne.montaigneapp.ui.spt.SptActivity;

import java.util.List;

public class AmostraAdapter extends RecyclerView.Adapter<BindedViewHolder<AdapterFuroBinding>>{
    private List<AmostraSpt> amostras;
    private int currentSelectedPosition = -1;
    private SparseBooleanArray selectedItems = new SparseBooleanArray();
    private IClickListener clickListener;

    public SparseBooleanArray getSelectedItems() {
        return selectedItems;
    }

    public void setCurrentSelectedPosition(int currentSelectedPosition) {
        this.currentSelectedPosition = currentSelectedPosition;
    }

    public void setSelectedItems(SparseBooleanArray selectedItems) {
        this.selectedItems = selectedItems;
    }

    public void setClickListener(IClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setAmostras(@NonNull List<AmostraSpt> amostras) {
        this.amostras = amostras;
    }

    @NonNull
    @Override
    public BindedViewHolder<AdapterFuroBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        AdapterFuroBinding binding = AdapterFuroBinding
                .inflate(inflater, parent, false);

        return new BindedViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindedViewHolder<AdapterFuroBinding> holder, int position) {
        Context context = holder.binding.getRoot().getContext();

        holder.binding.textFuroName.setText(context.getString(R.string.adapter_amostra_name) + (position + 1));

        if (selectedItems.get(position)) {
            holder.binding.cardView.setBackgroundResource(R.color.hint);
        } else {
            holder.binding.cardView.setBackgroundResource(R.color.white);
        }

        holder.binding.cardView.setOnClickListener(v -> {
            if (clickListener != null && selectedItems.size() > 0)
                clickListener.onItemClick(position);
            else {
                //TODO:IMPLEMENTAR NAVEGAÇÃO
            }
            if (selectedItems.get(position))
                holder.binding.cardView.setBackgroundResource(R.color.hint);
            else
                holder.binding.cardView.setBackgroundResource(R.color.white);
        });

        holder.binding.cardView.setOnLongClickListener(v -> {
            if (clickListener != null) {
                clickListener.onItemLongClick(position);
                System.out.println("longclick hein mano");
            }
            if (selectedItems.get(position))
                holder.binding.cardView.setBackgroundResource(R.color.hint);
            else holder.binding.cardView.setBackgroundResource(R.color.white);

            return true;
        });

        if (currentSelectedPosition == position) currentSelectedPosition = -1;
    }

    @Override
    public int getItemCount() {
        // fixme: o projeto crasha se você sai de um carimbo antes de a lista ter sido criada
        return amostras.size();
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
