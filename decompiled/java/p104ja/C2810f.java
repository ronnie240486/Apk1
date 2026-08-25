package p104ja;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.bitspark.android.beans.Menu;
import p156o9.AbstractC3281e;
import p237w0.AbstractC4044e;

public final class C2810f extends AbstractC4044e {

    public final LinearLayout f9558l;

    public Menu f9559m;

    public final TextView f9560n;

    public long f9561o;

    public C2810f(View view) {
        super(null, 0, view);
        Object[] objArrM8047R = AbstractC4044e.m8047R(view, 2, null);
        LinearLayout linearLayout = (LinearLayout) objArrM8047R[0];
        this.f9558l = linearLayout;
        this.f9561o = -1L;
        this.f9558l.setTag(null);
        TextView textView = (TextView) objArrM8047R[1];
        this.f9560n = textView;
        textView.setTag(null);
        m8049T(view);
        synchronized (this) {
            this.f9561o = 2L;
        }
        m8048S();
    }

    @Override
    public final void mo5800O() {
        long j10;
        synchronized (this) {
            j10 = this.f9561o;
            this.f9561o = 0L;
        }
        Menu menu = this.f9559m;
        long j11 = j10 & 3;
        String name = (j11 == 0 || menu == null) ? null : menu.getName();
        if (j11 != 0) {
            AbstractC3281e.m6612H(this.f9560n, name);
        }
    }

    @Override
    public final boolean mo5801P() {
        synchronized (this) {
            try {
                return this.f9561o != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m5802U(Menu menu) {
        this.f9559m = menu;
        synchronized (this) {
            this.f9561o |= 1;
        }
        m173G();
        m8048S();
    }
}
