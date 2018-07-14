package com.example.aluno.asynctaskws;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrarImagem(View view){
        BuscarImagem buscarImagem = new BuscarImagem(this);
        buscarImagem.execute("https://www.torcedores.com/content/uploads/2018/06/noticiasdocorinthians.jpg");
    }

    public void telaCadastrar(View view){
        Intent intent = new Intent(this, TelaCadastrar.class);
        startActivity(intent);
    }

    public void chamaWebService(View view){
        Intent intent = new Intent(this, WebService.class);
        startActivity(intent);
    }


}
