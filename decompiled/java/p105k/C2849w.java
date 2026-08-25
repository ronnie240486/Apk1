package p105k;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;

public class C2849w {

    public final Context f9755a;

    public final MenuC2838l f9756b;

    public final boolean f9757c;

    public final int f9758d;

    public View f9759e;

    public boolean f9761g;

    public InterfaceC2850x f9762h;

    public AbstractC2846t f9763i;

    public C2847u f9764j;

    public int f9760f = 8388611;

    public final C2847u f9765k = new C2847u(this);

    public C2849w(int i6, Context context, View view, MenuC2838l menuC2838l, boolean z7) {
        this.f9755a = context;
        this.f9756b = menuC2838l;
        this.f9759e = view;
        this.f9757c = z7;
        this.f9758d = i6;
    }

    public final AbstractC2846t m5854a() {
        AbstractC2846t viewOnKeyListenerC2829d0;
        if (this.f9763i == null) {
            Context context = this.f9755a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            AbstractC2848v.m5853a(defaultDisplay, point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                viewOnKeyListenerC2829d0 = new ViewOnKeyListenerC2832f(context, this.f9759e, this.f9758d, this.f9757c);
            } else {
                View view = this.f9759e;
                Context context2 = this.f9755a;
                boolean z7 = this.f9757c;
                viewOnKeyListenerC2829d0 = new ViewOnKeyListenerC2829d0(this.f9758d, context2, view, this.f9756b, z7);
            }
            viewOnKeyListenerC2829d0.mo5805n(this.f9756b);
            viewOnKeyListenerC2829d0.mo5810t(this.f9765k);
            viewOnKeyListenerC2829d0.mo5806p(this.f9759e);
            viewOnKeyListenerC2829d0.mo5804i(this.f9762h);
            viewOnKeyListenerC2829d0.mo5807q(this.f9761g);
            viewOnKeyListenerC2829d0.mo5808r(this.f9760f);
            this.f9763i = viewOnKeyListenerC2829d0;
        }
        return this.f9763i;
    }

    public final boolean m5855b() {
        AbstractC2846t abstractC2846t = this.f9763i;
        return abstractC2846t != null && abstractC2846t.mo578c();
    }

    public void mo654c() {
        this.f9763i = null;
        C2847u c2847u = this.f9764j;
        if (c2847u != null) {
            c2847u.onDismiss();
        }
    }

    public final void m5856d(int i6, int i10, boolean z7, boolean z10) {
        AbstractC2846t abstractC2846tM5854a = m5854a();
        abstractC2846tM5854a.mo5811u(z10);
        if (z7) {
            int i11 = this.f9760f;
            View view = this.f9759e;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if ((Gravity.getAbsoluteGravity(i11, view.getLayoutDirection()) & 7) == 5) {
                i6 -= this.f9759e.getWidth();
            }
            abstractC2846tM5854a.mo5809s(i6);
            abstractC2846tM5854a.mo5812v(i10);
            int i12 = (int) ((this.f9755a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            abstractC2846tM5854a.f9753a = new Rect(i6 - i12, i10 - i12, i6 + i12, i10 + i12);
        }
        abstractC2846tM5854a.mo576a();
    }
}
