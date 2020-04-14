package com.example.kitetsu_adc2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Managedb extends SQLiteOpenHelper {
    private static final String dbname= "user.db";
    public Managedb( Context context ) {
        super(context,dbname, null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="create table tbl_user (id integer primary key autoincrement, name text, pwd text)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_user");
        onCreate(db);
    }

    public String saveRegister(String p1, String p2){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("name",p1);
        cv.put("pwd",p2);
        long res=db.insert("tbl_user", null,cv);

        if(res==-1)
            return "Failed";
        else
            return "Successfully Registered";


    }

}

