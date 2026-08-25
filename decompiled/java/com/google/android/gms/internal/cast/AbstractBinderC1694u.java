package com.google.android.gms.internal.cast;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.signin.internal.zak;
import p177q5.AbstractC3501a;
import p271z4.BinderC4352w;
import ua.RunnableC3940a;

public abstract class AbstractBinderC1694u extends Binder implements IInterface {

    public final int f5684c;

    @Override
    public final IBinder asBinder() {
        int i6 = this.f5684c;
        return this;
    }

    @Override
    public final boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i10) {
        switch (this.f5684c) {
            case 0:
                if (i6 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i6, parcel, parcel2, i10)) {
                    return true;
                }
                return mo3202w(i6, parcel, parcel2);
            case 1:
                if (i6 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i6, parcel, parcel2, i10)) {
                    return true;
                }
                return mo3202w(i6, parcel, parcel2);
            default:
                if (i6 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i6, parcel, parcel2, i10)) {
                    return true;
                }
                switch (i6) {
                    case 3:
                        AbstractC3501a.m7146b(parcel);
                        break;
                    case 4:
                        AbstractC3501a.m7146b(parcel);
                        break;
                    case 5:
                    default:
                        return false;
                    case 6:
                        AbstractC3501a.m7146b(parcel);
                        break;
                    case 7:
                        AbstractC3501a.m7146b(parcel);
                        break;
                    case 8:
                        zak zakVar = (zak) AbstractC3501a.m7145a(parcel, zak.CREATOR);
                        AbstractC3501a.m7146b(parcel);
                        BinderC4352w binderC4352w = (BinderC4352w) this;
                        binderC4352w.f14753e.post(new RunnableC3940a(9, binderC4352w, zakVar, false));
                        break;
                    case 9:
                        AbstractC3501a.m7146b(parcel);
                        break;
                }
                parcel2.writeNoException();
                return true;
        }
    }

    public boolean mo3202w(int i6, Parcel parcel, Parcel parcel2) {
        return false;
    }

    public AbstractBinderC1694u(String str, int i6) {
        this.f5684c = i6;
        switch (i6) {
            case 1:
                attachInterface(this, str);
                break;
            default:
                attachInterface(this, str);
                break;
        }
    }
}
