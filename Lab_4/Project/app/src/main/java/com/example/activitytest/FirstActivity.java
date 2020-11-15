package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1=(Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //响应弹窗
                //Toast.makeText(FirstActivity.this,"You click Button 1",Toast.LENGTH_SHORT).show();

                //显式调用
                //Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                //startActivity(intent);

                //隐式调用
                //Intent intent=new Intent("com.example.activitytest.ACTION_START");
                //intent.addCategory("com.example.activitytest.MY_CATEGORY");
                //startActivity(intent);

                //自定义Intent
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);

                //Intent intent=new Intent(Intent.ACTION_DIAL);
                //intent.setData(Uri.parse("tel:10086"));
                //startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return  true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }


}
