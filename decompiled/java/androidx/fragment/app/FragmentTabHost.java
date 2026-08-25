package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;
import p000a.AbstractC0004e;

@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    public final ArrayList f1797a;

    public TabHost.OnTabChangeListener f1798b;

    public boolean f1799c;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0424q0();

        public String f1800a;

        public final String toString() {
            StringBuilder sb = new StringBuilder("FragmentTabHost.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" curTab=");
            return AbstractC0004e.m26t(sb, this.f1800a, "}");
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeString(this.f1800a);
        }
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1797a = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getCurrentTabTag();
        ArrayList arrayList = this.f1797a;
        if (arrayList.size() > 0) {
            throw AbstractC0004e.m17k(0, arrayList);
        }
        this.f1799c = true;
        if (arrayList.size() > 0) {
            throw AbstractC0004e.m17k(0, arrayList);
        }
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1799c = false;
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f1800a);
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1800a = getCurrentTabTag();
        return savedState;
    }

    @Override
    public final void onTabChanged(String str) {
        if (this.f1799c) {
            ArrayList arrayList = this.f1797a;
            if (arrayList.size() > 0) {
                throw AbstractC0004e.m17k(0, arrayList);
            }
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f1798b;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override
    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f1798b = onTabChangeListener;
    }

    @Override
    public final void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
}
