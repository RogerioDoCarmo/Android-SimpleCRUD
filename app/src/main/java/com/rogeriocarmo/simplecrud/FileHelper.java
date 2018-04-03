package com.rogeriocarmo.simplecrud;

/**
 * Created by Rogerio on 28/03/2018.
 */

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.content.res.AssetManager;

import static android.content.res.AssetManager.ACCESS_STREAMING;

/**
 * Created by Tan on 2/18/2016.
 */
public class FileHelper {

    public static String readFromAssets(Context context, String filename) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(filename)));
        BufferedReader reader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.lista)));

        // do reading, usually loop until end of file reading
        StringBuilder sb = new StringBuilder();
        String mLine = reader.readLine();
        while (mLine != null) {
            sb.append(mLine + "\n"); // process line
            mLine = reader.readLine();
        }
        reader.close();
        return sb.toString();
    }

}