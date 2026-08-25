package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.p2serv.android.p032ds.R;
import p002a1.C0026b;
import p045e.AbstractC2341a;
import p138n0.AbstractC3155s0;

public final class C0284v3 implements InterfaceC0222j1 {

    public final Toolbar f1098a;

    public int f1099b;

    public final View f1100c;

    public Drawable f1101d;

    public Drawable f1102e;

    public Drawable f1103f;

    public boolean f1104g;

    public CharSequence f1105h;

    public CharSequence f1106i;

    public final CharSequence f1107j;

    public Window.Callback f1108k;

    public boolean f1109l;

    public C0225k f1110m;

    public final int f1111n;

    public final Drawable f1112o;

    public C0284v3(Toolbar toolbar, boolean z7) {
        Drawable drawable;
        this.f1111n = 0;
        this.f1098a = toolbar;
        this.f1105h = toolbar.getTitle();
        this.f1106i = toolbar.getSubtitle();
        this.f1104g = this.f1105h != null;
        this.f1103f = toolbar.getNavigationIcon();
        C0026b c0026bM111C = C0026b.m111C(toolbar.getContext(), null, AbstractC2341a.f8153a, R.attr.actionBarStyle);
        int i6 = 15;
        this.f1112o = c0026bM111C.m140t(15);
        if (z7) {
            TypedArray typedArray = (TypedArray) c0026bM111C.f55c;
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                this.f1104g = true;
                this.f1105h = text;
                if ((this.f1099b & 8) != 0) {
                    Toolbar toolbar2 = this.f1098a;
                    toolbar2.setTitle(text);
                    if (this.f1104g) {
                        AbstractC3155s0.m6348r(toolbar2.getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                m798b(text2);
            }
            Drawable drawableM140t = c0026bM111C.m140t(20);
            if (drawableM140t != null) {
                this.f1102e = drawableM140t;
                m800d();
            }
            Drawable drawableM140t2 = c0026bM111C.m140t(17);
            if (drawableM140t2 != null) {
                this.f1101d = drawableM140t2;
                m800d();
            }
            if (this.f1103f == null && (drawable = this.f1112o) != null) {
                this.f1103f = drawable;
                int i10 = this.f1099b & 4;
                Toolbar toolbar3 = this.f1098a;
                if (i10 != 0) {
                    toolbar3.setNavigationIcon(drawable);
                } else {
                    toolbar3.setNavigationIcon((Drawable) null);
                }
            }
            m797a(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false);
                View view = this.f1100c;
                if (view != null && (this.f1099b & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.f1100c = viewInflate;
                if (viewInflate != null && (this.f1099b & 16) != 0) {
                    toolbar.addView(viewInflate);
                }
                m797a(this.f1099b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int iMax = Math.max(dimensionPixelOffset, 0);
                int iMax2 = Math.max(dimensionPixelOffset2, 0);
                toolbar.m616d();
                toolbar.f846t.m739a(iMax, iMax2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = toolbar.getContext();
                toolbar.f838l = resourceId2;
                AppCompatTextView appCompatTextView = toolbar.f828b;
                if (appCompatTextView != null) {
                    appCompatTextView.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = toolbar.getContext();
                toolbar.f839m = resourceId3;
                AppCompatTextView appCompatTextView2 = toolbar.f829c;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                toolbar.setPopupTheme(resourceId4);
            }
        } else {
            if (toolbar.getNavigationIcon() != null) {
                this.f1112o = toolbar.getNavigationIcon();
            } else {
                i6 = 11;
            }
            this.f1099b = i6;
        }
        c0026bM111C.m120F();
        if (R.string.abc_action_bar_up_description != this.f1111n) {
            this.f1111n = R.string.abc_action_bar_up_description;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                int i11 = this.f1111n;
                this.f1107j = i11 != 0 ? toolbar.getContext().getString(i11) : null;
                m799c();
            }
        }
        this.f1107j = toolbar.getNavigationContentDescription();
        toolbar.setNavigationOnClickListener(new ViewOnClickListenerC0274t3(this));
    }

    public final void m797a(int i6) {
        View view;
        int i10 = this.f1099b ^ i6;
        this.f1099b = i6;
        if (i10 != 0) {
            if ((i10 & 4) != 0) {
                if ((i6 & 4) != 0) {
                    m799c();
                }
                int i11 = this.f1099b & 4;
                Toolbar toolbar = this.f1098a;
                if (i11 != 0) {
                    Drawable drawable = this.f1103f;
                    if (drawable == null) {
                        drawable = this.f1112o;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i10 & 3) != 0) {
                m800d();
            }
            int i12 = i10 & 8;
            Toolbar toolbar2 = this.f1098a;
            if (i12 != 0) {
                if ((i6 & 8) != 0) {
                    toolbar2.setTitle(this.f1105h);
                    toolbar2.setSubtitle(this.f1106i);
                } else {
                    toolbar2.setTitle((CharSequence) null);
                    toolbar2.setSubtitle((CharSequence) null);
                }
            }
            if ((i10 & 16) == 0 || (view = this.f1100c) == null) {
                return;
            }
            if ((i6 & 16) != 0) {
                toolbar2.addView(view);
            } else {
                toolbar2.removeView(view);
            }
        }
    }

    public final void m798b(CharSequence charSequence) {
        this.f1106i = charSequence;
        if ((this.f1099b & 8) != 0) {
            this.f1098a.setSubtitle(charSequence);
        }
    }

    public final void m799c() {
        if ((this.f1099b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(this.f1107j);
            Toolbar toolbar = this.f1098a;
            if (zIsEmpty) {
                toolbar.setNavigationContentDescription(this.f1111n);
            } else {
                toolbar.setNavigationContentDescription(this.f1107j);
            }
        }
    }

    public final void m800d() {
        Drawable drawable;
        int i6 = this.f1099b;
        if ((i6 & 2) == 0) {
            drawable = null;
        } else if ((i6 & 1) == 0 || (drawable = this.f1102e) == null) {
            drawable = this.f1101d;
        }
        this.f1098a.setLogo(drawable);
    }
}
