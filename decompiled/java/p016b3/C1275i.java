package p016b3;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.EnumC1469g;
import com.bumptech.glide.load.data.InterfaceC1478d;
import com.bumptech.glide.load.data.InterfaceC1479e;
import java.io.IOException;
import java.io.InputStream;
import p156o9.AbstractC3280d;

public final class C1275i implements InterfaceC1479e {

    public final Resources.Theme f4024a;

    public final Resources f4025b;

    public final Object f4026c;

    public final int f4027d;

    public Object f4028e;

    public C1275i(Resources.Theme theme, Resources resources, C1273h c1273h, int i6) {
        this.f4024a = theme;
        this.f4025b = resources;
        this.f4026c = c1273h;
        this.f4027d = i6;
    }

    @Override
    public final Class mo3151a() {
        switch (((C1273h) this.f4026c).f4020a) {
            case 0:
                return AssetFileDescriptor.class;
            case 1:
                return Drawable.class;
            default:
                return InputStream.class;
        }
    }

    @Override
    public final void mo3152b() {
        Object obj = this.f4028e;
        if (obj != null) {
            try {
                switch (((C1273h) this.f4026c).f4020a) {
                    case 0:
                        ((AssetFileDescriptor) obj).close();
                        break;
                    case 1:
                        break;
                    default:
                        ((InputStream) obj).close();
                        break;
                }
            } catch (IOException unused) {
            }
        }
    }

    @Override
    public final int mo3153d() {
        return 1;
    }

    @Override
    public final void mo3154f(EnumC1469g enumC1469g, InterfaceC1478d interfaceC1478d) {
        Object objOpenRawResourceFd;
        try {
            Object obj = this.f4026c;
            Resources.Theme theme = this.f4024a;
            Resources resources = this.f4025b;
            int i6 = this.f4027d;
            C1273h c1273h = (C1273h) obj;
            switch (c1273h.f4020a) {
                case 0:
                    objOpenRawResourceFd = resources.openRawResourceFd(i6);
                    break;
                case 1:
                    Context context = c1273h.f4021b;
                    objOpenRawResourceFd = AbstractC3280d.m6596n(context, context, i6, theme);
                    break;
                default:
                    objOpenRawResourceFd = resources.openRawResource(i6);
                    break;
            }
            this.f4028e = objOpenRawResourceFd;
            interfaceC1478d.mo3173e(objOpenRawResourceFd);
        } catch (Resources.NotFoundException e5) {
            interfaceC1478d.mo3172c(e5);
        }
    }

    @Override
    public final void cancel() {
    }
}
