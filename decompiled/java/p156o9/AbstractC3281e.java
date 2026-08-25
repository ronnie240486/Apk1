package p156o9;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.Spanned;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.bumptech.glide.AbstractC1465c;
import com.bumptech.glide.C1468f;
import com.bumptech.glide.C1472j;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import com.bumptech.glide.load.data.C1482h;
import com.bumptech.glide.load.data.C1487m;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.FileSystem;
import okio.Path;
import p001a0.C0019b;
import p002a1.C0026b;
import p007a7.C0069f;
import p016b3.C1259a;
import p016b3.C1263c;
import p016b3.C1264c0;
import p016b3.C1268e0;
import p016b3.C1271g;
import p016b3.C1272g0;
import p016b3.C1273h;
import p016b3.C1277j;
import p016b3.C1278k;
import p026c3.C1393b;
import p026c3.C1396e;
import p028c6.C1399b;
import p049e3.C2377a;
import p049e3.C2379b;
import p049e3.C2380b0;
import p049e3.C2381c;
import p049e3.C2387f;
import p049e3.C2388f0;
import p049e3.C2389g;
import p049e3.C2395m;
import p049e3.C2398p;
import p049e3.C2402t;
import p056f0.AbstractC2478a;
import p059f6.C2492a;
import p059f6.C2493b;
import p059f6.C2495d;
import p059f6.InterfaceC2496e;
import p068g3.C2607a;
import p068g3.C2610d;
import p086i3.C2686b;
import p086i3.C2688d;
import p086i3.C2695k;
import p091i9.InterfaceC2724l;
import p097j3.C2772c;
import p097j3.C2773d;
import p103j9.AbstractC2796i;
import p119l1.CallableC2961b;
import p121l3.InterfaceC2971a;
import p208t2.C3803d;
import p221u6.C3905e;
import p222u7.AbstractC3928d;
import p228v2.InterfaceC3983j;
import p249x4.C4112e;
import p253x8.AbstractC4143f;
import p259y2.C4243f;
import p259y2.InterfaceC4238a;

public abstract class AbstractC3281e {

    public static Boolean f10984a;

    public static Boolean f10985b;

    public static Boolean f10986c;

    public static Boolean f10987d;

    public static SharedPreferences f10988e;

    public static void m6611A(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static void m6612H(TextView textView, CharSequence charSequence) {
        CharSequence text = textView.getText();
        if (charSequence != text) {
            if (charSequence == null && text.length() == 0) {
                return;
            }
            if (!(charSequence instanceof Spanned)) {
                if ((charSequence == null) == (text == null)) {
                    if (charSequence == null) {
                        return;
                    }
                    int length = charSequence.length();
                    if (length == text.length()) {
                        for (int i6 = 0; i6 < length; i6++) {
                            if (charSequence.charAt(i6) == text.charAt(i6)) {
                            }
                        }
                        return;
                    }
                }
            } else if (charSequence.equals(text)) {
                return;
            }
            textView.setText(charSequence);
        }
    }

    public static boolean m6613I(Context context) {
        ApplicationInfo applicationInfo;
        Intent intentPutExtra = new Intent().addFlags(268435456).setAction("com.android.settings.panel.action.MEDIA_OUTPUT").putExtra("com.android.settings.panel.extra.PACKAGE_NAME", context.getPackageName());
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intentPutExtra, 0).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && (applicationInfo = activityInfo.applicationInfo) != null && (applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) != 0) {
                intentPutExtra.setPackage(applicationInfo.packageName);
                context.startActivity(intentPutExtra);
                return true;
            }
        }
        return false;
    }

    public static SharedPreferences m6614J(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            try {
                if (f10988e == null) {
                    f10988e = (SharedPreferences) AbstractC3928d.m7839A(new CallableC2961b(1, context));
                }
                sharedPreferences = f10988e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sharedPreferences;
    }

    public static final boolean m6615c(Object[] objArr, int i6, int i10, List list) {
        if (i10 != list.size()) {
            return false;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (!AbstractC2796i.m5780a(objArr[i6 + i11], list.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public static final String m6616d(Object[] objArr, int i6, int i10, AbstractC4143f abstractC4143f) {
        StringBuilder sb = new StringBuilder((i10 * 3) + 2);
        sb.append("[");
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i6 + i11];
            if (obj == abstractC4143f) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        String string = sb.toString();
        AbstractC2796i.m5784e(string, "toString(...)");
        return string;
    }

    public static void m6617g(StringBuilder sb, Object obj, InterfaceC2724l interfaceC2724l) {
        if (interfaceC2724l != null) {
            sb.append((CharSequence) interfaceC2724l.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    public static boolean m6618h(int i6, Rect rect, Rect rect2, Rect rect3) {
        int iM6635y;
        int i10;
        int i11;
        boolean zM6619i = m6619i(i6, rect, rect2);
        if (m6619i(i6, rect, rect3) || !zM6619i) {
            return false;
        }
        if (i6 != 17) {
            if (i6 != 33) {
                if (i6 != 66) {
                    if (i6 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    if (rect.bottom <= rect3.top) {
                        if (i6 != 17 && i6 != 66) {
                            iM6635y = m6635y(i6, rect, rect2);
                            if (i6 != 17) {
                                i10 = rect.left;
                                i11 = rect3.left;
                            } else if (i6 != 33) {
                                i10 = rect.top;
                                i11 = rect3.top;
                            } else if (i6 != 66) {
                                i10 = rect3.right;
                                i11 = rect.right;
                            } else {
                                if (i6 == 130) {
                                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                                }
                                i10 = rect3.bottom;
                                i11 = rect.bottom;
                            }
                            if (iM6635y < Math.max(1, i10 - i11)) {
                                return true;
                            }
                            return false;
                        }
                    }
                } else if (rect.right <= rect3.left) {
                    if (i6 != 17) {
                        iM6635y = m6635y(i6, rect, rect2);
                        if (i6 != 17) {
                            i10 = rect.left;
                            i11 = rect3.left;
                        } else if (i6 != 33) {
                            i10 = rect.top;
                            i11 = rect3.top;
                        } else if (i6 != 66) {
                            i10 = rect3.right;
                            i11 = rect.right;
                        } else {
                            if (i6 == 130) {
                                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                            }
                            i10 = rect3.bottom;
                            i11 = rect.bottom;
                        }
                        if (iM6635y < Math.max(1, i10 - i11)) {
                            return true;
                        }
                        return false;
                    }
                }
            } else if (rect.top >= rect3.bottom) {
                if (i6 != 17) {
                    iM6635y = m6635y(i6, rect, rect2);
                    if (i6 != 17) {
                        i10 = rect.left;
                        i11 = rect3.left;
                    } else if (i6 != 33) {
                        i10 = rect.top;
                        i11 = rect3.top;
                    } else if (i6 != 66) {
                        i10 = rect3.right;
                        i11 = rect.right;
                    } else {
                        if (i6 == 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                        i10 = rect3.bottom;
                        i11 = rect.bottom;
                    }
                    if (iM6635y < Math.max(1, i10 - i11)) {
                        return true;
                    }
                    return false;
                }
            }
        } else if (rect.left >= rect3.right) {
            if (i6 != 17) {
                iM6635y = m6635y(i6, rect, rect2);
                if (i6 != 17) {
                    i10 = rect.left;
                    i11 = rect3.left;
                } else if (i6 != 33) {
                    i10 = rect.top;
                    i11 = rect3.top;
                } else if (i6 != 66) {
                    i10 = rect3.right;
                    i11 = rect.right;
                } else {
                    if (i6 == 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    i10 = rect3.bottom;
                    i11 = rect.bottom;
                }
                if (iM6635y < Math.max(1, i10 - i11)) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public static boolean m6619i(int i6, Rect rect, Rect rect2) {
        if (i6 != 17) {
            if (i6 != 33) {
                if (i6 != 66) {
                    if (i6 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static int m6620j(int i6, int i10) {
        return AbstractC2478a.m5513h(i6, (Color.alpha(i6) * i10) / 255);
    }

    public static byte[] m6621k(byte[] bArr, int i6, int i10) {
        int i11 = i10 - i6;
        if (i11 >= 0) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i6, bArr2, 0, Math.min(bArr.length - i6, i11));
            return bArr2;
        }
        throw new IllegalArgumentException(i6 + " > " + i10);
    }

    public static C1472j m6622l(ComponentCallbacks2C1464b componentCallbacks2C1464b, ArrayList arrayList) {
        InterfaceC3983j c2387f;
        InterfaceC3983j c2377a;
        InterfaceC4238a interfaceC4238a = componentCallbacks2C1464b.f4406a;
        C1468f c1468f = componentCallbacks2C1464b.f4408c;
        Context applicationContext = c1468f.getApplicationContext();
        C0019b c0019b = c1468f.f4438h;
        C1472j c1472j = new C1472j();
        C2395m c2395m = new C2395m();
        C2772c c2772c = c1472j.f4452g;
        synchronized (c2772c) {
            c2772c.f9487a.add(c2395m);
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 27) {
            c1472j.m3531k(new C2402t());
        }
        Resources resources = applicationContext.getResources();
        ArrayList arrayListM3526f = c1472j.m3526f();
        C4243f c4243f = componentCallbacks2C1464b.f4409d;
        C2686b c2686b = new C2686b(applicationContext, arrayListM3526f, interfaceC4238a, c4243f);
        C2388f0 c2388f0 = new C2388f0(interfaceC4238a, new C4112e(10));
        C2398p c2398p = new C2398p(c1472j.m3526f(), resources.getDisplayMetrics(), interfaceC4238a, c4243f);
        if (i6 < 28 || !((Map) c0019b.f38b).containsKey(AbstractC1465c.class)) {
            c2387f = new C2387f(c2398p, 0);
            c2377a = new C2377a(c2398p, 2, c4243f);
        } else {
            c2377a = new C2389g(1);
            c2387f = new C2389g(0);
        }
        if (i6 >= 28) {
            c1472j.m3524d("Animation", InputStream.class, Drawable.class, new C2607a(1, new C0069f(19, arrayListM3526f, c4243f, false)));
            c1472j.m3524d("Animation", ByteBuffer.class, Drawable.class, new C2607a(0, new C0069f(19, arrayListM3526f, c4243f, false)));
        }
        C2610d c2610d = new C2610d(applicationContext);
        C2379b c2379b = new C2379b(c4243f);
        C1399b c1399b = new C1399b(1);
        C2773d c2773d = new C2773d(1);
        ContentResolver contentResolver = applicationContext.getContentResolver();
        c1472j.m3522b(ByteBuffer.class, new C1263c(2));
        c1472j.m3522b(InputStream.class, new C0019b(10, c4243f));
        c1472j.m3524d("Bitmap", ByteBuffer.class, Bitmap.class, c2387f);
        c1472j.m3524d("Bitmap", InputStream.class, Bitmap.class, c2377a);
        String str = Build.FINGERPRINT;
        if (!"robolectric".equals(str)) {
            c1472j.m3524d("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new C2387f(c2398p, 1));
        }
        c1472j.m3524d("Bitmap", AssetFileDescriptor.class, Bitmap.class, new C2388f0(interfaceC4238a, new C3905e(9)));
        c1472j.m3524d("Bitmap", ParcelFileDescriptor.class, Bitmap.class, c2388f0);
        C1268e0 c1268e0 = C1268e0.f4008b;
        c1472j.m3521a(Bitmap.class, Bitmap.class, c1268e0);
        c1472j.m3524d("Bitmap", Bitmap.class, Bitmap.class, new C2380b0(0));
        c1472j.m3523c(Bitmap.class, c2379b);
        c1472j.m3524d("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new C2377a(resources, c2387f));
        c1472j.m3524d("BitmapDrawable", InputStream.class, BitmapDrawable.class, new C2377a(resources, c2377a));
        c1472j.m3524d("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new C2377a(resources, c2388f0));
        c1472j.m3523c(BitmapDrawable.class, new C0069f(17, interfaceC4238a, c2379b, false));
        c1472j.m3524d("Animation", InputStream.class, C2688d.class, new C2695k(arrayListM3526f, c2686b, c4243f));
        c1472j.m3524d("Animation", ByteBuffer.class, C2688d.class, c2686b);
        c1472j.m3523c(C2688d.class, new C4112e(14));
        c1472j.m3521a(C3803d.class, C3803d.class, c1268e0);
        c1472j.m3524d("Bitmap", C3803d.class, Bitmap.class, new C2381c(interfaceC4238a));
        c1472j.m3524d("legacy_append", Uri.class, Drawable.class, c2610d);
        c1472j.m3524d("legacy_append", Uri.class, Bitmap.class, new C2377a(c2610d, 1, interfaceC4238a));
        c1472j.m3529i(new C1482h(2));
        c1472j.m3521a(File.class, ByteBuffer.class, new C1268e0(3));
        c1472j.m3521a(File.class, InputStream.class, new C1277j(new C1263c(5)));
        c1472j.m3524d("legacy_append", File.class, File.class, new C2380b0(2));
        c1472j.m3521a(File.class, ParcelFileDescriptor.class, new C1277j(new C1263c(4)));
        c1472j.m3521a(File.class, File.class, c1268e0);
        c1472j.m3529i(new C1487m(c4243f));
        if (!"robolectric".equals(str)) {
            c1472j.m3529i(new C1482h(1));
        }
        C1273h c1273h = new C1273h(applicationContext, 2);
        C1273h c1273h2 = new C1273h(applicationContext, 0);
        C1273h c1273h3 = new C1273h(applicationContext, 1);
        Class cls = Integer.TYPE;
        c1472j.m3521a(cls, InputStream.class, c1273h);
        c1472j.m3521a(Integer.class, InputStream.class, c1273h);
        c1472j.m3521a(cls, AssetFileDescriptor.class, c1273h2);
        c1472j.m3521a(Integer.class, AssetFileDescriptor.class, c1273h2);
        c1472j.m3521a(cls, Drawable.class, c1273h3);
        c1472j.m3521a(Integer.class, Drawable.class, c1273h3);
        c1472j.m3521a(Uri.class, InputStream.class, new C1273h(applicationContext, 5));
        c1472j.m3521a(Uri.class, AssetFileDescriptor.class, new C1273h(applicationContext, 4));
        C1264c0 c1264c0 = new C1264c0(resources, 2);
        C1264c0 c1264c1 = new C1264c0(resources, 0);
        C1264c0 c1264c2 = new C1264c0(resources, 1);
        c1472j.m3521a(Integer.class, Uri.class, c1264c0);
        c1472j.m3521a(cls, Uri.class, c1264c0);
        c1472j.m3521a(Integer.class, AssetFileDescriptor.class, c1264c1);
        c1472j.m3521a(cls, AssetFileDescriptor.class, c1264c1);
        c1472j.m3521a(Integer.class, InputStream.class, c1264c2);
        c1472j.m3521a(cls, InputStream.class, c1264c2);
        c1472j.m3521a(String.class, InputStream.class, new C1271g(0));
        c1472j.m3521a(Uri.class, InputStream.class, new C1271g(0));
        c1472j.m3521a(String.class, InputStream.class, new C1268e0(6));
        c1472j.m3521a(String.class, ParcelFileDescriptor.class, new C1268e0(5));
        c1472j.m3521a(String.class, AssetFileDescriptor.class, new C1268e0(4));
        c1472j.m3521a(Uri.class, InputStream.class, new C1259a(applicationContext.getAssets(), 1));
        c1472j.m3521a(Uri.class, AssetFileDescriptor.class, new C1259a(applicationContext.getAssets(), 0));
        c1472j.m3521a(Uri.class, InputStream.class, new C1273h(applicationContext, 6));
        c1472j.m3521a(Uri.class, InputStream.class, new C1273h(applicationContext, 7));
        if (i6 >= 29) {
            c1472j.m3521a(Uri.class, InputStream.class, new C1393b(applicationContext, InputStream.class));
            c1472j.m3521a(Uri.class, ParcelFileDescriptor.class, new C1393b(applicationContext, ParcelFileDescriptor.class));
        }
        c1472j.m3521a(Uri.class, InputStream.class, new C1272g0(contentResolver, 2));
        c1472j.m3521a(Uri.class, ParcelFileDescriptor.class, new C1272g0(contentResolver, 1));
        c1472j.m3521a(Uri.class, AssetFileDescriptor.class, new C1272g0(contentResolver, 0));
        c1472j.m3521a(Uri.class, InputStream.class, new C1268e0(7));
        c1472j.m3521a(URL.class, InputStream.class, new C1396e());
        c1472j.m3521a(Uri.class, File.class, new C1273h(applicationContext, 3));
        c1472j.m3521a(C1278k.class, InputStream.class, new C1271g(1));
        c1472j.m3521a(byte[].class, ByteBuffer.class, new C1268e0(1));
        c1472j.m3521a(byte[].class, InputStream.class, new C1268e0(2));
        c1472j.m3521a(Uri.class, Uri.class, c1268e0);
        c1472j.m3521a(Drawable.class, Drawable.class, c1268e0);
        c1472j.m3524d("legacy_append", Drawable.class, Drawable.class, new C2380b0(1));
        c1472j.m3530j(Bitmap.class, BitmapDrawable.class, new C0019b(29, resources));
        c1472j.m3530j(Bitmap.class, byte[].class, c1399b);
        c1472j.m3530j(Drawable.class, byte[].class, new C0026b(interfaceC4238a, c1399b, c2773d, 21));
        c1472j.m3530j(C2688d.class, byte[].class, c2773d);
        if (i6 >= 23) {
            C2388f0 c2388f1 = new C2388f0(interfaceC4238a, new C4112e(9));
            c1472j.m3524d("legacy_append", ByteBuffer.class, Bitmap.class, c2388f1);
            c1472j.m3524d("legacy_append", ByteBuffer.class, BitmapDrawable.class, new C2377a(resources, c2388f1));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            InterfaceC2971a interfaceC2971a = (InterfaceC2971a) it.next();
            try {
                interfaceC2971a.mo3519a(c1472j);
            } catch (AbstractMethodError e5) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ".concat(interfaceC2971a.getClass().getName()), e5);
            }
        }
        return c1472j;
    }

    public static AnimatorSet m6623m(InterfaceC2496e interfaceC2496e, float f, float f3, float f4) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(interfaceC2496e, C2493b.f8722a, C2492a.f8720b, new C2495d(f, f3, f4));
        C2495d revealInfo = interfaceC2496e.getRevealInfo();
        if (revealInfo == null) {
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal((View) interfaceC2496e, (int) f, (int) f3, revealInfo.f8726c, f4);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, animatorCreateCircularReveal);
        return animatorSet;
    }

    public static String m6624n(int i6) {
        String strConcat = System.currentTimeMillis() + "";
        while (strConcat.length() < 13) {
            strConcat = SessionDescription.SUPPORTED_SDP_VERSION.concat(strConcat);
        }
        return strConcat + "-" + i6 + ' ';
    }

    public static final void m6625o(FileSystem fileSystem, Path path) throws IOException {
        try {
            IOException iOException = null;
            for (Path path2 : fileSystem.list(path)) {
                try {
                    if (fileSystem.metadata(path2).isDirectory()) {
                        m6625o(fileSystem, path2);
                    }
                    fileSystem.delete(path2);
                } catch (IOException e5) {
                    if (iOException == null) {
                        iOException = e5;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }

    public static int m6626p(int i6, View view) {
        return AbstractC1465c.m3478m(view.getContext(), i6, view.getClass().getCanonicalName());
    }

    public static int m6627q(Context context, int i6, int i10) {
        TypedValue typedValueM3477l = AbstractC1465c.m3477l(context, i6);
        return typedValueM3477l != null ? typedValueM3477l.data : i10;
    }

    public static boolean m6628r(byte[] bArr) {
        if (bArr == null || bArr.length <= 15 || bArr[13] != 45) {
            return false;
        }
        int i6 = 0;
        while (true) {
            if (i6 >= bArr.length) {
                i6 = -1;
                break;
            }
            if (bArr[i6] == 32) {
                break;
            }
            i6++;
        }
        return i6 > 14;
    }

    public static boolean m6629s(int i6, Rect rect, Rect rect2) {
        if (i6 == 17) {
            int i10 = rect.right;
            int i11 = rect2.right;
            return (i10 > i11 || rect.left >= i11) && rect.left > rect2.left;
        }
        if (i6 == 33) {
            int i12 = rect.bottom;
            int i13 = rect2.bottom;
            return (i12 > i13 || rect.top >= i13) && rect.top > rect2.top;
        }
        if (i6 == 66) {
            int i14 = rect.left;
            int i15 = rect2.left;
            return (i14 < i15 || rect.right <= i15) && rect.right < rect2.right;
        }
        if (i6 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i16 = rect.top;
        int i17 = rect2.top;
        return (i16 < i17 || rect.bottom <= i17) && rect.bottom < rect2.bottom;
    }

    public static boolean m6630t(int i6) {
        return i6 != 0 && AbstractC2478a.m5509d(i6) > 0.5d;
    }

    public static boolean m6631u(byte[] bArr) {
        String[] strArr;
        if (m6628r(bArr)) {
            String str = new String(m6621k(bArr, 0, 13));
            int i6 = 0;
            while (true) {
                if (i6 >= bArr.length) {
                    i6 = -1;
                    break;
                }
                if (bArr[i6] == 32) {
                    break;
                }
                i6++;
            }
            strArr = new String[]{str, new String(m6621k(bArr, 14, i6))};
        } else {
            strArr = null;
        }
        if (strArr != null && strArr.length == 2) {
            String strSubstring = strArr[0];
            while (strSubstring.startsWith(SessionDescription.SUPPORTED_SDP_VERSION)) {
                strSubstring = strSubstring.substring(1, strSubstring.length());
            }
            if (System.currentTimeMillis() > (Long.valueOf(strArr[1]).longValue() * 1000) + Long.valueOf(strSubstring).longValue()) {
                return true;
            }
        }
        return false;
    }

    public static boolean m6632v(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f10984a == null) {
            f10984a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f10984a.booleanValue();
    }

    public static boolean m6633w(Context context) {
        if (m6632v(context) && Build.VERSION.SDK_INT < 24) {
            return true;
        }
        if (f10985b == null) {
            f10985b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        if (f10985b.booleanValue()) {
            return !AbstractC3928d.m7856t() || Build.VERSION.SDK_INT >= 30;
        }
        return false;
    }

    public static int m6634x(float f, int i6, int i10) {
        return AbstractC2478a.m5511f(AbstractC2478a.m5513h(i10, Math.round(Color.alpha(i10) * f)), i6);
    }

    public static int m6635y(int i6, Rect rect, Rect rect2) {
        int i10;
        int i11;
        if (i6 == 17) {
            i10 = rect.left;
            i11 = rect2.right;
        } else if (i6 == 33) {
            i10 = rect.top;
            i11 = rect2.bottom;
        } else if (i6 == 66) {
            i10 = rect2.left;
            i11 = rect.right;
        } else {
            if (i6 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i10 = rect2.top;
            i11 = rect.bottom;
        }
        return Math.max(0, i10 - i11);
    }

    public static int m6636z(int i6, Rect rect, Rect rect2) {
        if (i6 != 17) {
            if (i6 != 33) {
                if (i6 != 66) {
                    if (i6 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public abstract View mo1265B(int i6);

    public abstract boolean mo1266C();

    public void mo4117E() {
    }

    public void mo4118D(FloatingActionButton floatingActionButton) {
    }

    public void mo6357F(boolean z7) {
    }

    public void mo6354G(boolean z7) {
    }
}
