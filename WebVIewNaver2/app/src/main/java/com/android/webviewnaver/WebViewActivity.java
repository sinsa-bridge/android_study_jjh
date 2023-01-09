package com.android.webviewnaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {
    private WebView mWebView;
    private WebSettings mWebSettings;
    private TextView mtextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Intent webViewIntent = getIntent();
        Intent progressIntent = new Intent(this, ProgressActivity.class);

        mWebView = (WebView) findViewById(R.id.webView);
        mtextView = (TextView) findViewById(R.id.textView);

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



        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                mWebView.setVisibility(View.INVISIBLE);
                mtextView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                mWebView.setVisibility(View.VISIBLE);
                mtextView.setVisibility(View.INVISIBLE);
            }
        });

        mWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
    }

    public void onClickCloseBtn(View v) {
        Intent webViewIntent = getIntent();
        Intent mainIntent = new Intent(this, MainActivity.class);

        String urlName = webViewIntent.getStringExtra("urlName");
        if (urlName.equals("Https://m.naver.com")) {
            Toast.makeText(this, "네이버 웹뷰가 종료되었습니다.", Toast.LENGTH_SHORT).show();
        } else if (urlName.equals("https://www.google.com/")) {
            Toast.makeText(this, "구글 웹뷰가 종료되었습니다.", Toast.LENGTH_SHORT).show();
        }

        finish();
        startActivity(mainIntent);
    }
}