package me.terge.union.adntest.loader;

import me.terge.union.adntest.admob.AdmobBanner;
import me.terge.union.adntest.admob.AdmobInterstitial;
import me.terge.union.adntest.admob.AdmobNative;
import me.terge.union.adntest.consts.ADN;
import me.terge.union.adntest.consts.AdType;
import me.terge.union.adntest.facebook.FacebookBanner;
import me.terge.union.adntest.union.UnionBanner;
import me.terge.union.adntest.union.UnionInterstitial;
import me.terge.union.adntest.union.UnionNative;

/**
 * Created by terge on 16-10-28.
 */

public class AdLoaderFactory {
    public static AdLoader create(ADN adn, AdType adType){
        switch (adn){
            case ADMOB:
                return createAdmob(adType);
            case FACEBOOK:
                return createFacebook(adType);
            case UNION:
                return createUnion(adType);
        }
        return null;
    }

    private static AdLoader createUnion(AdType adType) {
        switch (adType){
            case BANNER:
                return new UnionBanner();
            case INTERSTITIAL:
                return new UnionInterstitial();
            case NATIVE:
                return new UnionNative();
        }
        return null;
    }

    private static AdLoader createFacebook(AdType adType) {
        switch (adType){
            case BANNER:
                return new FacebookBanner();
        }
        return null;
    }

    private static AdLoader createAdmob(AdType adType) {
        switch (adType){
            case BANNER:
                return new AdmobBanner();
            case INTERSTITIAL:
                return new AdmobInterstitial();
            case NATIVE:
                return new AdmobNative();
        }
        return null;
    }
}
