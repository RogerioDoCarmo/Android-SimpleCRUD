package com.rogeriocarmo.simplecrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.rogeriocarmo.simplecrud.FileHelper.readFromRawAssets;

public class Activity_Pesquisar extends AppCompatActivity {

    private TextView txtNome;
    private Button btnPesquisar;
    private String[] items;
    public String mensagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__pesquisar1);

        this.txtNome = findViewById(R.id.txtNomeID);
        this.btnPesquisar = findViewById(R.id.btnPesquisarID);

        try {
            this.mensagens = readFromRawAssets(Activity_Pesquisar.this,"lista.xml");
            items = mensagens.split("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        final ListView listView = (ListView) findViewById(R.id.lvItens);
        final ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);

        // TODO refatorar para não precisar duplicar o adapter!
        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> novoTexto = new ArrayList<>();
                String textoBusca = txtNome.getText().toString();
                String[] mensagemLinhas = mensagens.split("\n");

                for (int i = 0; i < mensagemLinhas.length; i++){
                    if (mensagemLinhas[i].contains(textoBusca)){
                        novoTexto.add(mensagemLinhas[i]);
                    }
                }

                if (novoTexto.isEmpty()) return;

                items = Arrays.copyOf(novoTexto.toArray(),novoTexto.size(),String[].class);

                // Easter Egg topper
                if (textoBusca.equalsIgnoreCase("Junji"))
                    items =  new String[]{"Lixo"};

                ArrayAdapter<String> itemsAdapter2 =
                        new ArrayAdapter<String>(Activity_Pesquisar.this, android.R.layout.simple_list_item_1, items);
                itemsAdapter2.notifyDataSetChanged();
                listView.setAdapter(itemsAdapter2);
            }
        });

    }


}
