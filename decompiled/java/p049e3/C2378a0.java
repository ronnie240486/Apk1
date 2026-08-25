package p049e3;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import java.io.File;
import p186r3.AbstractC3602f;
import p186r3.AbstractC3610n;
import p247x2.InterfaceC4102x;

public final class C2378a0 implements InterfaceC4102x {

    public final int f8328a;

    public final Object f8329b;

    public C2378a0(int i6, Object obj) {
        this.f8328a = i6;
        this.f8329b = obj;
    }

    @Override
    public final int mo5403a() {
        switch (this.f8328a) {
            case 0:
                return AbstractC3610n.m7235c((Bitmap) this.f8329b);
            case 1:
                return ((byte[]) this.f8329b).length;
            case 2:
                return AbstractC3610n.m7236d(Bitmap.Config.ARGB_8888) * ((AnimatedImageDrawable) this.f8329b).getIntrinsicHeight() * ((AnimatedImageDrawable) this.f8329b).getIntrinsicWidth() * 2;
            default:
                return 1;
        }
    }

    @Override
    public final Class mo5404c() {
        switch (this.f8328a) {
            case 0:
                return Bitmap.class;
            case 1:
                return byte[].class;
            case 2:
                return Drawable.class;
            default:
                return ((File) this.f8329b).getClass();
        }
    }

    @Override
    public final void mo5405d() {
        switch (this.f8328a) {
            case 2:
                ((AnimatedImageDrawable) this.f8329b).stop();
                ((AnimatedImageDrawable) this.f8329b).clearAnimationCallbacks();
                break;
        }
    }

    @Override
    public final Object get() {
        switch (this.f8328a) {
            case 0:
                return (Bitmap) this.f8329b;
            case 1:
                return (byte[]) this.f8329b;
            case 2:
                return (AnimatedImageDrawable) this.f8329b;
            default:
                return (File) this.f8329b;
        }
    }

    public C2378a0(byte[] bArr) {
        this.f8328a = 1;
        AbstractC3602f.m7225c(bArr, "Argument must not be null");
        this.f8329b = bArr;
    }

    public C2378a0(File file) {
        this.f8328a = 3;
        AbstractC3602f.m7225c(file, "Argument must not be null");
        this.f8329b = file;
    }

    private final void m5400b() {
    }

    private final void m5401e() {
    }

    private final void m5402f() {
    }
}
