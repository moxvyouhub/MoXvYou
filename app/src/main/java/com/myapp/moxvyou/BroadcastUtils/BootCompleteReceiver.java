package com.myapp.moxvyou.BroadcastUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.myapp.moxvyou.Activities.HomeActivity;

//广播接受器的静态注册
//广播接收器  开机是接受系统的开机广播信号 可以做APP的自启动
public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        //开机自启动
        Intent autoStart = new Intent(context, HomeActivity.class);
        autoStart.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(autoStart);
//        Toast.makeText(context,"bootCompleteReceiver",Toast.LENGTH_SHORT).show();
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
