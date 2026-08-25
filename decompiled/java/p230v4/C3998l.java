package p230v4;

import android.os.SystemClock;
import android.util.Log;
import androidx.appcompat.app.C0161t0;
import androidx.leanback.widget.C0486o;
import androidx.media3.common.PlaybackException;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLiveSeekableRange;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.internal.cast.C1507a5;
import com.google.android.gms.internal.cast.C1540d8;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import com.lzy.okgo.model.Progress;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p176q4.C3474b0;
import p176q4.C3475c;
import p187r4.C3611a;
import p187r4.C3616f;
import p187r4.C3626p;
import p187r4.C3627q;
import p187r4.C3628r;
import p187r4.InterfaceC3614d;
import p199s4.C3716j;

public final class C3998l extends AbstractC4001o {

    public static final String f13529w;

    public long f13530e;

    public MediaStatus f13531f;

    public Long f13532g;

    public C3626p f13533h;

    public int f13534i;

    public final C4000n f13535j;

    public final C4000n f13536k;

    public final C4000n f13537l;

    public final C4000n f13538m;

    public final C4000n f13539n;

    public final C4000n f13540o;

    public final C4000n f13541p;

    public final C4000n f13542q;

    public final C4000n f13543r;

    public final C4000n f13544s;

    public final C4000n f13545t;

    public final C4000n f13546u;

    public final C4000n f13547v;

    static {
        Pattern pattern = AbstractC3987a.f13519a;
        f13529w = "urn:x-cast:com.google.cast.media";
    }

    public C3998l() {
        super(f13529w);
        this.f13534i = -1;
        C4000n c4000n = new C4000n(86400000L, "load");
        this.f13535j = c4000n;
        C4000n c4000n2 = new C4000n(86400000L, "pause");
        this.f13536k = c4000n2;
        C4000n c4000n3 = new C4000n(86400000L, "play");
        this.f13537l = c4000n3;
        C4000n c4000n4 = new C4000n(86400000L, "stop");
        C4000n c4000n5 = new C4000n(Renderer.DEFAULT_DURATION_TO_PROGRESS_US, "seek");
        this.f13538m = c4000n5;
        C4000n c4000n6 = new C4000n(86400000L, "volume");
        this.f13539n = c4000n6;
        C4000n c4000n7 = new C4000n(86400000L, "mute");
        this.f13540o = c4000n7;
        C4000n c4000n8 = new C4000n(86400000L, Progress.STATUS);
        this.f13541p = c4000n8;
        C4000n c4000n9 = new C4000n(86400000L, "activeTracks");
        this.f13542q = c4000n9;
        C4000n c4000n10 = new C4000n(86400000L, "trackStyle");
        C4000n c4000n11 = new C4000n(86400000L, "queueInsert");
        C4000n c4000n12 = new C4000n(86400000L, "queueUpdate");
        this.f13543r = c4000n12;
        C4000n c4000n13 = new C4000n(86400000L, "queueRemove");
        C4000n c4000n14 = new C4000n(86400000L, "queueReorder");
        C4000n c4000n15 = new C4000n(86400000L, "queueFetchItemIds");
        this.f13544s = c4000n15;
        C4000n c4000n16 = new C4000n(86400000L, "queueFetchItemRange");
        this.f13546u = c4000n16;
        this.f13545t = new C4000n(86400000L, "queueFetchItems");
        C4000n c4000n17 = new C4000n(86400000L, "setPlaybackRate");
        C4000n c4000n18 = new C4000n(86400000L, "skipAd");
        this.f13547v = c4000n18;
        m7998a(c4000n);
        m7998a(c4000n2);
        m7998a(c4000n3);
        m7998a(c4000n4);
        m7998a(c4000n5);
        m7998a(c4000n6);
        m7998a(c4000n7);
        m7998a(c4000n8);
        m7998a(c4000n9);
        m7998a(c4000n10);
        m7998a(c4000n11);
        m7998a(c4000n12);
        m7998a(c4000n13);
        m7998a(c4000n14);
        m7998a(c4000n15);
        m7998a(c4000n16);
        m7998a(c4000n16);
        m7998a(c4000n17);
        m7998a(c4000n18);
        m7983g();
    }

    public static C3997k m7979f(JSONObject jSONObject) {
        MediaError.m3590j(jSONObject);
        C3997k c3997k = new C3997k();
        Pattern pattern = AbstractC3987a.f13519a;
        if (jSONObject.has("customData")) {
            jSONObject.optJSONObject("customData");
        }
        return c3997k;
    }

    public static int[] m7980m(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[jSONArray.length()];
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            iArr[i6] = jSONArray.getInt(i6);
        }
        return iArr;
    }

    public final void m7981d(InterfaceC3999m interfaceC3999m, int i6) {
        JSONObject jSONObject = new JSONObject();
        long jM7999b = m7999b();
        try {
            jSONObject.put("requestId", jM7999b);
            jSONObject.put(SessionDescription.ATTR_TYPE, "QUEUE_UPDATE");
            jSONObject.put("mediaSessionId", m7991p());
            if (i6 != 0) {
                jSONObject.put("jump", i6);
            }
            int i10 = this.f13534i;
            if (i10 != -1) {
                jSONObject.put("sequenceNumber", i10);
            }
        } catch (JSONException unused) {
        }
        m8000c(jM7999b, jSONObject.toString());
        this.f13543r.m7992a(jM7999b, new C3995i(this, interfaceC3999m, 1));
    }

    public final long m7982e(long j10, double d, long j11) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f13530e;
        if (jElapsedRealtime < 0) {
            jElapsedRealtime = 0;
        }
        if (jElapsedRealtime == 0) {
            return j10;
        }
        long j12 = j10 + ((long) (jElapsedRealtime * d));
        if (j11 > 0 && j12 > j11) {
            return j11;
        }
        if (j12 >= 0) {
            return j12;
        }
        return 0L;
    }

    public final void m7983g() {
        this.f13530e = 0L;
        this.f13531f = null;
        Iterator it = this.f13560d.iterator();
        while (it.hasNext()) {
            ((C4000n) it.next()).m7997f(PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT);
        }
    }

    public final void m7984h(JSONObject jSONObject, String str) {
        if (jSONObject.has("sequenceNumber")) {
            this.f13534i = jSONObject.optInt("sequenceNumber", -1);
        } else {
            C3988b c3988b = this.f13557a;
            Log.w(c3988b.f13521a, c3988b.m7977d(str.concat(" message is missing a sequence number."), new Object[0]));
        }
    }

    public final void m7985i() {
        C3626p c3626p = this.f13533h;
        if (c3626p != null) {
            C3616f c3616f = c3626p.f12186a;
            c3616f.getClass();
            Iterator it = c3616f.f12154g.iterator();
            while (it.hasNext()) {
                ((InterfaceC3614d) it.next()).mo7283b();
            }
            for (C3474b0 c3474b0 : c3616f.f12155h) {
                switch (c3474b0.f11753a) {
                    case 2:
                        ((C3716j) c3474b0.f11754b).m7474c();
                        break;
                }
            }
        }
    }

    public final void m7986j() {
        C3626p c3626p = this.f13533h;
        if (c3626p != null) {
            C3616f c3616f = c3626p.f12186a;
            Iterator it = c3616f.f12154g.iterator();
            while (it.hasNext()) {
                ((InterfaceC3614d) it.next()).mo7288o();
            }
            for (C3474b0 c3474b0 : c3616f.f12155h) {
                switch (c3474b0.f11753a) {
                    case 2:
                        ((C3716j) c3474b0.f11754b).m7474c();
                        break;
                }
            }
        }
    }

    public final void m7987k() {
        C3626p c3626p = this.f13533h;
        if (c3626p != null) {
            C3616f c3616f = c3626p.f12186a;
            Iterator it = c3616f.f12154g.iterator();
            while (it.hasNext()) {
                ((InterfaceC3614d) it.next()).mo7284c();
            }
            for (C3474b0 c3474b0 : c3616f.f12155h) {
                switch (c3474b0.f11753a) {
                    case 2:
                        ((C3716j) c3474b0.f11754b).m7474c();
                        break;
                }
            }
        }
    }

    public final void m7988l() {
        C3626p c3626p = this.f13533h;
        if (c3626p != null) {
            C3616f c3616f = c3626p.f12186a;
            c3616f.getClass();
            for (C3628r c3628r : c3616f.f12157j.values()) {
                if (c3616f.m7305i() && !c3628r.f12192d) {
                    C3616f c3616f2 = c3628r.f12193e;
                    HandlerC1731y0 handlerC1731y0 = c3616f2.f12149b;
                    C3627q c3627q = c3628r.f12191c;
                    handlerC1731y0.removeCallbacks(c3627q);
                    c3628r.f12192d = true;
                    c3616f2.f12149b.postDelayed(c3627q, c3628r.f12190b);
                } else if (!c3616f.m7305i() && c3628r.f12192d) {
                    c3628r.f12193e.f12149b.removeCallbacks(c3628r.f12191c);
                    c3628r.f12192d = false;
                }
                if (c3628r.f12192d && (c3616f.m7306j() || c3616f.m7293C() || c3616f.m7309m() || c3616f.m7308l())) {
                    c3616f.m7295E(c3628r.f12189a);
                }
            }
            Iterator it = c3616f.f12154g.iterator();
            while (it.hasNext()) {
                ((InterfaceC3614d) it.next()).mo7285e();
            }
            for (C3474b0 c3474b0 : c3616f.f12155h) {
                switch (c3474b0.f11753a) {
                    case 0:
                        C3475c c3475c = (C3475c) c3474b0.f11754b;
                        C3616f c3616f3 = c3475c.f11763j;
                        MediaStatus mediaStatusM7302f = c3616f3 != null ? c3616f3.m7302f() : null;
                        C1507a5 c1507a5 = c3475c.f11765l;
                        if (c1507a5 != null && mediaStatusM7302f != null) {
                            C1540d8 c1540d8M3261l = c1507a5.f5205a.m3261l();
                            C0486o c0486o = new C0486o(mediaStatusM7302f);
                            C0161t0 c0161t0 = new C0161t0();
                            c0161t0.f443a = c0486o.f2374a;
                            c0161t0.f444b = System.currentTimeMillis();
                            C0161t0 c0161t1 = c1540d8M3261l.f5268m;
                            if (c0161t1 == null || c0161t1.f443a != 2) {
                                c0161t0.f445c = c1540d8M3261l.f5263h;
                                c1540d8M3261l.f5268m = c0161t0;
                            }
                        }
                        break;
                    case 1:
                        C3611a c3611a = (C3611a) c3474b0.f11754b;
                        long jM7247e = c3611a.m7247e();
                        if (jM7247e != c3611a.f12116b) {
                            c3611a.f12116b = jM7247e;
                            c3611a.m7245c();
                            if (c3611a.f12116b != 0) {
                                c3611a.m7246d();
                            }
                        }
                        break;
                    default:
                        ((C3716j) c3474b0.f11754b).m7474c();
                        break;
                }
            }
        }
    }

    public final void m7989n() {
        List list = this.f13560d;
        synchronized (list) {
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((C4000n) it.next()).m7997f(PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        m7983g();
    }

    public final long m7990o() {
        MediaLiveSeekableRange mediaLiveSeekableRange;
        MediaStatus mediaStatus = this.f13531f;
        MediaInfo mediaInfo = mediaStatus == null ? null : mediaStatus.f4704a;
        long jM7982e = 0;
        if (mediaInfo == null || mediaStatus == null) {
            return 0L;
        }
        Long l9 = this.f13532g;
        if (l9 == null) {
            if (this.f13530e == 0) {
                return 0L;
            }
            double d = mediaStatus.f4707d;
            long j10 = mediaStatus.f4710g;
            return (d == 0.0d || mediaStatus.f4708e != 2) ? j10 : m7982e(j10, d, mediaInfo.f4642e);
        }
        if (l9.equals(4294967296000L)) {
            MediaStatus mediaStatus2 = this.f13531f;
            if (mediaStatus2.f4724u != null) {
                long jLongValue = l9.longValue();
                MediaStatus mediaStatus3 = this.f13531f;
                if (mediaStatus3 != null && (mediaLiveSeekableRange = mediaStatus3.f4724u) != null) {
                    boolean z7 = mediaLiveSeekableRange.f4660d;
                    long j11 = mediaLiveSeekableRange.f4658b;
                    jM7982e = !z7 ? m7982e(j11, 1.0d, -1L) : j11;
                }
                return Math.min(jLongValue, jM7982e);
            }
            MediaInfo mediaInfo2 = mediaStatus2 == null ? null : mediaStatus2.f4704a;
            if ((mediaInfo2 != null ? mediaInfo2.f4642e : 0L) >= 0) {
                long jLongValue2 = l9.longValue();
                MediaStatus mediaStatus4 = this.f13531f;
                MediaInfo mediaInfo3 = mediaStatus4 != null ? mediaStatus4.f4704a : null;
                return Math.min(jLongValue2, mediaInfo3 != null ? mediaInfo3.f4642e : 0L);
            }
        }
        return l9.longValue();
    }

    public final long m7991p() throws C3996j {
        MediaStatus mediaStatus = this.f13531f;
        if (mediaStatus != null) {
            return mediaStatus.f4705b;
        }
        throw new C3996j();
    }
}
