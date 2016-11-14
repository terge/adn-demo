package me.terge.union.adntest.bridge;

import android.content.Context;
import android.view.ViewGroup;

/**
 * Created by terge on 16-10-28.
 */

public class BannerBridge {
    private static BannerBridge mBridge = new BannerBridge();

    private ViewGroup mContainer;
    public static BannerBridge instance() {
        return mBridge;
    }

    public void setContainer(ViewGroup container){
        mContainer = container;
    }

    public ViewGroup getContainer(){
        return mContainer;
    }

    public Context getContext(){
        return mContainer.getContext();
    }
}
