package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import p007a7.C0069f;
import p055ea.AbstractC2460q;
import p173q1.C3445s0;

final class OverlayListView extends ListView {

    public final ArrayList f3174a;

    public OverlayListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3174a = new ArrayList();
    }

    @Override
    public final void onDraw(Canvas canvas) {
        boolean z7;
        super.onDraw(canvas);
        ArrayList arrayList = this.f3174a;
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C1111r0 c1111r0 = (C1111r0) it.next();
                BitmapDrawable bitmapDrawable = c1111r0.f3349a;
                if (bitmapDrawable != null) {
                    bitmapDrawable.draw(canvas);
                }
                long drawingTime = getDrawingTime();
                if (c1111r0.f3359k) {
                    z7 = false;
                } else {
                    float fMax = c1111r0.f3358j ? Math.max(0.0f, Math.min(1.0f, (drawingTime - c1111r0.f3357i) / c1111r0.f3353e)) : 0.0f;
                    Interpolator interpolator = c1111r0.f3352d;
                    float interpolation = interpolator == null ? fMax : interpolator.getInterpolation(fMax);
                    int i6 = (int) (c1111r0.f3355g * interpolation);
                    Rect rect = c1111r0.f3354f;
                    int i10 = rect.top + i6;
                    Rect rect2 = c1111r0.f3351c;
                    rect2.top = i10;
                    rect2.bottom = rect.bottom + i6;
                    float fM5490d = AbstractC2460q.m5490d(c1111r0.f3356h, 1.0f, interpolation, 1.0f);
                    c1111r0.f3350b = fM5490d;
                    BitmapDrawable bitmapDrawable2 = c1111r0.f3349a;
                    if (bitmapDrawable2 != null) {
                        bitmapDrawable2.setAlpha((int) (fM5490d * 255.0f));
                        bitmapDrawable2.setBounds(rect2);
                    }
                    if (c1111r0.f3358j && fMax >= 1.0f) {
                        c1111r0.f3359k = true;
                        C0069f c0069f = c1111r0.f3360l;
                        if (c0069f != null) {
                            DialogC1116u dialogC1116u = (DialogC1116u) c0069f.f197c;
                            dialogC1116u.f3374I.remove((C3445s0) c0069f.f196b);
                            dialogC1116u.f3370E.notifyDataSetChanged();
                        }
                    }
                    z7 = !c1111r0.f3359k;
                }
                if (!z7) {
                    it.remove();
                }
            }
        }
    }

    public OverlayListView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f3174a = new ArrayList();
    }
}
