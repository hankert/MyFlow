package cn.hanker.com.myflow.NetUtils;

import android.text.TextUtils;

import java.io.IOException;
import java.util.Map;

import cn.hanker.com.myflow.utils.CommonUtils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static cn.hanker.com.myflow.utils.CommonUtils.genMD5String;


/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/3/17.
 */

public  class MyInterceptor implements Interceptor {

    public static  final String HEADER_KEY = "www.llyh.cn" ;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
//                .addHeader(ApiConfig.API_EXPIRESTIME, CommonUtils.genSn())
//                .addHeader("tcp", genHS(CommonUtils.genSn(), "90997546ABAB22E2C98D7ADA72AED92F"))
//                .addHeader("tcp", genHS(CommonUtils.genSn(), (String)genParametersMap().get(API_SIGN)))
//                .addHeader(ApiConfig.API_CHANNEL, "test")
//                .addHeader(ApiConfig.API_APPID, ApiConfig.APP_ID+"")
//                .addHeader(ApiConfig.API_DEVICEID, AppUtils.getDeviceId())
//                .addHeader(ApiConfig.API_TERVER, AppUtils.getVersionName())
                .build();

        return chain.proceed(request);

    }




    public  Map<String, String> genParametersMap() {
        return null;
    }

    private String genHS(String t, String s){
        if (TextUtils.isEmpty(s)) {
            // return Util.genMD5String(time+getK());
            return genMD5String(t + s + HEADER_KEY);

        } else {
            return CommonUtils.genMD5String(t + s + HEADER_KEY);
        }



    }
}
