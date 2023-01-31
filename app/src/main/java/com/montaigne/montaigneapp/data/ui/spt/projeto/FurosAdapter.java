package com.montaigne.montaigneapp.data.ui.spt.projeto;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.databinding.AdapterProjetoBinding;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.data.ui.BindedViewHolder;

import java.util.List;

public class FurosAdapter extends RecyclerView.Adapter<BindedViewHolder<AdapterProjetoBinding>> {
    private List<FuroSpt> furos;
    private final MutableLiveData<FuroSpt> furoClicado = new MutableLiveData<>();

    @NonNull
    @Override
    public BindedViewHolder<AdapterProjetoBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        AdapterProjetoBinding binding = AdapterProjetoBinding
                .inflate(inflater, parent, false);

        return new BindedViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindedViewHolder<AdapterProjetoBinding> holder, int position) {
        FuroSpt furo = furos.get(position);
        holder.binding.textFuroName.setText(furo.getCodigo());
        
        holder.binding.cardView.setOnClickListener(v -> furoClicado.setValue(furo));
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

    // TODO: seria bom pensarmos no caso de utilizar um construtor para recebimento desses dados
    public void setFuros(List<FuroSpt> furos) {
        this.furos = furos;
    }
}
