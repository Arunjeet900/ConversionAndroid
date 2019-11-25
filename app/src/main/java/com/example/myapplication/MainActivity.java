package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etFah, etCel;
    Button btnConv, btnClr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFah = findViewById(R.id.Fah);
        etCel = findViewById(R.id.Cel);
        btnConv = findViewById(R.id.Conv);
        btnClr = findViewById(R.id.Clr);

        //register the buttoon as clicklistener
        btnClr.setOnClickListener(this);
        btnConv.setOnClickListener(this);

    }
    public void onClick(View v)
    {

       switch (v.getId()){
           case R.id.Clr:
               etFah.setText("");
               etCel.setText("");
               break;
           case R.id.Conv:
               if(etFah.getText().toString().equals(""))
               {
                   //convert from celcius to fahrenheit
                   double cel = Double.parseDouble(etCel.getText().toString());
                   double f = cel*(9.0/5.0)+32;
                   Double result = new Double(f);
                   etFah.setText(result.toString());

               }
               else if(etCel.getText().toString().equals(""))
               {
                   //convert from fahrenheit to celcius
                   double f = Double.parseDouble(etFah.getText().toString());
                   double cel = (f-32)*(5.0/9.0);
                   Double result = new Double(cel);
                   etCel.setText(result.toString());
               }
               else //it means if both empty
                   Toast.makeText(getApplicationContext(),"Please enter the temperature that you want to convert",Toast.LENGTH_LONG).show();
       }


    }
}
