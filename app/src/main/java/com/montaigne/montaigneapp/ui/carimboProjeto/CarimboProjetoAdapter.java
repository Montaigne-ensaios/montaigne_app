package com.montaigne.montaigneapp.ui.carimboProjeto;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.databinding.AdapterCarimboProjetoBinding;

import java.util.HashMap;

public class CarimboProjetoAdapter extends RecyclerView.Adapter<CarimboProjetoAdapter.ViewHolder> {
    HashMap<String, MutableLiveData<String>> fields = new HashMap<>();

    public CarimboProjetoAdapter() {
        fields.put("nome", new MutableLiveData<>(""));
        fields.put("cliente", new MutableLiveData<>(""));
        fields.put("empresa", new MutableLiveData<>(""));
        fields.put("tecnico", new MutableLiveData<>(""));
        fields.put("numeroDeTelefone", new MutableLiveData<>(""));
        fields.put("dataInicio", new MutableLiveData<>(""));
        fields.put("coordenadas", new MutableLiveData<>(""));
    }

    @NonNull
    @Override
    public CarimboProjetoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        AdapterCarimboProjetoBinding binding = AdapterCarimboProjetoBinding
                .inflate(inflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CarimboProjetoAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final AdapterCarimboProjetoBinding binding;

        public ViewHolder(AdapterCarimboProjetoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
