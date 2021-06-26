package com.example.shopinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class AlisverisListeleme extends AppCompatActivity {

    RecyclerView rvAlisveris;
    RecyclerView.LayoutManager layoutManager;
    DatabaseHelper databaseHelper;
    AlisverisAdapter alisverisAdapter;
    List<Alisveris> alisverisList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alisveris_listeleme);

        databaseHelper = new DatabaseHelper(this);
        alisverisList = databaseHelper.getAllAlisveris();
        rvAlisveris = findViewById(R.id.rvAlisveris);
        rvAlisveris.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvAlisveris.setLayoutManager(layoutManager);
        alisverisAdapter = new AlisverisAdapter(this,alisverisList,rvAlisveris);
        rvAlisveris.setAdapter(alisverisAdapter);

    }
}