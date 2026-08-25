package p166p5;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

public final class CallableC3372a implements Callable {

    public final int f11397a;

    public final SharedPreferences f11398b;

    public final String f11399c;

    public final Object f11400d;

    public CallableC3372a(SharedPreferences sharedPreferences, String str, Object obj, int i6) {
        this.f11397a = i6;
        this.f11398b = sharedPreferences;
        this.f11399c = str;
        this.f11400d = obj;
    }

    @Override
    public final Object call() {
        switch (this.f11397a) {
            case 0:
                return Boolean.valueOf(this.f11398b.getBoolean(this.f11399c, ((Boolean) this.f11400d).booleanValue()));
            case 1:
                return Integer.valueOf(this.f11398b.getInt(this.f11399c, ((Integer) this.f11400d).intValue()));
            case 2:
                return Long.valueOf(this.f11398b.getLong(this.f11399c, ((Long) this.f11400d).longValue()));
            default:
                return this.f11398b.getString(this.f11399c, (String) this.f11400d);
        }
    }
}
