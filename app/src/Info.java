package com.example.hack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;

public class Info extends AppCompatActivity {

    ArrayList<String> allFlowers = new ArrayList<>();
    String objectName ="";
    String objectCost ="";
    String objecLength ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        allFlowers.add("TyxYhMKWsW");

        ImageView deneme6 = (ImageView)findViewById(R.id.imageView3);

        TextView text = findViewById(R.id.textViewName);
        TextView cost = findViewById(R.id.Cost);
        TextView length = findViewById(R.id.length);


        for(int i = 0 ; i < allFlowers.size() ; i++){
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Cicek");
            query.getInBackground(allFlowers.get(i), new GetCallback<ParseObject>() {
                @Override
                public void done(ParseObject object, ParseException e) {
                    if(e != null)
                        e.printStackTrace();
                    else{
                        objectName = object.getString("name");
                        objectCost= object.getString("fiyat");
                        objecLength= object.getString("length");
                    }

                }
            });
        }

        objectCost += "60TL";
        objecLength += "45CM";
        deneme6.setImageResource(R.drawable.a6);
        text.setText(objectName);
        cost.setText(objectCost);
        length.setText(objecLength);

    }

    public void ekle(View view) {

    }

    public void Anasayfaya_git(View view) {

        Intent ıntent = new Intent(getApplicationContext(),Flowers.class);
        startActivity(ıntent);
    }
}
