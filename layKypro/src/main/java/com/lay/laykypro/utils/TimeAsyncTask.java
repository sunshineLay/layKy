package com.lay.laykypro.utils;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimeAsyncTask extends AsyncTask<Integer,Integer,String> {
    private TextView textView;
    private Button btnStartup;

    public TimeAsyncTask(TextView textView, Button btnStartup) {
        this.textView = textView;
        this.btnStartup = btnStartup;
    }

    @Override
    protected String doInBackground(Integer... integers) {
        DelayOperator delayOperator = new DelayOperator();
        int i=0;
        for ( i = 4; i >= 0; i--) {

            delayOperator.delay();
            publishProgress(i);


        }
        return i + integers[0].intValue() + "";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
//        super.onProgressUpdate(values);
        int value=values[0];
        textView.setText(value+"");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        btnStartup.setVisibility(View.VISIBLE);

    }

}
