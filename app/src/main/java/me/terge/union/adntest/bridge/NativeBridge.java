package me.terge.union.adntest.bridge;

import android.content.Context;
import android.view.ViewGroup;

/**
 * Created by terge on 16-10-28.
 */

public class NativeBridge {
    private ViewGroup mContainer;
    private static NativeBridge mBridge = new NativeBridge();

    public static NativeBridge instance() {
        return mBridge;
    }


    public Context getContext(){
        return mContainer.getContext();
    }

    public void setContainer(ViewGroup container){
        mContainer = container;
    }

    public ViewGroup getContainer(){
        return mContainer;
    }
}
