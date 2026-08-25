package p076h2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.memory.MemoryCache$Key;
import java.util.LinkedHashMap;
import p008a9.InterfaceC0074d;
import p021b9.EnumC1367a;
import p025c2.C1383d;
import p025c2.C1391l;
import p030c9.AbstractC1439i;
import p036d2.EnumC2137f;
import p091i9.InterfaceC2728p;
import p101j7.C2782c;
import p108k2.C2864b;
import p130m2.C3061i;
import p130m2.C3065m;
import p130m2.C3069q;
import p156o9.AbstractC3280d;
import p185r2.AbstractC3587f;
import p185r2.ComponentCallbacks2C3594m;
import p213t9.InterfaceC3861s;
import p243w8.C4070l;

public final class C2646g extends AbstractC1439i implements InterfaceC2728p {

    public int f9218b;

    public final C2648i f9219c;

    public final C3061i f9220d;

    public final Object f9221e;

    public final C3065m f9222f;

    public final C1383d f9223g;

    public final MemoryCache$Key f9224h;

    public final C2650k f9225i;

    public C2646g(C2648i c2648i, C3061i c3061i, Object obj, C3065m c3065m, C1383d c1383d, MemoryCache$Key memoryCache$Key, C2650k c2650k, InterfaceC0074d interfaceC0074d) {
        super(interfaceC0074d);
        this.f9219c = c2648i;
        this.f9220d = c3061i;
        this.f9221e = obj;
        this.f9222f = c3065m;
        this.f9223g = c1383d;
        this.f9224h = memoryCache$Key;
        this.f9225i = c2650k;
    }

    @Override
    public final InterfaceC0074d create(Object obj, InterfaceC0074d interfaceC0074d) {
        return new C2646g(this.f9219c, this.f9220d, this.f9221e, this.f9222f, this.f9223g, this.f9224h, this.f9225i, interfaceC0074d);
    }

    @Override
    public final Object invoke(Object obj, Object obj2) {
        return ((C2646g) create((InterfaceC3861s) obj, (InterfaceC0074d) obj2)).invokeSuspend(C4070l.f13734a);
    }

    @Override
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4070l c4070l;
        C2864b c2864b;
        Bitmap bitmap;
        boolean z7;
        EnumC1367a enumC1367a = EnumC1367a.f4179a;
        int i6 = this.f9218b;
        if (i6 == 0) {
            AbstractC3280d.m6570I(obj);
            C2648i c2648i = this.f9219c;
            C3061i c3061i = this.f9220d;
            Object obj2 = this.f9221e;
            C3065m c3065m = this.f9222f;
            C1383d c1383d = this.f9223g;
            this.f9218b = 1;
            obj = C2648i.m5662b(c2648i, c3061i, obj2, c3065m, c1383d, this);
            if (obj == enumC1367a) {
                return enumC1367a;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC3280d.m6570I(obj);
        }
        C2640a c2640a = (C2640a) obj;
        ComponentCallbacks2C3594m componentCallbacks2C3594m = this.f9219c.f9239b;
        synchronized (componentCallbacks2C3594m) {
            try {
                C1391l c1391l = (C1391l) componentCallbacks2C3594m.f12083a.get();
                if (c1391l != null) {
                    if (componentCallbacks2C3594m.f12084b == null) {
                        Context context = c1391l.f4233a;
                        componentCallbacks2C3594m.f12084b = context;
                        context.registerComponentCallbacks(componentCallbacks2C3594m);
                    }
                    c4070l = C4070l.f13734a;
                } else {
                    c4070l = null;
                }
                if (c4070l == null) {
                    componentCallbacks2C3594m.m7216b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C2782c c2782c = this.f9219c.f9241d;
        MemoryCache$Key memoryCache$Key = this.f9224h;
        if (!this.f9220d.f10481n.f10418b || (c2864b = (C2864b) ((C1391l) c2782c.f9501b).f4235c.getValue()) == null || memoryCache$Key == null) {
            z7 = false;
        } else {
            Drawable drawable = c2640a.f9169a;
            BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
            if (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) {
                z7 = false;
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("coil#is_sampled", Boolean.valueOf(c2640a.f9170b));
                String str = c2640a.f9172d;
                if (str != null) {
                    linkedHashMap.put("coil#disk_cache_key", str);
                }
                c2864b.f9792a.mo228b(new MemoryCache$Key(memoryCache$Key.f4373a, AbstractC3280d.m6572K(memoryCache$Key.f4374b)), bitmap, AbstractC3280d.m6572K(linkedHashMap));
                z7 = true;
            }
        }
        Drawable drawable2 = c2640a.f9169a;
        C3061i c3061i2 = this.f9220d;
        EnumC2137f enumC2137f = c2640a.f9171c;
        MemoryCache$Key memoryCache$Key2 = z7 ? this.f9224h : null;
        String str2 = c2640a.f9172d;
        boolean z10 = c2640a.f9170b;
        C2650k c2650k = this.f9225i;
        Bitmap.Config[] configArr = AbstractC3587f.f12065a;
        return new C3069q(drawable2, c3061i2, enumC2137f, memoryCache$Key2, str2, z10, (c2650k instanceof C2650k) && c2650k.f9253g);
    }
}
