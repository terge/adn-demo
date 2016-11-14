package me.terge.union.adntest.facebook;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

import me.terge.union.adntest.bridge.BannerBridge;
import me.terge.union.adntest.loader.BaseAdloader;

/**
 * Created by terge on 16-10-31.
 */

public class FacebookBanner extends BaseAdloader implements AdListener{
    AdView adView;
    BannerBridge mBridge;

    public FacebookBanner(){
        mBridge = BannerBridge.instance();
    }
    @Override
    public void initAd() {

    }

    @Override
    public void loadAd(String appId, String pub) {
        if(adView !=null)adView.destroy();
        AdSettings.addTestDevice("c7dc23a2343b508d89d19722e24c828f");
        mBridge.getContainer().removeAllViews();
        adView = new AdView(mBridge.getContext(),
                "734836993326552_1081599061983675",
                AdSize.BANNER_HEIGHT_50);
        adView.setAdListener(this);
        mBridge.getContainer().addView(adView);
        // Request to load an ad
        adView.loadAd();
    }

    @Override
    public void reset() {

    }

    @Override
    public void onError(Ad ad, AdError adError) {
        mLog.e("terge",TAG+" onError:"+adError.getErrorCode()+"-"+adError.getErrorMessage());
    }

    @Override
    public void onAdLoaded(Ad ad) {
        mLog.d("terge",TAG+" onAdLoaded");
    }

    @Override
    public void onAdClicked(Ad ad) {
        mLog.d("terge",TAG+" onAdClicked");
    }
}
