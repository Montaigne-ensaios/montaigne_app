package com.montaigne.montaigneapp.ui.spt.projeto;

import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.AdapterSptFuroBinding;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.ui.BindedViewHolder;
import com.montaigne.montaigneapp.ui.IClickListener;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class FurosAdapter extends RecyclerView.Adapter<BindedViewHolder<AdapterSptFuroBinding>> {
    private List<FuroSpt> furos;
    private final MutableLiveData<FuroSpt> furoClicado = new MutableLiveData<>();
    private SparseBooleanArray selectedItems = new SparseBooleanArray();
    private int currentSelectedPosition = -1;
    private IClickListener clickListener;

    public SparseBooleanArray getSelectedItems() {
        return selectedItems;
    }

    public void setFuros(List<FuroSpt> furos) {
        this.furos = furos;
    }

    public void setClickListener(IClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public FurosAdapter(List<FuroSpt> furos) {
        this.furos = furos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BindedViewHolder<AdapterSptFuroBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        AdapterSptFuroBinding binding = AdapterSptFuroBinding
                .inflate(inflater, parent, false);

        return new BindedViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindedViewHolder<AdapterSptFuroBinding> holder, int position) {
        FuroSpt furo = furos.get(position);
        holder.binding.textFuroName.setText(furo.getCodigo());

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
                furoClicado.setValue(furo);
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
        if (furos == null) {
            return 0;
        }
        return furos.size();
    }

    public LiveData<FuroSpt> getOnClickObservable() {
        return furoClicado;
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
