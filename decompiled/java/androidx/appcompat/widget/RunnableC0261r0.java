package androidx.appcompat.widget;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.InterfaceC0316b;
import androidx.recyclerview.widget.AbstractC1174p1;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.cast.BinderC1703v;
import com.google.android.gms.internal.cast.C1512b0;
import com.google.android.gms.internal.cast.C1523c1;
import com.google.android.gms.internal.cast.C1552f0;
import com.google.android.gms.internal.cast.C1585i3;
import com.google.android.gms.internal.cast.C1661q2;
import com.google.android.gms.internal.cast.C1678s1;
import com.google.android.gms.internal.cast.C1739z;
import com.google.android.gms.internal.cast.RunnableC1502a0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.p2serv.android.p032ds.R;
import ga.C2625h;
import java.util.List;
import na.C3222a;
import org.bitspark.android.beans.ChannelBean;
import p000a.RunnableC0005f;
import p028c6.C1400c;
import p055ea.EnumC2434d;
import p055ea.HandlerC2468u;
import p063fa.C2525g0;
import p109k3.C2888t;
import p116ka.C2924i0;
import p116ka.ViewOnKeyListenerC2932m0;
import p116ka.ViewOnKeyListenerC2937r;
import p156o9.AbstractC3280d;
import p173q1.C3424l0;
import p176q4.C3477d;
import p242w5.AbstractC4057e;
import p242w5.C4056d;
import p242w5.C4058f;
import p242w5.InterfaceC4054b;
import sa.C3741l;

public final class RunnableC0261r0 implements Runnable {

    public final int f1043a;

    public final int f1044b;

    public final Object f1045c;

    public final Object f1046d;

    public RunnableC0261r0(Object obj, int i6, Object obj2, int i10) {
        this.f1043a = i10;
        this.f1046d = obj;
        this.f1044b = i6;
        this.f1045c = obj2;
    }

    private final void m765a() {
        C3477d c3477d;
        C1678s1 c1678s1 = (C1678s1) this.f1045c;
        C1585i3 c1585i3 = (C1585i3) this.f1046d;
        int i6 = this.f1044b;
        C1512b0 c1512b0 = c1678s1.f5611h;
        if (c1512b0 == null) {
            return;
        }
        synchronized (c1512b0) {
            C4056d c4056d = new C4056d();
            C1400c c1400cM3273c = C1400c.m3273c();
            C1523c1 c1523c1 = c1512b0.f5216c;
            c1400cM3273c.f4265c = new C1661q2(c1523c1);
            c1400cM3273c.f4263a = 4501;
            C3477d c3477dM8306c = c1523c1.m8306c(0, c1400cM3273c.m3275b());
            c3477dM8306c.m7129b(new C1739z(c4056d));
            ((C2888t) c3477dM8306c.f11770c).m5891h(new C4058f(AbstractC4057e.f13721a, (InterfaceC4054b) new C1739z(c4056d)));
            c3477dM8306c.m7134g();
            c1512b0.f5215b.postDelayed(new RunnableC1502a0(0, c4056d), c1512b0.f5214a * 1000);
            c3477d = c4056d.f13720a;
        }
        c3477d.m7129b(new C1552f0(c1678s1, i6, c1585i3));
    }

    @Override
    public final void run() {
        RecyclerView recyclerView;
        switch (this.f1043a) {
            case 0:
                ((TextView) this.f1045c).setTypeface((Typeface) this.f1046d, this.f1044b);
                return;
            case 1:
                String[] strArr = (String[]) this.f1045c;
                int[] iArr = new int[strArr.length];
                Activity activity = (Activity) this.f1046d;
                PackageManager packageManager = activity.getPackageManager();
                String packageName = activity.getPackageName();
                int length = strArr.length;
                for (int i6 = 0; i6 < length; i6++) {
                    iArr[i6] = packageManager.checkPermission(strArr[i6], packageName);
                }
                ((InterfaceC0316b) activity).onRequestPermissionsResult(this.f1044b, strArr, iArr);
                return;
            case 2:
                ((BottomSheetBehavior) this.f1046d).m4127D((View) this.f1045c, this.f1044b, false);
                return;
            case 3:
                BinderC1703v binderC1703v = (BinderC1703v) this.f1045c;
                C3424l0 c3424l0 = (C3424l0) this.f1046d;
                int i10 = this.f1044b;
                synchronized (binderC1703v.f5694g) {
                    binderC1703v.m4031z(c3424l0, i10);
                    break;
                }
                return;
            case 4:
                m765a();
                return;
            case 5:
                HandlerC2468u handlerC2468u = (HandlerC2468u) this.f1046d;
                handlerC2468u.f8662a.f11054I.m5961h0(EnumC2434d.f8530b);
                ViewOnKeyListenerC2937r viewOnKeyListenerC2937r = handlerC2468u.f8662a.f11054I;
                viewOnKeyListenerC2937r.f10001X.f8802g = false;
                AbstractC3280d.m6564A(viewOnKeyListenerC2937r.f10000W, viewOnKeyListenerC2937r.f10002Y, this.f1044b);
                ChannelBean channelBean = (ChannelBean) ((View) this.f1045c).getTag();
                if (channelBean != null) {
                    handlerC2468u.f8662a.f11054I.m5960g0(C2625h.m5631d(channelBean));
                    return;
                }
                return;
            case 6:
                int size = ((List) this.f1045c).size();
                ViewOnKeyListenerC2937r viewOnKeyListenerC2937r2 = (ViewOnKeyListenerC2937r) this.f1046d;
                int i11 = this.f1044b;
                if (i11 < size) {
                    AbstractC1174p1 abstractC1174p1FindViewHolderForAdapterPosition = viewOnKeyListenerC2937r2.f10000W.findViewHolderForAdapterPosition(i11);
                    if (abstractC1174p1FindViewHolderForAdapterPosition != null) {
                        AbstractC3280d.m6606y(abstractC1174p1FindViewHolderForAdapterPosition.itemView);
                        return;
                    }
                    return;
                }
                if (i11 > 0) {
                    AbstractC1174p1 abstractC1174p1FindViewHolderForAdapterPosition2 = viewOnKeyListenerC2937r2.f10000W.findViewHolderForAdapterPosition(i11 - 1);
                    if (abstractC1174p1FindViewHolderForAdapterPosition2 != null) {
                        AbstractC3280d.m6606y(abstractC1174p1FindViewHolderForAdapterPosition2.itemView);
                        return;
                    }
                    return;
                }
                if (viewOnKeyListenerC2937r2.f9999V != null) {
                    C2525g0 c2525g0 = viewOnKeyListenerC2937r2.f10001X;
                    if (c2525g0 != null) {
                        AbstractC3280d.m6606y(c2525g0.f8800e);
                    }
                    viewOnKeyListenerC2937r2.m5961h0(EnumC2434d.f8529a);
                    return;
                }
                return;
            case 7:
                C2924i0 c2924i0 = (C2924i0) this.f1046d;
                C3741l c3741l = (C3741l) c2924i0.m1319h().m1184k().m1264z((String) this.f1045c);
                if (c3741l != null && (recyclerView = c3741l.f12540U) != null) {
                    AbstractC3280d.m6607z(recyclerView, this.f1044b);
                }
                View currentFocus = c2924i0.m1319h().getCurrentFocus();
                if (currentFocus == null || R.id.root != currentFocus.getId()) {
                    return;
                }
                c2924i0.f9920d0.postDelayed(new RunnableC0005f(23, this), 300L);
                return;
            case 8:
                int i12 = this.f1044b;
                ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m0 = (ViewOnKeyListenerC2932m0) this.f1046d;
                RecyclerView recyclerView2 = (RecyclerView) this.f1045c;
                ViewOnKeyListenerC2932m0.m5927Q(viewOnKeyListenerC2932m0, recyclerView2, i12, i12);
                AbstractC3280d.m6606y(recyclerView2);
                return;
            default:
                Message message = new Message();
                message.what = this.f1044b;
                message.obj = (View) this.f1045c;
                ((C3222a) this.f1046d).f10824a.f11200o.sendMessage(message);
                return;
        }
    }

    public RunnableC0261r0(Object obj, Object obj2, int i6, int i10) {
        this.f1043a = i10;
        this.f1045c = obj;
        this.f1046d = obj2;
        this.f1044b = i6;
    }

    public RunnableC0261r0(Object obj, Object obj2, int i6, int i10, boolean z7) {
        this.f1043a = i10;
        this.f1046d = obj;
        this.f1045c = obj2;
        this.f1044b = i6;
    }
}
