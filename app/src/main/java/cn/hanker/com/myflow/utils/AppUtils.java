package cn.hanker.com.myflow.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import cn.hanker.com.myflow.MyApplication;

/**
 * 跟App相关的辅助类
 *
 * @author zhy
 *
 */
public class AppUtils
{

    private AppUtils()
    {
		/* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");

    }

    /**
     * 获取应用程序名称
     */
    public static String getAppName()
    {
        try
        {
            PackageManager packageManager = MyApplication.getInstance().getApplicationContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    MyApplication.getInstance().getApplicationContext().getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return MyApplication.getInstance().getApplicationContext().getResources().getString(labelRes);
        } catch (NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * [获取应用程序版本名称信息]
     * @return 当前应用的版本名称
     */
    public static String getVersionName()
    {
        PackageInfo packInfo = null;
        try {
            packInfo = MyApplication.sContext.getPackageManager().getPackageInfo(MyApplication.sContext.getPackageName(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return packInfo == null ? "1.0" : packInfo.versionName;
    }

    /**
     *
     * @return   手机的型号
     */
    public static String getAndroidModel() {
        return android.os.Build.BRAND + "_" + android.os.Build.MODEL;
    }

    /**
     *
     *
     * @return   获取android的版本
     */
    public static String getAndroidVer() {
        return "android_" + android.os.Build.VERSION.RELEASE;
    }

    /**
     *
     * @return  获取设备的deviceId
     */
    public static String getDeviceId() {
        String r = "wrong_device_id";
        try {
            r = ((TelephonyManager) MyApplication.sContext
                    .getSystemService(MyApplication.getContext().TELEPHONY_SERVICE)).getDeviceId();
            if (TextUtils.isEmpty(r) || "0".equals(r)) {
                r = getLocalMacAddress(MyApplication.getContext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }


    public static String getLocalMacAddress(Context context) {

        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

        WifiInfo info = wifi.getConnectionInfo();

        return info.getMacAddress();

    }

}
