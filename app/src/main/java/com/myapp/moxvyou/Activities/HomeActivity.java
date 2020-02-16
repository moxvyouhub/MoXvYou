package com.myapp.moxvyou.Activities;


import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;


import com.myapp.moxvyou.BroadcastUtils.NetworkChangeReceiver;
import com.myapp.moxvyou.R;
import com.myapp.moxvyou.Utils.BaseActivity;


public class HomeActivity extends BaseActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        intentFilter=new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver=new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);
    }

    //添加菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    /*处理菜单事件*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        //得到当前选中的MenuItem的ID,
        int item_id = item.getItemId();
        switch (item_id)
        {
            case R.id.bai_du:
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                break;
            case R.id.next_page:
                Intent intent2 = new Intent(HomeActivity.this,MenuNextPage1Activity.class);
                startActivity(intent2);
                break;
            case R.id.percent_frame_layout:
                Intent intent3 = new Intent(HomeActivity.this,PercentLayoutActivity.class);
                startActivity(intent3);
                break;
            case R.id.title_view_and_list_view_layout:
                Intent intent4 = new Intent(HomeActivity.this,TitleViewAndListView.class);
                startActivity(intent4);
                break;
            case R.id.recycler_view_layout:
                Intent intent5 = new Intent(HomeActivity.this, RecyclerViewActivity.class);
                startActivity(intent5);
                break;
            case R.id.recycler_view_layout2:
                Intent intent6 = new Intent(HomeActivity.this, RecyclerView2Activity.class);
                startActivity(intent6);
                break;
            case R.id.recycler_view_layout3:
                Intent intent7 = new Intent(HomeActivity.this, RecyclerView3Activity.class);
                startActivity(intent7);
                break;
            case R.id.chat_with:
                Intent intent8 = new Intent(HomeActivity.this, ChatWithEachOtherActivity.class);
                startActivity(intent8);
                break;
            case R.id.send_broadcast:
                Intent intent9 = new Intent(HomeActivity.this, SendBroadcastActivity.class);
                startActivity(intent9);
                break;
            case R.id.force_offline:
                Intent intent10 = new Intent(HomeActivity.this, ForceOfflineActivity.class);
                startActivity(intent10);
                break;
        }
        return true;
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

}
