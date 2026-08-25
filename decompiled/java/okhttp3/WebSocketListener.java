package okhttp3;

import okio.ByteString;
import p103j9.AbstractC2796i;

public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i6, String str) {
        AbstractC2796i.m5785f(webSocket, "webSocket");
        AbstractC2796i.m5785f(str, "reason");
    }

    public void onClosing(WebSocket webSocket, int i6, String str) {
        AbstractC2796i.m5785f(webSocket, "webSocket");
        AbstractC2796i.m5785f(str, "reason");
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        AbstractC2796i.m5785f(webSocket, "webSocket");
        AbstractC2796i.m5785f(th, "t");
    }

    public void onMessage(WebSocket webSocket, String str) {
        AbstractC2796i.m5785f(webSocket, "webSocket");
        AbstractC2796i.m5785f(str, "text");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        AbstractC2796i.m5785f(webSocket, "webSocket");
        AbstractC2796i.m5785f(response, "response");
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        AbstractC2796i.m5785f(webSocket, "webSocket");
        AbstractC2796i.m5785f(byteString, "bytes");
    }
}
