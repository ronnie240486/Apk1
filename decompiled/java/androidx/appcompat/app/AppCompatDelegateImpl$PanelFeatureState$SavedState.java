package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
class AppCompatDelegateImpl$PanelFeatureState$SavedState implements Parcelable {
    public static final Parcelable.Creator<AppCompatDelegateImpl$PanelFeatureState$SavedState> CREATOR = new C0131e0();

    public int f251a;

    public boolean f252b;

    public Bundle f253c;

    public static AppCompatDelegateImpl$PanelFeatureState$SavedState m367h(Parcel parcel, ClassLoader classLoader) {
        AppCompatDelegateImpl$PanelFeatureState$SavedState appCompatDelegateImpl$PanelFeatureState$SavedState = new AppCompatDelegateImpl$PanelFeatureState$SavedState();
        appCompatDelegateImpl$PanelFeatureState$SavedState.f251a = parcel.readInt();
        boolean z7 = parcel.readInt() == 1;
        appCompatDelegateImpl$PanelFeatureState$SavedState.f252b = z7;
        if (z7) {
            appCompatDelegateImpl$PanelFeatureState$SavedState.f253c = parcel.readBundle(classLoader);
        }
        return appCompatDelegateImpl$PanelFeatureState$SavedState;
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f251a);
        parcel.writeInt(this.f252b ? 1 : 0);
        if (this.f252b) {
            parcel.writeBundle(this.f253c);
        }
    }
}
