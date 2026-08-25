package androidx.media;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import androidx.mediarouter.app.HandlerC1080c;
import com.bumptech.glide.AbstractC1466d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import p129m1.C3030b;
import p129m1.C3033e;
import p129m1.C3035g;
import p129m1.C3037i;
import p129m1.C3038j;
import p160p.C3341e;

public abstract class MediaBrowserServiceCompat extends Service {

    public C3033e f2571a;

    public final C3030b f2572b = new C3030b(this, "android.media.session.MediaController", -1, -1, null);

    public final ArrayList f2573c = new ArrayList();

    public final C3341e f2574d = new C3341e(0);

    public final HandlerC1080c f2575e = new HandlerC1080c(this);

    static {
        Log.isLoggable("MBServiceCompat", 3);
    }

    public abstract AbstractC1466d m1531a();

    public abstract void m1532b();

    @Override
    public final IBinder onBind(Intent intent) {
        return this.f2571a.f10368b.onBind(intent);
    }

    @Override
    public final void onCreate() {
        super.onCreate();
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 28) {
            this.f2571a = new C3038j(this);
        } else if (i6 >= 26) {
            this.f2571a = new C3037i(this);
        } else if (i6 >= 23) {
            this.f2571a = new C3035g(this);
        } else {
            this.f2571a = new C3033e(this);
        }
        this.f2571a.mo6102a();
    }

    @Override
    public final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }
}
