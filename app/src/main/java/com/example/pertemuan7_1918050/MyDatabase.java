package com.example.pertemuan7_1918050;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_Alkohol";
    private static final String tb_Alkohol = "tb_Alkohol";
    private static final String getTb_Alkohol_id = "id";
    private static final String getTb_Alkohol_nama = "nama";
    private static final String getTb_Alkohol_harga = "harga";
    private static final String CREATE_TABLE_ALKOHOL = "CREATE TABLE " + tb_Alkohol +"("
            + getTb_Alkohol_id + " INTEGER PRIMARY KEY ,"
            + getTb_Alkohol_nama + " TEXT ,"
            + getTb_Alkohol_harga + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ALKOHOL);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateAlkohol(Alkohol data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(getTb_Alkohol_id, data.get_id());
        values.put(getTb_Alkohol_nama, data.get_nama_produk());
        values.put(getTb_Alkohol_harga, data.get_harga());
        db.insert(tb_Alkohol, null, values);
        db.close();
    }
    public List<Alkohol> ReadAlkohol() {
        List<Alkohol> listMhs = new ArrayList<Alkohol>();
        String selectQuery = "SELECT * FROM " + tb_Alkohol;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Alkohol data = new Alkohol();
                data.set_id(cursor.getString(0));
                data.set_nama_produk(cursor.getString(1));
                data.set_harga(cursor.getString(2));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdateAlkohol (Alkohol data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(getTb_Alkohol_nama, data.get_nama_produk());
        values.put(getTb_Alkohol_harga, data.get_harga());
        return db.update(tb_Alkohol, values, getTb_Alkohol_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteAlkohol(Alkohol data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_Alkohol,getTb_Alkohol_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
