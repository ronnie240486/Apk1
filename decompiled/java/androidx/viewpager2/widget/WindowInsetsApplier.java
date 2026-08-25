package androidx.viewpager2.widget;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p138n0.C3153r1;
import p138n0.InterfaceC3154s;

public final class WindowInsetsApplier implements InterfaceC3154s {
    private WindowInsetsApplier() {
    }

    private C3153r1 consumeAllInsets(C3153r1 c3153r1) {
        C3153r1 c3153r2 = C3153r1.f10640b;
        return c3153r2.m6330g() != null ? c3153r2 : c3153r1.f10641a.mo6237c().f10641a.mo6236b();
    }

    public static boolean install(ViewPager2 viewPager2) {
        ApplicationInfo applicationInfo = viewPager2.getContext().getApplicationInfo();
        if (Build.VERSION.SDK_INT >= 30 && applicationInfo.targetSdkVersion >= 30) {
            return false;
        }
        WindowInsetsApplier windowInsetsApplier = new WindowInsetsApplier();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        AbstractC3119g0.m6182u(viewPager2, windowInsetsApplier);
        return true;
    }

    @Override
    public C3153r1 onApplyWindowInsets(View view, C3153r1 c3153r1) {
        ViewPager2 viewPager2 = (ViewPager2) view;
        C3153r1 c3153r1M6341k = AbstractC3155s0.m6341k(viewPager2, c3153r1);
        if (c3153r1M6341k.f10641a.mo6239n()) {
            return c3153r1M6341k;
        }
        RecyclerView recyclerView = viewPager2.mRecyclerView;
        int childCount = recyclerView.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            AbstractC3155s0.m6332b(recyclerView.getChildAt(i6), new C3153r1(c3153r1M6341k));
        }
        return consumeAllInsets(c3153r1M6341k);
    }
}
