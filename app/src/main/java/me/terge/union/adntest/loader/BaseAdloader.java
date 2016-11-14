package me.terge.union.adntest.loader;

import me.terge.union.adntest.bridge.LogBridge;

/**
 * Created by terge on 16-10-28.
 */

public abstract class BaseAdloader implements AdLoader{
    protected final String TAG = getClass().getSimpleName();
    protected LogBridge mLog = LogBridge.instance();
}
