package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;

class PersistentFocusWrapper extends FrameLayout {

    public int f2205a;

    public final boolean f2206b;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0475j0();

        public int f2207a;

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f2207a);
        }
    }

    public PersistentFocusWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2205a = -1;
        this.f2206b = true;
    }

    @Override
    public final void addFocusables(ArrayList arrayList, int i6, int i10) {
        boolean z7;
        if (!hasFocus()) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(0);
            if ((viewGroup != null ? viewGroup.getChildCount() : 0) != 0 && (((z7 = this.f2206b) && (i6 == 33 || i6 == 130)) || (!z7 && (i6 == 17 || i6 == 66)))) {
                arrayList.add(this);
                return;
            }
        }
        super.addFocusables(arrayList, i6, i10);
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f2205a = savedState.f2207a;
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2207a = this.f2205a;
        return savedState;
    }

    @Override
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        while (view2 != null && view2.getParent() != view) {
            view2 = (View) view2.getParent();
        }
        this.f2205a = view2 == null ? -1 : ((ViewGroup) view).indexOfChild(view2);
    }

    @Override
    public final boolean requestFocus(int i6, Rect rect) {
        int i10;
        ViewGroup viewGroup = (ViewGroup) getChildAt(0);
        if (viewGroup != null && (i10 = this.f2205a) >= 0) {
            ViewGroup viewGroup2 = (ViewGroup) getChildAt(0);
            if (i10 < (viewGroup2 != null ? viewGroup2.getChildCount() : 0) && viewGroup.getChildAt(this.f2205a).requestFocus(i6, rect)) {
                return true;
            }
        }
        return super.requestFocus(i6, rect);
    }

    public PersistentFocusWrapper(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2205a = -1;
        this.f2206b = true;
    }
}
