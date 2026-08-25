package p003a2;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p160p.C3341e;

public abstract class AbstractC0033b {

    public final C3341e f95a;

    public final C3341e f96b;

    public final C3341e f97c;

    public AbstractC0033b(C3341e c3341e, C3341e c3341e2, C3341e c3341e3) {
        this.f95a = c3341e;
        this.f96b = c3341e2;
        this.f97c = c3341e3;
    }

    public abstract C0034c mo179a();

    public final Class m180b(Class cls) throws ClassNotFoundException {
        String name = cls.getName();
        C3341e c3341e = this.f97c;
        Class cls2 = (Class) c3341e.get(name);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        c3341e.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method m181c(String str) throws NoSuchMethodException {
        C3341e c3341e = this.f95a;
        Method method = (Method) c3341e.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, AbstractC0033b.class.getClassLoader()).getDeclaredMethod("read", AbstractC0033b.class);
        c3341e.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method m182d(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        String name = cls.getName();
        C3341e c3341e = this.f96b;
        Method method = (Method) c3341e.get(name);
        if (method != null) {
            return method;
        }
        Class clsM180b = m180b(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsM180b.getDeclaredMethod("write", cls, AbstractC0033b.class);
        c3341e.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean mo183e(int i6);

    public final int m184f(int i6, int i10) {
        return !mo183e(i10) ? i6 : ((C0034c) this).f99e.readInt();
    }

    public final Parcelable m185g(Parcelable parcelable, int i6) {
        if (!mo183e(i6)) {
            return parcelable;
        }
        return ((C0034c) this).f99e.readParcelable(C0034c.class.getClassLoader());
    }

    public final InterfaceC0035d m186h() {
        String string = ((C0034c) this).f99e.readString();
        if (string == null) {
            return null;
        }
        try {
            return (InterfaceC0035d) m181c(string).invoke(null, mo179a());
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e10);
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e11);
        } catch (InvocationTargetException e12) {
            if (e12.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e12.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e12);
        }
    }

    public abstract void mo187i(int i6);

    public final void m188j(int i6, int i10) {
        mo187i(i10);
        ((C0034c) this).f99e.writeInt(i6);
    }

    public final void m189k(Parcelable parcelable, int i6) {
        mo187i(i6);
        ((C0034c) this).f99e.writeParcelable(parcelable, 0);
    }

    public final void m190l(InterfaceC0035d interfaceC0035d) {
        if (interfaceC0035d == null) {
            ((C0034c) this).f99e.writeString(null);
            return;
        }
        try {
            ((C0034c) this).f99e.writeString(m180b(interfaceC0035d.getClass()).getName());
            C0034c c0034cMo179a = mo179a();
            try {
                m182d(interfaceC0035d.getClass()).invoke(null, interfaceC0035d, c0034cMo179a);
                int i6 = c0034cMo179a.f103i;
                if (i6 >= 0) {
                    int i10 = c0034cMo179a.f98d.get(i6);
                    Parcel parcel = c0034cMo179a.f99e;
                    int iDataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i10);
                    parcel.writeInt(iDataPosition - i10);
                    parcel.setDataPosition(iDataPosition);
                }
            } catch (ClassNotFoundException e5) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e10);
            } catch (NoSuchMethodException e11) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e11);
            } catch (InvocationTargetException e12) {
                if (!(e12.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e12);
                }
                throw ((RuntimeException) e12.getCause());
            }
        } catch (ClassNotFoundException e13) {
            throw new RuntimeException(interfaceC0035d.getClass().getSimpleName().concat(" does not have a Parcelizer"), e13);
        }
    }
}
