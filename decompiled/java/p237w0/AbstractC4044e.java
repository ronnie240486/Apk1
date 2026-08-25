package p237w0;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.internal.ViewOnAttachStateChangeListenerC1815c0;
import com.p2serv.android.p032ds.R;
import java.lang.ref.ReferenceQueue;
import p002a1.ChoreographerFrameCallbackC0025a;
import p003a2.AbstractC0032a;
import p173q1.RunnableC3431n1;

public abstract class AbstractC4044e extends AbstractC0032a {

    public static final boolean f13693i = true;

    public static final ReferenceQueue f13694j = new ReferenceQueue();

    public static final ViewOnAttachStateChangeListenerC1815c0 f13695k = new ViewOnAttachStateChangeListenerC1815c0(1);

    public final RunnableC3431n1 f13696b;

    public boolean f13697c;

    public final View f13698d;

    public boolean f13699e;

    public final Choreographer f13700f;

    public final ChoreographerFrameCallbackC0025a f13701g;

    public final Handler f13702h;

    public AbstractC4044e(Object obj, int i6, View view) {
        if (obj != null) {
            throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
        }
        this.f13696b = new RunnableC3431n1(6, this);
        this.f13697c = false;
        AbstractC4045f[] abstractC4045fArr = new AbstractC4045f[i6];
        this.f13698d = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        }
        if (f13693i) {
            this.f13700f = Choreographer.getInstance();
            this.f13701g = new ChoreographerFrameCallbackC0025a(1, this);
        } else {
            this.f13701g = null;
            this.f13702h = new Handler(Looper.myLooper());
        }
    }

    public static void m8046Q(View view, Object[] objArr, SparseIntArray sparseIntArray, boolean z7) {
        int id;
        int i6;
        int i10;
        int length;
        if ((view != null ? (AbstractC4044e) view.getTag(R.id.dataBinding) : null) != null) {
            return;
        }
        Object tag = view.getTag();
        String str = tag instanceof String ? (String) tag : null;
        if (z7 && str != null && str.startsWith(TtmlNode.TAG_LAYOUT)) {
            int iLastIndexOf = str.lastIndexOf(95);
            if (iLastIndexOf <= 0 || (length = str.length()) == (i10 = iLastIndexOf + 1)) {
                id = view.getId();
                if (id > 0) {
                    objArr[i6] = view;
                }
            } else {
                int i11 = i10;
                while (true) {
                    if (i11 >= length) {
                        int length2 = str.length();
                        int iCharAt = 0;
                        while (i10 < length2) {
                            iCharAt = (iCharAt * 10) + (str.charAt(i10) - '0');
                            i10++;
                        }
                        if (objArr[iCharAt] == null) {
                            objArr[iCharAt] = view;
                        }
                    } else if (Character.isDigit(str.charAt(i11))) {
                        i11++;
                    } else {
                        id = view.getId();
                        if (id > 0) {
                            objArr[i6] = view;
                        }
                    }
                }
            }
        } else if (str == null || !str.startsWith("binding_")) {
            id = view.getId();
            if (id > 0 && sparseIntArray != null && (i6 = sparseIntArray.get(id, -1)) >= 0 && objArr[i6] == null) {
                objArr[i6] = view;
            }
        } else {
            int length3 = str.length();
            int iCharAt2 = 0;
            for (int i12 = 8; i12 < length3; i12++) {
                iCharAt2 = (iCharAt2 * 10) + (str.charAt(i12) - '0');
            }
            if (objArr[iCharAt2] == null) {
                objArr[iCharAt2] = view;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                m8046Q(viewGroup.getChildAt(i13), objArr, sparseIntArray, false);
            }
        }
    }

    public static Object[] m8047R(View view, int i6, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i6];
        m8046Q(view, objArr, sparseIntArray, true);
        return objArr;
    }

    public abstract void mo5800O();

    public abstract boolean mo5801P();

    public final void m8048S() {
        synchronized (this) {
            try {
                if (this.f13697c) {
                    return;
                }
                this.f13697c = true;
                if (f13693i) {
                    this.f13700f.postFrameCallback(this.f13701g);
                } else {
                    this.f13702h.post(this.f13696b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m8049T(View view) {
        view.setTag(R.id.dataBinding, this);
    }
}
