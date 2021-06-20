package com.example.shopinglist;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button buttonEkle,buttonListele,buttonSilme,buttonPaylasma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEkle = (Button)findViewById(R.id.buttonEkle);
        buttonListele = (Button)findViewById(R.id.buttonListele);
        buttonSilme = (Button)findViewById(R.id.buttonSilme);
        buttonPaylasma = (Button)findViewById(R.id.buttonPaylasma);

        buttonEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,AlisverisEkleme.class);
                startActivity(intent);
            }
        });

        buttonListele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,AlisverisListeleme.class);
                startActivity(intent);
            }
        });

        buttonSilme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,AlisverisSilme.class);
                startActivity(intent);
            }
        });

        buttonPaylasma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,AlisverisPaylasma.class);
                startActivity(intent);
            }
        });

    }
}