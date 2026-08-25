package p012b;

import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;
import p005a4.C0052k;
import p173q1.C3406f0;
import p186r3.AbstractC3602f;
import p186r3.InterfaceC3603g;
import p269z2.C4302c;
import p269z2.C4303d;
import p269z2.InterfaceC4300a;

public final class C1224a implements InterfaceC3603g {

    public volatile Object f3908a;

    public final Object f3909b;

    public C1224a(Object obj) {
        this.f3909b = obj;
    }

    public InterfaceC4300a m3103a() {
        File file;
        File file2;
        if (((InterfaceC4300a) this.f3908a) == null) {
            synchronized (this) {
                try {
                    if (((InterfaceC4300a) this.f3908a) == null) {
                        C4303d c4303d = (C4303d) this.f3909b;
                        C0052k c0052k = c4303d.f14601b;
                        switch (c0052k.f154a) {
                            case 4:
                                File externalCacheDir = c0052k.f155b.getExternalCacheDir();
                                if (externalCacheDir != null) {
                                    file = new File(externalCacheDir, "image_manager_disk_cache");
                                    file2 = file;
                                } else {
                                    file2 = null;
                                }
                                break;
                            default:
                                File cacheDir = c0052k.f155b.getCacheDir();
                                if (cacheDir != null) {
                                    file = new File(cacheDir, "image_manager_disk_cache");
                                    file2 = file;
                                } else {
                                    file2 = null;
                                }
                                break;
                        }
                        C4302c c4302c = null;
                        if (file2 != null && (file2.isDirectory() || file2.mkdirs())) {
                            c4302c = new C4302c(file2, c4303d.f14600a);
                        }
                        this.f3908a = c4302c;
                    }
                    if (((InterfaceC4300a) this.f3908a) == null) {
                        this.f3908a = new C3406f0(11);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return (InterfaceC4300a) this.f3908a;
    }

    @Override
    public Object get() {
        if (this.f3908a == null) {
            synchronized (this) {
                try {
                    if (this.f3908a == null) {
                        Object obj = ((InterfaceC3603g) this.f3909b).get();
                        AbstractC3602f.m7225c(obj, "Argument must not be null");
                        this.f3908a = obj;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f3908a;
    }

    public C1224a() {
        this.f3909b = new CopyOnWriteArraySet();
    }
}
