package com.example.food;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settupButtons();
        /**
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }**/
    }

    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            Intent intent;
            intent = new Intent(this, Tomato.class);
            startActivity(intent);
        }/**
        if (v.getId() == R.id.btToHello2) {
            Intent intent;
            intent = new Intent(this, Hello2.class);
            startActivity(intent);
        }**/
      /**  if (v.getId() == R.id.btToHello3) {
            Intent intent;
            String string1 = "com.example.helloworld.intent.action.H3";
            // intent = new Intent(this, Hello3.class);
            intent = new Intent(string1);
            startActivity(intent);
//            Intent intent1 = new Intent(Intent.ACTION_VIEW);
//            intent1.setData(Uri.parse("http://www.hstc.edu.cn"));
//            startActivity(intent1);
        }**/
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "onPostResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
    private void settupButtons() {
        Button b;
        b = (Button) findViewById(R.id.button1);
        //b.setOnClickListener(this);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Tomato.class);
                startActivity(intent);
            }
        });
        b = (Button) findViewById(R.id.button4);
        //b.setOnClickListener(this);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Potato.class);
                startActivity(intent);
            }
        });
    }
}
