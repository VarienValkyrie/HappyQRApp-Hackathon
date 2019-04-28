package com.example.hack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class sepet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sepet);
    }

    public void Anasayfaya_git(View view) {

        Intent ıntent = new Intent(getApplicationContext(),Flowers.class);
        startActivity(ıntent);
    }
}
