package com.example.administrator.jingdong.Fragment.WoDe.DengLu.SouSuo.MySqlDao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MySqlDao {
    private MySql mySQlite;
    private SQLiteDatabase db;

    public MySqlDao(Context context){
        mySQlite = new MySql(context);
        db = mySQlite.getReadableDatabase();
    }

    public void add(String name){
        ContentValues values = new ContentValues();
        values.put("name",name);
        db.insert("search",null,values);
    }

    public void delete(String name){
        db.delete("search","name=?",new String[]{name});
    }

    public void deleteAll(){
        db.execSQL("DELETE FROM search");
    }

    public List<String> select(){
        Cursor cursor = db.rawQuery("select * from search",null);
        List<String> list = new ArrayList<>();

        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            list.add(name);
        }

        return list;
    }

}
