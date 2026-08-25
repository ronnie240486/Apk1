package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.p2serv.android.p032ds.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p045e.AbstractC2341a;
import p105k.InterfaceC2827c0;
import p123l5.AbstractC2973a;
import p138n0.AbstractC3155s0;

public class ListPopupWindow implements InterfaceC2827c0 {

    public static final Method f688A;

    public static final Method f689B;

    public static final Method f690z;

    public final Context f691a;

    public ListAdapter f692b;

    public C0267s1 f693c;

    public final int f694d;

    public int f695e;

    public int f696f;

    public int f697g;

    public final int f698h;

    public boolean f699i;

    public boolean f700j;

    public boolean f701k;

    public int f702l;

    public final int f703m;

    public C0175a2 f704n;

    public View f705o;

    public AdapterView.OnItemClickListener f706p;

    public final RunnableC0302z1 f707q;

    public final ViewOnTouchListenerC0187c2 f708r;

    public final C0181b2 f709s;

    public final RunnableC0302z1 f710t;

    public final Handler f711u;

    public final Rect f712v;

    public Rect f713w;

    public boolean f714x;

    public final PopupWindow f715y;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f690z = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f689B = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f688A = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    @Override
    public final void mo576a() {
        int i6;
        int iM827a;
        int iMakeMeasureSpec;
        int paddingBottom;
        C0267s1 c0267s1;
        int i10 = 0;
        C0267s1 c0267s2 = this.f693c;
        PopupWindow popupWindow = this.f715y;
        Context context = this.f691a;
        if (c0267s2 == null) {
            C0267s1 c0267s1Mo577b = mo577b(context, !this.f714x);
            this.f693c = c0267s1Mo577b;
            c0267s1Mo577b.setAdapter(this.f692b);
            this.f693c.setOnItemClickListener(this.f706p);
            this.f693c.setFocusable(true);
            this.f693c.setFocusableInTouchMode(true);
            this.f693c.setOnItemSelectedListener(new C0287w1(i10, this));
            this.f693c.setOnScrollListener(this.f709s);
            popupWindow.setContentView(this.f693c);
        }
        Drawable background = popupWindow.getBackground();
        Rect rect = this.f712v;
        if (background != null) {
            background.getPadding(rect);
            int i11 = rect.top;
            i6 = rect.bottom + i11;
            if (!this.f699i) {
                this.f697g = -i11;
            }
        } else {
            rect.setEmpty();
            i6 = 0;
        }
        boolean z7 = popupWindow.getInputMethodMode() == 2;
        View view = this.f705o;
        int i12 = this.f697g;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = f688A;
            if (method != null) {
                try {
                    iM827a = ((Integer) method.invoke(popupWindow, view, Integer.valueOf(i12), Boolean.valueOf(z7))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                    iM827a = popupWindow.getMaxAvailableHeight(view, i12);
                }
            } else {
                iM827a = popupWindow.getMaxAvailableHeight(view, i12);
            }
        } else {
            iM827a = AbstractC0292x1.m827a(popupWindow, view, i12, z7);
        }
        int i13 = this.f694d;
        if (i13 == -1) {
            paddingBottom = iM827a + i6;
        } else {
            int i14 = this.f695e;
            if (i14 != -2) {
                iMakeMeasureSpec = i14 != -1 ? View.MeasureSpec.makeMeasureSpec(i14, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824);
            } else {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE);
            }
            int iM769a = this.f693c.m769a(iMakeMeasureSpec, iM827a);
            paddingBottom = iM769a + (iM769a > 0 ? this.f693c.getPaddingBottom() + this.f693c.getPaddingTop() + i6 : 0);
        }
        boolean z10 = this.f715y.getInputMethodMode() == 2;
        AbstractC2973a.m6012Q(popupWindow, this.f698h);
        if (popupWindow.isShowing()) {
            View view2 = this.f705o;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if (view2.isAttachedToWindow()) {
                int width = this.f695e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.f705o.getWidth();
                }
                if (i13 == -1) {
                    i13 = z10 ? paddingBottom : -1;
                    if (z10) {
                        popupWindow.setWidth(this.f695e == -1 ? -1 : 0);
                        popupWindow.setHeight(0);
                    } else {
                        popupWindow.setWidth(this.f695e == -1 ? -1 : 0);
                        popupWindow.setHeight(-1);
                    }
                } else if (i13 == -2) {
                    i13 = paddingBottom;
                }
                popupWindow.setOutsideTouchable(true);
                popupWindow.update(this.f705o, this.f696f, this.f697g, width < 0 ? -1 : width, i13 < 0 ? -1 : i13);
                return;
            }
            return;
        }
        int width2 = this.f695e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.f705o.getWidth();
        }
        if (i13 == -1) {
            i13 = -1;
        } else if (i13 == -2) {
            i13 = paddingBottom;
        }
        popupWindow.setWidth(width2);
        popupWindow.setHeight(i13);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = f690z;
            if (method2 != null) {
                try {
                    method2.invoke(popupWindow, Boolean.TRUE);
                } catch (Exception unused2) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            AbstractC0297y1.m833b(popupWindow, true);
        }
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(this.f708r);
        if (this.f701k) {
            AbstractC2973a.m6011M(popupWindow, this.f700j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method3 = f689B;
            if (method3 != null) {
                try {
                    method3.invoke(popupWindow, this.f713w);
                } catch (Exception e5) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e5);
                }
            }
        } else {
            AbstractC0297y1.m832a(popupWindow, this.f713w);
        }
        popupWindow.showAsDropDown(this.f705o, this.f696f, this.f697g, this.f702l);
        this.f693c.setSelection(-1);
        if ((!this.f714x || this.f693c.isInTouchMode()) && (c0267s1 = this.f693c) != null) {
            c0267s1.setListSelectionHidden(true);
            c0267s1.requestLayout();
        }
        if (this.f714x) {
            return;
        }
        this.f711u.post(this.f710t);
    }

    public C0267s1 mo577b(Context context, boolean z7) {
        return new C0267s1(context, z7);
    }

    @Override
    public final boolean mo578c() {
        return this.f715y.isShowing();
    }

    @Override
    public final void dismiss() {
        PopupWindow popupWindow = this.f715y;
        popupWindow.dismiss();
        popupWindow.setContentView(null);
        this.f693c = null;
        this.f711u.removeCallbacks(this.f707q);
    }

    public final int m579e() {
        return this.f696f;
    }

    public final Drawable m580f() {
        return this.f715y.getBackground();
    }

    @Override
    public final C0267s1 mo581h() {
        return this.f693c;
    }

    public final void m582i(Drawable drawable) {
        this.f715y.setBackgroundDrawable(drawable);
    }

    public final void m583j(int i6) {
        this.f697g = i6;
        this.f699i = true;
    }

    public final void m584m(int i6) {
        this.f696f = i6;
    }

    public final int m585o() {
        if (this.f699i) {
            return this.f697g;
        }
        return 0;
    }

    public void mo586q(ListAdapter listAdapter) {
        C0175a2 c0175a2 = this.f704n;
        if (c0175a2 == null) {
            this.f704n = new C0175a2(0, this);
        } else {
            ListAdapter listAdapter2 = this.f692b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(c0175a2);
            }
        }
        this.f692b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f704n);
        }
        C0267s1 c0267s1 = this.f693c;
        if (c0267s1 != null) {
            c0267s1.setAdapter(this.f692b);
        }
    }

    public final void m587r(int i6) {
        Drawable background = this.f715y.getBackground();
        if (background == null) {
            this.f695e = i6;
            return;
        }
        Rect rect = this.f712v;
        background.getPadding(rect);
        this.f695e = rect.left + rect.right + i6;
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i6) {
        this(context, attributeSet, i6, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i6, int i10) {
        this.f694d = -2;
        this.f695e = -2;
        this.f698h = 1002;
        this.f702l = 0;
        this.f703m = Integer.MAX_VALUE;
        this.f707q = new RunnableC0302z1(this, 1);
        this.f708r = new ViewOnTouchListenerC0187c2(0, this);
        this.f709s = new C0181b2(this);
        this.f710t = new RunnableC0302z1(this, 0);
        this.f712v = new Rect();
        this.f691a = context;
        this.f711u = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2341a.f8168p, i6, 0);
        this.f696f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f697g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f699i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i6, 0);
        appCompatPopupWindow.m568a(context, attributeSet, i6);
        this.f715y = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }
}
