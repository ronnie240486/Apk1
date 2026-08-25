package p249x4;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzs;
import com.google.android.material.badge.BadgeState$State;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import java.util.Locale;
import p143n5.AbstractC3198d;

public final class C4120m implements Parcelable.Creator {

    public final int f13956a;

    public C4120m(int i6) {
        this.f13956a = i6;
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f13956a) {
            case 0:
                int iM6447V = AbstractC3198d.m6447V(parcel);
                boolean zM6431F = false;
                String strM6463k = null;
                IBinder iBinderM6435J = null;
                boolean zM6431F2 = false;
                while (parcel.dataPosition() < iM6447V) {
                    int i6 = parcel.readInt();
                    char c5 = (char) i6;
                    if (c5 == 1) {
                        strM6463k = AbstractC3198d.m6463k(parcel, i6);
                    } else if (c5 == 2) {
                        iBinderM6435J = AbstractC3198d.m6435J(parcel, i6);
                    } else if (c5 == 3) {
                        zM6431F = AbstractC3198d.m6431F(parcel, i6);
                    } else if (c5 != 4) {
                        AbstractC3198d.m6445T(parcel, i6);
                    } else {
                        zM6431F2 = AbstractC3198d.m6431F(parcel, i6);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V);
                return new zzs(strM6463k, iBinderM6435J, zM6431F, zM6431F2);
            case 1:
                return new UserInfoBean(parcel);
            case 2:
                BadgeState$State badgeState$State = new BadgeState$State();
                badgeState$State.f5885d = 255;
                badgeState$State.f5886e = -2;
                badgeState$State.f5887f = -2;
                badgeState$State.f5893l = Boolean.TRUE;
                badgeState$State.f5882a = parcel.readInt();
                badgeState$State.f5883b = (Integer) parcel.readSerializable();
                badgeState$State.f5884c = (Integer) parcel.readSerializable();
                badgeState$State.f5885d = parcel.readInt();
                badgeState$State.f5886e = parcel.readInt();
                badgeState$State.f5887f = parcel.readInt();
                badgeState$State.f5889h = parcel.readString();
                badgeState$State.f5890i = parcel.readInt();
                badgeState$State.f5892k = (Integer) parcel.readSerializable();
                badgeState$State.f5894m = (Integer) parcel.readSerializable();
                badgeState$State.f5895n = (Integer) parcel.readSerializable();
                badgeState$State.f5896o = (Integer) parcel.readSerializable();
                badgeState$State.f5897p = (Integer) parcel.readSerializable();
                badgeState$State.f5898q = (Integer) parcel.readSerializable();
                badgeState$State.f5899r = (Integer) parcel.readSerializable();
                badgeState$State.f5893l = (Boolean) parcel.readSerializable();
                badgeState$State.f5888g = (Locale) parcel.readSerializable();
                return badgeState$State;
            default:
                return new PlugInBean(parcel);
        }
    }

    @Override
    public final Object[] newArray(int i6) {
        switch (this.f13956a) {
            case 0:
                return new zzs[i6];
            case 1:
                return new UserInfoBean[i6];
            case 2:
                return new BadgeState$State[i6];
            default:
                return new PlugInBean[i6];
        }
    }
}
