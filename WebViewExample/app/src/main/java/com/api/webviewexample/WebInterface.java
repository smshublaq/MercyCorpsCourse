package com.api.webviewexample;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by iSaleem on 8/8/17.
 */

public class WebInterface {
    Context context;

    WebInterface(Context context){
        this.context = context;
    }

    @JavascriptInterface
    public void showToast(String toast){
        Toast.makeText(context,toast,Toast.LENGTH_SHORT).show();
    }
}
