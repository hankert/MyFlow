package cn.hanker.com.myflow.NetUtils;

import cn.hanker.com.myflow.api.ApiConfig;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/3/17.
 */

public class RetrofitUtils {



    private static final String BASEURL = ApiConfig.F_OFFICIAL ? "http://bank.wo.cn/v9/" : "http://207.sinobyte.cn/v9/";
    private static Retrofit retrofit = null;
    private static  FlowInterface iServer;
    private static OkHttpClient okHttpClient;

    public static FlowInterface getInstance() {

        if (retrofit == null) {
            okHttpClient = NetClientHelper.getInstance();
            synchronized (RetrofitUtils.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASEURL)
                            .client(okHttpClient)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    iServer = retrofit.create(FlowInterface.class);
                }
            }
        }
        return iServer;
    }

}
