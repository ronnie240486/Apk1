package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.C2033ap;
import java.util.Map;
import java.util.UUID;
import p237w0.C4043d;

public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new C4043d(17);

    public String f7092A;

    public String f7093B;

    public long f7094C;

    public long f7095D;

    public long f7096E;

    public long f7097F;

    public long f7098G;

    public long f7099H;

    public long f7100I;

    public long f7101J;

    public long f7102K;

    public String f7103L;

    public String f7104M;

    public String f7105N;

    public String f7106O;

    public String f7107P;

    public long f7108Q;

    public boolean f7109R;

    public Map<String, String> f7110S;

    public Map<String, String> f7111T;

    public int f7112U;

    public int f7113V;

    public Map<String, String> f7114W;

    public Map<String, String> f7115X;

    public byte[] f7116Y;

    public String f7117Z;

    public long f7118a;

    public String f7119aa;

    public int f7120b;

    public String f7121c;

    public boolean f7122d;

    public String f7123e;

    public String f7124f;

    public String f7125g;

    public Map<String, PlugInBean> f7126h;

    public Map<String, PlugInBean> f7127i;

    public boolean f7128j;

    public boolean f7129k;

    public int f7130l;

    public String f7131m;

    public String f7132n;

    public String f7133o;

    public String f7134p;

    public String f7135q;

    public long f7136r;

    public String f7137s;

    public int f7138t;

    public String f7139u;

    public String f7140v;

    public String f7141w;

    public String f7142x;

    public byte[] f7143y;

    public Map<String, String> f7144z;

    public CrashDetailBean() {
        this.f7118a = -1L;
        this.f7120b = 0;
        this.f7121c = UUID.randomUUID().toString();
        this.f7122d = false;
        this.f7123e = "";
        this.f7124f = "";
        this.f7125g = "";
        this.f7126h = null;
        this.f7127i = null;
        this.f7128j = false;
        this.f7129k = false;
        this.f7130l = 0;
        this.f7131m = "";
        this.f7132n = "";
        this.f7133o = "";
        this.f7134p = "";
        this.f7135q = "";
        this.f7136r = -1L;
        this.f7137s = null;
        this.f7138t = 0;
        this.f7139u = "";
        this.f7140v = "";
        this.f7141w = null;
        this.f7142x = null;
        this.f7143y = null;
        this.f7144z = null;
        this.f7092A = "";
        this.f7093B = "";
        this.f7094C = -1L;
        this.f7095D = -1L;
        this.f7096E = -1L;
        this.f7097F = -1L;
        this.f7098G = -1L;
        this.f7099H = -1L;
        this.f7100I = -1L;
        this.f7101J = -1L;
        this.f7102K = -1L;
        this.f7103L = "";
        this.f7104M = "";
        this.f7105N = "";
        this.f7106O = "";
        this.f7107P = "";
        this.f7108Q = -1L;
        this.f7109R = false;
        this.f7110S = null;
        this.f7111T = null;
        this.f7112U = -1;
        this.f7113V = -1;
        this.f7114W = null;
        this.f7115X = null;
        this.f7116Y = null;
        this.f7117Z = null;
        this.f7119aa = null;
    }

    @Override
    public int compareTo(CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 == null) {
            return 1;
        }
        long j10 = this.f7136r - crashDetailBean2.f7136r;
        if (j10 <= 0) {
            return j10 < 0 ? -1 : 0;
        }
        return 1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f7120b);
        parcel.writeString(this.f7121c);
        parcel.writeByte(this.f7122d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7123e);
        parcel.writeString(this.f7124f);
        parcel.writeString(this.f7125g);
        parcel.writeByte(this.f7128j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7129k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f7130l);
        parcel.writeString(this.f7131m);
        parcel.writeString(this.f7132n);
        parcel.writeString(this.f7133o);
        parcel.writeString(this.f7134p);
        parcel.writeString(this.f7135q);
        parcel.writeLong(this.f7136r);
        parcel.writeString(this.f7137s);
        parcel.writeInt(this.f7138t);
        parcel.writeString(this.f7139u);
        parcel.writeString(this.f7140v);
        parcel.writeString(this.f7141w);
        C2033ap.m4700b(parcel, this.f7144z);
        parcel.writeString(this.f7092A);
        parcel.writeString(this.f7093B);
        parcel.writeLong(this.f7094C);
        parcel.writeLong(this.f7095D);
        parcel.writeLong(this.f7096E);
        parcel.writeLong(this.f7097F);
        parcel.writeLong(this.f7098G);
        parcel.writeLong(this.f7099H);
        parcel.writeString(this.f7103L);
        parcel.writeString(this.f7104M);
        parcel.writeString(this.f7105N);
        parcel.writeString(this.f7106O);
        parcel.writeString(this.f7107P);
        parcel.writeLong(this.f7108Q);
        parcel.writeByte(this.f7109R ? (byte) 1 : (byte) 0);
        C2033ap.m4700b(parcel, this.f7110S);
        C2033ap.m4687a(parcel, this.f7126h);
        C2033ap.m4687a(parcel, this.f7127i);
        parcel.writeInt(this.f7112U);
        parcel.writeInt(this.f7113V);
        C2033ap.m4700b(parcel, this.f7114W);
        C2033ap.m4700b(parcel, this.f7115X);
        parcel.writeByteArray(this.f7116Y);
        parcel.writeByteArray(this.f7143y);
        parcel.writeString(this.f7117Z);
        parcel.writeString(this.f7119aa);
        parcel.writeString(this.f7142x);
        parcel.writeLong(this.f7100I);
        parcel.writeLong(this.f7101J);
        parcel.writeLong(this.f7102K);
    }

    public CrashDetailBean(Parcel parcel) {
        this.f7118a = -1L;
        this.f7120b = 0;
        this.f7121c = UUID.randomUUID().toString();
        this.f7122d = false;
        this.f7123e = "";
        this.f7124f = "";
        this.f7125g = "";
        this.f7126h = null;
        this.f7127i = null;
        this.f7128j = false;
        this.f7129k = false;
        this.f7130l = 0;
        this.f7131m = "";
        this.f7132n = "";
        this.f7133o = "";
        this.f7134p = "";
        this.f7135q = "";
        this.f7136r = -1L;
        this.f7137s = null;
        this.f7138t = 0;
        this.f7139u = "";
        this.f7140v = "";
        this.f7141w = null;
        this.f7142x = null;
        this.f7143y = null;
        this.f7144z = null;
        this.f7092A = "";
        this.f7093B = "";
        this.f7094C = -1L;
        this.f7095D = -1L;
        this.f7096E = -1L;
        this.f7097F = -1L;
        this.f7098G = -1L;
        this.f7099H = -1L;
        this.f7100I = -1L;
        this.f7101J = -1L;
        this.f7102K = -1L;
        this.f7103L = "";
        this.f7104M = "";
        this.f7105N = "";
        this.f7106O = "";
        this.f7107P = "";
        this.f7108Q = -1L;
        this.f7109R = false;
        this.f7110S = null;
        this.f7111T = null;
        this.f7112U = -1;
        this.f7113V = -1;
        this.f7114W = null;
        this.f7115X = null;
        this.f7116Y = null;
        this.f7117Z = null;
        this.f7119aa = null;
        this.f7120b = parcel.readInt();
        this.f7121c = parcel.readString();
        this.f7122d = parcel.readByte() == 1;
        this.f7123e = parcel.readString();
        this.f7124f = parcel.readString();
        this.f7125g = parcel.readString();
        this.f7128j = parcel.readByte() == 1;
        this.f7129k = parcel.readByte() == 1;
        this.f7130l = parcel.readInt();
        this.f7131m = parcel.readString();
        this.f7132n = parcel.readString();
        this.f7133o = parcel.readString();
        this.f7134p = parcel.readString();
        this.f7135q = parcel.readString();
        this.f7136r = parcel.readLong();
        this.f7137s = parcel.readString();
        this.f7138t = parcel.readInt();
        this.f7139u = parcel.readString();
        this.f7140v = parcel.readString();
        this.f7141w = parcel.readString();
        this.f7144z = C2033ap.m4698b(parcel);
        this.f7092A = parcel.readString();
        this.f7093B = parcel.readString();
        this.f7094C = parcel.readLong();
        this.f7095D = parcel.readLong();
        this.f7096E = parcel.readLong();
        this.f7097F = parcel.readLong();
        this.f7098G = parcel.readLong();
        this.f7099H = parcel.readLong();
        this.f7103L = parcel.readString();
        this.f7104M = parcel.readString();
        this.f7105N = parcel.readString();
        this.f7106O = parcel.readString();
        this.f7107P = parcel.readString();
        this.f7108Q = parcel.readLong();
        this.f7109R = parcel.readByte() == 1;
        this.f7110S = C2033ap.m4698b(parcel);
        this.f7126h = C2033ap.m4685a(parcel);
        this.f7127i = C2033ap.m4685a(parcel);
        this.f7112U = parcel.readInt();
        this.f7113V = parcel.readInt();
        this.f7114W = C2033ap.m4698b(parcel);
        this.f7115X = C2033ap.m4698b(parcel);
        this.f7116Y = parcel.createByteArray();
        this.f7143y = parcel.createByteArray();
        this.f7117Z = parcel.readString();
        this.f7119aa = parcel.readString();
        this.f7142x = parcel.readString();
        this.f7100I = parcel.readLong();
        this.f7101J = parcel.readLong();
        this.f7102K = parcel.readLong();
    }
}
