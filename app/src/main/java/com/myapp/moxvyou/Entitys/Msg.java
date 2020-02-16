package com.myapp.moxvyou.Entitys;

/**
 * @fileName Msg
 * @date on 2020/2/14 12:02
 * author  mo xv you
 */
public class Msg {
    public static final int TYPE_RECEIVED=0;
    public static final int TYPE_SEND=1;
    private String content;
    private int type;
    public Msg(String content,int type){
       this.content=content;
        this.type=type;
    }

    public String getContent(){
        return content;
    }

    public int getType(){
        return type;
    }

}
