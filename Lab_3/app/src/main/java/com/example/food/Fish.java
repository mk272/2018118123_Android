package com.example.food;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Fish extends AppCompatActivity implements View.OnClickListener{
    private final static String TAG = "Tomato";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fish);
        settupButtons();
        setTitle("鱼胆");
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
    public void onClick(View v) {
        if (v.getId() == R.id.button6) {
            Intent intent;
            intent = new Intent(this, Fish.class);
            startActivity(intent);
        }
    }
    private void settupButtons() {
        Button b;
        b = (Button) findViewById(R.id.back);
        //b.setOnClickListener(this);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Fish.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
