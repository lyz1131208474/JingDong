package com.example.administrator.jingdong.Fragment.WoDe.DengLu.SouSuo.MySqlDao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySql extends SQLiteOpenHelper {

    public MySql(Context context){
        super(context, "search.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "create table search(id integer primary key autoincrement,name varchar(20))";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
