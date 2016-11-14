package me.terge.union.adntest.union;

import android.view.ViewGroup;

import com.ucweb.union.ads.Ad;
import com.ucweb.union.ads.AdError;
import com.ucweb.union.ads.AdListener;
import com.ucweb.union.ads.AdRequest;
import com.ucweb.union.ads.NativeAd;
import com.ucweb.union.ads.NativeAdAssets;

import me.terge.union.adntest.bridge.NativeBridge;
import me.terge.union.adntest.loader.BaseAdloader;
import me.terge.union.adntest.loader.NativeItemText;

/**
 * Created by terge on 16-10-31.
 */

public class UnionNative extends BaseAdloader{
    private NativeBridge mBridge;
    NativeAd nativeAd;

    public UnionNative(){
        mBridge = NativeBridge.instance();
        initAd();
    }
    @Override
    public void initAd() {
        nativeAd = new NativeAd(mBridge.getContext());
        nativeAd.setAdListener(adListener);
    }

    @Override
    public void loadAd(String appId, String pub) {
        AdRequest adRequest = AdRequest.newBuilder()
                .pub("ssr@debugnative")
                .build();
        nativeAd.loadAd(adRequest);
    }

    @Override
    public void reset() {

    }


    AdListener adListener = new AdListener() {
        @Override
        public void onAdLoaded(Ad ad) {
            mLog.d("terge",TAG+" onAdLoaded");
            showNativeAd(nativeAd.getNativeAdAssets());
        /* ... */
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

    private void showNativeAd(NativeAdAssets nativeAdAssets) {
        mLog.e("terge","onAppInstallAdLoaded");
        ViewGroup container = mBridge.getContainer();
        //title
        NativeItemText title = new NativeItemText(mBridge.getContext());
        title.set("title",nativeAdAssets.getTitle());
        container.addView(title);



        //Covers
        StringBuilder sb = new StringBuilder();
        for(NativeAdAssets.Image img:nativeAdAssets.getCovers()){
            sb.append(img.getUrl());
        }
        NativeItemText covers = new NativeItemText(mBridge.getContext());
        covers.set("covers",sb.toString());
        container.addView(covers);

        //Desc
        NativeItemText desc = new NativeItemText(mBridge.getContext());
        desc.set("desc",nativeAdAssets.getDescription());
        container.addView(desc);

        //callToAction
        NativeItemText callToAction = new NativeItemText(mBridge.getContext());
        callToAction.set("callToAction",nativeAdAssets.getCallToAction());
        container.addView(callToAction);

        //rate
        NativeItemText rate = new NativeItemText(mBridge.getContext());
        rate.set("callToAction",""+nativeAdAssets.getRating());
        container.addView(rate);


        //price
        NativeItemText price = new NativeItemText(mBridge.getContext());
        price.set("price",nativeAdAssets.getPrice());
        container.addView(price);

        //icon
        NativeItemText icon = new NativeItemText(mBridge.getContext());
        icon.set("icon",nativeAdAssets.getIcon().getUrl());
        container.addView(icon);

        //cover
        NativeItemText cover = new NativeItemText(mBridge.getContext());
        cover.set("cover",nativeAdAssets.getCover().getUrl());
        container.addView(cover);

        nativeAd.registerViewForInteraction(container,
                title,
                desc,
                callToAction,
                rate,
                price,
                icon,
                cover,
                covers);
    }
}
