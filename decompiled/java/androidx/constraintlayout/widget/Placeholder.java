package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import p256y.AbstractC4193j;

public class Placeholder extends View {

    public int f1393a;

    public View f1394b;

    public int f1395c;

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1393a = -1;
        this.f1394b = null;
        this.f1395c = 4;
        m885a(attributeSet);
    }

    public final void m885a(AttributeSet attributeSet) {
        super.setVisibility(this.f1395c);
        this.f1393a = -1;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC4193j.f14237c);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i6);
                if (index == 0) {
                    this.f1393a = typedArrayObtainStyledAttributes.getResourceId(index, this.f1393a);
                } else if (index == 1) {
                    this.f1395c = typedArrayObtainStyledAttributes.getInt(index, this.f1395c);
                }
            }
        }
    }

    public View getContent() {
        return this.f1394b;
    }

    public int getEmptyVisibility() {
        return this.f1395c;
    }

    @Override
    public final void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int iHeight = rect.height();
            int iWidth = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((iWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((rect.height() / 2.0f) + (iHeight / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i6) {
        View viewFindViewById;
        if (this.f1393a == i6) {
            return;
        }
        View view = this.f1394b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.LayoutParams) this.f1394b.getLayoutParams()).f1342a0 = false;
            this.f1394b = null;
        }
        this.f1393a = i6;
        if (i6 == -1 || (viewFindViewById = ((View) getParent()).findViewById(i6)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i6) {
        this.f1395c = i6;
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1393a = -1;
        this.f1394b = null;
        this.f1395c = 4;
        m885a(attributeSet);
    }
}
