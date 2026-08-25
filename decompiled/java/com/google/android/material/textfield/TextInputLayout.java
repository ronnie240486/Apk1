package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.C0157r0;
import androidx.appcompat.widget.AbstractC0237m1;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.C0253p2;
import androidx.appcompat.widget.C0285w;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import com.bumptech.glide.AbstractC1465c;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.internal.AbstractC1818e;
import com.google.android.material.internal.C1816d;
import com.google.android.material.internal.CheckableImageButton;
import com.p2serv.android.p032ds.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import p002a1.C0026b;
import p004a3.RunnableC0038c;
import p007a7.C0066c;
import p056f0.AbstractC2478a;
import p065g0.AbstractC2581a;
import p118l0.AbstractC2959j;
import p118l0.C2951b;
import p138n0.AbstractC3128j0;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p148o0.AccessibilityManagerTouchExplorationStateChangeListenerC3227b;
import p156o9.AbstractC3281e;
import p221u6.C3901a;
import p221u6.C3908h;
import p221u6.C3912l;
import p221u6.C3913m;
import p221u6.InterfaceC3903c;
import p222u7.AbstractC3928d;
import p250x5.AbstractC4121a;
import p258y1.AbstractC4200b0;
import p262y5.AbstractC4268a;
import p263y6.AbstractC4275a;

public class TextInputLayout extends LinearLayout {

    public CharSequence f6739A;

    public int f6740A0;

    public final AppCompatTextView f6741B;

    public int f6742B0;

    public boolean f6743C;

    public boolean f6744C0;

    public CharSequence f6745D;

    public final C1816d f6746D0;

    public boolean f6747E;

    public boolean f6748E0;

    public C3908h f6749F;

    public boolean f6750F0;

    public C3908h f6751G;

    public ValueAnimator f6752G0;

    public C3908h f6753H;

    public boolean f6754H0;

    public C3913m f6755I;

    public boolean f6756I0;

    public boolean f6757J;

    public final int f6758K;

    public int f6759L;

    public int f6760M;

    public int f6761N;

    public int f6762O;

    public int f6763P;

    public int f6764Q;

    public int f6765R;

    public final Rect f6766S;

    public final Rect f6767T;

    public final RectF f6768U;

    public Typeface f6769V;

    public ColorDrawable f6770W;

    public final FrameLayout f6771a;

    public final C1880r f6772b;

    public int f6773b0;

    public final LinearLayout f6774c;

    public final LinkedHashSet f6775c0;

    public final FrameLayout f6776d;

    public int f6777d0;

    public EditText f6778e;

    public final SparseArray f6779e0;

    public CharSequence f6780f;

    public final CheckableImageButton f6781f0;

    public int f6782g;

    public final LinkedHashSet f6783g0;

    public int f6784h;

    public ColorStateList f6785h0;

    public int f6786i;

    public PorterDuff.Mode f6787i0;

    public int f6788j;

    public ColorDrawable f6789j0;

    public final C1878p f6790k;

    public int f6791k0;

    public boolean f6792l;

    public Drawable f6793l0;

    public int f6794m;

    public View.OnLongClickListener f6795m0;

    public boolean f6796n;

    public View.OnLongClickListener f6797n0;

    public AppCompatTextView f6798o;

    public final CheckableImageButton f6799o0;

    public int f6800p;

    public ColorStateList f6801p0;

    public int f6802q;

    public PorterDuff.Mode f6803q0;

    public CharSequence f6804r;

    public ColorStateList f6805r0;

    public boolean f6806s;

    public ColorStateList f6807s0;

    public AppCompatTextView f6808t;

    public int f6809t0;

    public ColorStateList f6810u;

    public int f6811u0;

    public int f6812v;

    public int f6813v0;

    public Fade f6814w;

    public ColorStateList f6815w0;

    public Fade f6816x;

    public int f6817x0;

    public ColorStateList f6818y;

    public int f6819y0;

    public ColorStateList f6820z;

    public int f6821z0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1883u();

        public CharSequence f6822c;

        public boolean f6823d;

        public CharSequence f6824e;

        public CharSequence f6825f;

        public CharSequence f6826g;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
            this.f6822c = (CharSequence) creator.createFromParcel(parcel);
            this.f6823d = parcel.readInt() == 1;
            this.f6824e = (CharSequence) creator.createFromParcel(parcel);
            this.f6825f = (CharSequence) creator.createFromParcel(parcel);
            this.f6826g = (CharSequence) creator.createFromParcel(parcel);
        }

        public final String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f6822c) + " hint=" + ((Object) this.f6824e) + " helperText=" + ((Object) this.f6825f) + " placeholderText=" + ((Object) this.f6826g) + "}";
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            TextUtils.writeToParcel(this.f6822c, parcel, i6);
            parcel.writeInt(this.f6823d ? 1 : 0);
            TextUtils.writeToParcel(this.f6824e, parcel, i6);
            TextUtils.writeToParcel(this.f6825f, parcel, i6);
            TextUtils.writeToParcel(this.f6826g, parcel, i6);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    private AbstractC1876n getEndIconDelegate() {
        SparseArray sparseArray = this.f6779e0;
        AbstractC1876n abstractC1876n = (AbstractC1876n) sparseArray.get(this.f6777d0);
        return abstractC1876n != null ? abstractC1876n : (AbstractC1876n) sparseArray.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        CheckableImageButton checkableImageButton = this.f6799o0;
        if (checkableImageButton.getVisibility() == 0) {
            return checkableImageButton;
        }
        if (this.f6777d0 == 0 || !m4360g()) {
            return null;
        }
        return this.f6781f0;
    }

    public static void m4352j(ViewGroup viewGroup, boolean z7) {
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = viewGroup.getChildAt(i6);
            childAt.setEnabled(z7);
            if (childAt instanceof ViewGroup) {
                m4352j((ViewGroup) childAt, z7);
            }
        }
    }

    public static void m4353k(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z7 = onLongClickListener != null;
        boolean z10 = zHasOnClickListeners || z7;
        checkableImageButton.setFocusable(z10);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z7);
        checkableImageButton.setImportantForAccessibility(z10 ? 1 : 2);
    }

    private void setEditText(EditText editText) {
        if (this.f6778e != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.f6777d0 != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f6778e = editText;
        int i6 = this.f6782g;
        if (i6 != -1) {
            setMinEms(i6);
        } else {
            setMinWidth(this.f6786i);
        }
        int i10 = this.f6784h;
        if (i10 != -1) {
            setMaxEms(i10);
        } else {
            setMaxWidth(this.f6788j);
        }
        m4361h();
        setTextInputAccessibilityDelegate(new C1882t(this));
        Typeface typeface = this.f6778e.getTypeface();
        C1816d c1816d = this.f6746D0;
        boolean zM4269n = c1816d.m4269n(typeface);
        boolean zM4271p = c1816d.m4271p(typeface);
        if (zM4269n || zM4271p) {
            c1816d.m4265j(false);
        }
        float textSize = this.f6778e.getTextSize();
        if (c1816d.f6415m != textSize) {
            c1816d.f6415m = textSize;
            c1816d.m4265j(false);
        }
        float letterSpacing = this.f6778e.getLetterSpacing();
        if (c1816d.f6404g0 != letterSpacing) {
            c1816d.f6404g0 = letterSpacing;
            c1816d.m4265j(false);
        }
        int gravity = this.f6778e.getGravity();
        c1816d.m4268m((gravity & (-113)) | 48);
        if (c1816d.f6411k != gravity) {
            c1816d.f6411k = gravity;
            c1816d.m4265j(false);
        }
        this.f6778e.addTextChangedListener(new C0253p2(2, this));
        if (this.f6805r0 == null) {
            this.f6805r0 = this.f6778e.getHintTextColors();
        }
        if (this.f6743C) {
            if (TextUtils.isEmpty(this.f6745D)) {
                CharSequence hint = this.f6778e.getHint();
                this.f6780f = hint;
                setHint(hint);
                this.f6778e.setHint((CharSequence) null);
            }
            this.f6747E = true;
        }
        if (this.f6798o != null) {
            m4364m(this.f6778e.getText().length());
        }
        m4367p();
        this.f6790k.m4394b();
        this.f6772b.bringToFront();
        this.f6774c.bringToFront();
        this.f6776d.bringToFront();
        this.f6799o0.bringToFront();
        Iterator it = this.f6775c0.iterator();
        while (it.hasNext()) {
            ((C1863a) it.next()).m4377a(this);
        }
        m4374w();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        m4371t(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f6745D)) {
            return;
        }
        this.f6745D = charSequence;
        C1816d c1816d = this.f6746D0;
        if (charSequence == null || !TextUtils.equals(c1816d.f6371G, charSequence)) {
            c1816d.f6371G = charSequence;
            c1816d.f6372H = null;
            Bitmap bitmap = c1816d.f6375K;
            if (bitmap != null) {
                bitmap.recycle();
                c1816d.f6375K = null;
            }
            c1816d.m4265j(false);
        }
        if (this.f6744C0) {
            return;
        }
        m4362i();
    }

    private void setPlaceholderTextEnabled(boolean z7) {
        if (this.f6806s == z7) {
            return;
        }
        if (z7) {
            AppCompatTextView appCompatTextView = this.f6808t;
            if (appCompatTextView != null) {
                this.f6771a.addView(appCompatTextView);
                this.f6808t.setVisibility(0);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.f6808t;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(8);
            }
            this.f6808t = null;
        }
        this.f6806s = z7;
    }

    public final void m4354a(float f) {
        C1816d c1816d = this.f6746D0;
        if (c1816d.f6395c == f) {
            return;
        }
        if (this.f6752G0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f6752G0 = valueAnimator;
            valueAnimator.setInterpolator(AbstractC4268a.f14470b);
            this.f6752G0.setDuration(167L);
            this.f6752G0.addUpdateListener(new C0066c(5, this));
        }
        this.f6752G0.setFloatValues(c1816d.f6395c, f);
        this.f6752G0.start();
    }

    @Override
    public final void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i6, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f6771a;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        m4370s();
        setEditText((EditText) view);
    }

    public final void m4355b() {
        int i6;
        int i10;
        C3908h c3908h = this.f6749F;
        if (c3908h == null) {
            return;
        }
        C3913m c3913m = c3908h.f13126a.f13107a;
        C3913m c3913m2 = this.f6755I;
        if (c3913m != c3913m2) {
            c3908h.setShapeAppearanceModel(c3913m2);
            if (this.f6777d0 == 3 && this.f6759L == 2) {
                C1875m c1875m = (C1875m) this.f6779e0.get(3);
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.f6778e;
                c1875m.getClass();
                if (!C1875m.m4387h(autoCompleteTextView) && c1875m.f6867a.getBoxBackgroundMode() == 2 && (autoCompleteTextView.getBackground() instanceof LayerDrawable)) {
                    c1875m.m4389e(autoCompleteTextView);
                }
            }
        }
        if (this.f6759L == 2 && (i6 = this.f6761N) > -1 && (i10 = this.f6764Q) != 0) {
            C3908h c3908h2 = this.f6749F;
            c3908h2.f13126a.f13116j = i6;
            c3908h2.invalidateSelf();
            c3908h2.m7814s(ColorStateList.valueOf(i10));
        }
        int iM5511f = this.f6765R;
        if (this.f6759L == 1) {
            iM5511f = AbstractC2478a.m5511f(this.f6765R, AbstractC3281e.m6627q(getContext(), R.attr.colorSurface, 0));
        }
        this.f6765R = iM5511f;
        this.f6749F.m7809n(ColorStateList.valueOf(iM5511f));
        if (this.f6777d0 == 3) {
            this.f6778e.getBackground().invalidateSelf();
        }
        C3908h c3908h3 = this.f6751G;
        if (c3908h3 != null && this.f6753H != null) {
            if (this.f6761N > -1 && this.f6764Q != 0) {
                c3908h3.m7809n(this.f6778e.isFocused() ? ColorStateList.valueOf(this.f6809t0) : ColorStateList.valueOf(this.f6764Q));
                this.f6753H.m7809n(ColorStateList.valueOf(this.f6764Q));
            }
            invalidate();
        }
        invalidate();
    }

    public final int m4356c() {
        float fM4261e;
        if (!this.f6743C) {
            return 0;
        }
        int i6 = this.f6759L;
        C1816d c1816d = this.f6746D0;
        if (i6 == 0) {
            fM4261e = c1816d.m4261e();
        } else {
            if (i6 != 2) {
                return 0;
            }
            fM4261e = c1816d.m4261e() / 2.0f;
        }
        return (int) fM4261e;
    }

    public final boolean m4357d() {
        return this.f6743C && !TextUtils.isEmpty(this.f6745D) && (this.f6749F instanceof C1869g);
    }

    @Override
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i6) {
        EditText editText = this.f6778e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i6);
            return;
        }
        if (this.f6780f != null) {
            boolean z7 = this.f6747E;
            this.f6747E = false;
            CharSequence hint = editText.getHint();
            this.f6778e.setHint(this.f6780f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i6);
                return;
            } finally {
                this.f6778e.setHint(hint);
                this.f6747E = z7;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i6);
        onProvideAutofillVirtualStructure(viewStructure, i6);
        FrameLayout frameLayout = this.f6771a;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i10 = 0; i10 < frameLayout.getChildCount(); i10++) {
            View childAt = frameLayout.getChildAt(i10);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i10);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i6);
            if (childAt == this.f6778e) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.f6756I0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f6756I0 = false;
    }

    @Override
    public final void draw(Canvas canvas) {
        C3908h c3908h;
        super.draw(canvas);
        boolean z7 = this.f6743C;
        C1816d c1816d = this.f6746D0;
        if (z7) {
            c1816d.m4260d(canvas);
        }
        if (this.f6753H == null || (c3908h = this.f6751G) == null) {
            return;
        }
        c3908h.draw(canvas);
        if (this.f6778e.isFocused()) {
            Rect bounds = this.f6753H.getBounds();
            Rect bounds2 = this.f6751G.getBounds();
            float f = c1816d.f6395c;
            int iCenterX = bounds2.centerX();
            bounds.left = AbstractC4268a.m8311c(f, iCenterX, bounds2.left);
            bounds.right = AbstractC4268a.m8311c(f, iCenterX, bounds2.right);
            this.f6753H.draw(canvas);
        }
    }

    @Override
    public final void drawableStateChanged() {
        boolean z7;
        ColorStateList colorStateList;
        if (this.f6754H0) {
            return;
        }
        this.f6754H0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        C1816d c1816d = this.f6746D0;
        if (c1816d != null) {
            c1816d.f6382R = drawableState;
            ColorStateList colorStateList2 = c1816d.f6421p;
            if ((colorStateList2 == null || !colorStateList2.isStateful()) && ((colorStateList = c1816d.f6419o) == null || !colorStateList.isStateful())) {
                z7 = false;
            } else {
                c1816d.m4265j(false);
                z7 = true;
            }
        } else {
            z7 = false;
        }
        if (this.f6778e != null) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            m4371t(isLaidOut() && isEnabled(), false);
        }
        m4367p();
        m4376y();
        if (z7) {
            invalidate();
        }
        this.f6754H0 = false;
    }

    public final int m4358e(int i6, boolean z7) {
        int compoundPaddingLeft = this.f6778e.getCompoundPaddingLeft() + i6;
        return (getPrefixText() == null || z7) ? compoundPaddingLeft : (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
    }

    public final int m4359f(int i6, boolean z7) {
        int compoundPaddingRight = i6 - this.f6778e.getCompoundPaddingRight();
        return (getPrefixText() == null || !z7) ? compoundPaddingRight : compoundPaddingRight + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
    }

    public final boolean m4360g() {
        return this.f6776d.getVisibility() == 0 && this.f6781f0.getVisibility() == 0;
    }

    @Override
    public int getBaseline() {
        EditText editText = this.f6778e;
        if (editText == null) {
            return super.getBaseline();
        }
        return m4356c() + getPaddingTop() + editText.getBaseline();
    }

    public C3908h getBoxBackground() {
        int i6 = this.f6759L;
        if (i6 == 1 || i6 == 2) {
            return this.f6749F;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f6765R;
    }

    public int getBoxBackgroundMode() {
        return this.f6759L;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.f6760M;
    }

    public float getBoxCornerRadiusBottomEnd() {
        boolean zM4249i = AbstractC1811a0.m4249i(this);
        RectF rectF = this.f6768U;
        return zM4249i ? this.f6755I.f13171h.mo7794a(rectF) : this.f6755I.f13170g.mo7794a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        boolean zM4249i = AbstractC1811a0.m4249i(this);
        RectF rectF = this.f6768U;
        return zM4249i ? this.f6755I.f13170g.mo7794a(rectF) : this.f6755I.f13171h.mo7794a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        boolean zM4249i = AbstractC1811a0.m4249i(this);
        RectF rectF = this.f6768U;
        return zM4249i ? this.f6755I.f13168e.mo7794a(rectF) : this.f6755I.f13169f.mo7794a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        boolean zM4249i = AbstractC1811a0.m4249i(this);
        RectF rectF = this.f6768U;
        return zM4249i ? this.f6755I.f13169f.mo7794a(rectF) : this.f6755I.f13168e.mo7794a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.f6813v0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f6815w0;
    }

    public int getBoxStrokeWidth() {
        return this.f6762O;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f6763P;
    }

    public int getCounterMaxLength() {
        return this.f6794m;
    }

    public CharSequence getCounterOverflowDescription() {
        AppCompatTextView appCompatTextView;
        if (this.f6792l && this.f6796n && (appCompatTextView = this.f6798o) != null) {
            return appCompatTextView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f6818y;
    }

    public ColorStateList getCounterTextColor() {
        return this.f6818y;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f6805r0;
    }

    public EditText getEditText() {
        return this.f6778e;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f6781f0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f6781f0.getDrawable();
    }

    public int getEndIconMode() {
        return this.f6777d0;
    }

    public CheckableImageButton getEndIconView() {
        return this.f6781f0;
    }

    public CharSequence getError() {
        C1878p c1878p = this.f6790k;
        if (c1878p.f6883k) {
            return c1878p.f6882j;
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.f6790k.f6885m;
    }

    public int getErrorCurrentTextColors() {
        AppCompatTextView appCompatTextView = this.f6790k.f6884l;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.f6799o0.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        AppCompatTextView appCompatTextView = this.f6790k.f6884l;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHelperText() {
        C1878p c1878p = this.f6790k;
        if (c1878p.f6889q) {
            return c1878p.f6888p;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.f6790k.f6890r;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.f6743C) {
            return this.f6745D;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.f6746D0.m4261e();
    }

    public final int getHintCurrentCollapsedTextColor() {
        C1816d c1816d = this.f6746D0;
        return c1816d.m4262f(c1816d.f6421p);
    }

    public ColorStateList getHintTextColor() {
        return this.f6807s0;
    }

    public int getMaxEms() {
        return this.f6784h;
    }

    public int getMaxWidth() {
        return this.f6788j;
    }

    public int getMinEms() {
        return this.f6782g;
    }

    public int getMinWidth() {
        return this.f6786i;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f6781f0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f6781f0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f6806s) {
            return this.f6804r;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f6812v;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f6810u;
    }

    public CharSequence getPrefixText() {
        return this.f6772b.f6899c;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f6772b.f6898b.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f6772b.f6898b;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f6772b.f6900d.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.f6772b.f6900d.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.f6739A;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f6741B.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f6741B;
    }

    public Typeface getTypeface() {
        return this.f6769V;
    }

    public final void m4361h() {
        int i6 = this.f6759L;
        if (i6 == 0) {
            this.f6749F = null;
            this.f6751G = null;
            this.f6753H = null;
        } else if (i6 == 1) {
            this.f6749F = new C3908h(this.f6755I);
            this.f6751G = new C3908h();
            this.f6753H = new C3908h();
        } else {
            if (i6 != 2) {
                throw new IllegalArgumentException(this.f6759L + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.f6743C || (this.f6749F instanceof C1869g)) {
                this.f6749F = new C3908h(this.f6755I);
            } else {
                this.f6749F = new C1869g(this.f6755I);
            }
            this.f6751G = null;
            this.f6753H = null;
        }
        EditText editText = this.f6778e;
        if (editText != null && this.f6749F != null && editText.getBackground() == null && this.f6759L != 0) {
            EditText editText2 = this.f6778e;
            C3908h c3908h = this.f6749F;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            editText2.setBackground(c3908h);
        }
        m4376y();
        if (this.f6759L == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.f6760M = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (AbstractC1466d.m3501u(getContext())) {
                this.f6760M = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.f6778e != null && this.f6759L == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                EditText editText3 = this.f6778e;
                WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), this.f6778e.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (AbstractC1466d.m3501u(getContext())) {
                EditText editText4 = this.f6778e;
                WeakHashMap weakHashMap3 = AbstractC3155s0.f10642a;
                editText4.setPaddingRelative(editText4.getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), this.f6778e.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.f6759L != 0) {
            m4370s();
        }
    }

    public final void m4362i() {
        float f;
        float f3;
        float f4;
        float f5;
        int i6;
        int i10;
        if (m4357d()) {
            RectF rectF = this.f6768U;
            int width = this.f6778e.getWidth();
            int gravity = this.f6778e.getGravity();
            C1816d c1816d = this.f6746D0;
            boolean zM4258b = c1816d.m4258b(c1816d.f6371G);
            c1816d.f6373I = zM4258b;
            Rect rect = c1816d.f6407i;
            if (gravity != 17 && (gravity & 7) != 1) {
                if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (zM4258b) {
                        i10 = rect.left;
                        f4 = i10;
                    } else {
                        f = rect.right;
                        f3 = c1816d.f6410j0;
                    }
                } else if (zM4258b) {
                    f = rect.right;
                    f3 = c1816d.f6410j0;
                } else {
                    i10 = rect.left;
                    f4 = i10;
                }
                rectF.left = f4;
                float f10 = rect.top;
                rectF.top = f10;
                if (gravity != 17 || (gravity & 7) == 1) {
                    f5 = (width / 2.0f) + (c1816d.f6410j0 / 2.0f);
                } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (zM4258b) {
                        f5 = f4 + c1816d.f6410j0;
                    } else {
                        i6 = rect.right;
                        f5 = i6;
                    }
                } else if (zM4258b) {
                    i6 = rect.right;
                    f5 = i6;
                } else {
                    f5 = c1816d.f6410j0 + f4;
                }
                rectF.right = f5;
                rectF.bottom = c1816d.m4261e() + f10;
                float f11 = rectF.left;
                float f12 = this.f6758K;
                rectF.left = f11 - f12;
                rectF.right += f12;
                rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.f6761N);
                C1869g c1869g = (C1869g) this.f6749F;
                c1869g.getClass();
                c1869g.m4383w(rectF.left, rectF.top, rectF.right, rectF.bottom);
            }
            f = width / 2.0f;
            f3 = c1816d.f6410j0 / 2.0f;
            f4 = f - f3;
            rectF.left = f4;
            float f13 = rect.top;
            rectF.top = f13;
            if (gravity != 17) {
                f5 = (width / 2.0f) + (c1816d.f6410j0 / 2.0f);
            } else {
                f5 = (width / 2.0f) + (c1816d.f6410j0 / 2.0f);
            }
            rectF.right = f5;
            rectF.bottom = c1816d.m4261e() + f13;
            float f14 = rectF.left;
            float f15 = this.f6758K;
            rectF.left = f14 - f15;
            rectF.right += f15;
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.f6761N);
            C1869g c1869g2 = (C1869g) this.f6749F;
            c1869g2.getClass();
            c1869g2.m4383w(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    public final void m4363l(AppCompatTextView appCompatTextView, int i6) {
        try {
            AbstractC3198d.m6443R(appCompatTextView, i6);
            if (Build.VERSION.SDK_INT < 23 || appCompatTextView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        AbstractC3198d.m6443R(appCompatTextView, R.style.TextAppearance_AppCompat_Caption);
        appCompatTextView.setTextColor(AbstractC3928d.m7847i(getContext(), R.color.design_error));
    }

    public final void m4364m(int i6) {
        boolean z7 = this.f6796n;
        int i10 = this.f6794m;
        String string = null;
        if (i10 == -1) {
            this.f6798o.setText(String.valueOf(i6));
            this.f6798o.setContentDescription(null);
            this.f6796n = false;
        } else {
            this.f6796n = i6 > i10;
            Context context = getContext();
            this.f6798o.setContentDescription(context.getString(this.f6796n ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, Integer.valueOf(i6), Integer.valueOf(this.f6794m)));
            if (z7 != this.f6796n) {
                m4365n();
            }
            C2951b c2951bM5974c = C2951b.m5974c();
            AppCompatTextView appCompatTextView = this.f6798o;
            String string2 = getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i6), Integer.valueOf(this.f6794m));
            if (string2 == null) {
                c2951bM5974c.getClass();
            } else {
                c2951bM5974c.getClass();
                C0157r0 c0157r0 = AbstractC2959j.f10137a;
                string = c2951bM5974c.m5975d(string2).toString();
            }
            appCompatTextView.setText(string);
        }
        if (this.f6778e == null || z7 == this.f6796n) {
            return;
        }
        m4371t(false, false);
        m4376y();
        m4367p();
    }

    public final void m4365n() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.f6798o;
        if (appCompatTextView != null) {
            m4363l(appCompatTextView, this.f6796n ? this.f6800p : this.f6802q);
            if (!this.f6796n && (colorStateList2 = this.f6818y) != null) {
                this.f6798o.setTextColor(colorStateList2);
            }
            if (!this.f6796n || (colorStateList = this.f6820z) == null) {
                return;
            }
            this.f6798o.setTextColor(colorStateList);
        }
    }

    public final boolean m4366o() {
        boolean z7;
        if (this.f6778e == null) {
            return false;
        }
        boolean z10 = true;
        if (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) {
            C1880r c1880r = this.f6772b;
            if (c1880r.getMeasuredWidth() > 0) {
                int measuredWidth = c1880r.getMeasuredWidth() - this.f6778e.getPaddingLeft();
                if (this.f6770W == null || this.f6773b0 != measuredWidth) {
                    ColorDrawable colorDrawable = new ColorDrawable();
                    this.f6770W = colorDrawable;
                    this.f6773b0 = measuredWidth;
                    colorDrawable.setBounds(0, 0, measuredWidth, 1);
                }
                Drawable[] compoundDrawablesRelative = this.f6778e.getCompoundDrawablesRelative();
                Drawable drawable = compoundDrawablesRelative[0];
                ColorDrawable colorDrawable2 = this.f6770W;
                if (drawable != colorDrawable2) {
                    this.f6778e.setCompoundDrawablesRelative(colorDrawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                    z7 = true;
                } else {
                    z7 = false;
                }
            } else if (this.f6770W != null) {
                Drawable[] compoundDrawablesRelative2 = this.f6778e.getCompoundDrawablesRelative();
                this.f6778e.setCompoundDrawablesRelative(null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.f6770W = null;
                z7 = true;
            } else {
                z7 = false;
            }
        } else if (this.f6770W != null) {
            Drawable[] compoundDrawablesRelative3 = this.f6778e.getCompoundDrawablesRelative();
            this.f6778e.setCompoundDrawablesRelative(null, compoundDrawablesRelative3[1], compoundDrawablesRelative3[2], compoundDrawablesRelative3[3]);
            this.f6770W = null;
            z7 = true;
        } else {
            z7 = false;
        }
        if ((this.f6799o0.getVisibility() == 0 || ((this.f6777d0 != 0 && m4360g()) || this.f6739A != null)) && this.f6774c.getMeasuredWidth() > 0) {
            int measuredWidth2 = this.f6741B.getMeasuredWidth() - this.f6778e.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = ((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams()).getMarginStart() + endIconToUpdateDummyDrawable.getMeasuredWidth() + measuredWidth2;
            }
            Drawable[] compoundDrawablesRelative4 = this.f6778e.getCompoundDrawablesRelative();
            ColorDrawable colorDrawable3 = this.f6789j0;
            if (colorDrawable3 == null || this.f6791k0 == measuredWidth2) {
                if (colorDrawable3 == null) {
                    ColorDrawable colorDrawable4 = new ColorDrawable();
                    this.f6789j0 = colorDrawable4;
                    this.f6791k0 = measuredWidth2;
                    colorDrawable4.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable2 = compoundDrawablesRelative4[2];
                ColorDrawable colorDrawable5 = this.f6789j0;
                if (drawable2 != colorDrawable5) {
                    this.f6793l0 = drawable2;
                    this.f6778e.setCompoundDrawablesRelative(compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], colorDrawable5, compoundDrawablesRelative4[3]);
                } else {
                    z10 = z7;
                }
            } else {
                this.f6791k0 = measuredWidth2;
                colorDrawable3.setBounds(0, 0, measuredWidth2, 1);
                this.f6778e.setCompoundDrawablesRelative(compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.f6789j0, compoundDrawablesRelative4[3]);
            }
        } else {
            if (this.f6789j0 == null) {
                return z7;
            }
            Drawable[] compoundDrawablesRelative5 = this.f6778e.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative5[2] == this.f6789j0) {
                this.f6778e.setCompoundDrawablesRelative(compoundDrawablesRelative5[0], compoundDrawablesRelative5[1], this.f6793l0, compoundDrawablesRelative5[3]);
            } else {
                z10 = z7;
            }
            this.f6789j0 = null;
        }
        return z10;
    }

    @Override
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f6746D0.m4263h(configuration);
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        EditText editText = this.f6778e;
        if (editText != null) {
            Rect rect = this.f6766S;
            AbstractC1818e.m4274a(this, editText, rect);
            C3908h c3908h = this.f6751G;
            if (c3908h != null) {
                int i13 = rect.bottom;
                c3908h.setBounds(rect.left, i13 - this.f6762O, rect.right, i13);
            }
            C3908h c3908h2 = this.f6753H;
            if (c3908h2 != null) {
                int i14 = rect.bottom;
                c3908h2.setBounds(rect.left, i14 - this.f6763P, rect.right, i14);
            }
            if (this.f6743C) {
                float textSize = this.f6778e.getTextSize();
                C1816d c1816d = this.f6746D0;
                if (c1816d.f6415m != textSize) {
                    c1816d.f6415m = textSize;
                    c1816d.m4265j(false);
                }
                int gravity = this.f6778e.getGravity();
                c1816d.m4268m((gravity & (-113)) | 48);
                if (c1816d.f6411k != gravity) {
                    c1816d.f6411k = gravity;
                    c1816d.m4265j(false);
                }
                if (this.f6778e == null) {
                    throw new IllegalStateException();
                }
                boolean zM4249i = AbstractC1811a0.m4249i(this);
                int i15 = rect.bottom;
                Rect rect2 = this.f6767T;
                rect2.bottom = i15;
                int i16 = this.f6759L;
                if (i16 == 1) {
                    rect2.left = m4358e(rect.left, zM4249i);
                    rect2.top = rect.top + this.f6760M;
                    rect2.right = m4359f(rect.right, zM4249i);
                } else if (i16 != 2) {
                    rect2.left = m4358e(rect.left, zM4249i);
                    rect2.top = getPaddingTop();
                    rect2.right = m4359f(rect.right, zM4249i);
                } else {
                    rect2.left = this.f6778e.getPaddingLeft() + rect.left;
                    rect2.top = rect.top - m4356c();
                    rect2.right = rect.right - this.f6778e.getPaddingRight();
                }
                int i17 = rect2.left;
                int i18 = rect2.top;
                int i19 = rect2.right;
                int i20 = rect2.bottom;
                Rect rect3 = c1816d.f6407i;
                if (rect3.left != i17 || rect3.top != i18 || rect3.right != i19 || rect3.bottom != i20) {
                    rect3.set(i17, i18, i19, i20);
                    c1816d.f6383S = true;
                    c1816d.m4264i();
                }
                if (this.f6778e == null) {
                    throw new IllegalStateException();
                }
                TextPaint textPaint = c1816d.f6385U;
                textPaint.setTextSize(c1816d.f6415m);
                textPaint.setTypeface(c1816d.f6365A);
                textPaint.setLetterSpacing(c1816d.f6404g0);
                float f = -textPaint.ascent();
                rect2.left = this.f6778e.getCompoundPaddingLeft() + rect.left;
                rect2.top = (this.f6759L != 1 || this.f6778e.getMinLines() > 1) ? rect.top + this.f6778e.getCompoundPaddingTop() : (int) (rect.centerY() - (f / 2.0f));
                rect2.right = rect.right - this.f6778e.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.f6759L != 1 || this.f6778e.getMinLines() > 1) ? rect.bottom - this.f6778e.getCompoundPaddingBottom() : (int) (rect2.top + f);
                rect2.bottom = compoundPaddingBottom;
                int i21 = rect2.left;
                int i22 = rect2.top;
                int i23 = rect2.right;
                Rect rect4 = c1816d.f6405h;
                if (rect4.left != i21 || rect4.top != i22 || rect4.right != i23 || rect4.bottom != compoundPaddingBottom) {
                    rect4.set(i21, i22, i23, compoundPaddingBottom);
                    c1816d.f6383S = true;
                    c1816d.m4264i();
                }
                c1816d.m4265j(false);
                if (!m4357d() || this.f6744C0) {
                    return;
                }
                m4362i();
            }
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        EditText editText;
        int iMax;
        super.onMeasure(i6, i10);
        boolean z7 = false;
        if (this.f6778e != null && this.f6778e.getMeasuredHeight() < (iMax = Math.max(this.f6774c.getMeasuredHeight(), this.f6772b.getMeasuredHeight()))) {
            this.f6778e.setMinimumHeight(iMax);
            z7 = true;
        }
        boolean zM4366o = m4366o();
        if (z7 || zM4366o) {
            this.f6778e.post(new RunnableC1881s(this, 1));
        }
        if (this.f6808t != null && (editText = this.f6778e) != null) {
            this.f6808t.setGravity(editText.getGravity());
            this.f6808t.setPadding(this.f6778e.getCompoundPaddingLeft(), this.f6778e.getCompoundPaddingTop(), this.f6778e.getCompoundPaddingRight(), this.f6778e.getCompoundPaddingBottom());
        }
        m4374w();
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1689a);
        setError(savedState.f6822c);
        if (savedState.f6823d) {
            this.f6781f0.post(new RunnableC1881s(this, 0));
        }
        setHint(savedState.f6824e);
        setHelperText(savedState.f6825f);
        setPlaceholderText(savedState.f6826g);
        requestLayout();
    }

    @Override
    public final void onRtlPropertiesChanged(int i6) {
        super.onRtlPropertiesChanged(i6);
        boolean z7 = false;
        boolean z10 = i6 == 1;
        boolean z11 = this.f6757J;
        if (z10 != z11) {
            if (z10 && !z11) {
                z7 = true;
            }
            InterfaceC3903c interfaceC3903c = this.f6755I.f13168e;
            RectF rectF = this.f6768U;
            float fMo7794a = interfaceC3903c.mo7794a(rectF);
            float fMo7794a2 = this.f6755I.f13169f.mo7794a(rectF);
            float fMo7794a3 = this.f6755I.f13171h.mo7794a(rectF);
            float fMo7794a4 = this.f6755I.f13170g.mo7794a(rectF);
            float f = z7 ? fMo7794a : fMo7794a2;
            if (z7) {
                fMo7794a = fMo7794a2;
            }
            float f3 = z7 ? fMo7794a3 : fMo7794a4;
            if (z7) {
                fMo7794a3 = fMo7794a4;
            }
            boolean zM4249i = AbstractC1811a0.m4249i(this);
            this.f6757J = zM4249i;
            float f4 = zM4249i ? fMo7794a : f;
            if (!zM4249i) {
                f = fMo7794a;
            }
            float f5 = zM4249i ? fMo7794a3 : f3;
            if (!zM4249i) {
                f3 = fMo7794a3;
            }
            C3908h c3908h = this.f6749F;
            if (c3908h != null && c3908h.m7804i() == f4) {
                C3908h c3908h2 = this.f6749F;
                if (c3908h2.f13126a.f13107a.f13169f.mo7794a(c3908h2.m7802g()) == f) {
                    C3908h c3908h3 = this.f6749F;
                    if (c3908h3.f13126a.f13107a.f13171h.mo7794a(c3908h3.m7802g()) == f5) {
                        C3908h c3908h4 = this.f6749F;
                        if (c3908h4.f13126a.f13107a.f13170g.mo7794a(c3908h4.m7802g()) == f3) {
                            return;
                        }
                    }
                }
            }
            C3912l c3912lM7826f = this.f6755I.m7826f();
            c3912lM7826f.f13155e = new C3901a(f4);
            c3912lM7826f.f13156f = new C3901a(f);
            c3912lM7826f.f13158h = new C3901a(f5);
            c3912lM7826f.f13157g = new C3901a(f3);
            this.f6755I = c3912lM7826f.m7819a();
            m4355b();
        }
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f6790k.m4397e()) {
            savedState.f6822c = getError();
        }
        savedState.f6823d = this.f6777d0 != 0 && this.f6781f0.f6319d;
        savedState.f6824e = getHint();
        savedState.f6825f = getHelperText();
        savedState.f6826g = getPlaceholderText();
        return savedState;
    }

    public final void m4367p() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        EditText editText = this.f6778e;
        if (editText == null || this.f6759L != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = AbstractC0237m1.f1008a;
        Drawable drawableMutate = background.mutate();
        C1878p c1878p = this.f6790k;
        if (c1878p.m4397e()) {
            AppCompatTextView appCompatTextView2 = c1878p.f6884l;
            drawableMutate.setColorFilter(C0285w.m802c(appCompatTextView2 != null ? appCompatTextView2.getCurrentTextColor() : -1, PorterDuff.Mode.SRC_IN));
        } else if (this.f6796n && (appCompatTextView = this.f6798o) != null) {
            drawableMutate.setColorFilter(C0285w.m802c(appCompatTextView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            AbstractC3198d.m6452a(drawableMutate);
            this.f6778e.refreshDrawableState();
        }
    }

    public final void m4368q() {
        int visibility = this.f6781f0.getVisibility();
        CheckableImageButton checkableImageButton = this.f6799o0;
        this.f6776d.setVisibility((visibility != 0 || checkableImageButton.getVisibility() == 0) ? 8 : 0);
        this.f6774c.setVisibility((m4360g() || checkableImageButton.getVisibility() == 0 || ((this.f6739A == null || this.f6744C0) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    public final void m4369r() {
        int i6;
        if (getErrorIconDrawable() != null) {
            C1878p c1878p = this.f6790k;
            if (c1878p.f6883k && c1878p.m4397e()) {
                i6 = 0;
            } else {
                i6 = 8;
            }
        } else {
            i6 = 8;
        }
        this.f6799o0.setVisibility(i6);
        m4368q();
        m4374w();
        if (this.f6777d0 != 0) {
            return;
        }
        m4366o();
    }

    public final void m4370s() {
        if (this.f6759L != 1) {
            FrameLayout frameLayout = this.f6771a;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iM4356c = m4356c();
            if (iM4356c != layoutParams.topMargin) {
                layoutParams.topMargin = iM4356c;
                frameLayout.requestLayout();
            }
        }
    }

    public void setBoxBackgroundColor(int i6) {
        if (this.f6765R != i6) {
            this.f6765R = i6;
            this.f6817x0 = i6;
            this.f6821z0 = i6;
            this.f6740A0 = i6;
            m4355b();
        }
    }

    public void setBoxBackgroundColorResource(int i6) {
        setBoxBackgroundColor(AbstractC3928d.m7847i(getContext(), i6));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f6817x0 = defaultColor;
        this.f6765R = defaultColor;
        this.f6819y0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f6821z0 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.f6740A0 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        m4355b();
    }

    public void setBoxBackgroundMode(int i6) {
        if (i6 == this.f6759L) {
            return;
        }
        this.f6759L = i6;
        if (this.f6778e != null) {
            m4361h();
        }
    }

    public void setBoxCollapsedPaddingTop(int i6) {
        this.f6760M = i6;
    }

    public void setBoxStrokeColor(int i6) {
        if (this.f6813v0 != i6) {
            this.f6813v0 = i6;
            m4376y();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f6809t0 = colorStateList.getDefaultColor();
            this.f6742B0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f6811u0 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            this.f6813v0 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        } else if (this.f6813v0 != colorStateList.getDefaultColor()) {
            this.f6813v0 = colorStateList.getDefaultColor();
        }
        m4376y();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f6815w0 != colorStateList) {
            this.f6815w0 = colorStateList;
            m4376y();
        }
    }

    public void setBoxStrokeWidth(int i6) {
        this.f6762O = i6;
        m4376y();
    }

    public void setBoxStrokeWidthFocused(int i6) {
        this.f6763P = i6;
        m4376y();
    }

    public void setBoxStrokeWidthFocusedResource(int i6) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i6));
    }

    public void setBoxStrokeWidthResource(int i6) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i6));
    }

    public void setCounterEnabled(boolean z7) {
        if (this.f6792l != z7) {
            C1878p c1878p = this.f6790k;
            if (z7) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
                this.f6798o = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.f6769V;
                if (typeface != null) {
                    this.f6798o.setTypeface(typeface);
                }
                this.f6798o.setMaxLines(1);
                c1878p.m4393a(this.f6798o, 2);
                ((ViewGroup.MarginLayoutParams) this.f6798o.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                m4365n();
                if (this.f6798o != null) {
                    EditText editText = this.f6778e;
                    m4364m(editText == null ? 0 : editText.getText().length());
                }
            } else {
                c1878p.m4400h(this.f6798o, 2);
                this.f6798o = null;
            }
            this.f6792l = z7;
        }
    }

    public void setCounterMaxLength(int i6) {
        if (this.f6794m != i6) {
            if (i6 > 0) {
                this.f6794m = i6;
            } else {
                this.f6794m = -1;
            }
            if (!this.f6792l || this.f6798o == null) {
                return;
            }
            EditText editText = this.f6778e;
            m4364m(editText == null ? 0 : editText.getText().length());
        }
    }

    public void setCounterOverflowTextAppearance(int i6) {
        if (this.f6800p != i6) {
            this.f6800p = i6;
            m4365n();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f6820z != colorStateList) {
            this.f6820z = colorStateList;
            m4365n();
        }
    }

    public void setCounterTextAppearance(int i6) {
        if (this.f6802q != i6) {
            this.f6802q = i6;
            m4365n();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f6818y != colorStateList) {
            this.f6818y = colorStateList;
            m4365n();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f6805r0 = colorStateList;
        this.f6807s0 = colorStateList;
        if (this.f6778e != null) {
            m4371t(false, false);
        }
    }

    @Override
    public void setEnabled(boolean z7) {
        m4352j(this, z7);
        super.setEnabled(z7);
    }

    public void setEndIconActivated(boolean z7) {
        this.f6781f0.setActivated(z7);
    }

    public void setEndIconCheckable(boolean z7) {
        this.f6781f0.setCheckable(z7);
    }

    public void setEndIconContentDescription(int i6) {
        setEndIconContentDescription(i6 != 0 ? getResources().getText(i6) : null);
    }

    public void setEndIconDrawable(int i6) {
        setEndIconDrawable(i6 != 0 ? AbstractC1465c.m3473h(getContext(), i6) : null);
    }

    public void setEndIconMode(int i6) {
        int i10 = this.f6777d0;
        if (i10 == i6) {
            return;
        }
        this.f6777d0 = i6;
        for (C1864b c1864b : this.f6783g0) {
            switch (c1864b.f6829a) {
                case 0:
                    EditText editText = getEditText();
                    if (editText != null && i10 == 2) {
                        editText.post(new RunnableC0038c(c1864b, 5, editText));
                        View.OnFocusChangeListener onFocusChangeListener = editText.getOnFocusChangeListener();
                        C1867e c1867e = (C1867e) c1864b.f6830b;
                        if (onFocusChangeListener == c1867e.f6836f) {
                            editText.setOnFocusChangeListener(null);
                        }
                        if (c1867e.f6869c.getOnFocusChangeListener() == c1867e.f6836f) {
                            c1867e.f6869c.setOnFocusChangeListener(null);
                        }
                    }
                    break;
                case 1:
                    AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) getEditText();
                    C1875m c1875m = (C1875m) c1864b.f6830b;
                    if (autoCompleteTextView != null && i10 == 3) {
                        autoCompleteTextView.post(new RunnableC0038c(c1864b, 7, autoCompleteTextView));
                        if (autoCompleteTextView.getOnFocusChangeListener() == c1875m.f6853f) {
                            autoCompleteTextView.setOnFocusChangeListener(null);
                        }
                        autoCompleteTextView.setOnTouchListener(null);
                        autoCompleteTextView.setOnDismissListener(null);
                    }
                    if (i10 == 3) {
                        removeOnAttachStateChangeListener(c1875m.f6857j);
                        AccessibilityManager accessibilityManager = c1875m.f6864q;
                        if (accessibilityManager != null) {
                            accessibilityManager.removeTouchExplorationStateChangeListener(new AccessibilityManagerTouchExplorationStateChangeListenerC3227b(c1875m.f6858k));
                        }
                    }
                    break;
                default:
                    EditText editText2 = getEditText();
                    if (editText2 != null && i10 == 1) {
                        editText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        editText2.post(new RunnableC0038c(c1864b, 8, editText2));
                    }
                    break;
            }
        }
        setEndIconVisible(i6 != 0);
        if (!getEndIconDelegate().mo4388b(this.f6759L)) {
            throw new IllegalStateException("The current box background mode " + this.f6759L + " is not supported by the end icon mode " + i6);
        }
        getEndIconDelegate().mo4379a();
        AbstractC3928d.m7840a(this, this.f6781f0, this.f6785h0, this.f6787i0);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        View.OnLongClickListener onLongClickListener = this.f6795m0;
        CheckableImageButton checkableImageButton = this.f6781f0;
        checkableImageButton.setOnClickListener(onClickListener);
        m4353k(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f6795m0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.f6781f0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        m4353k(checkableImageButton, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.f6785h0 != colorStateList) {
            this.f6785h0 = colorStateList;
            AbstractC3928d.m7840a(this, this.f6781f0, colorStateList, this.f6787i0);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.f6787i0 != mode) {
            this.f6787i0 = mode;
            AbstractC3928d.m7840a(this, this.f6781f0, this.f6785h0, mode);
        }
    }

    public void setEndIconVisible(boolean z7) {
        if (m4360g() != z7) {
            this.f6781f0.setVisibility(z7 ? 0 : 8);
            m4368q();
            m4374w();
            m4366o();
        }
    }

    public void setError(CharSequence charSequence) {
        C1878p c1878p = this.f6790k;
        if (!c1878p.f6883k) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            c1878p.m4399g();
            return;
        }
        c1878p.m4395c();
        c1878p.f6882j = charSequence;
        c1878p.f6884l.setText(charSequence);
        int i6 = c1878p.f6880h;
        if (i6 != 1) {
            c1878p.f6881i = 1;
        }
        c1878p.m4402j(i6, c1878p.f6881i, c1878p.m4401i(c1878p.f6884l, charSequence));
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        C1878p c1878p = this.f6790k;
        c1878p.f6885m = charSequence;
        AppCompatTextView appCompatTextView = c1878p.f6884l;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z7) {
        C1878p c1878p = this.f6790k;
        if (c1878p.f6883k == z7) {
            return;
        }
        c1878p.m4395c();
        TextInputLayout textInputLayout = c1878p.f6874b;
        if (z7) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(c1878p.f6873a, null);
            c1878p.f6884l = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_error);
            c1878p.f6884l.setTextAlignment(5);
            Typeface typeface = c1878p.f6893u;
            if (typeface != null) {
                c1878p.f6884l.setTypeface(typeface);
            }
            int i6 = c1878p.f6886n;
            c1878p.f6886n = i6;
            AppCompatTextView appCompatTextView2 = c1878p.f6884l;
            if (appCompatTextView2 != null) {
                textInputLayout.m4363l(appCompatTextView2, i6);
            }
            ColorStateList colorStateList = c1878p.f6887o;
            c1878p.f6887o = colorStateList;
            AppCompatTextView appCompatTextView3 = c1878p.f6884l;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            CharSequence charSequence = c1878p.f6885m;
            c1878p.f6885m = charSequence;
            AppCompatTextView appCompatTextView4 = c1878p.f6884l;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setContentDescription(charSequence);
            }
            c1878p.f6884l.setVisibility(4);
            AppCompatTextView appCompatTextView5 = c1878p.f6884l;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            appCompatTextView5.setAccessibilityLiveRegion(1);
            c1878p.m4393a(c1878p.f6884l, 0);
        } else {
            c1878p.m4399g();
            c1878p.m4400h(c1878p.f6884l, 0);
            c1878p.f6884l = null;
            textInputLayout.m4367p();
            textInputLayout.m4376y();
        }
        c1878p.f6883k = z7;
    }

    public void setErrorIconDrawable(int i6) {
        setErrorIconDrawable(i6 != 0 ? AbstractC1465c.m3473h(getContext(), i6) : null);
        AbstractC3928d.m7859x(this, this.f6799o0, this.f6801p0);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        View.OnLongClickListener onLongClickListener = this.f6797n0;
        CheckableImageButton checkableImageButton = this.f6799o0;
        checkableImageButton.setOnClickListener(onClickListener);
        m4353k(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f6797n0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.f6799o0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        m4353k(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        if (this.f6801p0 != colorStateList) {
            this.f6801p0 = colorStateList;
            AbstractC3928d.m7840a(this, this.f6799o0, colorStateList, this.f6803q0);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        if (this.f6803q0 != mode) {
            this.f6803q0 = mode;
            AbstractC3928d.m7840a(this, this.f6799o0, this.f6801p0, mode);
        }
    }

    public void setErrorTextAppearance(int i6) {
        C1878p c1878p = this.f6790k;
        c1878p.f6886n = i6;
        AppCompatTextView appCompatTextView = c1878p.f6884l;
        if (appCompatTextView != null) {
            c1878p.f6874b.m4363l(appCompatTextView, i6);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        C1878p c1878p = this.f6790k;
        c1878p.f6887o = colorStateList;
        AppCompatTextView appCompatTextView = c1878p.f6884l;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z7) {
        if (this.f6748E0 != z7) {
            this.f6748E0 = z7;
            m4371t(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        C1878p c1878p = this.f6790k;
        if (zIsEmpty) {
            if (c1878p.f6889q) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!c1878p.f6889q) {
            setHelperTextEnabled(true);
        }
        c1878p.m4395c();
        c1878p.f6888p = charSequence;
        c1878p.f6890r.setText(charSequence);
        int i6 = c1878p.f6880h;
        if (i6 != 2) {
            c1878p.f6881i = 2;
        }
        c1878p.m4402j(i6, c1878p.f6881i, c1878p.m4401i(c1878p.f6890r, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        C1878p c1878p = this.f6790k;
        c1878p.f6892t = colorStateList;
        AppCompatTextView appCompatTextView = c1878p.f6890r;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z7) {
        int i6 = 0;
        C1878p c1878p = this.f6790k;
        if (c1878p.f6889q == z7) {
            return;
        }
        c1878p.m4395c();
        if (z7) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(c1878p.f6873a, null);
            c1878p.f6890r = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_helper_text);
            c1878p.f6890r.setTextAlignment(5);
            Typeface typeface = c1878p.f6893u;
            if (typeface != null) {
                c1878p.f6890r.setTypeface(typeface);
            }
            c1878p.f6890r.setVisibility(4);
            AppCompatTextView appCompatTextView2 = c1878p.f6890r;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            appCompatTextView2.setAccessibilityLiveRegion(1);
            int i10 = c1878p.f6891s;
            c1878p.f6891s = i10;
            AppCompatTextView appCompatTextView3 = c1878p.f6890r;
            if (appCompatTextView3 != null) {
                AbstractC3198d.m6443R(appCompatTextView3, i10);
            }
            ColorStateList colorStateList = c1878p.f6892t;
            c1878p.f6892t = colorStateList;
            AppCompatTextView appCompatTextView4 = c1878p.f6890r;
            if (appCompatTextView4 != null && colorStateList != null) {
                appCompatTextView4.setTextColor(colorStateList);
            }
            c1878p.m4393a(c1878p.f6890r, 1);
            c1878p.f6890r.setAccessibilityDelegate(new C1877o(i6, c1878p));
        } else {
            c1878p.m4395c();
            int i11 = c1878p.f6880h;
            if (i11 == 2) {
                c1878p.f6881i = 0;
            }
            c1878p.m4402j(i11, c1878p.f6881i, c1878p.m4401i(c1878p.f6890r, ""));
            c1878p.m4400h(c1878p.f6890r, 1);
            c1878p.f6890r = null;
            TextInputLayout textInputLayout = c1878p.f6874b;
            textInputLayout.m4367p();
            textInputLayout.m4376y();
        }
        c1878p.f6889q = z7;
    }

    public void setHelperTextTextAppearance(int i6) {
        C1878p c1878p = this.f6790k;
        c1878p.f6891s = i6;
        AppCompatTextView appCompatTextView = c1878p.f6890r;
        if (appCompatTextView != null) {
            AbstractC3198d.m6443R(appCompatTextView, i6);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.f6743C) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z7) {
        this.f6750F0 = z7;
    }

    public void setHintEnabled(boolean z7) {
        if (z7 != this.f6743C) {
            this.f6743C = z7;
            if (z7) {
                CharSequence hint = this.f6778e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f6745D)) {
                        setHint(hint);
                    }
                    this.f6778e.setHint((CharSequence) null);
                }
                this.f6747E = true;
            } else {
                this.f6747E = false;
                if (!TextUtils.isEmpty(this.f6745D) && TextUtils.isEmpty(this.f6778e.getHint())) {
                    this.f6778e.setHint(this.f6745D);
                }
                setHintInternal(null);
            }
            if (this.f6778e != null) {
                m4370s();
            }
        }
    }

    public void setHintTextAppearance(int i6) {
        C1816d c1816d = this.f6746D0;
        c1816d.m4266k(i6);
        this.f6807s0 = c1816d.f6421p;
        if (this.f6778e != null) {
            m4371t(false, false);
            m4370s();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f6807s0 != colorStateList) {
            if (this.f6805r0 == null) {
                this.f6746D0.m4267l(colorStateList);
            }
            this.f6807s0 = colorStateList;
            if (this.f6778e != null) {
                m4371t(false, false);
            }
        }
    }

    public void setMaxEms(int i6) {
        this.f6784h = i6;
        EditText editText = this.f6778e;
        if (editText == null || i6 == -1) {
            return;
        }
        editText.setMaxEms(i6);
    }

    public void setMaxWidth(int i6) {
        this.f6788j = i6;
        EditText editText = this.f6778e;
        if (editText == null || i6 == -1) {
            return;
        }
        editText.setMaxWidth(i6);
    }

    public void setMaxWidthResource(int i6) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i6));
    }

    public void setMinEms(int i6) {
        this.f6782g = i6;
        EditText editText = this.f6778e;
        if (editText == null || i6 == -1) {
            return;
        }
        editText.setMinEms(i6);
    }

    public void setMinWidth(int i6) {
        this.f6786i = i6;
        EditText editText = this.f6778e;
        if (editText == null || i6 == -1) {
            return;
        }
        editText.setMinWidth(i6);
    }

    public void setMinWidthResource(int i6) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i6));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i6) {
        setPasswordVisibilityToggleContentDescription(i6 != 0 ? getResources().getText(i6) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i6) {
        setPasswordVisibilityToggleDrawable(i6 != 0 ? AbstractC1465c.m3473h(getContext(), i6) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z7) {
        if (z7 && this.f6777d0 != 1) {
            setEndIconMode(1);
        } else {
            if (z7) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f6785h0 = colorStateList;
        AbstractC3928d.m7840a(this, this.f6781f0, colorStateList, this.f6787i0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f6787i0 = mode;
        AbstractC3928d.m7840a(this, this.f6781f0, this.f6785h0, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f6808t == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
            this.f6808t = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_placeholder);
            AppCompatTextView appCompatTextView2 = this.f6808t;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            appCompatTextView2.setImportantForAccessibility(2);
            Fade fade = new Fade();
            fade.f3793c = 87L;
            LinearInterpolator linearInterpolator = AbstractC4268a.f14469a;
            fade.f3794d = linearInterpolator;
            this.f6814w = fade;
            fade.f3792b = 67L;
            Fade fade2 = new Fade();
            fade2.f3793c = 87L;
            fade2.f3794d = linearInterpolator;
            this.f6816x = fade2;
            setPlaceholderTextAppearance(this.f6812v);
            setPlaceholderTextColor(this.f6810u);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f6806s) {
                setPlaceholderTextEnabled(true);
            }
            this.f6804r = charSequence;
        }
        EditText editText = this.f6778e;
        m4372u(editText != null ? editText.getText().length() : 0);
    }

    public void setPlaceholderTextAppearance(int i6) {
        this.f6812v = i6;
        AppCompatTextView appCompatTextView = this.f6808t;
        if (appCompatTextView != null) {
            AbstractC3198d.m6443R(appCompatTextView, i6);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f6810u != colorStateList) {
            this.f6810u = colorStateList;
            AppCompatTextView appCompatTextView = this.f6808t;
            if (appCompatTextView == null || colorStateList == null) {
                return;
            }
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        C1880r c1880r = this.f6772b;
        c1880r.getClass();
        c1880r.f6899c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        c1880r.f6898b.setText(charSequence);
        c1880r.m4407d();
    }

    public void setPrefixTextAppearance(int i6) {
        AbstractC3198d.m6443R(this.f6772b.f6898b, i6);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f6772b.f6898b.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z7) {
        this.f6772b.f6900d.setCheckable(z7);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f6772b.f6900d;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i6) {
        setStartIconDrawable(i6 != 0 ? AbstractC1465c.m3473h(getContext(), i6) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        C1880r c1880r = this.f6772b;
        View.OnLongClickListener onLongClickListener = c1880r.f6903g;
        CheckableImageButton checkableImageButton = c1880r.f6900d;
        checkableImageButton.setOnClickListener(onClickListener);
        AbstractC3928d.m7860y(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        C1880r c1880r = this.f6772b;
        c1880r.f6903g = onLongClickListener;
        CheckableImageButton checkableImageButton = c1880r.f6900d;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        AbstractC3928d.m7860y(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        C1880r c1880r = this.f6772b;
        if (c1880r.f6901e != colorStateList) {
            c1880r.f6901e = colorStateList;
            AbstractC3928d.m7840a(c1880r.f6897a, c1880r.f6900d, colorStateList, c1880r.f6902f);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        C1880r c1880r = this.f6772b;
        if (c1880r.f6902f != mode) {
            c1880r.f6902f = mode;
            AbstractC3928d.m7840a(c1880r.f6897a, c1880r.f6900d, c1880r.f6901e, mode);
        }
    }

    public void setStartIconVisible(boolean z7) {
        this.f6772b.m4405b(z7);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f6739A = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f6741B.setText(charSequence);
        m4375x();
    }

    public void setSuffixTextAppearance(int i6) {
        AbstractC3198d.m6443R(this.f6741B, i6);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f6741B.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(C1882t c1882t) {
        EditText editText = this.f6778e;
        if (editText != null) {
            AbstractC3155s0.m6347q(editText, c1882t);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f6769V) {
            this.f6769V = typeface;
            C1816d c1816d = this.f6746D0;
            boolean zM4269n = c1816d.m4269n(typeface);
            boolean zM4271p = c1816d.m4271p(typeface);
            if (zM4269n || zM4271p) {
                c1816d.m4265j(false);
            }
            C1878p c1878p = this.f6790k;
            if (typeface != c1878p.f6893u) {
                c1878p.f6893u = typeface;
                AppCompatTextView appCompatTextView = c1878p.f6884l;
                if (appCompatTextView != null) {
                    appCompatTextView.setTypeface(typeface);
                }
                AppCompatTextView appCompatTextView2 = c1878p.f6890r;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTypeface(typeface);
                }
            }
            AppCompatTextView appCompatTextView3 = this.f6798o;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTypeface(typeface);
            }
        }
    }

    public final void m4371t(boolean z7, boolean z10) {
        ColorStateList colorStateList;
        AppCompatTextView appCompatTextView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f6778e;
        boolean z11 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f6778e;
        boolean z12 = editText2 != null && editText2.hasFocus();
        C1878p c1878p = this.f6790k;
        boolean zM4397e = c1878p.m4397e();
        ColorStateList colorStateList2 = this.f6805r0;
        C1816d c1816d = this.f6746D0;
        if (colorStateList2 != null) {
            c1816d.m4267l(colorStateList2);
            ColorStateList colorStateList3 = this.f6805r0;
            if (c1816d.f6419o != colorStateList3) {
                c1816d.f6419o = colorStateList3;
                c1816d.m4265j(false);
            }
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList4 = this.f6805r0;
            int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(new int[]{-16842910}, this.f6742B0) : this.f6742B0;
            c1816d.m4267l(ColorStateList.valueOf(colorForState));
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(colorForState);
            if (c1816d.f6419o != colorStateListValueOf) {
                c1816d.f6419o = colorStateListValueOf;
                c1816d.m4265j(false);
            }
        } else if (zM4397e) {
            AppCompatTextView appCompatTextView2 = c1878p.f6884l;
            c1816d.m4267l(appCompatTextView2 != null ? appCompatTextView2.getTextColors() : null);
        } else if (this.f6796n && (appCompatTextView = this.f6798o) != null) {
            c1816d.m4267l(appCompatTextView.getTextColors());
        } else if (z12 && (colorStateList = this.f6807s0) != null) {
            c1816d.m4267l(colorStateList);
        }
        C1880r c1880r = this.f6772b;
        if (z11 || !this.f6748E0 || (isEnabled() && z12)) {
            if (z10 || this.f6744C0) {
                ValueAnimator valueAnimator = this.f6752G0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f6752G0.cancel();
                }
                if (z7 && this.f6750F0) {
                    m4354a(1.0f);
                } else {
                    c1816d.m4272q(1.0f);
                }
                this.f6744C0 = false;
                if (m4357d()) {
                    m4362i();
                }
                EditText editText3 = this.f6778e;
                m4372u(editText3 == null ? 0 : editText3.getText().length());
                c1880r.f6904h = false;
                c1880r.m4407d();
                m4375x();
                return;
            }
            return;
        }
        if (z10 || !this.f6744C0) {
            ValueAnimator valueAnimator2 = this.f6752G0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f6752G0.cancel();
            }
            if (z7 && this.f6750F0) {
                m4354a(0.0f);
            } else {
                c1816d.m4272q(0.0f);
            }
            if (m4357d() && !((C1869g) this.f6749F).f6842x.isEmpty() && m4357d()) {
                ((C1869g) this.f6749F).m4383w(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.f6744C0 = true;
            AppCompatTextView appCompatTextView3 = this.f6808t;
            if (appCompatTextView3 != null && this.f6806s) {
                appCompatTextView3.setText((CharSequence) null);
                AbstractC4200b0.m8249a(this.f6771a, this.f6816x);
                this.f6808t.setVisibility(4);
            }
            c1880r.f6904h = true;
            c1880r.m4407d();
            m4375x();
        }
    }

    public final void m4372u(int i6) {
        FrameLayout frameLayout = this.f6771a;
        if (i6 != 0 || this.f6744C0) {
            AppCompatTextView appCompatTextView = this.f6808t;
            if (appCompatTextView == null || !this.f6806s) {
                return;
            }
            appCompatTextView.setText((CharSequence) null);
            AbstractC4200b0.m8249a(frameLayout, this.f6816x);
            this.f6808t.setVisibility(4);
            return;
        }
        if (this.f6808t == null || !this.f6806s || TextUtils.isEmpty(this.f6804r)) {
            return;
        }
        this.f6808t.setText(this.f6804r);
        AbstractC4200b0.m8249a(frameLayout, this.f6814w);
        this.f6808t.setVisibility(0);
        this.f6808t.bringToFront();
        announceForAccessibility(this.f6804r);
    }

    public final void m4373v(boolean z7, boolean z10) {
        int defaultColor = this.f6815w0.getDefaultColor();
        int colorForState = this.f6815w0.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f6815w0.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, defaultColor);
        if (z7) {
            this.f6764Q = colorForState2;
        } else if (z10) {
            this.f6764Q = colorForState;
        } else {
            this.f6764Q = defaultColor;
        }
    }

    public final void m4374w() {
        int paddingEnd;
        if (this.f6778e == null) {
            return;
        }
        if (m4360g() || this.f6799o0.getVisibility() == 0) {
            paddingEnd = 0;
        } else {
            EditText editText = this.f6778e;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            paddingEnd = editText.getPaddingEnd();
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int paddingTop = this.f6778e.getPaddingTop();
        int paddingBottom = this.f6778e.getPaddingBottom();
        WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
        this.f6741B.setPaddingRelative(dimensionPixelSize, paddingTop, paddingEnd, paddingBottom);
    }

    public final void m4375x() {
        AppCompatTextView appCompatTextView = this.f6741B;
        int visibility = appCompatTextView.getVisibility();
        int i6 = (this.f6739A == null || this.f6744C0) ? 8 : 0;
        if (visibility != i6) {
            getEndIconDelegate().mo4380c(i6 == 0);
        }
        m4368q();
        appCompatTextView.setVisibility(i6);
        m4366o();
    }

    public final void m4376y() {
        AppCompatTextView appCompatTextView;
        EditText editText;
        EditText editText2;
        if (this.f6749F == null || this.f6759L == 0) {
            return;
        }
        boolean z7 = false;
        boolean z10 = isFocused() || ((editText2 = this.f6778e) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f6778e) != null && editText.isHovered())) {
            z7 = true;
        }
        boolean zIsEnabled = isEnabled();
        C1878p c1878p = this.f6790k;
        if (!zIsEnabled) {
            this.f6764Q = this.f6742B0;
        } else if (c1878p.m4397e()) {
            if (this.f6815w0 != null) {
                m4373v(z10, z7);
            } else {
                AppCompatTextView appCompatTextView2 = c1878p.f6884l;
                this.f6764Q = appCompatTextView2 != null ? appCompatTextView2.getCurrentTextColor() : -1;
            }
        } else if (!this.f6796n || (appCompatTextView = this.f6798o) == null) {
            if (z10) {
                this.f6764Q = this.f6813v0;
            } else if (z7) {
                this.f6764Q = this.f6811u0;
            } else {
                this.f6764Q = this.f6809t0;
            }
        } else if (this.f6815w0 != null) {
            m4373v(z10, z7);
        } else {
            this.f6764Q = appCompatTextView.getCurrentTextColor();
        }
        m4369r();
        AbstractC3928d.m7859x(this, this.f6799o0, this.f6801p0);
        C1880r c1880r = this.f6772b;
        AbstractC3928d.m7859x(c1880r.f6897a, c1880r.f6900d, c1880r.f6901e);
        ColorStateList colorStateList = this.f6785h0;
        CheckableImageButton checkableImageButton = this.f6781f0;
        AbstractC3928d.m7859x(this, checkableImageButton, colorStateList);
        AbstractC1876n endIconDelegate = getEndIconDelegate();
        endIconDelegate.getClass();
        if (endIconDelegate instanceof C1875m) {
            if (!c1878p.m4397e() || getEndIconDrawable() == null) {
                AbstractC3928d.m7840a(this, checkableImageButton, this.f6785h0, this.f6787i0);
            } else {
                Drawable drawableMutate = AbstractC3198d.m6448W(getEndIconDrawable()).mutate();
                AppCompatTextView appCompatTextView3 = c1878p.f6884l;
                AbstractC2581a.m5585g(drawableMutate, appCompatTextView3 != null ? appCompatTextView3.getCurrentTextColor() : -1);
                checkableImageButton.setImageDrawable(drawableMutate);
            }
        }
        if (this.f6759L == 2) {
            int i6 = this.f6761N;
            if (z10 && isEnabled()) {
                this.f6761N = this.f6763P;
            } else {
                this.f6761N = this.f6762O;
            }
            if (this.f6761N != i6 && m4357d() && !this.f6744C0) {
                if (m4357d()) {
                    ((C1869g) this.f6749F).m4383w(0.0f, 0.0f, 0.0f, 0.0f);
                }
                m4362i();
            }
        }
        if (this.f6759L == 1) {
            if (!isEnabled()) {
                this.f6765R = this.f6819y0;
            } else if (z7 && !z10) {
                this.f6765R = this.f6740A0;
            } else if (z10) {
                this.f6765R = this.f6821z0;
            } else {
                this.f6765R = this.f6817x0;
            }
        }
        m4355b();
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i6) {
        int i10;
        ?? r10;
        super(AbstractC4275a.m8323a(context, attributeSet, i6, R.style.Widget_Design_TextInputLayout), attributeSet, i6);
        this.f6782g = -1;
        this.f6784h = -1;
        this.f6786i = -1;
        this.f6788j = -1;
        this.f6790k = new C1878p(this);
        this.f6766S = new Rect();
        this.f6767T = new Rect();
        this.f6768U = new RectF();
        this.f6775c0 = new LinkedHashSet();
        this.f6777d0 = 0;
        SparseArray sparseArray = new SparseArray();
        this.f6779e0 = sparseArray;
        this.f6783g0 = new LinkedHashSet();
        C1816d c1816d = new C1816d(this);
        this.f6746D0 = c1816d;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f6771a = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f6776d = frameLayout2;
        LinearLayout linearLayout = new LinearLayout(context2);
        this.f6774c = linearLayout;
        AppCompatTextView appCompatTextView = new AppCompatTextView(context2, null);
        this.f6741B = appCompatTextView;
        linearLayout.setVisibility(8);
        frameLayout2.setVisibility(8);
        appCompatTextView.setVisibility(8);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context2);
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflaterFrom.inflate(R.layout.design_text_input_end_icon, (ViewGroup) linearLayout, false);
        this.f6799o0 = checkableImageButton;
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) layoutInflaterFrom.inflate(R.layout.design_text_input_end_icon, (ViewGroup) frameLayout2, false);
        this.f6781f0 = checkableImageButton2;
        frameLayout.setAddStatesFromChildren(true);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        LinearInterpolator linearInterpolator = AbstractC4268a.f14469a;
        c1816d.f6387W = linearInterpolator;
        c1816d.m4265j(false);
        c1816d.f6386V = linearInterpolator;
        c1816d.m4265j(false);
        c1816d.m4268m(8388659);
        C0026b c0026bM4251k = AbstractC1811a0.m4251k(context2, attributeSet, AbstractC4121a.f13986b0, i6, R.style.Widget_Design_TextInputLayout, 22, 20, 35, 40, 44);
        C1880r c1880r = new C1880r(this, c0026bM4251k);
        this.f6772b = c1880r;
        TypedArray typedArray = (TypedArray) c0026bM4251k.f55c;
        this.f6743C = typedArray.getBoolean(43, true);
        setHint(typedArray.getText(4));
        this.f6750F0 = typedArray.getBoolean(42, true);
        this.f6748E0 = typedArray.getBoolean(37, true);
        if (typedArray.hasValue(6)) {
            i10 = -1;
            setMinEms(typedArray.getInt(6, -1));
        } else {
            i10 = -1;
            if (typedArray.hasValue(3)) {
                setMinWidth(typedArray.getDimensionPixelSize(3, -1));
            }
        }
        if (typedArray.hasValue(5)) {
            setMaxEms(typedArray.getInt(5, i10));
        } else if (typedArray.hasValue(2)) {
            setMaxWidth(typedArray.getDimensionPixelSize(2, i10));
        }
        this.f6755I = C3913m.m7822b(context2, attributeSet, i6, R.style.Widget_Design_TextInputLayout).m7819a();
        this.f6758K = context2.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.f6760M = typedArray.getDimensionPixelOffset(9, 0);
        this.f6762O = typedArray.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.f6763P = typedArray.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.f6761N = this.f6762O;
        float dimension = typedArray.getDimension(13, -1.0f);
        float dimension2 = typedArray.getDimension(12, -1.0f);
        float dimension3 = typedArray.getDimension(10, -1.0f);
        float dimension4 = typedArray.getDimension(11, -1.0f);
        C3912l c3912lM7826f = this.f6755I.m7826f();
        if (dimension >= 0.0f) {
            c3912lM7826f.f13155e = new C3901a(dimension);
        }
        if (dimension2 >= 0.0f) {
            c3912lM7826f.f13156f = new C3901a(dimension2);
        }
        if (dimension3 >= 0.0f) {
            c3912lM7826f.f13157g = new C3901a(dimension3);
        }
        if (dimension4 >= 0.0f) {
            c3912lM7826f.f13158h = new C3901a(dimension4);
        }
        this.f6755I = c3912lM7826f.m7819a();
        ColorStateList colorStateListM3492j = AbstractC1466d.m3492j(context2, c0026bM4251k, 7);
        if (colorStateListM3492j != null) {
            int defaultColor = colorStateListM3492j.getDefaultColor();
            this.f6817x0 = defaultColor;
            this.f6765R = defaultColor;
            if (colorStateListM3492j.isStateful()) {
                this.f6819y0 = colorStateListM3492j.getColorForState(new int[]{-16842910}, -1);
                this.f6821z0 = colorStateListM3492j.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
                this.f6740A0 = colorStateListM3492j.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            } else {
                this.f6821z0 = this.f6817x0;
                ColorStateList colorStateListM7848k = AbstractC3928d.m7848k(context2, R.color.mtrl_filled_background_color);
                this.f6819y0 = colorStateListM7848k.getColorForState(new int[]{-16842910}, -1);
                this.f6740A0 = colorStateListM7848k.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
            }
        } else {
            this.f6765R = 0;
            this.f6817x0 = 0;
            this.f6819y0 = 0;
            this.f6821z0 = 0;
            this.f6740A0 = 0;
        }
        if (typedArray.hasValue(1)) {
            ColorStateList colorStateListM139s = c0026bM4251k.m139s(1);
            this.f6807s0 = colorStateListM139s;
            this.f6805r0 = colorStateListM139s;
        }
        ColorStateList colorStateListM3492j2 = AbstractC1466d.m3492j(context2, c0026bM4251k, 14);
        this.f6813v0 = typedArray.getColor(14, 0);
        this.f6809t0 = AbstractC3928d.m7847i(context2, R.color.mtrl_textinput_default_box_stroke_color);
        this.f6742B0 = AbstractC3928d.m7847i(context2, R.color.mtrl_textinput_disabled_color);
        this.f6811u0 = AbstractC3928d.m7847i(context2, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListM3492j2 != null) {
            setBoxStrokeColorStateList(colorStateListM3492j2);
        }
        if (typedArray.hasValue(15)) {
            setBoxStrokeErrorColor(AbstractC1466d.m3492j(context2, c0026bM4251k, 15));
        }
        if (typedArray.getResourceId(44, -1) != -1) {
            r10 = 0;
            setHintTextAppearance(typedArray.getResourceId(44, 0));
        } else {
            r10 = 0;
        }
        int resourceId = typedArray.getResourceId(35, r10);
        CharSequence text = typedArray.getText(30);
        boolean z7 = typedArray.getBoolean(31, r10);
        checkableImageButton.setId(R.id.text_input_error_icon);
        if (AbstractC1466d.m3501u(context2)) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(r10);
        }
        if (typedArray.hasValue(33)) {
            this.f6801p0 = AbstractC1466d.m3492j(context2, c0026bM4251k, 33);
        }
        if (typedArray.hasValue(34)) {
            this.f6803q0 = AbstractC1811a0.m4252l(typedArray.getInt(34, -1), null);
        }
        if (typedArray.hasValue(32)) {
            setErrorIconDrawable(c0026bM4251k.m140t(32));
        }
        checkableImageButton.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        checkableImageButton.setImportantForAccessibility(2);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int resourceId2 = typedArray.getResourceId(40, 0);
        boolean z10 = typedArray.getBoolean(39, false);
        CharSequence text2 = typedArray.getText(38);
        int resourceId3 = typedArray.getResourceId(52, 0);
        CharSequence text3 = typedArray.getText(51);
        int resourceId4 = typedArray.getResourceId(65, 0);
        CharSequence text4 = typedArray.getText(64);
        boolean z11 = typedArray.getBoolean(18, false);
        setCounterMaxLength(typedArray.getInt(19, -1));
        this.f6802q = typedArray.getResourceId(22, 0);
        this.f6800p = typedArray.getResourceId(20, 0);
        setBoxBackgroundMode(typedArray.getInt(8, 0));
        if (AbstractC1466d.m3501u(context2)) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams()).setMarginStart(0);
        }
        int resourceId5 = typedArray.getResourceId(26, 0);
        sparseArray.append(-1, new C1868f(this, resourceId5, 0));
        sparseArray.append(0, new C1868f(this, 0, 1));
        sparseArray.append(1, new C1879q(this, resourceId5 == 0 ? typedArray.getResourceId(47, 0) : resourceId5));
        sparseArray.append(2, new C1867e(this, resourceId5));
        sparseArray.append(3, new C1875m(this, resourceId5));
        if (!typedArray.hasValue(48)) {
            if (typedArray.hasValue(28)) {
                this.f6785h0 = AbstractC1466d.m3492j(context2, c0026bM4251k, 28);
            }
            if (typedArray.hasValue(29)) {
                this.f6787i0 = AbstractC1811a0.m4252l(typedArray.getInt(29, -1), null);
            }
        }
        if (typedArray.hasValue(27)) {
            setEndIconMode(typedArray.getInt(27, 0));
            if (typedArray.hasValue(25)) {
                setEndIconContentDescription(typedArray.getText(25));
            }
            setEndIconCheckable(typedArray.getBoolean(24, true));
        } else if (typedArray.hasValue(48)) {
            if (typedArray.hasValue(49)) {
                this.f6785h0 = AbstractC1466d.m3492j(context2, c0026bM4251k, 49);
            }
            if (typedArray.hasValue(50)) {
                this.f6787i0 = AbstractC1811a0.m4252l(typedArray.getInt(50, -1), null);
            }
            setEndIconMode(typedArray.getBoolean(48, false) ? 1 : 0);
            setEndIconContentDescription(typedArray.getText(46));
        }
        appCompatTextView.setId(R.id.textinput_suffix_text);
        appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        appCompatTextView.setAccessibilityLiveRegion(1);
        setErrorContentDescription(text);
        setCounterOverflowTextAppearance(this.f6800p);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.f6802q);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        setSuffixTextAppearance(resourceId4);
        if (typedArray.hasValue(36)) {
            setErrorTextColor(c0026bM4251k.m139s(36));
        }
        if (typedArray.hasValue(41)) {
            setHelperTextColor(c0026bM4251k.m139s(41));
        }
        if (typedArray.hasValue(45)) {
            setHintTextColor(c0026bM4251k.m139s(45));
        }
        if (typedArray.hasValue(23)) {
            setCounterTextColor(c0026bM4251k.m139s(23));
        }
        if (typedArray.hasValue(21)) {
            setCounterOverflowTextColor(c0026bM4251k.m139s(21));
        }
        if (typedArray.hasValue(53)) {
            setPlaceholderTextColor(c0026bM4251k.m139s(53));
        }
        if (typedArray.hasValue(66)) {
            setSuffixTextColor(c0026bM4251k.m139s(66));
        }
        setEnabled(typedArray.getBoolean(0, true));
        c0026bM4251k.m120F();
        setImportantForAccessibility(2);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26 && i11 >= 26) {
            AbstractC3128j0.m6218m(this, 1);
        }
        frameLayout2.addView(checkableImageButton2);
        linearLayout.addView(appCompatTextView);
        linearLayout.addView(checkableImageButton);
        linearLayout.addView(frameLayout2);
        frameLayout.addView(c1880r);
        frameLayout.addView(linearLayout);
        addView(frameLayout);
        setHelperTextEnabled(z10);
        setErrorEnabled(z7);
        setCounterEnabled(z11);
        setHelperText(text2);
        setSuffixText(text4);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f6781f0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f6781f0;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            AbstractC3928d.m7840a(this, checkableImageButton, this.f6785h0, this.f6787i0);
            AbstractC3928d.m7859x(this, checkableImageButton, this.f6785h0);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f6772b.m4404a(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f6799o0;
        checkableImageButton.setImageDrawable(drawable);
        m4369r();
        AbstractC3928d.m7840a(this, checkableImageButton, this.f6801p0, this.f6803q0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f6781f0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f6781f0.setImageDrawable(drawable);
    }

    public void setHint(int i6) {
        setHint(i6 != 0 ? getResources().getText(i6) : null);
    }

    public void setStartIconContentDescription(int i6) {
        setStartIconContentDescription(i6 != 0 ? getResources().getText(i6) : null);
    }
}
