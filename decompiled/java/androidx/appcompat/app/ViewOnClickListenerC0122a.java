package androidx.appcompat.app;

import android.os.Bundle;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.C0259q3;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.AbstractComponentCallbacksC0427s;
import androidx.fragment.app.C0391a;
import androidx.fragment.app.C0412k0;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0415m;
import com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity;
import com.google.android.material.datepicker.C1801r;
import com.google.android.material.internal.C1824j;
import com.google.android.material.internal.C1832r;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.navigation.AbstractC1844d;
import com.google.android.material.navigation.AbstractC1846f;
import com.google.android.material.textfield.C1867e;
import com.google.android.material.textfield.C1875m;
import com.google.android.material.textfield.C1879q;
import com.google.android.material.textfield.TextInputLayout;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import com.tvbus.engine.TVCore;
import io.binstream.libtvcar.Libtvcar;
import la.C3014a;
import la.RunnableC3015b;
import la.ViewOnClickListenerC3017d;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p018b5.AbstractC1312l;
import p063fa.AbstractC2548o;
import p063fa.AbstractC2562u;
import p063fa.C2509b;
import p063fa.C2529h1;
import p063fa.C2535j1;
import p082ha.AbstractC2675a;
import p093j.AbstractC2740a;
import p105k.C2840n;
import p116ka.C2923i;
import p116ka.RunnableC2942w;
import p116ka.ViewOnKeyListenerC2925j;
import p116ka.ViewOnKeyListenerC2944y;
import p187r4.C3616f;
import p187r4.C3618h;
import p209t3.AbstractC3806c;
import p222u7.AbstractC3928d;
import p249x4.C4112e;
import sa.C3736g;
import sa.C3745p;
import sa.DialogC3734e;

public final class ViewOnClickListenerC0122a implements View.OnClickListener {

    public final int f255a;

    public final Object f256b;

    public ViewOnClickListenerC0122a(int i6, Object obj) {
        this.f255a = i6;
        this.f256b = obj;
    }

    @Override
    public final void onClick(View view) {
        C3616f c3616fM3628p;
        int i6 = 0;
        int i10 = 1;
        Object obj = this.f256b;
        switch (this.f255a) {
            case 0:
                C0136h c0136h = (C0136h) obj;
                Button button = c0136h.f364h;
                c0136h.f380x.obtainMessage(1, c0136h.f358b).sendToTarget();
                break;
            case 1:
                ((AbstractC2740a) obj).mo473a();
                break;
            case 2:
                C0259q3 c0259q3 = ((Toolbar) obj).f819M;
                C2840n c2840n = c0259q3 != null ? c0259q3.f1041b : null;
                if (c2840n != null) {
                    c2840n.collapseActionView();
                }
                break;
            case 3:
                C1801r c1801r = (C1801r) obj;
                int i11 = c1801r.f6203Y;
                if (i11 == 2) {
                    c1801r.m4201S(1);
                } else if (i11 == 1) {
                    c1801r.m4201S(2);
                }
                break;
            case 4:
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
                C1832r c1832r = (C1832r) obj;
                C1824j c1824j = c1832r.f6454e;
                if (c1824j != null) {
                    c1824j.f6442c = true;
                }
                C2840n itemData = navigationMenuItemView.getItemData();
                boolean zM5832q = c1832r.f6452c.m5832q(itemData, c1832r, 0);
                if (itemData != null && itemData.isCheckable() && zM5832q) {
                    c1832r.f6454e.m4278b(itemData);
                } else {
                    i10 = 0;
                }
                C1824j c1824j2 = c1832r.f6454e;
                if (c1824j2 != null) {
                    c1824j2.f6442c = false;
                }
                if (i10 != 0) {
                    c1832r.mo712j(false);
                }
                break;
            case 5:
                C2840n itemData2 = ((AbstractC1844d) view).getItemData();
                AbstractC1846f abstractC1846f = (AbstractC1846f) obj;
                if (!abstractC1846f.f6556B.m5832q(itemData2, abstractC1846f.f6555A, 0)) {
                    itemData2.setChecked(true);
                }
                break;
            case 6:
                C1867e c1867e = (C1867e) obj;
                Editable text = c1867e.f6867a.getEditText().getText();
                if (text != null) {
                    text.clear();
                }
                TextInputLayout textInputLayout = c1867e.f6867a;
                AbstractC3928d.m7859x(textInputLayout, textInputLayout.f6781f0, textInputLayout.f6785h0);
                break;
            case 7:
                C1875m c1875m = (C1875m) obj;
                C1875m.m4386d(c1875m, (AutoCompleteTextView) c1875m.f6867a.getEditText());
                break;
            case 8:
                C1879q c1879q = (C1879q) obj;
                EditText editText = c1879q.f6867a.getEditText();
                if (editText != null) {
                    int selectionEnd = editText.getSelectionEnd();
                    if (C1879q.m4403d(c1879q)) {
                        editText.setTransformationMethod(null);
                    } else {
                        editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                    if (selectionEnd >= 0) {
                        editText.setSelection(selectionEnd);
                    }
                    TextInputLayout textInputLayout2 = c1879q.f6867a;
                    AbstractC3928d.m7859x(textInputLayout2, textInputLayout2.f6781f0, textInputLayout2.f6785h0);
                    break;
                }
                break;
            case 9:
                C2509b c2509b = (C2509b) obj;
                c2509b.notifyItemChanged(c2509b.f8875b);
                c2509b.f8877d = c2509b.f8878e.getChildLayoutPosition(view);
                c2509b.f8875b = c2509b.f8878e.getChildLayoutPosition(view);
                c2509b.notifyItemChanged(c2509b.f8875b);
                break;
            case 10:
                String str = AbstractC2548o.f8873i;
                String strM165s = AbstractC0032a.m165s("1Bjc+zRk4C7UGNz0O2v9fIdmja9qMg==\n", "6SXhxglZ3RM=\n");
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(str, strM165s);
                AbstractC2548o abstractC2548o = (AbstractC2548o) obj;
                if (abstractC2548o.f8878e.findViewHolderForAdapterPosition(abstractC2548o.f8875b) != null && abstractC2548o.f8878e.findViewHolderForAdapterPosition(abstractC2548o.f8875b).itemView != null) {
                    abstractC2548o.f8878e.findViewHolderForAdapterPosition(abstractC2548o.f8875b).itemView.performClick();
                    break;
                }
                break;
            case 11:
                String str2 = AbstractC2562u.f8911e;
                String strM165s2 = AbstractC0032a.m165s("D8Fb35WTtqwPwVvQmpyr/ly/CovLxQ==\n", "Mvxm4qiui5E=\n");
                boolean z10 = AbstractC3331m.f11244b;
                Log.m5049i(str2, strM165s2);
                AbstractC2562u abstractC2562u = (AbstractC2562u) obj;
                if (abstractC2562u.f8916d.findViewHolderForAdapterPosition(abstractC2562u.f8914b) != null && abstractC2562u.f8916d.findViewHolderForAdapterPosition(abstractC2562u.f8914b).itemView != null) {
                    abstractC2562u.f8916d.findViewHolderForAdapterPosition(abstractC2562u.f8914b).itemView.performClick();
                    AbstractC2562u.f8912f = 1;
                    break;
                }
                break;
            case 12:
                C2529h1 c2529h1 = (C2529h1) obj;
                c2529h1.notifyItemChanged(c2529h1.f8884a);
                c2529h1.f8885b = c2529h1.f8886c.getChildLayoutPosition(view);
                c2529h1.f8884a = c2529h1.f8886c.getChildLayoutPosition(view);
                c2529h1.notifyItemChanged(c2529h1.f8884a);
                break;
            case 13:
                C2535j1 c2535j1 = (C2535j1) obj;
                c2535j1.notifyItemChanged(c2535j1.f8884a);
                c2535j1.f8885b = c2535j1.f8886c.getChildLayoutPosition(view);
                c2535j1.f8884a = c2535j1.f8886c.getChildLayoutPosition(view);
                c2535j1.notifyItemChanged(c2535j1.f8884a);
                break;
            case 14:
                ViewOnKeyListenerC2925j viewOnKeyListenerC2925j = ((C2923i) obj).f9910a;
                viewOnKeyListenerC2925j.m5922R(viewOnKeyListenerC2925j.f9928W);
                break;
            case 15:
                ViewOnKeyListenerC2944y viewOnKeyListenerC2944y = (ViewOnKeyListenerC2944y) obj;
                viewOnKeyListenerC2944y.f10098r1 = null;
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427sM1264z = viewOnKeyListenerC2944y.m1319h().m1184k().m1264z(AbstractC0032a.m165s("LKsiaJtYxGARvA9rmQ==\n", "eN1jBP4qsCQ=\n"));
                if (abstractComponentCallbacksC0427sM1264z != null) {
                    ((DialogInterfaceOnCancelListenerC0415m) abstractComponentCallbacksC0427sM1264z).m1274Q(true, false);
                    C0412k0 c0412k0M1184k = viewOnKeyListenerC2944y.m1319h().m1184k();
                    c0412k0M1184k.getClass();
                    C0391a c0391a = new C0391a(c0412k0M1184k);
                    c0391a.m1193h(abstractComponentCallbacksC0427sM1264z);
                    c0391a.m1190e(true);
                    C0412k0 c0412k0M1184k2 = viewOnKeyListenerC2944y.m1319h().m1184k();
                    c0412k0M1184k2.m1259u(true);
                    c0412k0M1184k2.m1217A();
                }
                RunnableC2942w runnableC2942w = new RunnableC2942w(viewOnKeyListenerC2944y, i6);
                RunnableC2942w runnableC2942w2 = new RunnableC2942w(viewOnKeyListenerC2944y, i10);
                String strM1325n = viewOnKeyListenerC2944y.f10096q1 ? viewOnKeyListenerC2944y.m1325n(R.string.network_status_not_good) : viewOnKeyListenerC2944y.m1325n(R.string.network_status_good);
                C3745p c3745p = new C3745p();
                c3745p.f12547k0 = runnableC2942w;
                c3745p.f12548l0 = runnableC2942w2;
                Bundle bundle = new Bundle();
                bundle.putString(C3745p.f12546s0, strM1325n);
                c3745p.m1316O(bundle);
                viewOnKeyListenerC2944y.f10098r1 = c3745p;
                c3745p.f12554r0 = new C4112e(19);
                c3745p.m1276S(viewOnKeyListenerC2944y.m1319h().m1184k(), AbstractC0032a.m165s("kzFOlWvkeeyuJmOWaQ==\n", "x0cP+Q6WDag=\n"));
                String str3 = AbstractC0032a.m165s("WGpB+8/GX9pDf0b9z9wPlhIiHbCC2BGWEiIdsILYJQ==\n", "LBwjjrzmL6g=\n") + TVCore.getInstance().getVersion(2026) + AbstractC0032a.m165s("OoQ+gwAzOQYMhD6DADM5BgyEPrU=\n", "MLgCvzwPBTo=\n");
                boolean z11 = AbstractC3331m.f11244b;
                String str4 = ViewOnKeyListenerC2944y.f10031u1;
                Log.m5049i(str4, str3);
                Log.m5049i(str4, AbstractC0032a.m165s("Hy+MSv/GW2kEOopY/twLJVVn0RWz2BUlVWfRFbPYIQ==\n", "a1nvK43mKxs=\n") + Libtvcar.getVersion(2026L) + AbstractC0032a.m165s("WPqSJTnXm/Ru+pIlOdeb9G76khM=\n", "UsauGQXrp8g=\n"));
                break;
            case 16:
                ViewOnClickListenerC3017d viewOnClickListenerC3017d = (ViewOnClickListenerC3017d) obj;
                viewOnClickListenerC3017d.f10326k0 = null;
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427sM1264z2 = viewOnClickListenerC3017d.m1319h().m1184k().m1264z(AbstractC0032a.m165s("PL4la9l+a90BqQho2w==\n", "aMhkB7wMH5k=\n"));
                if (abstractComponentCallbacksC0427sM1264z2 != null) {
                    ((DialogInterfaceOnCancelListenerC0415m) abstractComponentCallbacksC0427sM1264z2).m1274Q(true, false);
                    C0412k0 c0412k0M1184k3 = viewOnClickListenerC3017d.m1319h().m1184k();
                    c0412k0M1184k3.getClass();
                    C0391a c0391a2 = new C0391a(c0412k0M1184k3);
                    c0391a2.m1193h(abstractComponentCallbacksC0427sM1264z2);
                    c0391a2.m1190e(true);
                    C0412k0 c0412k0M1184k4 = viewOnClickListenerC3017d.m1319h().m1184k();
                    c0412k0M1184k4.m1259u(true);
                    c0412k0M1184k4.m1217A();
                }
                RunnableC3015b runnableC3015b = new RunnableC3015b(viewOnClickListenerC3017d, i6);
                RunnableC3015b runnableC3015b2 = new RunnableC3015b(viewOnClickListenerC3017d, i10);
                String strM1325n2 = viewOnClickListenerC3017d.f10327l0 ? viewOnClickListenerC3017d.m1325n(R.string.network_status_not_good) : viewOnClickListenerC3017d.m1325n(R.string.network_status_good);
                C3745p c3745p2 = new C3745p();
                c3745p2.f12547k0 = runnableC3015b;
                c3745p2.f12548l0 = runnableC3015b2;
                Bundle bundle2 = new Bundle();
                bundle2.putString(C3745p.f12546s0, strM1325n2);
                c3745p2.m1316O(bundle2);
                viewOnClickListenerC3017d.f10326k0 = c3745p2;
                c3745p2.f12554r0 = new C3014a(viewOnClickListenerC3017d);
                c3745p2.m1276S(viewOnClickListenerC3017d.m1319h().m1184k(), AbstractC0032a.m165s("qWnSYTxT66GUfv9iPg==\n", "/R+TDVkhn+U=\n"));
                viewOnClickListenerC3017d.f10314X.setVisibility(4);
                break;
            case 17:
                ((C3736g) obj).dismiss();
                break;
            case 18:
                ((DialogC3734e) obj).dismiss();
                break;
            case 19:
                ((DialogC3734e) obj).dismiss();
                break;
            case 20:
                ((AbstractC3806c) obj).f12844a.getClass();
                break;
            default:
                ExpandedControllerActivity expandedControllerActivity = (ExpandedControllerActivity) obj;
                if (expandedControllerActivity.f4931d0.isClickable() && (c3616fM3628p = expandedControllerActivity.m3628p()) != null) {
                    AbstractC1312l.m3195b("Must be called from the main thread.");
                    if (!c3616fM3628p.m7296F()) {
                        C3616f.m7290x();
                    } else {
                        C3616f.m7289G(new C3618h(c3616fM3628p, 5));
                    }
                    break;
                }
                break;
        }
    }

    public ViewOnClickListenerC0122a(C2509b c2509b, AbstractC2675a abstractC2675a) {
        this.f255a = 9;
        this.f256b = c2509b;
    }
}
