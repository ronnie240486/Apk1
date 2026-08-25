package p259y2;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p171q.C3388b;
import p186r3.AbstractC3610n;

public final class C4244g implements InterfaceC4238a {

    public static final Bitmap.Config f14412j = Bitmap.Config.ARGB_8888;

    public final C4248k f14413a;

    public final Set f14414b;

    public final C3388b f14415c;

    public final long f14416d;

    public long f14417e;

    public int f14418f;

    public int f14419g;

    public int f14420h;

    public int f14421i;

    public C4244g(long j10) {
        C4248k c4248k = new C4248k();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i6 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i6 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.f14416d = j10;
        this.f14413a = c4248k;
        this.f14414b = setUnmodifiableSet;
        this.f14415c = new C3388b(11);
    }

    @Override
    public final void mo6922a(int i6) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i6);
        }
        if (i6 >= 40 || (Build.VERSION.SDK_INT >= 23 && i6 >= 20)) {
            mo6927j();
        } else if (i6 >= 20 || i6 == 15) {
            m8295g(this.f14416d / 2);
        }
    }

    public final void m8293b() {
        Log.v("LruBitmapPool", "Hits=" + this.f14418f + ", misses=" + this.f14419g + ", puts=" + this.f14420h + ", evictions=" + this.f14421i + ", currentSize=" + this.f14417e + ", maxSize=" + this.f14416d + "\nStrategy=" + this.f14413a);
    }

    public final synchronized Bitmap m8294c(int i6, int i10, Bitmap.Config config) {
        Bitmap bitmapM8298b;
        try {
            if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
                throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            }
            bitmapM8298b = this.f14413a.m8298b(i6, i10, config != null ? config : f14412j);
            if (bitmapM8298b == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb = new StringBuilder("Missing bitmap=");
                    this.f14413a.getClass();
                    sb.append(C4248k.m8296c(AbstractC3610n.m7236d(config) * i6 * i10, config));
                    Log.d("LruBitmapPool", sb.toString());
                }
                this.f14419g++;
            } else {
                this.f14418f++;
                long j10 = this.f14417e;
                this.f14413a.getClass();
                this.f14417e = j10 - ((long) AbstractC3610n.m7235c(bitmapM8298b));
                this.f14415c.getClass();
                bitmapM8298b.setHasAlpha(true);
                bitmapM8298b.setPremultiplied(true);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb2 = new StringBuilder("Get bitmap=");
                this.f14413a.getClass();
                sb2.append(C4248k.m8296c(AbstractC3610n.m7236d(config) * i6 * i10, config));
                Log.v("LruBitmapPool", sb2.toString());
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                m8293b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return bitmapM8298b;
    }

    @Override
    public final Bitmap mo6924d(int i6, int i10, Bitmap.Config config) {
        Bitmap bitmapM8294c = m8294c(i6, i10, config);
        if (bitmapM8294c != null) {
            return bitmapM8294c;
        }
        if (config == null) {
            config = f14412j;
        }
        return Bitmap.createBitmap(i6, i10, config);
    }

    @Override
    public final Bitmap mo6925e(int i6, int i10, Bitmap.Config config) {
        Bitmap bitmapM8294c = m8294c(i6, i10, config);
        if (bitmapM8294c != null) {
            bitmapM8294c.eraseColor(0);
            return bitmapM8294c;
        }
        if (config == null) {
            config = f14412j;
        }
        return Bitmap.createBitmap(i6, i10, config);
    }

    @Override
    public final synchronized void mo5434f(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable()) {
                this.f14413a.getClass();
                if (AbstractC3610n.m7235c(bitmap) <= this.f14416d && this.f14414b.contains(bitmap.getConfig())) {
                    this.f14413a.getClass();
                    int iM7235c = AbstractC3610n.m7235c(bitmap);
                    this.f14413a.m8300e(bitmap);
                    this.f14415c.getClass();
                    this.f14420h++;
                    this.f14417e += (long) iM7235c;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb = new StringBuilder("Put bitmap in pool=");
                        this.f14413a.getClass();
                        sb.append(C4248k.m8296c(AbstractC3610n.m7235c(bitmap), bitmap.getConfig()));
                        Log.v("LruBitmapPool", sb.toString());
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        m8293b();
                    }
                    m8295g(this.f14416d);
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb2 = new StringBuilder("Reject bitmap from pool, bitmap: ");
                this.f14413a.getClass();
                sb2.append(C4248k.m8296c(AbstractC3610n.m7235c(bitmap), bitmap.getConfig()));
                sb2.append(", is mutable: ");
                sb2.append(bitmap.isMutable());
                sb2.append(", is allowed config: ");
                sb2.append(this.f14414b.contains(bitmap.getConfig()));
                Log.v("LruBitmapPool", sb2.toString());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void m8295g(long j10) {
        while (this.f14417e > j10) {
            try {
                C4248k c4248k = this.f14413a;
                Bitmap bitmap = (Bitmap) c4248k.f14432b.m6038A();
                if (bitmap != null) {
                    c4248k.m8297a(Integer.valueOf(AbstractC3610n.m7235c(bitmap)), bitmap);
                }
                if (bitmap == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        m8293b();
                    }
                    this.f14417e = 0L;
                    return;
                }
                this.f14415c.getClass();
                long j11 = this.f14417e;
                this.f14413a.getClass();
                this.f14417e = j11 - ((long) AbstractC3610n.m7235c(bitmap));
                this.f14421i++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Evicting bitmap=");
                    this.f14413a.getClass();
                    sb.append(C4248k.m8296c(AbstractC3610n.m7235c(bitmap), bitmap.getConfig()));
                    Log.d("LruBitmapPool", sb.toString());
                }
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    m8293b();
                }
                bitmap.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final void mo6927j() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        m8295g(0L);
    }
}
