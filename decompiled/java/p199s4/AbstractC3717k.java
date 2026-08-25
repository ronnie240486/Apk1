package p199s4;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.cast.framework.media.NotificationAction;
import java.util.ArrayList;
import p187r4.C3632v;
import p230v4.C3988b;

public abstract class AbstractC3717k {

    public static final C3988b f12470a = new C3988b("MediaSessionUtils", null);

    public static ArrayList m7482a(C3632v c3632v) {
        try {
            Parcel parcelM3688w = c3632v.m3688w(c3632v.m3687l(), 3);
            ArrayList arrayListCreateTypedArrayList = parcelM3688w.createTypedArrayList(NotificationAction.CREATOR);
            parcelM3688w.recycle();
            return arrayListCreateTypedArrayList;
        } catch (RemoteException e5) {
            Object[] objArr = {"getNotificationActions", C3632v.class.getSimpleName()};
            C3988b c3988b = f12470a;
            Log.e(c3988b.f13521a, c3988b.m7977d("Unable to call %s on %s.", objArr), e5);
            return null;
        }
    }

    public static int[] m7483b(C3632v c3632v) {
        try {
            Parcel parcelM3688w = c3632v.m3688w(c3632v.m3687l(), 4);
            int[] iArrCreateIntArray = parcelM3688w.createIntArray();
            parcelM3688w.recycle();
            return iArrCreateIntArray;
        } catch (RemoteException e5) {
            Object[] objArr = {"getCompactViewActionIndices", C3632v.class.getSimpleName()};
            C3988b c3988b = f12470a;
            Log.e(c3988b.f13521a, c3988b.m7977d("Unable to call %s on %s.", objArr), e5);
            return null;
        }
    }
}
