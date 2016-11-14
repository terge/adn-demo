package me.terge.union.adntest.admob;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import me.terge.union.adntest.loader.BaseAdloader;
import me.terge.union.adntest.bridge.InterstitialBridge;

/**
 * Created by terge on 16-10-28.
 */

public class AdmobInterstitial extends BaseAdloader{
    private InterstitialBridge mBridge;
    private InterstitialAd mInterstitialAd;

    public AdmobInterstitial(){
        mBridge = InterstitialBridge.instance();
    }

    @Override
    public void initAd() {

    }

    @Override
    public void loadAd(String appId, String pub) {
        mInterstitialAd= new InterstitialAd(mBridge.getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-5829484717446757/7275845029");
        mInterstitialAd.setAdListener(mAdListener);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mLog.i("terge","load "+TAG+" appId:"+appId);
        mLog.i("terge","load "+TAG+" pub:"+pub);
    }



    @Override
    public void reset() {

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
            mInterstitialAd.show();
            mLog.d("terge",TAG +" onAdLoaded");
        }
    };
}
