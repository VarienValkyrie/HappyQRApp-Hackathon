package com.example.hack;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bayi {
    ArrayList<String> fileNames = new ArrayList<>();
    ArrayList<String> percentVote = new ArrayList<>();
    ArrayList<String> bestSaller = new ArrayList<>();

    TextView txtFile;

    public void read(Context myContext){
       String text = "";
       try{
           AssetManager mngr = myContext.getAssets();
           InputStream inputStream = mngr.open("b1.txt");
           int size = inputStream.available();
           byte[] buffer = new byte[size];
           inputStream.read(buffer);
           inputStream.close();
           text = new String(buffer);
       } catch (IOException e) {
           e.printStackTrace();
       }
       txtFile.setText(text);

       System.out.println("---------" + text);
       //Toast.makeText(getApplicationContext(),"The file read operation is finished successfully.",
        //       Toast.LENGTH_SHORT).show();
   }
}

