package me.terge.union.adntest.bridge;

import android.content.Context;

/**
 * Created by terge on 16-10-28.
 */

public class InterstitialBridge {
    private static InterstitialBridge mBridge = new InterstitialBridge();

    private Context mContext;
    public static InterstitialBridge instance() {
        return mBridge;
    }

    public void setContext(Context context){
        mContext = context;
    }

    public Context getContext(){
        return mContext;
    }
}
