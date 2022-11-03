package com.montaigne.montaigneapp.ui.carimboProjeto;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.AdapterCarimboProjetoBinding;
import com.montaigne.montaigneapp.model.Projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarimboProjetoAdapter extends RecyclerView.Adapter<CarimboProjetoAdapter.ViewHolder> {
    List<Field> fields = new ArrayList<>();

    private static class Field {
        private String fieldName;
        private MutableLiveData<String> value;
        private String hint;
        private String obsMsg;
        private int iconId;

        private Field(String fieldName, String value, String hint, String obsMsg, int iconId){
            this.fieldName = fieldName;
            this.value = new MutableLiveData<>(value);
            this.hint = hint;
            this.obsMsg = obsMsg;
            this.iconId = iconId;
        }
    }

    public CarimboProjetoAdapter(Projeto projeto) {
        fields.add(new Field("nome", projeto.getNome(), "nome", "msgDeErro", R.drawable.ic_contato));
        fields.add(new Field("cliente", projeto.getCliente(), "cliente", "msgErro", R.drawable.icon_delet));  // todo: replace icon
        fields.add(new Field("empresa", projeto.getEmpresa(), "empresa", "msgErro", R.drawable.ic_empresa));
        fields.add(new Field("tecnico", projeto.getTecnico(), "tecnico", "msgErro", R.drawable.ic_technician));
        fields.add(new Field("numeroDeTelefone", projeto.getNumeroDeTelefone(), "numeroDeTelefone", "msgErro", R.drawable.ic_contato));
        fields.add(new Field("dataInicio", projeto.getDataInicio(), "dataInicio", "msgErro", R.drawable.icon_delet));
        fields.add(new Field("coordenadas", projeto.getCoordenadas().toString(), "coordenadas", "msgErro", R.drawable.ic_location));
    }

    public Map<String, LiveData<String>> getLiveData() {
        HashMap<String, LiveData<String>> map = new HashMap<>();
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        AdapterCarimboProjetoBinding binding = AdapterCarimboProjetoBinding
                .inflate(inflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Field field = fields.get(position);
        holder.binding.textInputLayoutNameProjeto.setStartIconDrawable(field.iconId);
        holder.binding.textInputLayoutNameProjeto.setHelperText(field.obsMsg);
        holder.binding.textInputEditTextNameProjeto.setHint(field.hint);
        holder.binding.textInputEditTextNameProjeto.setText(field.value.getValue());

        holder.binding.textInputEditTextNameProjeto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                field.value.setValue(s.toString());
            }
        });
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
