package p104ja;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.bitspark.android.beans.SubtitleMenu;
import p156o9.AbstractC3281e;
import p237w0.AbstractC4044e;

public final class C2809e extends AbstractC4044e {

    public final LinearLayout f9554l;

    public SubtitleMenu f9555m;

    public final TextView f9556n;

    public long f9557o;

    public C2809e(View view) {
        super(null, 0, view);
        Object[] objArrM8047R = AbstractC4044e.m8047R(view, 2, null);
        LinearLayout linearLayout = (LinearLayout) objArrM8047R[0];
        this.f9554l = linearLayout;
        this.f9557o = -1L;
        this.f9554l.setTag(null);
        TextView textView = (TextView) objArrM8047R[1];
        this.f9556n = textView;
        textView.setTag(null);
        m8049T(view);
        synchronized (this) {
            this.f9557o = 2L;
        }
        m8048S();
    }

    @Override
    public final void mo5800O() {
        long j10;
        synchronized (this) {
            j10 = this.f9557o;
            this.f9557o = 0L;
        }
        SubtitleMenu subtitleMenu = this.f9555m;
        long j11 = j10 & 3;
        String language = (j11 == 0 || subtitleMenu == null) ? null : subtitleMenu.getLanguage();
        if (j11 != 0) {
            AbstractC3281e.m6612H(this.f9556n, language);
        }
    }

    @Override
    public final boolean mo5801P() {
        synchronized (this) {
            try {
                return this.f9557o != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
