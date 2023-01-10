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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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

        if (webViewIntent.getStringExtra("flag") != null) {
            if (webViewIntent.getStringExtra("contactVOList") != null) {
                try {
                    System.out.println("flagTest :: 1");
                    //JSONObject contactVOList = new JSONObject(webViewIntent.getStringExtra("contactVOList"));
                    String contactVOList = webViewIntent.getStringExtra("contactVOList");
                    String url = "http://10.0.2.2:8080/profile/webViewTestResult";
                    String postData = "contactVOList=" + URLEncoder.encode(contactVOList, "UTF-8");
                    mWebView.postUrl(url, postData.getBytes());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("flagTest :: 2");
                mWebView.loadUrl("http://10.0.2.2:8080/profile/webViewTestResult?falgMsg=등록된 연락처가 없습니다.");
            }
        } else {
            System.out.println("flagTest :: 3");
            mWebView.loadUrl(webViewIntent.getStringExtra("urlName"));
        }

        mWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
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