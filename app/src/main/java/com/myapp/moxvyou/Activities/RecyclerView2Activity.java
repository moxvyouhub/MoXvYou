package com.myapp.moxvyou.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.myapp.moxvyou.Adapters.FruitRecycler2Adapter;
import com.myapp.moxvyou.Adapters.FruitRecyclerAdapter;
import com.myapp.moxvyou.Entitys.Fruit;
import com.myapp.moxvyou.R;
import com.myapp.moxvyou.Utils.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView2Activity extends BaseActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view2);
        initFurit();
        RecyclerView recyclerView =(RecyclerView)findViewById(R.id.recycler_view2_layout);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitRecycler2Adapter adapter=new FruitRecycler2Adapter(fruitList);
        try{
            recyclerView.setAdapter(adapter);
        }catch (Exception e){
            System.out.println(e.toString());
        }


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

