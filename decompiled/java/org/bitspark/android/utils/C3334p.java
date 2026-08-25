package org.bitspark.android.utils;

import com.nmmedit.protect.NativeUtil;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public final class C3334p extends WebSocketListener {

    public final String f11255a;

    public final C3335q f11256b;

    static {
        NativeUtil.classesInit0(0);
    }

    public C3334p(C3335q c3335q, String str) {
        this.f11256b = c3335q;
        this.f11255a = str;
    }

    @Override
    public final native void onClosed(WebSocket webSocket, int i6, String str);

    @Override
    public final native void onClosing(WebSocket webSocket, int i6, String str);

    @Override
    public final native void onFailure(WebSocket webSocket, Throwable th, Response response);

    @Override
    public final native void onMessage(WebSocket webSocket, String str);

    @Override
    public final native void onOpen(WebSocket webSocket, Response response);
}
