package com.example.twt.zhbj.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by twt on 2017/5/11.
 */

public class PrefUtil {
    private static SharedPreferences sp;
    public static void putBoolean(Context context,String key,boolean value){
        if (sp==null){
            sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }

        sp.edit().putBoolean(key,value).commit();

    }
    public static boolean getBoolean(Context context,String key,boolean defValue){
        if (sp==null){
            sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }

        return sp.getBoolean(key,defValue);
    }
    public static void putString(Context context,String key,String pwd){
        if (sp==null){
            sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }

        sp.edit().putString(key,pwd).commit();

    }
    public static String getString(Context context,String key,String pwd){
        if (sp==null){
            sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }

        return sp.getString(key,pwd);
    }

    public static void remove(Context context,String key) {
        if (sp==null){
            sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }

        sp.edit().remove(key).commit();


    }
    public static void putInt(Context context,String key,int pwd){
        if (sp==null){
            sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }

        sp.edit().putInt(key,pwd).commit();

    }
    public static int getInt(Context context,String key,int pwd){
        if (sp==null){
            sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }

        return sp.getInt(key,pwd);
    }
}
