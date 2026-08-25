package androidx.appcompat.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

public final class C0194d3 extends TouchDelegate {

    public final View f888a;

    public final Rect f889b;

    public final Rect f890c;

    public final Rect f891d;

    public final int f892e;

    public boolean f893f;

    public C0194d3(Rect rect, Rect rect2, View view) {
        super(rect, view);
        int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f892e = scaledTouchSlop;
        Rect rect3 = new Rect();
        this.f889b = rect3;
        Rect rect4 = new Rect();
        this.f891d = rect4;
        Rect rect5 = new Rect();
        this.f890c = rect5;
        rect3.set(rect);
        rect4.set(rect);
        int i6 = -scaledTouchSlop;
        rect4.inset(i6, i6);
        rect5.set(rect2);
        this.f888a = view;
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        boolean z10;
        int x10 = (int) motionEvent.getX();
        int y7 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z11 = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                z10 = this.f893f;
                if (z10 && !this.f891d.contains(x10, y7)) {
                    z11 = z10;
                    z7 = false;
                }
            } else if (action != 3) {
                z7 = true;
                z11 = false;
            } else {
                z10 = this.f893f;
                this.f893f = false;
            }
            z11 = z10;
            z7 = true;
        } else if (this.f889b.contains(x10, y7)) {
            this.f893f = true;
            z7 = true;
        } else {
            z7 = true;
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        Rect rect = this.f890c;
        View view = this.f888a;
        if (!z7 || rect.contains(x10, y7)) {
            motionEvent.setLocation(x10 - rect.left, y7 - rect.top);
        } else {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        }
        return view.dispatchTouchEvent(motionEvent);
    }
}
