package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public final class C0207g1 {

    public static final RectF f923l = new RectF();

    public static final ConcurrentHashMap f924m = new ConcurrentHashMap();

    public int f925a = 0;

    public boolean f926b = false;

    public float f927c = -1.0f;

    public float f928d = -1.0f;

    public float f929e = -1.0f;

    public int[] f930f = new int[0];

    public boolean f931g = false;

    public TextPaint f932h;

    public final TextView f933i;

    public final Context f934j;

    public final C0202f1 f935k;

    static {
        new ConcurrentHashMap();
    }

    public C0207g1(TextView textView) {
        this.f933i = textView;
        this.f934j = textView.getContext();
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            this.f935k = new C0197e1();
        } else if (i6 >= 23) {
            this.f935k = new C0192d1();
        } else {
            this.f935k = new C0202f1();
        }
    }

    public static int[] m674b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i6 : iArr) {
            if (i6 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i6)) < 0) {
                arrayList.add(Integer.valueOf(i6));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr2[i10] = ((Integer) arrayList.get(i10)).intValue();
        }
        return iArr2;
    }

    public static Method m675d(String str) {
        try {
            ConcurrentHashMap concurrentHashMap = f924m;
            Method declaredMethod = (Method) concurrentHashMap.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, null)) != null) {
                declaredMethod.setAccessible(true);
                concurrentHashMap.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e5) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e5);
            return null;
        }
    }

    public static Object m676e(Object obj, String str, Object obj2) {
        try {
            return m675d(str).invoke(obj, null);
        } catch (Exception e5) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e5);
            return obj2;
        }
    }

    public final void m677a() {
        if (m679f()) {
            if (this.f926b) {
                if (this.f933i.getMeasuredHeight() <= 0 || this.f933i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f935k.mo657b(this.f933i) ? ProgressiveMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES : (this.f933i.getMeasuredWidth() - this.f933i.getTotalPaddingLeft()) - this.f933i.getTotalPaddingRight();
                int height = (this.f933i.getHeight() - this.f933i.getCompoundPaddingBottom()) - this.f933i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f923l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fM678c = m678c(rectF);
                        if (fM678c != this.f933i.getTextSize()) {
                            m680g(0, fM678c);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            this.f926b = true;
        }
    }

    public final int m678c(RectF rectF) {
        CharSequence transformation;
        int length = this.f930f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i6 = length - 1;
        int i10 = 1;
        int i11 = 0;
        while (i10 <= i6) {
            int i12 = (i10 + i6) / 2;
            int i13 = this.f930f[i12];
            TextView textView = this.f933i;
            CharSequence text = textView.getText();
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            CharSequence charSequence = (transformationMethod == null || (transformation = transformationMethod.getTransformation(text, textView)) == null) ? text : transformation;
            int i14 = Build.VERSION.SDK_INT;
            int iM637b = AbstractC0174a1.m637b(textView);
            TextPaint textPaint = this.f932h;
            if (textPaint == null) {
                this.f932h = new TextPaint();
            } else {
                textPaint.reset();
            }
            this.f932h.set(textView.getPaint());
            this.f932h.setTextSize(i13);
            Layout.Alignment alignment = (Layout.Alignment) m676e(textView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
            int iRound = Math.round(rectF.right);
            StaticLayout staticLayoutM647a = i14 >= 23 ? AbstractC0186c1.m647a(charSequence, alignment, iRound, iM637b, textView, this.f932h, this.f935k) : AbstractC0174a1.m636a(charSequence, alignment, iRound, textView, this.f932h);
            if ((iM637b == -1 || (staticLayoutM647a.getLineCount() <= iM637b && staticLayoutM647a.getLineEnd(staticLayoutM647a.getLineCount() - 1) == charSequence.length())) && staticLayoutM647a.getHeight() <= rectF.bottom) {
                int i15 = i12 + 1;
                i11 = i10;
                i10 = i15;
            } else {
                i11 = i12 - 1;
                i6 = i11;
            }
        }
        return this.f930f[i11];
    }

    public final boolean m679f() {
        return m683j() && this.f925a != 0;
    }

    public final void m680g(int i6, float f) {
        Context context = this.f934j;
        float fApplyDimension = TypedValue.applyDimension(i6, f, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        TextView textView = this.f933i;
        if (fApplyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(fApplyDimension);
            boolean zM644a = AbstractC0180b1.m644a(textView);
            if (textView.getLayout() != null) {
                this.f926b = false;
                try {
                    Method methodM675d = m675d("nullLayouts");
                    if (methodM675d != null) {
                        methodM675d.invoke(textView, null);
                    }
                } catch (Exception e5) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e5);
                }
                if (zM644a) {
                    textView.forceLayout();
                } else {
                    textView.requestLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean m681h() {
        if (m683j() && this.f925a == 1) {
            if (!this.f931g || this.f930f.length == 0) {
                int iFloor = ((int) Math.floor((this.f929e - this.f928d) / this.f927c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i6 = 0; i6 < iFloor; i6++) {
                    iArr[i6] = Math.round((i6 * this.f927c) + this.f928d);
                }
                this.f930f = m674b(iArr);
            }
            this.f926b = true;
        } else {
            this.f926b = false;
        }
        return this.f926b;
    }

    public final boolean m682i() {
        int[] iArr = this.f930f;
        int length = iArr.length;
        boolean z7 = length > 0;
        this.f931g = z7;
        if (z7) {
            this.f925a = 1;
            this.f928d = iArr[0];
            this.f929e = iArr[length - 1];
            this.f927c = -1.0f;
        }
        return z7;
    }

    public final boolean m683j() {
        return !(this.f933i instanceof AppCompatEditText);
    }

    public final void m684k(float f, float f3, float f4) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        }
        if (f3 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        }
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
        this.f925a = 1;
        this.f928d = f;
        this.f929e = f3;
        this.f927c = f4;
        this.f931g = false;
    }
}
