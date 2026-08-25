package p271z4;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC1500a;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import p018b5.C1304d;
import p176q4.C3477d;
import p242w5.InterfaceC4053a;
import p261y4.C4257e;
import p261y4.InterfaceC4255c;

public final class C4347r implements InterfaceC4053a {

    public final C4334e f14736a;

    public final int f14737b;

    public final C4331b f14738c;

    public final long f14739d;

    public final long f14740e;

    public C4347r(C4334e c4334e, int i6, C4331b c4331b, long j10, long j11) {
        this.f14736a = c4334e;
        this.f14737b = i6;
        this.f14738c = c4331b;
        this.f14739d = j10;
        this.f14740e = j11;
    }

    public static ConnectionTelemetryConfiguration m8389a(C4343n c4343n, AbstractC1500a abstractC1500a, int i6) {
        zzk zzkVar = abstractC1500a.f5090v;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzkVar == null ? null : zzkVar.f5110d;
        if (connectionTelemetryConfiguration != null && connectionTelemetryConfiguration.f5031b) {
            int[] iArr = connectionTelemetryConfiguration.f5033d;
            int i10 = 0;
            if (iArr == null) {
                int[] iArr2 = connectionTelemetryConfiguration.f5035f;
                if (iArr2 != null) {
                    while (i10 < iArr2.length) {
                        if (iArr2[i10] != i6) {
                            i10++;
                        }
                    }
                }
                if (c4343n.f14731n < connectionTelemetryConfiguration.f5034e) {
                    return connectionTelemetryConfiguration;
                }
                return null;
            }
            while (i10 < iArr.length) {
                if (iArr[i10] == i6) {
                    if (c4343n.f14731n < connectionTelemetryConfiguration.f5034e) {
                        return connectionTelemetryConfiguration;
                    }
                    return null;
                }
                i10++;
            }
        }
        return null;
    }

    @Override
    public final void mo3998b(C3477d c3477d) {
        int i6;
        int i10;
        int i11;
        int i12;
        int i13;
        long j10;
        long j11;
        int iElapsedRealtime;
        C4334e c4334e = this.f14736a;
        if (c4334e.m8360a()) {
            RootTelemetryConfiguration rootTelemetryConfiguration = (RootTelemetryConfiguration) C1304d.m3176b().f4084a;
            if (rootTelemetryConfiguration == null || rootTelemetryConfiguration.f5062b) {
                C4343n c4343n = (C4343n) c4334e.f14707j.get(this.f14738c);
                if (c4343n != null) {
                    InterfaceC4255c interfaceC4255c = c4343n.f14721d;
                    if (interfaceC4255c instanceof AbstractC1500a) {
                        AbstractC1500a abstractC1500a = (AbstractC1500a) interfaceC4255c;
                        long j12 = this.f14739d;
                        boolean z7 = j12 > 0;
                        int i14 = abstractC1500a.f5085q;
                        if (rootTelemetryConfiguration != null) {
                            z7 &= rootTelemetryConfiguration.f5063c;
                            boolean z10 = abstractC1500a.f5090v != null;
                            int i15 = rootTelemetryConfiguration.f5064d;
                            i11 = rootTelemetryConfiguration.f5061a;
                            if (!z10 || abstractC1500a.mo3652e()) {
                                i6 = rootTelemetryConfiguration.f5065e;
                            } else {
                                ConnectionTelemetryConfiguration connectionTelemetryConfigurationM8389a = m8389a(c4343n, abstractC1500a, this.f14737b);
                                if (connectionTelemetryConfigurationM8389a == null) {
                                    return;
                                }
                                boolean z11 = connectionTelemetryConfigurationM8389a.f5032c && j12 > 0;
                                i6 = connectionTelemetryConfigurationM8389a.f5034e;
                                z7 = z11;
                            }
                            i10 = i15;
                        } else {
                            i6 = 100;
                            i10 = 5000;
                            i11 = 0;
                        }
                        if (c3477d.m7132e()) {
                            i12 = 0;
                            i13 = 0;
                        } else {
                            Exception excM7130c = c3477d.m7130c();
                            if (excM7130c instanceof C4257e) {
                                Status status = ((C4257e) excM7130c).f14453a;
                                i12 = status.f4994a;
                                ConnectionResult connectionResult = status.f4997d;
                                if (connectionResult != null) {
                                    i13 = connectionResult.f4971b;
                                }
                            } else {
                                i12 = 101;
                            }
                            i13 = -1;
                        }
                        if (z7) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            j10 = j12;
                            iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.f14740e);
                            j11 = jCurrentTimeMillis;
                        } else {
                            j10 = 0;
                            j11 = 0;
                            iElapsedRealtime = -1;
                        }
                        C4348s c4348s = new C4348s(new MethodInvocation(this.f14737b, i12, i13, j10, j11, null, null, i14, iElapsedRealtime), i11, i10, i6);
                        HandlerC1731y0 handlerC1731y0 = c4334e.f14710m;
                        handlerC1731y0.sendMessage(handlerC1731y0.obtainMessage(18, c4348s));
                    }
                }
            }
        }
    }
}
