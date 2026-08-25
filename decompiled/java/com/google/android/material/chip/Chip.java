package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.app.C0157r0;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.bumptech.glide.AbstractC1465c;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.internal.C1836v;
import com.google.android.material.internal.C1838x;
import com.google.android.material.internal.InterfaceC1820f;
import com.google.android.material.internal.InterfaceC1821g;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.WeakHashMap;
import p051e6.C2416a;
import p051e6.C2417b;
import p051e6.C2419d;
import p051e6.InterfaceC2418c;
import p065g0.C2590j;
import p065g0.InterfaceC2589i;
import p118l0.AbstractC2959j;
import p118l0.C2951b;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p148o0.C3232g;
import p156o9.AbstractC3280d;
import p189r6.C3639d;
import p201s6.AbstractC3722c;
import p221u6.C3913m;
import p221u6.InterfaceC3924x;
import p222u7.AbstractC3928d;
import p246x.C4075a;
import p250x5.AbstractC4121a;
import p262y5.C4272e;
import p263y6.AbstractC4275a;

public class Chip extends AppCompatCheckBox implements InterfaceC2418c, InterfaceC3924x, InterfaceC1821g {

    public static final Rect f6081x = new Rect();

    public static final int[] f6082y = {R.attr.state_selected};

    public static final int[] f6083z = {R.attr.state_checkable};

    public C2419d f6084e;

    public InsetDrawable f6085f;

    public RippleDrawable f6086g;

    public View.OnClickListener f6087h;

    public CompoundButton.OnCheckedChangeListener f6088i;

    public InterfaceC1820f f6089j;

    public boolean f6090k;

    public boolean f6091l;

    public boolean f6092m;

    public boolean f6093n;

    public boolean f6094o;

    public int f6095p;

    public int f6096q;

    public CharSequence f6097r;

    public final C2417b f6098s;

    public boolean f6099t;

    public final Rect f6100u;

    public final RectF f6101v;

    public final C1836v f6102w;

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.chipStyle);
    }

    public RectF getCloseIconTouchBounds() {
        RectF rectF = this.f6101v;
        rectF.setEmpty();
        if (m4158d() && this.f6087h != null) {
            C2419d c2419d = this.f6084e;
            Rect bounds = c2419d.getBounds();
            rectF.setEmpty();
            if (c2419d.m5475b0()) {
                float f = c2419d.f8463e0 + c2419d.f8462d0 + c2419d.f8448O + c2419d.f8461c0 + c2419d.f8460b0;
                if (AbstractC3198d.m6474w(c2419d) == 0) {
                    float f3 = bounds.right;
                    rectF.right = f3;
                    rectF.left = f3 - f;
                } else {
                    float f4 = bounds.left;
                    rectF.left = f4;
                    rectF.right = f4 + f;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i6 = (int) closeIconTouchBounds.left;
        int i10 = (int) closeIconTouchBounds.top;
        int i11 = (int) closeIconTouchBounds.right;
        int i12 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.f6100u;
        rect.set(i6, i10, i11, i12);
        return rect;
    }

    private C3639d getTextAppearance() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8470l0.f6499f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z7) {
        if (this.f6092m != z7) {
            this.f6092m = z7;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z7) {
        if (this.f6091l != z7) {
            this.f6091l = z7;
            refreshDrawableState();
        }
    }

    public final void m4157c(int i6) {
        this.f6096q = i6;
        if (!this.f6094o) {
            InsetDrawable insetDrawable = this.f6085f;
            if (insetDrawable == null) {
                int[] iArr = AbstractC3722c.f12475a;
                m4161g();
                return;
            } else {
                if (insetDrawable != null) {
                    this.f6085f = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr2 = AbstractC3722c.f12475a;
                    m4161g();
                    return;
                }
                return;
            }
        }
        int iMax = Math.max(0, i6 - ((int) this.f6084e.f8486z));
        int iMax2 = Math.max(0, i6 - this.f6084e.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.f6085f;
            if (insetDrawable2 == null) {
                int[] iArr3 = AbstractC3722c.f12475a;
                m4161g();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.f6085f = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr4 = AbstractC3722c.f12475a;
                    m4161g();
                    return;
                }
                return;
            }
        }
        int i10 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i11 = iMax > 0 ? iMax / 2 : 0;
        if (this.f6085f != null) {
            Rect rect = new Rect();
            this.f6085f.getPadding(rect);
            if (rect.top == i11 && rect.bottom == i11 && rect.left == i10 && rect.right == i10) {
                int[] iArr5 = AbstractC3722c.f12475a;
                m4161g();
                return;
            }
        }
        if (getMinHeight() != i6) {
            setMinHeight(i6);
        }
        if (getMinWidth() != i6) {
            setMinWidth(i6);
        }
        this.f6085f = new InsetDrawable((Drawable) this.f6084e, i10, i11, i10, i11);
        int[] iArr6 = AbstractC3722c.f12475a;
        m4161g();
    }

    public final boolean m4158d() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            Object obj = c2419d.f8445L;
            if (obj == null) {
                obj = null;
            } else if (obj instanceof InterfaceC2589i) {
                obj = ((C2590j) ((InterfaceC2589i) obj)).f9035f;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.f6099t) {
            return this.f6098s.m7940m(motionEvent) || super.dispatchHoverEvent(motionEvent);
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i6;
        if (!this.f6099t) {
            return super.dispatchKeyEvent(keyEvent);
        }
        C2417b c2417b = this.f6098s;
        c2417b.getClass();
        boolean zM7942q = false;
        int i10 = 0;
        zM7942q = false;
        zM7942q = false;
        zM7942q = false;
        zM7942q = false;
        zM7942q = false;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                int i11 = 66;
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                if (keyCode == 19) {
                                    i11 = 33;
                                } else if (keyCode == 21) {
                                    i11 = 17;
                                } else if (keyCode != 22) {
                                    i11 = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
                                }
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z7 = false;
                                while (i10 < repeatCount && c2417b.m7942q(i11, null)) {
                                    i10++;
                                    z7 = true;
                                }
                                zM7942q = z7;
                            }
                            break;
                        case 23:
                            if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                                i6 = c2417b.f13471l;
                                if (i6 != Integer.MIN_VALUE) {
                                    c2417b.mo4331s(i6, 16, null);
                                }
                                zM7942q = true;
                            }
                            break;
                    }
                } else if (keyEvent.hasNoModifiers()) {
                    i6 = c2417b.f13471l;
                    if (i6 != Integer.MIN_VALUE) {
                        c2417b.mo4331s(i6, 16, null);
                    }
                    zM7942q = true;
                }
            } else if (keyEvent.hasNoModifiers()) {
                zM7942q = c2417b.m7942q(2, null);
            } else if (keyEvent.hasModifiers(1)) {
                zM7942q = c2417b.m7942q(1, null);
            }
        }
        if (!zM7942q || c2417b.f13471l == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override
    public final void drawableStateChanged() {
        int i6;
        int i10;
        super.drawableStateChanged();
        C2419d c2419d = this.f6084e;
        boolean zM5452E = false;
        if (c2419d != null && C2419d.m5448C(c2419d.f8445L)) {
            C2419d c2419d2 = this.f6084e;
            ?? IsEnabled = isEnabled();
            if (this.f6093n) {
                i6 = IsEnabled;
                i6 = IsEnabled + 1;
            }
            i6 = IsEnabled;
            int i11 = i6;
            if (this.f6092m) {
                i11 = i6 + 1;
            }
            int i12 = i11;
            if (this.f6091l) {
                i12 = i11 + 1;
            }
            int i13 = i12;
            if (isChecked()) {
                i13 = i12 + 1;
            }
            int[] iArr = new int[i13];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i10 = 1;
            } else {
                i10 = 0;
            }
            if (this.f6093n) {
                iArr[i10] = 16842908;
                i10++;
            }
            if (this.f6092m) {
                iArr[i10] = 16843623;
                i10++;
            }
            if (this.f6091l) {
                iArr[i10] = 16842919;
                i10++;
            }
            if (isChecked()) {
                iArr[i10] = 16842913;
            }
            if (!Arrays.equals(c2419d2.f8487z0, iArr)) {
                c2419d2.f8487z0 = iArr;
                if (c2419d2.m5475b0()) {
                    zM5452E = c2419d2.m5452E(c2419d2.getState(), iArr);
                }
            }
        }
        if (zM5452E) {
            invalidate();
        }
    }

    public final boolean m4159e() {
        C2419d c2419d = this.f6084e;
        return c2419d != null && c2419d.f8450Q;
    }

    public final void m4160f() {
        C2419d c2419d;
        if (!m4158d() || (c2419d = this.f6084e) == null || !c2419d.f8444K || this.f6087h == null) {
            AbstractC3155s0.m6347q(this, null);
            this.f6099t = false;
        } else {
            AbstractC3155s0.m6347q(this, this.f6098s);
            this.f6099t = true;
        }
    }

    public final void m4161g() {
        this.f6086g = new RippleDrawable(AbstractC3722c.m7485b(this.f6084e.f8434D), getBackgroundDrawable(), null);
        this.f6084e.getClass();
        RippleDrawable rippleDrawable = this.f6086g;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        setBackground(rippleDrawable);
        m4162h();
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f6097r)) {
            return this.f6097r;
        }
        if (!m4159e()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof ChipGroup) && ((ChipGroup) parent).f6106h.f6353d) ? "android.widget.RadioButton" : "android.widget.CompoundButton";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f6085f;
        return insetDrawable == null ? this.f6084e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8452S;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8453T;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8484y;
        }
        return null;
    }

    public float getChipCornerRadius() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return Math.max(0.0f, c2419d.m5450A());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f6084e;
    }

    public float getChipEndPadding() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8463e0;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        Object obj;
        C2419d c2419d = this.f6084e;
        if (c2419d == null || (obj = c2419d.f8440G) == null) {
            return null;
        }
        if (obj instanceof InterfaceC2589i) {
            obj = ((C2590j) ((InterfaceC2589i) obj)).f9035f;
        }
        return obj;
    }

    public float getChipIconSize() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8442I;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8441H;
        }
        return null;
    }

    public float getChipMinHeight() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8486z;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8456W;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8430B;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8432C;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        Object obj;
        C2419d c2419d = this.f6084e;
        if (c2419d == null || (obj = c2419d.f8445L) == null) {
            return null;
        }
        if (obj instanceof InterfaceC2589i) {
            obj = ((C2590j) ((InterfaceC2589i) obj)).f9035f;
        }
        return obj;
    }

    public CharSequence getCloseIconContentDescription() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8449P;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8462d0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8448O;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8461c0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8447N;
        }
        return null;
    }

    @Override
    public TextUtils.TruncateAt getEllipsize() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8433C0;
        }
        return null;
    }

    @Override
    public final void getFocusedRect(Rect rect) {
        if (this.f6099t) {
            C2417b c2417b = this.f6098s;
            if (c2417b.f13471l == 1 || c2417b.f13470k == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public C4272e getHideMotionSpec() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8455V;
        }
        return null;
    }

    public float getIconEndPadding() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8458Y;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8457X;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8434D;
        }
        return null;
    }

    public C3913m getShapeAppearanceModel() {
        return this.f6084e.f13126a.f13107a;
    }

    public C4272e getShowMotionSpec() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8454U;
        }
        return null;
    }

    public float getTextEndPadding() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8460b0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            return c2419d.f8459Z;
        }
        return 0.0f;
    }

    public final void m4162h() {
        C2419d c2419d;
        if (TextUtils.isEmpty(getText()) || (c2419d = this.f6084e) == null) {
            return;
        }
        int iM5479z = (int) (c2419d.m5479z() + c2419d.f8463e0 + c2419d.f8460b0);
        C2419d c2419d2 = this.f6084e;
        int iM5478y = (int) (c2419d2.m5478y() + c2419d2.f8456W + c2419d2.f8459Z);
        if (this.f6085f != null) {
            Rect rect = new Rect();
            this.f6085f.getPadding(rect);
            iM5478y += rect.left;
            iM5479z += rect.right;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        setPaddingRelative(iM5478y, paddingTop, iM5479z, paddingBottom);
    }

    public final void m4163i() {
        TextPaint paint = getPaint();
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            paint.drawableState = c2419d.getState();
        }
        C3639d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.m7367e(getContext(), paint, this.f6102w);
        }
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC3280d.m6567D(this, this.f6084e);
    }

    @Override
    public final int[] onCreateDrawableState(int i6) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i6 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f6082y);
        }
        if (m4159e()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f6083z);
        }
        return iArrOnCreateDrawableState;
    }

    @Override
    public final void onFocusChanged(boolean z7, int i6, Rect rect) {
        super.onFocusChanged(z7, i6, rect);
        if (this.f6099t) {
            C2417b c2417b = this.f6098s;
            int i10 = c2417b.f13471l;
            if (i10 != Integer.MIN_VALUE) {
                c2417b.m7937j(i10);
            }
            if (z7) {
                c2417b.m7942q(i6, rect);
            }
        }
    }

    @Override
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i6;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(m4159e());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            if (!chipGroup.f6325c) {
                i6 = -1;
                break;
            }
            int i10 = 0;
            i6 = 0;
            while (true) {
                if (i10 >= chipGroup.getChildCount()) {
                    i6 = -1;
                    break;
                }
                if (chipGroup.getChildAt(i10) instanceof Chip) {
                    if (((Chip) chipGroup.getChildAt(i10)) == this) {
                        break;
                    } else {
                        i6++;
                    }
                }
                i10++;
            }
            Object tag = getTag(com.p2serv.android.p032ds.R.id.row_index_key);
            accessibilityNodeInfo.setCollectionItemInfo(C3232g.m6538a(tag instanceof Integer ? ((Integer) tag).intValue() : -1, 1, i6, 1, isChecked()).f10860a);
        }
    }

    @Override
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i6) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override
    public final void onRtlPropertiesChanged(int i6) {
        super.onRtlPropertiesChanged(i6);
        if (this.f6095p != i6) {
            this.f6095p = i6;
            m4162h();
        }
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        int actionMasked = motionEvent.getActionMasked();
        boolean zContains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                    }
                } else if (this.f6091l) {
                    if (!zContains) {
                        setCloseIconPressed(false);
                    }
                    z7 = true;
                }
                z7 = false;
            } else {
                if (this.f6091l) {
                    playSoundEffect(0);
                    View.OnClickListener onClickListener = this.f6087h;
                    if (onClickListener != null) {
                        onClickListener.onClick(this);
                    }
                    if (this.f6099t) {
                        this.f6098s.m7945x(1, 1);
                    }
                    z7 = true;
                }
                setCloseIconPressed(false);
            }
            z7 = false;
            setCloseIconPressed(false);
        } else if (zContains) {
            setCloseIconPressed(true);
            z7 = true;
        } else {
            z7 = false;
        }
        return z7 || super.onTouchEvent(motionEvent);
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f6097r = charSequence;
    }

    @Override
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f6086g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override
    public void setBackgroundColor(int i6) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f6086g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override
    public void setBackgroundResource(int i6) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z7) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5453F(z7);
        }
    }

    public void setCheckableResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5453F(c2419d.f8464f0.getResources().getBoolean(i6));
        }
    }

    @Override
    public void setChecked(boolean z7) {
        C2419d c2419d = this.f6084e;
        if (c2419d == null) {
            this.f6090k = z7;
        } else if (c2419d.f8450Q) {
            super.setChecked(z7);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5454G(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z7) {
        setCheckedIconVisible(z7);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i6) {
        setCheckedIconVisible(i6);
    }

    public void setCheckedIconResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5454G(AbstractC1465c.m3473h(c2419d.f8464f0, i6));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5455H(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5455H(AbstractC3928d.m7848k(c2419d.f8464f0, i6));
        }
    }

    public void setCheckedIconVisible(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5456I(c2419d.f8464f0.getResources().getBoolean(i6));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        C2419d c2419d = this.f6084e;
        if (c2419d == null || c2419d.f8484y == colorStateList) {
            return;
        }
        c2419d.f8484y = colorStateList;
        c2419d.onStateChange(c2419d.getState());
    }

    public void setChipBackgroundColorResource(int i6) {
        ColorStateList colorStateListM7848k;
        C2419d c2419d = this.f6084e;
        if (c2419d == null || c2419d.f8484y == (colorStateListM7848k = AbstractC3928d.m7848k(c2419d.f8464f0, i6))) {
            return;
        }
        c2419d.f8484y = colorStateListM7848k;
        c2419d.onStateChange(c2419d.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5457J(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5457J(c2419d.f8464f0.getResources().getDimension(i6));
        }
    }

    public void setChipDrawable(C2419d c2419d) {
        C2419d c2419d2 = this.f6084e;
        if (c2419d2 != c2419d) {
            if (c2419d2 != null) {
                c2419d2.f8431B0 = new WeakReference(null);
            }
            this.f6084e = c2419d;
            c2419d.f8435D0 = false;
            c2419d.f8431B0 = new WeakReference(this);
            m4157c(this.f6096q);
        }
    }

    public void setChipEndPadding(float f) {
        C2419d c2419d = this.f6084e;
        if (c2419d == null || c2419d.f8463e0 == f) {
            return;
        }
        c2419d.f8463e0 = f;
        c2419d.invalidateSelf();
        c2419d.m5451D();
    }

    public void setChipEndPaddingResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            float dimension = c2419d.f8464f0.getResources().getDimension(i6);
            if (c2419d.f8463e0 != dimension) {
                c2419d.f8463e0 = dimension;
                c2419d.invalidateSelf();
                c2419d.m5451D();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5458K(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z7) {
        setChipIconVisible(z7);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i6) {
        setChipIconVisible(i6);
    }

    public void setChipIconResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5458K(AbstractC1465c.m3473h(c2419d.f8464f0, i6));
        }
    }

    public void setChipIconSize(float f) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5459L(f);
        }
    }

    public void setChipIconSizeResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5459L(c2419d.f8464f0.getResources().getDimension(i6));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5460M(colorStateList);
        }
    }

    public void setChipIconTintResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5460M(AbstractC3928d.m7848k(c2419d.f8464f0, i6));
        }
    }

    public void setChipIconVisible(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5461N(c2419d.f8464f0.getResources().getBoolean(i6));
        }
    }

    public void setChipMinHeight(float f) {
        C2419d c2419d = this.f6084e;
        if (c2419d == null || c2419d.f8486z == f) {
            return;
        }
        c2419d.f8486z = f;
        c2419d.invalidateSelf();
        c2419d.m5451D();
    }

    public void setChipMinHeightResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            float dimension = c2419d.f8464f0.getResources().getDimension(i6);
            if (c2419d.f8486z != dimension) {
                c2419d.f8486z = dimension;
                c2419d.invalidateSelf();
                c2419d.m5451D();
            }
        }
    }

    public void setChipStartPadding(float f) {
        C2419d c2419d = this.f6084e;
        if (c2419d == null || c2419d.f8456W == f) {
            return;
        }
        c2419d.f8456W = f;
        c2419d.invalidateSelf();
        c2419d.m5451D();
    }

    public void setChipStartPaddingResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            float dimension = c2419d.f8464f0.getResources().getDimension(i6);
            if (c2419d.f8456W != dimension) {
                c2419d.f8456W = dimension;
                c2419d.invalidateSelf();
                c2419d.m5451D();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5462O(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5462O(AbstractC3928d.m7848k(c2419d.f8464f0, i6));
        }
    }

    public void setChipStrokeWidth(float f) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5463P(f);
        }
    }

    public void setChipStrokeWidthResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5463P(c2419d.f8464f0.getResources().getDimension(i6));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i6) {
        setText(getResources().getString(i6));
    }

    public void setCloseIcon(Drawable drawable) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5464Q(drawable);
        }
        m4160f();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        C2419d c2419d = this.f6084e;
        if (c2419d == null || c2419d.f8449P == charSequence) {
            return;
        }
        C2951b c2951bM5974c = C2951b.m5974c();
        c2951bM5974c.getClass();
        C0157r0 c0157r0 = AbstractC2959j.f10137a;
        c2419d.f8449P = c2951bM5974c.m5975d(charSequence);
        c2419d.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z7) {
        setCloseIconVisible(z7);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i6) {
        setCloseIconVisible(i6);
    }

    public void setCloseIconEndPadding(float f) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5465R(f);
        }
    }

    public void setCloseIconEndPaddingResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5465R(c2419d.f8464f0.getResources().getDimension(i6));
        }
    }

    public void setCloseIconResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5464Q(AbstractC1465c.m3473h(c2419d.f8464f0, i6));
        }
        m4160f();
    }

    public void setCloseIconSize(float f) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5466S(f);
        }
    }

    public void setCloseIconSizeResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5466S(c2419d.f8464f0.getResources().getDimension(i6));
        }
    }

    public void setCloseIconStartPadding(float f) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5467T(f);
        }
    }

    public void setCloseIconStartPaddingResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5467T(c2419d.f8464f0.getResources().getDimension(i6));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5468U(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5468U(AbstractC3928d.m7848k(c2419d.f8464f0, i6));
        }
    }

    public void setCloseIconVisible(int i6) {
        setCloseIconVisible(getResources().getBoolean(i6));
    }

    @Override
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i6, int i10, int i11, int i12) {
        if (i6 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i11 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i6, i10, i11, i12);
    }

    @Override
    public final void setCompoundDrawablesWithIntrinsicBounds(int i6, int i10, int i11, int i12) {
        if (i6 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i11 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i6, i10, i11, i12);
    }

    @Override
    public void setElevation(float f) {
        super.setElevation(f);
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m7808m(f);
        }
    }

    @Override
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f6084e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.f8433C0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z7) {
        this.f6094o = z7;
        m4157c(this.f6096q);
    }

    @Override
    public void setGravity(int i6) {
        if (i6 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i6);
        }
    }

    public void setHideMotionSpec(C4272e c4272e) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.f8455V = c4272e;
        }
    }

    public void setHideMotionSpecResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.f8455V = C4272e.m8314b(c2419d.f8464f0, i6);
        }
    }

    public void setIconEndPadding(float f) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5470W(f);
        }
    }

    public void setIconEndPaddingResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5470W(c2419d.f8464f0.getResources().getDimension(i6));
        }
    }

    public void setIconStartPadding(float f) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5471X(f);
        }
    }

    public void setIconStartPaddingResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5471X(c2419d.f8464f0.getResources().getDimension(i6));
        }
    }

    @Override
    public void setInternalOnCheckedChangeListener(InterfaceC1820f interfaceC1820f) {
        this.f6089j = interfaceC1820f;
    }

    @Override
    public void setLayoutDirection(int i6) {
        if (this.f6084e == null) {
            return;
        }
        super.setLayoutDirection(i6);
    }

    @Override
    public void setLines(int i6) {
        if (i6 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i6);
    }

    @Override
    public void setMaxLines(int i6) {
        if (i6 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i6);
    }

    @Override
    public void setMaxWidth(int i6) {
        super.setMaxWidth(i6);
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.f8437E0 = i6;
        }
    }

    @Override
    public void setMinLines(int i6) {
        if (i6 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i6);
    }

    @Override
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f6088i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f6087h = onClickListener;
        m4160f();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5472Y(colorStateList);
        }
        this.f6084e.getClass();
        m4161g();
    }

    public void setRippleColorResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5472Y(AbstractC3928d.m7848k(c2419d.f8464f0, i6));
            this.f6084e.getClass();
            m4161g();
        }
    }

    @Override
    public void setShapeAppearanceModel(C3913m c3913m) {
        this.f6084e.setShapeAppearanceModel(c3913m);
    }

    public void setShowMotionSpec(C4272e c4272e) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.f8454U = c4272e;
        }
    }

    public void setShowMotionSpecResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.f8454U = C4272e.m8314b(c2419d.f8464f0, i6);
        }
    }

    @Override
    public void setSingleLine(boolean z7) {
        if (!z7) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z7);
    }

    @Override
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        C2419d c2419d = this.f6084e;
        if (c2419d == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(c2419d.f8435D0 ? null : charSequence, bufferType);
        C2419d c2419d2 = this.f6084e;
        if (c2419d2 == null || TextUtils.equals(c2419d2.f8436E, charSequence)) {
            return;
        }
        c2419d2.f8436E = charSequence;
        c2419d2.f8470l0.f6497d = true;
        c2419d2.invalidateSelf();
        c2419d2.m5451D();
    }

    public void setTextAppearance(C3639d c3639d) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.f8470l0.m4286b(c3639d, c2419d.f8464f0);
        }
        m4163i();
    }

    public void setTextAppearanceResource(int i6) {
        setTextAppearance(getContext(), i6);
    }

    public void setTextEndPadding(float f) {
        C2419d c2419d = this.f6084e;
        if (c2419d == null || c2419d.f8460b0 == f) {
            return;
        }
        c2419d.f8460b0 = f;
        c2419d.invalidateSelf();
        c2419d.m5451D();
    }

    public void setTextEndPaddingResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            float dimension = c2419d.f8464f0.getResources().getDimension(i6);
            if (c2419d.f8460b0 != dimension) {
                c2419d.f8460b0 = dimension;
                c2419d.invalidateSelf();
                c2419d.m5451D();
            }
        }
    }

    public void setTextStartPadding(float f) {
        C2419d c2419d = this.f6084e;
        if (c2419d == null || c2419d.f8459Z == f) {
            return;
        }
        c2419d.f8459Z = f;
        c2419d.invalidateSelf();
        c2419d.m5451D();
    }

    public void setTextStartPaddingResource(int i6) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            float dimension = c2419d.f8464f0.getResources().getDimension(i6);
            if (c2419d.f8459Z != dimension) {
                c2419d.f8459Z = dimension;
                c2419d.invalidateSelf();
                c2419d.m5451D();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet, int i6) {
        int resourceId;
        super(AbstractC4275a.m8323a(context, attributeSet, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_Chip_Action), attributeSet, i6);
        int i10 = 0;
        this.f6100u = new Rect();
        this.f6101v = new RectF();
        this.f6102w = new C1836v(1, this);
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        C2419d c2419d = new C2419d(context2, attributeSet, i6);
        int[] iArr = AbstractC4121a.f13995i;
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(c2419d.f8464f0, attributeSet, iArr, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        c2419d.f8439F0 = typedArrayM4250j.hasValue(37);
        Context context3 = c2419d.f8464f0;
        ColorStateList colorStateListM3493k = AbstractC1466d.m3493k(context3, typedArrayM4250j, 24);
        if (c2419d.f8482x != colorStateListM3493k) {
            c2419d.f8482x = colorStateListM3493k;
            c2419d.onStateChange(c2419d.getState());
        }
        ColorStateList colorStateListM3493k2 = AbstractC1466d.m3493k(context3, typedArrayM4250j, 11);
        if (c2419d.f8484y != colorStateListM3493k2) {
            c2419d.f8484y = colorStateListM3493k2;
            c2419d.onStateChange(c2419d.getState());
        }
        float dimension = typedArrayM4250j.getDimension(19, 0.0f);
        if (c2419d.f8486z != dimension) {
            c2419d.f8486z = dimension;
            c2419d.invalidateSelf();
            c2419d.m5451D();
        }
        if (typedArrayM4250j.hasValue(12)) {
            c2419d.m5457J(typedArrayM4250j.getDimension(12, 0.0f));
        }
        c2419d.m5462O(AbstractC1466d.m3493k(context3, typedArrayM4250j, 22));
        c2419d.m5463P(typedArrayM4250j.getDimension(23, 0.0f));
        c2419d.m5472Y(AbstractC1466d.m3493k(context3, typedArrayM4250j, 36));
        String text = typedArrayM4250j.getText(5);
        text = text == null ? "" : text;
        boolean zEquals = TextUtils.equals(c2419d.f8436E, text);
        C1838x c1838x = c2419d.f8470l0;
        if (!zEquals) {
            c2419d.f8436E = text;
            c1838x.f6497d = true;
            c2419d.invalidateSelf();
            c2419d.m5451D();
        }
        C3639d c3639d = (!typedArrayM4250j.hasValue(0) || (resourceId = typedArrayM4250j.getResourceId(0, 0)) == 0) ? null : new C3639d(context3, resourceId);
        c3639d.f12223k = typedArrayM4250j.getDimension(1, c3639d.f12223k);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 23) {
            c3639d.f12222j = AbstractC1466d.m3493k(context3, typedArrayM4250j, 2);
        }
        c1838x.m4286b(c3639d, context3);
        int i12 = typedArrayM4250j.getInt(3, 0);
        if (i12 == 1) {
            c2419d.f8433C0 = TextUtils.TruncateAt.START;
        } else if (i12 == 2) {
            c2419d.f8433C0 = TextUtils.TruncateAt.MIDDLE;
        } else if (i12 == 3) {
            c2419d.f8433C0 = TextUtils.TruncateAt.END;
        }
        c2419d.m5461N(typedArrayM4250j.getBoolean(18, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            c2419d.m5461N(typedArrayM4250j.getBoolean(15, false));
        }
        c2419d.m5458K(AbstractC1466d.m3496n(context3, typedArrayM4250j, 14));
        if (typedArrayM4250j.hasValue(17)) {
            c2419d.m5460M(AbstractC1466d.m3493k(context3, typedArrayM4250j, 17));
        }
        c2419d.m5459L(typedArrayM4250j.getDimension(16, -1.0f));
        c2419d.m5469V(typedArrayM4250j.getBoolean(31, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            c2419d.m5469V(typedArrayM4250j.getBoolean(26, false));
        }
        c2419d.m5464Q(AbstractC1466d.m3496n(context3, typedArrayM4250j, 25));
        c2419d.m5468U(AbstractC1466d.m3493k(context3, typedArrayM4250j, 30));
        c2419d.m5466S(typedArrayM4250j.getDimension(28, 0.0f));
        c2419d.m5453F(typedArrayM4250j.getBoolean(6, false));
        c2419d.m5456I(typedArrayM4250j.getBoolean(10, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            c2419d.m5456I(typedArrayM4250j.getBoolean(8, false));
        }
        c2419d.m5454G(AbstractC1466d.m3496n(context3, typedArrayM4250j, 7));
        if (typedArrayM4250j.hasValue(9)) {
            c2419d.m5455H(AbstractC1466d.m3493k(context3, typedArrayM4250j, 9));
        }
        c2419d.f8454U = C4272e.m8313a(context3, typedArrayM4250j, 39);
        c2419d.f8455V = C4272e.m8313a(context3, typedArrayM4250j, 33);
        float dimension2 = typedArrayM4250j.getDimension(21, 0.0f);
        if (c2419d.f8456W != dimension2) {
            c2419d.f8456W = dimension2;
            c2419d.invalidateSelf();
            c2419d.m5451D();
        }
        c2419d.m5471X(typedArrayM4250j.getDimension(35, 0.0f));
        c2419d.m5470W(typedArrayM4250j.getDimension(34, 0.0f));
        float dimension3 = typedArrayM4250j.getDimension(41, 0.0f);
        if (c2419d.f8459Z != dimension3) {
            c2419d.f8459Z = dimension3;
            c2419d.invalidateSelf();
            c2419d.m5451D();
        }
        float dimension4 = typedArrayM4250j.getDimension(40, 0.0f);
        if (c2419d.f8460b0 != dimension4) {
            c2419d.f8460b0 = dimension4;
            c2419d.invalidateSelf();
            c2419d.m5451D();
        }
        c2419d.m5467T(typedArrayM4250j.getDimension(29, 0.0f));
        c2419d.m5465R(typedArrayM4250j.getDimension(27, 0.0f));
        float dimension5 = typedArrayM4250j.getDimension(13, 0.0f);
        if (c2419d.f8463e0 != dimension5) {
            c2419d.f8463e0 = dimension5;
            c2419d.invalidateSelf();
            c2419d.m5451D();
        }
        c2419d.f8437E0 = typedArrayM4250j.getDimensionPixelSize(4, Integer.MAX_VALUE);
        typedArrayM4250j.recycle();
        AbstractC1811a0.m4241a(context2, attributeSet, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_Chip_Action);
        AbstractC1811a0.m4242b(context2, attributeSet, iArr, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_Chip_Action);
        this.f6094o = typedArrayObtainStyledAttributes.getBoolean(32, false);
        this.f6096q = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(20, (float) Math.ceil(AbstractC1811a0.m4245e(getContext(), 48))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(c2419d);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        c2419d.m7808m(AbstractC3119g0.m6170i(this));
        AbstractC1811a0.m4241a(context2, attributeSet, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_Chip_Action);
        AbstractC1811a0.m4242b(context2, attributeSet, iArr, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_Chip_Action);
        if (i11 < 23) {
            setTextColor(AbstractC1466d.m3493k(context2, typedArrayObtainStyledAttributes2, 2));
        }
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(37);
        typedArrayObtainStyledAttributes2.recycle();
        this.f6098s = new C2417b(this, this);
        m4160f();
        if (!zHasValue) {
            setOutlineProvider(new C4075a(this, 2));
        }
        setChecked(this.f6090k);
        setText(c2419d.f8436E);
        setEllipsize(c2419d.f8433C0);
        m4163i();
        if (!this.f6084e.f8435D0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        m4162h();
        if (this.f6094o) {
            setMinHeight(this.f6096q);
        }
        this.f6095p = getLayoutDirection();
        super.setOnCheckedChangeListener(new C2416a(i10, this));
    }

    public void setCloseIconVisible(boolean z7) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5469V(z7);
        }
        m4160f();
    }

    public void setCheckedIconVisible(boolean z7) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5456I(z7);
        }
    }

    public void setChipIconVisible(boolean z7) {
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            c2419d.m5461N(z7);
        }
    }

    @Override
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override
    public final void setTextAppearance(Context context, int i6) {
        super.setTextAppearance(context, i6);
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            Context context2 = c2419d.f8464f0;
            c2419d.f8470l0.m4286b(new C3639d(context2, i6), context2);
        }
        m4163i();
    }

    @Override
    public void setTextAppearance(int i6) {
        super.setTextAppearance(i6);
        C2419d c2419d = this.f6084e;
        if (c2419d != null) {
            Context context = c2419d.f8464f0;
            c2419d.f8470l0.m4286b(new C3639d(context, i6), context);
        }
        m4163i();
    }
}
