package me.terge.union.adntest.loader;

/**
 * Created by terge on 16-10-28.
 */

public interface AdLoader {
    void initAd();
    void loadAd(String appId,String pub);
    void reset();
}
