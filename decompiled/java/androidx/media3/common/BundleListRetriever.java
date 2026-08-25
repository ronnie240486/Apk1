package androidx.media3.common;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.List;
import p041d7.AbstractC2301u1;
import p041d7.C2288s1;

@UnstableApi
public final class BundleListRetriever extends Binder {
    private static final int REPLY_BREAK = 2;
    private static final int REPLY_CONTINUE = 1;
    private static final int REPLY_END_OF_LIST = 0;
    private static final int SUGGESTED_MAX_IPC_SIZE;
    private final AbstractC2301u1 list;

    static {
        SUGGESTED_MAX_IPC_SIZE = Util.SDK_INT >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : C0565C.DEFAULT_BUFFER_SEGMENT_SIZE;
    }

    public BundleListRetriever(List<Bundle> list) {
        this.list = AbstractC2301u1.m5272n(list);
    }

    public static AbstractC2301u1 getList(IBinder iBinder) {
        return iBinder instanceof BundleListRetriever ? ((BundleListRetriever) iBinder).list : getListFromRemoteBinder(iBinder);
    }

    public static AbstractC2301u1 getListFromRemoteBinder(IBinder iBinder) {
        int i6;
        C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
        int i10 = 1;
        int i11 = 0;
        while (i10 != 0) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInt(i11);
                try {
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    while (true) {
                        i6 = parcelObtain2.readInt();
                        if (i6 == 1) {
                            c2288s1M5269k.m5255a((Bundle) Assertions.checkNotNull(parcelObtain2.readBundle()));
                            i11++;
                        }
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    i10 = i6;
                } catch (RemoteException e5) {
                    throw new RuntimeException(e5);
                }
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
        return c2288s1M5269k.m5262g();
    }

    @Override
    public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i10) throws RemoteException {
        if (i6 != 1) {
            return super.onTransact(i6, parcel, parcel2, i10);
        }
        if (parcel2 == null) {
            return false;
        }
        int size = this.list.size();
        int i11 = parcel.readInt();
        while (i11 < size && parcel2.dataSize() < SUGGESTED_MAX_IPC_SIZE) {
            parcel2.writeInt(1);
            parcel2.writeBundle((Bundle) this.list.get(i11));
            i11++;
        }
        parcel2.writeInt(i11 < size ? 2 : 0);
        return true;
    }
}
