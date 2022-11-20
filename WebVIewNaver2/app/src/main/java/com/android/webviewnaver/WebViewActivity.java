package com.android.webviewnaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {
    private WebView mWebView;
    private WebSettings mWebSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Intent webViewIntent = getIntent();

        mWebView = (WebView) findViewById(R.id.webView);

        mWebView.setWebViewClient(new WebViewClient());
        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setSupportMultipleWindows(false);
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(false);
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setSupportZoom(false);
        mWebSettings.setBuiltInZoomControls(false);
        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebSettings.setDomStorageEnabled(true);

        mWebView.loadUrl(webViewIntent.getStringExtra("urlName"));
    }

    public void onClickCloseBtn(View v) {
        Intent webViewIntent = getIntent();
        String urlName = webViewIntent.getStringExtra("urlName");
        if (urlName.equals("Https://m.naver.com")) {
            Toast.makeText(this, "네이버 웹뷰가 종료되었습니다.", Toast.LENGTH_SHORT).show();
        } else if (urlName.equals("https://www.google.com/")) {
            Toast.makeText(this, "구글 웹뷰가 종료되었습니다.", Toast.LENGTH_SHORT).show();
        } 
        

    }
}