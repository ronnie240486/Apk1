package p014b1;

import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.leanback.widget.RunnableC0485n0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p001a0.C0023f;
import p003a2.AbstractC0032a;
import p007a7.C0069f;
import p160p.C3342f;

public final class C1235i {

    public static final Object f3922i = new Object();

    public static volatile C1235i f3923j;

    public final ReentrantReadWriteLock f3924a;

    public final C3342f f3925b;

    public volatile int f3926c;

    public final Handler f3927d;

    public final C1232f f3928e;

    public final InterfaceC1234h f3929f;

    public final int f3930g;

    public final C1230d f3931h;

    public C1235i(C1242p c1242p) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f3924a = reentrantReadWriteLock;
        this.f3926c = 3;
        InterfaceC1234h interfaceC1234h = c1242p.f3956a;
        this.f3929f = interfaceC1234h;
        int i6 = c1242p.f3957b;
        this.f3930g = i6;
        this.f3931h = c1242p.f3958c;
        this.f3927d = new Handler(Looper.getMainLooper());
        this.f3925b = new C3342f(0);
        C1232f c1232f = new C1232f(this);
        this.f3928e = c1232f;
        reentrantReadWriteLock.writeLock().lock();
        if (i6 == 0) {
            try {
                this.f3926c = 0;
            } catch (Throwable th) {
                this.f3924a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (m3107b() == 0) {
            try {
                interfaceC1234h.mo204a(new C1231e(c1232f));
            } catch (Throwable th2) {
                m3109d(th2);
            }
        }
    }

    public static C1235i m3106a() {
        C1235i c1235i;
        synchronized (f3922i) {
            try {
                c1235i = f3923j;
                if (!(c1235i != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c1235i;
    }

    public final int m3107b() {
        this.f3924a.readLock().lock();
        try {
            return this.f3926c;
        } finally {
            this.f3924a.readLock().unlock();
        }
    }

    public final void m3108c() {
        if (!(this.f3930g == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (m3107b() == 1) {
            return;
        }
        this.f3924a.writeLock().lock();
        try {
            if (this.f3926c == 0) {
                this.f3924a.writeLock().unlock();
                return;
            }
            this.f3926c = 0;
            this.f3924a.writeLock().unlock();
            C1232f c1232f = this.f3928e;
            C1235i c1235i = c1232f.f3919a;
            try {
                c1235i.f3929f.mo204a(new C1231e(c1232f));
            } catch (Throwable th) {
                c1235i.m3109d(th);
            }
        } catch (Throwable th2) {
            this.f3924a.writeLock().unlock();
            throw th2;
        }
    }

    public final void m3109d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f3924a.writeLock().lock();
        try {
            this.f3926c = 2;
            arrayList.addAll(this.f3925b);
            this.f3925b.clear();
            this.f3924a.writeLock().unlock();
            this.f3927d.post(new RunnableC0485n0(arrayList, this.f3926c, th));
        } catch (Throwable th2) {
            this.f3924a.writeLock().unlock();
            throw th2;
        }
    }

    public final CharSequence m3110e(CharSequence charSequence, int i6, int i10) {
        int iCharCount;
        C1246t[] c1246tArr;
        if (!(m3107b() == 1)) {
            throw new IllegalStateException("Not initialized yet");
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("start cannot be negative");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("end cannot be negative");
        }
        AbstractC0032a.m160n("start should be <= than end", i6 <= i10);
        C1248v c1248v = null;
        if (charSequence == null) {
            return null;
        }
        AbstractC0032a.m160n("start should be < than charSequence length", i6 <= charSequence.length());
        AbstractC0032a.m160n("end should be < than charSequence length", i10 <= charSequence.length());
        if (charSequence.length() == 0 || i6 == i10) {
            return charSequence;
        }
        C0069f c0069f = this.f3928e.f3920b;
        c0069f.getClass();
        boolean z7 = charSequence instanceof C1245s;
        if (z7) {
            ((C1245s) charSequence).m3124a();
        }
        if (z7) {
            c1248v = new C1248v((Spannable) charSequence);
        } else {
            try {
                if (charSequence instanceof Spannable) {
                    c1248v = new C1248v((Spannable) charSequence);
                } else if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i6 - 1, i10 + 1, C1246t.class) <= i10) {
                    c1248v = new C1248v(charSequence);
                }
            } finally {
                if (z7) {
                    ((C1245s) charSequence).m3125b();
                }
            }
        }
        if (c1248v != null && (c1246tArr = (C1246t[]) c1248v.f3969b.getSpans(i6, i10, C1246t.class)) != null && c1246tArr.length > 0) {
            for (C1246t c1246t : c1246tArr) {
                int spanStart = c1248v.f3969b.getSpanStart(c1246t);
                int spanEnd = c1248v.f3969b.getSpanEnd(c1246t);
                if (spanStart != i10) {
                    c1248v.removeSpan(c1246t);
                }
                i6 = Math.min(spanStart, i6);
                i10 = Math.max(spanEnd, i10);
            }
        }
        if (i6 != i10 && i6 < charSequence.length()) {
            C1240n c1240n = new C1240n((C1243q) ((C0023f) c0069f.f196b).f46d);
            C1248v c1248v2 = c1248v;
            int iCodePointAt = Character.codePointAt(charSequence, i6);
            int i11 = 0;
            loop1: while (true) {
                iCharCount = i6;
                while (true) {
                    if (i6 >= i10 || i11 >= Integer.MAX_VALUE) {
                        break loop1;
                    }
                    int iM3116a = c1240n.m3116a(iCodePointAt);
                    if (iM3116a == 1) {
                        iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                        if (iCharCount < i10) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        }
                        i6 = iCharCount;
                    } else if (iM3116a == 2) {
                        i6 += Character.charCount(iCodePointAt);
                        if (i6 < i10) {
                            iCodePointAt = Character.codePointAt(charSequence, i6);
                        }
                    } else if (iM3116a != 3) {
                    }
                }
                if (!c0069f.m221D(charSequence, iCharCount, i6, ((C1243q) c1240n.f3946f).f3960b)) {
                    if (c1248v2 == null) {
                        c1248v2 = new C1248v((Spannable) new SpannableString(charSequence));
                    }
                    c1248v2.setSpan(new C1246t(((C1243q) c1240n.f3946f).f3960b), iCharCount, i6, 33);
                    i11++;
                }
            }
            if (c1240n.f3941a == 2 && ((C1243q) c1240n.f3945e).f3960b != null && ((c1240n.f3943c > 1 || c1240n.m3119d()) && i11 < Integer.MAX_VALUE && !c0069f.m221D(charSequence, iCharCount, i6, ((C1243q) c1240n.f3945e).f3960b))) {
                if (c1248v2 == null) {
                    c1248v2 = new C1248v(charSequence);
                }
                c1248v2.setSpan(new C1246t(((C1243q) c1240n.f3945e).f3960b), iCharCount, i6, 33);
            }
            if (c1248v2 != null) {
                return c1248v2.f3969b;
            }
            if (!z7) {
                return charSequence;
            }
        } else if (!z7) {
            return charSequence;
        }
        return charSequence;
    }

    public final void m3111f(AbstractC1233g abstractC1233g) {
        AbstractC0032a.m162p(abstractC1233g, "initCallback cannot be null");
        this.f3924a.writeLock().lock();
        try {
            if (this.f3926c == 1 || this.f3926c == 2) {
                this.f3927d.post(new RunnableC0485n0(Arrays.asList(abstractC1233g), this.f3926c, (Throwable) null));
            } else {
                this.f3925b.add(abstractC1233g);
            }
        } finally {
            this.f3924a.writeLock().unlock();
        }
    }
}
