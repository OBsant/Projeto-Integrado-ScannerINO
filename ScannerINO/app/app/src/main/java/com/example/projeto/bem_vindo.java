package com.example.projeto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class bem_vindo extends AppCompatActivity {

    tela_comparacao telaComparacao = new tela_comparacao();

    //EditText edtBarra;
    //String barra;

    //String texto;

    //novas var

    //Para o cadastro do codigo de barras

    public static String codigo;

    public static String codigoDois;
    //Para o cadastro do preço

    public static String preco;

    public static String precoDois;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);


        //botão
        Button comparar = this.findViewById(R.id.comparar);
        //cod de barras
        //edtBarra = (EditText) findViewById(R.id.entradaBarras);

        comparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //barra = edtBarra.getText().toString();
                mudarTela();

            }
        });

    }


    public void mudarTela() {
        //magica não toque
        /*Intent intentRecebedoraUm = getIntent();
        Bundle parametros = intentRecebedoraUm.getExtras();*/

        //compara
        /*String compCodigoUm = parametros.getString("chaveUm");
        String compCodigoDois = parametros.getString("chaveDois");
        String compPreco = parametros.getString("precoUm");
        String compPrecoDois = parametros.getString("precoDois");*/

        try {
            AssetManager assetManager = getResources().getAssets();
            InputStream inputStream = assetManager.open("putty.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String linha;
            LinkedList<String> linhas = new LinkedList<String>();
            while((linha = bufferedReader.readLine())!=null){
                //aqui com o valor da linha vc pode testar o que quiser, por exemplo: linha.equals("123")
                if (codigo.equals(linha) || codigoDois.equals(linha)) {

                    if (Double.valueOf(preco) < Double.valueOf(precoDois)) {
                        //aqui o produto um é mais barato
                        telaComparacao.resultadoComparação = "baratoUm";
                        Intent intentDois = new Intent(getApplicationContext(), tela_comparacao.class);
                        Bundle parametroDois = new Bundle();
                        parametroDois.putString("chave", preco);
                        parametroDois.putString("chaveDois", precoDois);
                        intentDois.putExtras(parametroDois);
                        startActivity(intentDois);
                    } else if (Double.valueOf(preco) > Double.valueOf(precoDois)) {
                        //aqui o produto dois é mais barato
                        telaComparacao.resultadoComparação = "baratoDois";
                        Intent intentDois = new Intent(getApplicationContext(), tela_comparacao.class);
                        Bundle parametroDois = new Bundle();
                        parametroDois.putString("chave", preco);
                        parametroDois.putString("chaveDois", precoDois);
                        intentDois.putExtras(parametroDois);
                        startActivity(intentDois);
                    }

                }
                linhas.add(linha);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}