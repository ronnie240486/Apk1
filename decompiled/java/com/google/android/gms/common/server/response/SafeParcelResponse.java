package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.SparseArray;
import androidx.fragment.app.C0423q;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import p000a.AbstractC0004e;
import p018b5.AbstractC1312l;
import p078h5.C2661a;
import p111k5.AbstractC2891a;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;
import p187r4.AbstractC3612b;

public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new C2661a(5);

    public final int f5147a;

    public final Parcel f5148b;

    public final int f5149c;

    public final zan f5150d;

    public final String f5151e;

    public int f5152f;

    public int f5153g;

    public SafeParcelResponse(int i6, Parcel parcel, zan zanVar) {
        this.f5147a = i6;
        AbstractC1312l.m3198e(parcel);
        this.f5148b = parcel;
        this.f5149c = 2;
        this.f5150d = zanVar;
        this.f5151e = zanVar == null ? null : zanVar.f5162c;
        this.f5152f = 2;
    }

    public static void m3679r(StringBuilder sb, Map map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse$Field) entry.getValue()).f5142g, entry);
        }
        sb.append('{');
        int iM6447V = AbstractC3198d.m6447V(parcel);
        boolean z7 = false;
        while (parcel.dataPosition() < iM6447V) {
            int i6 = parcel.readInt();
            Map.Entry entry2 = (Map.Entry) sparseArray.get((char) i6);
            if (entry2 != null) {
                if (z7) {
                    sb.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse$Field fastJsonResponse$Field = (FastJsonResponse$Field) entry2.getValue();
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                StringToIntConverter stringToIntConverter = fastJsonResponse$Field.f5146k;
                BigInteger bigInteger = null;
                BigInteger bigInteger2 = null;
                Parcel[] parcelArr = null;
                boolean[] zArrCreateBooleanArray = null;
                BigDecimal[] bigDecimalArr = null;
                double[] dArrCreateDoubleArray = null;
                float[] fArrCreateFloatArray = null;
                BigInteger[] bigIntegerArr = null;
                Parcel parcelObtain = null;
                int i10 = fastJsonResponse$Field.f5139d;
                if (stringToIntConverter != null) {
                    switch (i10) {
                        case 0:
                            m3681t(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.m3672o(fastJsonResponse$Field, Integer.valueOf(AbstractC3198d.m6436K(parcel, i6))));
                            break;
                        case 1:
                            int iM6439N = AbstractC3198d.m6439N(parcel, i6);
                            int iDataPosition = parcel.dataPosition();
                            if (iM6439N != 0) {
                                byte[] bArrCreateByteArray = parcel.createByteArray();
                                parcel.setDataPosition(iDataPosition + iM6439N);
                                bigInteger2 = new BigInteger(bArrCreateByteArray);
                            }
                            m3681t(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.m3672o(fastJsonResponse$Field, bigInteger2));
                            break;
                        case 2:
                            m3681t(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.m3672o(fastJsonResponse$Field, Long.valueOf(AbstractC3198d.m6438M(parcel, i6))));
                            break;
                        case 3:
                            m3681t(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.m3672o(fastJsonResponse$Field, Float.valueOf(AbstractC3198d.m6434I(parcel, i6))));
                            break;
                        case 4:
                            m3681t(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.m3672o(fastJsonResponse$Field, Double.valueOf(AbstractC3198d.m6433H(parcel, i6))));
                            break;
                        case 5:
                            m3681t(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.m3672o(fastJsonResponse$Field, AbstractC3198d.m6457e(parcel, i6)));
                            break;
                        case 6:
                            m3681t(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.m3672o(fastJsonResponse$Field, Boolean.valueOf(AbstractC3198d.m6431F(parcel, i6))));
                            break;
                        case 7:
                            m3681t(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.m3672o(fastJsonResponse$Field, AbstractC3198d.m6463k(parcel, i6)));
                            break;
                        case 8:
                        case 9:
                            m3681t(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.m3672o(fastJsonResponse$Field, AbstractC3198d.m6459g(parcel, i6)));
                            break;
                        case 10:
                            Bundle bundleM6458f = AbstractC3198d.m6458f(parcel, i6);
                            HashMap map2 = new HashMap();
                            for (String str2 : bundleM6458f.keySet()) {
                                String string = bundleM6458f.getString(str2);
                                AbstractC1312l.m3198e(string);
                                map2.put(str2, string);
                            }
                            m3681t(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.m3672o(fastJsonResponse$Field, map2));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException(AbstractC0004e.m20n(i10, "Unknown field out type = "));
                    }
                } else {
                    boolean z10 = fastJsonResponse$Field.f5140e;
                    String str3 = fastJsonResponse$Field.f5144i;
                    if (z10) {
                        sb.append("[");
                        switch (i10) {
                            case 0:
                                int[] iArrM6460h = AbstractC3198d.m6460h(parcel, i6);
                                int length = iArrM6460h.length;
                                for (int i11 = 0; i11 < length; i11++) {
                                    if (i11 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(iArrM6460h[i11]);
                                }
                                break;
                            case 1:
                                int iM6439N2 = AbstractC3198d.m6439N(parcel, i6);
                                int iDataPosition2 = parcel.dataPosition();
                                if (iM6439N2 != 0) {
                                    int i12 = parcel.readInt();
                                    bigIntegerArr = new BigInteger[i12];
                                    for (int i13 = 0; i13 < i12; i13++) {
                                        bigIntegerArr[i13] = new BigInteger(parcel.createByteArray());
                                    }
                                    parcel.setDataPosition(iDataPosition2 + iM6439N2);
                                }
                                int length2 = bigIntegerArr.length;
                                for (int i14 = 0; i14 < length2; i14++) {
                                    if (i14 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(bigIntegerArr[i14]);
                                }
                                break;
                            case 2:
                                long[] jArrM6461i = AbstractC3198d.m6461i(parcel, i6);
                                int length3 = jArrM6461i.length;
                                for (int i15 = 0; i15 < length3; i15++) {
                                    if (i15 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(jArrM6461i[i15]);
                                }
                                break;
                            case 3:
                                int iM6439N3 = AbstractC3198d.m6439N(parcel, i6);
                                int iDataPosition3 = parcel.dataPosition();
                                if (iM6439N3 != 0) {
                                    fArrCreateFloatArray = parcel.createFloatArray();
                                    parcel.setDataPosition(iDataPosition3 + iM6439N3);
                                }
                                int length4 = fArrCreateFloatArray.length;
                                for (int i16 = 0; i16 < length4; i16++) {
                                    if (i16 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(fArrCreateFloatArray[i16]);
                                }
                                break;
                            case 4:
                                int iM6439N4 = AbstractC3198d.m6439N(parcel, i6);
                                int iDataPosition4 = parcel.dataPosition();
                                if (iM6439N4 != 0) {
                                    dArrCreateDoubleArray = parcel.createDoubleArray();
                                    parcel.setDataPosition(iDataPosition4 + iM6439N4);
                                }
                                int length5 = dArrCreateDoubleArray.length;
                                for (int i17 = 0; i17 < length5; i17++) {
                                    if (i17 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(dArrCreateDoubleArray[i17]);
                                }
                                break;
                            case 5:
                                int iM6439N5 = AbstractC3198d.m6439N(parcel, i6);
                                int iDataPosition5 = parcel.dataPosition();
                                if (iM6439N5 != 0) {
                                    int i18 = parcel.readInt();
                                    bigDecimalArr = new BigDecimal[i18];
                                    for (int i19 = 0; i19 < i18; i19++) {
                                        bigDecimalArr[i19] = new BigDecimal(new BigInteger(parcel.createByteArray()), parcel.readInt());
                                    }
                                    parcel.setDataPosition(iDataPosition5 + iM6439N5);
                                }
                                int length6 = bigDecimalArr.length;
                                for (int i20 = 0; i20 < length6; i20++) {
                                    if (i20 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(bigDecimalArr[i20]);
                                }
                                break;
                            case 6:
                                int iM6439N6 = AbstractC3198d.m6439N(parcel, i6);
                                int iDataPosition6 = parcel.dataPosition();
                                if (iM6439N6 != 0) {
                                    zArrCreateBooleanArray = parcel.createBooleanArray();
                                    parcel.setDataPosition(iDataPosition6 + iM6439N6);
                                }
                                int length7 = zArrCreateBooleanArray.length;
                                for (int i21 = 0; i21 < length7; i21++) {
                                    if (i21 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(zArrCreateBooleanArray[i21]);
                                }
                                break;
                            case 7:
                                String[] strArrM6464l = AbstractC3198d.m6464l(parcel, i6);
                                int length8 = strArrM6464l.length;
                                for (int i22 = 0; i22 < length8; i22++) {
                                    if (i22 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append("\"");
                                    sb.append(strArrM6464l[i22]);
                                    sb.append("\"");
                                }
                                break;
                            case 8:
                            case 9:
                            case 10:
                                throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                            case 11:
                                int iM6439N7 = AbstractC3198d.m6439N(parcel, i6);
                                int iDataPosition7 = parcel.dataPosition();
                                if (iM6439N7 != 0) {
                                    int i23 = parcel.readInt();
                                    Parcel[] parcelArr2 = new Parcel[i23];
                                    for (int i24 = 0; i24 < i23; i24++) {
                                        int i25 = parcel.readInt();
                                        if (i25 != 0) {
                                            int iDataPosition8 = parcel.dataPosition();
                                            Parcel parcelObtain2 = Parcel.obtain();
                                            parcelObtain2.appendFrom(parcel, iDataPosition8, i25);
                                            parcelArr2[i24] = parcelObtain2;
                                            parcel.setDataPosition(iDataPosition8 + i25);
                                        } else {
                                            parcelArr2[i24] = null;
                                        }
                                    }
                                    parcel.setDataPosition(iDataPosition7 + iM6439N7);
                                    parcelArr = parcelArr2;
                                }
                                int length9 = parcelArr.length;
                                for (int i26 = 0; i26 < length9; i26++) {
                                    if (i26 > 0) {
                                        sb.append(",");
                                    }
                                    parcelArr[i26].setDataPosition(0);
                                    AbstractC1312l.m3198e(str3);
                                    AbstractC1312l.m3198e(fastJsonResponse$Field.f5145j);
                                    Map map3 = (Map) fastJsonResponse$Field.f5145j.f5161b.get(str3);
                                    AbstractC1312l.m3198e(map3);
                                    m3679r(sb, map3, parcelArr[i26]);
                                }
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out.");
                        }
                        sb.append("]");
                    } else {
                        switch (i10) {
                            case 0:
                                sb.append(AbstractC3198d.m6436K(parcel, i6));
                                break;
                            case 1:
                                int iM6439N8 = AbstractC3198d.m6439N(parcel, i6);
                                int iDataPosition9 = parcel.dataPosition();
                                if (iM6439N8 != 0) {
                                    byte[] bArrCreateByteArray2 = parcel.createByteArray();
                                    parcel.setDataPosition(iDataPosition9 + iM6439N8);
                                    bigInteger = new BigInteger(bArrCreateByteArray2);
                                }
                                sb.append(bigInteger);
                                break;
                            case 2:
                                sb.append(AbstractC3198d.m6438M(parcel, i6));
                                break;
                            case 3:
                                sb.append(AbstractC3198d.m6434I(parcel, i6));
                                break;
                            case 4:
                                sb.append(AbstractC3198d.m6433H(parcel, i6));
                                break;
                            case 5:
                                sb.append(AbstractC3198d.m6457e(parcel, i6));
                                break;
                            case 6:
                                sb.append(AbstractC3198d.m6431F(parcel, i6));
                                break;
                            case 7:
                                String strM6463k = AbstractC3198d.m6463k(parcel, i6);
                                sb.append("\"");
                                sb.append(AbstractC2891a.m5895b(strM6463k));
                                sb.append("\"");
                                break;
                            case 8:
                                byte[] bArrM6459g = AbstractC3198d.m6459g(parcel, i6);
                                sb.append("\"");
                                sb.append(bArrM6459g != null ? Base64.encodeToString(bArrM6459g, 0) : null);
                                sb.append("\"");
                                break;
                            case 9:
                                byte[] bArrM6459g2 = AbstractC3198d.m6459g(parcel, i6);
                                sb.append("\"");
                                sb.append(bArrM6459g2 != null ? Base64.encodeToString(bArrM6459g2, 10) : null);
                                sb.append("\"");
                                break;
                            case 10:
                                Bundle bundleM6458f2 = AbstractC3198d.m6458f(parcel, i6);
                                Set<String> setKeySet = bundleM6458f2.keySet();
                                sb.append("{");
                                boolean z11 = true;
                                for (String str4 : setKeySet) {
                                    if (!z11) {
                                        sb.append(",");
                                    }
                                    sb.append("\"");
                                    sb.append(str4);
                                    sb.append("\":\"");
                                    sb.append(AbstractC2891a.m5895b(bundleM6458f2.getString(str4)));
                                    sb.append("\"");
                                    z11 = false;
                                }
                                sb.append("}");
                                break;
                            case 11:
                                int iM6439N9 = AbstractC3198d.m6439N(parcel, i6);
                                int iDataPosition10 = parcel.dataPosition();
                                if (iM6439N9 != 0) {
                                    parcelObtain = Parcel.obtain();
                                    parcelObtain.appendFrom(parcel, iDataPosition10, iM6439N9);
                                    parcel.setDataPosition(iDataPosition10 + iM6439N9);
                                }
                                parcelObtain.setDataPosition(0);
                                AbstractC1312l.m3198e(str3);
                                AbstractC1312l.m3198e(fastJsonResponse$Field.f5145j);
                                Map map4 = (Map) fastJsonResponse$Field.f5145j.f5161b.get(str3);
                                AbstractC1312l.m3198e(map4);
                                m3679r(sb, map4, parcelObtain);
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out");
                        }
                    }
                }
                z7 = true;
            }
        }
        if (parcel.dataPosition() != iM6447V) {
            throw new C0423q(AbstractC0004e.m20n(iM6447V, "Overread allowed size end="), parcel);
        }
        sb.append('}');
    }

    public static final void m3680s(StringBuilder sb, int i6, Object obj) {
        switch (i6) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                AbstractC1312l.m3198e(obj);
                sb.append(AbstractC2891a.m5895b(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                byte[] bArr = (byte[]) obj;
                sb.append(bArr != null ? Base64.encodeToString(bArr, 0) : null);
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                byte[] bArr2 = (byte[]) obj;
                sb.append(bArr2 != null ? Base64.encodeToString(bArr2, 10) : null);
                sb.append("\"");
                return;
            case 10:
                AbstractC1312l.m3198e(obj);
                AbstractC3612b.m7260Q(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Unknown type = "));
        }
    }

    public static final void m3681t(StringBuilder sb, FastJsonResponse$Field fastJsonResponse$Field, Object obj) {
        boolean z7 = fastJsonResponse$Field.f5138c;
        int i6 = fastJsonResponse$Field.f5137b;
        if (!z7) {
            m3680s(sb, i6, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 != 0) {
                sb.append(",");
            }
            m3680s(sb, i6, arrayList.get(i10));
        }
        sb.append("]");
    }

    @Override
    public final Map mo3674h() {
        zan zanVar = this.f5150d;
        if (zanVar == null) {
            return null;
        }
        String str = this.f5151e;
        AbstractC1312l.m3198e(str);
        return (Map) zanVar.f5161b.get(str);
    }

    @Override
    public final Object mo3676l() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override
    public final boolean mo3678n() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final Parcel m3682q() {
        int i6 = this.f5152f;
        Parcel parcel = this.f5148b;
        if (i6 == 0) {
            int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
            this.f5153g = iM6583V;
            AbstractC3280d.m6584W(parcel, iM6583V);
            this.f5152f = 2;
        } else if (i6 == 1) {
            AbstractC3280d.m6584W(parcel, this.f5153g);
            this.f5152f = 2;
        }
        return parcel;
    }

    @Override
    public final String toString() {
        zan zanVar = this.f5150d;
        AbstractC1312l.m3199f(zanVar, "Cannot convert to JSON on client side.");
        Parcel parcelM3682q = m3682q();
        parcelM3682q.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        String str = this.f5151e;
        AbstractC1312l.m3198e(str);
        Map map = (Map) zanVar.f5161b.get(str);
        AbstractC1312l.m3198e(map);
        m3679r(sb, map, parcelM3682q);
        return sb.toString();
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5147a);
        Parcel parcelM3682q = m3682q();
        if (parcelM3682q != null) {
            int iM6583V2 = AbstractC3280d.m6583V(parcel, 2);
            parcel.appendFrom(parcelM3682q, 0, parcelM3682q.dataSize());
            AbstractC3280d.m6584W(parcel, iM6583V2);
        }
        AbstractC3280d.m6578Q(parcel, 3, this.f5149c != 0 ? this.f5150d : null, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
