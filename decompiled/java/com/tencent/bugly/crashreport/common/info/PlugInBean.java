package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;
import p249x4.C4120m;

public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new C4120m(3);

    public final String f7066a;

    public final String f7067b;

    public final String f7068c;

    public PlugInBean(String str, String str2, String str3) {
        this.f7066a = str;
        this.f7067b = str2;
        this.f7068c = str3;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f7066a + " plV:" + this.f7067b + " plUUID:" + this.f7068c;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f7066a);
        parcel.writeString(this.f7067b);
        parcel.writeString(this.f7068c);
    }

    public PlugInBean(Parcel parcel) {
        this.f7066a = parcel.readString();
        this.f7067b = parcel.readString();
        this.f7068c = parcel.readString();
    }
}
