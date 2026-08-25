package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.WeakHashMap;
import p006a6.C0062a;
import p124l6.C2987m;
import p138n0.AbstractC3155s0;
import p258y1.AbstractC4210g0;
import p258y1.C4206e0;

public class ChangeClipBounds extends Transition {

    public static final String[] f3762x = {"android:clipBounds:clip"};

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static void m3034F(C4206e0 c4206e0) {
        View view = c4206e0.f14293b;
        if (view.getVisibility() == 8) {
            return;
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        Rect clipBounds = view.getClipBounds();
        HashMap map = c4206e0.f14292a;
        map.put("android:clipBounds:clip", clipBounds);
        if (clipBounds == null) {
            map.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
        }
    }

    @Override
    public final void mo3030c(C4206e0 c4206e0) {
        m3034F(c4206e0);
    }

    @Override
    public final void mo3031f(C4206e0 c4206e0) {
        m3034F(c4206e0);
    }

    @Override
    public final Animator mo3032j(ViewGroup viewGroup, C4206e0 c4206e0, C4206e0 c4206e1) {
        if (c4206e0 != null && c4206e1 != null) {
            HashMap map = c4206e0.f14292a;
            if (map.containsKey("android:clipBounds:clip")) {
                HashMap map2 = c4206e1.f14292a;
                if (map2.containsKey("android:clipBounds:clip")) {
                    Rect rect = (Rect) map.get("android:clipBounds:clip");
                    Rect rect2 = (Rect) map2.get("android:clipBounds:clip");
                    boolean z7 = rect2 == null;
                    if (rect == null && rect2 == null) {
                        return null;
                    }
                    if (rect == null) {
                        rect = (Rect) map.get("android:clipBounds:bounds");
                    } else if (rect2 == null) {
                        rect2 = (Rect) map2.get("android:clipBounds:bounds");
                    }
                    if (rect.equals(rect2)) {
                        return null;
                    }
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    View view = c4206e1.f14293b;
                    view.setClipBounds(rect);
                    Rect rect3 = new Rect();
                    C2987m c2987m = new C2987m(2);
                    c2987m.f10247b = rect3;
                    ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, AbstractC4210g0.f14315c, c2987m, rect, rect2);
                    if (z7) {
                        objectAnimatorOfObject.addListener(new C0062a(7, view));
                    }
                    return objectAnimatorOfObject;
                }
            }
        }
        return null;
    }

    @Override
    public final String[] mo3033o() {
        return f3762x;
    }
}
