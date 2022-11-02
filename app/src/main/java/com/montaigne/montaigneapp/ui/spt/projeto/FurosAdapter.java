package com.montaigne.montaigneapp.ui.spt.projeto;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.databinding.AdapterProjetoBinding;
import com.montaigne.montaigneapp.ui.spt.furo.FuroFragment;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.List;

public class FurosAdapter extends RecyclerView.Adapter<FurosAdapter.ViewHolder> {
    protected ProjetoSpt projetoSpt;
    protected List<FuroSpt> furos;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        AdapterProjetoBinding binding = AdapterProjetoBinding
                .inflate(inflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // TODO: verificar se vai ser realmente o código que será exibido e como gerá-lo
        holder.binding.textFuroName.setText(furos.get(position).getCodigo());

        int id = position;

        holder.binding.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), FuroFragment.class);
            intent.putExtra("idFuro", id);
            intent.putExtra("projetoSpt", projetoSpt);

            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        if (furos == null) {
            return 0;
        }
        return furos.size();
    }

    // TODO: seria bom pensarmos no caso de utilizar um construtor para recebimento desses dados
    public void setFuros(List<FuroSpt> furos) {
        this.furos = furos;
    }

    public void setProjetoSpt(ProjetoSpt projetoSpt) {
        this.projetoSpt = projetoSpt;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder{
        private final AdapterProjetoBinding binding;

        public ViewHolder(AdapterProjetoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
