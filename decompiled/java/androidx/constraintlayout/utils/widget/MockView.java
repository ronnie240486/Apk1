package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import p256y.AbstractC4193j;

public class MockView extends View {

    public final Paint f1271a;

    public final Paint f1272b;

    public final Paint f1273c;

    public boolean f1274d;

    public boolean f1275e;

    public String f1276f;

    public final Rect f1277g;

    public int f1278h;

    public int f1279i;

    public int f1280j;

    public int f1281k;

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1271a = new Paint();
        this.f1272b = new Paint();
        this.f1273c = new Paint();
        this.f1274d = true;
        this.f1275e = true;
        this.f1276f = null;
        this.f1277g = new Rect();
        this.f1278h = Color.argb(255, 0, 0, 0);
        this.f1279i = Color.argb(255, 200, 200, 200);
        this.f1280j = Color.argb(255, 50, 50, 50);
        this.f1281k = 4;
        m867a(context, attributeSet);
    }

    public final void m867a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4193j.f14242h);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i6);
                if (index == 1) {
                    this.f1276f = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == 4) {
                    this.f1274d = typedArrayObtainStyledAttributes.getBoolean(index, this.f1274d);
                } else if (index == 0) {
                    this.f1278h = typedArrayObtainStyledAttributes.getColor(index, this.f1278h);
                } else if (index == 2) {
                    this.f1280j = typedArrayObtainStyledAttributes.getColor(index, this.f1280j);
                } else if (index == 3) {
                    this.f1279i = typedArrayObtainStyledAttributes.getColor(index, this.f1279i);
                } else if (index == 5) {
                    this.f1275e = typedArrayObtainStyledAttributes.getBoolean(index, this.f1275e);
                }
            }
        }
        if (this.f1276f == null) {
            try {
                this.f1276f = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        int i10 = this.f1278h;
        Paint paint = this.f1271a;
        paint.setColor(i10);
        paint.setAntiAlias(true);
        int i11 = this.f1279i;
        Paint paint2 = this.f1272b;
        paint2.setColor(i11);
        paint2.setAntiAlias(true);
        this.f1273c.setColor(this.f1280j);
        this.f1281k = Math.round((getResources().getDisplayMetrics().xdpi / 160.0f) * this.f1281k);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f1274d) {
            width--;
            height--;
            float f = width;
            float f3 = height;
            canvas.drawLine(0.0f, 0.0f, f, f3, this.f1271a);
            canvas.drawLine(0.0f, f3, f, 0.0f, this.f1271a);
            canvas.drawLine(0.0f, 0.0f, f, 0.0f, this.f1271a);
            canvas.drawLine(f, 0.0f, f, f3, this.f1271a);
            canvas.drawLine(f, f3, 0.0f, f3, this.f1271a);
            canvas.drawLine(0.0f, f3, 0.0f, 0.0f, this.f1271a);
        }
        String str = this.f1276f;
        if (str == null || !this.f1275e) {
            return;
        }
        int length = str.length();
        Paint paint = this.f1272b;
        Rect rect = this.f1277g;
        paint.getTextBounds(str, 0, length, rect);
        float fWidth = (width - rect.width()) / 2.0f;
        float fHeight = ((height - rect.height()) / 2.0f) + rect.height();
        rect.offset((int) fWidth, (int) fHeight);
        int i6 = rect.left;
        int i10 = this.f1281k;
        rect.set(i6 - i10, rect.top - i10, rect.right + i10, rect.bottom + i10);
        canvas.drawRect(rect, this.f1273c);
        canvas.drawText(this.f1276f, fWidth, fHeight, paint);
    }

    public MockView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1271a = new Paint();
        this.f1272b = new Paint();
        this.f1273c = new Paint();
        this.f1274d = true;
        this.f1275e = true;
        this.f1276f = null;
        this.f1277g = new Rect();
        this.f1278h = Color.argb(255, 0, 0, 0);
        this.f1279i = Color.argb(255, 200, 200, 200);
        this.f1280j = Color.argb(255, 50, 50, 50);
        this.f1281k = 4;
        m867a(context, attributeSet);
    }
}
