package com.example.aluno.asynctaskws.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.aluno.asynctaskws.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluno on 13/07/18.
 */

public class DAOUsuarios {

    SQLiteDatabase database;

    public DAOUsuarios(Context context){
        database = new BDCore(context).getWritableDatabase();
    }

    public void inserir(Usuario usuario){
        Log.i("DAOUsuarios",usuario.getNome());
        ContentValues values = new ContentValues();
        values.put("nome",usuario.getNome());
        values.put("idade",usuario.getIdade());
        values.put("sexo", usuario.getSexo());
        database.insert("usuarios",  null, values);
    }
    public void excluir(Integer id){
        database.delete("usuarios","id=?",
                new String[]{String.valueOf(id)});

        //database.delete("lancamentos","id="+id,null);
    }
    public void alterar(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("nome",usuario.getNome());
        values.put("idade",usuario.getIdade());
        values.put("sexo", usuario.getSexo());
        database.update("usuarios",values,
                "id="+usuario.getId(),null);
    }
    public List<Usuario> consultar(){
        List<Usuario> usuarios = new ArrayList<>();
        String[] colunas = {"id", "nome", "idade", "sexo"};
        Cursor cursor = database.query("usuarios", colunas,
                null,null,null,null,
                null);
        cursor.moveToFirst();
        for(int x=0; x<cursor.getCount(); x++){
            Usuario usuario = new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNome(cursor.getString(1));
            usuario.setIdade(cursor.getInt(2));
            usuario.setSexo(cursor.getString(3));
            usuarios.add(usuario);
            cursor.moveToNext();
        }
        return usuarios;
    }

    public Usuario buscarPorId(Integer id){
        Usuario usuario = new Usuario();
        String[] colunas = {"id", "nome", "idade", "sexo"};
        Cursor cursor = database.query("usuarios", colunas,
                "id="+id,null,null,null,
                null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            usuario.setId(cursor.getInt(0));
            usuario.setNome(cursor.getString(1));
            usuario.setIdade(cursor.getInt(2));
            usuario.setSexo(cursor.getString(3));
        }
        return usuario;
    }

}
