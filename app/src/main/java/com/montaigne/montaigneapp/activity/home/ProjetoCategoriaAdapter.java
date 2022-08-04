package com.montaigne.montaigneapp.activity.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProjetoCategoriaAdapter extends RecyclerView.Adapter<ProjetoCategoriaAdapter.ViewHolder>{
    private final Context context;
    private ArrayList<Object[]> categoriasProjeto = new ArrayList<>();
    // lista com: nome, referência da imagem
    // não pode ser um hash map pois não é acessível por posição


    public ProjetoCategoriaAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_projeto_categoria, parent, false);
        //new ViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.buttonProjetoName.setText((String) categoriasProjeto.get(position)[0]);
        int drawableId = (Integer) categoriasProjeto.get(position)[1];
        holder.imageProjeto.setImageDrawable(AppCompatResources.getDrawable(context, drawableId));
    }

    @Override
    public int getItemCount() {
        return categoriasProjeto.size();
    }

    public void setCategoriasProjeto(ArrayList<Object[]> categoriasProjeto) {
        this.categoriasProjeto = categoriasProjeto;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        protected ImageView imageProjeto;
        protected Button buttonProjetoName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // todo: initialize views
        }
    }
}
