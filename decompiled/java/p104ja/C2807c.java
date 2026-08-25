package p104ja;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.bitspark.android.beans.SettingBean;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2796i;
import p156o9.AbstractC3281e;
import p237w0.AbstractC4044e;

public final class C2807c extends AbstractC4044e {

    public final ImageView f9546l;

    public SettingBean f9547m;

    public final TextView f9548n;

    public long f9549o;

    public C2807c(View view) {
        super(null, 0, view);
        Object[] objArrM8047R = AbstractC4044e.m8047R(view, 3, null);
        ImageView imageView = (ImageView) objArrM8047R[1];
        this.f9546l = imageView;
        this.f9549o = -1L;
        this.f9546l.setTag(null);
        ((LinearLayout) objArrM8047R[0]).setTag(null);
        TextView textView = (TextView) objArrM8047R[2];
        this.f9548n = textView;
        textView.setTag(null);
        m8049T(view);
        synchronized (this) {
            this.f9549o = 2L;
        }
        m8048S();
    }

    @Override
    public final void mo5800O() {
        long j10;
        String name;
        int icon;
        synchronized (this) {
            j10 = this.f9549o;
            this.f9549o = 0L;
        }
        SettingBean settingBean = this.f9547m;
        long j11 = j10 & 3;
        if (j11 == 0 || settingBean == null) {
            name = null;
            icon = 0;
        } else {
            name = settingBean.getName();
            icon = settingBean.getIcon();
        }
        if (j11 != 0) {
            ImageView imageView = this.f9546l;
            AbstractC2796i.m5785f(imageView, AbstractC0032a.m165s("idh9kIi2WlWX\n", "4LUc9+3gMzA=\n"));
            if (icon != 0) {
                try {
                    imageView.setImageResource(icon);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            AbstractC3281e.m6612H(this.f9548n, name);
        }
    }

    @Override
    public final boolean mo5801P() {
        synchronized (this) {
            try {
                return this.f9549o != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
