package com.example.aluno.asynctaskws;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.aluno.asynctaskws.Banco.DAOUsuarios;

public class TelaCadastrar extends AppCompatActivity {

    Usuario usuario = new Usuario();
    EditText editTextNome;
    EditText editTextIdade;
    RadioButton radioButtonMasculino;
    RadioButton radioButtonFeminino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar);

        editTextNome = (EditText) findViewById(R.id.textNome);
        editTextIdade = (EditText) findViewById(R.id.textIdade);
        radioButtonMasculino = (RadioButton) findViewById(R.id.radioMasculino);
        radioButtonFeminino = (RadioButton) findViewById(R.id.radioFeminino);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("id")) {
            Integer id = bundle.getInt("id");
            Log.i("Tela", "" + id);
            Usuario usuario = new DAOUsuarios(this).buscarPorId(id);
            editTextNome.setText(usuario.getNome());
            editTextIdade.setText(String.valueOf(usuario.getIdade()));
            if (usuario.getSexo().equals("M")) {
                radioButtonMasculino.setChecked(true);
            } else {
                radioButtonFeminino.setChecked(true);
            }
        }
    }

    public void inserir(View view) {

        Intent intent = new Intent(this, ListaUsuarios.class);
        startActivity(intent);


        usuario.setNome(editTextNome.getText().toString());
        usuario.setIdade(Integer.parseInt(editTextIdade.getText().toString()));
        if (radioButtonMasculino.isChecked()) {
            usuario.setSexo("M");
        } else {
            usuario.setSexo("F");
        }
        if (usuario.getId() == null) {
            new DAOUsuarios(this).inserir(usuario);
        } else {
            new DAOUsuarios(this).alterar(usuario);
        }

        //Solução ruim
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
        finish();
    }
}
