package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.customview.view.AbsSavedState;
import p015b2.C1256h;
import p138n0.AbstractC3155s0;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    public static final int[] f6318g = {R.attr.state_checked};

    public boolean f6319d;

    public boolean f6320e;

    public boolean f6321f;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1812b();

        public boolean f6322c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6322c = parcel.readInt() == 1;
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f6322c ? 1 : 0);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.imageButtonStyle);
    }

    @Override
    public final boolean isChecked() {
        return this.f6319d;
    }

    @Override
    public final int[] onCreateDrawableState(int i6) {
        return this.f6319d ? View.mergeDrawableStates(super.onCreateDrawableState(i6 + 1), f6318g) : super.onCreateDrawableState(i6);
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1689a);
        setChecked(savedState.f6322c);
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f6322c = this.f6319d;
        return savedState;
    }

    public void setCheckable(boolean z7) {
        if (this.f6320e != z7) {
            this.f6320e = z7;
            sendAccessibilityEvent(0);
        }
    }

    @Override
    public void setChecked(boolean z7) {
        if (!this.f6320e || this.f6319d == z7) {
            return;
        }
        this.f6319d = z7;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z7) {
        this.f6321f = z7;
    }

    @Override
    public void setPressed(boolean z7) {
        if (this.f6321f) {
            super.setPressed(z7);
        }
    }

    @Override
    public final void toggle() {
        setChecked(!this.f6319d);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f6320e = true;
        this.f6321f = true;
        AbstractC3155s0.m6347q(this, new C1256h(3, this));
    }
}
