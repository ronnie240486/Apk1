package p221u6;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.LocaleList;
import android.os.Parcel;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.AbstractC0554v0;
import androidx.lifecycle.InterfaceC0560y0;
import com.alibaba.fastjson.parser.deserializer.AbstractC1451d;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import com.tencent.mars.xlog.Log;
import io.binstream.libtvcar.Libtvcar;
import io.binstream.libtvcar.Listener;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.Executors;
import na.InterfaceC3223b;
import org.bitspark.android.utils.AbstractC3331m;
import org.json.JSONException;
import org.json.JSONObject;
import p003a2.AbstractC0032a;
import p005a4.ExecutorC0059r;
import p038d4.InterfaceC2152b;
import p049e3.InterfaceC2386e0;
import p055ea.AbstractC2460q;
import p055ea.C2463r0;
import p055ea.C2465s0;
import p055ea.C2467t0;
import p055ea.C2469u0;
import p055ea.C2471v0;
import p055ea.C2473w0;
import p095j1.C2768b;
import p103j9.AbstractC2796i;
import p107k1.C2862b;
import p109k3.InterfaceC2881m;
import p110k4.InterfaceC2890a;
import p124l6.C2982h;
import p126l8.InterfaceC3013a;
import p144n7.InterfaceC3215m;
import p147o.AbstractC3225b;
import p147o.C3224a;
import p165p4.C3370o;
import p230v4.C3988b;
import p230v4.C3990d;
import p230v4.C4009w;
import p242w5.C4056d;
import p243w8.C4068j;
import p253x8.AbstractC4158u;
import p271z4.InterfaceC4340k;
import sa.InterfaceC3730a;
import ua.C3944e;

public class C3905e implements InterfaceC2152b, InterfaceC2386e0, InterfaceC3730a, Listener, InterfaceC0560y0, InterfaceC2881m, InterfaceC2890a, InterfaceC3223b, InterfaceC3215m, InterfaceC3013a, InterfaceC4340k {

    public static C3905e f13104b;

    public final int f13105a;

    public C3905e(int i6) {
        this.f13105a = i6;
    }

    public static void m7795j(Context context, Locale locale) {
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        AbstractC2796i.m5781b(resources, "res");
        Configuration configuration = resources.getConfiguration();
        AbstractC2796i.m5781b(configuration, "res.configuration");
        if (AbstractC1466d.m3498q(configuration).equals(locale)) {
            return;
        }
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (Build.VERSION.SDK_INT >= 24) {
            Locale[] localeArr = {locale};
            LinkedHashSet linkedHashSet = new LinkedHashSet(AbstractC4158u.m8196p(1));
            linkedHashSet.add(localeArr[0]);
            LocaleList localeList = LocaleList.getDefault();
            AbstractC2796i.m5781b(localeList, "LocaleList.getDefault()");
            int size = localeList.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i6 = 0; i6 < size; i6++) {
                Locale locale2 = localeList.get(i6);
                AbstractC2796i.m5781b(locale2, "defaultLocales[it]");
                arrayList.add(locale2);
            }
            linkedHashSet.addAll(arrayList);
            Object[] array = linkedHashSet.toArray(new Locale[0]);
            if (array == null) {
                throw new C4068j("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Locale[] localeArr2 = (Locale[]) array;
            configuration2.setLocales(AbstractC1451d.m3442i((Locale[]) Arrays.copyOf(localeArr2, localeArr2.length)));
        } else {
            configuration2.setLocale(locale);
        }
        resources.updateConfiguration(configuration2, resources.getDisplayMetrics());
    }

    @Override
    public AbstractC0554v0 mo1197a(Class cls) {
        return new C2862b();
    }

    @Override
    public AbstractC0554v0 mo1198b(Class cls, C2768b c2768b) {
        return mo1197a(cls);
    }

    @Override
    public long mo5893c() {
        return System.currentTimeMillis();
    }

    public boolean mo7796d() {
        return this instanceof C3906f;
    }

    @Override
    public void mo5412e(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
        mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
    }

    @Override
    public void mo5413f(MediaExtractor mediaExtractor, Object obj) throws IOException {
        AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
        mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
    }

    public void mo4119g(float f, float f3, float f4, C3923w c3923w) {
        c3923w.m7835d(f, 0.0f);
    }

    @Override
    public Object get() {
        return new ExecutorC0059r(0, Executors.newSingleThreadExecutor());
    }

    public boolean mo3129h(CharSequence charSequence) {
        return false;
    }

    public void m7797i(C2982h c2982h, float f) {
        C3224a c3224a = (C3224a) ((Drawable) c2982h.f10225b);
        CardView cardView = (CardView) c2982h.f10226c;
        boolean useCompatPadding = cardView.getUseCompatPadding();
        boolean preventCornerOverlap = cardView.getPreventCornerOverlap();
        if (f != c3224a.f10829e || c3224a.f10830f != useCompatPadding || c3224a.f10831g != preventCornerOverlap) {
            c3224a.f10829e = f;
            c3224a.f10830f = useCompatPadding;
            c3224a.f10831g = preventCornerOverlap;
            c3224a.m6509b(null);
            c3224a.invalidateSelf();
        }
        if (!cardView.getUseCompatPadding()) {
            c2982h.m6039B(0, 0, 0, 0);
            return;
        }
        C3224a c3224a2 = (C3224a) ((Drawable) c2982h.f10225b);
        float f3 = c3224a2.f10829e;
        float f4 = c3224a2.f10825a;
        int iCeil = (int) Math.ceil(AbstractC3225b.m6510a(f3, f4, cardView.getPreventCornerOverlap()));
        int iCeil2 = (int) Math.ceil(AbstractC3225b.m6511b(f3, f4, cardView.getPreventCornerOverlap()));
        c2982h.m6039B(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override
    public Object mo135n() {
        switch (this.f13105a) {
            case 22:
                return new ConcurrentHashMap();
            case 23:
                return new LinkedHashMap();
            case 24:
                return new TreeSet();
            case 25:
                return new ArrayDeque();
            default:
                return new ConcurrentSkipListMap();
        }
    }

    @Override
    public void onInfo(String str) {
        JSONObject jSONObject;
        String strM165s = AbstractC0032a.m165s("LzSVCA0Un4gNC7UM\n", "e2LWaX9H+vo=\n");
        String strM5496j = AbstractC2460q.m5496j("KzogTNx4Fw==\n", "RFRpIroXLQM=\n", new StringBuilder(), str);
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM5496j);
        C3944e c3944eM7867b = C3944e.m7867b();
        C2463r0 c2463r0 = new C2463r0();
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e5) {
            String strM165s2 = AbstractC0032a.m165s("amoU9uxwRTJIVTTy\n", "PjxXl54jIEA=\n");
            String str2 = AbstractC0032a.m165s("gP7e1dNhSeyn5OPWzlpF/LHM6tWb\n", "wq2NsKEXII8=\n") + e5;
            boolean z10 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s2, str2);
            jSONObject = null;
        }
        if (jSONObject != null) {
            c2463r0.f8654a = jSONObject.optInt(AbstractC0032a.m165s("gijW9xs4Hfe5NcDtEg==\n", "5kehmXdXfJM=\n"));
            jSONObject.optInt(AbstractC0032a.m165s("IHwV4BRhfiI0eBw=\n", "VQx5j3UFIVA=\n"));
            jSONObject.optInt(AbstractC0032a.m165s("m0GyEQUAyiGgWqoLCAM=\n", "/y7Ff2lvq0U=\n"));
            jSONObject.optInt(AbstractC0032a.m165s("+AWffQEav/fiAZJ+\n", "jXXzEmB+4IM=\n"));
        }
        c3944eM7867b.m7870e(c2463r0);
    }

    @Override
    public void onInited(String str) {
        JSONObject jSONObject;
        String strM165s = AbstractC0032a.m165s("+v7fSosMDCnYwf9O\n", "rqicK/lfaVs=\n");
        String strM5496j = AbstractC2460q.m5496j("bMTIkhJETnA5\n", "A6qB/HswKxQ=\n", new StringBuilder(), str);
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM5496j);
        C3944e c3944eM7867b = C3944e.m7867b();
        C2465s0 c2465s0 = new C2465s0();
        c2465s0.f8658a = -1000;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e5) {
            String strM165s2 = AbstractC0032a.m165s("oOHBayejvTuC3uFv\n", "9LeCClXw2Ek=\n");
            String str2 = AbstractC0032a.m165s("2zYgpG3c5Sv8LB2oa8/oBfwWAKB4z7Y=\n", "mWVzwR+qjEg=\n") + e5;
            boolean z10 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s2, str2);
            jSONObject = null;
        }
        if (jSONObject != null) {
            c2465s0.f8658a = jSONObject.optInt(AbstractC0032a.m165s("JGXg/4s=\n", "QReSkeQ3SeM=\n"), -1000);
        }
        c3944eM7867b.m7870e(c2465s0);
        Log.m5049i(AbstractC0032a.m165s("iz8Xw2FFarqpADfH\n", "32lUohMWD8g=\n"), AbstractC0032a.m165s("2mRbUFwPNOnBcV1CXRVkpZAsBg8QEXqlkCwGDxARTg==\n", "rhI4MS4vRJs=\n") + Libtvcar.getVersion(2026L) + AbstractC0032a.m165s("/5kL79l9ijXJmQvv2X2KNcmZC9k=\n", "9aU30+VBtgk=\n"));
    }

    @Override
    public void onPrepared(String str) {
        JSONObject jSONObject;
        String strM165s = AbstractC0032a.m165s("4ggK+oqPAl3ANyr+\n", "tl5Jm/jcZy8=\n");
        String strM5496j = AbstractC2460q.m5496j("zF+RJvvr2nnGVfs=\n", "ozHBVJ6buws=\n", new StringBuilder(), str);
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM5496j);
        C3944e c3944eM7867b = C3944e.m7867b();
        C2473w0 c2473w0 = new C2473w0();
        c2473w0.f8671a = -1300;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e5) {
            String strM165s2 = AbstractC0032a.m165s("wLerV8r+gqTiiItT\n", "lOHoNrit59Y=\n");
            String str2 = AbstractC0032a.m165s("lLF+JxmGuGqwhk8jD5uvfLOGWiNR\n", "wOc9RmvWyg8=\n") + e5;
            boolean z10 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s2, str2);
            jSONObject = null;
        }
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt(AbstractC0032a.m165s("r0Ac9cE=\n", "yjJum66mFTY=\n"), -1300);
            c2473w0.f8671a = iOptInt;
            if (iOptInt == 0) {
                c2473w0.f8672b = jSONObject.optString(AbstractC0032a.m165s("mYhU\n", "7Po4D2ekSEU=\n"), AbstractC0032a.m165s("YmF2tQ==\n", "DBQa2Xfg9ts=\n"));
            }
        }
        c3944eM7867b.m7870e(c2473w0);
    }

    @Override
    public void onQuit(String str) {
        JSONObject jSONObject;
        String strM165s = AbstractC0032a.m165s("NYDg2aJ9UIAXv8Dd\n", "YdajuNAuNfI=\n");
        String strM5496j = AbstractC2460q.m5496j("QuyBZbsOgg==\n", "LYLQENJ6uCM=\n", new StringBuilder(), str);
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM5496j);
        C3944e c3944eM7867b = C3944e.m7867b();
        C2467t0 c2467t0 = new C2467t0();
        c2467t0.f8661a = -1500;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e5) {
            String strM165s2 = AbstractC0032a.m165s("KBd3Ms382mwKKFc2\n", "fEE0U7+vvx4=\n");
            String str2 = AbstractC0032a.m165s("HGWgyaXis/s7Z4bFo9m/6y1XlMnt\n", "XjbzrNeU2pg=\n") + e5;
            boolean z10 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s2, str2);
            jSONObject = null;
        }
        if (jSONObject != null) {
            c2467t0.f8661a = jSONObject.optInt(AbstractC0032a.m165s("q57qBuc=\n", "zuyYaIhcqpI=\n"), -1500);
        }
        c3944eM7867b.m7870e(c2467t0);
    }

    @Override
    public void onStart(String str) {
        JSONObject jSONObject;
        String strM165s = AbstractC0032a.m165s("MbKiFXg3KqITjYIR\n", "ZeThdApkT9A=\n");
        String strM5496j = AbstractC2460q.m5496j("+Q3eafw1iyU=\n", "lmONHZ1H/x8=\n", new StringBuilder(), str);
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM5496j);
        C3944e c3944eM7867b = C3944e.m7867b();
        C2469u0 c2469u0 = new C2469u0();
        c2469u0.f8663a = -1100;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e5) {
            String strM165s2 = AbstractC0032a.m165s("Ntpelu4DPyMU5X6S\n", "Yowd95xQWlE=\n");
            String str2 = AbstractC0032a.m165s("MYe0338nOXIWh5PbfyUddACnht1oaw==\n", "c9Tnug1RUBE=\n") + e5;
            boolean z10 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s2, str2);
            jSONObject = null;
        }
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt(AbstractC0032a.m165s("Y4CwUTQ=\n", "BvLCP1uRmY0=\n"), -1100);
            c2469u0.f8663a = iOptInt;
            if (iOptInt == 0) {
                c2469u0.f8664b = jSONObject.optString(AbstractC0032a.m165s("WGIl\n", "LRBJ6PKYaoU=\n"), AbstractC0032a.m165s("cG6OMQ==\n", "HhviXZRNf5M=\n"));
            }
        }
        c3944eM7867b.m7870e(c2469u0);
    }

    @Override
    public void onStop(String str) {
        JSONObject jSONObject;
        String strM165s = AbstractC0032a.m165s("CVLMzZiIqaQrbezJ\n", "XQSPrOrbzNY=\n");
        String strM5496j = AbstractC2460q.m5496j("DPLW7WKR5Q==\n", "Y5yFmQ3h344=\n", new StringBuilder(), str);
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM5496j);
        C3944e c3944eM7867b = C3944e.m7867b();
        C2471v0 c2471v0 = new C2471v0();
        c2471v0.f8667a = -1200;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e5) {
            String strM165s2 = AbstractC0032a.m165s("elIRC+7FY/5YbTEP\n", "LgRSapyWBow=\n");
            String str2 = AbstractC0032a.m165s("4fHribSEjmLG8cyDtr+CctDD34n8\n", "o6K47Mby5wE=\n") + e5;
            boolean z10 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s2, str2);
            jSONObject = null;
        }
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt(AbstractC0032a.m165s("gM+IkOM=\n", "5b36/ow7Rbo=\n"), -1200);
            c2471v0.f8667a = iOptInt;
            if (iOptInt == 0) {
                c2471v0.f8668b = jSONObject.optString(AbstractC0032a.m165s("Eu1z\n", "Z58fNCxHqoA=\n"), AbstractC0032a.m165s("YAUFSA==\n", "DnBpJE/rRYc=\n"));
            }
        }
        c3944eM7867b.m7870e(c2471v0);
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
        c3990d.m3690y(parcelM3687l, 1);
        ((C4056d) obj2).m8059b(null);
    }

    public String toString() {
        switch (this.f13105a) {
            case 27:
                return "EmptyConsumer";
            default:
                return super.toString();
        }
    }

    public C3905e(int[] iArr, ValueAnimator valueAnimator) {
        this.f13105a = 7;
    }

    @Override
    public void accept(Object obj) {
    }
}
