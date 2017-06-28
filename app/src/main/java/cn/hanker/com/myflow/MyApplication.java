package cn.hanker.com.myflow;

import android.app.Application;
import android.content.Context;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/3/17.
 */

public class MyApplication extends Application {

    public static Context sContext = null;

    private static MyApplication singleton;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context getContext() {
        return sContext;
    }


    public static MyApplication getInstance() {
        if(singleton==null){
            singleton =new MyApplication();
        }
        return singleton;
    }


}
