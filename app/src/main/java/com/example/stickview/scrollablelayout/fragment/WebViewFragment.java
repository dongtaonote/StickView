package com.example.stickview.scrollablelayout.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import com.example.stickview.R;
import com.example.stickview.scrollablelayout.fragment.base.ScrollAbleFragment;
import com.example.stickview.scrollablelayout.scrollhelper.ScrollableHelper;

public class WebViewFragment extends ScrollAbleFragment implements ScrollableHelper.ScrollableContainer {

    private WebView webView;
    private EditText mAddressEdt;

    public static WebViewFragment newInstance() {
        WebViewFragment scrollViewFragment = new WebViewFragment();
        return scrollViewFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview, container, false);
        mAddressEdt = (EditText) view.findViewById(R.id.addressEdt);
        view.findViewById(R.id.goBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(mAddressEdt.getText().toString());
            }
        });
        webView = (WebView) view.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("https://www.baidu.com/");
        return view;
    }

    @Override
    public View getScrollableView() {
        return webView;
    }
}
