package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.bumptech.glide.AbstractC1465c;
import com.bumptech.glide.AbstractC1466d;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;
import p002a1.C0026b;
import p014b1.C1235i;
import p045e.AbstractC2341a;
import p065g0.AbstractC2581a;
import p083i.C2677a;
import p138n0.AbstractC3155s0;
import p138n0.C3107c0;
import p143n5.AbstractC3198d;
import p222u7.AbstractC3928d;

public class SwitchCompat extends CompoundButton {

    public static final C0209g3 f762R = new C0209g3("thumbPos", Float.class, 0);

    public static final int[] f763S = {R.attr.state_checked};

    public int f764A;

    public int f765B;

    public int f766C;

    public int f767D;

    public int f768E;

    public int f769F;

    public int f770G;

    public boolean f771H;

    public final TextPaint f772I;

    public final ColorStateList f773J;

    public StaticLayout f774K;

    public StaticLayout f775L;

    public final C2677a f776M;

    public ObjectAnimator f777N;

    public C0295y f778O;

    public C0219i3 f779P;

    public final Rect f780Q;

    public Drawable f781a;

    public ColorStateList f782b;

    public PorterDuff.Mode f783c;

    public boolean f784d;

    public boolean f785e;

    public Drawable f786f;

    public ColorStateList f787g;

    public PorterDuff.Mode f788h;

    public boolean f789i;

    public boolean f790j;

    public int f791k;

    public int f792l;

    public int f793m;

    public boolean f794n;

    public CharSequence f795o;

    public CharSequence f796p;

    public CharSequence f797q;

    public CharSequence f798r;

    public boolean f799s;

    public int f800t;

    public final int f801u;

    public float f802v;

    public float f803w;

    public final VelocityTracker f804x;

    public final int f805y;

    public float f806z;

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.switchStyle);
    }

    private C0295y getEmojiTextViewHelper() {
        if (this.f778O == null) {
            this.f778O = new C0295y(this);
        }
        return this.f778O;
    }

    private boolean getTargetCheckedState() {
        return this.f806z > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((AbstractC0189c4.m648a(this) ? 1.0f - this.f806z : this.f806z) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f786f;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f780Q;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f781a;
        Rect rectM736b = drawable2 != null ? AbstractC0237m1.m736b(drawable2) : AbstractC0237m1.f1010c;
        return ((((this.f764A - this.f766C) - rect.left) - rect.right) - rectM736b.left) - rectM736b.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f797q = charSequence;
        C0295y emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod transformationMethodMo3511I = ((AbstractC1466d) emojiTextViewHelper.f1135b.f38b).mo3511I(this.f776M);
        if (transformationMethodMo3511I != null) {
            charSequence = transformationMethodMo3511I.getTransformation(charSequence, this);
        }
        this.f798r = charSequence;
        this.f775L = null;
        if (this.f799s) {
            m608d();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f795o = charSequence;
        C0295y emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod transformationMethodMo3511I = ((AbstractC1466d) emojiTextViewHelper.f1135b.f38b).mo3511I(this.f776M);
        if (transformationMethodMo3511I != null) {
            charSequence = transformationMethodMo3511I.getTransformation(charSequence, this);
        }
        this.f796p = charSequence;
        this.f774K = null;
        if (this.f799s) {
            m608d();
        }
    }

    public final void m605a() {
        Drawable drawable = this.f781a;
        if (drawable != null) {
            if (this.f784d || this.f785e) {
                Drawable drawableMutate = AbstractC3198d.m6448W(drawable).mutate();
                this.f781a = drawableMutate;
                if (this.f784d) {
                    AbstractC2581a.m5586h(drawableMutate, this.f782b);
                }
                if (this.f785e) {
                    AbstractC2581a.m5587i(this.f781a, this.f783c);
                }
                if (this.f781a.isStateful()) {
                    this.f781a.setState(getDrawableState());
                }
            }
        }
    }

    public final void m606b() {
        Drawable drawable = this.f786f;
        if (drawable != null) {
            if (this.f789i || this.f790j) {
                Drawable drawableMutate = AbstractC3198d.m6448W(drawable).mutate();
                this.f786f = drawableMutate;
                if (this.f789i) {
                    AbstractC2581a.m5586h(drawableMutate, this.f787g);
                }
                if (this.f790j) {
                    AbstractC2581a.m5587i(this.f786f, this.f788h);
                }
                if (this.f786f.isStateful()) {
                    this.f786f.setState(getDrawableState());
                }
            }
        }
    }

    public final void m607c() {
        setTextOnInternal(this.f795o);
        setTextOffInternal(this.f797q);
        requestLayout();
    }

    public final void m608d() {
        if (this.f779P == null && ((AbstractC1466d) this.f778O.f1135b.f38b).mo3516t() && C1235i.f3923j != null) {
            C1235i c1235iM3106a = C1235i.m3106a();
            int iM3107b = c1235iM3106a.m3107b();
            if (iM3107b == 3 || iM3107b == 0) {
                C0219i3 c0219i3 = new C0219i3(this);
                this.f779P = c0219i3;
                c1235iM3106a.m3111f(c0219i3);
            }
        }
    }

    @Override
    public final void draw(Canvas canvas) {
        int i6;
        int i10;
        int i11 = this.f767D;
        int i12 = this.f768E;
        int i13 = this.f769F;
        int i14 = this.f770G;
        int thumbOffset = getThumbOffset() + i11;
        Drawable drawable = this.f781a;
        Rect rectM736b = drawable != null ? AbstractC0237m1.m736b(drawable) : AbstractC0237m1.f1010c;
        Drawable drawable2 = this.f786f;
        Rect rect = this.f780Q;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i15 = rect.left;
            thumbOffset += i15;
            if (rectM736b != null) {
                int i16 = rectM736b.left;
                if (i16 > i15) {
                    i11 += i16 - i15;
                }
                int i17 = rectM736b.top;
                int i18 = rect.top;
                i6 = i17 > i18 ? (i17 - i18) + i12 : i12;
                int i19 = rectM736b.right;
                int i20 = rect.right;
                if (i19 > i20) {
                    i13 -= i19 - i20;
                }
                int i21 = rectM736b.bottom;
                int i22 = rect.bottom;
                if (i21 > i22) {
                    i10 = i14 - (i21 - i22);
                }
                this.f786f.setBounds(i11, i6, i13, i10);
            } else {
                i6 = i12;
            }
            i10 = i14;
            this.f786f.setBounds(i11, i6, i13, i10);
        }
        Drawable drawable3 = this.f781a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i23 = thumbOffset - rect.left;
            int i24 = thumbOffset + this.f766C + rect.right;
            this.f781a.setBounds(i23, i12, i24, i14);
            Drawable background = getBackground();
            if (background != null) {
                AbstractC2581a.m5584f(background, i23, i12, i24, i14);
            }
        }
        super.draw(canvas);
    }

    @Override
    public final void drawableHotspotChanged(float f, float f3) {
        super.drawableHotspotChanged(f, f3);
        Drawable drawable = this.f781a;
        if (drawable != null) {
            AbstractC2581a.m5583e(drawable, f, f3);
        }
        Drawable drawable2 = this.f786f;
        if (drawable2 != null) {
            AbstractC2581a.m5583e(drawable2, f, f3);
        }
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f781a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f786f;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override
    public int getCompoundPaddingLeft() {
        if (!AbstractC0189c4.m648a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f764A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f793m : compoundPaddingLeft;
    }

    @Override
    public int getCompoundPaddingRight() {
        if (AbstractC0189c4.m648a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f764A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f793m : compoundPaddingRight;
    }

    @Override
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC3198d.m6446U(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f799s;
    }

    public boolean getSplitTrack() {
        return this.f794n;
    }

    public int getSwitchMinWidth() {
        return this.f792l;
    }

    public int getSwitchPadding() {
        return this.f793m;
    }

    public CharSequence getTextOff() {
        return this.f797q;
    }

    public CharSequence getTextOn() {
        return this.f795o;
    }

    public Drawable getThumbDrawable() {
        return this.f781a;
    }

    public final float getThumbPosition() {
        return this.f806z;
    }

    public int getThumbTextPadding() {
        return this.f791k;
    }

    public ColorStateList getThumbTintList() {
        return this.f782b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f783c;
    }

    public Drawable getTrackDrawable() {
        return this.f786f;
    }

    public ColorStateList getTrackTintList() {
        return this.f787g;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f788h;
    }

    @Override
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f781a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f786f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f777N;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f777N.end();
        this.f777N = null;
    }

    @Override
    public final int[] onCreateDrawableState(int i6) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i6 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f763S);
        }
        return iArrOnCreateDrawableState;
    }

    @Override
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.f786f;
        Rect rect = this.f780Q;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i6 = this.f768E;
        int i10 = this.f770G;
        int i11 = i6 + rect.top;
        int i12 = i10 - rect.bottom;
        Drawable drawable2 = this.f781a;
        if (drawable != null) {
            if (!this.f794n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectM736b = AbstractC0237m1.m736b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectM736b.left;
                rect.right -= rectM736b.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = getTargetCheckedState() ? this.f774K : this.f775L;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f773J;
            TextPaint textPaint = this.f772I;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i11 + i12) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f795o : this.f797q;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        int iMax;
        int iM13g;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z7, i6, i10, i11, i12);
        int iMax2 = 0;
        if (this.f781a != null) {
            Drawable drawable = this.f786f;
            Rect rect = this.f780Q;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectM736b = AbstractC0237m1.m736b(this.f781a);
            iMax = Math.max(0, rectM736b.left - rect.left);
            iMax2 = Math.max(0, rectM736b.right - rect.right);
        } else {
            iMax = 0;
        }
        if (AbstractC0189c4.m648a(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            iM13g = AbstractC0004e.m13g(paddingLeft, this.f764A, iMax, iMax2);
        } else {
            int width = (getWidth() - getPaddingRight()) - iMax2;
            int i13 = iMax2 + (width - this.f764A) + iMax;
            iM13g = width;
            paddingLeft = i13;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i14 = this.f765B;
            int i15 = height2 - (i14 / 2);
            height = i14 + i15;
            paddingTop = i15;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.f765B + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.f765B;
        }
        this.f767D = paddingLeft;
        this.f768E = paddingTop;
        this.f770G = height;
        this.f769F = iM13g;
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int intrinsicWidth;
        int intrinsicHeight;
        int iMax;
        int intrinsicHeight2 = 0;
        if (this.f799s) {
            StaticLayout staticLayout = this.f774K;
            TextPaint textPaint = this.f772I;
            if (staticLayout == null) {
                CharSequence charSequence = this.f796p;
                this.f774K = new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.f775L == null) {
                CharSequence charSequence2 = this.f798r;
                this.f775L = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.f781a;
        Rect rect = this.f780Q;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f781a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f781a.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        if (this.f799s) {
            iMax = (this.f791k * 2) + Math.max(this.f774K.getWidth(), this.f775L.getWidth());
        } else {
            iMax = 0;
        }
        this.f766C = Math.max(iMax, intrinsicWidth);
        Drawable drawable2 = this.f786f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f786f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax2 = rect.left;
        int iMax3 = rect.right;
        Drawable drawable3 = this.f781a;
        if (drawable3 != null) {
            Rect rectM736b = AbstractC0237m1.m736b(drawable3);
            iMax2 = Math.max(iMax2, rectM736b.left);
            iMax3 = Math.max(iMax3, rectM736b.right);
        }
        int iMax4 = this.f771H ? Math.max(this.f792l, (this.f766C * 2) + iMax2 + iMax3) : this.f792l;
        int iMax5 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f764A = iMax4;
        this.f765B = iMax5;
        super.onMeasure(i6, i10);
        if (getMeasuredHeight() < iMax5) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax5);
        }
    }

    @Override
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f795o : this.f797q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        boolean zIsChecked;
        boolean targetCheckedState;
        float xVelocity;
        float f;
        VelocityTracker velocityTracker = this.f804x;
        velocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int i6 = this.f801u;
        if (actionMasked != 0) {
            float f3 = 0.0f;
            if (actionMasked == 1) {
                if (this.f800t == 2) {
                    this.f800t = 0;
                    if (motionEvent.getAction() == 1 || !isEnabled()) {
                        z7 = false;
                    } else {
                        z7 = true;
                    }
                    zIsChecked = isChecked();
                    if (z7) {
                        velocityTracker.computeCurrentVelocity(1000);
                        xVelocity = velocityTracker.getXVelocity();
                        if (Math.abs(xVelocity) <= this.f805y) {
                            targetCheckedState = AbstractC0189c4.m648a(this) ? xVelocity > 0.0f : xVelocity < 0.0f;
                        } else {
                            targetCheckedState = getTargetCheckedState();
                        }
                    } else {
                        targetCheckedState = zIsChecked;
                    }
                    if (targetCheckedState != zIsChecked) {
                        playSoundEffect(0);
                    }
                    setChecked(targetCheckedState);
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.setAction(3);
                    super.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                this.f800t = 0;
                velocityTracker.clear();
            } else if (actionMasked == 2) {
                int i10 = this.f800t;
                if (i10 == 1) {
                    float x10 = motionEvent.getX();
                    float y7 = motionEvent.getY();
                    float f4 = i6;
                    if (Math.abs(x10 - this.f802v) > f4 || Math.abs(y7 - this.f803w) > f4) {
                        this.f800t = 2;
                        getParent().requestDisallowInterceptTouchEvent(true);
                        this.f802v = x10;
                        this.f803w = y7;
                        return true;
                    }
                } else if (i10 == 2) {
                    float x11 = motionEvent.getX();
                    int thumbScrollRange = getThumbScrollRange();
                    float f5 = x11 - this.f802v;
                    if (thumbScrollRange != 0) {
                        f = f5 / thumbScrollRange;
                    } else {
                        f = f5 > 0.0f ? 1.0f : -1.0f;
                    }
                    if (AbstractC0189c4.m648a(this)) {
                        f = -f;
                    }
                    float f10 = this.f806z;
                    float f11 = f + f10;
                    if (f11 >= 0.0f) {
                        f3 = f11 > 1.0f ? 1.0f : f11;
                    }
                    if (f3 != f10) {
                        this.f802v = x11;
                        setThumbPosition(f3);
                    }
                    return true;
                }
            } else if (actionMasked == 3) {
                if (this.f800t == 2) {
                    this.f800t = 0;
                    if (motionEvent.getAction() == 1) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    zIsChecked = isChecked();
                    if (z7) {
                        velocityTracker.computeCurrentVelocity(1000);
                        xVelocity = velocityTracker.getXVelocity();
                        if (Math.abs(xVelocity) <= this.f805y) {
                            targetCheckedState = getTargetCheckedState();
                        } else if (AbstractC0189c4.m648a(this)) {
                        }
                    } else {
                        targetCheckedState = zIsChecked;
                    }
                    if (targetCheckedState != zIsChecked) {
                        playSoundEffect(0);
                    }
                    setChecked(targetCheckedState);
                    MotionEvent motionEventObtain2 = MotionEvent.obtain(motionEvent);
                    motionEventObtain2.setAction(3);
                    super.onTouchEvent(motionEventObtain2);
                    motionEventObtain2.recycle();
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                this.f800t = 0;
                velocityTracker.clear();
            }
        } else {
            float x12 = motionEvent.getX();
            float y9 = motionEvent.getY();
            if (isEnabled() && this.f781a != null) {
                int thumbOffset = getThumbOffset();
                Drawable drawable = this.f781a;
                Rect rect = this.f780Q;
                drawable.getPadding(rect);
                int i11 = this.f768E - i6;
                int i12 = (this.f767D + thumbOffset) - i6;
                int i13 = this.f766C + i12 + rect.left + rect.right + i6;
                int i14 = this.f770G + i6;
                if (x12 > i12 && x12 < i13 && y9 > i11 && y9 < i14) {
                    this.f800t = 1;
                    this.f802v = x12;
                    this.f803w = y9;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().m830c(z7);
    }

    @Override
    public void setChecked(boolean z7) {
        super.setChecked(z7);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                Object string = this.f795o;
                if (string == null) {
                    string = getResources().getString(com.p2serv.android.p032ds.R.string.abc_capital_on);
                }
                Object obj = string;
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                new C3107c0(com.p2serv.android.p032ds.R.id.tag_state_description, CharSequence.class, 64, 30, 2).m3247d(this, obj);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            Object string2 = this.f797q;
            if (string2 == null) {
                string2 = getResources().getString(com.p2serv.android.p032ds.R.string.abc_capital_off);
            }
            Object obj2 = string2;
            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
            new C3107c0(com.p2serv.android.p032ds.R.id.tag_state_description, CharSequence.class, 64, 30, 2).m3247d(this, obj2);
        }
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap3 = AbstractC3155s0.f10642a;
            if (isLaidOut()) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f762R, zIsChecked ? 1.0f : 0.0f);
                this.f777N = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(250L);
                AbstractC0214h3.m688a(this.f777N, true);
                this.f777N.start();
                return;
            }
        }
        ObjectAnimator objectAnimator = this.f777N;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        setThumbPosition(zIsChecked ? 1.0f : 0.0f);
    }

    @Override
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC3198d.m6449X(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z7) {
        getEmojiTextViewHelper().m831d(z7);
        setTextOnInternal(this.f795o);
        setTextOffInternal(this.f797q);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z7) {
        this.f771H = z7;
        invalidate();
    }

    @Override
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().m828a(inputFilterArr));
    }

    public void setShowText(boolean z7) {
        if (this.f799s != z7) {
            this.f799s = z7;
            requestLayout();
            if (z7) {
                m608d();
            }
        }
    }

    public void setSplitTrack(boolean z7) {
        this.f794n = z7;
        invalidate();
    }

    public void setSwitchMinWidth(int i6) {
        this.f792l = i6;
        requestLayout();
    }

    public void setSwitchPadding(int i6) {
        this.f793m = i6;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.f772I;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object string = this.f797q;
        if (string == null) {
            string = getResources().getString(com.p2serv.android.p032ds.R.string.abc_capital_off);
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        new C3107c0(com.p2serv.android.p032ds.R.id.tag_state_description, CharSequence.class, 64, 30, 2).m3247d(this, string);
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (!isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object string = this.f795o;
        if (string == null) {
            string = getResources().getString(com.p2serv.android.p032ds.R.string.abc_capital_on);
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        new C3107c0(com.p2serv.android.p032ds.R.id.tag_state_description, CharSequence.class, 64, 30, 2).m3247d(this, string);
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f781a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f781a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f) {
        this.f806z = f;
        invalidate();
    }

    public void setThumbResource(int i6) {
        setThumbDrawable(AbstractC1465c.m3473h(getContext(), i6));
    }

    public void setThumbTextPadding(int i6) {
        this.f791k = i6;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f782b = colorStateList;
        this.f784d = true;
        m605a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f783c = mode;
        this.f785e = true;
        m605a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f786f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f786f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i6) {
        setTrackDrawable(AbstractC1465c.m3473h(getContext(), i6));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f787g = colorStateList;
        this.f789i = true;
        m606b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f788h = mode;
        this.f790j = true;
        m606b();
    }

    @Override
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f781a || drawable == this.f786f;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i6) {
        Typeface typeface;
        int resourceId;
        super(context, attributeSet, i6);
        this.f782b = null;
        this.f783c = null;
        this.f784d = false;
        this.f785e = false;
        this.f787g = null;
        this.f788h = null;
        this.f789i = false;
        this.f790j = false;
        this.f804x = VelocityTracker.obtain();
        this.f771H = true;
        this.f780Q = new Rect();
        AbstractC0224j3.m702a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.f772I = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = AbstractC2341a.f8176x;
        C0026b c0026bM111C = C0026b.m111C(context, attributeSet, iArr, i6);
        AbstractC3155s0.m6346p(this, context, iArr, attributeSet, (TypedArray) c0026bM111C.f55c, i6, 0);
        Drawable drawableM140t = c0026bM111C.m140t(2);
        this.f781a = drawableM140t;
        if (drawableM140t != null) {
            drawableM140t.setCallback(this);
        }
        Drawable drawableM140t2 = c0026bM111C.m140t(11);
        this.f786f = drawableM140t2;
        if (drawableM140t2 != null) {
            drawableM140t2.setCallback(this);
        }
        TypedArray typedArray = (TypedArray) c0026bM111C.f55c;
        setTextOnInternal(typedArray.getText(0));
        setTextOffInternal(typedArray.getText(1));
        this.f799s = typedArray.getBoolean(3, true);
        this.f791k = typedArray.getDimensionPixelSize(8, 0);
        this.f792l = typedArray.getDimensionPixelSize(5, 0);
        this.f793m = typedArray.getDimensionPixelSize(6, 0);
        this.f794n = typedArray.getBoolean(4, false);
        ColorStateList colorStateListM139s = c0026bM111C.m139s(9);
        if (colorStateListM139s != null) {
            this.f782b = colorStateListM139s;
            this.f784d = true;
        }
        PorterDuff.Mode modeM737c = AbstractC0237m1.m737c(typedArray.getInt(10, -1), null);
        if (this.f783c != modeM737c) {
            this.f783c = modeM737c;
            this.f785e = true;
        }
        if (this.f784d || this.f785e) {
            m605a();
        }
        ColorStateList colorStateListM139s2 = c0026bM111C.m139s(12);
        if (colorStateListM139s2 != null) {
            this.f787g = colorStateListM139s2;
            this.f789i = true;
        }
        PorterDuff.Mode modeM737c2 = AbstractC0237m1.m737c(typedArray.getInt(13, -1), null);
        if (this.f788h != modeM737c2) {
            this.f788h = modeM737c2;
            this.f790j = true;
        }
        if (this.f789i || this.f790j) {
            m606b();
        }
        int resourceId2 = typedArray.getResourceId(7, 0);
        if (resourceId2 != 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId2, AbstractC2341a.f8177y);
            ColorStateList colorStateList = (!typedArrayObtainStyledAttributes.hasValue(3) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = AbstractC3928d.m7848k(context, resourceId)) == null) ? typedArrayObtainStyledAttributes.getColorStateList(3) : colorStateList;
            if (colorStateList != null) {
                this.f773J = colorStateList;
            } else {
                this.f773J = getTextColors();
            }
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f = dimensionPixelSize;
                if (f != textPaint.getTextSize()) {
                    textPaint.setTextSize(f);
                    requestLayout();
                }
            }
            int i10 = typedArrayObtainStyledAttributes.getInt(1, -1);
            int i11 = typedArrayObtainStyledAttributes.getInt(2, -1);
            if (i10 == 1) {
                typeface = Typeface.SANS_SERIF;
            } else if (i10 != 2) {
                typeface = i10 != 3 ? null : Typeface.MONOSPACE;
            } else {
                typeface = Typeface.SERIF;
            }
            if (i11 > 0) {
                Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i11) : Typeface.create(typeface, i11);
                setSwitchTypeface(typefaceDefaultFromStyle);
                int i12 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i11;
                textPaint.setFakeBoldText((i12 & 1) != 0);
                textPaint.setTextSkewX((i12 & 2) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
                Context context2 = getContext();
                C2677a c2677a = new C2677a();
                c2677a.f9313a = context2.getResources().getConfiguration().locale;
                this.f776M = c2677a;
            } else {
                this.f776M = null;
            }
            setTextOnInternal(this.f795o);
            setTextOffInternal(this.f797q);
            typedArrayObtainStyledAttributes.recycle();
        }
        new C0291x0(this).m819f(attributeSet, i6);
        c0026bM111C.m120F();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f801u = viewConfiguration.getScaledTouchSlop();
        this.f805y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().m829b(attributeSet, i6);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
