package me.terge.union.adntest.union;

import com.ucweb.union.ads.Ad;
import com.ucweb.union.ads.AdError;
import com.ucweb.union.ads.AdListener;
import com.ucweb.union.ads.AdRequest;
import com.ucweb.union.ads.BannerAdView;

import me.terge.union.adntest.bridge.BannerBridge;
import me.terge.union.adntest.loader.BaseAdloader;

/**
 * Created by terge on 16-10-28.
 */

public class UnionBanner extends BaseAdloader{
    private BannerBridge mBridge;
    BannerAdView adView;

    public UnionBanner(){
        mBridge = BannerBridge.instance();
    }

    @Override
    public void initAd() {
        adView = new BannerAdView(mBridge.getContext());
        adView.setAdListener(adListener);
    }

    @Override
    public void loadAd(String appId, String pub) {
        mBridge.getContainer().removeAllViews();
        initAd();
        AdRequest adRequest = AdRequest.newBuilder()
            .pub("sachin3@unicorn9apps")
            .build();
        adView.loadAd(adRequest);
        mBridge.getContainer().addView(adView);
    }

    @Override
    public void reset() {

    }

    AdListener adListener = new AdListener() {
        @Override
        public void onAdLoaded(Ad ad) {
            mLog.d("terge",TAG +" onAdLoaded");
        }
        @Override
        public void onAdClosed(Ad ad) {
            mLog.d("terge",TAG +" onAdClosed");
        }
        @Override
        public void onAdShowed(Ad ad) {
            mLog.d("terge",TAG +" onAdShowed");
        }
        @Override
        public void onAdClicked(Ad ad) {
            mLog.d("terge",TAG +" onAdClicked");
        }
        @Override
        public void onAdError(Ad ad, AdError adError) {
            mLog.e("terge",TAG +" onAdError:"+adError.getErrorCode()+"-"+adError.getErrorMessage());
        }
    };
}
