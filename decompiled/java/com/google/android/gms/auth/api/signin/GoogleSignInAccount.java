package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p018b5.AbstractC1312l;
import p078h5.C2661a;
import p156o9.AbstractC3280d;

@Deprecated
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new C2661a(7);

    public final int f4538a;

    public final String f4539b;

    public final String f4540c;

    public final String f4541d;

    public final String f4542e;

    public final Uri f4543f;

    public String f4544g;

    public final long f4545h;

    public final String f4546i;

    public final ArrayList f4547j;

    public final String f4548k;

    public final String f4549l;

    public final HashSet f4550m = new HashSet();

    public GoogleSignInAccount(int i6, String str, String str2, String str3, String str4, Uri uri, String str5, long j10, String str6, ArrayList arrayList, String str7, String str8) {
        this.f4538a = i6;
        this.f4539b = str;
        this.f4540c = str2;
        this.f4541d = str3;
        this.f4542e = str4;
        this.f4543f = uri;
        this.f4544g = str5;
        this.f4545h = j10;
        this.f4546i = str6;
        this.f4547j = arrayList;
        this.f4548k = str7;
        this.f4549l = str8;
    }

    public static GoogleSignInAccount m3581j(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j10 = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i6 = 0; i6 < length; i6++) {
            hashSet.add(new Scope(1, jSONArray.getString(i6)));
        }
        String strOptString2 = jSONObject.optString(TtmlNode.ATTR_ID);
        String strOptString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String strOptString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String strOptString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String strOptString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String strOptString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        String string = jSONObject.getString("obfuscatedIdentifier");
        AbstractC1312l.m3196c(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, strOptString2, strOptString3, strOptString4, strOptString5, uri, null, j10, string, new ArrayList(hashSet), strOptString6, strOptString7);
        googleSignInAccount.f4544g = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (googleSignInAccount.f4546i.equals(this.f4546i)) {
            HashSet hashSet = new HashSet(googleSignInAccount.f4547j);
            hashSet.addAll(googleSignInAccount.f4550m);
            HashSet hashSet2 = new HashSet(this.f4547j);
            hashSet2.addAll(this.f4550m);
            if (hashSet.equals(hashSet2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f4546i.hashCode() + 527;
        HashSet hashSet = new HashSet(this.f4547j);
        hashSet.addAll(this.f4550m);
        return (iHashCode * 31) + hashSet.hashCode();
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f4538a);
        AbstractC3280d.m6579R(parcel, 2, this.f4539b);
        AbstractC3280d.m6579R(parcel, 3, this.f4540c);
        AbstractC3280d.m6579R(parcel, 4, this.f4541d);
        AbstractC3280d.m6579R(parcel, 5, this.f4542e);
        AbstractC3280d.m6578Q(parcel, 6, this.f4543f, i6);
        AbstractC3280d.m6579R(parcel, 7, this.f4544g);
        AbstractC3280d.m6585X(parcel, 8, 8);
        parcel.writeLong(this.f4545h);
        AbstractC3280d.m6579R(parcel, 9, this.f4546i);
        AbstractC3280d.m6582U(parcel, 10, this.f4547j);
        AbstractC3280d.m6579R(parcel, 11, this.f4548k);
        AbstractC3280d.m6579R(parcel, 12, this.f4549l);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
