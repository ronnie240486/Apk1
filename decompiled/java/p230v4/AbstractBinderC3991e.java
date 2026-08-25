package p230v4;

import android.os.Parcel;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.internal.zza;
import com.google.android.gms.cast.internal.zzac;
import com.google.android.gms.internal.cast.AbstractBinderC1694u;
import com.google.android.gms.internal.cast.AbstractC1542e0;

public abstract class AbstractBinderC3991e extends AbstractBinderC1694u implements InterfaceC3992f {
    public AbstractBinderC3991e() {
        super("com.google.android.gms.cast.internal.ICastDeviceControllerListener", 0);
    }

    @Override
    public final boolean mo3202w(int i6, Parcel parcel, Parcel parcel2) {
        switch (i6) {
            case 1:
                int i10 = parcel.readInt();
                AbstractC1542e0.m3808b(parcel);
                mo6848m(i10);
                return true;
            case 2:
                ApplicationMetadata applicationMetadata = (ApplicationMetadata) AbstractC1542e0.m3807a(parcel, ApplicationMetadata.CREATOR);
                String string = parcel.readString();
                String string2 = parcel.readString();
                boolean z7 = parcel.readInt() != 0;
                AbstractC1542e0.m3808b(parcel);
                mo6856u(applicationMetadata, string, string2, z7);
                return true;
            case 3:
                int i11 = parcel.readInt();
                AbstractC1542e0.m3808b(parcel);
                mo6853r(i11);
                return true;
            case 4:
                parcel.readString();
                parcel.readDouble();
                int i12 = AbstractC1542e0.f5277a;
                parcel.readInt();
                AbstractC1542e0.m3808b(parcel);
                mo6850o();
                return true;
            case 5:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                AbstractC1542e0.m3808b(parcel);
                mo6849n(string3, string4);
                return true;
            case 6:
                String string5 = parcel.readString();
                byte[] bArrCreateByteArray = parcel.createByteArray();
                AbstractC1542e0.m3808b(parcel);
                mo6854s(string5, bArrCreateByteArray);
                return true;
            case 7:
                int i13 = parcel.readInt();
                AbstractC1542e0.m3808b(parcel);
                mo6846e(i13);
                return true;
            case 8:
                int i14 = parcel.readInt();
                AbstractC1542e0.m3808b(parcel);
                mo6851p(i14);
                return true;
            case 9:
                int i15 = parcel.readInt();
                AbstractC1542e0.m3808b(parcel);
                mo6843a(i15);
                return true;
            case 10:
                parcel.readString();
                long j10 = parcel.readLong();
                int i16 = parcel.readInt();
                AbstractC1542e0.m3808b(parcel);
                mo6852q(i16, j10);
                return true;
            case 11:
                parcel.readString();
                long j11 = parcel.readLong();
                AbstractC1542e0.m3808b(parcel);
                mo6855t(j11);
                return true;
            case 12:
                zza zzaVar = (zza) AbstractC1542e0.m3807a(parcel, zza.CREATOR);
                AbstractC1542e0.m3808b(parcel);
                mo6844c(zzaVar);
                return true;
            case 13:
                zzac zzacVar = (zzac) AbstractC1542e0.m3807a(parcel, zzac.CREATOR);
                AbstractC1542e0.m3808b(parcel);
                mo6857v(zzacVar);
                return true;
            case 14:
                int i17 = parcel.readInt();
                AbstractC1542e0.m3808b(parcel);
                mo6845d(i17);
                return true;
            case 15:
                int i18 = parcel.readInt();
                AbstractC1542e0.m3808b(parcel);
                mo6847k(i18);
                return true;
            default:
                return false;
        }
    }
}
