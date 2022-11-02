package com.montaigne.montaigneapp.activity.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.spt.projeto.ProjetoActivity;
import com.montaigne.montaigneapp.data.usecase.ProjetoSptUseCase;
import com.montaigne.montaigneapp.model.Projeto;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.ArrayList;
import java.util.List;

public class ProjetosSalvosAdapter extends RecyclerView.Adapter<ProjetosSalvosAdapter.ViewHolder> {
    // todo: passar esta array list para a entity
    private Context context;
    private List<ProjetoSpt> projetoList = new ArrayList<>();

    public ProjetosSalvosAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_home_projetos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Projeto projeto = projetoList.get(position);

        holder.textNomeProjeto.setText( projeto.getNome() );

        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ProjetoActivity.class);
            intent.putExtra("projeto", projeto);
            //TODO: java.lang.RuntimeException: Parcelable encountered IOException writing serializable object (name = com.montaigne.montaigneapp.model.spt.ProjetoSpt)
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return projetoList.size();}

    public void refreshProjetoList(){
        projetoList.clear();

        try {
            ProjetoSptUseCase.getDatabase().keepSynced(true);

        } catch (Exception e) {

        }

        ProjetoSptUseCase.read().addOnCompleteListener(task -> {
            if(task.isSuccessful()) {
                for (DataSnapshot child : task.getResult().getChildren()) {
                    ProjetoSpt projeto = child.getValue(ProjetoSpt.class);
                    projetoList.add(projeto);
                }

                notifyDataSetChanged();
                Toast.makeText(context, "Sucesso ao carregar projetos", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(context, "Erro ao carregar projetos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        protected final CardView cardView;
        protected final ImageView imageProjeto;
        protected final TextView textNomeProjeto, textDescricaoProjeto, textTipoEnsaio, textDateProjeto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
            textNomeProjeto = itemView.findViewById(R.id.textNameProjeto);
            textDescricaoProjeto = itemView.findViewById(R.id.textDescricaoProjeto);
            textTipoEnsaio = itemView.findViewById(R.id.textTipoEnsaio);
            textDateProjeto = itemView.findViewById(R.id.textDateProjeto);
            imageProjeto = itemView.findViewById(R.id.imageProjeto);

           imageProjeto.setImageResource(R.drawable.icon_home);
        }
    }
}
