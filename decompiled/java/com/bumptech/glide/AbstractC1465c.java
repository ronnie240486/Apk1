package com.bumptech.glide;

import android.animation.ObjectAnimator;
import android.app.AppOpsManager;
import android.content.Context;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.media.MediaBrowserCompat;
import android.transition.TransitionValues;
import android.util.Log;
import android.util.Property;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.CompoundButton;
import androidx.appcompat.widget.C0233l2;
import androidx.core.app.AbstractC0326f;
import androidx.core.app.AbstractC0328g;
import androidx.core.widget.AbstractC0370c;
import androidx.leanback.transition.C0446g;
import androidx.leanback.transition.FadeAndShortSlide;
import com.p2serv.android.p032ds.R;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.Objects;
import p008a9.C0072b;
import p008a9.C0080j;
import p008a9.InterfaceC0079i;
import p024c1.C1378b;
import p103j9.AbstractC2796i;
import p156o9.C3282f;
import p156o9.C3284h;

public abstract class AbstractC1465c {

    public static Field f4413a;

    public static boolean f4414b;

    public static boolean m3467b(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        if (bundle == null) {
            return bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1;
        }
        if (bundle2 == null) {
            return bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1;
        }
        return bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) && bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
    }

    public static void m3468c(long j10, String str) {
        if (j10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " (" + j10 + ") must be >= 0");
    }

    public static void m3469d(boolean z7) {
        if (!z7) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }

    public static int m3470e(Context context, String str) {
        int iM960a;
        int iMyPid = Process.myPid();
        int iMyUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, iMyPid, iMyUid) == -1) {
            return -1;
        }
        int i6 = Build.VERSION.SDK_INT;
        String strM957d = i6 >= 23 ? AbstractC0326f.m957d(str) : null;
        if (strM957d != null) {
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(iMyUid);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                packageName = packagesForUid[0];
            }
            int iMyUid2 = Process.myUid();
            String packageName2 = context.getPackageName();
            int iM956c = 1;
            if (iMyUid2 == iMyUid && Objects.equals(packageName2, packageName)) {
                if (i6 >= 29) {
                    AppOpsManager appOpsManagerM962c = AbstractC0328g.m962c(context);
                    iM960a = AbstractC0328g.m960a(appOpsManagerM962c, strM957d, Binder.getCallingUid(), packageName);
                    if (iM960a == 0) {
                        iM960a = AbstractC0328g.m960a(appOpsManagerM962c, strM957d, iMyUid, AbstractC0328g.m961b(context));
                    }
                } else if (i6 >= 23) {
                    iM956c = AbstractC0326f.m956c((AppOpsManager) AbstractC0326f.m954a(context, AppOpsManager.class), strM957d, packageName);
                }
                if (iM960a != 0) {
                    return -2;
                }
            } else if (i6 >= 23) {
                iM956c = AbstractC0326f.m956c((AppOpsManager) AbstractC0326f.m954a(context, AppOpsManager.class), strM957d, packageName);
            }
            iM960a = iM956c;
            if (iM960a != 0) {
                return -2;
            }
        }
        return 0;
    }

    public static ObjectAnimator m3471f(View view, TransitionValues transitionValues, int i6, int i10, float f, float f3, float f4, float f5, DecelerateInterpolator decelerateInterpolator, FadeAndShortSlide fadeAndShortSlide) {
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(R.id.transitionPosition);
        if (iArr != null) {
            f = (iArr[0] - i6) + translationX;
            f3 = (iArr[1] - i10) + translationY;
        }
        int iRound = Math.round(f - translationX) + i6;
        int iRound2 = Math.round(f3 - translationY) + i10;
        view.setTranslationX(f);
        view.setTranslationY(f3);
        if (f == f4 && f3 == f5) {
            return null;
        }
        Path path = new Path();
        path.moveTo(f, f3);
        path.lineTo(f4, f5);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, (Property<View, Float>) View.TRANSLATION_Y, path);
        C0446g c0446g = new C0446g(view, transitionValues.view, iRound, iRound2, translationX, translationY);
        fadeAndShortSlide.addListener(c0446g);
        objectAnimatorOfFloat.addListener(c0446g);
        objectAnimatorOfFloat.addPauseListener(c0446g);
        objectAnimatorOfFloat.setInterpolator(decelerateInterpolator);
        return objectAnimatorOfFloat;
    }

    public static Drawable m3472g(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AbstractC0370c.m1121a(compoundButton);
        }
        if (!f4414b) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f4413a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e5) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e5);
            }
            f4414b = true;
        }
        Field field = f4413a;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e10) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e10);
                f4413a = null;
            }
        }
        return null;
    }

    public static Drawable m3473h(Context context, int i6) {
        return C0233l2.m720d().m727f(context, i6);
    }

    public static boolean m3474i(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static InterfaceC0079i m3475j(InterfaceC0079i interfaceC0079i, InterfaceC0079i interfaceC0079i2) {
        AbstractC2796i.m5785f(interfaceC0079i2, "context");
        return interfaceC0079i2 == C0080j.f206a ? interfaceC0079i : (InterfaceC0079i) interfaceC0079i2.mo250a(interfaceC0079i, new C0072b(1));
    }

    public static C1378b m3476k(MappedByteBuffer mappedByteBuffer) throws IOException {
        long j10;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
        int i6 = byteBufferDuplicate.getShort() & 65535;
        if (i6 > 100) {
            throw new IOException("Cannot read metadata.");
        }
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 6);
        int i10 = 0;
        while (true) {
            if (i10 >= i6) {
                j10 = -1;
                break;
            }
            int i11 = byteBufferDuplicate.getInt();
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            j10 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            if (1835365473 == i11) {
                break;
            }
            i10++;
        }
        if (j10 != -1) {
            byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) (j10 - ((long) byteBufferDuplicate.position()))));
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 12);
            long j11 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            for (int i12 = 0; i12 < j11; i12++) {
                int i13 = byteBufferDuplicate.getInt();
                long j12 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
                byteBufferDuplicate.getInt();
                if (1164798569 == i13 || 1701669481 == i13) {
                    byteBufferDuplicate.position((int) (j12 + j10));
                    C1378b c1378b = new C1378b();
                    byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                    c1378b.f4194d = byteBufferDuplicate;
                    c1378b.f4191a = iPosition;
                    int i14 = iPosition - byteBufferDuplicate.getInt(iPosition);
                    c1378b.f4192b = i14;
                    c1378b.f4193c = ((ByteBuffer) c1378b.f4194d).getShort(i14);
                    return c1378b;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static TypedValue m3477l(Context context, int i6) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i6, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static int m3478m(Context context, int i6, String str) {
        TypedValue typedValueM3477l = m3477l(context, i6);
        if (typedValueM3477l != null) {
            return typedValueM3477l.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i6)));
    }

    public static C3282f m3479n(C3284h c3284h, int i6) {
        AbstractC2796i.m5785f(c3284h, "<this>");
        boolean z7 = i6 > 0;
        Integer numValueOf = Integer.valueOf(i6);
        if (z7) {
            if (c3284h.f10991c <= 0) {
                i6 = -i6;
            }
            return new C3282f(c3284h.f10989a, c3284h.f10990b, i6);
        }
        throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
    }

    public static C3284h m3480o(int i6, int i10) {
        if (i10 > Integer.MIN_VALUE) {
            return new C3284h(i6, i10 - 1, 1);
        }
        C3284h c3284h = C3284h.f10996d;
        return C3284h.f10996d;
    }

    public abstract AbstractC1465c mo3481a(Serializable serializable);
}
