package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.appbar.MaterialToolbar;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Locale;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;
import p001a0.C0022e;
import p002a1.C0026b;
import p007a7.C0069f;
import p138n0.AbstractC3113e0;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p250x5.AbstractC4121a;

public abstract class AbstractC1811a0 {

    public static final int[] f6355a = {R.attr.colorPrimary};

    public static final int[] f6356b = {R.attr.colorPrimaryVariant};

    public static final C0022e f6357c = new C0022e(2);

    public static void m4241a(Context context, AttributeSet attributeSet, int i6, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4121a.f13988c0, i6, i10);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(1, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z7) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                m4243c(context, f6356b, "Theme.MaterialComponents");
            }
        }
        m4243c(context, f6355a, "Theme.AppCompat");
    }

    public static void m4242b(Context context, AttributeSet attributeSet, int[] iArr, int i6, int i10, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4121a.f13988c0, i6, i10);
        boolean z7 = false;
        if (!typedArrayObtainStyledAttributes.getBoolean(2, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2.length != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i6, i10);
            int length = iArr2.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    typedArrayObtainStyledAttributes2.recycle();
                    z7 = true;
                    break;
                } else {
                    if (typedArrayObtainStyledAttributes2.getResourceId(iArr2[i11], -1) == -1) {
                        typedArrayObtainStyledAttributes2.recycle();
                        break;
                    }
                    i11++;
                }
            }
        } else if (typedArrayObtainStyledAttributes.getResourceId(0, -1) != -1) {
            z7 = true;
            break;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!z7) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    public static void m4243c(Context context, int[] iArr, String str) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i6 = 0; i6 < iArr.length; i6++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i6)) {
                typedArrayObtainStyledAttributes.recycle();
                throw new IllegalArgumentException(AbstractC0004e.m24r("The style on this component requires your app theme to be ", str, " (or a descendant)."));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void m4244d(View view, InterfaceC1817d0 interfaceC1817d0) {
        Object[] objArr = 0;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        int paddingStart = view.getPaddingStart();
        int paddingTop = view.getPaddingTop();
        int paddingEnd = view.getPaddingEnd();
        int paddingBottom = view.getPaddingBottom();
        C1819e0 c1819e0 = new C1819e0();
        c1819e0.f6436a = paddingStart;
        c1819e0.f6437b = paddingTop;
        c1819e0.f6438c = paddingEnd;
        c1819e0.f6439d = paddingBottom;
        AbstractC3119g0.m6182u(view, new C0069f(13, interfaceC1817d0, c1819e0, false));
        if (view.isAttachedToWindow()) {
            AbstractC3113e0.m6130c(view);
        } else {
            view.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC1815c0(objArr == true ? 1 : 0));
        }
    }

    public static float m4245e(Context context, int i6) {
        return TypedValue.applyDimension(1, i6, context.getResources().getDisplayMetrics());
    }

    public static ViewGroup m4246f(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(android.R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static ArrayList m4247g(MaterialToolbar materialToolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < materialToolbar.getChildCount(); i6++) {
            View childAt = materialToolbar.getChildAt(i6);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    public static boolean m4248h() {
        String str = Build.MANUFACTURER;
        Locale locale = Locale.ENGLISH;
        return str.toLowerCase(locale).equals("lge") || str.toLowerCase(locale).equals("samsung");
    }

    public static boolean m4249i(View view) {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        return view.getLayoutDirection() == 1;
    }

    public static TypedArray m4250j(Context context, AttributeSet attributeSet, int[] iArr, int i6, int i10, int... iArr2) {
        m4241a(context, attributeSet, i6, i10);
        m4242b(context, attributeSet, iArr, i6, i10, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i6, i10);
    }

    public static C0026b m4251k(Context context, AttributeSet attributeSet, int[] iArr, int i6, int i10, int... iArr2) {
        m4241a(context, attributeSet, i6, i10);
        m4242b(context, attributeSet, iArr, i6, i10, iArr2);
        return new C0026b(context, context.obtainStyledAttributes(attributeSet, iArr, i6, i10));
    }

    public static PorterDuff.Mode m4252l(int i6, PorterDuff.Mode mode) {
        if (i6 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i6 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i6 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i6) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
