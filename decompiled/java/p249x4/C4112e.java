package p249x4;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.text.Editable;
import android.text.Selection;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.AbstractC0410j0;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import com.google.android.material.internal.C1819e0;
import com.google.android.material.internal.InterfaceC1817d0;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import p007a7.C0069f;
import p014b1.C1246t;
import p018b5.AbstractC1312l;
import p035d1.C2124b;
import p038d4.InterfaceC2152b;
import p049e3.C2384d0;
import p049e3.InterfaceC2386e0;
import p049e3.InterfaceC2397o;
import p077h4.C2652b;
import p077h4.C2653c;
import p077h4.EnumC2655e;
import p086i3.C2688d;
import p086i3.C2693i;
import p109k3.InterfaceC2874f;
import p109k3.InterfaceC2875g;
import p109k3.InterfaceC2877i;
import p109k3.InterfaceC2881m;
import p110k4.InterfaceC2890a;
import p114k8.C2903c;
import p120l2.InterfaceC2970g;
import p126l8.InterfaceC3013a;
import p138n0.AbstractC3155s0;
import p138n0.C3153r1;
import p143n5.C3196b;
import p143n5.C3197c;
import p144n7.C3214l;
import p144n7.InterfaceC3215m;
import p165p4.C3370o;
import p186r3.AbstractC3597a;
import p221u6.C3905e;
import p228v2.C3981h;
import p228v2.InterfaceC3984k;
import p230v4.C3988b;
import p230v4.C3990d;
import p230v4.C4009w;
import p242w5.C4056d;
import p247x2.InterfaceC4102x;
import p248x3.EnumC4107c;
import p259y2.InterfaceC4238a;
import p271z4.InterfaceC4340k;
import sa.InterfaceC3744o;

public class C4112e implements InterfaceC1817d0, InterfaceC2397o, InterfaceC2386e0, InterfaceC2152b, InterfaceC3984k, InterfaceC2875g, InterfaceC2874f, InterfaceC2881m, InterfaceC2890a, InterfaceC3744o, InterfaceC2970g, InterfaceC3215m, InterfaceC3013a, InterfaceC4340k {

    public static C4112e f13939b;

    public final int f13940a;

    public C4112e(int i6) {
        this.f13940a = i6;
    }

    public static void m8130j(Context context) {
        AbstractC1312l.m3198e(context);
        synchronized (C4112e.class) {
            try {
                if (f13939b == null) {
                    AbstractC4119l.m8140a(context);
                    C4112e c4112e = new C4112e(0);
                    context.getApplicationContext();
                    f13939b = c4112e;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean m8131q(C2124b c2124b, Editable editable, int i6, int i10, boolean z7) {
        int iMin;
        if (editable == null || i6 < 0 || i10 < 0) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart == -1 || selectionEnd == -1 || selectionStart != selectionEnd) {
            return false;
        }
        if (z7) {
            int iMax = Math.max(i6, 0);
            int length = editable.length();
            if (selectionStart >= 0 && length >= selectionStart && iMax >= 0) {
                loop0: while (true) {
                    boolean z10 = false;
                    while (true) {
                        if (iMax == 0) {
                            break loop0;
                        }
                        selectionStart--;
                        if (selectionStart < 0) {
                            if (!z10) {
                                selectionStart = 0;
                                break loop0;
                            }
                            break loop0;
                        }
                        char cCharAt = editable.charAt(selectionStart);
                        if (z10) {
                            if (Character.isHighSurrogate(cCharAt)) {
                                iMax--;
                            }
                        } else if (!Character.isSurrogate(cCharAt)) {
                            iMax--;
                        } else if (!Character.isHighSurrogate(cCharAt)) {
                            z10 = true;
                        }
                        selectionStart = -1;
                        break loop0;
                    }
                }
            }
            selectionStart = -1;
            break loop0;
            int iMax2 = Math.max(i10, 0);
            iMin = editable.length();
            if (selectionEnd >= 0 && iMin >= selectionEnd && iMax2 >= 0) {
                loop2: while (true) {
                    boolean z11 = false;
                    while (true) {
                        if (iMax2 != 0) {
                            if (selectionEnd >= iMin) {
                                if (!z11) {
                                    break loop2;
                                }
                                break loop2;
                            }
                            char cCharAt2 = editable.charAt(selectionEnd);
                            if (z11) {
                                if (Character.isLowSurrogate(cCharAt2)) {
                                    iMax2--;
                                    selectionEnd++;
                                }
                            } else if (!Character.isSurrogate(cCharAt2)) {
                                iMax2--;
                                selectionEnd++;
                            } else if (!Character.isLowSurrogate(cCharAt2)) {
                                selectionEnd++;
                                z11 = true;
                            }
                            iMin = -1;
                            break loop2;
                        }
                        iMin = selectionEnd;
                        break loop2;
                    }
                }
            }
            iMin = -1;
            break loop2;
            if (selectionStart == -1 || iMin == -1) {
                return false;
            }
        } else {
            selectionStart = Math.max(selectionStart - i6, 0);
            iMin = Math.min(selectionEnd + i10, editable.length());
        }
        C1246t[] c1246tArr = (C1246t[]) editable.getSpans(selectionStart, iMin, C1246t.class);
        if (c1246tArr == null || c1246tArr.length <= 0) {
            return false;
        }
        for (C1246t c1246t : c1246tArr) {
            int spanStart = editable.getSpanStart(c1246t);
            int spanEnd = editable.getSpanEnd(c1246t);
            selectionStart = Math.min(spanStart, selectionStart);
            iMin = Math.max(spanEnd, iMin);
        }
        int iMax3 = Math.max(selectionStart, 0);
        int iMin2 = Math.min(iMin, editable.length());
        c2124b.beginBatchEdit();
        editable.delete(iMax3, iMin2);
        c2124b.endBatchEdit();
        return true;
    }

    public static final AbstractBinderC4116i m8132v(PackageInfo packageInfo, AbstractBinderC4116i... abstractBinderC4116iArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            BinderC4117j binderC4117j = new BinderC4117j(packageInfo.signatures[0].toByteArray());
            for (int i6 = 0; i6 < abstractBinderC4116iArr.length; i6++) {
                if (abstractBinderC4116iArr[i6].equals(binderC4117j)) {
                    return abstractBinderC4116iArr[i6];
                }
            }
        }
        return null;
    }

    public static final boolean m8133w(PackageInfo packageInfo) {
        PackageInfo packageInfo2;
        boolean z7;
        if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z7 = (applicationInfo == null || (applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) == 0) ? false : true;
            } else {
                z7 = true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
            z7 = true;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z7 ? m8132v(packageInfo2, AbstractC4118k.f13952a) : m8132v(packageInfo2, AbstractC4118k.f13952a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void accept(Object obj) {
        Throwable nullPointerException = (Throwable) obj;
        String str = "The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | " + nullPointerException;
        if (nullPointerException == null) {
            nullPointerException = new NullPointerException();
        }
        AbstractC1466d.m3505y(new C2903c(str, nullPointerException));
    }

    @Override
    public boolean mo126b() {
        return true;
    }

    @Override
    public long mo5893c() {
        return SystemClock.elapsedRealtime();
    }

    @Override
    public void mo5412e(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        switch (this.f13940a) {
            case 9:
                mediaMetadataRetriever.setDataSource(new C2384d0((ByteBuffer) obj));
                break;
            default:
                mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
                break;
        }
    }

    @Override
    public void mo5413f(MediaExtractor mediaExtractor, Object obj) throws IOException {
        switch (this.f13940a) {
            case 9:
                mediaExtractor.setDataSource(new C2384d0((ByteBuffer) obj));
                break;
            default:
                mediaExtractor.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
                break;
        }
    }

    @Override
    public Object get() {
        C3905e c3905e = new C3905e(19);
        HashMap map = new HashMap();
        EnumC4107c enumC4107c = EnumC4107c.f13925a;
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(enumC4107c, new C2653c(SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS, 86400000L, setEmptySet));
        EnumC4107c enumC4107c2 = EnumC4107c.f13927c;
        Set setEmptySet2 = Collections.emptySet();
        if (setEmptySet2 == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(enumC4107c2, new C2653c(1000L, 86400000L, setEmptySet2));
        EnumC4107c enumC4107c3 = EnumC4107c.f13926b;
        if (Collections.emptySet() == null) {
            throw new NullPointerException("Null flags");
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(EnumC2655e.f9262a, EnumC2655e.f9263b)));
        if (setUnmodifiableSet == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(enumC4107c3, new C2653c(86400000L, 86400000L, setUnmodifiableSet));
        if (map.keySet().size() < EnumC4107c.values().length) {
            throw new IllegalStateException("Not all priorities have been configured");
        }
        new HashMap();
        return new C2652b(c3905e, map);
    }

    @Override
    public void mo5862h(InterfaceC2877i interfaceC2877i) {
        interfaceC2877i.mo3565i();
    }

    @Override
    public boolean mo93i(Object obj, File file, C3981h c3981h) throws Throwable {
        try {
            AbstractC3597a.m7220d(((C2693i) ((C2688d) ((InterfaceC4102x) obj).get()).f9337a.f9336b).f9354a.f12824d.asReadOnlyBuffer(), file);
            return true;
        } catch (IOException e5) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e5);
            }
            return false;
        }
    }

    @Override
    public int mo235l(C3981h c3981h) {
        return 1;
    }

    public Signature[] mo3105m(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    @Override
    public Object mo135n() {
        switch (this.f13940a) {
            case 22:
                return new TreeMap();
            case 23:
                return new C3214l();
            case 24:
                return new LinkedHashSet();
            default:
                return new ArrayList();
        }
    }

    @Override
    public C3153r1 mo443o(View view, C3153r1 c3153r1, C1819e0 c1819e0) {
        c1819e0.f6439d = c3153r1.m6325a() + c1819e0.f6439d;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        boolean z7 = view.getLayoutDirection() == 1;
        int iM6326b = c3153r1.m6326b();
        int iM6327c = c3153r1.m6327c();
        int i6 = c1819e0.f6436a + (z7 ? iM6327c : iM6326b);
        c1819e0.f6436a = i6;
        int i10 = c1819e0.f6438c;
        if (!z7) {
            iM6326b = iM6327c;
        }
        int i11 = i10 + iM6326b;
        c1819e0.f6438c = i11;
        view.setPaddingRelative(i6, c1819e0.f6437b, i11, c1819e0.f6439d);
        return c3153r1;
    }

    @Override
    public void mo99p(Object obj, Object obj2) {
        C4009w c4009w = (C4009w) obj;
        C3988b c3988b = C3370o.f11372F;
        Context context = c4009w.f5071c;
        ComplianceOptions complianceOptions = new ComplianceOptions(-1, -1, 0, true);
        C3990d c3990d = (C3990d) c4009w.m3663p();
        ApiMetadata apiMetadata = new ApiMetadata(complianceOptions);
        Parcel parcelM3687l = c3990d.m3687l();
        AbstractC1542e0.m3809c(parcelM3687l, apiMetadata);
        c3990d.m3690y(parcelM3687l, 19);
        ((C4056d) obj2).m8059b(Boolean.TRUE);
    }

    public String toString() {
        switch (this.f13940a) {
            case 26:
                return "EmptyAction";
            default:
                return super.toString();
        }
    }

    public C3196b m8137u(Context context, C3905e c3905e) {
        C3196b c3196b = new C3196b();
        c3905e.getClass();
        int iM6421b = C3197c.m6421b(context, "com.google.android.gms.cast.framework.dynamite", true);
        c3196b.f10753b = iM6421b;
        if (iM6421b != 0) {
            c3196b.f10754c = 1;
        } else {
            int i6 = 0;
            try {
                Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors.com.google.android.gms.cast.framework.dynamite.ModuleDescriptor");
                Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
                Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
                if (AbstractC1312l.m3201h(declaredField.get(null), "com.google.android.gms.cast.framework.dynamite")) {
                    i6 = declaredField2.getInt(null);
                } else {
                    Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id 'com.google.android.gms.cast.framework.dynamite'");
                }
            } catch (ClassNotFoundException unused) {
                Log.w("DynamiteModule", "Local module descriptor class for com.google.android.gms.cast.framework.dynamite not found.");
            } catch (Exception e5) {
                Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e5.getMessage())));
            }
            c3196b.f10752a = i6;
            if (i6 != 0) {
                c3196b.f10754c = -1;
            }
        }
        return c3196b;
    }

    public C4112e(C0069f c0069f, AbstractC0410j0 abstractC0410j0) {
        this.f13940a = 17;
    }

    @Override
    public void mo234k() {
    }

    @Override
    public void onDismiss() {
    }

    public void m8134r() {
    }

    public void m8135s() {
    }

    @Override
    public void shutdown() {
    }

    public void m8136t() {
    }

    @Override
    public void mo5860a(FragmentActivity fragmentActivity) {
    }

    @Override
    public void mo5861g(InterfaceC2877i interfaceC2877i) {
    }

    @Override
    public void mo230d(Bitmap bitmap, InterfaceC4238a interfaceC4238a) {
    }
}
