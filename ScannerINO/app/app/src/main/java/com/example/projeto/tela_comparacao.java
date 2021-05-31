package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tela_comparacao extends AppCompatActivity {

    tela_descricao telaDescricao = new tela_descricao();

    public static String resultadoComparação;

    //para nome do produto
    public static String nome;
    public static String nomeDois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tela_comparacao);
        TextView produtoUm = (TextView) findViewById(R.id.nomeIten);
        TextView produtoDois = (TextView) findViewById(R.id.nomeItenDois);
        TextView precoUm = (TextView) findViewById(R.id.precoIten);
        TextView precoDois = (TextView) findViewById(R.id.precoItenDois);
        Button irDescricao = this.findViewById(R.id.info);
        Button irDescricaoDois = this.findViewById(R.id.infoDois);

        //magica não toque
        Intent intentRecebedoraDois = getIntent();
        Bundle parametroDois = intentRecebedoraDois.getExtras();

        String precoUmm = parametroDois.getString("chave");
        String precoDoiss = parametroDois.getString("chaveDois");

        if(resultadoComparação.equals("baratoUm")){
            produtoUm.setText(nome);
            precoUm.setText("Preço:"+precoUmm);
            produtoDois.setText(nomeDois);
            precoDois.setText("Preço:"+precoDoiss);
        }else if(resultadoComparação.equals("baratoDois")){
            produtoUm.setText(nomeDois);
            precoUm.setText("Preço:"+precoDoiss);
            produtoDois.setText(nome);
            precoDois.setText("Preço:"+precoUmm);
        }

        irDescricao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                telaDescricao.contadorDois++;
                descri();

            }
        });

        irDescricaoDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                telaDescricao.contadorDois--;
                descriDois();

            }
        });


    }

    public void descri(){
        Intent intentTres = new Intent(getApplicationContext(), tela_descricao.class);
        Bundle parametroTres = new Bundle();
        parametroTres.putString("name", nome);
        parametroTres.putString("nameTwo", nomeDois);
        intentTres.putExtras(parametroTres);
        startActivity(intentTres);
    }

    public void descriDois(){
        Intent intentTres = new Intent(getApplicationContext(), tela_descricao.class);
        Bundle parametroTres = new Bundle();
        parametroTres.putString("name", nome);
        parametroTres.putString("nameTwo", nomeDois);
        intentTres.putExtras(parametroTres);
        startActivity(intentTres);
    }

}