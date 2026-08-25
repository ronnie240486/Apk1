package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.bumptech.glide.AbstractC1466d;
import com.p2serv.android.p032ds.R;
import java.util.Arrays;
import p101j7.C2782c;
import p138n0.AbstractC3155s0;
import p222u7.AbstractC3928d;
import p250x5.AbstractC4121a;

class ClockFaceView extends RadialViewGroup implements InterfaceC1887d {

    public final int f6910A;

    public final int f6911B;

    public final int f6912C;

    public final int f6913D;

    public final String[] f6914E;

    public float f6915F;

    public final ColorStateList f6916G;

    public final ClockHandView f6917t;

    public final Rect f6918u;

    public final RectF f6919v;

    public final SparseArray f6920w;

    public final C1886c f6921x;

    public final int[] f6922y;

    public final float[] f6923z;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) C2782c.m5751x(1, this.f6914E.length, 1, false).f9501b);
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        m4408p();
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = (int) (this.f6913D / Math.max(Math.max(this.f6911B / displayMetrics.heightPixels, this.f6912C / displayMetrics.widthPixels), 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
        setMeasuredDimension(iMax, iMax);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    public final void m4408p() {
        RadialGradient radialGradient;
        RectF rectF = this.f6917t.f6928e;
        int i6 = 0;
        while (true) {
            SparseArray sparseArray = this.f6920w;
            if (i6 >= sparseArray.size()) {
                return;
            }
            TextView textView = (TextView) sparseArray.get(i6);
            if (textView != null) {
                Rect rect = this.f6918u;
                textView.getDrawingRect(rect);
                offsetDescendantRectToMyCoords(textView, rect);
                textView.setSelected(rectF.contains(rect.centerX(), rect.centerY()));
                RectF rectF2 = this.f6919v;
                rectF2.set(rect);
                rectF2.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                if (RectF.intersects(rectF, rectF2)) {
                    radialGradient = new RadialGradient(rectF.centerX() - rectF2.left, rectF.centerY() - rectF2.top, 0.5f * rectF.width(), this.f6922y, this.f6923z, Shader.TileMode.CLAMP);
                } else {
                    radialGradient = null;
                }
                textView.getPaint().setShader(radialGradient);
                textView.invalidate();
            }
            i6++;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f6918u = new Rect();
        this.f6919v = new RectF();
        SparseArray sparseArray = new SparseArray();
        this.f6920w = sparseArray;
        this.f6923z = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4121a.f13998l, i6, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListM3493k = AbstractC1466d.m3493k(context, typedArrayObtainStyledAttributes, 1);
        this.f6916G = colorStateListM3493k;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.f6917t = clockHandView;
        this.f6910A = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateListM3493k.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListM3493k.getDefaultColor());
        this.f6922y = new int[]{colorForState, colorForState, colorStateListM3493k.getDefaultColor()};
        clockHandView.f6924a.add(this);
        int defaultColor = AbstractC3928d.m7848k(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListM3493k2 = AbstractC1466d.m3493k(context, typedArrayObtainStyledAttributes, 0);
        setBackgroundColor(colorStateListM3493k2 != null ? colorStateListM3493k2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC1885b(this));
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.f6921x = new C1886c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.f6914E = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        for (int i10 = 0; i10 < Math.max(this.f6914E.length, size); i10++) {
            TextView textView = (TextView) sparseArray.get(i10);
            if (i10 >= this.f6914E.length) {
                removeView(textView);
                sparseArray.remove(i10);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i10, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.f6914E[i10]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i10));
                AbstractC3155s0.m6347q(textView, this.f6921x);
                textView.setTextColor(this.f6916G);
            }
        }
        this.f6911B = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.f6912C = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.f6913D = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }
}
