package com.myapp.moxvyou.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.myapp.moxvyou.R;
import com.myapp.moxvyou.Utils.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class PullCallListContentReSolverActivity extends BaseActivity {

    ArrayAdapter<String> adapter;
    List<String> contactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_call_list_content_re_solver);
        ListView contactView=(ListView)findViewById(R.id.contact_view);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contactList);
        contactView.setAdapter(adapter);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},1);
        }else{
            readContact();
        }
    }
    private void readContact(){
        Cursor cursor = null;
        try{
            cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
            if(cursor!=null ){
                while(cursor.moveToNext()){
//                    String number= cursor.getString(cursor.getColumnIndex("ContactsContract.CommonDataKinds.Phone.NUMBER"));
                    String displayName = cursor.getString(cursor.getColumnIndex("ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME"));
                    contactList.add(displayName);
                }
                adapter.notifyDataSetChanged();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if( cursor !=null ){
                cursor.close();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions ,int[] grantResults){
       switch (requestCode){
           case 1:
               if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                   readContact();
               }else{
                   Toast.makeText(this,"you denied the permission",Toast.LENGTH_SHORT).show();
               }
               break;
               default:
       }
    }
}
