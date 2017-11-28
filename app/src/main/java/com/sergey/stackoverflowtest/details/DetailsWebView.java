package com.sergey.stackoverflowtest.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;

import com.sergey.stackoverflowtest.R;

/**
 * Created by sergey on 28.11.17.
 */

public class DetailsWebView extends AppCompatActivity {

    public static final String URL = "url";

    public static void startWebDetailsActivity(Context context, String url) {
        Intent intent = new Intent(context, DetailsWebView.class);
        intent.putExtra(URL, url);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_web_activity_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        String url = intent.getStringExtra(URL);
        WebView webView = findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

}
