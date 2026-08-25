package androidx.leanback.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.widget.TextView;
import p075h1.AbstractC2639a;
import p143n5.AbstractC3198d;

@SuppressLint({"AppCompatCustomView"})
class ResizingTextView extends TextView {

    public final int f2208a;

    public final int f2209b;

    public final boolean f2210c;

    public final int f2211d;

    public final int f2212e;

    public boolean f2213f;

    public int f2214g;

    public float f2215h;

    public int f2216i;

    public int f2217j;

    public ResizingTextView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2213f = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2639a.f9165i, i6, 0);
        try {
            this.f2208a = typedArrayObtainStyledAttributes.getInt(1, 1);
            this.f2209b = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, -1);
            this.f2210c = typedArrayObtainStyledAttributes.getBoolean(0, false);
            this.f2211d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0);
            this.f2212e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void m1394a(int i6, int i10) {
        if (isPaddingRelative()) {
            setPaddingRelative(getPaddingStart(), i6, getPaddingEnd(), i10);
        } else {
            setPadding(getPaddingLeft(), i6, getPaddingRight(), i10);
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        boolean z7;
        int i11;
        boolean z10 = true;
        if (!this.f2213f) {
            this.f2214g = (int) getTextSize();
            this.f2215h = getLineSpacingExtra();
            this.f2216i = getPaddingTop();
            this.f2217j = getPaddingBottom();
            this.f2213f = true;
        }
        boolean z11 = false;
        setTextSize(0, this.f2214g);
        setLineSpacing(this.f2215h, getLineSpacingMultiplier());
        m1394a(this.f2216i, this.f2217j);
        super.onMeasure(i6, i10);
        Layout layout = getLayout();
        if (layout == null || (this.f2208a & 1) <= 0) {
            z7 = false;
        } else {
            int lineCount = layout.getLineCount();
            int maxLines = getMaxLines();
            if (maxLines <= 1 || lineCount != maxLines) {
                z7 = false;
            } else {
                z7 = true;
            }
        }
        int textSize = (int) getTextSize();
        boolean z12 = this.f2210c;
        int i12 = this.f2209b;
        if (z7) {
            if (i12 != -1 && textSize != i12) {
                setTextSize(0, i12);
                z11 = true;
            }
            float f = (this.f2215h + this.f2214g) - i12;
            if (z12 && getLineSpacingExtra() != f) {
                setLineSpacing(f, getLineSpacingMultiplier());
                z11 = true;
            }
            int i13 = this.f2216i + this.f2211d;
            int i14 = this.f2217j + this.f2212e;
            if (getPaddingTop() == i13 && getPaddingBottom() == i14) {
                z10 = z11;
            } else {
                m1394a(i13, i14);
            }
        } else {
            if (i12 != -1 && textSize != (i11 = this.f2214g)) {
                setTextSize(0, i11);
                z11 = true;
            }
            if (z12) {
                float lineSpacingExtra = getLineSpacingExtra();
                float f3 = this.f2215h;
                if (lineSpacingExtra != f3) {
                    setLineSpacing(f3, getLineSpacingMultiplier());
                    z11 = true;
                }
            }
            if (getPaddingTop() == this.f2216i && getPaddingBottom() == this.f2217j) {
                z10 = z11;
            } else {
                m1394a(this.f2216i, this.f2217j);
            }
        }
        if (z10) {
            super.onMeasure(i6, i10);
        }
    }

    @Override
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC3198d.m6449X(callback, this));
    }

    public ResizingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }
}
