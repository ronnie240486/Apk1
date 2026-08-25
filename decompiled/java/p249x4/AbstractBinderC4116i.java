package p249x4;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.cast.AbstractBinderC1694u;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import p018b5.InterfaceC1310j;
import p132m5.BinderC3079b;
import p132m5.InterfaceC3078a;
import p188r5.AbstractC3635a;

public abstract class AbstractBinderC4116i extends AbstractBinderC1694u implements InterfaceC1310j {

    public static final int f13949e = 0;

    public final int f13950d;

    public AbstractBinderC4116i(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData", 1);
        if (bArr.length != 25) {
            throw new IllegalArgumentException();
        }
        this.f13950d = Arrays.hashCode(bArr);
    }

    public static byte[] m8139x(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e5) {
            throw new AssertionError(e5);
        }
    }

    @Override
    public final int mo3191b() {
        return this.f13950d;
    }

    public final boolean equals(Object obj) {
        InterfaceC3078a interfaceC3078aMo3192f;
        if (obj != null && (obj instanceof InterfaceC1310j)) {
            try {
                InterfaceC1310j interfaceC1310j = (InterfaceC1310j) obj;
                if (interfaceC1310j.mo3191b() == this.f13950d && (interfaceC3078aMo3192f = interfaceC1310j.mo3192f()) != null) {
                    return Arrays.equals(mo8138y(), (byte[]) BinderC3079b.m6112y(interfaceC3078aMo3192f));
                }
                return false;
            } catch (RemoteException e5) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
            }
        }
        return false;
    }

    @Override
    public final InterfaceC3078a mo3192f() {
        return new BinderC3079b(mo8138y());
    }

    public final int hashCode() {
        return this.f13950d;
    }

    @Override
    public final boolean mo3202w(int i6, Parcel parcel, Parcel parcel2) {
        if (i6 == 1) {
            InterfaceC3078a interfaceC3078aMo3192f = mo3192f();
            parcel2.writeNoException();
            AbstractC3635a.m7362c(parcel2, interfaceC3078aMo3192f);
        } else {
            if (i6 != 2) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(this.f13950d);
        }
        return true;
    }

    public abstract byte[] mo8138y();
}
