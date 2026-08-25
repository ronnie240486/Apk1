package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zaa;
import p007a7.C0069f;
import p088i5.C2705a;
import p156o9.AbstractC3280d;

public class FastJsonResponse$Field<I, O> extends AbstractSafeParcelable {
    public static final C2705a CREATOR = new C2705a();

    public final int f5136a;

    public final int f5137b;

    public final boolean f5138c;

    public final int f5139d;

    public final boolean f5140e;

    public final String f5141f;

    public final int f5142g;

    public final Class f5143h;

    public final String f5144i;

    public zan f5145j;

    public final StringToIntConverter f5146k;

    public FastJsonResponse$Field(int i6, int i10, boolean z7, int i11, boolean z10, String str, int i12, String str2, zaa zaaVar) {
        this.f5136a = i6;
        this.f5137b = i10;
        this.f5138c = z7;
        this.f5139d = i11;
        this.f5140e = z10;
        this.f5141f = str;
        this.f5142g = i12;
        if (str2 == null) {
            this.f5143h = null;
            this.f5144i = null;
        } else {
            this.f5143h = SafeParcelResponse.class;
            this.f5144i = str2;
        }
        if (zaaVar == null) {
            this.f5146k = null;
            return;
        }
        StringToIntConverter stringToIntConverter = zaaVar.f5132b;
        if (stringToIntConverter == null) {
            throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
        }
        this.f5146k = stringToIntConverter;
    }

    public final String toString() {
        C0069f c0069f = new C0069f(this);
        c0069f.m229c(Integer.valueOf(this.f5136a), "versionCode");
        c0069f.m229c(Integer.valueOf(this.f5137b), "typeIn");
        c0069f.m229c(Boolean.valueOf(this.f5138c), "typeInArray");
        c0069f.m229c(Integer.valueOf(this.f5139d), "typeOut");
        c0069f.m229c(Boolean.valueOf(this.f5140e), "typeOutArray");
        c0069f.m229c(this.f5141f, "outputFieldName");
        c0069f.m229c(Integer.valueOf(this.f5142g), "safeParcelFieldId");
        String str = this.f5144i;
        if (str == null) {
            str = null;
        }
        c0069f.m229c(str, "concreteTypeName");
        Class cls = this.f5143h;
        if (cls != null) {
            c0069f.m229c(cls.getCanonicalName(), "concreteType.class");
        }
        if (this.f5146k != null) {
            c0069f.m229c(StringToIntConverter.class.getCanonicalName(), "converterName");
        }
        return c0069f.toString();
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5136a);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f5137b);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5138c ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(this.f5139d);
        AbstractC3280d.m6585X(parcel, 5, 4);
        parcel.writeInt(this.f5140e ? 1 : 0);
        AbstractC3280d.m6579R(parcel, 6, this.f5141f);
        AbstractC3280d.m6585X(parcel, 7, 4);
        parcel.writeInt(this.f5142g);
        String str = this.f5144i;
        if (str == null) {
            str = null;
        }
        AbstractC3280d.m6579R(parcel, 8, str);
        StringToIntConverter stringToIntConverter = this.f5146k;
        AbstractC3280d.m6578Q(parcel, 9, stringToIntConverter != null ? new zaa(stringToIntConverter) : null, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
