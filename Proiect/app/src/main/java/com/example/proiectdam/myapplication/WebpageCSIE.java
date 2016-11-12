package com.example.proiectdam.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewFragment;
import android.widget.TextView;

public class WebpageCSIE extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.webpage_csie, container, false);
        String link = "http://csie.ase.ro";
        WebView webViewCSIE = (WebView)v.findViewById(R.id.webViewCSIE);
        webViewCSIE.getSettings().setJavaScriptEnabled(true);
        webViewCSIE.loadUrl(link);
        webViewCSIE.setWebViewClient(new WebViewClient());
        return v;
    }
}
