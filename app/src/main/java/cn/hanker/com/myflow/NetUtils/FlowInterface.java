package cn.hanker.com.myflow.NetUtils;

import java.util.Map;

import cn.hanker.com.myflow.Entity.BannerEntity;
import cn.hanker.com.myflow.Entity.UserEntity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/3/17.
 */

public interface FlowInterface {


    public static final String URL_LOGIN  = "login";
    public static final String URL_GETBANNER  = "getbanner";

    /**
     * 传递参数的Get请求
     * @return
     */
    @GET(URL_LOGIN)
    Call<UserEntity> getLogin(@QueryMap Map<String, String> param);

    @GET(URL_GETBANNER)
    Call<BannerEntity> getBanner(@QueryMap Map<String, Object> param);



}
