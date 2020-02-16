package com.myapp.moxvyou.Utils;

import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.myapp.moxvyou.Activities.ForceOfflineActivity;
import com.myapp.moxvyou.BroadcastUtils.ForceOfflineReceiver;

/**
 * @fileName BaseActivity
 * @date on 2020/2/10 11:59
 * author  mo xv you
 */

//通过该类的改写 可以打印出所有当前打开活动的类名
// 为了以后维护人员方便查找该活动

public class BaseActivity extends AppCompatActivity {
    private ForceOfflineReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity:",getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy(){
      super.onDestroy();
      ActivityCollector.removeActivity(this);
    }

    @Override
    public void onResume(){
        super.onResume();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.myapp.moxvyou.Activity.ForceOfflineActivity");
        receiver=new ForceOfflineReceiver();
        registerReceiver(receiver,intentFilter);
    }

    @Override
    public void onPause(){
        super.onPause();
        if(receiver!=null){
            unregisterReceiver(receiver);
            receiver=null;
        }
    }
}
