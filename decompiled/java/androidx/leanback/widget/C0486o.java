package androidx.leanback.widget;

import com.google.android.gms.cast.MediaStatus;

public class C0486o {

    public final int f2374a;

    public boolean m1446a(int i6) {
        return (this.f2374a & i6) == i6;
    }

    public boolean m1447b() {
        return !(!m1446a(32) || m1446a(64) || m1446a(128)) || m1446a(64);
    }

    public boolean m1448c() {
        return m1447b() || m1446a(128);
    }

    public C0486o(MediaStatus mediaStatus) {
        this.f2374a = mediaStatus.f4708e;
    }
}
