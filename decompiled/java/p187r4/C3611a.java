package p187r4;

import android.os.Looper;
import android.util.SparseIntArray;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p018b5.AbstractC1312l;
import p176q4.C3474b0;
import p230v4.C3988b;

public final class C3611a {

    public long f12116b;

    public final C3616f f12117c;

    public ArrayList f12118d;

    public final SparseIntArray f12119e;

    public final C3634x f12120f;

    public final ArrayList f12121g;

    public final ArrayDeque f12122h;

    public final HandlerC1731y0 f12123i;

    public final C3627q f12124j;

    public BasePendingResult f12125k;

    public BasePendingResult f12126l;

    public final Set f12127m = Collections.synchronizedSet(new HashSet());

    public final C3988b f12115a = new C3988b("MediaQueue", null);

    public C3611a(C3616f c3616f) {
        this.f12117c = c3616f;
        Math.max(20, 1);
        this.f12118d = new ArrayList();
        this.f12119e = new SparseIntArray();
        this.f12121g = new ArrayList();
        this.f12122h = new ArrayDeque(20);
        this.f12123i = new HandlerC1731y0(Looper.getMainLooper(), 0);
        int i6 = 1;
        this.f12124j = new C3627q(i6, this);
        C3474b0 c3474b0 = new C3474b0(i6, this);
        c3616f.getClass();
        AbstractC1312l.m3195b("Must be called from the main thread.");
        c3616f.f12155h.add(c3474b0);
        this.f12120f = new C3634x(this);
        this.f12116b = m7247e();
        m7246d();
    }

    public static void m7243a(C3611a c3611a) {
        Set set = c3611a.f12127m;
        synchronized (set) {
            try {
                Iterator it = set.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void m7244b(C3611a c3611a) {
        SparseIntArray sparseIntArray = c3611a.f12119e;
        sparseIntArray.clear();
        for (int i6 = 0; i6 < c3611a.f12118d.size(); i6++) {
            sparseIntArray.put(((Integer) c3611a.f12118d.get(i6)).intValue(), i6);
        }
    }

    public final void m7245c() {
        m7250h();
        this.f12118d.clear();
        this.f12119e.clear();
        this.f12120f.evictAll();
        this.f12121g.clear();
        this.f12123i.removeCallbacks(this.f12124j);
        this.f12122h.clear();
        BasePendingResult basePendingResult = this.f12126l;
        if (basePendingResult != null) {
            basePendingResult.m3638b0();
            this.f12126l = null;
        }
        BasePendingResult basePendingResult2 = this.f12125k;
        if (basePendingResult2 != null) {
            basePendingResult2.m3638b0();
            this.f12125k = null;
        }
        m7249g();
        m7248f();
    }

    public final void m7246d() {
        BasePendingResult basePendingResult;
        BasePendingResult basePendingResultM7290x;
        AbstractC1312l.m3195b("Must be called from the main thread.");
        if (this.f12116b != 0 && (basePendingResult = this.f12126l) == null) {
            if (basePendingResult != null) {
                basePendingResult.m3638b0();
                this.f12126l = null;
            }
            BasePendingResult basePendingResult2 = this.f12125k;
            if (basePendingResult2 != null) {
                basePendingResult2.m3638b0();
                this.f12125k = null;
            }
            C3616f c3616f = this.f12117c;
            c3616f.getClass();
            AbstractC1312l.m3195b("Must be called from the main thread.");
            if (c3616f.m7296F()) {
                C3618h c3618h = new C3618h(c3616f);
                C3616f.m7289G(c3618h);
                basePendingResultM7290x = c3618h;
            } else {
                basePendingResultM7290x = C3616f.m7290x();
            }
            this.f12126l = basePendingResultM7290x;
            basePendingResultM7290x.m3644h0(new C3633w(this, 0));
        }
    }

    public final long m7247e() {
        MediaStatus mediaStatusM7302f = this.f12117c.m7302f();
        if (mediaStatusM7302f == null) {
            return 0L;
        }
        MediaInfo mediaInfo = mediaStatusM7302f.f4704a;
        int i6 = mediaInfo == null ? -1 : mediaInfo.f4639b;
        int i10 = mediaStatusM7302f.f4708e;
        int i11 = mediaStatusM7302f.f4709f;
        int i12 = mediaStatusM7302f.f4715l;
        if (i10 == 1) {
            if (i11 == 1) {
                if (i12 == 0) {
                    return 0L;
                }
            } else if (i11 != 2) {
                if (i11 != 3) {
                    return 0L;
                }
                if (i12 == 0) {
                    return 0L;
                }
            } else if (i6 != 2) {
                return 0L;
            }
        }
        return mediaStatusM7302f.f4705b;
    }

    public final void m7248f() {
        Set set = this.f12127m;
        synchronized (set) {
            try {
                Iterator it = set.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m7249g() {
        Set set = this.f12127m;
        synchronized (set) {
            try {
                Iterator it = set.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m7250h() {
        Set set = this.f12127m;
        synchronized (set) {
            try {
                Iterator it = set.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
