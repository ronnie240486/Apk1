package p176q4;

import android.os.Parcel;
import com.google.android.gms.internal.cast.AbstractBinderC1694u;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import p132m5.BinderC3079b;
import p132m5.InterfaceC3078a;

public final class BinderC3500z extends AbstractBinderC1694u {

    public final InterfaceC3483i f11788d;

    public final Class f11789e;

    public BinderC3500z(InterfaceC3483i interfaceC3483i) {
        super("com.google.android.gms.cast.framework.ISessionManagerListener", 0);
        this.f11788d = interfaceC3483i;
        this.f11789e = C3475c.class;
    }

    @Override
    public final boolean mo3202w(int i6, Parcel parcel, Parcel parcel2) {
        Class cls = this.f11789e;
        InterfaceC3483i interfaceC3483i = this.f11788d;
        switch (i6) {
            case 1:
                BinderC3079b binderC3079b = new BinderC3079b(interfaceC3483i);
                parcel2.writeNoException();
                AbstractC1542e0.m3810d(parcel2, binderC3079b);
                return true;
            case 2:
                InterfaceC3078a interfaceC3078aM6111x = BinderC3079b.m6111x(parcel.readStrongBinder());
                AbstractC1542e0.m3808b(parcel);
                AbstractC3481g abstractC3481g = (AbstractC3481g) BinderC3079b.m6112y(interfaceC3078aM6111x);
                if (cls.isInstance(abstractC3481g) && interfaceC3483i != null) {
                    interfaceC3483i.mo3725n((AbstractC3481g) cls.cast(abstractC3481g));
                }
                parcel2.writeNoException();
                return true;
            case 3:
                InterfaceC3078a interfaceC3078aM6111x2 = BinderC3079b.m6111x(parcel.readStrongBinder());
                String string = parcel.readString();
                AbstractC1542e0.m3808b(parcel);
                AbstractC3481g abstractC3481g2 = (AbstractC3481g) BinderC3079b.m6112y(interfaceC3078aM6111x2);
                if (cls.isInstance(abstractC3481g2) && interfaceC3483i != null) {
                    interfaceC3483i.mo3720h((AbstractC3481g) cls.cast(abstractC3481g2), string);
                }
                parcel2.writeNoException();
                return true;
            case 4:
                InterfaceC3078a interfaceC3078aM6111x3 = BinderC3079b.m6111x(parcel.readStrongBinder());
                int i10 = parcel.readInt();
                AbstractC1542e0.m3808b(parcel);
                AbstractC3481g abstractC3481g3 = (AbstractC3481g) BinderC3079b.m6112y(interfaceC3078aM6111x3);
                if (cls.isInstance(abstractC3481g3) && interfaceC3483i != null) {
                    interfaceC3483i.mo3717a((AbstractC3481g) cls.cast(abstractC3481g3), i10);
                }
                parcel2.writeNoException();
                return true;
            case 5:
                InterfaceC3078a interfaceC3078aM6111x4 = BinderC3079b.m6111x(parcel.readStrongBinder());
                AbstractC1542e0.m3808b(parcel);
                AbstractC3481g abstractC3481g4 = (AbstractC3481g) BinderC3079b.m6112y(interfaceC3078aM6111x4);
                if (cls.isInstance(abstractC3481g4) && interfaceC3483i != null) {
                    interfaceC3483i.mo3723l((AbstractC3481g) cls.cast(abstractC3481g4));
                }
                parcel2.writeNoException();
                return true;
            case 6:
                InterfaceC3078a interfaceC3078aM6111x5 = BinderC3079b.m6111x(parcel.readStrongBinder());
                int i11 = parcel.readInt();
                AbstractC1542e0.m3808b(parcel);
                AbstractC3481g abstractC3481g5 = (AbstractC3481g) BinderC3079b.m6112y(interfaceC3078aM6111x5);
                if (cls.isInstance(abstractC3481g5) && interfaceC3483i != null) {
                    interfaceC3483i.mo3724m((AbstractC3481g) cls.cast(abstractC3481g5), i11);
                }
                parcel2.writeNoException();
                return true;
            case 7:
                InterfaceC3078a interfaceC3078aM6111x6 = BinderC3079b.m6111x(parcel.readStrongBinder());
                String string2 = parcel.readString();
                AbstractC1542e0.m3808b(parcel);
                AbstractC3481g abstractC3481g6 = (AbstractC3481g) BinderC3079b.m6112y(interfaceC3078aM6111x6);
                if (cls.isInstance(abstractC3481g6) && interfaceC3483i != null) {
                    interfaceC3483i.mo3722k((AbstractC3481g) cls.cast(abstractC3481g6), string2);
                }
                parcel2.writeNoException();
                return true;
            case 8:
                InterfaceC3078a interfaceC3078aM6111x7 = BinderC3079b.m6111x(parcel.readStrongBinder());
                int i12 = AbstractC1542e0.f5277a;
                boolean z7 = parcel.readInt() != 0;
                AbstractC1542e0.m3808b(parcel);
                AbstractC3481g abstractC3481g7 = (AbstractC3481g) BinderC3079b.m6112y(interfaceC3078aM6111x7);
                if (cls.isInstance(abstractC3481g7) && interfaceC3483i != null) {
                    interfaceC3483i.mo3718d((AbstractC3481g) cls.cast(abstractC3481g7), z7);
                }
                parcel2.writeNoException();
                return true;
            case 9:
                InterfaceC3078a interfaceC3078aM6111x8 = BinderC3079b.m6111x(parcel.readStrongBinder());
                int i13 = parcel.readInt();
                AbstractC1542e0.m3808b(parcel);
                AbstractC3481g abstractC3481g8 = (AbstractC3481g) BinderC3079b.m6112y(interfaceC3078aM6111x8);
                if (cls.isInstance(abstractC3481g8) && interfaceC3483i != null) {
                    interfaceC3483i.mo3721i((AbstractC3481g) cls.cast(abstractC3481g8), i13);
                }
                parcel2.writeNoException();
                return true;
            case 10:
                InterfaceC3078a interfaceC3078aM6111x9 = BinderC3079b.m6111x(parcel.readStrongBinder());
                int i14 = parcel.readInt();
                AbstractC1542e0.m3808b(parcel);
                AbstractC3481g abstractC3481g9 = (AbstractC3481g) BinderC3079b.m6112y(interfaceC3078aM6111x9);
                if (cls.isInstance(abstractC3481g9) && interfaceC3483i != null) {
                    interfaceC3483i.mo3719g((AbstractC3481g) cls.cast(abstractC3481g9), i14);
                }
                parcel2.writeNoException();
                return true;
            case 11:
                parcel2.writeNoException();
                parcel2.writeInt(12451000);
                return true;
            default:
                return false;
        }
    }
}
