package p230v4;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.recyclerview.widget.C1130c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import p028c6.C1400c;
import p109k3.C2888t;
import p165p4.C3366k;
import p165p4.C3370o;
import p176q4.C3477d;
import p187r4.C3621k;
import p242w5.AbstractC4057e;
import p242w5.C4058f;

public abstract class AbstractC4001o {

    public final C3988b f13557a;

    public final String f13558b;

    public C3621k f13559c;

    public final List f13560d;

    public AbstractC4001o(String str) {
        AbstractC3987a.m7970c(str);
        this.f13558b = str;
        this.f13557a = new C3988b("MediaControlChannel", null);
        this.f13560d = Collections.synchronizedList(new ArrayList());
    }

    public final void m7998a(C4000n c4000n) {
        this.f13560d.add(c4000n);
    }

    public final long m7999b() {
        C3621k c3621k = this.f13559c;
        if (c3621k != null) {
            return ((AtomicLong) c3621k.f12171c).getAndIncrement();
        }
        C3988b c3988b = this.f13557a;
        Log.e(c3988b.f13521a, c3988b.m7977d("Attempt to generate requestId without a sink", new Object[0]));
        return 0L;
    }

    public final void m8000c(long j10, String str) {
        int i6 = 1;
        Object[] objArr = {str, null};
        C3988b c3988b = this.f13557a;
        c3988b.getClass();
        boolean zEquals = Build.TYPE.equals("user");
        String str2 = c3988b.f13521a;
        if (!zEquals && c3988b.f13522b && Log.isLoggable(str2, 2)) {
            Log.v(str2, c3988b.m7977d("Sending text message: %s to: %s", objArr));
        }
        C3621k c3621k = this.f13559c;
        if (c3621k == null) {
            Log.e(str2, c3988b.m7977d("Attempt to send text message without a sink", new Object[0]));
            return;
        }
        C3370o c3370o = (C3370o) c3621k.f12170b;
        if (c3370o == null) {
            throw new IllegalStateException("Device is not connected");
        }
        String str3 = this.f13558b;
        AbstractC3987a.m7970c(str3);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (str.length() > 524288) {
            C3988b c3988b2 = C3370o.f11372F;
            Log.w(c3988b2.f13521a, c3988b2.m7977d("Message send failed. Message exceeds maximum size", new Object[0]));
            throw new IllegalArgumentException("Message exceeds maximum size524288");
        }
        C1400c c1400cM3273c = C1400c.m3273c();
        c1400cM3273c.f4265c = new C3366k(c3370o, str3, str, i6);
        c1400cM3273c.f4263a = 8405;
        C3477d c3477dM8306c = c3370o.m8306c(1, c1400cM3273c.m3275b());
        C1130c c1130c = new C1130c(c3621k, j10);
        c3477dM8306c.getClass();
        ((C2888t) c3477dM8306c.f11770c).m5891h(new C4058f(AbstractC4057e.f13721a, c1130c));
        c3477dM8306c.m7134g();
    }
}
