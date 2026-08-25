package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import p055ea.AbstractC2460q;
import p266z.AbstractC4282a;

public final class C0311c extends ViewGroup.MarginLayoutParams {

    public CoordinatorLayout.Behavior f1442a;

    public boolean f1443b;

    public final int f1444c;

    public int f1445d;

    public final int f1446e;

    public final int f1447f;

    public final int f1448g;

    public int f1449h;

    public int f1450i;

    public int f1451j;

    public View f1452k;

    public View f1453l;

    public boolean f1454m;

    public boolean f1455n;

    public boolean f1456o;

    public final Rect f1457p;

    public C0311c() {
        super(-2, -2);
        this.f1443b = false;
        this.f1444c = 0;
        this.f1445d = 0;
        this.f1446e = -1;
        this.f1447f = -1;
        this.f1448g = 0;
        this.f1449h = 0;
        this.f1457p = new Rect();
    }

    public final boolean m937a(int i6) {
        if (i6 == 0) {
            return this.f1454m;
        }
        if (i6 != 1) {
            return false;
        }
        return this.f1455n;
    }

    public C0311c(Context context, AttributeSet attributeSet) {
        CoordinatorLayout.Behavior behavior;
        super(context, attributeSet);
        this.f1443b = false;
        this.f1444c = 0;
        this.f1445d = 0;
        this.f1446e = -1;
        this.f1447f = -1;
        this.f1448g = 0;
        this.f1449h = 0;
        this.f1457p = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4282a.f14507b);
        this.f1444c = typedArrayObtainStyledAttributes.getInteger(0, 0);
        this.f1447f = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        this.f1445d = typedArrayObtainStyledAttributes.getInteger(2, 0);
        this.f1446e = typedArrayObtainStyledAttributes.getInteger(6, -1);
        this.f1448g = typedArrayObtainStyledAttributes.getInt(5, 0);
        this.f1449h = typedArrayObtainStyledAttributes.getInt(4, 0);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(3);
        this.f1443b = zHasValue;
        if (zHasValue) {
            String string = typedArrayObtainStyledAttributes.getString(3);
            String str = CoordinatorLayout.f1417t;
            if (TextUtils.isEmpty(string)) {
                behavior = null;
            } else {
                if (string.startsWith(".")) {
                    string = context.getPackageName() + string;
                } else if (string.indexOf(46) < 0) {
                    String str2 = CoordinatorLayout.f1417t;
                    if (!TextUtils.isEmpty(str2)) {
                        string = str2 + '.' + string;
                    }
                }
                try {
                    ThreadLocal threadLocal = CoordinatorLayout.f1419v;
                    Map map = (Map) threadLocal.get();
                    if (map == null) {
                        map = new HashMap();
                        threadLocal.set(map);
                    }
                    Constructor<?> constructor = (Constructor) map.get(string);
                    if (constructor == null) {
                        constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.f1418u);
                        constructor.setAccessible(true);
                        map.put(string, constructor);
                    }
                    behavior = (CoordinatorLayout.Behavior) constructor.newInstance(context, attributeSet);
                } catch (Exception e5) {
                    throw new RuntimeException(AbstractC2460q.m5501o("Could not inflate Behavior subclass ", string), e5);
                }
            }
            this.f1442a = behavior;
        }
        typedArrayObtainStyledAttributes.recycle();
        CoordinatorLayout.Behavior behavior2 = this.f1442a;
        if (behavior2 != null) {
            behavior2.mo921c(this);
        }
    }

    public C0311c(C0311c c0311c) {
        super((ViewGroup.MarginLayoutParams) c0311c);
        this.f1443b = false;
        this.f1444c = 0;
        this.f1445d = 0;
        this.f1446e = -1;
        this.f1447f = -1;
        this.f1448g = 0;
        this.f1449h = 0;
        this.f1457p = new Rect();
    }

    public C0311c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f1443b = false;
        this.f1444c = 0;
        this.f1445d = 0;
        this.f1446e = -1;
        this.f1447f = -1;
        this.f1448g = 0;
        this.f1449h = 0;
        this.f1457p = new Rect();
    }

    public C0311c(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f1443b = false;
        this.f1444c = 0;
        this.f1445d = 0;
        this.f1446e = -1;
        this.f1447f = -1;
        this.f1448g = 0;
        this.f1449h = 0;
        this.f1457p = new Rect();
    }
}
