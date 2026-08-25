package androidx.appcompat.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.widget.AbstractC0374g;
import com.bumptech.glide.AbstractC1465c;
import com.google.android.gms.internal.cast.C1507a5;
import com.google.android.gms.internal.cast.C1594j2;
import com.google.android.gms.internal.cast.C1624m2;
import com.google.android.gms.internal.cast.C1675r7;
import com.google.android.gms.internal.cast.C1678s1;
import com.google.android.gms.internal.cast.C1730y;
import p002a1.C0026b;
import p018b5.AbstractC1312l;
import p025c2.C1381b;
import p045e.AbstractC2341a;
import p138n0.AbstractC3155s0;
import p176q4.C3482h;
import p242w5.InterfaceC4055c;

public final class C0300z implements InterfaceC4055c {

    public int f1148a;

    public final Object f1149b;

    public Object f1150c;

    public Object f1151d;

    public C0300z(C1678s1 c1678s1, String str, int i6, SharedPreferences sharedPreferences) {
        this.f1149b = c1678s1;
        this.f1150c = str;
        this.f1148a = i6;
        this.f1151d = sharedPreferences;
    }

    public void m837a() {
        ImageView imageView = (ImageView) this.f1149b;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            AbstractC0237m1.m735a(drawable);
        }
        if (drawable != null) {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 <= 21 && i6 == 21) {
                if (((C0234l3) this.f1151d) == null) {
                    this.f1151d = new C0234l3();
                }
                C0234l3 c0234l3 = (C0234l3) this.f1151d;
                c0234l3.f999a = null;
                c0234l3.f1002d = false;
                c0234l3.f1000b = null;
                c0234l3.f1001c = false;
                ColorStateList colorStateListM1126a = AbstractC0374g.m1126a(imageView);
                if (colorStateListM1126a != null) {
                    c0234l3.f1002d = true;
                    c0234l3.f999a = colorStateListM1126a;
                }
                PorterDuff.Mode modeM1127b = AbstractC0374g.m1127b(imageView);
                if (modeM1127b != null) {
                    c0234l3.f1001c = true;
                    c0234l3.f1000b = modeM1127b;
                }
                if (c0234l3.f1002d || c0234l3.f1001c) {
                    C0285w.m804e(drawable, c0234l3, imageView.getDrawableState());
                    return;
                }
            }
            C0234l3 c0234l4 = (C0234l3) this.f1150c;
            if (c0234l4 != null) {
                C0285w.m804e(drawable, c0234l4, imageView.getDrawableState());
            }
        }
    }

    public void m838b(AttributeSet attributeSet, int i6) {
        Drawable drawable;
        Drawable drawable2;
        int resourceId;
        ImageView imageView = (ImageView) this.f1149b;
        Context context = imageView.getContext();
        int[] iArr = AbstractC2341a.f8159g;
        C0026b c0026bM111C = C0026b.m111C(context, attributeSet, iArr, i6);
        AbstractC3155s0.m6346p(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) c0026bM111C.f55c, i6, 0);
        try {
            Drawable drawable3 = imageView.getDrawable();
            TypedArray typedArray = (TypedArray) c0026bM111C.f55c;
            if (drawable3 == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable3 = AbstractC1465c.m3473h(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable3);
            }
            if (drawable3 != null) {
                AbstractC0237m1.m735a(drawable3);
            }
            if (typedArray.hasValue(2)) {
                ColorStateList colorStateListM139s = c0026bM111C.m139s(2);
                int i10 = Build.VERSION.SDK_INT;
                AbstractC0374g.m1128c(imageView, colorStateListM139s);
                if (i10 == 21 && (drawable2 = imageView.getDrawable()) != null && AbstractC0374g.m1126a(imageView) != null) {
                    if (drawable2.isStateful()) {
                        drawable2.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable2);
                }
            }
            if (typedArray.hasValue(3)) {
                PorterDuff.Mode modeM737c = AbstractC0237m1.m737c(typedArray.getInt(3, -1), null);
                int i11 = Build.VERSION.SDK_INT;
                AbstractC0374g.m1129d(imageView, modeM737c);
                if (i11 == 21 && (drawable = imageView.getDrawable()) != null && AbstractC0374g.m1126a(imageView) != null) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        } finally {
            c0026bM111C.m120F();
        }
    }

    public void m839c(int i6) {
        ImageView imageView = (ImageView) this.f1149b;
        if (i6 != 0) {
            Drawable drawableM3473h = AbstractC1465c.m3473h(imageView.getContext(), i6);
            if (drawableM3473h != null) {
                AbstractC0237m1.m735a(drawableM3473h);
            }
            imageView.setImageDrawable(drawableM3473h);
        } else {
            imageView.setImageDrawable(null);
        }
        m837a();
    }

    @Override
    public void onSuccess(Object obj) {
        C1381b c1381b;
        Bundle bundle = (Bundle) obj;
        C1678s1 c1678s1 = (C1678s1) this.f1149b;
        C3482h c3482h = c1678s1.f5604a;
        AbstractC1312l.m3198e(c3482h);
        String str = (String) this.f1150c;
        int i6 = this.f1148a;
        C1730y c1730y = c1678s1.f5605b;
        if (i6 == 3) {
            c1381b = new C1381b(c1678s1, c1678s1.f5606c, str);
            c3482h.m7140a(new C1507a5(c1381b));
            if (c1730y != null) {
                C1594j2 c1594j2 = new C1594j2(1, c1381b);
                C1730y.f5727g.m7975b("register callback = %s", c1594j2);
                AbstractC1312l.m3195b("Must be called from the main thread.");
                c1730y.f5729b.add(c1594j2);
            }
        } else if (i6 == 2) {
            i6 = 2;
            c1381b = new C1381b(c1678s1, c1678s1.f5606c, str);
            c3482h.m7140a(new C1507a5(c1381b));
            if (c1730y != null) {
                C1594j2 c1594j3 = new C1594j2(1, c1381b);
                C1730y.f5727g.m7975b("register callback = %s", c1594j3);
                AbstractC1312l.m3195b("Must be called from the main thread.");
                c1730y.f5729b.add(c1594j3);
            }
        }
        if (i6 == 1 || i6 == 2) {
            C1624m2 c1624m2 = new C1624m2((SharedPreferences) this.f1151d, c1678s1, c1678s1.f5606c, bundle, str);
            c3482h.m7140a(new C1675r7(4, c1624m2));
            if (c1730y != null) {
                C1594j2 c1594j4 = new C1594j2(0, c1624m2);
                C1730y.f5727g.m7975b("register callback = %s", c1594j4);
                AbstractC1312l.m3195b("Must be called from the main thread.");
                c1730y.f5729b.add(c1594j4);
            }
        }
    }

    public C0300z(ImageView imageView) {
        this.f1148a = 0;
        this.f1149b = imageView;
    }
}
