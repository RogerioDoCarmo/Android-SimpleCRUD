package com.rogeriocarmo.simplecrud;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class activity_alt extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alt);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);

        try {
            saveOnDisk();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveOnDisk() throws IOException {
        String[] teste = new String[]{"Bankai\n","Tensa Zangetsu xD\n"};

        if (FileHelper.isExternalStorageWritable()){
            Context context = getApplicationContext();
            CharSequence text = "Espaço Disponível!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        File novoArquivo = FileHelper.getPrivateStorageDir(this,"BANKAI.txt");

        Toast.makeText(getApplicationContext(),
                "Espaço disponível: " + novoArquivo.getFreeSpace() + " bytes",
                Toast.LENGTH_SHORT).show();

        FileHelper.writeTxtFile2External(novoArquivo, teste);

        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, "Caminho do Storage: " + novoArquivo.getAbsolutePath(), Snackbar.LENGTH_LONG);
        snackbar.show();

    }
}
