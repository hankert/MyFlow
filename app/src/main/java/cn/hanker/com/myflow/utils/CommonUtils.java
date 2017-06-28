package cn.hanker.com.myflow.utils;

import android.util.Base64;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import cn.hanker.com.myflow.api.ApiConfig;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/3/17.
 */

public class CommonUtils {

    static final String CIPHER_ALGORITHM_CBC = "AES/CBC/PKCS5Padding";
    static Cipher cipher;
    static SecretKey secretKey;

    /**
     *
     * @param plainText  要加密的文本
     * @return   加密后的文本
     */
    public static String genMD5String(String plainText) {

        Logger.d(ApiConfig.APP_TAG, MD5.mkMd5(plainText));

        return MD5.mkMd5(plainText);
    }

    public static String doEncrypt(String str) {
        String sKey = "6106c34e2786d852e79e6bf32ab8fa9b";
        String sLv = "00e3d201c5c2ac23f8154860272ba0c4";
        return Encrypt(str, sKey, sLv);
    }


    public static String genSn() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss", Locale.getDefault());
        return new String(sdf.format(new Date()));
    }


    // 加密 skey和slv为不同值 base64转换
    public static String Encrypt(String str, String sKey, String sLv) {
        try {
            if (cipher == null)
                cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);

            if (secretKey == null)
                secretKey = new SecretKeySpec(StringTool.getFromHexString(sKey), "AES");// 生成密匙

            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(StringTool.getFromHexString(sLv)));// 使用加密模式初始化
            // 密钥
            byte[] encrypt = cipher.doFinal(str.getBytes("utf-8")); // 按单部分操作加密或解密数据，或者结束一个多部分操作。
            String sout = new String(Base64.encode(encrypt, Base64.DEFAULT), "UTF-8");// Base64.encodeBase64String(encrypt);
            // Logger.info("Encrypt - 加密后：" + sout);
            return sout;
        } catch (Exception e) {
            // Logger.error("Aes Encrypt ", e);
        }
        return null;
    }



    /**
     * 获取签名
     *
     * @param map
     * @return
     */
    public static String genSigntureString(Map<String, String> map) {
        StringBuilder sBuilder = new StringBuilder();
        Set<String> keySet = map.keySet();
        List<String> keyList = new ArrayList<String>();
        for (String key : keySet) {
            keyList.add(key);
        }
        Collections.sort(keyList, new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return lhs.compareTo(rhs);
            }
        });
        sBuilder.append(ApiConfig.APPKEY);
        for (String key : keyList) {
            sBuilder.append(key).append(map.get(key));
        }
        sBuilder.append(ApiConfig.APPSECRET);
        keySet = null;
        keyList = null;
        Logger.d(ApiConfig.APP_TAG, sBuilder.toString());
        return genMD5String(sBuilder.toString());
    }

    public static String getTime(){

        long time=System.currentTimeMillis()/1000;//获取系统时间的10位的时间戳

        String str = String.valueOf(time);

        return str;

    }
}
