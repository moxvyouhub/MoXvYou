package com.myapp.moxvyou.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.myapp.moxvyou.R;
import com.myapp.moxvyou.Utils.BaseActivity;

public class ForceOfflineActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_force_offline);
        Button button = (Button)findViewById(R.id.force_offline);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.myapp.moxvyou.Activity.ForceOfflineActivity");
                sendBroadcast(intent);
            }
    });
    }
}
