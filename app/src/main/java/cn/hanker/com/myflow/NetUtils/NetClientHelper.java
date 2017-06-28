package cn.hanker.com.myflow.NetUtils;

import okhttp3.OkHttpClient;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/3/17.
 */

public class NetClientHelper {

    private static OkHttpClient okHttpClient;


    public static OkHttpClient getInstance(){
        if(okHttpClient == null)
        {
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new MyInterceptor())
                    .build();

        }
        return okHttpClient;


    }

}
