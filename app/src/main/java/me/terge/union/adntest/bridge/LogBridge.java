package me.terge.union.adntest.bridge;

import android.util.Log;
import android.widget.Toast;

import me.terge.union.adntest.App;

/**
 * Created by terge on 16-10-28.
 */

public class LogBridge {
    private static  LogBridge mBridge = new LogBridge();
    public static LogBridge instance() {
        return mBridge;
    }
    private LogView mLogView;
    public void setLogView(LogView logView){
        mLogView = logView;
    }

    public void i(String tag,String log){
        Log.i(tag,log);
        if(mLogView!=null){
            mLogView.i(log);
        }
    }

    public void d(String tag,String log){
        Log.d(tag,log);
        if(mLogView!=null){
            mLogView.d(log);
        }
    }

    public void v(String tag,String log){
        Log.v(tag,log);
        if(mLogView!=null){
            mLogView.v(log);
        }
    }

    public void w(String tag,String log){
        Log.w(tag,log);
        if(mLogView!=null){
            mLogView.w(log);
        }
    }

    public void e(String tag,String log){
        Log.e(tag,log);
        if(mLogView!=null){
            mLogView.e(log);
        }
        Toast.makeText(App.appContext,log,Toast.LENGTH_SHORT).show();
    }

    public void clear(){
        if(mLogView!= null)mLogView.clear();
    }
}
