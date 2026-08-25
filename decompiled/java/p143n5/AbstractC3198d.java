package p143n5;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.AbstractC0381n;
import androidx.core.widget.AbstractC0382o;
import androidx.core.widget.AbstractC0383p;
import androidx.core.widget.ActionModeCallbackC0384q;
import androidx.fragment.app.C0423q;
import com.p2serv.android.p032ds.R;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import org.bitspark.android.SpkApplication;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;
import p004a3.C0036a;
import p065g0.AbstractC2581a;
import p065g0.AbstractC2582b;
import p065g0.C2590j;
import p065g0.InterfaceC2588h;
import p065g0.InterfaceC2589i;
import p091i9.InterfaceC2713a;
import p103j9.AbstractC2797j;
import p118l0.C2956g;
import p123l5.AbstractC2973a;
import p221u6.C3923w;
import p243w8.C4069k;
import p243w8.C4071m;
import p243w8.InterfaceC4061c;

public abstract class AbstractC3198d {

    public static ClassLoader f10767a;

    public static Thread f10768b;

    public static Method f10769c;

    public static boolean f10770d;

    public static Method f10771e;

    public static boolean f10772f;

    public static final boolean m6426A(Bitmap.Config config) {
        return Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE;
    }

    public static InterfaceC4061c m6427B(InterfaceC2713a interfaceC2713a) {
        C4069k c4069k = C4069k.f13733a;
        C4071m c4071m = new C4071m();
        c4071m.f13735a = (AbstractC2797j) interfaceC2713a;
        c4071m.f13736b = c4069k;
        return c4071m;
    }

    public static Typeface m6428C(Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT < 31 || configuration.fontWeightAdjustment == Integer.MAX_VALUE || configuration.fontWeightAdjustment == 0) {
            return null;
        }
        return Typeface.create(typeface, AbstractC2973a.m6016g(configuration.fontWeightAdjustment + typeface.getWeight(), 1, 1000), typeface.isItalic());
    }

    public static MappedByteBuffer m6429D(Context context, Uri uri) {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return map;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public static void m6430E(Context context, String str) {
        if (str.equals("")) {
            context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            return;
        }
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);
            XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
            try {
                try {
                    xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                    xmlSerializerNewSerializer.startDocument("UTF-8", Boolean.TRUE);
                    xmlSerializerNewSerializer.startTag(null, "locales");
                    xmlSerializerNewSerializer.attribute(null, "application_locales", str);
                    xmlSerializerNewSerializer.endTag(null, "locales");
                    xmlSerializerNewSerializer.endDocument();
                    Log.d("AppLocalesStorageHelper", "Storing App Locales : app-locales: " + str + " persisted successfully.");
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (Throwable th) {
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                Log.w("AppLocalesStorageHelper", "Storing App Locales : Failed to persist app-locales: ".concat(str), e5);
                if (fileOutputStreamOpenFileOutput != null) {
                    fileOutputStreamOpenFileOutput.close();
                }
            }
        } catch (FileNotFoundException unused3) {
            Log.w("AppLocalesStorageHelper", "Storing App Locales : FileNotFoundException: Cannot open file androidx.appcompat.app.AppCompatDelegate.application_locales_record_file for writing ");
        }
    }

    public static boolean m6431F(Parcel parcel, int i6) {
        m6453a0(parcel, i6, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean m6432G(Parcel parcel, int i6) {
        int iM6439N = m6439N(parcel, i6);
        if (iM6439N == 0) {
            return null;
        }
        m6451Z(parcel, iM6439N, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static double m6433H(Parcel parcel, int i6) {
        m6453a0(parcel, i6, 8);
        return parcel.readDouble();
    }

    public static float m6434I(Parcel parcel, int i6) {
        m6453a0(parcel, i6, 4);
        return parcel.readFloat();
    }

    public static IBinder m6435J(Parcel parcel, int i6) {
        int iM6439N = m6439N(parcel, i6);
        int iDataPosition = parcel.dataPosition();
        if (iM6439N == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iM6439N);
        return strongBinder;
    }

    public static int m6436K(Parcel parcel, int i6) {
        m6453a0(parcel, i6, 4);
        return parcel.readInt();
    }

    public static String m6437L(Context context) {
        String attributeValue = "";
        try {
            FileInputStream fileInputStreamOpenFileInput = context.openFileInput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            try {
                try {
                    XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, "UTF-8");
                    int depth = xmlPullParserNewPullParser.getDepth();
                    while (true) {
                        int next = xmlPullParserNewPullParser.next();
                        if (next != 1 && (next != 3 || xmlPullParserNewPullParser.getDepth() > depth)) {
                            if (next != 3 && next != 4 && xmlPullParserNewPullParser.getName().equals("locales")) {
                                attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "application_locales");
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (IOException | XmlPullParserException unused2) {
                    Log.w("AppLocalesStorageHelper", "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                }
                if (attributeValue.isEmpty()) {
                    context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                } else {
                    Log.d("AppLocalesStorageHelper", "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: ".concat(attributeValue));
                }
                return attributeValue;
            } catch (Throwable th) {
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused4) {
            Log.w("AppLocalesStorageHelper", "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            return "";
        }
    }

    public static long m6438M(Parcel parcel, int i6) {
        m6453a0(parcel, i6, 8);
        return parcel.readLong();
    }

    public static int m6439N(Parcel parcel, int i6) {
        return (i6 & (-65536)) != -65536 ? (char) (i6 >> 16) : parcel.readInt();
    }

    public static void m6440O(TextView textView, int i6) {
        AbstractC0032a.m161o(i6);
        if (Build.VERSION.SDK_INT >= 28) {
            AbstractC0383p.m1156d(textView, i6);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i10 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i6 > Math.abs(i10)) {
            textView.setPadding(textView.getPaddingLeft(), i6 + i10, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void m6441P(TextView textView, int i6) {
        AbstractC0032a.m161o(i6);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i10 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i6 > Math.abs(i10)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i6 - i10);
        }
    }

    public static boolean m6442Q(Drawable drawable, int i6) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AbstractC2582b.m5589b(drawable, i6);
        }
        if (!f10770d) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                f10769c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e5) {
                Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e5);
            }
            f10770d = true;
        }
        Method method = f10769c;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i6));
                return true;
            } catch (Exception e10) {
                Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e10);
                f10769c = null;
            }
        }
        return false;
    }

    public static void m6443R(TextView textView, int i6) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i6);
        } else {
            textView.setTextAppearance(textView.getContext(), i6);
        }
    }

    public static void m6444S(Drawable drawable, int i6) {
        AbstractC2581a.m5585g(drawable, i6);
    }

    public static void m6445T(Parcel parcel, int i6) {
        parcel.setDataPosition(parcel.dataPosition() + m6439N(parcel, i6));
    }

    public static ActionMode.Callback m6446U(ActionMode.Callback callback) {
        return (!(callback instanceof ActionModeCallbackC0384q) || Build.VERSION.SDK_INT < 26) ? callback : ((ActionModeCallbackC0384q) callback).f1682a;
    }

    public static int m6447V(Parcel parcel) {
        int i6 = parcel.readInt();
        int iM6439N = m6439N(parcel, i6);
        char c5 = (char) i6;
        int iDataPosition = parcel.dataPosition();
        if (c5 != 20293) {
            throw new C0423q("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i6))), parcel);
        }
        int i10 = iM6439N + iDataPosition;
        if (i10 < iDataPosition || i10 > parcel.dataSize()) {
            throw new C0423q(AbstractC0004e.m19m(iDataPosition, i10, "Size read is invalid start=", " end="), parcel);
        }
        return i10;
    }

    public static Drawable m6448W(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23 || (drawable instanceof InterfaceC2588h)) {
            return drawable;
        }
        C2590j c2590j = new C2590j();
        c2590j.f9033d = c2590j.m5607c();
        c2590j.m5612h(drawable);
        C2590j.m5605a();
        return c2590j;
    }

    public static ActionMode.Callback m6449X(ActionMode.Callback callback, TextView textView) {
        int i6 = Build.VERSION.SDK_INT;
        return (i6 < 26 || i6 > 27 || (callback instanceof ActionModeCallbackC0384q) || callback == null) ? callback : new ActionModeCallbackC0384q(callback, textView);
    }

    public static synchronized ClassLoader m6450Y() {
        SecurityException e5;
        Thread thread;
        ThreadGroup threadGroup;
        if (f10767a == null) {
            Thread thread2 = f10768b;
            ClassLoader contextClassLoader = null;
            if (thread2 != null) {
                synchronized (thread2) {
                    try {
                        contextClassLoader = f10768b.getContextClassLoader();
                    } catch (SecurityException e10) {
                        Log.w("DynamiteLoaderV2CL", "Failed to get thread context classloader " + e10.getMessage());
                    }
                }
                f10767a = contextClassLoader;
            } else {
                ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
                if (threadGroup2 == null) {
                    thread2 = null;
                } else {
                    synchronized (Void.class) {
                        try {
                            try {
                                int iActiveGroupCount = threadGroup2.activeGroupCount();
                                ThreadGroup[] threadGroupArr = new ThreadGroup[iActiveGroupCount];
                                threadGroup2.enumerate(threadGroupArr);
                                int i6 = 0;
                                int i10 = 0;
                                while (true) {
                                    if (i10 >= iActiveGroupCount) {
                                        threadGroup = null;
                                        break;
                                    }
                                    threadGroup = threadGroupArr[i10];
                                    if ("dynamiteLoader".equals(threadGroup.getName())) {
                                        break;
                                    }
                                    i10++;
                                }
                                if (threadGroup == null) {
                                    threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                                }
                                int iActiveCount = threadGroup.activeCount();
                                Thread[] threadArr = new Thread[iActiveCount];
                                threadGroup.enumerate(threadArr);
                                while (true) {
                                    if (i6 >= iActiveCount) {
                                        thread = null;
                                        break;
                                    }
                                    thread = threadArr[i6];
                                    if ("GmsDynamite".equals(thread.getName())) {
                                        break;
                                    }
                                    i6++;
                                }
                                if (thread == null) {
                                    try {
                                        C0036a c0036a = new C0036a(threadGroup, "GmsDynamite");
                                        try {
                                            c0036a.setContextClassLoader(null);
                                            c0036a.start();
                                            thread = c0036a;
                                        } catch (SecurityException e11) {
                                            e5 = e11;
                                            thread = c0036a;
                                            Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e5.getMessage());
                                        }
                                    } catch (SecurityException e12) {
                                        e5 = e12;
                                    }
                                }
                            } catch (SecurityException e13) {
                                e5 = e13;
                                thread = null;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    thread2 = thread;
                }
                f10768b = thread2;
                if (thread2 != null) {
                    synchronized (thread2) {
                        contextClassLoader = f10768b.getContextClassLoader();
                    }
                }
                f10767a = contextClassLoader;
            }
        }
        return f10767a;
    }

    public static void m6451Z(Parcel parcel, int i6, int i10) {
        if (i6 == i10) {
            return;
        }
        throw new C0423q(AbstractC0004e.m26t(AbstractC0004e.m28v("Expected size ", i10, " got ", i6, " (0x"), Integer.toHexString(i6), ")"), parcel);
    }

    public static void m6452a(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        if (Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            m6452a(((InsetDrawable) drawable).getDrawable());
            return;
        }
        if (drawable instanceof InterfaceC2589i) {
            m6452a(((C2590j) ((InterfaceC2589i) drawable)).f9035f);
            return;
        }
        if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
            return;
        }
        int childCount = drawableContainerState.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            Drawable child = drawableContainerState.getChild(i6);
            if (child != null) {
                m6452a(child);
            }
        }
    }

    public static void m6453a0(Parcel parcel, int i6, int i10) {
        int iM6439N = m6439N(parcel, i6);
        if (iM6439N == i10) {
            return;
        }
        throw new C0423q(AbstractC0004e.m26t(AbstractC0004e.m28v("Expected size ", i10, " got ", iM6439N, " (0x"), Integer.toHexString(iM6439N), ")"), parcel);
    }

    public static void m6454b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean m6455c(File file, Resources resources, int i6) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i6);
            try {
                boolean zM6456d = m6456d(file, inputStreamOpenRawResource);
                m6454b(inputStreamOpenRawResource);
                return zM6456d;
            } catch (Throwable th) {
                th = th;
                m6454b(inputStreamOpenRawResource);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenRawResource = null;
        }
    }

    public static boolean m6456d(File file, InputStream inputStream) throws Throwable {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i6 = inputStream.read(bArr);
                        if (i6 == -1) {
                            m6454b(fileOutputStream2);
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                            return true;
                        }
                        fileOutputStream2.write(bArr, 0, i6);
                    }
                } catch (IOException e5) {
                    e = e5;
                    fileOutputStream = fileOutputStream2;
                    Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
                    m6454b(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    m6454b(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static BigDecimal m6457e(Parcel parcel, int i6) {
        int iM6439N = m6439N(parcel, i6);
        int iDataPosition = parcel.dataPosition();
        if (iM6439N == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i10 = parcel.readInt();
        parcel.setDataPosition(iDataPosition + iM6439N);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i10);
    }

    public static Bundle m6458f(Parcel parcel, int i6) {
        int iM6439N = m6439N(parcel, i6);
        int iDataPosition = parcel.dataPosition();
        if (iM6439N == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iM6439N);
        return bundle;
    }

    public static byte[] m6459g(Parcel parcel, int i6) {
        int iM6439N = m6439N(parcel, i6);
        int iDataPosition = parcel.dataPosition();
        if (iM6439N == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iM6439N);
        return bArrCreateByteArray;
    }

    public static int[] m6460h(Parcel parcel, int i6) {
        int iM6439N = m6439N(parcel, i6);
        int iDataPosition = parcel.dataPosition();
        if (iM6439N == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iM6439N);
        return iArrCreateIntArray;
    }

    public static long[] m6461i(Parcel parcel, int i6) {
        int iM6439N = m6439N(parcel, i6);
        int iDataPosition = parcel.dataPosition();
        if (iM6439N == 0) {
            return null;
        }
        long[] jArrCreateLongArray = parcel.createLongArray();
        parcel.setDataPosition(iDataPosition + iM6439N);
        return jArrCreateLongArray;
    }

    public static Parcelable m6462j(Parcel parcel, int i6, Parcelable.Creator creator) {
        int iM6439N = m6439N(parcel, i6);
        int iDataPosition = parcel.dataPosition();
        if (iM6439N == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iM6439N);
        return parcelable;
    }

    public static String m6463k(Parcel parcel, int i6) {
        int iM6439N = m6439N(parcel, i6);
        int iDataPosition = parcel.dataPosition();
        if (iM6439N == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iM6439N);
        return string;
    }

    public static String[] m6464l(Parcel parcel, int i6) {
        int iM6439N = m6439N(parcel, i6);
        int iDataPosition = parcel.dataPosition();
        if (iM6439N == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iM6439N);
        return strArrCreateStringArray;
    }

    public static String[] m6465m(int i6, int i10) {
        String[] strArr = new String[(i10 - i6) + 1];
        for (int i11 = i6; i11 <= i10; i11++) {
            strArr[i11 - i6] = String.format("%02d", Integer.valueOf(i11));
        }
        return strArr;
    }

    public static ArrayList m6466n(Parcel parcel, int i6) {
        int iM6439N = m6439N(parcel, i6);
        int iDataPosition = parcel.dataPosition();
        if (iM6439N == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iM6439N);
        return arrayListCreateStringArrayList;
    }

    public static Object[] m6467o(Parcel parcel, int i6, Parcelable.Creator creator) {
        int iM6439N = m6439N(parcel, i6);
        int iDataPosition = parcel.dataPosition();
        if (iM6439N == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iM6439N);
        return objArrCreateTypedArray;
    }

    public static ArrayList m6468p(Parcel parcel, int i6, Parcelable.Creator creator) {
        int iM6439N = m6439N(parcel, i6);
        int iDataPosition = parcel.dataPosition();
        if (iM6439N == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iM6439N);
        return arrayListCreateTypedArrayList;
    }

    public static int m6469q(Context context, int i6) {
        if (context == null) {
            context = SpkApplication.f11160c.getApplicationContext();
        }
        return context == null ? i6 : (int) TypedValue.applyDimension(1, i6, context.getResources().getDisplayMetrics());
    }

    public static void m6470r(Parcel parcel, int i6) {
        if (parcel.dataPosition() != i6) {
            throw new C0423q(AbstractC0004e.m20n(i6, "Overread allowed size end="), parcel);
        }
    }

    public static final int m6471s(Bitmap bitmap) {
        int i6;
        if (bitmap.isRecycled()) {
            throw new IllegalStateException(("Cannot obtain size for recycled bitmap: " + bitmap + " [" + bitmap.getWidth() + " x " + bitmap.getHeight() + "] + " + bitmap.getConfig()).toString());
        }
        try {
            return bitmap.getAllocationByteCount();
        } catch (Exception unused) {
            int height = bitmap.getHeight() * bitmap.getWidth();
            Bitmap.Config config = bitmap.getConfig();
            if (config == Bitmap.Config.ALPHA_8) {
                i6 = 1;
            } else if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
                i6 = 2;
            } else {
                i6 = (Build.VERSION.SDK_INT < 26 || config != Bitmap.Config.RGBA_F16) ? 4 : 8;
            }
            return i6 * height;
        }
    }

    public static Calendar m6472t(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    public static int m6473v(Context context) {
        float fraction;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        boolean z7 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(z7 ? R.dimen.mr_dialog_fixed_width_minor : R.dimen.mr_dialog_fixed_width_major, typedValue, true);
        int i6 = typedValue.type;
        if (i6 == 5) {
            fraction = typedValue.getDimension(displayMetrics);
        } else {
            if (i6 != 6) {
                return -2;
            }
            int i10 = displayMetrics.widthPixels;
            fraction = typedValue.getFraction(i10, i10);
        }
        return (int) fraction;
    }

    public static int m6474w(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AbstractC2582b.m5588a(drawable);
        }
        if (!f10772f) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", null);
                f10771e = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e5) {
                Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e5);
            }
            f10772f = true;
        }
        Method method = f10771e;
        if (method == null) {
            return 0;
        }
        try {
            return ((Integer) method.invoke(drawable, null)).intValue();
        } catch (Exception e10) {
            Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e10);
            f10771e = null;
            return 0;
        }
    }

    public static File m6475x(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i6 = 0; i6 < 100; i6++) {
            File file = new File(cacheDir, str + i6);
            try {
                if (file.createNewFile()) {
                    return file;
                }
            } catch (IOException unused) {
            }
        }
        return null;
    }

    public static C2956g m6476y(AppCompatTextView appCompatTextView) {
        int iM1144a;
        int iM1147d;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 28) {
            return new C2956g(AbstractC0383p.m1155c(appCompatTextView));
        }
        TextPaint textPaint = new TextPaint(appCompatTextView.getPaint());
        if (i6 >= 23) {
            iM1144a = 1;
            iM1147d = 1;
        } else {
            iM1144a = 0;
            iM1147d = 0;
        }
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        if (i6 >= 23) {
            iM1144a = AbstractC0381n.m1144a(appCompatTextView);
            iM1147d = AbstractC0381n.m1147d(appCompatTextView);
        }
        if (appCompatTextView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else if (i6 < 28 || (appCompatTextView.getInputType() & 15) != 3) {
            boolean z7 = appCompatTextView.getLayoutDirection() == 1;
            switch (appCompatTextView.getTextDirection()) {
                case 2:
                    textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                    break;
                case 3:
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                    break;
                case 4:
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                    break;
                case 5:
                    textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                    break;
                case 6:
                    break;
                case 7:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    break;
                default:
                    if (z7) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    break;
            }
        } else {
            byte directionality = Character.getDirectionality(AbstractC0383p.m1154b(AbstractC0382o.m1152a(appCompatTextView.getTextLocale()))[0].codePointAt(0));
            textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        return new C2956g(textPaint, textDirectionHeuristic, iM1144a, iM1147d);
    }

    public static boolean m6477z(MotionEvent motionEvent, int i6) {
        return (motionEvent.getSource() & i6) == i6;
    }

    public abstract void mo6478u(C3923w c3923w, float f, float f3);
}
