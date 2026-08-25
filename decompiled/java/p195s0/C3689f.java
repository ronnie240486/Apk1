package p195s0;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

public final class C3689f implements InterfaceC3690g {

    public final InputContentInfo f12343a;

    public C3689f(Object obj) {
        this.f12343a = (InputContentInfo) obj;
    }

    @Override
    public final ClipDescription mo7324a() {
        return this.f12343a.getDescription();
    }

    @Override
    public final Object mo7325b() {
        return this.f12343a;
    }

    @Override
    public final Uri mo7326c() {
        return this.f12343a.getContentUri();
    }

    @Override
    public final void mo7327d() {
        this.f12343a.requestPermission();
    }

    @Override
    public final Uri mo7328e() {
        return this.f12343a.getLinkUri();
    }

    public C3689f(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f12343a = new InputContentInfo(uri, clipDescription, uri2);
    }
}
