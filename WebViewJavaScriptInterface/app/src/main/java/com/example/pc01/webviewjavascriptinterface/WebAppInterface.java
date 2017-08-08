package com.example.pc01.webviewjavascriptinterface;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by pc01 on 05/09/2015.
 */
public class WebAppInterface {
    Context context;

    public WebAppInterface(Context context){
        this.context = context;

    }

    @JavascriptInterface
    public void showToast(String toast){
        Toast.makeText(context,toast,Toast.LENGTH_SHORT).show();
    }

}
