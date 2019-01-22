package com.ftninformatika.termin13.Activites;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ftninformatika.termin13.R;

public class SecondActivity extends Activity {
    public static final int INTERNET_PERMISSION_REQUEST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

       if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) ==
                    PackageManager.PERMISSION_GRANTED){

                showPage();

        }else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET },INTERNET_PERMISSION_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case INTERNET_PERMISSION_REQUEST:
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                showPage();
            }
            break;
        }
    }

    private void showPage(){
        Intent intent = getIntent();
        String adresa = intent.getStringExtra("URL");
        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        webView.loadUrl(adresa);

    }
}
