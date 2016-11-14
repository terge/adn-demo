package me.terge.union.adntest.union;

import com.ucweb.union.ads.Ad;
import com.ucweb.union.ads.AdError;
import com.ucweb.union.ads.AdListener;
import com.ucweb.union.ads.AdRequest;
import com.ucweb.union.ads.InterstitialAd;

import me.terge.union.adntest.bridge.InterstitialBridge;
import me.terge.union.adntest.loader.BaseAdloader;

/**
 * Created by terge on 16-10-31.
 */

public class UnionInterstitial extends BaseAdloader{

    InterstitialAd interstitial;
    InterstitialBridge mBridge;
    public UnionInterstitial(){
        mBridge = InterstitialBridge.instance();
        initAd();
    }
    @Override
    public void initAd() {
        interstitial = new InterstitialAd(mBridge.getContext());
        interstitial.setAdListener(adListener);
    }

    @Override
    public void loadAd(String appId, String pub) {
        AdRequest adRequest = AdRequest.newBuilder()
                .pub("ssr@debuginterstitial")
        .build();
        interstitial.loadAd(adRequest);
    }

    @Override
    public void reset() {

    }

    AdListener adListener = new AdListener() {
        @Override
        public void onAdLoaded(Ad ad) {
            mLog.d("terge",TAG+" onAdLoaded");
            interstitial.show();
        }
        @Override
        public void onAdClosed(Ad ad) {
            mLog.d("terge",TAG+" onAdClosed");
        }
        @Override
        public void onAdShowed(Ad ad) {
            mLog.d("terge",TAG+" onAdShowed");
        }
        @Override
        public void onAdClicked(Ad ad) {
            mLog.d("terge",TAG+" onAdClicked");
        }
        @Override
        public void onAdError(Ad ad, AdError adError) {
            mLog.e("terge",TAG+" onAdError:"+adError.getErrorCode()+"-"+adError.getErrorMessage());
        }
    };
}
