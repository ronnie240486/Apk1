package p230v4;

import android.util.Log;
import androidx.media3.common.PlaybackException;
import p176q4.C3474b0;
import p187r4.C3611a;

public final class C3995i implements InterfaceC3999m {

    public final int f13526a;

    public final InterfaceC3999m f13527b;

    public final C3998l f13528c;

    public C3995i(C3998l c3998l, InterfaceC3999m interfaceC3999m, int i6) {
        this.f13526a = i6;
        this.f13527b = interfaceC3999m;
        this.f13528c = c3998l;
    }

    @Override
    public final void mo7338c(String str, long j10, int i6, C3997k c3997k, long j11, long j12) {
        int i10;
        C3998l c3998l = this.f13528c;
        switch (this.f13526a) {
            case 0:
                c3998l.f13532g = null;
                InterfaceC3999m interfaceC3999m = this.f13527b;
                if (interfaceC3999m != null) {
                    interfaceC3999m.mo7338c(str, j10, i6, c3997k, j11, j12);
                }
                break;
            default:
                InterfaceC3999m interfaceC3999m2 = this.f13527b;
                if (interfaceC3999m2 != null) {
                    if (i6 == 2001) {
                        Object[] objArr = {Integer.valueOf(c3998l.f13534i)};
                        C3988b c3988b = c3998l.f13557a;
                        Log.w(c3988b.f13521a, c3988b.m7977d("Possibility of local queue out of sync with receiver queue. Refetching sequence number. Current Local Sequence Number = %d", objArr));
                        for (C3474b0 c3474b0 : c3998l.f13533h.f12186a.f12155h) {
                            switch (c3474b0.f11753a) {
                                case 1:
                                    ((C3611a) c3474b0.f11754b).m7246d();
                                    break;
                            }
                        }
                        i10 = PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED;
                    } else {
                        i10 = i6;
                    }
                    interfaceC3999m2.mo7338c(str, j10, i10, c3997k, j11, j12);
                }
                break;
        }
    }

    @Override
    public final void mo7339d(String str, long j10, long j11, long j12) {
        switch (this.f13526a) {
            case 0:
                InterfaceC3999m interfaceC3999m = this.f13527b;
                if (interfaceC3999m != null) {
                    interfaceC3999m.mo7339d(str, j10, j11, j12);
                }
                break;
            default:
                InterfaceC3999m interfaceC3999m2 = this.f13527b;
                if (interfaceC3999m2 != null) {
                    interfaceC3999m2.mo7339d(str, j10, j11, j12);
                }
                break;
        }
    }
}
