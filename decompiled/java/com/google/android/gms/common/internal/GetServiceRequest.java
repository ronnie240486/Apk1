package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p018b5.AbstractBinderC1301a;
import p018b5.C1324x;
import p018b5.InterfaceC1303c;
import p188r5.AbstractC3635a;
import p237w0.C4043d;

public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new C4043d(16);

    public static final Scope[] f5036o = new Scope[0];

    public static final Feature[] f5037p = new Feature[0];

    public final int f5038a;

    public final int f5039b;

    public final int f5040c;

    public String f5041d;

    public IBinder f5042e;

    public Scope[] f5043f;

    public Bundle f5044g;

    public Account f5045h;

    public Feature[] f5046i;

    public Feature[] f5047j;

    public final boolean f5048k;

    public final int f5049l;

    public boolean f5050m;

    public final String f5051n;

    public GetServiceRequest(int i6, int i10, int i11, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z7, int i12, boolean z10, String str2) {
        Account account2;
        Scope[] scopeArr2 = scopeArr == null ? f5036o : scopeArr;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        Feature[] featureArr3 = f5037p;
        Feature[] featureArr4 = featureArr == null ? featureArr3 : featureArr;
        featureArr3 = featureArr2 != null ? featureArr2 : featureArr3;
        this.f5038a = i6;
        this.f5039b = i10;
        this.f5040c = i11;
        if ("com.google.android.gms".equals(str)) {
            this.f5041d = "com.google.android.gms";
        } else {
            this.f5041d = str;
        }
        if (i6 < 2) {
            account2 = null;
            if (iBinder != null) {
                int i13 = AbstractBinderC1301a.f4080d;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                InterfaceC1303c c1324x = iInterfaceQueryLocalInterface instanceof InterfaceC1303c ? (InterfaceC1303c) iInterfaceQueryLocalInterface : new C1324x(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 2);
                if (c1324x != null) {
                    long jClearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        try {
                            C1324x c1324x2 = (C1324x) c1324x;
                            Parcel parcelM3686g = c1324x2.m3686g(c1324x2.m3687l(), 2);
                            Account account3 = (Account) AbstractC3635a.m7360a(parcelM3686g, Account.CREATOR);
                            parcelM3686g.recycle();
                            Binder.restoreCallingIdentity(jClearCallingIdentity);
                            account2 = account3;
                        } catch (RemoteException unused) {
                            Log.w("AccountAccessor", "Remote account accessor probably died");
                            Binder.restoreCallingIdentity(jClearCallingIdentity);
                        }
                    } catch (Throwable th) {
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                        throw th;
                    }
                }
            }
        } else {
            this.f5042e = iBinder;
            account2 = account;
        }
        this.f5045h = account2;
        this.f5043f = scopeArr2;
        this.f5044g = bundle2;
        this.f5046i = featureArr4;
        this.f5047j = featureArr3;
        this.f5048k = z7;
        this.f5049l = i12;
        this.f5050m = z10;
        this.f5051n = str2;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        C4043d.m8045a(this, parcel, i6);
    }
}
