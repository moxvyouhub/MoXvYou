package com.myapp.moxvyou.Utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @fileName ActivityCollector
 * @date on 2020/2/10 11:43
 * author  mo xv you
 */

//该类用于维护APP的所有活动  被所有活动继承
//活动创建时添加进列表，销毁时踢除出列表，退出APP时从列表中踢除所有的活动
public class ActivityCollector {

 private static List<Activity> activities = new ArrayList<>();

 public static void addActivity(Activity activity){activities.add(activity);}

 public static void removeActivity(Activity activity){activities.remove(activity);}

 public static void finishAll(){
     for(Activity activity:activities){
         if(!activity.isFinishing()){
             activity.finish();
         }
     }
 }


}
