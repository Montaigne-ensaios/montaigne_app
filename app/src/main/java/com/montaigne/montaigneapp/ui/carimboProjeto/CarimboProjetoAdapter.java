package com.montaigne.montaigneapp.ui.carimboProjeto;

import android.app.Application;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
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
        private final int hintId;
        private final String obsMsg;
        private final int iconId;
        private String value;

        public Field(String fieldName, String value, int hintId, String obsMsg, int iconId){
            this.fieldName = fieldName;
            this.value = value;
            this.hintId = hintId;
            this.obsMsg = obsMsg;
            this.iconId = iconId;
        }
    }

    public CarimboProjetoAdapter(Projeto projeto) {
        setProjeto(projeto);
    }

    private void setProjeto(Projeto projeto) {
        fields.add(new Field("nome", projeto.getNome(), R.string.HintAdapterCarimboProjetoNome, "msgDeErro", R.drawable.ic_contato));
        fields.add(new Field("cliente", projeto.getCliente(), R.string.HintAdapterCarimboProjetoCliente, "msgErro", R.drawable.icon_delet));  // todo: replace icon
        fields.add(new Field("empresa", projeto.getEmpresa(), R.string.HintAdapterCarimboProjetoNomeEmpresa, "msgErro", R.drawable.ic_empresa));
        fields.add(new Field("tecnico", projeto.getTecnico(), R.string.HintAdapterCarimboProjetoNomeTecnico, "msgErro", R.drawable.ic_technician));
        fields.add(new Field("numeroDeTelefone", projeto.getNumeroDeTelefone(), R.string.HintAdapterCarimboProjetoContato, "msgErro", R.drawable.ic_contato));
        fields.add(new Field("dataInicio", projeto.getDataInicio(), R.string.HintAdapterCarimboProjetoDataInicio, "msgErro", R.drawable.icon_delet));
        fields.add(new Field("coordenadas", "", R.string.HintAdapterCarimboProjetoLocal, "msgErro", R.drawable.ic_location));
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
        holder.binding.textInputLayoutNameProjeto.setStartIconDrawable(field.iconId);
        holder.binding.textInputLayoutNameProjeto.setHelperText(field.obsMsg);
        holder.binding.textInputEditTextNameProjeto.setHint(field.hintId);  // todo: resolver hint errada
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
