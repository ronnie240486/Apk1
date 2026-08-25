package p273z6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import androidx.appcompat.widget.ViewOnLayoutChangeListenerC0268s2;
import com.google.android.material.internal.C1838x;
import com.google.android.material.internal.InterfaceC1837w;
import p189r6.C3639d;
import p221u6.C3906f;
import p221u6.C3908h;
import p221u6.C3909i;
import p221u6.C3912l;

public final class C4357a extends C3908h implements InterfaceC1837w {

    public final C1838x f14783A;

    public final ViewOnLayoutChangeListenerC0268s2 f14784B;

    public final Rect f14785C;

    public int f14786D;

    public int f14787E;

    public int f14788F;

    public int f14789G;

    public int f14790H;

    public int f14791I;

    public float f14792J;

    public float f14793K;

    public float f14794L;

    public float f14795M;

    public CharSequence f14796x;

    public final Context f14797y;

    public final Paint.FontMetrics f14798z;

    public C4357a(Context context, int i6) {
        super(context, null, 0, i6);
        this.f14798z = new Paint.FontMetrics();
        C1838x c1838x = new C1838x(this);
        this.f14783A = c1838x;
        this.f14784B = new ViewOnLayoutChangeListenerC0268s2(3, this);
        this.f14785C = new Rect();
        this.f14792J = 1.0f;
        this.f14793K = 1.0f;
        this.f14794L = 0.5f;
        this.f14795M = 1.0f;
        this.f14797y = context;
        TextPaint textPaint = c1838x.f6494a;
        textPaint.density = context.getResources().getDisplayMetrics().density;
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    public final void draw(Canvas canvas) {
        canvas.save();
        float fM8399w = m8399w();
        float f = (float) (-((Math.sqrt(2.0d) * ((double) this.f14790H)) - ((double) this.f14790H)));
        canvas.scale(this.f14792J, this.f14793K, (getBounds().width() * 0.5f) + getBounds().left, (getBounds().height() * this.f14794L) + getBounds().top);
        canvas.translate(fM8399w, f);
        super.draw(canvas);
        if (this.f14796x != null) {
            Rect bounds = getBounds();
            float fCenterY = bounds.centerY();
            C1838x c1838x = this.f14783A;
            TextPaint textPaint = c1838x.f6494a;
            Paint.FontMetrics fontMetrics = this.f14798z;
            textPaint.getFontMetrics(fontMetrics);
            int i6 = (int) (fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f));
            C3639d c3639d = c1838x.f6499f;
            TextPaint textPaint2 = c1838x.f6494a;
            if (c3639d != null) {
                textPaint2.drawableState = getState();
                c1838x.f6499f.m7367e(this.f14797y, textPaint2, c1838x.f6495b);
                textPaint2.setAlpha((int) (this.f14795M * 255.0f));
            }
            CharSequence charSequence = this.f14796x;
            canvas.drawText(charSequence, 0, charSequence.length(), bounds.centerX(), i6, textPaint2);
        }
        canvas.restore();
    }

    @Override
    public final int getIntrinsicHeight() {
        return (int) Math.max(this.f14783A.f6494a.getTextSize(), this.f14788F);
    }

    @Override
    public final int getIntrinsicWidth() {
        float f = this.f14786D * 2;
        CharSequence charSequence = this.f14796x;
        return (int) Math.max(f + (charSequence == null ? 0.0f : this.f14783A.m4285a(charSequence.toString())), this.f14787E);
    }

    @Override
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        C3912l c3912lM7826f = this.f13126a.f13107a.m7826f();
        c3912lM7826f.f13161k = m8400x();
        setShapeAppearanceModel(c3912lM7826f.m7819a());
    }

    public final float m8399w() {
        int i6;
        Rect rect = this.f14785C;
        if (((rect.right - getBounds().right) - this.f14791I) - this.f14789G < 0) {
            i6 = ((rect.right - getBounds().right) - this.f14791I) - this.f14789G;
        } else {
            if (((rect.left - getBounds().left) - this.f14791I) + this.f14789G <= 0) {
                return 0.0f;
            }
            i6 = ((rect.left - getBounds().left) - this.f14791I) + this.f14789G;
        }
        return i6;
    }

    public final C3909i m8400x() {
        float f = -m8399w();
        float fWidth = ((float) (((double) getBounds().width()) - (Math.sqrt(2.0d) * ((double) this.f14790H)))) / 2.0f;
        return new C3909i(new C3906f(this.f14790H), Math.min(Math.max(f, -fWidth), fWidth));
    }
}
