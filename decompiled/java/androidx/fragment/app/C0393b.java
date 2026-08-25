package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class C0393b implements Parcelable.Creator {

    public final int f1822a;

    @Override
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f1822a) {
            case 0:
                return new BackStackState(parcel);
            case 1:
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = new FragmentManager$LaunchedFragmentInfo();
                fragmentManager$LaunchedFragmentInfo.f1774a = parcel.readString();
                fragmentManager$LaunchedFragmentInfo.f1775b = parcel.readInt();
                return fragmentManager$LaunchedFragmentInfo;
            case 2:
                FragmentManagerState fragmentManagerState = new FragmentManagerState();
                fragmentManagerState.f1780e = null;
                fragmentManagerState.f1781f = new ArrayList();
                fragmentManagerState.f1782g = new ArrayList();
                fragmentManagerState.f1776a = parcel.createTypedArrayList(FragmentState.CREATOR);
                fragmentManagerState.f1777b = parcel.createStringArrayList();
                fragmentManagerState.f1778c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
                fragmentManagerState.f1779d = parcel.readInt();
                fragmentManagerState.f1780e = parcel.readString();
                fragmentManagerState.f1781f = parcel.createStringArrayList();
                fragmentManagerState.f1782g = parcel.createTypedArrayList(Bundle.CREATOR);
                fragmentManagerState.f1783h = parcel.createTypedArrayList(FragmentManager$LaunchedFragmentInfo.CREATOR);
                return fragmentManagerState;
            default:
                return new FragmentState(parcel);
        }
    }

    @Override
    public final Object[] newArray(int i6) {
        switch (this.f1822a) {
            case 0:
                return new BackStackState[i6];
            case 1:
                return new FragmentManager$LaunchedFragmentInfo[i6];
            case 2:
                return new FragmentManagerState[i6];
            default:
                return new FragmentState[i6];
        }
    }
}
