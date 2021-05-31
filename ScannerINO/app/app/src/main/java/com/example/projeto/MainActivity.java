package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    bem_vindo bemVindo = new bem_vindo();
    tela_comparacao telaComparacao = new tela_comparacao();
    tela_descricao telaDescricao = new tela_descricao();

    //Para o cadastro do codigo de barras
    EditText edtCodigo;

    EditText edtCodigoDois;

    //Para o cadastro do preço
    EditText edtPreco;

    EditText edtPrecoDois;

    //Para descrição
    EditText edtDescricao;

    EditText edtDescricaoDois;

    //para nome do produto
    EditText edtNome;

    EditText edtNomeDois;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cadastrar = this.findViewById(R.id.button);

        //para codigo de barras
        edtCodigo = (EditText) findViewById(R.id.codBarras);
        edtCodigoDois = (EditText) findViewById(R.id.codBarrasDois);
        //para preço
        edtPreco = (EditText) findViewById(R.id.preco);
        edtPrecoDois = (EditText) findViewById(R.id.precoDois);
        //para descrição
        edtDescricao = (EditText) findViewById(R.id.descricao);
        edtDescricaoDois = (EditText) findViewById(R.id.descricaoDois);
        //para nome do produto
        edtNome = (EditText) findViewById(R.id.nome);
        edtNomeDois = (EditText) findViewById(R.id.nomeDois);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clicar();

            }
        });

    }

    public void clicar(){

        //para codigo de barras
        bemVindo.codigo = edtCodigo.getText().toString();
        bemVindo.codigoDois = edtCodigoDois.getText().toString();
        //para preço
        bemVindo.preco = edtPreco.getText().toString();
        bemVindo.precoDois = edtPrecoDois.getText().toString();
        //para descrição
        telaDescricao.descricao = edtDescricao.getText().toString();
        telaDescricao.descricaoDois = edtDescricaoDois.getText().toString();
        //para nome do produto
        telaComparacao.nome = edtNome.getText().toString();
        telaComparacao.nomeDois = edtNomeDois.getText().toString();
        //mudar tela
        Intent intentUm = new Intent(getApplicationContext(), bem_vindo.class);
        //passar dados para outra tela
        /*Bundle parametros = new Bundle();
        parametros.putString("descricao", codigo);

        intentUm.putExtras(parametros);*/

        startActivity(intentUm);

    }

}