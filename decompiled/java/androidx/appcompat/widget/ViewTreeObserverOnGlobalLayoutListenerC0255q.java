package androidx.appcompat.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.internal.C1832r;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p105k.C2830e;
import p105k.InterfaceC2850x;
import p105k.ViewOnKeyListenerC2829d0;
import p105k.ViewOnKeyListenerC2832f;
import p138n0.AbstractC3106c;
import p138n0.AbstractC3155s0;

public final class ViewTreeObserverOnGlobalLayoutListenerC0255q implements ViewTreeObserver.OnGlobalLayoutListener {

    public final int f1030a;

    public final Object f1031b;

    public ViewTreeObserverOnGlobalLayoutListenerC0255q(int i6, Object obj) {
        this.f1030a = i6;
        this.f1031b = obj;
    }

    @Override
    public final void onGlobalLayout() {
        C0225k c0225k;
        InterfaceC2850x interfaceC2850x;
        Activity activity;
        boolean z7 = false;
        Object obj = this.f1031b;
        switch (this.f1030a) {
            case 0:
                ActivityChooserView activityChooserView = (ActivityChooserView) obj;
                if (activityChooserView.m565b()) {
                    if (!activityChooserView.isShown()) {
                        activityChooserView.getListPopupWindow().dismiss();
                        break;
                    } else {
                        activityChooserView.getListPopupWindow().mo576a();
                        AbstractC3106c abstractC3106c = activityChooserView.f599g;
                        if (abstractC3106c != null && (c0225k = abstractC3106c.f10578a) != null && (interfaceC2850x = c0225k.f9613e) != null) {
                            interfaceC2850x.mo90f(c0225k.f9611c);
                            break;
                        }
                    }
                }
                break;
            case 1:
                AppCompatSpinner appCompatSpinner = (AppCompatSpinner) obj;
                if (!appCompatSpinner.getInternalPopup().mo689c()) {
                    appCompatSpinner.f648f.mo697n(AbstractC0206g0.m671b(appCompatSpinner), AbstractC0206g0.m670a(appCompatSpinner));
                }
                ViewTreeObserver viewTreeObserver = appCompatSpinner.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    AbstractC0201f0.m660a(viewTreeObserver, this);
                }
                break;
            case 2:
                C0236m0 c0236m0 = (C0236m0) obj;
                AppCompatSpinner appCompatSpinner2 = c0236m0.f1007G;
                c0236m0.getClass();
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                if (appCompatSpinner2.isAttachedToWindow() && appCompatSpinner2.getGlobalVisibleRect(c0236m0.f1005E)) {
                    c0236m0.m734s();
                    c0236m0.mo576a();
                } else {
                    c0236m0.dismiss();
                }
                break;
            case 3:
                NavigationView navigationView = (NavigationView) obj;
                navigationView.getLocationOnScreen(navigationView.f6508i);
                boolean z10 = navigationView.f6508i[1] == 0;
                C1832r c1832r = navigationView.f6506g;
                if (c1832r.f6471v != z10) {
                    c1832r.f6471v = z10;
                    int i6 = (c1832r.f6451b.getChildCount() == 0 && c1832r.f6471v) ? c1832r.f6473x : 0;
                    NavigationMenuView navigationMenuView = c1832r.f6450a;
                    navigationMenuView.setPadding(0, i6, 0, navigationMenuView.getPaddingBottom());
                }
                navigationView.setDrawTopInsetForeground(z10 && navigationView.f6511l);
                Context context = navigationView.getContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        activity = null;
                    } else if (context instanceof Activity) {
                        activity = (Activity) context;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
                if (activity != null) {
                    boolean z11 = activity.findViewById(R.id.content).getHeight() == navigationView.getHeight();
                    boolean z12 = Color.alpha(activity.getWindow().getNavigationBarColor()) != 0;
                    if (z11 && z12 && navigationView.f6512m) {
                        z7 = true;
                    }
                    navigationView.setDrawBottomInsetForeground(z7);
                }
                break;
            case 4:
                ViewOnKeyListenerC2832f viewOnKeyListenerC2832f = (ViewOnKeyListenerC2832f) obj;
                if (viewOnKeyListenerC2832f.mo578c()) {
                    ArrayList arrayList = viewOnKeyListenerC2832f.f9653h;
                    if (arrayList.size() > 0 && !((C2830e) arrayList.get(0)).f9642a.f714x) {
                        View view = viewOnKeyListenerC2832f.f9660o;
                        if (view != null && view.isShown()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((C2830e) it.next()).f9642a.mo576a();
                            }
                        } else {
                            viewOnKeyListenerC2832f.dismiss();
                        }
                        break;
                    }
                }
                break;
            default:
                ViewOnKeyListenerC2829d0 viewOnKeyListenerC2829d0 = (ViewOnKeyListenerC2829d0) obj;
                if (viewOnKeyListenerC2829d0.mo578c()) {
                    C0218i2 c0218i2 = viewOnKeyListenerC2829d0.f9629h;
                    if (!c0218i2.f714x) {
                        View view2 = viewOnKeyListenerC2829d0.f9634m;
                        if (view2 != null && view2.isShown()) {
                            c0218i2.mo576a();
                        } else {
                            viewOnKeyListenerC2829d0.dismiss();
                        }
                    }
                }
                break;
        }
    }
}
