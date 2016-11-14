package me.terge.union.adntest.loader;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by terge on 16-10-28.
 */

public class NativeItemText extends TextView{
    public NativeItemText(Context context) {
        super(context);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setGravity(Gravity.LEFT);
        setSingleLine();
        int padding = 10;
        setPadding(padding,padding,padding,padding);
        setTextColor(Color.BLACK);
    }

    public void set(String key,String value){
        append("\n");
        append(key+" : "+value);
    }
}
