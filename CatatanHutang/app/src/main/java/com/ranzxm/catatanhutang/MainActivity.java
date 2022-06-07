package com.ranzxm.catatanhutang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    String[] daftar;
    ListView daftar_pelanggan;
    Menu menu;
    protected Cursor cursor;
    DataHelper database;
    public static MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton nav_tambah = findViewById(R.id.nav_tambah);
        nav_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beralih = new Intent(MainActivity.this, InputHutang.class);
                startActivity(beralih);
            }
        });
        ma = this;
        database = new DataHelper(this);
        RefreshList();
    }

    private void RefreshList() {
        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pelanggan", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int i = 0; i< cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            daftar[i] = cursor.getString(0).toString();
        }

        daftar_pelanggan = (ListView) findViewById(R.id.daftar_pelanggan);
        daftar_pelanggan.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        daftar_pelanggan.setSelected(true);

//        https://www.youtube.com/watch?v=lOfEi_yarzw&ab_channel=NicoFernades TIME : 27:30

    }
}