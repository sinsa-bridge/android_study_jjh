package com.android.webviewnaver;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.logging.Handler;

public class WebAppInterface {
    Context mContext;

    public WebAppInterface(Context mContext)  {
        this.mContext = mContext;
    }

    public WebAppInterface() {}

    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void getContactRequest() {
        /*
        * 웹뷰에 주소록 띄어주기
        *
        * 1. Web에서 getContactRequest() 요청을 받아 GetContactActivity 실행
        * 2. GetContactActivity의 getContactList() 메소드로 contact 리턴
        * 3. contact return -> json으로 Web에 response
        *
        * */


    }


}
