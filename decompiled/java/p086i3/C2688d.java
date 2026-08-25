package p086i3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import java.util.ArrayList;
import p186r3.AbstractC3602f;

public final class C2688d extends Drawable implements InterfaceC2691g, Animatable {

    public final C2687c f9337a;

    public boolean f9338b;

    public boolean f9339c;

    public boolean f9340d;

    public int f9342f;

    public boolean f9344h;

    public Paint f9345i;

    public Rect f9346j;

    public boolean f9341e = true;

    public final int f9343g = -1;

    public C2688d(C2687c c2687c) {
        AbstractC3602f.m7225c(c2687c, "Argument must not be null");
        this.f9337a = c2687c;
    }

    public final void m5690a() {
        AbstractC3602f.m7223a("You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.", !this.f9340d);
        C2693i c2693i = (C2693i) this.f9337a.f9336b;
        if (c2693i.f9354a.f12832l.f12808c == 1) {
            invalidateSelf();
            return;
        }
        if (this.f9338b) {
            return;
        }
        this.f9338b = true;
        if (c2693i.f9363j) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        ArrayList arrayList = c2693i.f9356c;
        if (arrayList.contains(this)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = arrayList.isEmpty();
        arrayList.add(this);
        if (zIsEmpty && !c2693i.f9359f) {
            c2693i.f9359f = true;
            c2693i.f9363j = false;
            c2693i.m5691a();
        }
        invalidateSelf();
    }

    @Override
    public final void draw(Canvas canvas) {
        if (this.f9340d) {
            return;
        }
        if (this.f9344h) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.f9346j == null) {
                this.f9346j = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.f9346j);
            this.f9344h = false;
        }
        C2693i c2693i = (C2693i) this.f9337a.f9336b;
        C2690f c2690f = c2693i.f9362i;
        Bitmap bitmap = c2690f != null ? c2690f.f9351g : c2693i.f9365l;
        if (this.f9346j == null) {
            this.f9346j = new Rect();
        }
        Rect rect = this.f9346j;
        if (this.f9345i == null) {
            this.f9345i = new Paint(2);
        }
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.f9345i);
    }

    @Override
    public final Drawable.ConstantState getConstantState() {
        return this.f9337a;
    }

    @Override
    public final int getIntrinsicHeight() {
        return ((C2693i) this.f9337a.f9336b).f9369p;
    }

    @Override
    public final int getIntrinsicWidth() {
        return ((C2693i) this.f9337a.f9336b).f9368o;
    }

    @Override
    public final int getOpacity() {
        return -2;
    }

    @Override
    public final boolean isRunning() {
        return this.f9338b;
    }

    @Override
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f9344h = true;
    }

    @Override
    public final void setAlpha(int i6) {
        if (this.f9345i == null) {
            this.f9345i = new Paint(2);
        }
        this.f9345i.setAlpha(i6);
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f9345i == null) {
            this.f9345i = new Paint(2);
        }
        this.f9345i.setColorFilter(colorFilter);
    }

    @Override
    public final boolean setVisible(boolean z7, boolean z10) {
        AbstractC3602f.m7223a("Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.", !this.f9340d);
        this.f9341e = z7;
        if (!z7) {
            this.f9338b = false;
            C2693i c2693i = (C2693i) this.f9337a.f9336b;
            ArrayList arrayList = c2693i.f9356c;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                c2693i.f9359f = false;
            }
        } else if (this.f9339c) {
            m5690a();
        }
        return super.setVisible(z7, z10);
    }

    @Override
    public final void start() {
        this.f9339c = true;
        this.f9342f = 0;
        if (this.f9341e) {
            m5690a();
        }
    }

    @Override
    public final void stop() {
        this.f9339c = false;
        this.f9338b = false;
        C2693i c2693i = (C2693i) this.f9337a.f9336b;
        ArrayList arrayList = c2693i.f9356c;
        arrayList.remove(this);
        if (arrayList.isEmpty()) {
            c2693i.f9359f = false;
        }
    }
}
