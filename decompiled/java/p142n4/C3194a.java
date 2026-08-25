package p142n4;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.locks.ReentrantLock;

public final class C3194a {

    public static final ReentrantLock f10748c = new ReentrantLock();

    public static C3194a f10749d;

    public final ReentrantLock f10750a = new ReentrantLock();

    public final SharedPreferences f10751b;

    public C3194a(Context context) {
        this.f10751b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public final String m6419a(String str) {
        ReentrantLock reentrantLock = this.f10750a;
        reentrantLock.lock();
        try {
            return this.f10751b.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }
}
