package com.rogeriocarmo.simplecrud;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import static com.rogeriocarmo.simplecrud.FileHelper.readFromAssets;

public class activity_cad extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtSobrenome;
    private Button btnSalvar;
    private TextView lblResultado;
    private String novaLinha = "";

    private String nome;
    private String sobrenome;
    private TextView txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        txtNome = (EditText) findViewById(R.id.txtNomeID);
        txtSobrenome = findViewById(R.id.txtSobrenomeID);
        lblResultado = findViewById(R.id.lblResultID);
        btnSalvar = findViewById(R.id.btnSalvarID);

        txtContent = findViewById(R.id.txtContent);

        // Set the string as the message text
        lblResultado.setText(message);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nome = txtNome.getText().toString();
                sobrenome = txtSobrenome.getText().toString();

                if (nome.isEmpty()){
                    lblResultado.setText("Digite o nome!"); //TODO por um toast!
                }

                if (sobrenome.isEmpty()){
                    lblResultado.setText("Digite o sobrenome!"); // FIXME aqui tambem
                }
                String resultado = null;
                novaLinha = nome + sobrenome;
                try {
                    resultado = readFromAssets(activity_cad.this,"lista.xml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                txtContent.setText("lido do arquivo: " + resultado);

            }
        });


    }
}
