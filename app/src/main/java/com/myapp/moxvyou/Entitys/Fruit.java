package com.myapp.moxvyou.Entitys;

/**
 * @fileName Fruit
 * @date on 2020/2/13 10:41
 * author  mo xv you
 */
public class Fruit {
    private String name;
    private int imageId;

    public Fruit(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }

}
