package com.example.admin.asynccounter;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by admin on 4/8/2016.
 */
public class AsyncCounter extends AsyncTask<Void, Integer, Void> {
    private TextView mTextView;

    public AsyncCounter(TextView mTv){
        mTextView = mTv;
    }
    @Override
    protected Void doInBackground(Void... params) {

        for(int i = 1; i <= 1000; i++){
            publishProgress(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        mTextView.setText(Integer.toString(values[0]));
        Log.d("TAG", "onProgressUpdate: " + Integer.toString(values[0]));
    }
}
