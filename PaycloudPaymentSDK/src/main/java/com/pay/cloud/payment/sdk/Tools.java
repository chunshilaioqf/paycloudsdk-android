package com.pay.cloud.payment.sdk;

import android.content.Context;

public class Tools {
    public static Context appContext;
    public static void init(Context context) {
        if (null != context) {
            appContext = context;
        }
    }
}
