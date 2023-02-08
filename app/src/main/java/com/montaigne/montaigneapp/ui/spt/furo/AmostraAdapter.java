package com.montaigne.montaigneapp.ui.spt.furo;

import static com.montaigne.montaigneapp.utils.editTextInputParser.getFloat;
import static com.montaigne.montaigneapp.utils.editTextInputParser.setValue;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.AdapterAmostraBinding;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.ui.LockingTextWatcher;
import com.montaigne.montaigneapp.ui.BindedViewHolder;
import com.montaigne.montaigneapp.ui.IClickListener;

import java.util.List;

public class AmostraAdapter extends RecyclerView.Adapter<BindedViewHolder<AdapterAmostraBinding>>{
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
    public BindedViewHolder<AdapterAmostraBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        AdapterAmostraBinding binding = AdapterAmostraBinding
                .inflate(inflater, parent, false);

        return new BindedViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindedViewHolder<AdapterAmostraBinding> holder, int position) {
        Context context = holder.binding.getRoot().getContext();
        AmostraSpt amostra = amostras.get(position);

        setValue(holder.binding.editTextProfundidade, amostra.getProfundidade());
        setValue(holder.binding.editTextGolpe1, amostra.getGolpe1());
        setValue(holder.binding.editTextGolpe2, amostra.getGolpe2());
        setValue(holder.binding.editTextGolpe3, amostra.getGolpe3());
        setValue(holder.binding.editTextPenetracao1, amostra.getPenatracao1());
        setValue(holder.binding.editTextPenetracao2, amostra.getPenatracao2());
        setValue(holder.binding.editTextPenetracao3, amostra.getPenatracao3());

        holder.binding.editTextProfundidade.addTextChangedListener(
                new LockingTextWatcher(true, position + "proufundidade"){
                    @Override
                    public void afterValidChangeListener(String string) {
                        amostra.setProfundidade(Float.parseFloat(string));
                    }
                });

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
