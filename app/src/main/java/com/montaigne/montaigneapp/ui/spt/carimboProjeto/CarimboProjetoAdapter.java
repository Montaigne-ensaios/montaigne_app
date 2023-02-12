package com.montaigne.montaigneapp.ui.spt.carimboProjeto;

import android.text.InputType;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.AdapterCarimboProjetoBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.BindedViewHolder;
import com.montaigne.montaigneapp.utils.FragmentNavigator;
import com.montaigne.montaigneapp.ui.LockingTextWatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarimboProjetoAdapter extends RecyclerView.Adapter<BindedViewHolder<AdapterCarimboProjetoBinding>> {
    private final List<Pair<Field, String >> fields = new ArrayList<>();

    private static final String OBRIGATORIO = "Campo obrigatório";
    
    public enum Field {
        ID("id"),
        NOME("nome",  R.string.registration_projectName_hint, OBRIGATORIO, R.drawable.ic_name_project, InputType.TYPE_CLASS_TEXT),
        CLIENTE("cliente", R.string.registration_cliente_hint, " ", R.drawable.ic_perfil, InputType.TYPE_CLASS_TEXT),
        EMPRESA("empresa", R.string.registration_empresa_hint, " ", R.drawable.ic_empresa, InputType.TYPE_CLASS_TEXT),
        TECNICO("tecnico", R.string.registration_tecnico_hint, " ", R.drawable.ic_technician, InputType.TYPE_CLASS_TEXT),
        CONTATO("contato",  R.string.registration_contato_hint, " ", R.drawable.ic_contato, InputType.TYPE_CLASS_TEXT),
        REFERENCIA("referencia", R.string.registration_referencia_nivel_hint, OBRIGATORIO, R.drawable.ic_referencia_furo, InputType.TYPE_CLASS_TEXT),
        ALTURAREFERENCIA("altura", R.string.registration_altura_referencia_nivel_hint, " ", R.drawable.ic_edit, InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL),

        ENDERECO("endereço", R.string.registration_coordenadas_hint, " ", R.drawable.ic_location, InputType.TYPE_CLASS_TEXT), // captura de localização -> geocode
        DATA_INICIO("datainicio"), DATA_FIM("datafim");  // datepicker

        final String id, message;
        final int hintId, iconId, inputType;

        Field(String id) {
            this.id = id;
            message = null;
            hintId = -1;
            iconId = -1;
            inputType = -1;
        }

        Field(String id, int hintId, String message, int iconId, int inputType) {
            this.id = id;
            this.hintId = hintId;
            this.message = message;
            this.iconId = iconId;
            this.inputType = inputType;
        }
    }

    public CarimboProjetoAdapter(ProjetoSpt ProjetoSpt) {
        setProjetoSpt(ProjetoSpt);
    }

    private void setProjetoSpt(ProjetoSpt ProjetoSpt) {
        fields.add(new Pair<>(Field.NOME, ProjetoSpt.getNome()));
        fields.add(new Pair<>(Field.CLIENTE, ProjetoSpt.getCliente()));
        fields.add(new Pair<>(Field.EMPRESA, ProjetoSpt.getEmpresa()));
        fields.add(new Pair<>(Field.TECNICO, ProjetoSpt.getTecnico()));
        fields.add(new Pair<>(Field.CONTATO, ProjetoSpt.getContato()));
        fields.add(new Pair<>(Field.REFERENCIA, ProjetoSpt.getReferenciaNivel()));
        fields.add(new Pair<>(Field.ALTURAREFERENCIA, Float.toString(ProjetoSpt.getAlturaReferencia())));
        fields.add(new Pair<>(Field.ENDERECO, ProjetoSpt.getEndereco()));
        notifyDataSetChanged();
    }

    public ProjetoSpt updateProjetoSpt(@NonNull ProjetoSpt projeto) {
        projeto.setNome(fields.get(0).second);
        projeto.setCliente(fields.get(1).second);
        projeto.setEmpresa(fields.get(2).second);
        projeto.setTecnico(fields.get(3).second);
        projeto.setContato(fields.get(4).second);
        projeto.setReferenciaNivel(fields.get(5).second);
        projeto.setAlturaReferencia(Float.parseFloat(fields.get(6).second));
        projeto.setEndereco(fields.get(7).second);

        return projeto;
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
        Pair<Field, String> pair = fields.get(position);
        
        Field field = pair.first;
        String string = pair.second;
        holder.binding.textInputLayoutNameProjeto.setStartIconDrawable(field.iconId);
        holder.binding.textInputLayoutNameProjeto.setHelperText(field.message);
        holder.binding.textInputLayoutNameProjeto.setHint(field.hintId);
        holder.binding.textInputEditTextNameProjeto.setText(string);
        holder.binding.textInputEditTextNameProjeto.setInputType(field.inputType);

        if ((Objects.equals(string, "") || Objects.equals(string, " ") || string == null )
                && Objects.equals(field.message, OBRIGATORIO)) {
            FragmentNavigator.addEmptyFieldId(field.id);
        }

        holder.binding.textInputEditTextNameProjeto.addTextChangedListener(new LockingTextWatcher(
                field.message.equals(OBRIGATORIO), field.id) {
            @Override
            public void afterValidChangeListener(String string) {
                fields.set(holder.getAdapterPosition(),  // necessário para chamadas feitas posteriormente
                        new Pair<>(field, string));
            }
        });
    }

    @Override
    public int getItemCount() {
        return fields.size();
    }
}
