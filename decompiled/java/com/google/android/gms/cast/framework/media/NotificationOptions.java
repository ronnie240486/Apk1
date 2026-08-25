package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.cast.AbstractC1714w1;
import com.google.android.gms.internal.cast.C1504a2;
import com.google.android.gms.internal.cast.C1696u1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p000a.AbstractC0004e;
import p156o9.AbstractC3280d;
import p165p4.C3371p;
import p187r4.C3632v;

public class NotificationOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<NotificationOptions> CREATOR;

    public static final C1504a2 f4845I;

    public static final int[] f4846J;

    public final int f4847A;

    public final int f4848B;

    public final int f4849C;

    public final int f4850D;

    public final int f4851E;

    public final C3632v f4852F;

    public final boolean f4853G;

    public final boolean f4854H;

    public final ArrayList f4855a;

    public final int[] f4856b;

    public final long f4857c;

    public final String f4858d;

    public final int f4859e;

    public final int f4860f;

    public final int f4861g;

    public final int f4862h;

    public final int f4863i;

    public final int f4864j;

    public final int f4865k;

    public final int f4866l;

    public final int f4867m;

    public final int f4868n;

    public final int f4869o;

    public final int f4870p;

    public final int f4871q;

    public final int f4872r;

    public final int f4873s;

    public final int f4874t;

    public final int f4875u;

    public final int f4876v;

    public final int f4877w;

    public final int f4878x;

    public final int f4879y;

    public final int f4880z;

    static {
        C1696u1 c1696u1 = AbstractC1714w1.f5716b;
        Object[] objArr = {MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK, MediaIntentReceiver.ACTION_STOP_CASTING};
        for (int i6 = 0; i6 < 2; i6++) {
            if (objArr[i6] == null) {
                throw new NullPointerException(AbstractC0004e.m20n(i6, "at index "));
            }
        }
        f4845I = AbstractC1714w1.m4052h(objArr, 2);
        f4846J = new int[]{0, 1};
        CREATOR = new C3371p(10);
    }

    public NotificationOptions(List list, int[] iArr, long j10, String str, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, IBinder iBinder, boolean z7, boolean z10) {
        C3632v c3632v;
        this.f4855a = new ArrayList(list);
        this.f4856b = Arrays.copyOf(iArr, iArr.length);
        this.f4857c = j10;
        this.f4858d = str;
        this.f4859e = i6;
        this.f4860f = i10;
        this.f4861g = i11;
        this.f4862h = i12;
        this.f4863i = i13;
        this.f4864j = i14;
        this.f4865k = i15;
        this.f4866l = i16;
        this.f4867m = i17;
        this.f4868n = i18;
        this.f4869o = i19;
        this.f4870p = i20;
        this.f4871q = i21;
        this.f4872r = i22;
        this.f4873s = i23;
        this.f4874t = i24;
        this.f4875u = i25;
        this.f4876v = i26;
        this.f4877w = i27;
        this.f4878x = i28;
        this.f4879y = i29;
        this.f4880z = i30;
        this.f4847A = i31;
        this.f4848B = i32;
        this.f4849C = i33;
        this.f4850D = i34;
        this.f4851E = i35;
        this.f4853G = z7;
        this.f4854H = z10;
        if (iBinder == null) {
            c3632v = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.INotificationActionsProvider");
            c3632v = iInterfaceQueryLocalInterface instanceof C3632v ? (C3632v) iInterfaceQueryLocalInterface : new C3632v(iBinder, "com.google.android.gms.cast.framework.media.INotificationActionsProvider", 0);
        }
        this.f4852F = c3632v;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6580S(parcel, 2, this.f4855a);
        int[] iArr = this.f4856b;
        AbstractC3280d.m6576O(parcel, 3, Arrays.copyOf(iArr, iArr.length));
        AbstractC3280d.m6585X(parcel, 4, 8);
        parcel.writeLong(this.f4857c);
        AbstractC3280d.m6579R(parcel, 5, this.f4858d);
        AbstractC3280d.m6585X(parcel, 6, 4);
        parcel.writeInt(this.f4859e);
        AbstractC3280d.m6585X(parcel, 7, 4);
        parcel.writeInt(this.f4860f);
        AbstractC3280d.m6585X(parcel, 8, 4);
        parcel.writeInt(this.f4861g);
        AbstractC3280d.m6585X(parcel, 9, 4);
        parcel.writeInt(this.f4862h);
        AbstractC3280d.m6585X(parcel, 10, 4);
        parcel.writeInt(this.f4863i);
        AbstractC3280d.m6585X(parcel, 11, 4);
        parcel.writeInt(this.f4864j);
        AbstractC3280d.m6585X(parcel, 12, 4);
        parcel.writeInt(this.f4865k);
        AbstractC3280d.m6585X(parcel, 13, 4);
        parcel.writeInt(this.f4866l);
        AbstractC3280d.m6585X(parcel, 14, 4);
        parcel.writeInt(this.f4867m);
        AbstractC3280d.m6585X(parcel, 15, 4);
        parcel.writeInt(this.f4868n);
        AbstractC3280d.m6585X(parcel, 16, 4);
        parcel.writeInt(this.f4869o);
        AbstractC3280d.m6585X(parcel, 17, 4);
        parcel.writeInt(this.f4870p);
        AbstractC3280d.m6585X(parcel, 18, 4);
        parcel.writeInt(this.f4871q);
        AbstractC3280d.m6585X(parcel, 19, 4);
        parcel.writeInt(this.f4872r);
        AbstractC3280d.m6585X(parcel, 20, 4);
        parcel.writeInt(this.f4873s);
        AbstractC3280d.m6585X(parcel, 21, 4);
        parcel.writeInt(this.f4874t);
        AbstractC3280d.m6585X(parcel, 22, 4);
        parcel.writeInt(this.f4875u);
        AbstractC3280d.m6585X(parcel, 23, 4);
        parcel.writeInt(this.f4876v);
        AbstractC3280d.m6585X(parcel, 24, 4);
        parcel.writeInt(this.f4877w);
        AbstractC3280d.m6585X(parcel, 25, 4);
        parcel.writeInt(this.f4878x);
        AbstractC3280d.m6585X(parcel, 26, 4);
        parcel.writeInt(this.f4879y);
        AbstractC3280d.m6585X(parcel, 27, 4);
        parcel.writeInt(this.f4880z);
        AbstractC3280d.m6585X(parcel, 28, 4);
        parcel.writeInt(this.f4847A);
        AbstractC3280d.m6585X(parcel, 29, 4);
        parcel.writeInt(this.f4848B);
        AbstractC3280d.m6585X(parcel, 30, 4);
        parcel.writeInt(this.f4849C);
        AbstractC3280d.m6585X(parcel, 31, 4);
        parcel.writeInt(this.f4850D);
        AbstractC3280d.m6585X(parcel, 32, 4);
        parcel.writeInt(this.f4851E);
        C3632v c3632v = this.f4852F;
        AbstractC3280d.m6575N(parcel, 33, c3632v == null ? null : c3632v.f5195d);
        AbstractC3280d.m6585X(parcel, 34, 4);
        parcel.writeInt(this.f4853G ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 35, 4);
        parcel.writeInt(this.f4854H ? 1 : 0);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
