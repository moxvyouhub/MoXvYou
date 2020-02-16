package com.myapp.moxvyou.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.myapp.moxvyou.Adapters.MsgAdapter;
import com.myapp.moxvyou.Entitys.Fruit;
import com.myapp.moxvyou.Entitys.Msg;
import com.myapp.moxvyou.R;
import com.myapp.moxvyou.Utils.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class ChatWithEachOtherActivity extends BaseActivity {

    private List<Msg> msgList = new ArrayList<>();

    private EditText inputText;

    private Button sent;

    private RecyclerView msgRecyclerView;

    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_with_each_other);
        initMsgs();
        inputText= (EditText)findViewById(R.id.input_text);
        sent=(Button)findViewById(R.id.send);

        msgRecyclerView=(RecyclerView)findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter=new MsgAdapter(msgList);
        try{
            msgRecyclerView.setAdapter(adapter);
        }catch (Exception e){
            System.out.println(e.toString());
        }

        sent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String content=inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);
                    msgRecyclerView.scrollToPosition(msgList.size()-1);
                    inputText.setText("");
                }
            }
        });




    }

    private void initMsgs(){
        Msg msg1 = new Msg("Hello guy . ", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hello .Who is that ？ ", Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3 = new Msg("This is Tomy is talking to you . ", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}