package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import p156o9.AbstractC3280d;
import p165p4.C3371p;
import p187r4.C3613c;

public class CastOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CastOptions> CREATOR;

    public static final zzj f4760s = new zzj(false);

    public static final zzl f4761t = new zzl(0);

    public static final CastMediaOptions f4762u;

    public final String f4763a;

    public final ArrayList f4764b;

    public final boolean f4765c;

    public final LaunchOptions f4766d;

    public final boolean f4767e;

    public final CastMediaOptions f4768f;

    public final boolean f4769g;

    public final double f4770h;

    public final boolean f4771i;

    public final boolean f4772j;

    public final boolean f4773k;

    public final ArrayList f4774l;

    public final boolean f4775m;

    public final boolean f4776n;

    public final zzj f4777o;

    public zzl f4778p;

    public final boolean f4779q;

    public final boolean f4780r;

    static {
        new C3613c().m7282a();
        f4762u = new CastMediaOptions("com.google.android.gms.cast.framework.media.MediaIntentReceiver", null, null, null, false, false);
        CREATOR = new C3371p(6);
    }

    public CastOptions(String str, ArrayList arrayList, boolean z7, LaunchOptions launchOptions, boolean z10, CastMediaOptions castMediaOptions, boolean z11, double d, boolean z12, boolean z13, boolean z14, ArrayList arrayList2, boolean z15, boolean z16, zzj zzjVar, zzl zzlVar, boolean z17, boolean z18) {
        this.f4763a = true == TextUtils.isEmpty(str) ? "" : str;
        int size = arrayList == null ? 0 : arrayList.size();
        ArrayList arrayList3 = new ArrayList(size);
        this.f4764b = arrayList3;
        if (size > 0) {
            arrayList3.addAll(arrayList);
        }
        this.f4765c = z7;
        this.f4766d = launchOptions == null ? new LaunchOptions() : launchOptions;
        this.f4767e = z10;
        this.f4768f = castMediaOptions;
        this.f4769g = z11;
        this.f4770h = d;
        this.f4771i = z12;
        this.f4772j = z13;
        this.f4773k = z14;
        this.f4774l = arrayList2;
        this.f4775m = z15;
        this.f4776n = z16;
        this.f4777o = zzjVar;
        this.f4778p = zzlVar;
        this.f4779q = z17;
        this.f4780r = z18;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6579R(parcel, 2, this.f4763a);
        AbstractC3280d.m6580S(parcel, 3, Collections.unmodifiableList(this.f4764b));
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(this.f4765c ? 1 : 0);
        AbstractC3280d.m6578Q(parcel, 5, this.f4766d, i6);
        AbstractC3280d.m6585X(parcel, 6, 4);
        parcel.writeInt(this.f4767e ? 1 : 0);
        AbstractC3280d.m6578Q(parcel, 7, this.f4768f, i6);
        AbstractC3280d.m6585X(parcel, 8, 4);
        parcel.writeInt(this.f4769g ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 9, 8);
        parcel.writeDouble(this.f4770h);
        AbstractC3280d.m6585X(parcel, 10, 4);
        parcel.writeInt(this.f4771i ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 11, 4);
        parcel.writeInt(this.f4772j ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 12, 4);
        parcel.writeInt(this.f4773k ? 1 : 0);
        AbstractC3280d.m6580S(parcel, 13, Collections.unmodifiableList(this.f4774l));
        AbstractC3280d.m6585X(parcel, 14, 4);
        parcel.writeInt(this.f4775m ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 15, 4);
        parcel.writeInt(0);
        AbstractC3280d.m6585X(parcel, 16, 4);
        parcel.writeInt(this.f4776n ? 1 : 0);
        AbstractC3280d.m6578Q(parcel, 17, this.f4777o, i6);
        AbstractC3280d.m6578Q(parcel, 18, this.f4778p, i6);
        AbstractC3280d.m6585X(parcel, 19, 4);
        parcel.writeInt(this.f4779q ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 20, 4);
        parcel.writeInt(this.f4780r ? 1 : 0);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
