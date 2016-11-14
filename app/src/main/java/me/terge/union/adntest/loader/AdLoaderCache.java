package me.terge.union.adntest.loader;

import java.util.HashMap;
import java.util.Map;

import me.terge.union.adntest.consts.ADN;
import me.terge.union.adntest.consts.AdType;

/**
 * Created by terge on 16-10-27.
 */

public class AdLoaderCache {
    private static Map<String,AdLoader> loaderCache = new HashMap<>();

    public static AdLoader get(ADN adn,AdType adType){
        String key = adn+""+adType ;
        AdLoader adLoader = loaderCache.get(key);
        if(adLoader == null){
            adLoader = AdLoaderFactory.create(adn,adType);
            loaderCache.put(key,adLoader);
        }
        return adLoader;
    }
}
