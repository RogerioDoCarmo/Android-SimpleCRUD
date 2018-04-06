package com.rogeriocarmo.simplecrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.rogeriocarmo.simplecrud.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


  }


    public void iniciarTela_Cadastro(View view) {
        Intent intent = new Intent(this, activity_cad.class);
        String message = "Cadastro";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void iniciarTela_Pesquisa(View view) {
        Intent intent = new Intent(this, Activity_Pesquisar.class);
        String message = "Pesquisa";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}

