package com.lay.laykypro.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lay.laykypro.base.IBackRequestCallBack;
import com.lay.laykypro.sql.WatchRecordSqliteHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WatchListDataModel implements WatchListDataInter {

    @Override
    public void getWatchDataFromSql(Context context, IBackRequestCallBack<List<HashMap<String, Object>>> iBackRequestCallBack) {
        ArrayList<HashMap<String,Object>> hashMapArrayList=new ArrayList<>();
        //sqlite
        WatchRecordSqliteHelper watchRecordSqliteHelper = new WatchRecordSqliteHelper(context);
        SQLiteDatabase watchSql = watchRecordSqliteHelper.getReadableDatabase();
        //第一种，不分页
        String sql="select * from watchrecord";
        //select * from 表名;

        Cursor cursor = watchSql.rawQuery(sql, null);

        //第二种，分页
//        int index=(Count-1)*5;
//        Cursor cursor = watchSql.rawQuery("select *from watchrecord limit ?,5",new String[]{index+""});

        while(cursor.moveToNext()){
            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
            String imgurl=cursor.getString(cursor.getColumnIndex("IMGURL"));
            String category = cursor.getString(cursor.getColumnIndex("CATEGORY"));
            String title = cursor.getString(cursor.getColumnIndex("TITLE"));
            int oldid = cursor.getInt(cursor.getColumnIndex("OLDID"));
            String type = cursor.getString(cursor.getColumnIndex("TYPE"));

            stringObjectHashMap.put("type",type);
            stringObjectHashMap.put("oldid",oldid);
            stringObjectHashMap.put("imgurl",imgurl);
           stringObjectHashMap.put("category",category);
           stringObjectHashMap.put("title",title);

           hashMapArrayList.add(stringObjectHashMap);
        }
        watchSql.close();

        iBackRequestCallBack.requestSuccess(hashMapArrayList);
    }
}
