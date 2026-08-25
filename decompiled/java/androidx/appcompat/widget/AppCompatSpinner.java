package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.AbstractC0107a;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.bumptech.glide.AbstractC1465c;
import p002a1.C0026b;
import p045e.AbstractC2341a;
import p093j.C2743d;

public class AppCompatSpinner extends Spinner {

    public static final int[] f642i = {R.attr.spinnerMode};

    public final C0275u f643a;

    public final Context f644b;

    public final C0196e0 f645c;

    public SpinnerAdapter f646d;

    public final boolean f647e;

    public final InterfaceC0246o0 f648f;

    public int f649g;

    public final Rect f650h;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0241n0();

        public boolean f651a;

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeByte(this.f651a ? (byte) 1 : (byte) 0);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.spinnerStyle);
    }

    public final int m569a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i6 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i6) {
                view = null;
                i6 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        Rect rect = this.f650h;
        drawable.getPadding(rect);
        return iMax2 + rect.left + rect.right;
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0275u c0275u = this.f643a;
        if (c0275u != null) {
            c0275u.m773a();
        }
    }

    @Override
    public int getDropDownHorizontalOffset() {
        InterfaceC0246o0 interfaceC0246o0 = this.f648f;
        return interfaceC0246o0 != null ? interfaceC0246o0.mo690e() : super.getDropDownHorizontalOffset();
    }

    @Override
    public int getDropDownVerticalOffset() {
        InterfaceC0246o0 interfaceC0246o0 = this.f648f;
        return interfaceC0246o0 != null ? interfaceC0246o0.mo698o() : super.getDropDownVerticalOffset();
    }

    @Override
    public int getDropDownWidth() {
        return this.f648f != null ? this.f649g : super.getDropDownWidth();
    }

    public final InterfaceC0246o0 getInternalPopup() {
        return this.f648f;
    }

    @Override
    public Drawable getPopupBackground() {
        InterfaceC0246o0 interfaceC0246o0 = this.f648f;
        return interfaceC0246o0 != null ? interfaceC0246o0.mo691f() : super.getPopupBackground();
    }

    @Override
    public Context getPopupContext() {
        return this.f644b;
    }

    @Override
    public CharSequence getPrompt() {
        InterfaceC0246o0 interfaceC0246o0 = this.f648f;
        return interfaceC0246o0 != null ? interfaceC0246o0.mo699p() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0275u c0275u = this.f643a;
        if (c0275u != null) {
            return c0275u.m774c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0275u c0275u = this.f643a;
        if (c0275u != null) {
            return c0275u.m775d();
        }
        return null;
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC0246o0 interfaceC0246o0 = this.f648f;
        if (interfaceC0246o0 == null || !interfaceC0246o0.mo689c()) {
            return;
        }
        interfaceC0246o0.dismiss();
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        if (this.f648f == null || View.MeasureSpec.getMode(i6) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m569a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i6)), getMeasuredHeight());
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.f651a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0255q(1, this));
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        InterfaceC0246o0 interfaceC0246o0 = this.f648f;
        savedState.f651a = interfaceC0246o0 != null && interfaceC0246o0.mo689c();
        return savedState;
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0196e0 c0196e0 = this.f645c;
        if (c0196e0 == null || !c0196e0.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override
    public final boolean performClick() {
        InterfaceC0246o0 interfaceC0246o0 = this.f648f;
        if (interfaceC0246o0 == null) {
            return super.performClick();
        }
        if (interfaceC0246o0.mo689c()) {
            return true;
        }
        this.f648f.mo697n(AbstractC0206g0.m671b(this), AbstractC0206g0.m670a(this));
        return true;
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0275u c0275u = this.f643a;
        if (c0275u != null) {
            c0275u.m777f();
        }
    }

    @Override
    public void setBackgroundResource(int i6) {
        super.setBackgroundResource(i6);
        C0275u c0275u = this.f643a;
        if (c0275u != null) {
            c0275u.m778g(i6);
        }
    }

    @Override
    public void setDropDownHorizontalOffset(int i6) {
        InterfaceC0246o0 interfaceC0246o0 = this.f648f;
        if (interfaceC0246o0 == null) {
            super.setDropDownHorizontalOffset(i6);
        } else {
            interfaceC0246o0.mo695l(i6);
            interfaceC0246o0.mo696m(i6);
        }
    }

    @Override
    public void setDropDownVerticalOffset(int i6) {
        InterfaceC0246o0 interfaceC0246o0 = this.f648f;
        if (interfaceC0246o0 != null) {
            interfaceC0246o0.mo694j(i6);
        } else {
            super.setDropDownVerticalOffset(i6);
        }
    }

    @Override
    public void setDropDownWidth(int i6) {
        if (this.f648f != null) {
            this.f649g = i6;
        } else {
            super.setDropDownWidth(i6);
        }
    }

    @Override
    public void setPopupBackgroundDrawable(Drawable drawable) {
        InterfaceC0246o0 interfaceC0246o0 = this.f648f;
        if (interfaceC0246o0 != null) {
            interfaceC0246o0.mo693i(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override
    public void setPopupBackgroundResource(int i6) {
        setPopupBackgroundDrawable(AbstractC1465c.m3473h(getPopupContext(), i6));
    }

    @Override
    public void setPrompt(CharSequence charSequence) {
        InterfaceC0246o0 interfaceC0246o0 = this.f648f;
        if (interfaceC0246o0 != null) {
            interfaceC0246o0.mo692g(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0275u c0275u = this.f643a;
        if (c0275u != null) {
            c0275u.m780i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0275u c0275u = this.f643a;
        if (c0275u != null) {
            c0275u.m781j(mode);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i6) throws Throwable {
        TypedArray typedArrayObtainStyledAttributes;
        CharSequence[] textArray;
        SpinnerAdapter spinnerAdapter;
        super(context, attributeSet, i6);
        this.f650h = new Rect();
        AbstractC0224j3.m702a(this, getContext());
        int[] iArr = AbstractC2341a.f8175w;
        C0026b c0026bM111C = C0026b.m111C(context, attributeSet, iArr, i6);
        this.f643a = new C0275u(this);
        TypedArray typedArray = (TypedArray) c0026bM111C.f55c;
        int resourceId = typedArray.getResourceId(4, 0);
        if (resourceId != 0) {
            this.f644b = new C2743d(context, resourceId);
        } else {
            this.f644b = context;
        }
        int i10 = -1;
        TypedArray typedArray2 = null;
        try {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f642i, i6, 0);
            try {
                try {
                    if (typedArrayObtainStyledAttributes.hasValue(0)) {
                        i10 = typedArrayObtainStyledAttributes.getInt(0, 0);
                    }
                } catch (Exception e5) {
                    e = e5;
                    Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                    if (typedArrayObtainStyledAttributes != null) {
                    }
                    if (i10 != 0) {
                        DialogInterfaceOnClickListenerC0216i0 dialogInterfaceOnClickListenerC0216i0 = new DialogInterfaceOnClickListenerC0216i0(this);
                        this.f648f = dialogInterfaceOnClickListenerC0216i0;
                        dialogInterfaceOnClickListenerC0216i0.f946c = typedArray.getString(2);
                    } else if (i10 == 1) {
                        C0236m0 c0236m0 = new C0236m0(this, this.f644b, attributeSet, i6);
                        C0026b c0026bM111C2 = C0026b.m111C(this.f644b, attributeSet, iArr, i6);
                        this.f649g = ((TypedArray) c0026bM111C2.f55c).getLayoutDimension(3, -2);
                        c0236m0.m582i(c0026bM111C2.m140t(1));
                        c0236m0.f1003C = typedArray.getString(2);
                        c0026bM111C2.m120F();
                        this.f648f = c0236m0;
                        this.f645c = new C0196e0(this, this, c0236m0);
                    }
                    textArray = typedArray.getTextArray(0);
                    if (textArray != null) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, textArray);
                        arrayAdapter.setDropDownViewResource(com.p2serv.android.p032ds.R.layout.support_simple_spinner_dropdown_item);
                        setAdapter((SpinnerAdapter) arrayAdapter);
                    }
                    c0026bM111C.m120F();
                    this.f647e = true;
                    spinnerAdapter = this.f646d;
                    if (spinnerAdapter != null) {
                        setAdapter(spinnerAdapter);
                        this.f646d = null;
                    }
                    this.f643a.m776e(attributeSet, i6);
                }
            } catch (Throwable th) {
                th = th;
                typedArray2 = typedArrayObtainStyledAttributes;
                if (typedArray2 != null) {
                    typedArray2.recycle();
                }
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            typedArrayObtainStyledAttributes = null;
        } catch (Throwable th2) {
            th = th2;
            if (typedArray2 != null) {
                typedArray2.recycle();
            }
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (i10 != 0) {
            DialogInterfaceOnClickListenerC0216i0 dialogInterfaceOnClickListenerC0216i1 = new DialogInterfaceOnClickListenerC0216i0(this);
            this.f648f = dialogInterfaceOnClickListenerC0216i1;
            dialogInterfaceOnClickListenerC0216i1.f946c = typedArray.getString(2);
        } else if (i10 == 1) {
            C0236m0 c0236m1 = new C0236m0(this, this.f644b, attributeSet, i6);
            C0026b c0026bM111C3 = C0026b.m111C(this.f644b, attributeSet, iArr, i6);
            this.f649g = ((TypedArray) c0026bM111C3.f55c).getLayoutDimension(3, -2);
            c0236m1.m582i(c0026bM111C3.m140t(1));
            c0236m1.f1003C = typedArray.getString(2);
            c0026bM111C3.m120F();
            this.f648f = c0236m1;
            this.f645c = new C0196e0(this, this, c0236m1);
        }
        textArray = typedArray.getTextArray(0);
        if (textArray != null) {
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(context, R.layout.simple_spinner_item, textArray);
            arrayAdapter2.setDropDownViewResource(com.p2serv.android.p032ds.R.layout.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter2);
        }
        c0026bM111C.m120F();
        this.f647e = true;
        spinnerAdapter = this.f646d;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.f646d = null;
        }
        this.f643a.m776e(attributeSet, i6);
    }

    @Override
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f647e) {
            this.f646d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        InterfaceC0246o0 interfaceC0246o0 = this.f648f;
        if (interfaceC0246o0 != null) {
            Context context = this.f644b;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            C0221j0 c0221j0 = new C0221j0();
            c0221j0.f952a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                c0221j0.f953b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && Build.VERSION.SDK_INT >= 23 && AbstractC0107a.m285x(spinnerAdapter)) {
                AbstractC0211h0.m687a(AbstractC0107a.m273l(spinnerAdapter), theme);
            }
            interfaceC0246o0.mo586q(c0221j0);
        }
    }
}
