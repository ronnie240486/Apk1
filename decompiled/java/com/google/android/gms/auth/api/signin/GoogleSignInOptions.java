package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import p078h5.C2661a;
import p156o9.AbstractC3280d;
import p261y4.InterfaceC4254b;

@Deprecated
public class GoogleSignInOptions extends AbstractSafeParcelable implements InterfaceC4254b, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    public final int f4551a;

    public final ArrayList f4552b;

    public final Account f4553c;

    public final boolean f4554d;

    public final boolean f4555e;

    public final boolean f4556f;

    public final String f4557g;

    public final String f4558h;

    public final ArrayList f4559i;

    public final String f4560j;

    static {
        Scope scope = new Scope(1, "profile");
        new Scope(1, "email");
        Scope scope2 = new Scope(1, "openid");
        Scope scope3 = new Scope(1, "https://www.googleapis.com/auth/games_lite");
        Scope scope4 = new Scope(1, "https://www.googleapis.com/auth/games");
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        hashSet.add(scope2);
        hashSet.add(scope);
        if (hashSet.contains(scope4) && hashSet.contains(scope3)) {
            hashSet.remove(scope3);
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, map, null);
        HashSet hashSet2 = new HashSet();
        HashMap map2 = new HashMap();
        hashSet2.add(scope3);
        hashSet2.addAll(Arrays.asList(new Scope[0]));
        if (hashSet2.contains(scope4) && hashSet2.contains(scope3)) {
            hashSet2.remove(scope3);
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet2), null, false, false, false, null, null, map2, null);
        CREATOR = new C2661a(8);
    }

    public GoogleSignInOptions(int i6, ArrayList arrayList, Account account, boolean z7, boolean z10, boolean z11, String str, String str2, HashMap map, String str3) {
        this.f4551a = i6;
        this.f4552b = arrayList;
        this.f4553c = account;
        this.f4554d = z7;
        this.f4555e = z10;
        this.f4556f = z11;
        this.f4557g = str;
        this.f4558h = str2;
        this.f4559i = new ArrayList(map.values());
        this.f4560j = str3;
    }

    public final boolean equals(Object obj) {
        String str = this.f4557g;
        ArrayList arrayList = this.f4552b;
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            ArrayList arrayList2 = googleSignInOptions.f4552b;
            String str2 = googleSignInOptions.f4557g;
            Account account = googleSignInOptions.f4553c;
            if (this.f4559i.isEmpty() && googleSignInOptions.f4559i.isEmpty() && arrayList.size() == new ArrayList(arrayList2).size() && arrayList.containsAll(new ArrayList(arrayList2))) {
                Account account2 = this.f4553c;
                if (account2 == null) {
                    if (account == null) {
                        if (TextUtils.isEmpty(str)) {
                            if (TextUtils.isEmpty(str2)) {
                                if (this.f4556f != googleSignInOptions.f4556f && this.f4554d == googleSignInOptions.f4554d && this.f4555e == googleSignInOptions.f4555e && TextUtils.equals(this.f4560j, googleSignInOptions.f4560j)) {
                                    return true;
                                }
                            }
                        } else if (!str.equals(str2)) {
                            if (this.f4556f != googleSignInOptions.f4556f) {
                            }
                        }
                    }
                } else if (account2.equals(account)) {
                    if (TextUtils.isEmpty(str)) {
                        if (TextUtils.isEmpty(str2)) {
                            if (this.f4556f != googleSignInOptions.f4556f) {
                            }
                        }
                    } else if (!str.equals(str2)) {
                        if (this.f4556f != googleSignInOptions.f4556f) {
                        }
                    }
                }
            }
        } catch (ClassCastException unused) {
        }
        return false;
    }

    public final int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f4552b;
        int size = arrayList2.size();
        for (int i6 = 0; i6 < size; i6++) {
            arrayList.add(((Scope) arrayList2.get(i6)).f4990b);
        }
        Collections.sort(arrayList);
        int iHashCode = arrayList.hashCode() + (1 * 31);
        Account account = this.f4553c;
        int iHashCode2 = (iHashCode * 31) + (account == null ? 0 : account.hashCode());
        String str = this.f4557g;
        int iHashCode3 = (((((((iHashCode2 * 31) + (str == null ? 0 : str.hashCode())) * 31) + (this.f4556f ? 1 : 0)) * 31) + (this.f4554d ? 1 : 0)) * 31) + (this.f4555e ? 1 : 0);
        String str2 = this.f4560j;
        return (iHashCode3 * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f4551a);
        AbstractC3280d.m6582U(parcel, 2, new ArrayList(this.f4552b));
        AbstractC3280d.m6578Q(parcel, 3, this.f4553c, i6);
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(this.f4554d ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 5, 4);
        parcel.writeInt(this.f4555e ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 6, 4);
        parcel.writeInt(this.f4556f ? 1 : 0);
        AbstractC3280d.m6579R(parcel, 7, this.f4557g);
        AbstractC3280d.m6579R(parcel, 8, this.f4558h);
        AbstractC3280d.m6582U(parcel, 9, this.f4559i);
        AbstractC3280d.m6579R(parcel, 10, this.f4560j);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
