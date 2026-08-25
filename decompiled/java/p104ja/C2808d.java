package p104ja;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.bitspark.android.beans.Source;
import p156o9.AbstractC3281e;
import p237w0.AbstractC4044e;

public final class C2808d extends AbstractC4044e {

    public final LinearLayout f9550l;

    public Source f9551m;

    public final TextView f9552n;

    public long f9553o;

    public C2808d(View view) {
        super(null, 0, view);
        Object[] objArrM8047R = AbstractC4044e.m8047R(view, 2, null);
        LinearLayout linearLayout = (LinearLayout) objArrM8047R[0];
        this.f9550l = linearLayout;
        this.f9553o = -1L;
        this.f9550l.setTag(null);
        TextView textView = (TextView) objArrM8047R[1];
        this.f9552n = textView;
        textView.setTag(null);
        m8049T(view);
        synchronized (this) {
            this.f9553o = 2L;
        }
        m8048S();
    }

    @Override
    public final void mo5800O() {
        long j10;
        synchronized (this) {
            j10 = this.f9553o;
            this.f9553o = 0L;
        }
        Source source = this.f9551m;
        long j11 = j10 & 3;
        String short_title = (j11 == 0 || source == null) ? null : source.getShort_title();
        if (j11 != 0) {
            AbstractC3281e.m6612H(this.f9552n, short_title);
        }
    }

    @Override
    public final boolean mo5801P() {
        synchronized (this) {
            try {
                return this.f9553o != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
