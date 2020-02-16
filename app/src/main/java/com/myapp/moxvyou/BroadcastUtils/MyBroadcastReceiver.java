package com.myapp.moxvyou.BroadcastUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        //接收自定义广播
        Toast.makeText(context,"Received is MyBroadcast",Toast.LENGTH_SHORT).show();
    }
}
