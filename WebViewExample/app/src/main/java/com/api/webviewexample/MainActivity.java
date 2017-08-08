package com.api.webviewexample;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WebView webView = (WebView)findViewById(R.id.webView);
        webView.loadUrl("http://www.google.ps");

        if(webView.canGoBack()){
            webView.goBack();
        }

        //webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new MyWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.addJavascriptInterface(new WebInterface(this),"Android");
    }
    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(Uri.parse(url).getHost().equals("www.google.ps"))
            {

            }
            Intent intent = new Intent(Intent.ACTION_VIEW);
            startActivity(intent);
            return true;
        }


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if(request.getUrl().getHost().equals("www.google.ps")){

                }
            }
            Intent intent = new Intent(Intent.ACTION_VIEW);
            startActivity(intent);
            return true;
        }
    }
}
