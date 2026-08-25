package p119l1;

import android.content.Context;
import android.os.Process;
import java.util.concurrent.Callable;
import p197s2.C3699c;

public final class CallableC2961b implements Callable {

    public final int f10145a;

    public final Object f10146b;

    public CallableC2961b(int i6, Object obj) {
        this.f10145a = i6;
        this.f10146b = obj;
    }

    @Override
    public final Object call() {
        switch (this.f10145a) {
            case 0:
                RunnableC2960a runnableC2960a = (RunnableC2960a) this.f10146b;
                runnableC2960a.f10143b.set(true);
                try {
                    Process.setThreadPriority(10);
                    throw null;
                } catch (Throwable th) {
                    try {
                        runnableC2960a.f10142a.set(true);
                        throw th;
                    } catch (Throwable th2) {
                        runnableC2960a.m6003a(null);
                        throw th2;
                    }
                }
            case 1:
                return ((Context) this.f10146b).getSharedPreferences("google_sdk_flags", 0);
            default:
                synchronized (((C3699c) this.f10146b)) {
                    try {
                        C3699c c3699c = (C3699c) this.f10146b;
                        if (c3699c.f12398i == null) {
                            return null;
                        }
                        c3699c.m7463n();
                        if (((C3699c) this.f10146b).m7458g()) {
                            ((C3699c) this.f10146b).m7462l();
                            ((C3699c) this.f10146b).f12400k = 0;
                        }
                        return null;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
        }
    }
}
