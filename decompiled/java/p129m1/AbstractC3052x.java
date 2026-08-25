package p129m1;

import android.media.VolumeProvider;
import android.os.Build;

public abstract class AbstractC3052x {

    public final int f10406a;

    public final int f10407b;

    public final String f10408c;

    public int f10409d;

    public AbstractC3051w f10410e;

    public VolumeProvider f10411f;

    public AbstractC3052x(int i6, String str, int i10, int i11) {
        this.f10406a = i6;
        this.f10407b = i10;
        this.f10409d = i11;
        this.f10408c = str;
    }

    public final VolumeProvider m6104a() {
        if (this.f10411f == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f10411f = new C3048t(this, this.f10406a, this.f10407b, this.f10409d, this.f10408c);
            } else {
                this.f10411f = new C3049u(this, this.f10406a, this.f10407b, this.f10409d);
            }
        }
        return this.f10411f;
    }
}
