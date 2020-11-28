package com.example.servicetest2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }



    public void onCreate(){
        super.onCreate();
        Log.d("MyService","onCreate executed");
    }

    public int onStartCommand(Intent intent,int flags,int startId){
        Log.d("MyService","onStartCommand executed");
        return super.onStartCommand(intent,flags,startId);
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d("MyService","onDestory executed");
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}

