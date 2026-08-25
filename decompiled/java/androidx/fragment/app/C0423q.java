package androidx.fragment.app;

import android.os.Parcel;

public final class C0423q extends RuntimeException {

    public final int f1936a;

    private final synchronized Throwable m1306a() {
        return this;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        switch (this.f1936a) {
            case 5:
                m1306a();
                return this;
            default:
                return super.fillInStackTrace();
        }
    }

    public C0423q(String str, int i6) {
        super(str);
        this.f1936a = i6;
    }

    public C0423q(String str, Throwable th, int i6) {
        super(str, th);
        this.f1936a = i6;
    }

    public C0423q(Throwable th, int i6) {
        super(th);
        this.f1936a = i6;
    }

    public C0423q(String str, Parcel parcel) {
        super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        this.f1936a = 2;
    }
}
