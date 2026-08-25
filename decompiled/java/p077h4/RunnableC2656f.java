package p077h4;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.media3.common.C0605n;
import androidx.media3.common.C0628x;
import java.util.Objects;
import p005a4.C0051j;
import p087i4.C2702g;
import p087i4.InterfaceC2699d;
import p098j4.C2774a;
import p098j4.InterfaceC2776c;

public final class RunnableC2656f implements Runnable {

    public final C2659i f9266a;

    public final C0051j f9267b;

    public final int f9268c;

    public final Runnable f9269d;

    public RunnableC2656f(C2659i c2659i, C0051j c0051j, int i6, Runnable runnable) {
        this.f9266a = c2659i;
        this.f9267b = c0051j;
        this.f9268c = i6;
        this.f9269d = runnable;
    }

    @Override
    public final void run() {
        C0051j c0051j = this.f9267b;
        int i6 = this.f9268c;
        Runnable runnable = this.f9269d;
        C2659i c2659i = this.f9266a;
        InterfaceC2776c interfaceC2776c = c2659i.f9282f;
        try {
            try {
                InterfaceC2699d interfaceC2699d = c2659i.f9279c;
                Objects.requireNonNull(interfaceC2699d);
                ((C2702g) interfaceC2776c).m5700e(new C0628x(12, interfaceC2699d));
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) c2659i.f9277a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    ((C2702g) interfaceC2776c).m5700e(new C0605n(c2659i, c0051j, i6, 2));
                } else {
                    c2659i.m5669a(c0051j, i6);
                }
            } catch (C2774a unused) {
                c2659i.f9280d.m5668a(c0051j, i6 + 1, false);
            }
        } finally {
            runnable.run();
        }
    }
}
