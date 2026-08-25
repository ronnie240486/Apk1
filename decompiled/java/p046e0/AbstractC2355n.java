package p046e0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.app.RunnableC0147m0;
import com.google.android.gms.cast.framework.internal.featurehighlight.C1498f;
import java.io.IOException;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
import p056f0.AbstractC2484g;

public abstract class AbstractC2355n {

    public static final ThreadLocal f8209a = new ThreadLocal();

    public static final WeakHashMap f8210b = new WeakHashMap(0);

    public static final Object f8211c = new Object();

    public static void m5337a(C2353l c2353l, int i6, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f8211c) {
            try {
                WeakHashMap weakHashMap = f8210b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(c2353l);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(c2353l, sparseArray);
                }
                sparseArray.append(i6, new C2352k(colorStateList, c2353l.f8207a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Typeface m5338b(Context context, int i6) {
        if (context.isRestricted()) {
            return null;
        }
        return m5339c(context, i6, new TypedValue(), 0, null, false, false);
    }

    public static Typeface m5339c(Context context, int i6, TypedValue typedValue, int i10, AbstractC2343b abstractC2343b, boolean z7, boolean z10) {
        Resources resources = context.getResources();
        resources.getValue(i6, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i6) + "\" (" + Integer.toHexString(i6) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        Typeface typefaceM5521a = null;
        if (string.startsWith("res/")) {
            int i11 = typedValue.assetCookie;
            C1498f c1498f = AbstractC2484g.f8689b;
            Typeface typefaceMo5537o = (Typeface) c1498f.m3612b(AbstractC2484g.m5522b(resources, i6, string, i11, i10));
            if (typefaceMo5537o != null) {
                if (abstractC2343b != null) {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0147m0(abstractC2343b, 12, typefaceMo5537o));
                }
            } else if (!z10) {
                try {
                    if (string.toLowerCase().endsWith(".xml")) {
                        InterfaceC2346e interfaceC2346eM5323k = AbstractC2343b.m5323k(resources.getXml(i6), resources);
                        if (interfaceC2346eM5323k == null) {
                            Log.e("ResourcesCompat", "Failed to find font-family tag");
                            if (abstractC2343b != null) {
                                abstractC2343b.m5328a(-3);
                            }
                        } else {
                            typefaceM5521a = AbstractC2484g.m5521a(context, interfaceC2346eM5323k, resources, i6, string, typedValue.assetCookie, i10, abstractC2343b, z7);
                        }
                    } else {
                        int i12 = typedValue.assetCookie;
                        typefaceMo5537o = AbstractC2484g.f8688a.mo5537o(context, resources, i6, string, i10);
                        if (typefaceMo5537o != null) {
                            c1498f.m3614d(AbstractC2484g.m5522b(resources, i6, string, i12, i10), typefaceMo5537o);
                        }
                        if (abstractC2343b != null) {
                            if (typefaceMo5537o != null) {
                                new Handler(Looper.getMainLooper()).post(new RunnableC0147m0(abstractC2343b, 12, typefaceMo5537o));
                            } else {
                                abstractC2343b.m5328a(-3);
                            }
                        }
                    }
                } catch (IOException e5) {
                    Log.e("ResourcesCompat", "Failed to read xml resource ".concat(string), e5);
                    if (abstractC2343b != null) {
                        abstractC2343b.m5328a(-3);
                    }
                } catch (XmlPullParserException e10) {
                    Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(string), e10);
                    if (abstractC2343b != null) {
                        abstractC2343b.m5328a(-3);
                    }
                }
            }
            typefaceM5521a = typefaceMo5537o;
        } else if (abstractC2343b != null) {
            abstractC2343b.m5328a(-3);
        }
        if (typefaceM5521a != null || abstractC2343b != null || z10) {
            return typefaceM5521a;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i6) + " could not be retrieved.");
    }
}
