package com.android.webviewnaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;
    private WebSettings mWebSettings;
    private GetContactActivity getContactActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //권한 설정
        AndPermission.with(this)
                .runtime()
                .permission(Permission.READ_CONTACTS,Permission.WRITE_CONTACTS)
                .start();
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void onCLickWebViewNaverBtn(View v) {
        Intent webViewIntent = new Intent(this, WebViewActivity.class);
        webViewIntent.putExtra("urlName", "Https://m.naver.com");
        startActivity(webViewIntent);
    }

    public void onCLickWebViewGoogleBtn(View v) {
        Intent webViewIntent = new Intent(this, WebViewActivity.class);
        webViewIntent.putExtra("urlName", "https://www.google.com/");
        startActivity(webViewIntent);
    }

    public void onCLickWebViewContacBtn(View v) {
        Intent getCotactIntent = new Intent(this, GetContactActivity.class);
        startActivity(getCotactIntent);
    }

    public void onCLickWebViewBridgeBtn(View v) {
        Intent webViewIntent = new Intent(this, WebViewActivity.class);
        webViewIntent.putExtra("urlName", "http://10.0.2.2:8080/profile/webViewTest");
        startActivity(webViewIntent);
    }
}