package me.terge.union.adntest.admob;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;

import me.terge.union.adntest.loader.BaseAdloader;
import me.terge.union.adntest.bridge.NativeBridge;
import me.terge.union.adntest.loader.NativeItemText;

/**
 * Created by terge on 16-10-28.
 */

public class AdmobNative extends BaseAdloader implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener {
    private NativeBridge mBridge;

    public AdmobNative(){
        mBridge = NativeBridge.instance();
    }

    @Override
    public void initAd() {

    }

    @Override
    public void loadAd(String appId, String pub) {
        mBridge.getContainer().removeAllViews();
        AdLoader adLoader = new AdLoader.Builder(mBridge.getContext(),"ca-app-pub-3940256099942544/3986624511")
                .forAppInstallAd(this)
                .forContentAd(this)
                .withAdListener(mAdListener)
                .withNativeAdOptions(nativeAdOptions)
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());
    }

    @Override
    public void reset() {

    }

    @Override
    public void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
        mLog.e("terge","onAppInstallAdLoaded");
        NativeAppInstallAdView adView = new NativeAppInstallAdView(mBridge.getContext());
        //headLine
        NativeItemText headlineView = new NativeItemText(mBridge.getContext());
        headlineView.set("headline",nativeAppInstallAd.getHeadline().toString());
        adView.setHeadlineView(headlineView);

        //Imags
        StringBuilder sb = new StringBuilder();
        for(NativeAd.Image img:nativeAppInstallAd.getImages()){
            sb.append(img.getUri());
        }
        NativeItemText imgView = new NativeItemText(mBridge.getContext());
        imgView.set("imgs",sb.toString());
        adView.setImageView(imgView);

        //Body
        NativeItemText bodyView = new NativeItemText(mBridge.getContext());
        bodyView.set("body",nativeAppInstallAd.getBody().toString());
        adView.setHeadlineView(bodyView);

        //Icon
        NativeItemText iconView = new NativeItemText(mBridge.getContext());
        iconView.set("icon",nativeAppInstallAd.getIcon().getUri().toString());
        adView.setHeadlineView(iconView);

        //callToAction
        NativeItemText actionView = new NativeItemText(mBridge.getContext());
        actionView.set("callToAction",nativeAppInstallAd.getCallToAction().toString());
        adView.setHeadlineView(actionView);


        //Star
        NativeItemText starView = new NativeItemText(mBridge.getContext());
        starView.set("start",nativeAppInstallAd.getStarRating().toString());
        adView.setHeadlineView(starView);

        //Store
        NativeItemText storeView = new NativeItemText(mBridge.getContext());
        storeView.set("store",nativeAppInstallAd.getStore().toString());
        adView.setHeadlineView(storeView);

        //Price
        NativeItemText priceView = new NativeItemText(mBridge.getContext());
        priceView.set("price",nativeAppInstallAd.getPrice().toString());
        adView.setHeadlineView(priceView);

        adView.setNativeAd(nativeAppInstallAd);
        mBridge.getContainer().addView(adView);
    }

    @Override
    public void onContentAdLoaded(NativeContentAd nativeContentAd) {
        mLog.e("terge","onContentAdLoaded");
        NativeContentAdView adView = new NativeContentAdView(mBridge.getContext());

        //headLine
        NativeItemText headlineView = new NativeItemText(mBridge.getContext());
        headlineView.set("headline",nativeContentAd.getHeadline().toString());
        adView.setHeadlineView(headlineView);
        mBridge.getContainer().addView(headlineView);

        //Imags
        StringBuilder sb = new StringBuilder();
        for(NativeAd.Image img:nativeContentAd.getImages()){
            sb.append(img.getUri());
        }
        NativeItemText imgView = new NativeItemText(mBridge.getContext());
        imgView.set("imgs",sb.toString());
        adView.setImageView(imgView);
        mBridge.getContainer().addView(imgView);

        //Body
        NativeItemText bodyView = new NativeItemText(mBridge.getContext());
        bodyView.set("body",nativeContentAd.getBody().toString());
        adView.setHeadlineView(bodyView);
        mBridge.getContainer().addView(bodyView);

        //Logo
        NativeItemText logoView = new NativeItemText(mBridge.getContext());
        logoView.set("logo",nativeContentAd.getLogo().getUri().toString());
        adView.setHeadlineView(logoView);
        mBridge.getContainer().addView(logoView);

        //callToAction
        NativeItemText actionView = new NativeItemText(mBridge.getContext());
        actionView.set("callToAction",nativeContentAd.getCallToAction().toString());
        adView.setHeadlineView(actionView);
        mBridge.getContainer().addView(actionView);

        //adviser
        NativeItemText adviserView = new NativeItemText(mBridge.getContext());
        adviserView.set("adviser",nativeContentAd.getAdvertiser().toString());
        adView.setHeadlineView(adviserView);
        mBridge.getContainer().addView(adviserView);


        adView.setNativeAd(nativeContentAd);
        mBridge.getContainer().addView(adView);
    }


    private AdListener mAdListener = new AdListener() {
        @Override
        public void onAdClosed() {
            super.onAdClosed();
            mLog.e("terge",TAG +" onAdClosed");
        }

        @Override
        public void onAdFailedToLoad(int i) {
            super.onAdFailedToLoad(i);
            mLog.e("terge",TAG +" onAdFailedToLoad:"+i);
        }

        @Override
        public void onAdLeftApplication() {
            super.onAdLeftApplication();
            mLog.e("terge",TAG +" onAdLeftApplication");
        }

        @Override
        public void onAdOpened() {
            super.onAdOpened();
            mLog.e("terge",TAG +" onAdOpened");
        }

        @Override
        public void onAdLoaded() {
            super.onAdLoaded();
            mLog.e("terge",TAG +" onAdLoaded");
        }
    };

    private NativeAdOptions nativeAdOptions = new NativeAdOptions.Builder().build();
}
