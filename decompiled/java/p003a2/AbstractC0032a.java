package p003a2;

import android.animation.TimeInterpolator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.media.MediaRoute2Info;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import android.util.Property;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.leanback.transition.InterfaceC0444e;
import androidx.media3.common.AbstractC0590d;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.mediarouter.app.AbstractC1115t0;
import androidx.versionedparcelable.ParcelImpl;
import com.bumptech.glide.AbstractC1465c;
import com.bumptech.glide.AbstractC1466d;
import com.lzy.okgo.model.Progress;
import com.p2serv.android.p032ds.R;
import java.io.Closeable;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000a.AbstractC0004e;
import p001a0.C0023f;
import p055ea.AbstractC2460q;
import p060f7.AbstractC2500d;
import p066g1.C2592a;
import p103j9.AbstractC2796i;
import p123l5.AbstractC2973a;
import p161p0.AbstractC3349a;
import p173q1.C3454w;
import p240w3.AbstractC4051a;
import p264y8.C4278c;

public abstract class AbstractC0032a implements InterfaceC0444e {

    public static Boolean f94a;

    public static Intent m149A(AppCompatActivity appCompatActivity) {
        Intent parentActivityIntent = appCompatActivity.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        try {
            String strM150B = m150B(appCompatActivity, appCompatActivity.getComponentName());
            if (strM150B == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(appCompatActivity, strM150B);
            try {
                return m150B(appCompatActivity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + strM150B + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    public static String m150B(Context context, ComponentName componentName) {
        int i6;
        String string;
        PackageManager packageManager = context.getPackageManager();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            i6 = 269222528;
        } else {
            i6 = i10 >= 24 ? 787072 : 640;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i6);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static ArrayList m151C(List list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MediaRoute2Info mediaRoute2InfoM1624f = AbstractC0590d.m1624f(it.next());
            if (mediaRoute2InfoM1624f != null) {
                arrayList.add(mediaRoute2InfoM1624f.getId());
            }
        }
        return arrayList;
    }

    public static InterfaceC0035d m152D(Bundle bundle) {
        try {
            Bundle bundle2 = (Bundle) bundle.getParcelable(MediaSessionCompat.KEY_SESSION2_TOKEN);
            if (bundle2 == null) {
                return null;
            }
            bundle2.setClassLoader(AbstractC0032a.class.getClassLoader());
            Parcelable parcelable = bundle2.getParcelable(CmcdData.OBJECT_TYPE_AUDIO_ONLY);
            if (parcelable instanceof ParcelImpl) {
                return ((ParcelImpl) parcelable).f3818a;
            }
            throw new IllegalArgumentException("Invalid parcel");
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static boolean m153E(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static List m154F(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        AbstractC2796i.m5784e(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static TimeInterpolator m155K(Context context, C2592a c2592a) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.motionEasingStandard, typedValue, true)) {
            return c2592a;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be a string");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!m153E(strValueOf, "cubic-bezier")) {
            if (m153E(strValueOf, "path")) {
                return AbstractC3349a.m6823c(AbstractC1466d.m3489g(strValueOf.substring(5, strValueOf.length() - 1)));
            }
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(strValueOf));
        }
        String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
        if (strArrSplit.length == 4) {
            return AbstractC3349a.m6822b(m168v(strArrSplit, 0), m168v(strArrSplit, 1), m168v(strArrSplit, 2), m168v(strArrSplit, 3));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
    }

    public static long m156L(long j10, long j11) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(~j11) + Long.numberOfLeadingZeros(j11) + Long.numberOfLeadingZeros(~j10) + Long.numberOfLeadingZeros(j10);
        if (iNumberOfLeadingZeros > 65) {
            return j10 * j11;
        }
        long j12 = ((j10 ^ j11) >>> 63) + Long.MAX_VALUE;
        if ((iNumberOfLeadingZeros < 64) || ((j11 == Long.MIN_VALUE) & (j10 < 0))) {
            return j12;
        }
        long j13 = j10 * j11;
        return (j10 == 0 || j13 / j10 == j11) ? j13 : j12;
    }

    public static C3454w m157M(MediaRoute2Info mediaRoute2Info) {
        int i6;
        if (mediaRoute2Info == null) {
            return null;
        }
        C0023f c0023f = new C0023f(mediaRoute2Info.getId(), mediaRoute2Info.getName().toString());
        int connectionState = mediaRoute2Info.getConnectionState();
        Bundle bundle = (Bundle) c0023f.f44b;
        bundle.putInt("connectionState", connectionState);
        bundle.putInt("volumeHandling", mediaRoute2Info.getVolumeHandling());
        bundle.putInt("volumeMax", mediaRoute2Info.getVolumeMax());
        bundle.putInt("volume", mediaRoute2Info.getVolume());
        Bundle extras = mediaRoute2Info.getExtras();
        if (extras == null) {
            bundle.putBundle("extras", null);
        } else {
            bundle.putBundle("extras", new Bundle(extras));
        }
        bundle.putBoolean("enabled", true);
        bundle.putBoolean("canDisconnect", false);
        if (Build.VERSION.SDK_INT >= 34) {
            bundle.putStringArrayList("deduplicationIds", new ArrayList<>(AbstractC1115t0.m2783b(mediaRoute2Info)));
            int iM2784c = AbstractC1115t0.m2784c(mediaRoute2Info);
            i6 = 2;
            if (iM2784c == 2) {
                i6 = 12;
            } else if (iM2784c == 3) {
                i6 = 13;
            } else if (iM2784c == 4) {
                i6 = 14;
            } else if (iM2784c == 22) {
                i6 = 20;
            } else if (iM2784c == 23) {
                i6 = 21;
            } else if (iM2784c == 26) {
                i6 = 22;
            } else if (iM2784c == 29) {
                i6 = 24;
            } else if (iM2784c != 2000) {
                switch (iM2784c) {
                    case 8:
                        i6 = 3;
                        break;
                    case 9:
                        i6 = 16;
                        break;
                    case 10:
                        i6 = 23;
                        break;
                    case 11:
                        i6 = 17;
                        break;
                    case 12:
                        i6 = 18;
                        break;
                    case 13:
                        i6 = 19;
                        break;
                    default:
                        switch (iM2784c) {
                            case 1001:
                                i6 = 1;
                                break;
                            case 1002:
                                break;
                            case 1003:
                                i6 = 4;
                                break;
                            case 1004:
                                i6 = 5;
                                break;
                            case 1005:
                                i6 = 6;
                                break;
                            case AnalyticsListener.EVENT_BANDWIDTH_ESTIMATE:
                                i6 = 7;
                                break;
                            case AnalyticsListener.EVENT_AUDIO_ENABLED:
                                i6 = 8;
                                break;
                            case AnalyticsListener.EVENT_AUDIO_DECODER_INITIALIZED:
                                i6 = 9;
                                break;
                            case AnalyticsListener.EVENT_AUDIO_INPUT_FORMAT_CHANGED:
                                i6 = 10;
                                break;
                            case AnalyticsListener.EVENT_AUDIO_POSITION_ADVANCING:
                                i6 = 11;
                                break;
                            default:
                                i6 = 0;
                                break;
                        }
                        break;
                }
            } else {
                i6 = 1000;
            }
        } else {
            i6 = 0;
        }
        CharSequence description = mediaRoute2Info.getDescription();
        if (description != null) {
            bundle.putString(Progress.STATUS, description.toString());
        }
        Uri iconUri = mediaRoute2Info.getIconUri();
        if (iconUri != null) {
            bundle.putString("iconUri", iconUri.toString());
        }
        Bundle extras2 = mediaRoute2Info.getExtras();
        if (extras2 == null || !extras2.containsKey("androidx.mediarouter.media.KEY_EXTRAS") || !extras2.containsKey("androidx.mediarouter.media.KEY_DEVICE_TYPE") || !extras2.containsKey("androidx.mediarouter.media.KEY_CONTROL_FILTERS")) {
            return null;
        }
        Bundle bundle2 = extras2.getBundle("androidx.mediarouter.media.KEY_EXTRAS");
        if (bundle2 == null) {
            bundle.putBundle("extras", null);
        } else {
            bundle.putBundle("extras", new Bundle(bundle2));
        }
        if (i6 == 0) {
            i6 = extras2.getInt("androidx.mediarouter.media.KEY_DEVICE_TYPE", 0);
        }
        bundle.putInt("deviceType", i6);
        bundle.putInt("playbackType", extras2.getInt("androidx.mediarouter.media.KEY_PLAYBACK_TYPE", 1));
        ArrayList parcelableArrayList = extras2.getParcelableArrayList("androidx.mediarouter.media.KEY_CONTROL_FILTERS");
        if (parcelableArrayList != null) {
            c0023f.m102b(parcelableArrayList);
        }
        return c0023f.m103c();
    }

    public static String m158N(Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String string;
        int i6 = 0;
        int i10 = 0;
        while (true) {
            length = objArr.length;
            if (i10 >= length) {
                break;
            }
            Object obj = objArr[i10];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e5) {
                    String strM5495i = AbstractC2460q.m5495i(obj.getClass().getName(), "@", Integer.toHexString(System.identityHashCode(obj)));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(strM5495i), (Throwable) e5);
                    string = "<" + strM5495i + " threw " + e5.getClass().getName() + ">";
                }
            }
            objArr[i10] = string;
            i10++;
        }
        StringBuilder sb = new StringBuilder((length * 16) + 29);
        int i11 = 0;
        while (true) {
            length2 = objArr.length;
            if (i6 >= length2 || (iIndexOf = "expected a non-null reference".indexOf("%s", i11)) == -1) {
                break;
            }
            sb.append((CharSequence) "expected a non-null reference", i11, iIndexOf);
            sb.append(objArr[i6]);
            i11 = iIndexOf + 2;
            i6++;
        }
        sb.append((CharSequence) "expected a non-null reference", i11, 29);
        if (i6 < length2) {
            sb.append(" [");
            sb.append(objArr[i6]);
            for (int i12 = i6 + 1; i12 < objArr.length; i12++) {
                sb.append(", ");
                sb.append(objArr[i12]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static C4278c m159m(C4278c c4278c) {
        c4278c.m8337h();
        c4278c.f14499c = true;
        return c4278c.f14498b > 0 ? c4278c : C4278c.f14496d;
    }

    public static void m160n(String str, boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void m161o(int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void m162p(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static long m163q(long j10, long j11) {
        long j12 = j10 + j11;
        if (((j10 ^ j11) < 0) || ((j10 ^ j12) >= 0)) {
            return j12;
        }
        StringBuilder sb = new StringBuilder("overflow: checkedAdd(");
        sb.append(j10);
        sb.append(", ");
        throw new ArithmeticException(AbstractC0004e.m25s(sb, j11, ")"));
    }

    public static final void m164r(Closeable closeable, Throwable th) throws IOException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                AbstractC2973a.m6013a(th, th2);
            }
        }
    }

    public static String m165s(String str, String str2) {
        byte[] bArrM8054a = AbstractC4051a.m8054a(str);
        byte[] bArrM8054a2 = AbstractC4051a.m8054a(str2);
        int length = bArrM8054a.length;
        int length2 = bArrM8054a2.length;
        int i6 = 0;
        int i10 = 0;
        while (i6 < length) {
            if (i10 >= length2) {
                i10 = 0;
            }
            bArrM8054a[i6] = (byte) (bArrM8054a[i6] ^ bArrM8054a2[i10]);
            i6++;
            i10++;
        }
        return new String(bArrM8054a, StandardCharsets.UTF_8);
    }

    public static long m166t(long j10, long j11, RoundingMode roundingMode) {
        roundingMode.getClass();
        long j12 = j10 / j11;
        long j13 = j10 - (j11 * j12);
        if (j13 == 0) {
            return j12;
        }
        int i6 = ((int) ((j10 ^ j11) >> 63)) | 1;
        switch (AbstractC2500d.f8730a[roundingMode.ordinal()]) {
            case 1:
                AbstractC1465c.m3469d(j13 == 0);
                return j12;
            case 2:
                return j12;
            case 3:
                if (i6 >= 0) {
                    return j12;
                }
                break;
            case 4:
                break;
            case 5:
                if (i6 <= 0) {
                    return j12;
                }
                break;
            case 6:
            case 7:
            case 8:
                long jAbs = Math.abs(j13);
                long jAbs2 = jAbs - (Math.abs(j11) - jAbs);
                if (jAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP && (roundingMode != RoundingMode.HALF_EVEN || (1 & j12) == 0)) {
                        return j12;
                    }
                } else if (jAbs2 <= 0) {
                    return j12;
                }
            default:
                throw new AssertionError();
        }
        return j12 + ((long) i6);
    }

    public static long m167u(long j10, long j11) {
        AbstractC1465c.m3468c(j10, CmcdData.OBJECT_TYPE_AUDIO_ONLY);
        AbstractC1465c.m3468c(j11, "b");
        if (j10 == 0) {
            return j11;
        }
        if (j11 == 0) {
            return j10;
        }
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j10);
        long jNumberOfTrailingZeros = j10 >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(j11);
        long j12 = j11 >> iNumberOfTrailingZeros2;
        while (jNumberOfTrailingZeros != j12) {
            long j13 = jNumberOfTrailingZeros - j12;
            long j14 = (j13 >> 63) & j13;
            long j15 = (j13 - j14) - j14;
            j12 += j14;
            jNumberOfTrailingZeros = j15 >> Long.numberOfTrailingZeros(j15);
        }
        return jNumberOfTrailingZeros << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros2);
    }

    public static float m168v(String[] strArr, int i6) {
        float f = Float.parseFloat(strArr[i6]);
        if (f >= 0.0f && f <= 1.0f) {
            return f;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f);
    }

    public static String m169w() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String m170x(Context context, int i6) {
        if (i6 == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(i6);
        } catch (Exception unused) {
            return AbstractC0004e.m20n(i6, "?");
        }
    }

    public static String m171y(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static Intent m172z(Context context, ComponentName componentName) {
        String strM150B = m150B(context, componentName);
        if (strM150B == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strM150B);
        return m150B(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public void m173G() {
        synchronized (this) {
        }
    }

    public abstract void mo174H(Throwable th);

    public abstract void mo175I(C0023f c0023f);

    public abstract Object mo176J(Intent intent, int i6);

    @Override
    public float mo177j(View view) {
        return view.getTranslationY();
    }

    @Override
    public Property mo178l() {
        return View.TRANSLATION_Y;
    }
}
