package p068g3;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.ComponentCallbacks2C1491o;
import p007a7.C0069f;
import p086i3.C2688d;
import p086i3.C2690f;
import p086i3.C2693i;
import p186r3.AbstractC3602f;
import p208t2.C3803d;
import p247x2.InterfaceC4099u;
import p247x2.InterfaceC4102x;
import p259y2.C4243f;
import p259y2.InterfaceC4238a;

public final class C2609c implements InterfaceC4102x, InterfaceC4099u {

    public final Drawable f9080a;

    public final int f9081b;

    public C2609c(Drawable drawable, int i6) {
        this.f9081b = i6;
        AbstractC3602f.m7225c(drawable, "Argument must not be null");
        this.f9080a = drawable;
    }

    @Override
    public final int mo5403a() {
        switch (this.f9081b) {
            case 0:
                Drawable drawable = this.f9080a;
                return Math.max(1, drawable.getIntrinsicHeight() * drawable.getIntrinsicWidth() * 4);
            default:
                C2693i c2693i = (C2693i) ((C2688d) this.f9080a).f9337a.f9336b;
                C3803d c3803d = c2693i.f9354a;
                return (c3803d.f12830j.length * 4) + c3803d.f12824d.limit() + c3803d.f12829i.length + c2693i.f9367n;
        }
    }

    @Override
    public final Class mo5404c() {
        switch (this.f9081b) {
            case 0:
                return this.f9080a.getClass();
            default:
                return C2688d.class;
        }
    }

    @Override
    public final void mo5405d() {
        C4243f c4243f;
        C4243f c4243f2;
        C4243f c4243f3;
        switch (this.f9081b) {
            case 0:
                break;
            default:
                C2688d c2688d = (C2688d) this.f9080a;
                c2688d.stop();
                c2688d.f9340d = true;
                C2693i c2693i = (C2693i) c2688d.f9337a.f9336b;
                c2693i.f9356c.clear();
                Bitmap bitmap = c2693i.f9365l;
                if (bitmap != null) {
                    c2693i.f9358e.mo5434f(bitmap);
                    c2693i.f9365l = null;
                }
                c2693i.f9359f = false;
                C2690f c2690f = c2693i.f9362i;
                ComponentCallbacks2C1491o componentCallbacks2C1491o = c2693i.f9357d;
                if (c2690f != null) {
                    componentCallbacks2C1491o.m3569l(c2690f);
                    c2693i.f9362i = null;
                }
                C2690f c2690f2 = c2693i.f9364k;
                if (c2690f2 != null) {
                    componentCallbacks2C1491o.m3569l(c2690f2);
                    c2693i.f9364k = null;
                }
                C2690f c2690f3 = c2693i.f9366m;
                if (c2690f3 != null) {
                    componentCallbacks2C1491o.m3569l(c2690f3);
                    c2693i.f9366m = null;
                }
                C3803d c3803d = c2693i.f9354a;
                c3803d.f12832l = null;
                byte[] bArr = c3803d.f12829i;
                C0069f c0069f = c3803d.f12823c;
                if (bArr != null && (c4243f3 = (C4243f) c0069f.f197c) != null) {
                    c4243f3.m8291h(bArr);
                }
                int[] iArr = c3803d.f12830j;
                if (iArr != null && (c4243f2 = (C4243f) c0069f.f197c) != null) {
                    c4243f2.m8291h(iArr);
                }
                Bitmap bitmap2 = c3803d.f12833m;
                if (bitmap2 != null) {
                    ((InterfaceC4238a) c0069f.f196b).mo5434f(bitmap2);
                }
                c3803d.f12833m = null;
                c3803d.f12824d = null;
                c3803d.f12839s = null;
                byte[] bArr2 = c3803d.f12825e;
                if (bArr2 != null && (c4243f = (C4243f) c0069f.f197c) != null) {
                    c4243f.m8291h(bArr2);
                }
                c2693i.f9363j = true;
                break;
        }
    }

    @Override
    public final Object get() {
        Drawable drawable = this.f9080a;
        Drawable.ConstantState constantState = drawable.getConstantState();
        return constantState == null ? drawable : constantState.newDrawable();
    }

    @Override
    public void initialize() {
        switch (this.f9081b) {
            case 1:
                ((C2693i) ((C2688d) this.f9080a).f9337a.f9336b).f9365l.prepareToDraw();
                break;
            default:
                Drawable drawable = this.f9080a;
                if (drawable instanceof BitmapDrawable) {
                    ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
                } else if (drawable instanceof C2688d) {
                    ((C2693i) ((C2688d) drawable).f9337a.f9336b).f9365l.prepareToDraw();
                }
                break;
        }
    }

    private final void m5623b() {
    }
}
