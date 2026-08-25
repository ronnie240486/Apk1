package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new C4043d(3);

    public final int f5014a;

    public final String[] f5015b;

    public Bundle f5016c;

    public final CursorWindow[] f5017d;

    public final int f5018e;

    public final Bundle f5019f;

    public int[] f5020g;

    public boolean f5021h = false;

    static {
        new ArrayList();
        new HashMap();
    }

    public DataHolder(int i6, String[] strArr, CursorWindow[] cursorWindowArr, int i10, Bundle bundle) {
        this.f5014a = i6;
        this.f5015b = strArr;
        this.f5017d = cursorWindowArr;
        this.f5018e = i10;
        this.f5019f = bundle;
    }

    @Override
    public final void close() {
        synchronized (this) {
            try {
                if (!this.f5021h) {
                    this.f5021h = true;
                    int i6 = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.f5017d;
                        if (i6 >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i6].close();
                        i6++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void finalize() throws Throwable {
        boolean z7;
        try {
            if (this.f5017d.length > 0) {
                synchronized (this) {
                    z7 = this.f5021h;
                }
                if (!z7) {
                    close();
                    Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: " + toString() + ")");
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        String[] strArr = this.f5015b;
        if (strArr != null) {
            int iM6583V2 = AbstractC3280d.m6583V(parcel, 1);
            parcel.writeStringArray(strArr);
            AbstractC3280d.m6584W(parcel, iM6583V2);
        }
        AbstractC3280d.m6581T(parcel, 2, this.f5017d, i6);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5018e);
        AbstractC3280d.m6574M(parcel, 4, this.f5019f);
        AbstractC3280d.m6585X(parcel, 1000, 4);
        parcel.writeInt(this.f5014a);
        AbstractC3280d.m6584W(parcel, iM6583V);
        if ((i6 & 1) != 0) {
            close();
        }
    }
}
