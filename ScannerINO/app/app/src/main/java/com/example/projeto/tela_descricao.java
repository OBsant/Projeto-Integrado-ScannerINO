package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class tela_descricao extends AppCompatActivity {

    //Para descrição

    public static String descricao;

    public static String descricaoDois;

    public static int contadorDois = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_descricao);

        Intent intentRecebedoraTres = getIntent();
        Bundle parametroTres = intentRecebedoraTres.getExtras();

        String nameVar = parametroTres.getString("name");
        String nameVarTwo = parametroTres.getString("nameTwo");

        TextView descriProd = (TextView) findViewById(R.id.descricaoProd);
        TextView nomeProd = (TextView) findViewById(R.id.nomeTelaDescri);


        if(contadorDois == 2){
            descriProd.setText(descricao);
            nomeProd.setText(nameVar);
            contadorDois--;
        }else if(contadorDois == 0){
            descriProd.setText(descricaoDois);
            nomeProd.setText(nameVarTwo);
            contadorDois++;
        }

    }
}