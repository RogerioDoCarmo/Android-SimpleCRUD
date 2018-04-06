package com.rogeriocarmo.simplecrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;

import static com.rogeriocarmo.simplecrud.FileHelper.readFromAssets;

public class Activity_Pesquisar extends AppCompatActivity {

    private String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__pesquisar1);

        try {
            String mensagens = readFromAssets(Activity_Pesquisar.this,"lista.xml");
            items = mensagens.split("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ListView listView = (ListView) findViewById(R.id.lvItens);
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);

    }
}
