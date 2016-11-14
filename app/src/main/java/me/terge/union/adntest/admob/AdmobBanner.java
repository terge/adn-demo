package me.terge.union.adntest.admob;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import me.terge.union.adntest.bridge.BannerBridge;
import me.terge.union.adntest.loader.BaseAdloader;

/**
 * Created by terge on 16-10-28.
 */

public class AdmobBanner extends BaseAdloader {
    private AdView mAdview;
    private BannerBridge mBridge;
    public AdmobBanner(){
        mBridge = BannerBridge.instance();
    }


    @Override
    public void initAd() {
        mAdview = new AdView(mBridge.getContext());
        mAdview.setAdSize(AdSize.SMART_BANNER);
        mAdview.setAdListener(mAdListener);
        mBridge.getContainer().addView(mAdview);
    }

    @Override
    public void loadAd(String appId, String pub) {
        if(mAdview != null)mBridge.getContainer().removeView(mAdview);
        initAd();
        mAdview.setAdUnitId("ca-app-pub-8804888282454530/3624997406");
        mAdview.loadAd(new AdRequest.Builder().build());
    }


    @Override
    public void reset() {
//        mAdview.destroy();
//        mBridge.getContainer().removeView(mAdview);
//        mAdview = new AdView(mBridge.getContext());
//        mAdview.setAdSize(AdSize.SMART_BANNER);
//        mAdview.setAdListener(mAdListener);
    }


    private AdListener mAdListener = new AdListener() {
        @Override
        public void onAdClosed() {
            super.onAdClosed();
            mLog.d("terge",TAG +" onAdClosed");
        }

        @Override
        public void onAdFailedToLoad(int i) {
            super.onAdFailedToLoad(i);
            mLog.e("terge",TAG +" onAdFailedToLoad:"+i);
        }

        @Override
        public void onAdLeftApplication() {
            super.onAdLeftApplication();
            mLog.d("terge",TAG +" onAdLeftApplication");
        }

        @Override
        public void onAdOpened() {
            super.onAdOpened();
            mLog.d("terge",TAG +" onAdOpened");
        }

        @Override
        public void onAdLoaded() {
            super.onAdLoaded();
            mLog.d("terge",TAG +" onAdLoaded");
        }
    };
}
