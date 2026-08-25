package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.C2033ap;
import java.util.Map;
import p249x4.C4120m;

public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new C4120m(1);

    public long f7047a;

    public int f7048b;

    public String f7049c;

    public String f7050d;

    public long f7051e;

    public long f7052f;

    public long f7053g;

    public long f7054h;

    public long f7055i;

    public String f7056j;

    public long f7057k;

    public boolean f7058l;

    public String f7059m;

    public String f7060n;

    public int f7061o;

    public int f7062p;

    public int f7063q;

    public Map<String, String> f7064r;

    public Map<String, String> f7065s;

    public UserInfoBean() {
        this.f7057k = 0L;
        this.f7058l = false;
        this.f7059m = "unknown";
        this.f7062p = -1;
        this.f7063q = -1;
        this.f7064r = null;
        this.f7065s = null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f7048b);
        parcel.writeString(this.f7049c);
        parcel.writeString(this.f7050d);
        parcel.writeLong(this.f7051e);
        parcel.writeLong(this.f7052f);
        parcel.writeLong(this.f7053g);
        parcel.writeLong(this.f7054h);
        parcel.writeLong(this.f7055i);
        parcel.writeString(this.f7056j);
        parcel.writeLong(this.f7057k);
        parcel.writeByte(this.f7058l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7059m);
        parcel.writeInt(this.f7062p);
        parcel.writeInt(this.f7063q);
        C2033ap.m4700b(parcel, this.f7064r);
        C2033ap.m4700b(parcel, this.f7065s);
        parcel.writeString(this.f7060n);
        parcel.writeInt(this.f7061o);
    }

    public UserInfoBean(Parcel parcel) {
        this.f7057k = 0L;
        this.f7058l = false;
        this.f7059m = "unknown";
        this.f7062p = -1;
        this.f7063q = -1;
        this.f7064r = null;
        this.f7065s = null;
        this.f7048b = parcel.readInt();
        this.f7049c = parcel.readString();
        this.f7050d = parcel.readString();
        this.f7051e = parcel.readLong();
        this.f7052f = parcel.readLong();
        this.f7053g = parcel.readLong();
        this.f7054h = parcel.readLong();
        this.f7055i = parcel.readLong();
        this.f7056j = parcel.readString();
        this.f7057k = parcel.readLong();
        this.f7058l = parcel.readByte() == 1;
        this.f7059m = parcel.readString();
        this.f7062p = parcel.readInt();
        this.f7063q = parcel.readInt();
        this.f7064r = C2033ap.m4698b(parcel);
        this.f7065s = C2033ap.m4698b(parcel);
        this.f7060n = parcel.readString();
        this.f7061o = parcel.readInt();
    }
}
