package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import p064g.C2578e;
import p073h.AbstractC2636b;
import p268z1.C4288c;
import p268z1.C4299n;

public final class C0228k2 {

    public final int f985a;

    public C0228k2(int i6) {
        this.f985a = i6;
    }

    public final Drawable m717a(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        switch (this.f985a) {
            case 0:
                String classAttribute = attributeSet.getClassAttribute();
                if (classAttribute == null) {
                    return null;
                }
                try {
                    Drawable drawable = (Drawable) C0228k2.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(null).newInstance(null);
                    AbstractC2636b.m5658c(drawable, context.getResources(), xmlResourceParser, attributeSet, theme);
                    return drawable;
                } catch (Exception e5) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e5);
                    return null;
                }
            case 1:
                try {
                    return C2578e.m5572e(context, context.getResources(), xmlResourceParser, attributeSet, theme);
                } catch (Exception e10) {
                    Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e10);
                    return null;
                }
            case 2:
                try {
                    Resources resources = context.getResources();
                    C4288c c4288c = new C4288c(context);
                    c4288c.inflate(resources, xmlResourceParser, attributeSet, theme);
                    return c4288c;
                } catch (Exception e11) {
                    Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e11);
                    return null;
                }
            default:
                try {
                    Resources resources2 = context.getResources();
                    C4299n c4299n = new C4299n();
                    c4299n.inflate(resources2, xmlResourceParser, attributeSet, theme);
                    return c4299n;
                } catch (Exception e12) {
                    Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e12);
                    return null;
                }
        }
    }
}
