package com.google.android.gms.internal.cast;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class AbstractC1501a implements IInterface {

    public final int f5194c;

    public final IBinder f5195d;

    public final String f5196e;

    public AbstractC1501a(IBinder iBinder, String str, int i6) {
        this.f5194c = i6;
        this.f5195d = iBinder;
        this.f5196e = str;
    }

    @Override
    public final IBinder asBinder() {
        switch (this.f5194c) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.f5195d;
    }

    public Parcel m3686g(Parcel parcel, int i6) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f5195d.transact(i6, parcel, parcelObtain, 0);
                parcelObtain.readException();
                parcel.recycle();
                return parcelObtain;
            } catch (RuntimeException e5) {
                parcelObtain.recycle();
                throw e5;
            }
        } catch (Throwable th) {
            parcel.recycle();
            throw th;
        }
    }

    public Parcel m3687l() {
        switch (this.f5194c) {
            case 0:
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.writeInterfaceToken(this.f5196e);
                return parcelObtain;
            default:
                Parcel parcelObtain2 = Parcel.obtain();
                parcelObtain2.writeInterfaceToken(this.f5196e);
                return parcelObtain2;
        }
    }

    public Parcel m3688w(Parcel parcel, int i6) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f5195d.transact(i6, parcel, parcelObtain, 0);
                parcelObtain.readException();
                parcel.recycle();
                return parcelObtain;
            } catch (RuntimeException e5) {
                parcelObtain.recycle();
                throw e5;
            }
        } catch (Throwable th) {
            parcel.recycle();
            throw th;
        }
    }

    public void m3689x(Parcel parcel, int i6) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f5195d.transact(i6, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    public void m3690y(Parcel parcel, int i6) {
        try {
            this.f5195d.transact(i6, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
