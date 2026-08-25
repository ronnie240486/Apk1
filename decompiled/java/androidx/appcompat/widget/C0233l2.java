package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import com.p2serv.android.p032ds.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
import p005a4.C0049h;
import p034d0.AbstractC2115a;
import p065g0.AbstractC2581a;
import p143n5.AbstractC3198d;
import p160p.C3345i;
import p160p.C3347k;
import p160p.C3348l;
import p268z1.C4299n;

public final class C0233l2 {

    public static C0233l2 f990i;

    public WeakHashMap f992a;

    public C3347k f993b;

    public C3348l f994c;

    public final WeakHashMap f995d = new WeakHashMap(0);

    public TypedValue f996e;

    public boolean f997f;

    public C0049h f998g;

    public static final PorterDuff.Mode f989h = PorterDuff.Mode.SRC_IN;

    public static final C0223j2 f991j = new C0223j2(6);

    public static synchronized C0233l2 m720d() {
        try {
            if (f990i == null) {
                C0233l2 c0233l2 = new C0233l2();
                f990i = c0233l2;
                m722j(c0233l2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f990i;
    }

    public static synchronized PorterDuffColorFilter m721h(int i6, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        C0223j2 c0223j2 = f991j;
        c0223j2.getClass();
        int i10 = (31 + i6) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) c0223j2.m3612b(Integer.valueOf(mode.hashCode() + i10));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i6, mode);
        }
        return porterDuffColorFilter;
    }

    public static void m722j(C0233l2 c0233l2) {
        if (Build.VERSION.SDK_INT < 24) {
            c0233l2.m723a("vector", new C0228k2(3));
            c0233l2.m723a("animated-vector", new C0228k2(2));
            c0233l2.m723a("animated-selector", new C0228k2(1));
            c0233l2.m723a("drawable", new C0228k2(0));
        }
    }

    public final void m723a(String str, C0228k2 c0228k2) {
        if (this.f993b == null) {
            this.f993b = new C3347k(0);
        }
        this.f993b.put(str, c0228k2);
    }

    public final synchronized void m724b(Context context, long j10, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                C3345i c3345i = (C3345i) this.f995d.get(context);
                if (c3345i == null) {
                    c3345i = new C3345i();
                    this.f995d.put(context, c3345i);
                }
                c3345i.m6801h(j10, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Drawable m725c(Context context, int i6) {
        if (this.f996e == null) {
            this.f996e = new TypedValue();
        }
        TypedValue typedValue = this.f996e;
        context.getResources().getValue(i6, typedValue, true);
        long j10 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable drawableM726e = m726e(context, j10);
        if (drawableM726e != null) {
            return drawableM726e;
        }
        LayerDrawable layerDrawableM195e = null;
        if (this.f998g != null) {
            if (i6 == R.drawable.abc_cab_background_top_material) {
                layerDrawableM195e = new LayerDrawable(new Drawable[]{m727f(context, R.drawable.abc_cab_background_internal_bg), m727f(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i6 == R.drawable.abc_ratingbar_material) {
                layerDrawableM195e = C0049h.m195e(this, context, R.dimen.abc_star_big);
            } else if (i6 == R.drawable.abc_ratingbar_indicator_material) {
                layerDrawableM195e = C0049h.m195e(this, context, R.dimen.abc_star_medium);
            } else if (i6 == R.drawable.abc_ratingbar_small_material) {
                layerDrawableM195e = C0049h.m195e(this, context, R.dimen.abc_star_small);
            }
        }
        if (layerDrawableM195e != null) {
            layerDrawableM195e.setChangingConfigurations(typedValue.changingConfigurations);
            m724b(context, j10, layerDrawableM195e);
        }
        return layerDrawableM195e;
    }

    public final synchronized Drawable m726e(Context context, long j10) {
        C3345i c3345i = (C3345i) this.f995d.get(context);
        if (c3345i == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) c3345i.m6797d(j10);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            c3345i.m6802i(j10);
        }
        return null;
    }

    public final synchronized Drawable m727f(Context context, int i6) {
        return m728g(context, i6, false);
    }

    public final synchronized Drawable m728g(Context context, int i6, boolean z7) {
        Drawable drawableM730k;
        try {
            if (!this.f997f) {
                this.f997f = true;
                Drawable drawableM727f = m727f(context, R.drawable.abc_vector_test);
                if (drawableM727f == null || (!(drawableM727f instanceof C4299n) && !"android.graphics.drawable.VectorDrawable".equals(drawableM727f.getClass().getName()))) {
                    this.f997f = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            drawableM730k = m730k(context, i6);
            if (drawableM730k == null) {
                drawableM730k = m725c(context, i6);
            }
            if (drawableM730k == null) {
                drawableM730k = AbstractC2115a.m5069b(context, i6);
            }
            if (drawableM730k != null) {
                drawableM730k = m733n(context, i6, z7, drawableM730k);
            }
            if (drawableM730k != null) {
                AbstractC0237m1.m735a(drawableM730k);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableM730k;
    }

    public final synchronized ColorStateList m729i(Context context, int i6) {
        ColorStateList colorStateList;
        C3348l c3348l;
        WeakHashMap weakHashMap = this.f992a;
        ColorStateList colorStateListM199f = null;
        colorStateList = (weakHashMap == null || (c3348l = (C3348l) weakHashMap.get(context)) == null) ? null : (ColorStateList) c3348l.m6819c(i6);
        if (colorStateList == null) {
            C0049h c0049h = this.f998g;
            if (c0049h != null) {
                colorStateListM199f = c0049h.m199f(context, i6);
            }
            if (colorStateListM199f != null) {
                if (this.f992a == null) {
                    this.f992a = new WeakHashMap();
                }
                C3348l c3348l2 = (C3348l) this.f992a.get(context);
                if (c3348l2 == null) {
                    c3348l2 = new C3348l();
                    this.f992a.put(context, c3348l2);
                }
                c3348l2.m6817a(i6, colorStateListM199f);
            }
            colorStateList = colorStateListM199f;
        }
        return colorStateList;
    }

    public final Drawable m730k(Context context, int i6) {
        int next;
        C3347k c3347k = this.f993b;
        if (c3347k == null || c3347k.isEmpty()) {
            return null;
        }
        C3348l c3348l = this.f994c;
        if (c3348l != null) {
            String str = (String) c3348l.m6819c(i6);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f993b.get(str) == null)) {
                return null;
            }
        } else {
            this.f994c = new C3348l();
        }
        if (this.f996e == null) {
            this.f996e = new TypedValue();
        }
        TypedValue typedValue = this.f996e;
        Resources resources = context.getResources();
        resources.getValue(i6, typedValue, true);
        long j10 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable drawableM726e = m726e(context, j10);
        if (drawableM726e != null) {
            return drawableM726e;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i6);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f994c.m6817a(i6, name);
                C0228k2 c0228k2 = (C0228k2) this.f993b.get(name);
                if (c0228k2 != null) {
                    drawableM726e = c0228k2.m717a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableM726e != null) {
                    drawableM726e.setChangingConfigurations(typedValue.changingConfigurations);
                    m724b(context, j10, drawableM726e);
                }
            } catch (Exception e5) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e5);
            }
        }
        if (drawableM726e == null) {
            this.f994c.m6817a(i6, "appcompat_skip_skip");
        }
        return drawableM726e;
    }

    public final synchronized void m731l(Context context) {
        C3345i c3345i = (C3345i) this.f995d.get(context);
        if (c3345i != null) {
            c3345i.m6795b();
        }
    }

    public final synchronized void m732m(C0049h c0049h) {
        this.f998g = c0049h;
    }

    public final Drawable m733n(Context context, int i6, boolean z7, Drawable drawable) {
        int iRound;
        boolean z10;
        Drawable drawableMutate;
        int i10 = R.attr.colorControlNormal;
        ColorStateList colorStateListM729i = m729i(context, i6);
        PorterDuff.Mode mode = null;
        if (colorStateListM729i != null) {
            int[] iArr = AbstractC0237m1.f1008a;
            Drawable drawableM6448W = AbstractC3198d.m6448W(drawable.mutate());
            AbstractC2581a.m5586h(drawableM6448W, colorStateListM729i);
            if (this.f998g != null && i6 == R.drawable.abc_switch_thumb_material) {
                mode = PorterDuff.Mode.MULTIPLY;
            }
            if (mode == null) {
                return drawableM6448W;
            }
            AbstractC2581a.m5587i(drawableM6448W, mode);
            return drawableM6448W;
        }
        if (this.f998g != null) {
            if (i6 == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
                int iM704c = AbstractC0224j3.m704c(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode2 = C0285w.f1113b;
                C0049h.m196g(drawableFindDrawableByLayerId, iM704c, mode2);
                C0049h.m196g(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), AbstractC0224j3.m704c(context, R.attr.colorControlNormal), mode2);
                C0049h.m196g(layerDrawable.findDrawableByLayerId(android.R.id.progress), AbstractC0224j3.m704c(context, R.attr.colorControlActivated), mode2);
                return drawable;
            }
            if (i6 == R.drawable.abc_ratingbar_material || i6 == R.drawable.abc_ratingbar_indicator_material || i6 == R.drawable.abc_ratingbar_small_material) {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.background);
                int iM703b = AbstractC0224j3.m703b(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode3 = C0285w.f1113b;
                C0049h.m196g(drawableFindDrawableByLayerId2, iM703b, mode3);
                C0049h.m196g(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), AbstractC0224j3.m704c(context, R.attr.colorControlActivated), mode3);
                C0049h.m196g(layerDrawable2.findDrawableByLayerId(android.R.id.progress), AbstractC0224j3.m704c(context, R.attr.colorControlActivated), mode3);
                return drawable;
            }
        }
        C0049h c0049h = this.f998g;
        boolean z11 = false;
        if (c0049h != null) {
            PorterDuff.Mode mode4 = C0285w.f1113b;
            if (C0049h.m193b((int[]) c0049h.f139a, i6)) {
                iRound = -1;
            } else if (C0049h.m193b((int[]) c0049h.f141c, i6)) {
                iRound = -1;
                i10 = R.attr.colorControlActivated;
            } else {
                if (C0049h.m193b((int[]) c0049h.f142d, i6)) {
                    mode4 = PorterDuff.Mode.MULTIPLY;
                } else {
                    if (i6 == R.drawable.abc_list_divider_mtrl_alpha) {
                        iRound = Math.round(40.8f);
                        i10 = android.R.attr.colorForeground;
                    } else if (i6 != R.drawable.abc_dialog_material_background) {
                        iRound = -1;
                        i10 = 0;
                        z10 = false;
                    }
                    if (z10) {
                        int[] iArr2 = AbstractC0237m1.f1008a;
                        drawableMutate = drawable.mutate();
                        drawableMutate.setColorFilter(C0285w.m802c(AbstractC0224j3.m704c(context, i10), mode4));
                        if (iRound != -1) {
                            drawableMutate.setAlpha(iRound);
                        }
                        z11 = true;
                    }
                }
                iRound = -1;
                i10 = android.R.attr.colorBackground;
            }
            z10 = true;
            if (z10) {
                int[] iArr3 = AbstractC0237m1.f1008a;
                drawableMutate = drawable.mutate();
                drawableMutate.setColorFilter(C0285w.m802c(AbstractC0224j3.m704c(context, i10), mode4));
                if (iRound != -1) {
                    drawableMutate.setAlpha(iRound);
                }
                z11 = true;
            }
        }
        if (z11 || !z7) {
            return drawable;
        }
        return null;
    }
}
