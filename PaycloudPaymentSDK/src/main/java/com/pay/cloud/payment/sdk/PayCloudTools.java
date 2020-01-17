package com.pay.cloud.payment.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class PayCloudTools {
    private static Context appContext;
    private static String API_URL;
    private static String H5_URL;
    private static String TOKEN;
    private static String EXT_USER_ID;
    private static PayCloudTools _self = null;

    public static Context getAppContext() {
        return appContext;
    }

    public static void setAppContext(Context appContext) {
        PayCloudTools.appContext = appContext;
    }

    public static String getApiUrl() {
        return API_URL;
    }

    public static void setApiUrl(String apiUrl) {
        API_URL = apiUrl;
    }

    public static String getH5Url() {
        return H5_URL;
    }

    public static void setH5Url(String h5Url) {
        H5_URL = h5Url;
    }

    public static String getTOKEN() {
        return TOKEN;
    }

    public static void setTOKEN(String TOKEN) {
        PayCloudTools.TOKEN = TOKEN;
    }

    public static String getExtUserId() {
        return EXT_USER_ID;
    }

    public static void setExtUserId(String extUserId) {
        EXT_USER_ID = extUserId;
    }

    public static PayCloudTools init(Context context, String api_url, String h5_url, String token, String ext_user_id) {
        if (null != context) {
            appContext = context;
        }
        PayCloudTools.initialization();
        _self.setApiUrl(api_url);
        _self.setH5Url(h5_url);
        _self.setTOKEN(token);
        _self.setExtUserId(ext_user_id);
        return _self;
    }
    private static void destory(){
        PayCloudTools._self = null;
    }
    private static void initialization(){
        if(PayCloudTools._self == null) {
            _self = new PayCloudTools();
        }
    }
    public void start(String path){
        Intent intent = new Intent();
        intent.setClass(PayCloudTools.getAppContext(), SdkActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url",H5_URL + path + "?token=" + TOKEN + "&extUserId=" + EXT_USER_ID);
        PayCloudTools.getAppContext().startActivity(intent, bundle);
    }

}
