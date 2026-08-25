package p187r4;

import android.content.ClipDescription;
import android.net.Uri;
import android.util.Log;
import androidx.constraintlayout.widget.C0306b;
import androidx.media3.exoplayer.Renderer;
import com.google.android.gms.common.Feature;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.internal.p159ws.WebSocketProtocol;
import p128m0.C3028d;
import p141n3.C3192f;
import p171q.C3388b;
import p195s0.InterfaceC3690g;
import p198s3.InterfaceC3703a;
import p198s3.InterfaceC3704b;
import p225v.C3958e;
import p225v.C3959f;
import p225v.EnumC3957d;
import p230v4.AbstractC3987a;
import p236w.C4027b;
import p236w.InterfaceC4028c;
import p247x2.C4090l;
import p247x2.C4094p;
import p271z4.C4337h;
import p271z4.C4339j;

public final class C3621k implements InterfaceC3690g {

    public final int f12169a;

    public Object f12170b;

    public Object f12171c;

    public Object f12172d;

    @Override
    public ClipDescription mo7324a() {
        return (ClipDescription) this.f12171c;
    }

    @Override
    public Object mo7325b() {
        return null;
    }

    @Override
    public Uri mo7326c() {
        return (Uri) this.f12170b;
    }

    @Override
    public Uri mo7328e() {
        return (Uri) this.f12172d;
    }

    public Object m7329f() {
        Object objMo6099a = ((C3028d) this.f12172d).mo6099a();
        if (objMo6099a == null) {
            objMo6099a = ((InterfaceC3703a) this.f12170b).mo6882g();
            if (Log.isLoggable("FactoryPools", 2)) {
                Log.v("FactoryPools", "Created new " + objMo6099a.getClass());
            }
        }
        if (objMo6099a instanceof InterfaceC3704b) {
            ((InterfaceC3704b) objMo6099a).mo7466b().f12412a = false;
        }
        return objMo6099a;
    }

    public void m7330g(double d, float f) {
        int length = ((float[]) this.f12170b).length + 1;
        int iBinarySearch = Arrays.binarySearch((double[]) this.f12171c, d);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        this.f12171c = Arrays.copyOf((double[]) this.f12171c, length);
        this.f12170b = Arrays.copyOf((float[]) this.f12170b, length);
        this.f12172d = new double[length];
        double[] dArr = (double[]) this.f12171c;
        System.arraycopy(dArr, iBinarySearch, dArr, iBinarySearch + 1, (length - iBinarySearch) - 1);
        ((double[]) this.f12171c)[iBinarySearch] = d;
        ((float[]) this.f12170b)[iBinarySearch] = f;
    }

    public double m7331h(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        } else if (d > 1.0d) {
            d = 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch((double[]) this.f12171c, d);
        if (iBinarySearch > 0) {
            return 1.0d;
        }
        if (iBinarySearch == 0) {
            return 0.0d;
        }
        int i6 = -iBinarySearch;
        int i10 = i6 - 1;
        float[] fArr = (float[]) this.f12170b;
        float f = fArr[i10];
        int i11 = i6 - 2;
        float f3 = fArr[i11];
        double[] dArr = (double[]) this.f12171c;
        double d10 = dArr[i10];
        double d11 = dArr[i11];
        double d12 = ((double) (f - f3)) / (d10 - d11);
        return ((((d * d) - (d11 * d11)) * d12) / 2.0d) + ((d - d11) * (((double) f3) - (d12 * d11))) + ((double[]) this.f12172d)[i11];
    }

    public double m7332i(double d) {
        return Math.sin(m7331h(d) * 6.283185307179586d);
    }

    public boolean m7333j(InterfaceC4028c interfaceC4028c, C3958e c3958e, boolean z7) {
        EnumC3957d[] enumC3957dArr = c3958e.f13333J;
        EnumC3957d enumC3957d = enumC3957dArr[0];
        C4027b c4027b = (C4027b) this.f12171c;
        c4027b.f13643a = enumC3957d;
        c4027b.f13644b = enumC3957dArr[1];
        c4027b.f13645c = c3958e.m7905m();
        c4027b.f13646d = c3958e.m7902j();
        c4027b.f13651i = false;
        c4027b.f13652j = z7;
        EnumC3957d enumC3957d2 = c4027b.f13643a;
        EnumC3957d enumC3957d3 = EnumC3957d.f13321c;
        boolean z10 = enumC3957d2 == enumC3957d3;
        boolean z11 = c4027b.f13644b == enumC3957d3;
        boolean z12 = z10 && c3958e.f13337N > 0.0f;
        boolean z13 = z11 && c3958e.f13337N > 0.0f;
        EnumC3957d enumC3957d4 = EnumC3957d.f13319a;
        int[] iArr = c3958e.f13367l;
        if (z12 && iArr[0] == 4) {
            c4027b.f13643a = enumC3957d4;
        }
        if (z13 && iArr[1] == 4) {
            c4027b.f13644b = enumC3957d4;
        }
        ((C0306b) interfaceC4028c).m886a(c3958e, c4027b);
        c3958e.m7918z(c4027b.f13647e);
        c3958e.m7915w(c4027b.f13648f);
        c3958e.f13378w = c4027b.f13650h;
        int i6 = c4027b.f13649g;
        c3958e.f13341R = i6;
        c3958e.f13378w = i6 > 0;
        c4027b.f13652j = false;
        return c4027b.f13651i;
    }

    public boolean m7334k(Object obj) {
        if (obj instanceof InterfaceC3704b) {
            ((InterfaceC3704b) obj).mo7466b().f12412a = true;
        }
        switch (((C3388b) this.f12171c).f11425a) {
            case 1:
                break;
            default:
                ((List) obj).clear();
                break;
        }
        return ((C3028d) this.f12172d).mo6101c(obj);
    }

    public void m7335l(C3959f c3959f, int i6, int i10) {
        int i11 = c3959f.f13342S;
        int i12 = c3959f.f13343T;
        c3959f.f13342S = 0;
        c3959f.f13343T = 0;
        c3959f.m7918z(i6);
        c3959f.m7915w(i10);
        if (i11 < 0) {
            c3959f.f13342S = 0;
        } else {
            c3959f.f13342S = i11;
        }
        if (i12 < 0) {
            c3959f.f13343T = 0;
        } else {
            c3959f.f13343T = i12;
        }
        ((C3959f) this.f12172d).m7922F();
    }

    public String toString() {
        switch (this.f12169a) {
            case 1:
                return "pos =" + Arrays.toString((double[]) this.f12171c) + " period=" + Arrays.toString((float[]) this.f12170b);
            default:
                return super.toString();
        }
    }

    public C3621k(Object obj, Object obj2, Object obj3, int i6) {
        this.f12169a = i6;
        this.f12170b = obj;
        this.f12171c = obj2;
        this.f12172d = obj3;
    }

    public C3621k(C4339j c4339j, C4337h c4337h, Feature[] featureArr, int i6) {
        this.f12169a = 8;
        this.f12172d = c4339j;
        this.f12170b = c4337h;
        this.f12171c = featureArr;
    }

    public C3621k(C3616f c3616f) {
        this.f12169a = 0;
        this.f12172d = c3616f;
        this.f12171c = new AtomicLong((AbstractC3987a.f13520b.nextLong() & WebSocketProtocol.PAYLOAD_SHORT_MAX) * Renderer.DEFAULT_DURATION_TO_PROGRESS_US);
    }

    public C3621k(C3959f c3959f) {
        this.f12169a = 4;
        this.f12170b = new ArrayList();
        this.f12171c = new C4027b();
        this.f12172d = c3959f;
    }

    public C3621k(C3028d c3028d, InterfaceC3703a interfaceC3703a, C3388b c3388b) {
        this.f12169a = 3;
        this.f12172d = c3028d;
        this.f12170b = interfaceC3703a;
        this.f12171c = c3388b;
    }

    public C3621k(C4090l c4090l, C3192f c3192f, C4094p c4094p) {
        this.f12169a = 7;
        this.f12172d = c4090l;
        this.f12171c = c3192f;
        this.f12170b = c4094p;
    }

    @Override
    public void mo7327d() {
    }
}
