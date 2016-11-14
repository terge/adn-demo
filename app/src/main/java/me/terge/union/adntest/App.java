package me.terge.union.adntest;

import android.app.Application;
import android.content.Context;

import com.ucweb.union.ads.UnionAdsSdk;

/**
 * Created by terge on 16-10-27.
 */

public class App extends Application{
    public static Context appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        UnionAdsSdk.start(this,"5d41beae1935ad745dd7ef20d805af41");
//        FacebookSdk.sdkInitialize(getApplicationContext());
    }

}
