package p129m1;

import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.media.MediaBrowserServiceCompat;
import java.util.HashMap;
import p000a.RunnableC0005f;
import p118l0.AbstractC2955f;

public final class C3030b implements IBinder.DeathRecipient {

    public final String f10360a;

    public final int f10361b;

    public final int f10362c;

    public final C3044p f10363d;

    public final HashMap f10364e = new HashMap();

    public final MediaBrowserServiceCompat f10365f;

    public C3030b(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, int i6, int i10, C3044p c3044p) {
        this.f10365f = mediaBrowserServiceCompat;
        this.f10360a = str;
        this.f10361b = i6;
        this.f10362c = i10;
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        if (Build.VERSION.SDK_INT >= 28) {
            AbstractC2955f.m5994n(i6, i10, str);
        }
        this.f10363d = c3044p;
    }

    @Override
    public final void binderDied() {
        this.f10365f.f2575e.post(new RunnableC0005f(26, this));
    }
}
