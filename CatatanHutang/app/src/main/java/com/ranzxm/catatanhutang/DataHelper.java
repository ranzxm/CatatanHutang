package com.ranzxm.catatanhutang;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "pelanggan.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table pelanggan(nama_pel text null, tgl_dicatat text null, jumlah_hutang int null);";
        Log.d("Data", "onCreate" + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db1, int db2, int db3) {

    }
}
