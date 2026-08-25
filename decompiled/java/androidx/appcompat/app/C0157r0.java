package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.C0195e;
import androidx.appcompat.widget.C0225k;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.internal.C1819e0;
import com.google.android.material.internal.InterfaceC1817d0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p056f0.C2480c;
import p105k.InterfaceC2850x;
import p105k.MenuC2838l;
import p118l0.AbstractC2959j;
import p118l0.C2958i;
import p138n0.C3144o1;
import p138n0.C3153r1;
import p151o3.C3251e;
import p165p4.C3370o;
import p173q1.C3454w;
import p230v4.C3988b;
import p230v4.C3990d;
import p230v4.C4009w;
import p242w5.C4056d;
import p247x2.InterfaceC4102x;
import p271z4.InterfaceC4340k;

public final class C0157r0 implements InterfaceC2850x, InterfaceC1817d0, InterfaceC4340k {

    public final int f427a;

    public boolean f428b;

    public final Object f429c;

    public C0157r0(int i6, Object obj) {
        this.f427a = i6;
        this.f429c = obj;
    }

    public static C0157r0 m439c(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("routes");
        if (parcelableArrayList != null) {
            for (int i6 = 0; i6 < parcelableArrayList.size(); i6++) {
                Bundle bundle2 = (Bundle) parcelableArrayList.get(i6);
                arrayList.add(bundle2 != null ? new C3454w(bundle2) : null);
            }
        }
        return new C0157r0(arrayList, bundle.getBoolean("supportsDynamicGroupRoute", false));
    }

    public boolean m440a() {
        return this.f428b;
    }

    @Override
    public void mo86b(MenuC2838l menuC2838l, boolean z7) {
        C0225k c0225k;
        if (this.f428b) {
            return;
        }
        this.f428b = true;
        C0159s0 c0159s0 = (C0159s0) this.f429c;
        ActionMenuView actionMenuView = c0159s0.f432r.f1098a.f827a;
        if (actionMenuView != null && (c0225k = actionMenuView.f580t) != null) {
            c0225k.m708c();
            C0195e c0195e = c0225k.f972u;
            if (c0195e != null && c0195e.m5855b()) {
                c0195e.f9763i.dismiss();
            }
        }
        c0159s0.f433s.onPanelClosed(108, menuC2838l);
        this.f428b = false;
    }

    public boolean m441d(CharSequence charSequence, int i6) {
        if (charSequence == null || i6 < 0 || charSequence.length() - i6 < 0) {
            throw new IllegalArgumentException();
        }
        if (((C2958i) this.f429c) == null) {
            return m440a();
        }
        char c5 = 2;
        for (int i10 = 0; i10 < i6 && c5 == 2; i10++) {
            byte directionality = Character.getDirectionality(charSequence.charAt(i10));
            C0157r0 c0157r0 = AbstractC2959j.f10137a;
            if (directionality == 0) {
                c5 = 1;
            } else if (directionality != 1 && directionality != 2) {
                switch (directionality) {
                    case 14:
                    case 15:
                        c5 = 1;
                        break;
                    case 16:
                    case 17:
                        c5 = 0;
                        break;
                    default:
                        c5 = 2;
                        break;
                }
            } else {
                c5 = 0;
            }
        }
        if (c5 == 0) {
            return true;
        }
        if (c5 != 1) {
            return m440a();
        }
        return false;
    }

    public synchronized void m442e(InterfaceC4102x interfaceC4102x, boolean z7) {
        try {
            if (this.f428b || z7) {
                ((Handler) this.f429c).obtainMessage(1, interfaceC4102x).sendToTarget();
            } else {
                this.f428b = true;
                interfaceC4102x.mo5405d();
                this.f428b = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override
    public boolean mo90f(MenuC2838l menuC2838l) {
        ((C0159s0) this.f429c).f433s.onMenuOpened(108, menuC2838l);
        return true;
    }

    @Override
    public C3153r1 mo443o(View view, C3153r1 c3153r1, C1819e0 c1819e0) {
        boolean z7;
        C3144o1 c3144o1 = c3153r1.f10641a;
        C2480c c2480cMo6228g = c3144o1.mo6228g(7);
        C2480c c2480cMo6228g2 = c3144o1.mo6228g(32);
        int i6 = c2480cMo6228g.f8682b;
        BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f429c;
        bottomSheetBehavior.f6006v = i6;
        boolean zM4249i = AbstractC1811a0.m4249i(view);
        int paddingBottom = view.getPaddingBottom();
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        if (bottomSheetBehavior.f5998n) {
            int iM6325a = c3153r1.m6325a();
            bottomSheetBehavior.f6005u = iM6325a;
            paddingBottom = iM6325a + c1819e0.f6439d;
        }
        boolean z10 = bottomSheetBehavior.f5999o;
        int i10 = c2480cMo6228g.f8681a;
        if (z10) {
            paddingLeft = (zM4249i ? c1819e0.f6438c : c1819e0.f6436a) + i10;
        }
        boolean z11 = bottomSheetBehavior.f6000p;
        int i11 = c2480cMo6228g.f8683c;
        if (z11) {
            paddingRight = (zM4249i ? c1819e0.f6436a : c1819e0.f6438c) + i11;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        boolean z12 = true;
        if (!bottomSheetBehavior.f6002r || marginLayoutParams.leftMargin == i10) {
            z7 = false;
        } else {
            marginLayoutParams.leftMargin = i10;
            z7 = true;
        }
        if (bottomSheetBehavior.f6003s && marginLayoutParams.rightMargin != i11) {
            marginLayoutParams.rightMargin = i11;
            z7 = true;
        }
        if (bottomSheetBehavior.f6004t) {
            int i12 = marginLayoutParams.topMargin;
            int i13 = c2480cMo6228g.f8682b;
            if (i12 != i13) {
                marginLayoutParams.topMargin = i13;
            } else {
                z12 = z7;
            }
        } else {
            z12 = z7;
        }
        if (z12) {
            view.setLayoutParams(marginLayoutParams);
        }
        view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
        boolean z13 = this.f428b;
        if (z13) {
            bottomSheetBehavior.f5996l = c2480cMo6228g2.f8684d;
        }
        if (bottomSheetBehavior.f5998n || z13) {
            bottomSheetBehavior.m4131H();
        }
        return c3153r1;
    }

    @Override
    public void mo99p(Object obj, Object obj2) {
        C4009w c4009w = (C4009w) obj;
        C3988b c3988b = C3370o.f11372F;
        Context context = c4009w.f5071c;
        ComplianceOptions complianceOptions = new ComplianceOptions(-1, -1, 0, true);
        C3990d c3990d = (C3990d) c4009w.m3663p();
        C3370o c3370o = (C3370o) this.f429c;
        double d = c3370o.f11390u;
        boolean z7 = c3370o.f11391v;
        ApiMetadata apiMetadata = new ApiMetadata(complianceOptions);
        Parcel parcelM3687l = c3990d.m3687l();
        int i6 = AbstractC1542e0.f5277a;
        parcelM3687l.writeInt(this.f428b ? 1 : 0);
        parcelM3687l.writeDouble(d);
        parcelM3687l.writeInt(z7 ? 1 : 0);
        AbstractC1542e0.m3809c(parcelM3687l, apiMetadata);
        c3990d.m3690y(parcelM3687l, 8);
        ((C4056d) obj2).m8059b(null);
    }

    public String toString() {
        switch (this.f427a) {
            case 5:
                StringBuilder sb = new StringBuilder("MediaRouteProviderDescriptor{ routes=");
                List list = (List) this.f429c;
                sb.append(Arrays.toString(list.toArray()));
                sb.append(", isValid=");
                int size = list.size();
                boolean z7 = false;
                for (int i6 = 0; i6 < size; i6++) {
                    C3454w c3454w = (C3454w) list.get(i6);
                    if (c3454w == null || !c3454w.m7094k()) {
                        sb.append(z7);
                        sb.append(" }");
                        return sb.toString();
                    }
                }
                z7 = true;
                sb.append(z7);
                sb.append(" }");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public C0157r0(int i6, Object obj, boolean z7) {
        this.f427a = i6;
        this.f429c = obj;
        this.f428b = z7;
    }

    public C0157r0() {
        this.f427a = 6;
        this.f429c = new Handler(Looper.getMainLooper(), new C3251e(1));
    }

    public C0157r0(ArrayList arrayList, boolean z7) {
        this.f427a = 5;
        if (arrayList.isEmpty()) {
            this.f429c = Collections.emptyList();
        } else {
            this.f429c = Collections.unmodifiableList(new ArrayList(arrayList));
        }
        this.f428b = z7;
    }

    public C0157r0(C2958i c2958i, boolean z7) {
        this(3, c2958i);
        this.f427a = 3;
        this.f428b = z7;
    }
}
