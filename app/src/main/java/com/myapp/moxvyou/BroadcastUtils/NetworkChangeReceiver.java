package com.myapp.moxvyou.BroadcastUtils;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.myapp.moxvyou.Utils.BaseActivity;

import java.net.NetworkInterface;

/**
 * @fileName NetworkChangeReceiver
 * @date on 2020/2/15 14:56
 * author  mo xv you
 */


//接受手机的网络状态广播  并提示网络状态
public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo !=null && networkInfo.isAvailable()){
            Toast.makeText(context,"Network  is available",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Network  is unavailable",Toast.LENGTH_SHORT).show();
        }
    }
}
