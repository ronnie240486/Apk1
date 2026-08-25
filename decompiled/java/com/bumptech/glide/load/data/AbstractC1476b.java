package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.EnumC1469g;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class AbstractC1476b implements InterfaceC1479e {

    public final int f4473a;

    public Object f4474b;

    public final Comparable f4475c;

    public final Object f4476d;

    public AbstractC1476b(int i6, Comparable comparable, Object obj) {
        this.f4473a = i6;
        this.f4476d = obj;
        this.f4475c = comparable;
    }

    @Override
    public final void mo3152b() {
        switch (this.f4473a) {
            case 0:
                Object obj = this.f4474b;
                if (obj != null) {
                    try {
                        mo3543g(obj);
                    } catch (IOException unused) {
                        return;
                    }
                    break;
                }
                break;
            default:
                Object obj2 = this.f4474b;
                if (obj2 != null) {
                    try {
                        mo3543g(obj2);
                    } catch (IOException unused2) {
                        return;
                    }
                }
                break;
        }
    }

    @Override
    public final void cancel() {
        int i6 = this.f4473a;
    }

    @Override
    public final int mo3153d() {
        switch (this.f4473a) {
        }
        return 1;
    }

    @Override
    public final void mo3154f(EnumC1469g enumC1469g, InterfaceC1478d interfaceC1478d) {
        switch (this.f4473a) {
            case 0:
                try {
                    Object objMo3547h = mo3547h((AssetManager) this.f4476d, (String) this.f4475c);
                    this.f4474b = objMo3547h;
                    interfaceC1478d.mo3173e(objMo3547h);
                } catch (IOException e5) {
                    if (Log.isLoggable("AssetPathFetcher", 3)) {
                        Log.d("AssetPathFetcher", "Failed to load data from asset manager", e5);
                    }
                    interfaceC1478d.mo3172c(e5);
                    return;
                }
                break;
            default:
                try {
                    Object objMo3544i = mo3544i((Uri) this.f4475c, (ContentResolver) this.f4476d);
                    this.f4474b = objMo3544i;
                    interfaceC1478d.mo3173e(objMo3544i);
                } catch (FileNotFoundException e10) {
                    if (Log.isLoggable("LocalUriFetcher", 3)) {
                        Log.d("LocalUriFetcher", "Failed to open Uri", e10);
                    }
                    interfaceC1478d.mo3172c(e10);
                }
                break;
        }
    }

    public abstract void mo3543g(Object obj);

    public abstract Object mo3547h(AssetManager assetManager, String str);

    public abstract Object mo3544i(Uri uri, ContentResolver contentResolver);

    private final void m3545c() {
    }

    private final void m3546e() {
    }
}
