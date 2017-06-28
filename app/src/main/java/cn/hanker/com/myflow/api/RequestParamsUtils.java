package cn.hanker.com.myflow.api;

import java.util.HashMap;
import java.util.Map;

import cn.hanker.com.myflow.utils.AppUtils;
import cn.hanker.com.myflow.utils.CommonUtils;

/**
 * @auther jh
 * @des 请求参数封装工具类
 * Created by J.H on 2017/3/17.
 */

public class RequestParamsUtils {

//     private static String phone;
//     private static String password;
     private  static Map<String, String> map = null;
//
//    public RequestParamsUtils(String phone, String password) {
//        this.phone = phone;
//        this.password = password;
//    }

    /**
     * 得到请求参数的map
     * @param phone  手机号
     * @param password  密码
     * @return
     */
    public static Map getLoginRequestParams(String phone, String password){


        if(map == null)
        {
            map = new HashMap<>();
        }
        if(map.containsKey(ApiConfig.API_SIGN)){
            map.clear();
        }
        map.put(ApiConfig.API_APPID, ApiConfig.APP_ID+"");
        map.put(ApiConfig.API_PHONENUM, CommonUtils.doEncrypt(phone));
        map.put(ApiConfig.API_TYPE, "0");
        map.put(ApiConfig.API_PASSWORD, CommonUtils.genMD5String(password));
        map.put(ApiConfig.API_PLATFORM, AppUtils.getAndroidVer());
        map.put(ApiConfig.API_PHONEINFO, AppUtils.getAndroidModel());
        map.put(ApiConfig.API_DEVICEID, AppUtils.getDeviceId());
        map.put(ApiConfig.API_SIGN, CommonUtils.genSigntureString(map));


        return map;


    }

    public static Map getBannerParams(int source, int width, int height, String updateTime){


        if(map == null)
        {
            map = new HashMap<>();
        }
        if(map.containsKey(ApiConfig.API_SIGN)){
            map.clear();
        }
        map.put(ApiConfig.API_APPID, ApiConfig.APP_ID+"");
        map.put(ApiConfig.API_SOURCE, source+"");
        map.put(ApiConfig.API_SWIDTH, width+"");
        map.put(ApiConfig.API_SHEIGHT, height+"");
        map.put(ApiConfig.API_UPDATETIME, updateTime);
        map.put(ApiConfig.API_SIGN, CommonUtils.genSigntureString(map));


        return map;


    }


//    public Map<String, Object> genParametersMap() {
//                map.clear();
//        return  getLoginRequestParams();
//    }

}
