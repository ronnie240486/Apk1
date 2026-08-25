package com.tencent.bugly.crashreport;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.crashreport.crash.p033h5.H5JavaScriptInterface;

public final class C2009a implements CrashReport.InterfaceC2008a {

    public final WebView f7046a;

    public C2009a(WebView webView) {
        this.f7046a = webView;
    }

    @Override
    public final String mo4476a() {
        return this.f7046a.getUrl();
    }

    @Override
    public final void mo4479b() {
        WebSettings settings = this.f7046a.getSettings();
        if (settings.getJavaScriptEnabled()) {
            return;
        }
        settings.setJavaScriptEnabled(true);
    }

    @Override
    public final CharSequence mo4480c() {
        return this.f7046a.getContentDescription();
    }

    @Override
    public final void mo4478a(String str) {
        this.f7046a.loadUrl(str);
    }

    @Override
    public final void mo4477a(H5JavaScriptInterface h5JavaScriptInterface, String str) {
        this.f7046a.addJavascriptInterface(h5JavaScriptInterface, str);
    }
}
