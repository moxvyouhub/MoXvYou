package com.myapp.moxvyou.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.myapp.moxvyou.DatabaseHelper.MyDatabaseHelper;
import com.myapp.moxvyou.R;
import com.myapp.moxvyou.Utils.BaseActivity;

public class CreateDatabaseActivity extends BaseActivity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_database);
        dbHelper=new MyDatabaseHelper(this,"BookStore.db",null,2);
        Button button=(Button)findViewById(R.id.create_database);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });

        //添加数据 insert
        Button button2=(Button)findViewById(R.id.add_data);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues  values = new ContentValues();
                values.put("name","The Da Vinci Code");
                values.put("author","Dan Brown");
                values.put("page",545);
                values.put("price",16.96);
                db.insert("Book",null,values);
                values.clear();
                values.put("name","The Lost Symbol");
                values.put("author","Dan Brown");
                values.put("page",510);
                values.put("price",19.65);
                db.insert("Book",null,values);
            }
        });

        //更新数据 update
        Button button3=(Button)findViewById(R.id.update_data);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues  values = new ContentValues();
                values.put("price","The Da Vinci Code");
                values.put("price",10.9);
                db.update("Book",values,"name = ?",new String[]{"The Da Vinci Code"});
            }
        });

        //删除数据 delete
        Button button4=(Button)findViewById(R.id.delete_data);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book","page > ?",new String[]{"530"});
            }
        });

        //查看数据 select
        Button button5=(Button)findViewById(R.id.select_data);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor=db.query("Book",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int page = cursor.getInt(cursor.getColumnIndex("page"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("CreateDatabaseActivity","book name is : "+name);
                        Log.d("CreateDatabaseActivity","book author is :"+author);
                        Log.d("CreateDatabaseActivity","book page is :"+page);
                        Log.d("CreateDatabaseActivity","book price is :"+price);
                    }while(cursor.moveToNext());
                }
                cursor.close();
            }
        });


    }


}
