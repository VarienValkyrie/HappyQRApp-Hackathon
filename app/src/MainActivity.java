package com.example.hack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    public Button button;
    public String input = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.loginButton);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                TextView email = findViewById(R.id.emailTxt);
                TextView pasword = findViewById(R.id.passwordTxt);
                Intent intent = null;

                if(email.length() == 0){
                    input = "--";
                }else {

                    try {
                        readFromFile(email.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("-----------------------------------------------");
                System.out.println("______ " + input + "______" + pasword.getText().toString());


                if(input.equals(pasword.getText().toString())){
                    Intent ıntent = new Intent(getApplicationContext(),Flowers.class);
                    startActivity(ıntent);

                }else{
                    Toast toast1=Toast.makeText(getApplicationContext(),"Wrong Password or Email",Toast.LENGTH_SHORT);
                    toast1.setMargin(BIND_ABOVE_CLIENT,BIND_AUTO_CREATE);
                    toast1.show();
                }


            }
        });
    }


    public void readFromFile(String name) throws JSONException, IOException {
        String in = "/home/samet/Desktop/deneme.json";
        //getResources().openRawResource(R.raw.deneme);
        System.out.println("----------" + name);
        InputStreamReader isr = null;
        BufferedReader br = null;
        InputStream is =
                getResources().openRawResource(R.raw.deneme);
        StringBuilder sb = new StringBuilder();
        String content;
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            while ((content = br.readLine()) != null) {
                sb.append(content);
            }
            isr.close();
            br.close();

        String mystring = sb.toString();
        JSONObject reader = new JSONObject(mystring);

        JSONObject sys  = reader.getJSONObject("user");
        input = sys.getString(name);
        if(input == ""){
            input = "-";
        }
        System.out.println("__________________"  + input);

        // putting data to JSONObject

    }
}
