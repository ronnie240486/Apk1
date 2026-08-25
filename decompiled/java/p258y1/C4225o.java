package p258y1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import com.p2serv.android.p032ds.R;
import p001a0.ViewTreeObserverOnPreDrawListenerC0021d;

public final class C4225o extends ViewGroup implements InterfaceC4221m {

    public static final int f14359g = 0;

    public ViewGroup f14360a;

    public View f14361b;

    public final View f14362c;

    public int f14363d;

    public Matrix f14364e;

    public final ViewTreeObserverOnPreDrawListenerC0021d f14365f;

    public C4225o(View view) {
        super(view.getContext());
        this.f14365f = new ViewTreeObserverOnPreDrawListenerC0021d(2, this);
        this.f14362c = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    @Override
    public final void mo7337a(ViewGroup viewGroup, View view) {
        this.f14360a = viewGroup;
        this.f14361b = view;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View view = this.f14362c;
        view.setTag(R.id.ghost_view, this);
        view.getViewTreeObserver().addOnPreDrawListener(this.f14365f);
        AbstractC4210g0.m8258c(4, view);
        if (view.getParent() != null) {
            ((View) view.getParent()).invalidate();
        }
    }

    @Override
    public final void onDetachedFromWindow() {
        View view = this.f14362c;
        view.getViewTreeObserver().removeOnPreDrawListener(this.f14365f);
        AbstractC4210g0.m8258c(0, view);
        view.setTag(R.id.ghost_view, null);
        if (view.getParent() != null) {
            ((View) view.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override
    public final void onDraw(Canvas canvas) {
        AbstractC4233v.m8274d(canvas, true);
        canvas.setMatrix(this.f14364e);
        View view = this.f14362c;
        AbstractC4210g0.m8258c(0, view);
        view.invalidate();
        AbstractC4210g0.m8258c(4, view);
        drawChild(canvas, view, getDrawingTime());
        AbstractC4233v.m8274d(canvas, false);
    }

    @Override
    public final void setVisibility(int i6) {
        super.setVisibility(i6);
        View view = this.f14362c;
        if (((C4225o) view.getTag(R.id.ghost_view)) == this) {
            AbstractC4210g0.m8258c(i6 == 0 ? 4 : 0, view);
        }
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
    }
}
