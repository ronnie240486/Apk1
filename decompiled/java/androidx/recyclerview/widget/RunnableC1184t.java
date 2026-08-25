package androidx.recyclerview.widget;

import android.os.Trace;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import p094j0.AbstractC2766n;

public final class RunnableC1184t implements Runnable {

    public static final ThreadLocal f3695e = new ThreadLocal();

    public static final C1175q f3696f = new C1175q();

    public long f3698b;

    public long f3699c;

    public final ArrayList f3697a = new ArrayList();

    public final ArrayList f3700d = new ArrayList();

    public static AbstractC1174p1 m2991c(RecyclerView recyclerView, int i6, long j10) {
        int iM2916h = recyclerView.mChildHelper.m2916h();
        for (int i10 = 0; i10 < iM2916h; i10++) {
            AbstractC1174p1 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.m2915g(i10));
            if (childViewHolderInt.mPosition == i6 && !childViewHolderInt.isInvalid()) {
                return null;
            }
        }
        C1140e1 c1140e1 = recyclerView.mRecycler;
        if (j10 == Long.MAX_VALUE) {
            try {
                if (AbstractC2766n.m5740a()) {
                    Trace.beginSection("RV Prefetch forced - needed next frame");
                }
            } finally {
                recyclerView.onExitLayoutOrScroll(false);
                Trace.endSection();
            }
        }
        recyclerView.onEnterLayoutOrScroll();
        AbstractC1174p1 abstractC1174p1M2935l = c1140e1.m2935l(i6, j10);
        if (abstractC1174p1M2935l != null) {
            if (!abstractC1174p1M2935l.isBound() || abstractC1174p1M2935l.isInvalid()) {
                c1140e1.m2925a(abstractC1174p1M2935l, false);
            } else {
                c1140e1.m2932i(abstractC1174p1M2935l.itemView);
            }
        }
        return abstractC1174p1M2935l;
    }

    public final void m2992a(RecyclerView recyclerView, int i6, int i10) {
        if (recyclerView.isAttachedToWindow()) {
            if (RecyclerView.sDebugAssertionsEnabled && !this.f3697a.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            }
            if (this.f3698b == 0) {
                this.f3698b = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        C1178r c1178r = recyclerView.mPrefetchRegistry;
        c1178r.f3674a = i6;
        c1178r.f3675b = i10;
    }

    public final void m2993b(long j10) {
        C1181s c1181s;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        C1181s c1181s2;
        ArrayList arrayList = this.f3697a;
        int size = arrayList.size();
        int i6 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            RecyclerView recyclerView3 = (RecyclerView) arrayList.get(i10);
            if (recyclerView3.getWindowVisibility() == 0) {
                recyclerView3.mPrefetchRegistry.m2987b(recyclerView3, false);
                i6 += recyclerView3.mPrefetchRegistry.f3677d;
            }
        }
        ArrayList arrayList2 = this.f3700d;
        arrayList2.ensureCapacity(i6);
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            RecyclerView recyclerView4 = (RecyclerView) arrayList.get(i12);
            if (recyclerView4.getWindowVisibility() == 0) {
                C1178r c1178r = recyclerView4.mPrefetchRegistry;
                int iAbs = Math.abs(c1178r.f3675b) + Math.abs(c1178r.f3674a);
                for (int i13 = 0; i13 < c1178r.f3677d * 2; i13 += 2) {
                    if (i11 >= arrayList2.size()) {
                        c1181s2 = new C1181s();
                        arrayList2.add(c1181s2);
                    } else {
                        c1181s2 = (C1181s) arrayList2.get(i11);
                    }
                    int[] iArr = c1178r.f3676c;
                    int i14 = iArr[i13 + 1];
                    c1181s2.f3682a = i14 <= iAbs;
                    c1181s2.f3683b = iAbs;
                    c1181s2.f3684c = i14;
                    c1181s2.f3685d = recyclerView4;
                    c1181s2.f3686e = iArr[i13];
                    i11++;
                }
            }
        }
        Collections.sort(arrayList2, f3696f);
        for (int i15 = 0; i15 < arrayList2.size() && (recyclerView = (c1181s = (C1181s) arrayList2.get(i15)).f3685d) != null; i15++) {
            AbstractC1174p1 abstractC1174p1M2991c = m2991c(recyclerView, c1181s.f3686e, c1181s.f3682a ? Long.MAX_VALUE : j10);
            if (abstractC1174p1M2991c != null && abstractC1174p1M2991c.mNestedRecyclerView != null && abstractC1174p1M2991c.isBound() && !abstractC1174p1M2991c.isInvalid() && (recyclerView2 = abstractC1174p1M2991c.mNestedRecyclerView.get()) != null) {
                if (recyclerView2.mDataSetHasChangedAfterLayout && recyclerView2.mChildHelper.m2916h() != 0) {
                    recyclerView2.removeAndRecycleViews();
                }
                C1178r c1178r2 = recyclerView2.mPrefetchRegistry;
                c1178r2.m2987b(recyclerView2, true);
                if (c1178r2.f3677d != 0) {
                    try {
                        Trace.beginSection(j10 == Long.MAX_VALUE ? "RV Nested Prefetch" : "RV Nested Prefetch forced - needed next frame");
                        C1162l1 c1162l1 = recyclerView2.mState;
                        AbstractC1158k0 abstractC1158k0 = recyclerView2.mAdapter;
                        c1162l1.f3618d = 1;
                        c1162l1.f3619e = abstractC1158k0.getItemCount();
                        c1162l1.f3621g = false;
                        c1162l1.f3622h = false;
                        c1162l1.f3623i = false;
                        for (int i16 = 0; i16 < c1178r2.f3677d * 2; i16 += 2) {
                            m2991c(recyclerView2, c1178r2.f3676c[i16], j10);
                        }
                        Trace.endSection();
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                }
            }
            c1181s.f3682a = false;
            c1181s.f3683b = 0;
            c1181s.f3684c = 0;
            c1181s.f3685d = null;
            c1181s.f3686e = 0;
        }
    }

    @Override
    public final void run() {
        try {
            Trace.beginSection("RV Prefetch");
            ArrayList arrayList = this.f3697a;
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long jMax = 0;
                for (int i6 = 0; i6 < size; i6++) {
                    RecyclerView recyclerView = (RecyclerView) arrayList.get(i6);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    m2993b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f3699c);
                }
            }
        } finally {
            this.f3698b = 0L;
            Trace.endSection();
        }
    }
}
