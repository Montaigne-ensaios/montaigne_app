package com.montaigne.montaigneapp.ui.spt.carimboProjeto;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.AdapterCarimboProjetoBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.BindedViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarimboProjetoAdapter extends RecyclerView.Adapter<BindedViewHolder<AdapterCarimboProjetoBinding>> {
    List<Field> fields = new ArrayList<>();

    private static class Field {
        private final FieldsIds fieldName;
        private final int hintId;
        private final String obsMsg;
        private final int iconId;
        private String value;
        private int inputType;

        public Field(FieldsIds fieldName, String value, int hintId,
                     String obsMsg, int iconId, int inputType){
            this.fieldName = fieldName;
            this.value = value;
            this.hintId = hintId;
            this.obsMsg = obsMsg;
            this.iconId = iconId;
            this.inputType = inputType;
        }
    }

    public enum FieldsIds {
        ID("id"), NOME("nome"), CLIENTE("cliente"),
        EMPRESA("empresa"), TECNICO("tecnico"), CONTATO("contato"),
        REFERENCIA("referencia"), ALTURAREFERENCIA("altura"),

        ENDERECO("endereço"), // captura de localização -> geocode
        DATA_INICIO("datainicio"), DATA_FIM("datafim");  // datepicker

        final String id;

        FieldsIds(String id) {
            this.id = id;
        }
    }

    public CarimboProjetoAdapter(ProjetoSpt ProjetoSpt) {
        setProjetoSpt(ProjetoSpt);
    }

    private void setProjetoSpt(ProjetoSpt ProjetoSpt) {
        fields.add(new Field(FieldsIds.NOME, ProjetoSpt.getNome(), R.string.registration_projectName_hint, "Obrigatório*", R.drawable.ic_name_project, InputType.TYPE_CLASS_TEXT));
        fields.add(new Field(FieldsIds.CLIENTE, ProjetoSpt.getCliente(), R.string.registration_cliente_hint, " ", R.drawable.ic_perfil, InputType.TYPE_CLASS_TEXT));
        fields.add(new Field(FieldsIds.EMPRESA, ProjetoSpt.getEmpresa(), R.string.registration_empresa_hint, " ", R.drawable.ic_empresa, InputType.TYPE_CLASS_TEXT));
        fields.add(new Field(FieldsIds.TECNICO, ProjetoSpt.getTecnico(), R.string.registration_tecnico_hint, " ", R.drawable.ic_technician, InputType.TYPE_CLASS_TEXT));
        fields.add(new Field(FieldsIds.CONTATO, ProjetoSpt.getContato(), R.string.registration_contato_hint, " ", R.drawable.ic_contato, InputType.TYPE_CLASS_TEXT));
        fields.add(new Field(FieldsIds.REFERENCIA, ProjetoSpt.getReferenciaNivel(), R.string.registration_referencia_nivel_hint, "Obrigatório*", R.drawable.ic_referencia_furo, InputType.TYPE_CLASS_TEXT));
        fields.add(new Field(FieldsIds.ALTURAREFERENCIA, Float.toString(ProjetoSpt.getAlturaReferencia()), R.string.registration_altura_referencia_nivel_hint, " ", R.drawable.ic_edit, InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL));
        fields.add(new Field(FieldsIds.ENDERECO, ProjetoSpt.getEndereco(), R.string.registration_coordenadas_hint, " ", R.drawable.ic_location, InputType.TYPE_CLASS_TEXT));
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
        holder.binding.textInputEditTextNameProjeto.setInputType(field.inputType);

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
