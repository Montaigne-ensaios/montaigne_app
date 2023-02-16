package com.montaigne.montaigneapp.ui.spt.furo;

import static com.montaigne.montaigneapp.utils.editTextInputParser.setValue;

import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.AdapterSptAmostraBinding;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.ui.LockingTextWatcher;
import com.montaigne.montaigneapp.ui.BindedViewHolder;
import com.montaigne.montaigneapp.ui.IClickListener;

import java.util.List;

public class AmostraAdapter extends RecyclerView.Adapter<BindedViewHolder<AdapterSptAmostraBinding>>{
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
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BindedViewHolder<AdapterSptAmostraBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        AdapterSptAmostraBinding binding = AdapterSptAmostraBinding
                .inflate(inflater, parent, false);

        return new BindedViewHolder<>(binding);
    }

    private void setIOForHolder(BindedViewHolder<AdapterSptAmostraBinding> holder, int position) {
        AmostraSpt amostra = amostras.get(position);

        setValue(holder.binding.editTextProfundidade, amostra.getProfundidade());
        setValue(holder.binding.editTextGolpe1, amostra.getGolpe1());
        setValue(holder.binding.editTextGolpe2, amostra.getGolpe2());
        setValue(holder.binding.editTextGolpe3, amostra.getGolpe3());
        setValue(holder.binding.editTextPenetracao1, amostra.getPenatracao1());
        setValue(holder.binding.editTextPenetracao2, amostra.getPenatracao2());
        setValue(holder.binding.editTextPenetracao3, amostra.getPenatracao3());

        holder.binding.editTextProfundidade.addTextChangedListener(
                new LockingTextWatcher(true, position + "profundidade"){
                    @Override
                    public void afterValidChangeListener(String string) {
                        amostra.setProfundidade(Float.parseFloat(string));
                    }
                });

        holder.binding.editTextGolpe1.addTextChangedListener(
                new LockingTextWatcher(true, position + "golpe1"){
                    @Override
                    public void afterValidChangeListener(String string) {
                        amostra.setGolpe1(Integer.parseInt(string));
                    }
                });
        holder.binding.editTextGolpe2.addTextChangedListener(
                new LockingTextWatcher(false, position + "golpe2"){
                    @Override
                    public void afterValidChangeListener(String string) {
                        amostra.setGolpe2(Integer.parseInt(string));
                    }
                });
        holder.binding.editTextGolpe3.addTextChangedListener(
                new LockingTextWatcher(false, position + "golpe3"){
                    @Override
                    public void afterValidChangeListener(String string) {
                        amostra.setGolpe3(Integer.parseInt(string));
                    }
                });

        holder.binding.editTextPenetracao1.addTextChangedListener(
                new LockingTextWatcher(true, position + "penetração1"){
                    @Override
                    public void afterValidChangeListener(String string) {
                        amostra.setPenatracao1(Float.parseFloat(string));
                    }
                });
        holder.binding.editTextPenetracao2.addTextChangedListener(
                new LockingTextWatcher(false, position + "penetração2"){
                    @Override
                    public void afterValidChangeListener(String string) {
                        amostra.setPenatracao2(Float.parseFloat(string));
                    }
                });
        holder.binding.editTextPenetracao3.addTextChangedListener(
                new LockingTextWatcher(false, position + "penetração3"){
                    @Override
                    public void afterValidChangeListener(String string) {
                        amostra.setPenatracao3(Float.parseFloat(string));
                    }
                });

    }

    @Override
    public void onBindViewHolder(@NonNull BindedViewHolder<AdapterSptAmostraBinding> holder, int position) {
        setIOForHolder(holder, position);

        if (selectedItems.get(position)) {
            holder.binding.cardView.setBackgroundResource(R.color.hint);
        } else {
            holder.binding.cardView.setBackgroundResource(R.color.white);
        }

        holder.binding.cardView.setOnClickListener(v -> {

            if (clickListener != null && selectedItems.size() > 0) {
                clickListener.onItemClick(position);
            }
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
