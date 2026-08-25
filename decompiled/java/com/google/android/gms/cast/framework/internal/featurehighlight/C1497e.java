package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.mediarouter.app.MediaRouteButton;
import com.p2serv.android.p032ds.R;
import p002a1.C0026b;
import p101j7.C2782c;

public final class C1497e extends ViewGroup {

    public final int[] f4812a;

    public final Rect f4813b;

    public final Rect f4814c;

    public final OuterHighlightDrawable f4815d;

    public final InnerZoneDrawable f4816e;

    public MediaRouteButton f4817f;

    public AnimatorSet f4818g;

    public final C1498f f4819h;

    public final C2782c f4820i;

    public C2782c f4821j;

    public C0026b f4822k;

    public boolean f4823l;

    public HelpTextView f4824m;

    public C1497e(Activity activity) {
        super(activity);
        this.f4812a = new int[2];
        this.f4813b = new Rect();
        this.f4814c = new Rect();
        setId(R.id.cast_featurehighlight_view);
        setWillNotDraw(false);
        InnerZoneDrawable innerZoneDrawable = new InnerZoneDrawable(activity);
        this.f4816e = innerZoneDrawable;
        innerZoneDrawable.setCallback(this);
        OuterHighlightDrawable outerHighlightDrawable = new OuterHighlightDrawable(activity);
        this.f4815d = outerHighlightDrawable;
        outerHighlightDrawable.setCallback(this);
        this.f4819h = new C1498f(this);
        C2782c c2782c = new C2782c(activity, new C1493a(this));
        this.f4820i = c2782c;
        ((GestureDetector) c2782c.f9501b).setIsLongpressEnabled(false);
        setVisibility(8);
    }

    @Override
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    @Override
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override
    public final void onDraw(Canvas canvas) {
        canvas.save();
        OuterHighlightDrawable outerHighlightDrawable = this.f4815d;
        outerHighlightDrawable.draw(canvas);
        this.f4816e.draw(canvas);
        MediaRouteButton mediaRouteButton = this.f4817f;
        if (mediaRouteButton == null) {
            throw new IllegalStateException("Neither target view nor drawable was set");
        }
        if (mediaRouteButton.getParent() != null) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f4817f.getWidth(), this.f4817f.getHeight(), Bitmap.Config.ARGB_8888);
            this.f4817f.draw(new Canvas(bitmapCreateBitmap));
            int color = outerHighlightDrawable.f4799f.getColor();
            int iRed = Color.red(color);
            int iGreen = Color.green(color);
            int iBlue = Color.blue(color);
            for (int i6 = 0; i6 < bitmapCreateBitmap.getHeight(); i6++) {
                for (int i10 = 0; i10 < bitmapCreateBitmap.getWidth(); i10++) {
                    int pixel = bitmapCreateBitmap.getPixel(i10, i6);
                    if (Color.alpha(pixel) != 0) {
                        bitmapCreateBitmap.setPixel(i10, i6, Color.argb(Color.alpha(pixel), iRed, iGreen, iBlue));
                    }
                }
            }
            Rect rect = this.f4813b;
            canvas.drawBitmap(bitmapCreateBitmap, rect.left, rect.top, (Paint) null);
        }
        canvas.restore();
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        MediaRouteButton mediaRouteButton = this.f4817f;
        if (mediaRouteButton == null) {
            throw new IllegalStateException("Target view must be set before layout");
        }
        ViewParent parent = mediaRouteButton.getParent();
        int[] iArr = this.f4812a;
        if (parent != null) {
            MediaRouteButton mediaRouteButton2 = this.f4817f;
            getLocationInWindow(iArr);
            int i13 = iArr[0];
            int i14 = iArr[1];
            mediaRouteButton2.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i13;
            iArr[1] = iArr[1] - i14;
        }
        int i15 = iArr[0];
        int i16 = iArr[1];
        int width = this.f4817f.getWidth() + i15;
        int height = this.f4817f.getHeight() + iArr[1];
        Rect rect = this.f4813b;
        rect.set(i15, i16, width, height);
        Rect rect2 = this.f4814c;
        rect2.set(i6, i10, i11, i12);
        this.f4815d.setBounds(rect2);
        this.f4816e.setBounds(rect2);
        C1498f c1498f = this.f4819h;
        C1497e c1497e = (C1497e) c1498f.f4831g;
        View viewAsView = c1497e.f4824m.asView();
        if (rect.isEmpty() || rect2.isEmpty()) {
            viewAsView.layout(0, 0, 0, 0);
        } else {
            int iCenterY = rect.centerY();
            int iCenterX = rect.centerX();
            int iCenterY2 = rect2.centerY();
            int iHeight = rect.height();
            int i17 = c1498f.f4826b;
            int iMax = Math.max(i17 + i17, iHeight) / 2;
            int i18 = iCenterY + iMax;
            int i19 = c1498f.f4827c;
            if (iCenterY < iCenterY2) {
                int i20 = i18 + i19;
                c1498f.m3621k(viewAsView, rect2.width(), rect2.bottom - i20);
                int iM3620j = c1498f.m3620j(viewAsView, rect2.left, rect2.right, viewAsView.getMeasuredWidth(), iCenterX);
                viewAsView.layout(iM3620j, i20, viewAsView.getMeasuredWidth() + iM3620j, viewAsView.getMeasuredHeight() + i20);
            } else {
                int i21 = (iCenterY - iMax) - i19;
                c1498f.m3621k(viewAsView, rect2.width(), i21 - rect2.top);
                int iM3620j2 = c1498f.m3620j(viewAsView, rect2.left, rect2.right, viewAsView.getMeasuredWidth(), iCenterX);
                viewAsView.layout(iM3620j2, i21 - viewAsView.getMeasuredHeight(), viewAsView.getMeasuredWidth() + iM3620j2, i21);
            }
        }
        int left = viewAsView.getLeft();
        int top = viewAsView.getTop();
        int right = viewAsView.getRight();
        int bottom = viewAsView.getBottom();
        Rect rect3 = (Rect) c1498f.f4830f;
        rect3.set(left, top, right, bottom);
        OuterHighlightDrawable outerHighlightDrawable = c1497e.f4815d;
        outerHighlightDrawable.f4797d.set(rect);
        outerHighlightDrawable.f4798e.set(rect3);
        float fExactCenterX = rect.exactCenterX();
        float fExactCenterY = rect.exactCenterY();
        Rect bounds = outerHighlightDrawable.getBounds();
        if (Math.min(fExactCenterY - bounds.top, bounds.bottom - fExactCenterY) < outerHighlightDrawable.f4794a) {
            outerHighlightDrawable.f4802i = fExactCenterX;
            outerHighlightDrawable.f4803j = fExactCenterY;
        } else {
            float fExactCenterX2 = bounds.exactCenterX();
            int i22 = outerHighlightDrawable.f4795b;
            outerHighlightDrawable.f4802i = fExactCenterX <= fExactCenterX2 ? rect3.exactCenterX() + i22 : rect3.exactCenterX() - i22;
            fExactCenterY = rect3.exactCenterY();
            outerHighlightDrawable.f4803j = fExactCenterY;
        }
        outerHighlightDrawable.f4800g = outerHighlightDrawable.f4796c + Math.max(OuterHighlightDrawable.m3610a(outerHighlightDrawable.f4802i, fExactCenterY, rect), OuterHighlightDrawable.m3610a(outerHighlightDrawable.f4802i, outerHighlightDrawable.f4803j, rect3));
        outerHighlightDrawable.invalidateSelf();
        InnerZoneDrawable innerZoneDrawable = c1497e.f4816e;
        Rect rect4 = innerZoneDrawable.f4785c;
        rect4.set(rect);
        innerZoneDrawable.f4790h = rect4.exactCenterX();
        innerZoneDrawable.f4791i = rect4.exactCenterY();
        innerZoneDrawable.f4788f = Math.max(innerZoneDrawable.f4786d, Math.max(rect4.width() / 2.0f, rect4.height() / 2.0f));
        innerZoneDrawable.invalidateSelf();
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        setMeasuredDimension(View.resolveSize(View.MeasureSpec.getSize(i6), i6), View.resolveSize(View.MeasureSpec.getSize(i10), i10));
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f4823l = this.f4813b.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            actionMasked = 0;
        }
        if (this.f4823l) {
            C2782c c2782c = this.f4821j;
            if (c2782c != null) {
                ((GestureDetector) c2782c.f9501b).onTouchEvent(motionEvent);
                if (actionMasked == 1) {
                    motionEvent = MotionEvent.obtain(motionEvent);
                    motionEvent.setAction(3);
                }
            }
            if (this.f4817f.getParent() != null) {
                this.f4817f.onTouchEvent(motionEvent);
            }
        } else {
            ((GestureDetector) this.f4820i.f9501b).onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4815d || drawable == this.f4816e || drawable == null;
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }
}
