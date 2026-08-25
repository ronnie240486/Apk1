package p173q1;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import androidx.drawerlayout.widget.C0390b;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.material.internal.ViewOnAttachStateChangeListenerC1815c0;
import java.lang.ref.ReferenceQueue;
import java.net.DatagramSocket;
import p001a0.C0023f;
import p028c6.C1399b;
import p187r4.C3624n;
import p199s4.C3716j;
import p226v0.C3968d;
import p230v4.C4000n;
import p237w0.AbstractC4044e;
import p247x2.C4078a;
import p261y4.InterfaceC4255c;
import p271z4.AbstractDialogInterfaceOnCancelListenerC4341l;
import p271z4.BinderC4352w;
import p271z4.C4343n;

public final class RunnableC3431n1 implements Runnable {

    public final int f11597a;

    public final Object f11598b;

    public RunnableC3431n1(int i6, Object obj) {
        this.f11597a = i6;
        this.f11598b = obj;
    }

    private final void m7008a() {
        synchronized (this) {
            ((AbstractC4044e) this.f11598b).f13697c = false;
        }
        while (AbstractC4044e.f13694j.poll() != null) {
        }
        if (!((AbstractC4044e) this.f11598b).f13698d.isAttachedToWindow()) {
            View view = ((AbstractC4044e) this.f11598b).f13698d;
            ViewOnAttachStateChangeListenerC1815c0 viewOnAttachStateChangeListenerC1815c0 = AbstractC4044e.f13695k;
            view.removeOnAttachStateChangeListener(viewOnAttachStateChangeListenerC1815c0);
            ((AbstractC4044e) this.f11598b).f13698d.addOnAttachStateChangeListener(viewOnAttachStateChangeListenerC1815c0);
            return;
        }
        AbstractC4044e abstractC4044e = (AbstractC4044e) this.f11598b;
        if (abstractC4044e.f13699e) {
            abstractC4044e.m8048S();
        } else if (abstractC4044e.mo5801P()) {
            abstractC4044e.f13699e = true;
            abstractC4044e.mo5800O();
            abstractC4044e.f13699e = false;
        }
    }

    @Override
    public final void run() {
        View viewM1168d;
        int width;
        switch (this.f11597a) {
            case 0:
                ((C3434o1) this.f11598b).m7009a();
                return;
            case 1:
                ((C3716j) this.f11598b).m7478g(false);
                return;
            case 2:
                ((CastSeekBar) this.f11598b).sendAccessibilityEvent(4);
                return;
            case 3:
                ((C3968d) this.f11598b).m7961p(0);
                return;
            case 4:
                C4000n c4000n = (C4000n) this.f11598b;
                synchronized (C4000n.f13548i) {
                    try {
                        if (c4000n.m7995d()) {
                            c4000n.m7997f(15);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            case 5:
                DatagramSocket datagramSocket = (DatagramSocket) this.f11598b;
                try {
                    datagramSocket.disconnect();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                try {
                    datagramSocket.close();
                    return;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return;
                }
            case 6:
                m7008a();
                return;
            case 7:
                C0023f c0023f = (C0023f) this.f11598b;
                c0023f.getClass();
                while (true) {
                    try {
                        c0023f.m104d((C4078a) ((ReferenceQueue) c0023f.f46d).remove());
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                break;
            case 8:
                C0390b c0390b = (C0390b) this.f11598b;
                int i6 = c0390b.f1747d.f13492o;
                int i10 = c0390b.f1746c;
                boolean z7 = i10 == 3;
                DrawerLayout drawerLayout = c0390b.f1749f;
                if (z7) {
                    viewM1168d = drawerLayout.m1168d(3);
                    width = (viewM1168d != null ? -viewM1168d.getWidth() : 0) + i6;
                } else {
                    viewM1168d = drawerLayout.m1168d(5);
                    width = drawerLayout.getWidth() - i6;
                }
                if (viewM1168d != null) {
                    if (((!z7 || viewM1168d.getLeft() >= width) && (z7 || viewM1168d.getLeft() <= width)) || drawerLayout.m1171g(viewM1168d) != 0) {
                        return;
                    }
                    DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) viewM1168d.getLayoutParams();
                    c0390b.f1747d.m7964s(viewM1168d, width, viewM1168d.getTop());
                    layoutParams.f1739c = true;
                    drawerLayout.invalidate();
                    View viewM1168d2 = drawerLayout.m1168d(i10 == 3 ? 5 : 3);
                    if (viewM1168d2 != null) {
                        drawerLayout.m1166b(viewM1168d2);
                    }
                    if (drawerLayout.f1728r) {
                        return;
                    }
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    int childCount = drawerLayout.getChildCount();
                    for (int i11 = 0; i11 < childCount; i11++) {
                        drawerLayout.getChildAt(i11).dispatchTouchEvent(motionEventObtain);
                    }
                    motionEventObtain.recycle();
                    drawerLayout.f1728r = true;
                    return;
                }
                return;
            case 9:
                ((C4343n) this.f11598b).m8372f();
                return;
            case 10:
                InterfaceC4255c interfaceC4255c = ((C4343n) ((C3624n) this.f11598b).f12182b).f14721d;
                interfaceC4255c.mo3651c(interfaceC4255c.getClass().getName().concat(" disconnecting because it was signed out."));
                return;
            case 11:
                ((BinderC4352w) this.f11598b).f14758j.m52e(new ConnectionResult(4));
                return;
            default:
                throw null;
        }
    }

    public RunnableC3431n1(AbstractDialogInterfaceOnCancelListenerC4341l abstractDialogInterfaceOnCancelListenerC4341l, C1399b c1399b) {
        this.f11597a = 12;
        this.f11598b = c1399b;
    }
}
