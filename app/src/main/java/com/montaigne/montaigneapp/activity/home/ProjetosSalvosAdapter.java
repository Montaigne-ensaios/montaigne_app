package com.montaigne.montaigneapp.activity.home;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.spt.projeto.ProjetoActivity;
import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;
import com.montaigne.montaigneapp.model.Projeto;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.ArrayList;
import java.util.List;

public class ProjetosSalvosAdapter extends RecyclerView.Adapter<ProjetosSalvosAdapter.ViewHolder> {
    // todo: passar esta array list para a entity
    private ProjetoSptDao projetoSptDao;
    private List<Projeto> projetoList;

    public ProjetosSalvosAdapter() {
        projetoList = new ArrayList<>();

        this.projetoSptDao = new ProjetoSptDao();
        reloadProjetos();
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
            intent.putExtra("name", projeto);
            v.getContext().startActivity(intent);
        });
        // todo: definir se este listener deveria ficar aqui
    }

    @Override
    public int getItemCount() { return projetoList.size(); }

    private void reloadProjetos() {
        DatabaseReference reference = projetoSptDao.getDbReference();
        projetoList.clear();

        try {
            reference.getDatabase().setPersistenceEnabled(true);
        } catch (Exception e) {

        }

        reference.get().addOnCompleteListener(dataSnapshotProjetoSpt -> {
            for (DataSnapshot child : dataSnapshotProjetoSpt.getResult().getChildren()) {
                // todo: colocar os outros tipos de projeto (como granulometria) para serem adicionados na lista aqui
                ProjetoSpt projeto = child.getValue(ProjetoSpt.class);
                projetoList.add(projeto);
            }

            notifyDataSetChanged();
        });
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        protected final CardView cardView;
        protected final ImageView imageProjeto;
        protected final TextView textNomeProjeto, textDescricaoProjeto, textTipoEnsaio, textDateProjeto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
            textNomeProjeto = itemView.findViewById(R.id.textNomeProjeto);
            textDescricaoProjeto = itemView.findViewById(R.id.textDescricaoProjeto);
            textTipoEnsaio = itemView.findViewById(R.id.textTipoEnsaio);
            textDateProjeto = itemView.findViewById(R.id.textDateProjeto);
            imageProjeto = itemView.findViewById(R.id.imageProjeto);

            imageProjeto.setImageResource(R.drawable.icon_home3);
        }
    }
}
