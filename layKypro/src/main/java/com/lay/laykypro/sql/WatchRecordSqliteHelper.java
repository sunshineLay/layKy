package com.lay.laykypro.sql;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WatchRecordSqliteHelper extends SQLiteOpenHelper {

    public WatchRecordSqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public WatchRecordSqliteHelper(Context context){
        super(context,"watchrecord.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE  WATCHRECORD (_id INTEGER PRIMARY KEY AUTOINCREMENT , IMGURL VARCHAR(100), TITLE VARCHAR(20),CATEGORY VARCHAR(20),OLDID INTEGER(8),TYPE VARCHAR(20))";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //升级的时候用的

    }
}
