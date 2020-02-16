package com.myapp.moxvyou.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.myapp.moxvyou.Adapters.FruitAdapter;
import com.myapp.moxvyou.Entitys.Fruit;
import com.myapp.moxvyou.R;
import com.myapp.moxvyou.Utils.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class TitleViewAndListView extends BaseActivity {
    private String[] data={"apple","pear","banana","watermalon","cherry","pineapple",
            "grape","strawberry","orange","mango","apple","pear","banana","watermalon",
            "cherry", "apple","pear","banana","watermalon","cherry","pineapple"};

    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_view_and_list_view);

//        隐藏布局自带标题栏
        ActionBar actionBar =getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        initFurit();
        FruitAdapter fruitAdapter= new FruitAdapter(TitleViewAndListView.this,R.layout.fruit_item,fruitList);
        ListView listView =(ListView)findViewById(R.id.list_view);
        listView.setAdapter(fruitAdapter);
        //设置ListView每个子控件的点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(TitleViewAndListView.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        //添加滚动文本内容
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                HomeActivity.this,android.R.layout.simple_list_item_1,data);
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
    }
    //水果初始化
    public void initFurit(){
        for(int i=0;i<2;i++){
            Fruit apple = new Fruit("Apple",R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit grape = new Fruit("Grape",R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pear = new Fruit("Pear",R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit cherry = new Fruit("Cherry",R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit watermelon = new Fruit("Watermelon",R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit orange = new Fruit("Orange",R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit pineapple = new Fruit("Pineapple",R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry",R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit peach = new Fruit("Peach",R.drawable.peach_pic);
            fruitList.add(peach);
        }
    }
}
