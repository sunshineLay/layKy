package com.lay.laykypro.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyTimeUtils {

    public static String timeFormatFromInt(int releaseTime){
        String timeS="%02d:%02d";
        int hour=releaseTime/1000/3600%24;
        int minute=releaseTime/1000%3600/60;
        return String.format(timeS,hour,minute);
    }
    public static String timeFormInt(long time){
        Calendar c=Calendar.getInstance();
//        int seconds = 1514871613;//数据库中提取的数据
        long millions=new Long(time).longValue()*1000;
        c.setTimeInMillis(millions);
//        System.out.println(""+c.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
        String dateString = sdf.format(c.getTime());
//        System.out.println(dateString);
        return dateString;
    }
}
