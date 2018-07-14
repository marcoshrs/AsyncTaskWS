package com.example.aluno.asynctaskws;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class WebService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);
    }

    public void enviarWS(View view){

        String altura = ((EditText) findViewById(R.id.textAltura)).getText().toString();
        String nome = ((EditText) findViewById(R.id.textNome)).getText().toString();
        String peso = ((EditText) findViewById(R.id.textPeso)).getText().toString();
        String usuario = ((EditText) findViewById(R.id.textUsuario)).getText().toString();
        Imc imc = new Imc();
        imc.setAltura(altura);
        imc.setNome(nome);
        imc.setPeso(peso);
        imc.setUsuario(usuario);


        EnviarImcWS enviarImcWS = new EnviarImcWS(this);
        enviarImcWS.execute(imc);

    }
}
