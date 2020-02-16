package com.myapp.moxvyou.Activities;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.core.view.LayoutInflaterCompat;

import com.myapp.moxvyou.R;


/**
 * @fileName TitleLayout
 * @date on 2020/2/12 21:20
 * author  mo xv you
 */

//该布局类用于统一处理标题点击事件
public class TitleLayout extends LinearLayout {

    public TitleLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);

        Button button_back=(Button)findViewById(R.id.title_back);
        Button button_edit=(Button)findViewById(R.id.title_edit);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });

        button_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"you click edit ",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
