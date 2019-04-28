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

public class Main2Activity extends AppCompatActivity {

    ArrayList<String> allFlowers = new ArrayList<>();
    ArrayList<String> objectName = new ArrayList<>();
    int number ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        allFlowers.add("weqeIJ0fEC");
        allFlowers.add("aR8Ccwx5oH");
        allFlowers.add("MLA7smYsBL");
        allFlowers.add("E4wcWQytqM");
        allFlowers.add("bSuw5pxhrU");
        allFlowers.add("TyxYhMKWsW");
        allFlowers.add("IB8yqgmPhE");
        allFlowers.add("l9T14ahjQk");
        allFlowers.add("Af5GBjtbHb");
        allFlowers.add("sC8wym0G1j");
        allFlowers.add("z0DVXPff9o");

        ImageView deneme1 = findViewById(R.id.cicek1);
        ImageView deneme2 = findViewById(R.id.cicek2);
        ImageView deneme3 = findViewById(R.id.cicek3);
        ImageView deneme4 = findViewById(R.id.cicek4);
        ImageView deneme5 = findViewById(R.id.cicek5);
        ImageView deneme6 = findViewById(R.id.cicek6);
        ImageView deneme7 = findViewById(R.id.cicek7);
        ImageView deneme8 = findViewById(R.id.cicek8);
        ImageView deneme9 = findViewById(R.id.cicek9);

        TextView  text1 = findViewById(R.id.editText1);
        TextView  text2 = findViewById(R.id.editText2);
        TextView  text3 = findViewById(R.id.editText3);
        TextView  text4 = findViewById(R.id.editText4);
        TextView  text5 = findViewById(R.id.editText5);
        TextView  text6 = findViewById(R.id.editText6);
        TextView  text7 = findViewById(R.id.editText7);
        TextView  text8 = findViewById(R.id.editText8);
        TextView  text9 = findViewById(R.id.editText9);

        for(int i = 0 ; i < allFlowers.size() ; i++){
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Cicek");
            query.getInBackground(allFlowers.get(i), new GetCallback<ParseObject>() {
                @Override
                public void done(ParseObject object, ParseException e) {
                    if(e != null)
                        e.printStackTrace();
                    else{
                        objectName.add(object.getString("File_name"));

                    }

                }
            });
        }


        deneme1.setImageResource(R.drawable.a1);
        deneme2.setImageResource(R.drawable.a2);
        deneme4.setImageResource(R.drawable.a3);
        deneme9.setImageResource(R.drawable.a4);
        deneme5.setImageResource(R.drawable.a5);
        deneme2.setImageResource(R.drawable.a6);
        deneme7.setImageResource(R.drawable.a7);
        deneme8.setImageResource(R.drawable.a8);
        deneme6.setImageResource(R.drawable.a9);

        text1.setText("1001");
        text2.setText("1002");
        text3.setText("1003");
        text4.setText("1004");
        text5.setText("1005");
        text6.setText("1006");
        text7.setText("1007");
        text8.setText("1008");
        text9.setText("1009");
    }

    public void gönder(View view) {
        Intent ıntent2 = new Intent(getApplicationContext(),Info.class);
        startActivity(ıntent2);

    }

    public void Anasayfaya_git(View view) {
        Intent ıntent = new Intent(getApplicationContext(),Flowers.class);
        startActivity(ıntent);
    }
}
