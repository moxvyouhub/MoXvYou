package com.myapp.moxvyou.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.myapp.moxvyou.Entitys.Fruit;
import com.myapp.moxvyou.R;

import java.util.List;

/**
 * @fileName FruitRecycler3Adapter
 * @date on 2020/2/13 22:55
 * author  mo xv you
 */
public class FruitRecycler3Adapter  extends RecyclerView.Adapter<FruitRecycler3Adapter.ViewHolder> {
    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;
        public ViewHolder(View view){
            super(view);
            fruitView=view;
            fruitImage=(ImageView) view.findViewById(R.id.fruit_image);
            fruitName=(TextView)view.findViewById(R.id.fruit_name);
        }
    }

    public  FruitRecycler3Adapter (List<Fruit> fruitList){
        mFruitList=fruitList;
    }

    @Override
    public FruitRecycler3Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item3,parent,false);
        final FruitRecycler3Adapter.ViewHolder holder = new FruitRecycler3Adapter.ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"you click view is  "+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"you click image is  "+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(FruitRecycler3Adapter.ViewHolder holder, int position){
        Fruit fruit = mFruitList.get(position);
        try{
            int id = fruit.getImageId();
            holder.fruitImage.setImageResource(id);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount(){
        return mFruitList.size();
    }

}
