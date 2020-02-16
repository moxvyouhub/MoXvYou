package com.myapp.moxvyou.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.myapp.moxvyou.Adapters.FruitRecycler2Adapter;
import com.myapp.moxvyou.Adapters.FruitRecycler3Adapter;
import com.myapp.moxvyou.Entitys.Fruit;
import com.myapp.moxvyou.R;
import com.myapp.moxvyou.Utils.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerView3Activity extends BaseActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view3);
        initFurit();
        RecyclerView recyclerView =(RecyclerView)findViewById(R.id.recycler_view3_layout);
        StaggeredGridLayoutManager layoutManager =new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitRecycler3Adapter adapter=new FruitRecycler3Adapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    //水果初始化
    public void initFurit(){
        for(int i=0;i<2;i++){
            Fruit apple = new Fruit(getRandomLengthName("Apple"),R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("Banana"),R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit grape = new Fruit(getRandomLengthName("Grape"),R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pear = new Fruit(getRandomLengthName("Pear"),R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit cherry = new Fruit(getRandomLengthName("Cherry"),R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"),R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit orange = new Fruit(getRandomLengthName("Orange"),R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"),R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"),R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit peach = new Fruit(getRandomLengthName("Peach"),R.drawable.peach_pic);
            fruitList.add(peach);
        }
    }

    public String getRandomLengthName(String name){
        Random random = new Random();
        int length= random.nextInt(20)+1;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<length;i++){
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }
}
