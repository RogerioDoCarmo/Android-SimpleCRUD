package com.rogeriocarmo.simplecrud;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;

public class activity_alt extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alt);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);

        saveOnDisk();
    }

    private void saveOnDisk(){
        String[] teste = new String[]{"Oi","Lalala"};

        if (FileHelper.isExternalStorageWritable()){
            Context context = getApplicationContext();
            CharSequence text = "Espaço Disponível!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        File novoArquivo = FileHelper.getPrivateAlbumStorageDir(this,"GNSSlogs");

        Toast.makeText(getApplicationContext(),
                "Espaço disponível: " + novoArquivo.getFreeSpace(),
                Toast.LENGTH_SHORT).show();


        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, "Caminho do Storage: " + novoArquivo.getAbsolutePath(), Snackbar.LENGTH_INDEFINITE);
        snackbar.show();

    }
}
