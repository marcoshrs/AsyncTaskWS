package com.example.aluno.asynctaskws;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.aluno.asynctaskws.Banco.DAOUsuarios;

import java.util.List;

public class ListaUsuarios extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        listView = findViewById(R.id.listaUsuarios);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Usuario> listaUsuarios = new DAOUsuarios(this).consultar();
        AdapterUsuario adapterUsuario = new AdapterUsuario(this, listaUsuarios);
        listView.setAdapter(adapterUsuario);
    }

    public void novoCadastro(View view){
        Intent intent = new Intent(this, TelaCadastrar.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, TelaCadastrar.class);
        intent.putExtra("id",Integer.parseInt(String.valueOf(id)));
        startActivity(intent);
    }

    private void atualizarLista(){
        List<Usuario> listaUsuarios = new DAOUsuarios(this).consultar();
        AdapterUsuario adapterUsuario = new AdapterUsuario(this, listaUsuarios);
        listView.setAdapter(adapterUsuario);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        final DAOUsuarios daoUsuarios = new DAOUsuarios(this);
        final long idExcluir = id;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja Excluir o Registro??")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        daoUsuarios.excluir(Integer.parseInt(String.valueOf(idExcluir)));
                        atualizarLista();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        builder.show();

        return true;
    }

}
