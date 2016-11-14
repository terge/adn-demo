package me.terge.union.adntest.bridge;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by terge on 16-10-28.
 */

public class LogView extends TextView{
    private SpannableStringBuilder ssb;
    public LogView(Context context) {
        super(context);
        ssb = new SpannableStringBuilder();
    }

    public LogView(Context context,  AttributeSet attrs){
        super(context,attrs);
        ssb = new SpannableStringBuilder();
    }

    public void i(String log){
        appendLog(log,Color.BLACK);
    }

    public void d(String log){
        appendLog(log,Color.GREEN);

    }

    public void w(String log){
        appendLog(log,Color.YELLOW);
    }

    public void e(String log){
        appendLog(log,Color.RED);
    }

    public void v(String log){
        appendLog(log,Color.GRAY);
    }

    private void appendLog(String log,int color){
        ssb.append("\n"+log);
        int end = ssb.length();
        int start = end-log.length();
        ssb.setSpan(new ForegroundColorSpan(color), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        setText(ssb);
    }

    public void clear(){
        ssb.clear();
    }
}
