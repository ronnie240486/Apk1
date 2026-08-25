package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import p015b2.AbstractC1249a;
import p015b2.C1251c;
import p015b2.C1252d;
import p015b2.InterfaceC1254f;
import p015b2.InterfaceC1258j;
import p143n5.AbstractC3198d;

@InterfaceC1254f
public class PagerTitleStrip extends ViewGroup {

    public static final int[] f3835o = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    public static final int[] f3836p = {R.attr.textAllCaps};

    public ViewPager f3837a;

    public final TextView f3838b;

    public final TextView f3839c;

    public final TextView f3840d;

    public int f3841e;

    public float f3842f;

    public int f3843g;

    public int f3844h;

    public boolean f3845i;

    public boolean f3846j;

    public final C1251c f3847k;

    public WeakReference f3848l;

    public int f3849m;

    public int f3850n;

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3841e = -1;
        this.f3842f = -1.0f;
        this.f3847k = new C1251c(this);
        TextView textView = new TextView(context);
        this.f3838b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f3839c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f3840d = textView3;
        addView(textView3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3835o);
        boolean z7 = false;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            AbstractC3198d.m6443R(textView, resourceId);
            AbstractC3198d.m6443R(textView2, resourceId);
            AbstractC3198d.m6443R(textView3, resourceId);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            float f = dimensionPixelSize;
            textView.setTextSize(0, f);
            textView2.setTextSize(0, f);
            textView3.setTextSize(0, f);
        }
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            int color = typedArrayObtainStyledAttributes.getColor(2, 0);
            textView.setTextColor(color);
            textView2.setTextColor(color);
            textView3.setTextColor(color);
        }
        this.f3844h = typedArrayObtainStyledAttributes.getInteger(3, 80);
        typedArrayObtainStyledAttributes.recycle();
        this.f3850n = textView2.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView2.setEllipsize(truncateAt);
        textView3.setEllipsize(truncateAt);
        if (resourceId != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f3836p);
            z7 = typedArrayObtainStyledAttributes2.getBoolean(0, false);
            typedArrayObtainStyledAttributes2.recycle();
        }
        if (z7) {
            setSingleLineAllCaps(textView);
            setSingleLineAllCaps(textView2);
            setSingleLineAllCaps(textView3);
        } else {
            textView.setSingleLine();
            textView2.setSingleLine();
            textView3.setSingleLine();
        }
        this.f3843g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        Context context = textView.getContext();
        C1252d c1252d = new C1252d();
        c1252d.f3976a = context.getResources().getConfiguration().locale;
        textView.setTransformationMethod(c1252d);
    }

    public final void m3079a(AbstractC1249a abstractC1249a, AbstractC1249a abstractC1249a2) {
        C1251c c1251c = this.f3847k;
        if (abstractC1249a != null) {
            abstractC1249a.f3970a.unregisterObserver(c1251c);
            this.f3848l = null;
        }
        if (abstractC1249a2 != null) {
            abstractC1249a2.f3970a.registerObserver(c1251c);
            this.f3848l = new WeakReference(abstractC1249a2);
        }
        ViewPager viewPager = this.f3837a;
        if (viewPager != null) {
            this.f3841e = -1;
            this.f3842f = -1.0f;
            m3080b(viewPager.getCurrentItem(), abstractC1249a2);
            requestLayout();
        }
    }

    public final void m3080b(int i6, AbstractC1249a abstractC1249a) {
        if (abstractC1249a != null) {
            abstractC1249a.mo3131c();
        }
        this.f3845i = true;
        TextView textView = this.f3838b;
        textView.setText((CharSequence) null);
        TextView textView2 = this.f3839c;
        textView2.setText((CharSequence) null);
        int i10 = i6 + 1;
        TextView textView3 = this.f3840d;
        textView3.setText((CharSequence) null);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        textView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        textView2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        textView3.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f3841e = i6;
        if (!this.f3846j) {
            mo3078c(this.f3842f, i6, false);
        }
        this.f3845i = false;
    }

    public void mo3078c(float f, int i6, boolean z7) {
        int i10;
        int i11;
        int i12;
        int i13;
        if (i6 != this.f3841e) {
            m3080b(i6, this.f3837a.getAdapter());
        } else if (!z7 && f == this.f3842f) {
            return;
        }
        this.f3846j = true;
        TextView textView = this.f3838b;
        int measuredWidth = textView.getMeasuredWidth();
        TextView textView2 = this.f3839c;
        int measuredWidth2 = textView2.getMeasuredWidth();
        TextView textView3 = this.f3840d;
        int measuredWidth3 = textView3.getMeasuredWidth();
        int i14 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i15 = paddingRight + i14;
        int i16 = (width - (paddingLeft + i14)) - i15;
        float f3 = f + 0.5f;
        if (f3 > 1.0f) {
            f3 -= 1.0f;
        }
        int i17 = ((width - i15) - ((int) (i16 * f3))) - i14;
        int i18 = measuredWidth2 + i17;
        int baseline = textView.getBaseline();
        int baseline2 = textView2.getBaseline();
        int baseline3 = textView3.getBaseline();
        int iMax = Math.max(Math.max(baseline, baseline2), baseline3);
        int i19 = iMax - baseline;
        int i20 = iMax - baseline2;
        int i21 = iMax - baseline3;
        int iMax2 = Math.max(Math.max(textView.getMeasuredHeight() + i19, textView2.getMeasuredHeight() + i20), textView3.getMeasuredHeight() + i21);
        int i22 = this.f3844h & 112;
        if (i22 != 16) {
            if (i22 != 80) {
                i11 = i19 + paddingTop;
                i12 = i20 + paddingTop;
                i13 = paddingTop + i21;
            } else {
                i10 = (height - paddingBottom) - iMax2;
            }
            textView2.layout(i17, i12, i18, textView2.getMeasuredHeight() + i12);
            int iMin = Math.min(paddingLeft, (i17 - this.f3843g) - measuredWidth);
            textView.layout(iMin, i11, measuredWidth + iMin, textView.getMeasuredHeight() + i11);
            int iMax3 = Math.max((width - paddingRight) - measuredWidth3, i18 + this.f3843g);
            textView3.layout(iMax3, i13, iMax3 + measuredWidth3, textView3.getMeasuredHeight() + i13);
            this.f3842f = f;
            this.f3846j = false;
        }
        i10 = (((height - paddingTop) - paddingBottom) - iMax2) / 2;
        i11 = i19 + i10;
        i12 = i20 + i10;
        i13 = i10 + i21;
        textView2.layout(i17, i12, i18, textView2.getMeasuredHeight() + i12);
        int iMin2 = Math.min(paddingLeft, (i17 - this.f3843g) - measuredWidth);
        textView.layout(iMin2, i11, measuredWidth + iMin2, textView.getMeasuredHeight() + i11);
        int iMax4 = Math.max((width - paddingRight) - measuredWidth3, i18 + this.f3843g);
        textView3.layout(iMax4, i13, iMax4 + measuredWidth3, textView3.getMeasuredHeight() + i13);
        this.f3842f = f;
        this.f3846j = false;
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f3843g;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        AbstractC1249a adapter = viewPager.getAdapter();
        C1251c c1251c = this.f3847k;
        viewPager.f3872S = c1251c;
        if (viewPager.f3873T == null) {
            viewPager.f3873T = new ArrayList();
        }
        viewPager.f3873T.add(c1251c);
        this.f3837a = viewPager;
        WeakReference weakReference = this.f3848l;
        m3079a(weakReference != null ? (AbstractC1249a) weakReference.get() : null, adapter);
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f3837a;
        if (viewPager != null) {
            m3079a(viewPager.getAdapter(), null);
            ViewPager viewPager2 = this.f3837a;
            InterfaceC1258j interfaceC1258j = viewPager2.f3872S;
            viewPager2.f3872S = null;
            ArrayList arrayList = viewPager2.f3873T;
            if (arrayList != null) {
                arrayList.remove(this.f3847k);
            }
            this.f3837a = null;
        }
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        if (this.f3837a != null) {
            float f = this.f3842f;
            if (f < 0.0f) {
                f = 0.0f;
            }
            mo3078c(f, this.f3841e, true);
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int iMax;
        if (View.MeasureSpec.getMode(i6) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, paddingBottom, -2);
        int size = View.MeasureSpec.getSize(i6);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i6, (int) (size * 0.2f), -2);
        this.f3838b.measure(childMeasureSpec2, childMeasureSpec);
        TextView textView = this.f3839c;
        textView.measure(childMeasureSpec2, childMeasureSpec);
        this.f3840d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            iMax = View.MeasureSpec.getSize(i10);
        } else {
            iMax = Math.max(getMinHeight(), textView.getMeasuredHeight() + paddingBottom);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(iMax, i10, textView.getMeasuredState() << 16));
    }

    @Override
    public final void requestLayout() {
        if (this.f3845i) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i6) {
        this.f3844h = i6;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f) {
        int i6 = ((int) (f * 255.0f)) & 255;
        this.f3849m = i6;
        int i10 = (i6 << 24) | (this.f3850n & 16777215);
        this.f3838b.setTextColor(i10);
        this.f3840d.setTextColor(i10);
    }

    public void setTextColor(int i6) {
        this.f3850n = i6;
        this.f3839c.setTextColor(i6);
        int i10 = (this.f3849m << 24) | (this.f3850n & 16777215);
        this.f3838b.setTextColor(i10);
        this.f3840d.setTextColor(i10);
    }

    public void setTextSpacing(int i6) {
        this.f3843g = i6;
        requestLayout();
    }
}
