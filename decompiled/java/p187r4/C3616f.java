package p187r4;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.common.PlaybackException;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import com.google.android.gms.cast.AdBreakStatus;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import com.lzy.okgo.model.Progress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p002a1.C0026b;
import p018b5.AbstractC1312l;
import p028c6.C1400c;
import p101j7.C2782c;
import p165p4.C3362g;
import p165p4.C3367l;
import p165p4.C3370o;
import p165p4.InterfaceC3357b;
import p176q4.C3474b0;
import p199s4.C3716j;
import p230v4.AbstractC3987a;
import p230v4.C3988b;
import p230v4.C3998l;
import p230v4.C4000n;

public final class C3616f implements InterfaceC3357b {

    public static final C3988b f12147k = new C3988b("RemoteMediaClient", null);

    public final C3998l f12150c;

    public final C3621k f12151d;

    public final C3611a f12152e;

    public C3370o f12153f;

    public final CopyOnWriteArrayList f12154g = new CopyOnWriteArrayList();

    public final CopyOnWriteArrayList f12155h = new CopyOnWriteArrayList();

    public final ConcurrentHashMap f12156i = new ConcurrentHashMap();

    public final ConcurrentHashMap f12157j = new ConcurrentHashMap();

    public final Object f12148a = new Object();

    public final HandlerC1731y0 f12149b = new HandlerC1731y0(Looper.getMainLooper(), 0);

    static {
        String str = C3998l.f13529w;
    }

    public C3616f(C3998l c3998l) {
        C3621k c3621k = new C3621k(this);
        this.f12151d = c3621k;
        this.f12150c = c3998l;
        C3626p c3626p = new C3626p();
        c3626p.f12186a = this;
        c3998l.f13533h = c3626p;
        c3998l.f13559c = c3621k;
        this.f12152e = new C3611a(this);
    }

    public static final void m7289G(AbstractC3625o abstractC3625o) {
        try {
            abstractC3625o.m7345m0();
        } catch (IllegalArgumentException e5) {
            throw e5;
        } catch (Throwable unused) {
            abstractC3625o.m3643g0(new C3622l(new Status(2100, null, null, null), 1));
        }
    }

    public static C3623m m7290x() {
        C3623m c3623m = new C3623m();
        c3623m.m3643g0(new C3622l(new Status(17, null, null, null), 0));
        return c3623m;
    }

    public final boolean m7291A() {
        if (!m7305i()) {
            return false;
        }
        MediaStatus mediaStatusM7302f = m7302f();
        AbstractC1312l.m3198e(mediaStatusM7302f);
        if (!((mediaStatusM7302f.f4711h & 64) != 0) && mediaStatusM7302f.f4719p == 0) {
            Integer num = (Integer) mediaStatusM7302f.f4727x.get(mediaStatusM7302f.f4706c);
            if (num == null || num.intValue() >= mediaStatusM7302f.f4720q.size() - 1) {
                return false;
            }
        }
        return true;
    }

    public final boolean m7292B() {
        if (!m7305i()) {
            return false;
        }
        MediaStatus mediaStatusM7302f = m7302f();
        AbstractC1312l.m3198e(mediaStatusM7302f);
        if (!((mediaStatusM7302f.f4711h & 128) != 0) && mediaStatusM7302f.f4719p == 0) {
            Integer num = (Integer) mediaStatusM7302f.f4727x.get(mediaStatusM7302f.f4706c);
            if (num == null || num.intValue() <= 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean m7293C() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        MediaStatus mediaStatusM7302f = m7302f();
        return mediaStatusM7302f != null && mediaStatusM7302f.f4708e == 5;
    }

    public final boolean m7294D() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        if (!m7307k()) {
            return true;
        }
        MediaStatus mediaStatusM7302f = m7302f();
        return (mediaStatusM7302f == null || (mediaStatusM7302f.f4711h & 2) == 0 || mediaStatusM7302f.f4724u == null) ? false : true;
    }

    public final void m7295E(HashSet hashSet) {
        HashSet<InterfaceC3615e> hashSet2 = new HashSet(hashSet);
        if (m7310n() || m7309m() || m7306j() || m7293C()) {
            for (InterfaceC3615e interfaceC3615e : hashSet2) {
                m7299c();
                m7304h();
                interfaceC3615e.mo3844a();
            }
            return;
        }
        if (!m7308l()) {
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                ((InterfaceC3615e) it.next()).mo3844a();
            }
            return;
        }
        MediaQueueItem mediaQueueItemM7300d = m7300d();
        if (mediaQueueItemM7300d == null || mediaQueueItemM7300d.f4695a == null) {
            return;
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            ((InterfaceC3615e) it2.next()).mo3844a();
        }
    }

    public final boolean m7296F() {
        return this.f12153f != null;
    }

    public final void m7297a(InterfaceC3615e interfaceC3615e) {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        ConcurrentHashMap concurrentHashMap = this.f12156i;
        if (concurrentHashMap.containsKey(interfaceC3615e)) {
            return;
        }
        ConcurrentHashMap concurrentHashMap2 = this.f12157j;
        C3628r c3628r = (C3628r) concurrentHashMap2.get(1000L);
        if (c3628r == null) {
            c3628r = new C3628r(this);
            concurrentHashMap2.put(1000L, c3628r);
        }
        c3628r.f12189a.add(interfaceC3615e);
        concurrentHashMap.put(interfaceC3615e, c3628r);
        if (m7305i()) {
            C3616f c3616f = c3628r.f12193e;
            HandlerC1731y0 handlerC1731y0 = c3616f.f12149b;
            C3627q c3627q = c3628r.f12191c;
            handlerC1731y0.removeCallbacks(c3627q);
            c3628r.f12192d = true;
            c3616f.f12149b.postDelayed(c3627q, c3628r.f12190b);
        }
    }

    public final long m7298b() {
        long jM7982e;
        MediaStatus mediaStatus;
        AdBreakStatus adBreakStatus;
        synchronized (this.f12148a) {
            AbstractC1312l.m3195b("Must be called from the main thread.");
            C3998l c3998l = this.f12150c;
            jM7982e = 0;
            if (c3998l.f13530e != 0 && (mediaStatus = c3998l.f13531f) != null && (adBreakStatus = mediaStatus.f4722s) != null) {
                double d = mediaStatus.f4707d;
                if (d == 0.0d) {
                    d = 1.0d;
                }
                jM7982e = c3998l.m7982e(adBreakStatus.f4586b, mediaStatus.f4708e != 2 ? 0.0d : d, 0L);
            }
        }
        return jM7982e;
    }

    public final long m7299c() {
        long jM7990o;
        synchronized (this.f12148a) {
            AbstractC1312l.m3195b("Must be called from the main thread.");
            jM7990o = this.f12150c.m7990o();
        }
        return jM7990o;
    }

    public final MediaQueueItem m7300d() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        MediaStatus mediaStatusM7302f = m7302f();
        if (mediaStatusM7302f == null) {
            return null;
        }
        Integer num = (Integer) mediaStatusM7302f.f4727x.get(mediaStatusM7302f.f4715l);
        if (num == null) {
            return null;
        }
        return (MediaQueueItem) mediaStatusM7302f.f4720q.get(num.intValue());
    }

    public final MediaInfo m7301e() {
        MediaInfo mediaInfo;
        synchronized (this.f12148a) {
            AbstractC1312l.m3195b("Must be called from the main thread.");
            MediaStatus mediaStatus = this.f12150c.f13531f;
            mediaInfo = mediaStatus == null ? null : mediaStatus.f4704a;
        }
        return mediaInfo;
    }

    public final MediaStatus m7302f() {
        MediaStatus mediaStatus;
        synchronized (this.f12148a) {
            AbstractC1312l.m3195b("Must be called from the main thread.");
            mediaStatus = this.f12150c.f13531f;
        }
        return mediaStatus;
    }

    public final int m7303g() {
        int i6;
        synchronized (this.f12148a) {
            AbstractC1312l.m3195b("Must be called from the main thread.");
            MediaStatus mediaStatusM7302f = m7302f();
            i6 = mediaStatusM7302f != null ? mediaStatusM7302f.f4708e : 1;
        }
        return i6;
    }

    public final long m7304h() {
        long j10;
        synchronized (this.f12148a) {
            AbstractC1312l.m3195b("Must be called from the main thread.");
            MediaStatus mediaStatus = this.f12150c.f13531f;
            MediaInfo mediaInfo = mediaStatus == null ? null : mediaStatus.f4704a;
            j10 = mediaInfo != null ? mediaInfo.f4642e : 0L;
        }
        return j10;
    }

    public final boolean m7305i() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        return m7306j() || m7293C() || m7310n() || m7309m() || m7308l();
    }

    public final boolean m7306j() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        MediaStatus mediaStatusM7302f = m7302f();
        return mediaStatusM7302f != null && mediaStatusM7302f.f4708e == 4;
    }

    public final boolean m7307k() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        MediaInfo mediaInfoM7301e = m7301e();
        return mediaInfoM7301e != null && mediaInfoM7301e.f4639b == 2;
    }

    public final boolean m7308l() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        MediaStatus mediaStatusM7302f = m7302f();
        return (mediaStatusM7302f == null || mediaStatusM7302f.f4715l == 0) ? false : true;
    }

    public final boolean m7309m() {
        int i6;
        AbstractC1312l.m3195b("Must be called from the main thread.");
        MediaStatus mediaStatusM7302f = m7302f();
        if (mediaStatusM7302f == null) {
            return false;
        }
        if (mediaStatusM7302f.f4708e == 3) {
            return true;
        }
        if (!m7307k()) {
            return false;
        }
        synchronized (this.f12148a) {
            AbstractC1312l.m3195b("Must be called from the main thread.");
            MediaStatus mediaStatusM7302f2 = m7302f();
            i6 = mediaStatusM7302f2 != null ? mediaStatusM7302f2.f4709f : 0;
        }
        return i6 == 2;
    }

    public final boolean m7310n() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        MediaStatus mediaStatusM7302f = m7302f();
        return mediaStatusM7302f != null && mediaStatusM7302f.f4708e == 2;
    }

    public final boolean m7311o() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        MediaStatus mediaStatusM7302f = m7302f();
        return mediaStatusM7302f != null && mediaStatusM7302f.f4721r;
    }

    public final void m7312p(String str) {
        byte b8;
        int i6;
        int iM3602l;
        boolean z7;
        MediaStatus mediaStatus;
        int[] iArrM7980m;
        byte b10;
        C3998l c3998l = this.f12150c;
        C3988b c3988b = c3998l.f13557a;
        c3988b.m7975b("message received: %s", str);
        String str2 = c3988b.f13521a;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(SessionDescription.ATTR_TYPE);
            long jOptLong = jSONObject.optLong("requestId", -1L);
            switch (string) {
                case "LOAD_CANCELLED":
                    b8 = 3;
                    break;
                case "QUEUE_ITEMS":
                    b8 = 8;
                    break;
                case "INVALID_REQUEST":
                    b8 = 4;
                    break;
                case "LOAD_FAILED":
                    b8 = 2;
                    break;
                case "ERROR":
                    b8 = 5;
                    break;
                case "QUEUE_CHANGE":
                    b8 = 7;
                    break;
                case "INVALID_PLAYER_STATE":
                    b8 = 1;
                    break;
                case "MEDIA_STATUS":
                    b8 = 0;
                    break;
                case "QUEUE_ITEM_IDS":
                    b8 = 6;
                    break;
                default:
                    b8 = -1;
                    break;
            }
            C4000n c4000n = c3998l.f13535j;
            List list = c3998l.f13560d;
            switch (b8) {
                case 0:
                    JSONArray jSONArray = jSONObject.getJSONArray(Progress.STATUS);
                    if (jSONArray.length() > 0) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(0);
                        boolean zM7994c = c4000n.m7994c(jOptLong);
                        C4000n c4000n2 = c3998l.f13539n;
                        if (!c4000n2.m7995d() || c4000n2.m7994c(jOptLong)) {
                            C4000n c4000n3 = c3998l.f13540o;
                            i6 = (!c4000n3.m7995d() || c4000n3.m7994c(jOptLong)) ? 0 : 1;
                        }
                        if (zM7994c || (mediaStatus = c3998l.f13531f) == null) {
                            MediaStatus mediaStatus2 = new MediaStatus(null, 0L, 0, 0.0d, 0, 0, 0L, 0L, 0.0d, false, null, 0, 0, null, 0, null, false, null, null, null, null);
                            mediaStatus2.m3602l(jSONObject2, 0);
                            c3998l.f13531f = mediaStatus2;
                            c3998l.f13530e = SystemClock.elapsedRealtime();
                            iM3602l = 127;
                        } else {
                            iM3602l = mediaStatus.m3602l(jSONObject2, i6);
                        }
                        if ((iM3602l & 1) != 0) {
                            c3998l.f13530e = SystemClock.elapsedRealtime();
                            c3998l.f13534i = -1;
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if ((iM3602l & 2) != 0) {
                            c3998l.f13530e = SystemClock.elapsedRealtime();
                            z7 = true;
                        }
                        if ((iM3602l & 128) != 0) {
                            c3998l.f13530e = SystemClock.elapsedRealtime();
                        }
                        if ((4 & iM3602l) != 0) {
                            c3998l.m7985i();
                        }
                        if ((8 & iM3602l) != 0) {
                            c3998l.m7987k();
                        }
                        if ((iM3602l & 16) != 0) {
                            c3998l.m7986j();
                        }
                        if ((iM3602l & 32) != 0) {
                            c3998l.f13530e = SystemClock.elapsedRealtime();
                            C3626p c3626p = c3998l.f13533h;
                            if (c3626p != null) {
                                C3616f c3616f = c3626p.f12186a;
                                Iterator it = c3616f.f12154g.iterator();
                                while (it.hasNext()) {
                                    ((InterfaceC3614d) it.next()).mo7287j();
                                }
                                for (C3474b0 c3474b0 : c3616f.f12155h) {
                                    switch (c3474b0.f11753a) {
                                        case 2:
                                            ((C3716j) c3474b0.f11754b).m7474c();
                                    }
                                }
                            }
                        }
                        if ((iM3602l & 64) != 0) {
                            c3998l.f13530e = SystemClock.elapsedRealtime();
                        } else if (z7) {
                        }
                        c3998l.m7988l();
                    } else {
                        c3998l.f13531f = null;
                        c3998l.m7988l();
                        c3998l.m7985i();
                        c3998l.m7987k();
                        c3998l.m7986j();
                    }
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        ((C4000n) it2.next()).m7993b(jOptLong, 0, null);
                    }
                    break;
                case 1:
                    Log.w(str2, c3988b.m7977d("received unexpected error: Invalid Player State.", new Object[0]));
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        ((C4000n) it3.next()).m7993b(jOptLong, 2100, C3998l.m7979f(jSONObject));
                    }
                    break;
                case 2:
                    c4000n.m7993b(jOptLong, 2100, C3998l.m7979f(jSONObject));
                    break;
                case 3:
                    c4000n.m7993b(jOptLong, 2101, C3998l.m7979f(jSONObject));
                    break;
                case 4:
                    Log.w(str2, c3988b.m7977d("received unexpected error: Invalid Request.", new Object[0]));
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        ((C4000n) it4.next()).m7993b(jOptLong, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, C3998l.m7979f(jSONObject));
                    }
                    break;
                case 5:
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        ((C4000n) it5.next()).m7993b(jOptLong, 2100, C3998l.m7979f(jSONObject));
                    }
                    if (c3998l.f13533h != null) {
                        MediaError.m3590j(jSONObject);
                        Iterator it6 = c3998l.f13533h.f12186a.f12155h.iterator();
                        while (it6.hasNext()) {
                            ((C3474b0) it6.next()).getClass();
                        }
                    }
                    break;
                case 6:
                    c3998l.f13544s.m7993b(jOptLong, 0, null);
                    c3998l.m7984h(jSONObject, "QUEUE_ITEM_IDS");
                    if (c3998l.f13533h != null && (iArrM7980m = C3998l.m7980m(jSONObject.getJSONArray("itemIds"))) != null) {
                        Iterator it7 = c3998l.f13533h.f12186a.f12155h.iterator();
                        while (it7.hasNext()) {
                            ((C3474b0) it7.next()).m7109g(iArrM7980m);
                        }
                        break;
                    }
                    break;
                case 7:
                    c3998l.f13546u.m7993b(jOptLong, 0, null);
                    c3998l.m7984h(jSONObject, "QUEUE_CHANGE");
                    if (c3998l.f13533h != null) {
                        String string2 = jSONObject.getString("changeType");
                        int[] iArrM7980m2 = C3998l.m7980m(jSONObject.getJSONArray("itemIds"));
                        int iOptInt = jSONObject.optInt("insertBefore", 0);
                        if (iArrM7980m2 != null) {
                            switch (string2) {
                                case "INSERT":
                                    b10 = 0;
                                    break;
                                case "REMOVE":
                                    b10 = 2;
                                    break;
                                case "UPDATE":
                                    b10 = 3;
                                    break;
                                case "ITEMS_CHANGE":
                                    b10 = 1;
                                    break;
                                default:
                                    b10 = -1;
                                    break;
                            }
                            if (b10 == 0) {
                                Iterator it8 = c3998l.f13533h.f12186a.f12155h.iterator();
                                while (it8.hasNext()) {
                                    ((C3474b0) it8.next()).m7111i(iArrM7980m2, iOptInt);
                                }
                                break;
                            } else if (b10 == 1) {
                                Iterator it9 = c3998l.f13533h.f12186a.f12155h.iterator();
                                while (it9.hasNext()) {
                                    ((C3474b0) it9.next()).m7119q(iArrM7980m2);
                                }
                                break;
                            } else if (b10 == 2) {
                                Iterator it10 = c3998l.f13533h.f12186a.f12155h.iterator();
                                while (it10.hasNext()) {
                                    ((C3474b0) it10.next()).m7115m(iArrM7980m2);
                                }
                                break;
                            } else if (b10 == 3) {
                                int[] iArrM7980m3 = C3998l.m7980m(jSONObject.getJSONArray("itemIds"));
                                AbstractC1312l.m3199f(iArrM7980m3, "A list of item IDs is expected in a QUEUE UPDATE message.");
                                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("reorderItemIds");
                                if (jSONArrayOptJSONArray != null) {
                                    ArrayList arrayListM7971d = AbstractC3987a.m7971d(iArrM7980m3);
                                    int iOptInt2 = jSONObject.optInt("insertBefore", 0);
                                    int[] iArrM7980m4 = C3998l.m7980m(jSONArrayOptJSONArray);
                                    AbstractC1312l.m3198e(iArrM7980m4);
                                    ArrayList arrayListM7971d2 = AbstractC3987a.m7971d(iArrM7980m4);
                                    Iterator it11 = c3998l.f13533h.f12186a.f12155h.iterator();
                                    while (it11.hasNext()) {
                                        ((C3474b0) it11.next()).m7117o(arrayListM7971d, arrayListM7971d2, iOptInt2);
                                    }
                                } else {
                                    Iterator it12 = c3998l.f13533h.f12186a.f12155h.iterator();
                                    while (it12.hasNext()) {
                                        ((C3474b0) it12.next()).m7109g(iArrM7980m3);
                                    }
                                }
                                break;
                            }
                        }
                    }
                    break;
                case 8:
                    c3998l.f13545t.m7993b(jOptLong, 0, null);
                    c3998l.m7984h(jSONObject, "QUEUE_ITEMS");
                    if (c3998l.f13533h != null) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("items");
                        MediaQueueItem[] mediaQueueItemArr = new MediaQueueItem[jSONArray2.length()];
                        for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                            mediaQueueItemArr[i10] = new C2782c(jSONArray2.getJSONObject(i10)).m5759r();
                        }
                        Iterator it13 = c3998l.f13533h.f12186a.f12155h.iterator();
                        while (it13.hasNext()) {
                            ((C3474b0) it13.next()).m7113k(mediaQueueItemArr);
                        }
                    }
                    break;
            }
        } catch (JSONException e5) {
            Log.w(str2, c3988b.m7977d("Message is malformed (%s); ignoring: %s", e5.getMessage(), str));
        }
    }

    public final void m7313q() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        if (m7296F()) {
            m7289G(new C3618h(this, 1));
        } else {
            m7290x();
        }
    }

    public final void m7314r() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        if (m7296F()) {
            m7289G(new C3618h(this, 0));
        } else {
            m7290x();
        }
    }

    public final void m7315s(InterfaceC3615e interfaceC3615e) {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        C3628r c3628r = (C3628r) this.f12156i.remove(interfaceC3615e);
        if (c3628r != null) {
            HashSet hashSet = c3628r.f12189a;
            hashSet.remove(interfaceC3615e);
            if (hashSet.isEmpty()) {
                this.f12157j.remove(Long.valueOf(c3628r.f12190b));
                c3628r.f12193e.f12149b.removeCallbacks(c3628r.f12191c);
                c3628r.f12192d = false;
            }
        }
    }

    public final BasePendingResult m7316t(C3362g c3362g) {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        if (!m7296F()) {
            return m7290x();
        }
        C3619i c3619i = new C3619i(this, c3362g, 2);
        m7289G(c3619i);
        return c3619i;
    }

    public final void m7317u(long j10) {
        m7316t(new C3362g(j10, false));
    }

    public final void m7318v() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        int iM7303g = m7303g();
        if (iM7303g == 4 || iM7303g == 2) {
            AbstractC1312l.m3195b("Must be called from the main thread.");
            if (m7296F()) {
                m7289G(new C3618h(this, 3));
                return;
            } else {
                m7290x();
                return;
            }
        }
        AbstractC1312l.m3195b("Must be called from the main thread.");
        if (m7296F()) {
            m7289G(new C3618h(this, 4));
        } else {
            m7290x();
        }
    }

    public final int m7319w() {
        MediaQueueItem mediaQueueItemM7300d;
        if (m7301e() != null && m7305i()) {
            if (m7306j()) {
                return 6;
            }
            if (m7310n()) {
                return 3;
            }
            if (m7309m()) {
                return 2;
            }
            if (m7308l() && (mediaQueueItemM7300d = m7300d()) != null && mediaQueueItemM7300d.f4695a != null) {
                return 6;
            }
        }
        return 0;
    }

    public final void m7320y() {
        C3370o c3370o = this.f12153f;
        if (c3370o == null) {
            return;
        }
        AbstractC1312l.m3195b("Must be called from the main thread.");
        String str = this.f12150c.f13558b;
        AbstractC3987a.m7970c(str);
        HashMap map = c3370o.f11375B;
        synchronized (map) {
            map.put(str, this);
        }
        C1400c c1400cM3273c = C1400c.m3273c();
        c1400cM3273c.f4265c = new C3367l(c3370o, str, this);
        c1400cM3273c.f4263a = 8413;
        c3370o.m8306c(1, c1400cM3273c.m3275b());
        AbstractC1312l.m3195b("Must be called from the main thread.");
        if (m7296F()) {
            m7289G(new C3618h(this, 6));
        } else {
            m7290x();
        }
    }

    public final void m7321z(C3370o c3370o) {
        InterfaceC3357b interfaceC3357b;
        C3370o c3370o2 = this.f12153f;
        if (c3370o2 == c3370o) {
            return;
        }
        if (c3370o2 != null) {
            this.f12150c.m7989n();
            this.f12152e.m7245c();
            AbstractC1312l.m3195b("Must be called from the main thread.");
            String str = this.f12150c.f13558b;
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Channel namespace cannot be null or empty");
            }
            HashMap map = c3370o2.f11375B;
            synchronized (map) {
                interfaceC3357b = (InterfaceC3357b) map.remove(str);
            }
            C1400c c1400cM3273c = C1400c.m3273c();
            c1400cM3273c.f4265c = new C0026b(c3370o2, interfaceC3357b, str, 28);
            c1400cM3273c.f4263a = 8414;
            c3370o2.m8306c(1, c1400cM3273c.m3275b());
            this.f12151d.f12170b = null;
            this.f12149b.removeCallbacksAndMessages(null);
        }
        this.f12153f = c3370o;
        if (c3370o != null) {
            this.f12151d.f12170b = c3370o;
        }
    }
}
