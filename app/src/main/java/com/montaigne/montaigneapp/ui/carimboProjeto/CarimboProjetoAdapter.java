package com.montaigne.montaigneapp.ui.carimboProjeto;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.AdapterCarimboProjetoBinding;
import com.montaigne.montaigneapp.model.Projeto;
import com.montaigne.montaigneapp.ui.BindedViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarimboProjetoAdapter extends RecyclerView.Adapter<BindedViewHolder<AdapterCarimboProjetoBinding>> {
    List<Field> fields = new ArrayList<>();

    private static class Field {
        private final String fieldName;
        private final String hint;
        private final String obsMsg;
        private final int iconId;
        private String value;

        private Field(String fieldName, String value, String hint, String obsMsg, int iconId){
            this.fieldName = fieldName;
            this.value = value;
            this.hint = hint;
            this.obsMsg = obsMsg;
            this.iconId = iconId;
        }
    }

    public CarimboProjetoAdapter(Projeto projeto) {
        setProjeto(projeto);
    }

    private void setProjeto(Projeto projeto) {
        fields.add(new Field("nome", projeto.getNome(), "nome", "msgDeErro", R.drawable.ic_contato));
        fields.add(new Field("cliente", projeto.getCliente(), "cliente", "msgErro", R.drawable.icon_delet));  // todo: replace icon
        fields.add(new Field("empresa", projeto.getEmpresa(), "empresa", "msgErro", R.drawable.ic_empresa));
        fields.add(new Field("tecnico", projeto.getTecnico(), "tecnico", "msgErro", R.drawable.ic_technician));
        fields.add(new Field("numeroDeTelefone", projeto.getNumeroDeTelefone(), "numeroDeTelefone", "msgErro", R.drawable.ic_contato));
        fields.add(new Field("dataInicio", projeto.getDataInicio(), "dataInicio", "msgErro", R.drawable.icon_delet));
        fields.add(new Field("coordenadas", "", "coordenadas", "msgErro", R.drawable.ic_location));
        notifyDataSetChanged();
    }

    public Map<String, String> getValues() {
        HashMap<String, String> map = new HashMap<>();
        map.put("nome", fields.get(0).value);
        map.put("cliente", fields.get(1).value);
        map.put("empresa", fields.get(2).value);
        map.put("tecnico", fields.get(3).value);
        map.put("numeroDeTelefone", fields.get(4).value);
        map.put("dataInicio", fields.get(5).value);
        map.put("coordenadas", fields.get(6).value);

        return map;
    }

    @NonNull
    @Override
    public BindedViewHolder<AdapterCarimboProjetoBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        AdapterCarimboProjetoBinding binding = AdapterCarimboProjetoBinding
                .inflate(inflater, parent, false);

        return new BindedViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindedViewHolder<AdapterCarimboProjetoBinding> holder, int position) {
        Field field = fields.get(position);
        Log.d("Adapter", "Adapter criado: " + field.fieldName);
        holder.binding.textInputLayoutNameProjeto.setStartIconDrawable(field.iconId);
        holder.binding.textInputLayoutNameProjeto.setHelperText(field.obsMsg);
        holder.binding.textInputEditTextNameProjeto.setHint(field.hint);
        holder.binding.textInputEditTextNameProjeto.setText(field.value);

        holder.binding.textInputEditTextNameProjeto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}  // todo: implementar máscaras

            @Override
            public void afterTextChanged(Editable s) {
                fields.get(holder.getAdapterPosition()).value = s.toString();
            }
        });
    }

    @Override
    public int getItemCount() {
        return fields.size();
    }
}
