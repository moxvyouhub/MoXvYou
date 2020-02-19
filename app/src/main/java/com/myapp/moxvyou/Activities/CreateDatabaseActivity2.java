package com.myapp.moxvyou.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.myapp.moxvyou.Entitys.Book;
import com.myapp.moxvyou.R;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class CreateDatabaseActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_database2);

        //创建数据库和数据表
        Button button=(Button)findViewById(R.id.create_database2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Connector.getDatabase();
                }catch (Exception e){
                    System.out.println(e.toString());
                }

            }
        });

        //添加数据 insert
        Button button2=(Button)findViewById(R.id.add_data2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book =new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPage(545);
                book.setPrice(16.96);
                book.setPress("unknown");
                book.save();

                book.setName("The Lost Symbol");
                book.setAuthor("Dan Brown");
                book.setPage(500);
                book.setPrice(13.20);
                book.setPress("unknown");
                book.save();
            }
        });

        //更新数据 update
        Button button3=(Button)findViewById(R.id.update_data2);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book= new Book();
                book.setPrice(0.99);
//                book.setToDefault("page");  //将page 设置为默认值 0
                book.setPress("anchor");
                book.updateAll("name = ? and author= ?","The Lost Symbol","Dan Brown");
            }
        });

        //删除数据 delete
        Button button4=(Button)findViewById(R.id.delete_data2);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.deleteAll(Book.class,"price > ? ","10");
            }
        });

        //查看数据 select
        Button button5=(Button)findViewById(R.id.select_data2);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             List<Book> books= DataSupport.findAll(Book.class);
             for( Book book :books){
                 Log.d("CreateDatabaseActivity2","book name is : "+book.getName());
                 Log.d("CreateDatabaseActivity2","book author is :"+book.getAuthor());
                 Log.d("CreateDatabaseActivity2","book page is :"+book.getPage());
                 Log.d("CreateDatabaseActivity2","book price is :"+book.getPrice());
                 Log.d("CreateDatabaseActivity2","book price is :"+book.getId());
                 Log.d("CreateDatabaseActivity2","book price is :"+book.getPress());
             }
            }
        });

    }
}
