package com.example.final_task;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    private SQLiteDatabase db;
    private DBOpenHelper dbOpenHelper;

    private Context mContext;
    private ListView list_memo;
    private MyAdapter<memo>myAdapter=null;
    private ArrayList<memo> mData=null;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.my_main);
        setContentView(R.layout.my_main2);
        //toolbar=parentView.findViewById(R.id.toolbar);
        mContext=MainActivity.this;
        //toolbar_init();
        toolbar =(Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //.inflateMenu(R.menu.menu_main);
        init();

    }


    /**
    private void toolbar_init(){
        //导航栏初始化
        toolbar =findViewById(R.id.main_toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setTitle("");
        toolbar.inflateMenu(R.menu.menu_main);
        //setSupportActionBar(toolbar);
        //toolbar左侧返回按钮 返回事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_delete_note:

                    case R.id.memo_check:

                }
                return false;
            }
        });
    }
    /****/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.search:
                Toast.makeText(this,"You click",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
    private void init(){

        //获取控件对象
        addBtn=(Button)findViewById(R.id.fab);
        list_memo=(ListView)findViewById(R.id.list_memo);

        //数据库变量初始化
        dbOpenHelper = new DBOpenHelper(mContext, "My_memo.db", null, 1);
        db = dbOpenHelper.getWritableDatabase();

        //数据初始化
        mData=new ArrayList<memo>();
        mData.add(new memo("测试标题1","备忘录内容1"));
        mData.add(new memo("测试标题2","备忘录内容2"));
        reFlashListView(mData);
        myAdapter=new MyAdapter<memo>((ArrayList)mData,R.layout.item) {
            @Override
            public void bindView(MyAdapter.ViewHolder holder, memo obj) {
                holder.setText(R.id.itemTitle,obj.getTitle());
                holder.setText(R.id.itemDate,obj.getDate());
            }
        };
        list_memo.setAdapter(myAdapter);
        //ListView单击事件，跳转到当前备忘信息
        list_memo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //传递数据到edit_memo
                memo my_memo =mData.get(position);
                Intent intent=new Intent(MainActivity.this,edit_memo.class);
                intent.putExtra("memo_data",my_memo);
                intent.putExtra("flag",0);
                startActivity(intent);

            }
        });
        //跳转到添加界面
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,edit_memo.class);
                intent.putExtra("flag",1);
                startActivity(intent);
            }
        });

    }

    private void reFlashListView(ArrayList<memo>mData){
        //参数依次是:表名，列名，where约束条件，where中占位符提供具体的值，指定group by的列，进一步约束
        //指定查询结果的排序方式
        //Cursor cursor = db.query("memo_1", new String[]{"title","modified_date"}, null, null, null, null, null);
        Cursor cursor =  db.rawQuery("SELECT id,title,content,modified_date,memoType,alarm_date FROM memo_1 ", null);
        if (cursor.moveToFirst()) {
            do {
                int id=cursor.getInt(cursor.getColumnIndex("id"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String content = cursor.getString(cursor.getColumnIndex("content"));
                String date = cursor.getString(cursor.getColumnIndex("modified_date"));
                String memoType = cursor.getString(cursor.getColumnIndex("memoType"));
                String alarm_date = cursor.getString(cursor.getColumnIndex("alarm_date"));
                System.out.println("main:"+memoType);
                mData.add(new memo(id,title,content,date,memoType,alarm_date));

            } while (cursor.moveToNext());
        }
        cursor.close();

    }


}
