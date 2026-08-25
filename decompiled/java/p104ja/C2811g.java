package p104ja;

import android.view.View;
import android.widget.TextView;
import p156o9.AbstractC3281e;
import p237w0.AbstractC4044e;

public final class C2811g extends AbstractC4044e {

    public final TextView f9562l;

    public String f9563m;

    public long f9564n;

    public C2811g(View view, TextView textView) {
        super(null, 0, view);
        this.f9562l = textView;
    }

    @Override
    public final void mo5800O() {
        long j10;
        synchronized (this) {
            j10 = this.f9564n;
            this.f9564n = 0L;
        }
        String str = this.f9563m;
        if ((j10 & 3) != 0) {
            AbstractC3281e.m6612H(this.f9562l, str);
        }
    }

    @Override
    public final boolean mo5801P() {
        synchronized (this) {
            try {
                return this.f9564n != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
