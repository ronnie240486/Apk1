package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.C0158s;
import androidx.appcompat.app.LayoutInflaterFactory2C0135g0;
import p105k.MenuC2838l;
import p138n0.C3102a1;

public class ContentFrameLayout extends FrameLayout {

    public TypedValue f665a;

    public TypedValue f666b;

    public TypedValue f667c;

    public TypedValue f668d;

    public TypedValue f669e;

    public TypedValue f670f;

    public final Rect f671g;

    public InterfaceC0212h1 f672h;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f669e == null) {
            this.f669e = new TypedValue();
        }
        return this.f669e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f670f == null) {
            this.f670f = new TypedValue();
        }
        return this.f670f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f667c == null) {
            this.f667c = new TypedValue();
        }
        return this.f667c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f668d == null) {
            this.f668d = new TypedValue();
        }
        return this.f668d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f665a == null) {
            this.f665a = new TypedValue();
        }
        return this.f665a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f666b == null) {
            this.f666b = new TypedValue();
        }
        return this.f666b;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        InterfaceC0212h1 interfaceC0212h1 = this.f672h;
        if (interfaceC0212h1 != null) {
            interfaceC0212h1.getClass();
        }
    }

    @Override
    public final void onDetachedFromWindow() {
        C0225k c0225k;
        super.onDetachedFromWindow();
        InterfaceC0212h1 interfaceC0212h1 = this.f672h;
        if (interfaceC0212h1 != null) {
            LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = ((C0158s) interfaceC0212h1).f431b;
            InterfaceC0217i1 interfaceC0217i1 = layoutInflaterFactory2C0135g0.f348r;
            if (interfaceC0217i1 != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0217i1;
                actionBarOverlayLayout.m556k();
                ActionMenuView actionMenuView = ((C0284v3) actionBarOverlayLayout.f552e).f1098a.f827a;
                if (actionMenuView != null && (c0225k = actionMenuView.f580t) != null) {
                    c0225k.m708c();
                    C0195e c0195e = c0225k.f972u;
                    if (c0195e != null && c0195e.m5855b()) {
                        c0195e.f9763i.dismiss();
                    }
                }
            }
            if (layoutInflaterFactory2C0135g0.f353w != null) {
                layoutInflaterFactory2C0135g0.f342l.getDecorView().removeCallbacks(layoutInflaterFactory2C0135g0.f354x);
                if (layoutInflaterFactory2C0135g0.f353w.isShowing()) {
                    try {
                        layoutInflaterFactory2C0135g0.f353w.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                layoutInflaterFactory2C0135g0.f353w = null;
            }
            C3102a1 c3102a1 = layoutInflaterFactory2C0135g0.f355y;
            if (c3102a1 != null) {
                c3102a1.m6122b();
            }
            MenuC2838l menuC2838l = layoutInflaterFactory2C0135g0.m383A(0).f293h;
            if (menuC2838l != null) {
                menuC2838l.m5827c(true);
            }
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int iMakeMeasureSpec;
        boolean z7;
        int iMakeMeasureSpec2;
        int i11;
        int i12;
        float fraction;
        int i13;
        int i14;
        float fraction2;
        int i15;
        int i16;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z10 = true;
        boolean z11 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i6);
        int mode2 = View.MeasureSpec.getMode(i10);
        Rect rect = this.f671g;
        if (mode != Integer.MIN_VALUE) {
            iMakeMeasureSpec = i6;
            z7 = false;
        } else {
            TypedValue typedValue = z11 ? this.f668d : this.f667c;
            if (typedValue == null || (i15 = typedValue.type) == 0) {
                iMakeMeasureSpec = i6;
                z7 = false;
            } else {
                if (i15 == 5) {
                    fraction3 = typedValue.getDimension(displayMetrics);
                } else {
                    if (i15 == 6) {
                        int i17 = displayMetrics.widthPixels;
                        fraction3 = typedValue.getFraction(i17, i17);
                    } else {
                        i16 = 0;
                    }
                    if (i16 > 0) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(i16 - (rect.left + rect.right), View.MeasureSpec.getSize(i6)), 1073741824);
                        z7 = true;
                    } else {
                        iMakeMeasureSpec = i6;
                        z7 = false;
                    }
                }
                i16 = (int) fraction3;
                if (i16 > 0) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(i16 - (rect.left + rect.right), View.MeasureSpec.getSize(i6)), 1073741824);
                    z7 = true;
                } else {
                    iMakeMeasureSpec = i6;
                    z7 = false;
                }
            }
        }
        if (mode2 != Integer.MIN_VALUE) {
            iMakeMeasureSpec2 = i10;
        } else {
            TypedValue typedValue2 = z11 ? this.f669e : this.f670f;
            if (typedValue2 == null || (i13 = typedValue2.type) == 0) {
                iMakeMeasureSpec2 = i10;
            } else {
                if (i13 == 5) {
                    fraction2 = typedValue2.getDimension(displayMetrics);
                } else {
                    if (i13 == 6) {
                        int i18 = displayMetrics.heightPixels;
                        fraction2 = typedValue2.getFraction(i18, i18);
                    } else {
                        i14 = 0;
                    }
                    if (i14 > 0) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.min(i14 - (rect.top + rect.bottom), View.MeasureSpec.getSize(i10)), 1073741824);
                    } else {
                        iMakeMeasureSpec2 = i10;
                    }
                }
                i14 = (int) fraction2;
                if (i14 > 0) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.min(i14 - (rect.top + rect.bottom), View.MeasureSpec.getSize(i10)), 1073741824);
                } else {
                    iMakeMeasureSpec2 = i10;
                }
            }
        }
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec2);
        int measuredWidth = getMeasuredWidth();
        int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (z7 || mode != Integer.MIN_VALUE) {
            z10 = false;
        } else {
            TypedValue typedValue3 = z11 ? this.f666b : this.f665a;
            if (typedValue3 == null || (i11 = typedValue3.type) == 0) {
                z10 = false;
            } else {
                if (i11 == 5) {
                    fraction = typedValue3.getDimension(displayMetrics);
                } else {
                    if (i11 == 6) {
                        int i19 = displayMetrics.widthPixels;
                        fraction = typedValue3.getFraction(i19, i19);
                    } else {
                        i12 = 0;
                    }
                    if (i12 > 0) {
                        i12 -= rect.left + rect.right;
                    }
                    if (measuredWidth < i12) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                    } else {
                        z10 = false;
                    }
                }
                i12 = (int) fraction;
                if (i12 > 0) {
                    i12 -= rect.left + rect.right;
                }
                if (measuredWidth < i12) {
                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                } else {
                    z10 = false;
                }
            }
        }
        if (z10) {
            super.onMeasure(iMakeMeasureSpec3, iMakeMeasureSpec2);
        }
    }

    public void setAttachListener(InterfaceC0212h1 interfaceC0212h1) {
        this.f672h = interfaceC0212h1;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f671g = new Rect();
    }
}
