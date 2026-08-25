package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

public final class C0430t0 extends Writer {

    public final StringBuilder f1997b = new StringBuilder(128);

    public final String f1996a = "FragmentManager";

    public final void m1335a() {
        StringBuilder sb = this.f1997b;
        if (sb.length() > 0) {
            Log.d(this.f1996a, sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override
    public final void close() {
        m1335a();
    }

    @Override
    public final void flush() {
        m1335a();
    }

    @Override
    public final void write(char[] cArr, int i6, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            char c5 = cArr[i6 + i11];
            if (c5 == '\n') {
                m1335a();
            } else {
                this.f1997b.append(c5);
            }
        }
    }
}
