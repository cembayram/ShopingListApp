package com.example.shopinglist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import android.os.Bundle;

public class AlisverisEkleme extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    Button AlısverisKaydet;
    EditText alisverisAdi_s,urunAdi_s,urunMiktari_s,urunAdedi_s,urunFiyati_s,urunNot_s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alisveris_ekleme);
        databaseHelper = new DatabaseHelper(this);

        // references to buttons and other contorls on the layout
        AlısverisKaydet = findViewById(R.id.buttonUrunKaydet);
        alisverisAdi_s = findViewById(R.id.alisverisAdi);
        urunAdi_s = findViewById(R.id.urunAdi);
        urunMiktari_s = findViewById(R.id.urunMiktari);
        urunAdedi_s = findViewById(R.id.urunAdedi);
        urunFiyati_s = findViewById(R.id.urunFiyati);
        urunNot_s = findViewById(R.id.urunNot);

        AlısverisKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String alisverisAdi = alisverisAdi_s.getText().toString();
                String urunAdi = urunAdi_s.getText().toString();
                String urunMiktari = urunMiktari_s.getText().toString();
                String urunAdedi = urunAdedi_s.getText().toString();
                String urunFiyati =urunFiyati_s.getText().toString();
                String urunNot =urunNot_s.getText().toString();
                if(alisverisAdi.equals("") || urunAdi.equals("") || urunMiktari.equals("") || urunAdedi.equals("")
                        || urunFiyati.equals("") || urunNot.equals("")){
                    Toast.makeText(getApplicationContext(), "Alanları doldurmak zorunlu", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    boolean ekle = databaseHelper.shoppingAdd(alisverisAdi,urunAdi,urunMiktari,urunAdedi,urunFiyati,urunNot);
                    if(ekle == true)
                    {
                        Toast.makeText(getApplicationContext(), "Ürün eklemesi yapıldı.", Toast.LENGTH_SHORT).show();
                        urunAdi_s.setText("");
                        urunMiktari_s.setText("");
                        urunAdedi_s.setText("");
                        urunFiyati_s.setText("");
                        urunNot_s.setText("");
                    }
                    else
                    {
                        Toast.makeText(AlisverisEkleme.this,"Ürün kaydedilirken bir hata oldu",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}