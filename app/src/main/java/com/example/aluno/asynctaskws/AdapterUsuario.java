package com.example.aluno.asynctaskws;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aluno on 13/07/18.
 */

public class AdapterUsuario extends BaseAdapter {
    List<Usuario> usuarios;
    Context contexto;

    public AdapterUsuario(Context context, List<Usuario> usuarios){
        this.contexto = context;
        this.usuarios = usuarios;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int position) {
        return usuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return usuarios.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewLinha = LayoutInflater.from(contexto).
                inflate(R.layout.linha_lista_usuario, parent, false);
        TextView textViewNome = (TextView) viewLinha.findViewById(R.id.linhaNome);
        TextView textViewIdade = (TextView) viewLinha.findViewById(R.id.linhaIdade);
        TextView textViewSexo = (TextView) viewLinha.findViewById(R.id.linhaSexo);

        Usuario usuario = (Usuario) getItem(position);

        textViewNome.setText(usuario.getNome());
        textViewIdade.setText(String.valueOf(usuario.getIdade()));
        textViewSexo.setText(usuario.getSexo());

        return viewLinha;
    }
}

