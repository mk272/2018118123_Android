package com.example.servicetest2;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;


public class MyIntentService extends IntentService {

    /**
     *
     * @deprecated
     */
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //打印当前进程的ID
        Log.d("MyIntentService","Thread id is"+Thread.currentThread().getId());
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d("MyIntentService","onDestroy executed");
    }
}
