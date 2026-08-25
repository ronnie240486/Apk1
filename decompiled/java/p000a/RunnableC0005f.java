package p000a;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.C0159s0;
import androidx.appcompat.app.WindowCallbackC0171z;
import androidx.appcompat.widget.C0267s1;
import androidx.appcompat.widget.RunnableC0261r0;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.AsyncTaskC0330h;
import androidx.core.widget.C0368a;
import androidx.core.widget.ViewOnTouchListenerC0375h;
import androidx.leanback.widget.picker.DatePicker;
import androidx.lifecycle.C0518d0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import ba.C1371d;
import com.bumptech.glide.ComponentCallbacks2C1491o;
import com.google.android.gms.cast.CastRemoteDisplayLocalService;
import com.google.android.gms.internal.cast.C1640o;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.p2serv.android.p032ds.R;
import com.tencent.bugly.proguard.C2024ag;
import com.tencent.bugly.proguard.C2038au;
import com.tencent.mars.xlog.Log;
import ga.C2618a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import org.bitspark.android.Spark;
import org.bitspark.android.SpkApplication;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3320b;
import p001a0.C0023f;
import p003a2.AbstractC0032a;
import p028c6.C1400c;
import p044da.C2339b;
import p055ea.C2448k;
import p055ea.ViewOnClickListenerC2474x;
import p063fa.C2569x0;
import p064g.C2578e;
import p084i1.C2681d;
import p105k.MenuC2838l;
import p116ka.C2911c;
import p116ka.C2924i0;
import p116ka.C2926j0;
import p116ka.C2930l0;
import p129m1.C3030b;
import p138n0.AbstractC3155s0;
import p156o9.AbstractC3280d;
import p173q1.C3421k0;
import p222u7.AbstractC3928d;
import p226v0.C3968d;
import p230v4.C3988b;
import sa.C3741l;

public final class RunnableC0005f implements Runnable {

    public final int f5a;

    public final Object f6b;

    public RunnableC0005f(int i6, Object obj) {
        this.f5a = i6;
        this.f6b = obj;
    }

    @Override
    public final void run() {
        Object obj;
        boolean z7;
        boolean z10;
        RecyclerView recyclerView;
        Spark spark;
        switch (this.f5a) {
            case 0:
                try {
                    super/*android.app.Activity*/.onBackPressed();
                    return;
                } catch (IllegalStateException e5) {
                    if (!TextUtils.equals(e5.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e5;
                    }
                    return;
                }
            case 1:
                C0159s0 c0159s0 = (C0159s0) this.f6b;
                WindowCallbackC0171z windowCallbackC0171z = c0159s0.f433s;
                Menu menuM456V = c0159s0.m456V();
                MenuC2838l menuC2838l = menuM456V instanceof MenuC2838l ? (MenuC2838l) menuM456V : null;
                if (menuC2838l != null) {
                    menuC2838l.m5840y();
                }
                try {
                    menuM456V.clear();
                    if (!windowCallbackC0171z.onCreatePanelMenu(0, menuM456V) || !windowCallbackC0171z.onPreparePanel(0, null, menuM456V)) {
                        menuM456V.clear();
                    }
                    if (menuC2838l != null) {
                        return;
                    } else {
                        return;
                    }
                } finally {
                    if (menuC2838l != null) {
                        menuC2838l.m5839x();
                    }
                }
                break;
            case 2:
                C0267s1 c0267s1 = (C0267s1) this.f6b;
                c0267s1.f1062l = null;
                c0267s1.drawableStateChanged();
                return;
            case 3:
                ((Toolbar) this.f6b).m630v();
                return;
            case 4:
                ViewOnTouchListenerC0375h viewOnTouchListenerC0375h = (ViewOnTouchListenerC0375h) this.f6b;
                if (viewOnTouchListenerC0375h.f1678o) {
                    boolean z11 = viewOnTouchListenerC0375h.f1676m;
                    C0368a c0368a = viewOnTouchListenerC0375h.f1664a;
                    if (z11) {
                        viewOnTouchListenerC0375h.f1676m = false;
                        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        c0368a.f1656e = jCurrentAnimationTimeMillis;
                        c0368a.f1658g = -1L;
                        c0368a.f1657f = jCurrentAnimationTimeMillis;
                        c0368a.f1659h = 0.5f;
                    }
                    if ((c0368a.f1658g > 0 && AnimationUtils.currentAnimationTimeMillis() > c0368a.f1658g + ((long) c0368a.f1660i)) || !viewOnTouchListenerC0375h.m1134e()) {
                        viewOnTouchListenerC0375h.f1678o = false;
                        return;
                    }
                    boolean z12 = viewOnTouchListenerC0375h.f1677n;
                    ListView listView = viewOnTouchListenerC0375h.f1666c;
                    if (z12) {
                        viewOnTouchListenerC0375h.f1677n = false;
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                        listView.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                    }
                    if (c0368a.f1657f == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float fM1116a = c0368a.m1116a(jCurrentAnimationTimeMillis2);
                    long j10 = jCurrentAnimationTimeMillis2 - c0368a.f1657f;
                    c0368a.f1657f = jCurrentAnimationTimeMillis2;
                    viewOnTouchListenerC0375h.f1680q.scrollListBy((int) (j10 * ((fM1116a * 4.0f) + ((-4.0f) * fM1116a * fM1116a)) * c0368a.f1655d));
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    listView.postOnAnimation(this);
                    return;
                }
                return;
            case 5:
                synchronized (((C0518d0) this.f6b).f2472a) {
                    obj = ((C0518d0) this.f6b).f2477f;
                    ((C0518d0) this.f6b).f2477f = C0518d0.f2471k;
                    break;
                }
                ((C0518d0) this.f6b).m1490j(obj);
                return;
            case 6:
                ViewPager viewPager = (ViewPager) this.f6b;
                viewPager.setScrollState(0);
                viewPager.m3096p();
                return;
            case 7:
                C1400c c1400c = (C1400c) this.f6b;
                c1400c.f4264b = false;
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) c1400c.f4266d;
                C3968d c3968d = bottomSheetBehavior.f5968K;
                if (c3968d != null && c3968d.m7952g()) {
                    c1400c.m3276d(c1400c.f4263a);
                    return;
                } else {
                    if (bottomSheetBehavior.f5967J == 2) {
                        bottomSheetBehavior.m4125B(c1400c.f4263a);
                        return;
                    }
                    return;
                }
            case 8:
                Toast.makeText(Log.toastSupportContext, (String) this.f6b, 1).show();
                return;
            case 9:
                ComponentCallbacks2C1491o componentCallbacks2C1491o = (ComponentCallbacks2C1491o) this.f6b;
                componentCallbacks2C1491o.f4504c.mo5862h(componentCallbacks2C1491o);
                return;
            case 10:
                View view = (View) this.f6b;
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
                return;
            case 11:
                C2024ag.m4598c((List) this.f6b);
                return;
            case 12:
                C2038au.m4781a((C2038au) this.f6b);
                return;
            case 13:
                C2339b c2339b = (C2339b) this.f6b;
                File[] fileArrListFiles = c2339b.f8146f.listFiles();
                if (fileArrListFiles != null) {
                    int length = fileArrListFiles.length;
                    int length2 = 0;
                    int i6 = 0;
                    for (int i10 = 0; i10 < length; i10++) {
                        File file = fileArrListFiles[i10];
                        length2 = (int) ((file == null ? 0L : file.length()) + ((long) length2));
                        i6++;
                        c2339b.f8145e.put(file, Long.valueOf(file.lastModified()));
                    }
                    c2339b.f8141a.set(length2);
                    c2339b.f8142b.set(i6);
                    return;
                }
                return;
            case 14:
                ((ViewOnClickListenerC2474x) this.f6b).f8674b.m6709Z();
                return;
            case 15:
                Spark spark2 = ((C2448k) this.f6b).f8630b;
                spark2.f11031A0.smoothScrollToPosition(spark2.f11120i0.m7734d(0));
                return;
            case 16:
                C2569x0 c2569x0 = (C2569x0) ((AsyncTaskC0330h) this.f6b).f1501b;
                c2569x0.notifyItemInserted(c2569x0.f8932j.size() - 1);
                return;
            case 17:
                C2578e c2578e = (C2578e) this.f6b;
                c2578e.m5576a(true);
                c2578e.invalidateSelf();
                return;
            case 18:
                ((C2618a) this.f6b).f9101b.f9103a.dismiss();
                return;
            case 19:
                DatePicker datePicker = (DatePicker) this.f6b;
                int[] iArr = {datePicker.f2396u, datePicker.f2395t, datePicker.f2397v};
                boolean z13 = true;
                boolean z14 = true;
                for (int i11 = 2; i11 >= 0; i11--) {
                    int i12 = iArr[i11];
                    if (i12 >= 0) {
                        int i13 = DatePicker.f2388C[i11];
                        ArrayList arrayList = datePicker.f2404c;
                        C2681d c2681d = arrayList == null ? null : (C2681d) arrayList.get(i12);
                        if (z13) {
                            int i14 = datePicker.f2400y.get(i13);
                            if (i14 != c2681d.f9322b) {
                                c2681d.f9322b = i14;
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                        } else {
                            int actualMinimum = datePicker.f2389A.getActualMinimum(i13);
                            if (actualMinimum != c2681d.f9322b) {
                                c2681d.f9322b = actualMinimum;
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                        }
                        if (z14) {
                            int i15 = datePicker.f2401z.get(i13);
                            if (i15 != c2681d.f9323c) {
                                c2681d.f9323c = i15;
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                        } else {
                            int actualMaximum = datePicker.f2389A.getActualMaximum(i13);
                            if (actualMaximum != c2681d.f9323c) {
                                c2681d.f9323c = actualMaximum;
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                        }
                        boolean z15 = z7 | z10;
                        z13 &= datePicker.f2389A.get(i13) == datePicker.f2400y.get(i13);
                        z14 &= datePicker.f2389A.get(i13) == datePicker.f2401z.get(i13);
                        if (z15) {
                            datePicker.m1458b(iArr[i11], c2681d);
                        }
                        datePicker.m1459c(iArr[i11], datePicker.f2389A.get(i13));
                    }
                }
                return;
            case 20:
                C2911c c2911c = (C2911c) this.f6b;
                C1371d.m3242a(c2911c.f9868b.m1321j(), 0, c2911c.f9868b.m1324m().getString(R.string.advise_delete_outdated_programs)).show();
                return;
            case 21:
                TextView textView = (TextView) this.f6b;
                int width = textView.getWidth();
                int height = textView.getHeight();
                AbstractC0032a.m165s("GSNYn2IyHtA8KVuO\n", "UUw1+iRAf7c=\n");
                AbstractC0032a.m165s("lrTj0mAMzKaXhf7kbQeCsZC/rbA=\n", "5dGXkAFiosM=\n");
                AbstractC0032a.m165s("+CyZ0wepoQ==\n", "xRGk7jqUnAo=\n");
                if (width == 0 || height == 0) {
                    return;
                }
                textView.setVisibility(0);
                textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, width, 0.0f, new int[]{AbstractC3928d.m7847i(SpkApplication.f11160c.getApplicationContext(), R.color.home_banner_title_text_start), AbstractC3928d.m7847i(SpkApplication.f11160c.getApplicationContext(), R.color.home_banner_title_text_end)}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
                textView.invalidate();
                return;
            case 22:
                ((C2924i0) this.f6b).m5915Q();
                return;
            case 23:
                RunnableC0261r0 runnableC0261r0 = (RunnableC0261r0) this.f6b;
                C3741l c3741l = (C3741l) ((C2924i0) runnableC0261r0.f1046d).m1319h().m1184k().m1264z((String) runnableC0261r0.f1045c);
                if (c3741l != null && (recyclerView = c3741l.f12540U) != null) {
                    AbstractC3280d.m6607z(recyclerView, runnableC0261r0.f1044b);
                }
                String strM165s = AbstractC0032a.m165s("/k9t2V+CmMbEZnv8XZucwdw=\n", "qCAJnTr2+a8=\n");
                String str = AbstractC0032a.m165s("3sXlnlHYndqhpOzex1k=\n", "O0NoeP15dVs=\n") + ((C2924i0) runnableC0261r0.f1046d).m1319h().getCurrentFocus();
                boolean z16 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s, str);
                return;
            case 24:
                ((C2926j0) this.f6b).f9935b.f9968g0.setVisibility(8);
                return;
            case 25:
                C2930l0 c2930l0 = (C2930l0) this.f6b;
                C1371d.m3242a(c2930l0.f9944d.m1321j(), 0, c2930l0.f9944d.m1324m().getString(R.string.advise_delete_outdated_programs)).show();
                return;
            case 26:
                C3030b c3030b = (C3030b) this.f6b;
                c3030b.f10365f.f2574d.remove(c3030b.f10363d.f10399a.getBinder());
                return;
            case 27:
                C1640o c1640o = ((C3320b) ((C0023f) this.f6b).f47e).f11207e;
                if (c1640o == null || !c1640o.f5479f || (spark = c1640o.f5475b) == null) {
                    return;
                }
                ((ViewGroup) spark.getWindow().getDecorView()).removeView(c1640o);
                c1640o.m3954a();
                return;
            case 28:
                CastRemoteDisplayLocalService castRemoteDisplayLocalService = (CastRemoteDisplayLocalService) this.f6b;
                castRemoteDisplayLocalService.m3589a("onCreate after delay. The local service been started: " + castRemoteDisplayLocalService.f4622a);
                if (castRemoteDisplayLocalService.f4622a) {
                    return;
                }
                C3988b c3988b = CastRemoteDisplayLocalService.f4620d;
                android.util.Log.e(c3988b.f13521a, c3988b.m7977d("[Instance: %s] %s", castRemoteDisplayLocalService, "The local service has not been been started, stopping it"));
                castRemoteDisplayLocalService.stopSelf();
                return;
            default:
                ((C3421k0) this.f6b).m6998h();
                return;
        }
    }
}
