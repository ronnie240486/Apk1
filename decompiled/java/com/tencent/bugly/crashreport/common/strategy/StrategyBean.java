package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import com.tencent.bugly.proguard.C2033ap;
import java.util.Map;
import p055ea.AbstractC2460q;
import p237w0.C4043d;

public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new C4043d(4);

    public static String f7069a = "https://android.bugly.qq.com/rqd/async";

    public static String f7070b = "https://android.bugly.qq.com/rqd/async";

    public static String f7071c;

    public long f7072d;

    public long f7073e;

    public boolean f7074f;

    public boolean f7075g;

    public boolean f7076h;

    public boolean f7077i;

    public boolean f7078j;

    public boolean f7079k;

    public boolean f7080l;

    public boolean f7081m;

    public boolean f7082n;

    public long f7083o;

    public long f7084p;

    public String f7085q;

    public String f7086r;

    public String f7087s;

    public Map<String, String> f7088t;

    public int f7089u;

    public long f7090v;

    public long f7091w;

    public StrategyBean() {
        this.f7072d = -1L;
        this.f7073e = -1L;
        this.f7074f = true;
        this.f7075g = true;
        this.f7076h = true;
        this.f7077i = true;
        this.f7078j = false;
        this.f7079k = true;
        this.f7080l = true;
        this.f7081m = true;
        this.f7082n = true;
        this.f7084p = SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS;
        this.f7085q = f7069a;
        this.f7086r = f7070b;
        this.f7089u = 10;
        this.f7090v = 300000L;
        this.f7091w = -1L;
        this.f7073e = System.currentTimeMillis();
        StringBuilder sbM5498l = AbstractC2460q.m5498l("S(@L@L@)");
        f7071c = sbM5498l.toString();
        sbM5498l.setLength(0);
        sbM5498l.append("*^@K#K@!");
        this.f7087s = sbM5498l.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeLong(this.f7073e);
        parcel.writeByte(this.f7074f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7075g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7076h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7085q);
        parcel.writeString(this.f7086r);
        parcel.writeString(this.f7087s);
        C2033ap.m4700b(parcel, this.f7088t);
        parcel.writeByte(this.f7077i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7078j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7081m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7082n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f7084p);
        parcel.writeByte(this.f7079k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7080l ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f7083o);
        parcel.writeInt(this.f7089u);
        parcel.writeLong(this.f7090v);
        parcel.writeLong(this.f7091w);
    }

    public StrategyBean(Parcel parcel) {
        this.f7072d = -1L;
        this.f7073e = -1L;
        boolean z7 = true;
        this.f7074f = true;
        this.f7075g = true;
        this.f7076h = true;
        this.f7077i = true;
        this.f7078j = false;
        this.f7079k = true;
        this.f7080l = true;
        this.f7081m = true;
        this.f7082n = true;
        this.f7084p = SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS;
        this.f7085q = f7069a;
        this.f7086r = f7070b;
        this.f7089u = 10;
        this.f7090v = 300000L;
        this.f7091w = -1L;
        try {
            f7071c = "S(@L@L@)";
            this.f7073e = parcel.readLong();
            this.f7074f = parcel.readByte() == 1;
            this.f7075g = parcel.readByte() == 1;
            this.f7076h = parcel.readByte() == 1;
            this.f7085q = parcel.readString();
            this.f7086r = parcel.readString();
            this.f7087s = parcel.readString();
            this.f7088t = C2033ap.m4698b(parcel);
            this.f7077i = parcel.readByte() == 1;
            this.f7078j = parcel.readByte() == 1;
            this.f7081m = parcel.readByte() == 1;
            this.f7082n = parcel.readByte() == 1;
            this.f7084p = parcel.readLong();
            this.f7079k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z7 = false;
            }
            this.f7080l = z7;
            this.f7083o = parcel.readLong();
            this.f7089u = parcel.readInt();
            this.f7090v = parcel.readLong();
            this.f7091w = parcel.readLong();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
