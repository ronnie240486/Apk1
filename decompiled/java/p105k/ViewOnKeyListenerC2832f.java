package p105k;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.AbstractC0198e2;
import androidx.appcompat.widget.AbstractC0203f2;
import androidx.appcompat.widget.C0218i2;
import androidx.appcompat.widget.C0267s1;
import androidx.appcompat.widget.ViewTreeObserverOnGlobalLayoutListenerC0255q;
import com.google.android.material.textfield.ViewOnAttachStateChangeListenerC1873k;
import com.p2serv.android.p032ds.R;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p055ea.AbstractC2460q;
import p101j7.C2782c;
import p138n0.AbstractC3155s0;

public final class ViewOnKeyListenerC2832f extends AbstractC2846t implements View.OnKeyListener, PopupWindow.OnDismissListener {

    public final Context f9647b;

    public final int f9648c;

    public final int f9649d;

    public final boolean f9650e;

    public final Handler f9651f;

    public final ViewOnAttachStateChangeListenerC1873k f9655j;

    public final C2782c f9656k;

    public View f9659n;

    public View f9660o;

    public int f9661p;

    public boolean f9662q;

    public boolean f9663r;

    public int f9664s;

    public int f9665t;

    public boolean f9667v;

    public InterfaceC2850x f9668w;

    public ViewTreeObserver f9669x;

    public C2847u f9670y;

    public boolean f9671z;

    public final ArrayList f9652g = new ArrayList();

    public final ArrayList f9653h = new ArrayList();

    public final ViewTreeObserverOnGlobalLayoutListenerC0255q f9654i = new ViewTreeObserverOnGlobalLayoutListenerC0255q(4, this);

    public int f9657l = 0;

    public int f9658m = 0;

    public boolean f9666u = false;

    public ViewOnKeyListenerC2832f(Context context, View view, int i6, boolean z7) {
        int i10 = 1;
        this.f9655j = new ViewOnAttachStateChangeListenerC1873k(i10, this);
        this.f9656k = new C2782c(i10, this);
        this.f9647b = context;
        this.f9659n = view;
        this.f9649d = i6;
        this.f9650e = z7;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        this.f9661p = view.getLayoutDirection() == 1 ? 0 : 1;
        Resources resources = context.getResources();
        this.f9648c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f9651f = new Handler();
    }

    @Override
    public final void mo576a() {
        if (mo578c()) {
            return;
        }
        ArrayList arrayList = this.f9652g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m5821x((MenuC2838l) it.next());
        }
        arrayList.clear();
        View view = this.f9659n;
        this.f9660o = view;
        if (view != null) {
            boolean z7 = this.f9669x == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f9669x = viewTreeObserver;
            if (z7) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f9654i);
            }
            this.f9660o.addOnAttachStateChangeListener(this.f9655j);
        }
    }

    @Override
    public final void mo707b(MenuC2838l menuC2838l, boolean z7) {
        ArrayList arrayList = this.f9653h;
        int size = arrayList.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                i6 = -1;
                break;
            } else if (menuC2838l == ((C2830e) arrayList.get(i6)).f9643b) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 < 0) {
            return;
        }
        int i10 = i6 + 1;
        if (i10 < arrayList.size()) {
            ((C2830e) arrayList.get(i10)).f9643b.m5827c(false);
        }
        C2830e c2830e = (C2830e) arrayList.remove(i6);
        c2830e.f9643b.m5833r(this);
        boolean z10 = this.f9671z;
        C0218i2 c0218i2 = c2830e.f9642a;
        if (z10) {
            if (Build.VERSION.SDK_INT >= 23) {
                AbstractC0198e2.m659b(c0218i2.f715y, null);
            }
            c0218i2.f715y.setAnimationStyle(0);
        }
        c0218i2.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.f9661p = ((C2830e) arrayList.get(size2 - 1)).f9644c;
        } else {
            View view = this.f9659n;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            this.f9661p = view.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z7) {
                ((C2830e) arrayList.get(0)).f9643b.m5827c(false);
                return;
            }
            return;
        }
        dismiss();
        InterfaceC2850x interfaceC2850x = this.f9668w;
        if (interfaceC2850x != null) {
            interfaceC2850x.mo86b(menuC2838l, true);
        }
        ViewTreeObserver viewTreeObserver = this.f9669x;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f9669x.removeGlobalOnLayoutListener(this.f9654i);
            }
            this.f9669x = null;
        }
        this.f9660o.removeOnAttachStateChangeListener(this.f9655j);
        this.f9670y.onDismiss();
    }

    @Override
    public final boolean mo578c() {
        ArrayList arrayList = this.f9653h;
        return arrayList.size() > 0 && ((C2830e) arrayList.get(0)).f9642a.f715y.isShowing();
    }

    @Override
    public final void dismiss() {
        ArrayList arrayList = this.f9653h;
        int size = arrayList.size();
        if (size > 0) {
            C2830e[] c2830eArr = (C2830e[]) arrayList.toArray(new C2830e[size]);
            for (int i6 = size - 1; i6 >= 0; i6--) {
                C2830e c2830e = c2830eArr[i6];
                if (c2830e.f9642a.f715y.isShowing()) {
                    c2830e.f9642a.dismiss();
                }
            }
        }
    }

    @Override
    public final boolean mo709e(SubMenuC2831e0 subMenuC2831e0) {
        for (C2830e c2830e : this.f9653h) {
            if (subMenuC2831e0 == c2830e.f9643b) {
                c2830e.f9642a.f693c.requestFocus();
                return true;
            }
        }
        if (!subMenuC2831e0.hasVisibleItems()) {
            return false;
        }
        mo5805n(subMenuC2831e0);
        InterfaceC2850x interfaceC2850x = this.f9668w;
        if (interfaceC2850x != null) {
            interfaceC2850x.mo90f(subMenuC2831e0);
        }
        return true;
    }

    @Override
    public final C0267s1 mo581h() {
        ArrayList arrayList = this.f9653h;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((C2830e) AbstractC2460q.m5491e(1, arrayList)).f9642a.f693c;
    }

    @Override
    public final void mo5804i(InterfaceC2850x interfaceC2850x) {
        this.f9668w = interfaceC2850x;
    }

    @Override
    public final void mo712j(boolean z7) {
        Iterator it = this.f9653h.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((C2830e) it.next()).f9642a.f693c.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((C2835i) adapter).notifyDataSetChanged();
        }
    }

    @Override
    public final boolean mo714l() {
        return false;
    }

    @Override
    public final Parcelable mo715m() {
        return null;
    }

    @Override
    public final void mo5805n(MenuC2838l menuC2838l) {
        menuC2838l.m5826b(this, this.f9647b);
        if (mo578c()) {
            m5821x(menuC2838l);
        } else {
            this.f9652g.add(menuC2838l);
        }
    }

    @Override
    public final void onDismiss() {
        C2830e c2830e;
        ArrayList arrayList = this.f9653h;
        int size = arrayList.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                c2830e = null;
                break;
            }
            c2830e = (C2830e) arrayList.get(i6);
            if (!c2830e.f9642a.f715y.isShowing()) {
                break;
            } else {
                i6++;
            }
        }
        if (c2830e != null) {
            c2830e.f9643b.m5827c(false);
        }
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i6 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override
    public final void mo5806p(View view) {
        if (this.f9659n != view) {
            this.f9659n = view;
            int i6 = this.f9657l;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            this.f9658m = Gravity.getAbsoluteGravity(i6, view.getLayoutDirection());
        }
    }

    @Override
    public final void mo5807q(boolean z7) {
        this.f9666u = z7;
    }

    @Override
    public final void mo5808r(int i6) {
        if (this.f9657l != i6) {
            this.f9657l = i6;
            View view = this.f9659n;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            this.f9658m = Gravity.getAbsoluteGravity(i6, view.getLayoutDirection());
        }
    }

    @Override
    public final void mo5809s(int i6) {
        this.f9662q = true;
        this.f9664s = i6;
    }

    @Override
    public final void mo5810t(PopupWindow.OnDismissListener onDismissListener) {
        this.f9670y = (C2847u) onDismissListener;
    }

    @Override
    public final void mo5811u(boolean z7) {
        this.f9667v = z7;
    }

    @Override
    public final void mo5812v(int i6) {
        this.f9663r = true;
        this.f9665t = i6;
    }

    public final void m5821x(MenuC2838l menuC2838l) {
        View childAt;
        C2830e c2830e;
        char c5;
        int i6;
        int i10;
        int width;
        MenuItem item;
        C2835i c2835i;
        int headersCount;
        int i11;
        int firstVisiblePosition;
        Context context = this.f9647b;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        C2835i c2835i2 = new C2835i(menuC2838l, layoutInflaterFrom, this.f9650e, R.layout.abc_cascading_menu_item_layout);
        if (!mo578c() && this.f9666u) {
            c2835i2.f9682c = true;
        } else if (mo578c()) {
            c2835i2.f9682c = AbstractC2846t.m5852w(menuC2838l);
        }
        int iM5851o = AbstractC2846t.m5851o(c2835i2, context, this.f9648c);
        C0218i2 c0218i2 = new C0218i2(context, null, this.f9649d, 0);
        PopupWindow popupWindow = c0218i2.f715y;
        c0218i2.f949C = this.f9656k;
        c0218i2.f706p = this;
        popupWindow.setOnDismissListener(this);
        c0218i2.f705o = this.f9659n;
        c0218i2.f702l = this.f9658m;
        c0218i2.f714x = true;
        popupWindow.setFocusable(true);
        popupWindow.setInputMethodMode(2);
        c0218i2.mo586q(c2835i2);
        c0218i2.m587r(iM5851o);
        c0218i2.f702l = this.f9658m;
        ArrayList arrayList = this.f9653h;
        if (arrayList.size() > 0) {
            c2830e = (C2830e) AbstractC2460q.m5491e(1, arrayList);
            MenuC2838l menuC2838l2 = c2830e.f9643b;
            int size = menuC2838l2.f9692f.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size) {
                    item = null;
                    break;
                }
                item = menuC2838l2.getItem(i12);
                if (item.hasSubMenu() && menuC2838l == item.getSubMenu()) {
                    break;
                } else {
                    i12++;
                }
            }
            if (item == null) {
                childAt = null;
            } else {
                C0267s1 c0267s1 = c2830e.f9642a.f693c;
                ListAdapter adapter = c0267s1.getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    c2835i = (C2835i) headerViewListAdapter.getWrappedAdapter();
                } else {
                    c2835i = (C2835i) adapter;
                    headersCount = 0;
                }
                int count = c2835i.getCount();
                int i13 = 0;
                while (true) {
                    if (i13 >= count) {
                        i11 = -1;
                        i13 = -1;
                        break;
                    } else {
                        if (item == c2835i.getItem(i13)) {
                            i11 = -1;
                            break;
                        }
                        i13++;
                    }
                }
                childAt = (i13 != i11 && (firstVisiblePosition = (i13 + headersCount) - c0267s1.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < c0267s1.getChildCount()) ? c0267s1.getChildAt(firstVisiblePosition) : null;
            }
        } else {
            childAt = null;
            c2830e = null;
        }
        if (childAt != null) {
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = C0218i2.f948D;
                if (method != null) {
                    try {
                        method.invoke(popupWindow, Boolean.FALSE);
                    } catch (Exception unused) {
                        Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                    }
                }
            } else {
                AbstractC0203f2.m661a(popupWindow, false);
            }
            int i14 = Build.VERSION.SDK_INT;
            if (i14 >= 23) {
                AbstractC0198e2.m658a(popupWindow, null);
            }
            C0267s1 c0267s2 = ((C2830e) AbstractC2460q.m5491e(1, arrayList)).f9642a.f693c;
            int[] iArr = new int[2];
            c0267s2.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            this.f9660o.getWindowVisibleDisplayFrame(rect);
            int i15 = (this.f9661p != 1 ? iArr[0] - iM5851o >= 0 : (c0267s2.getWidth() + iArr[0]) + iM5851o > rect.right) ? 0 : 1;
            boolean z7 = i15 == 1;
            this.f9661p = i15;
            if (i14 >= 26) {
                c0218i2.f705o = childAt;
                i10 = 0;
                i6 = 0;
            } else {
                int[] iArr2 = new int[2];
                this.f9659n.getLocationOnScreen(iArr2);
                int[] iArr3 = new int[2];
                childAt.getLocationOnScreen(iArr3);
                if ((this.f9658m & 7) == 5) {
                    c5 = 0;
                    iArr2[0] = this.f9659n.getWidth() + iArr2[0];
                    iArr3[0] = childAt.getWidth() + iArr3[0];
                } else {
                    c5 = 0;
                }
                i6 = iArr3[c5] - iArr2[c5];
                i10 = iArr3[1] - iArr2[1];
            }
            if ((this.f9658m & 5) == 5) {
                width = z7 ? i6 + iM5851o : i6 - childAt.getWidth();
            } else {
                width = z7 ? i6 + childAt.getWidth() : i6 - iM5851o;
            }
            c0218i2.f696f = width;
            c0218i2.f701k = true;
            c0218i2.f700j = true;
            c0218i2.m583j(i10);
        } else {
            if (this.f9662q) {
                c0218i2.f696f = this.f9664s;
            }
            if (this.f9663r) {
                c0218i2.m583j(this.f9665t);
            }
            Rect rect2 = this.f9753a;
            c0218i2.f713w = rect2 != null ? new Rect(rect2) : null;
        }
        arrayList.add(new C2830e(c0218i2, menuC2838l, this.f9661p));
        c0218i2.mo576a();
        C0267s1 c0267s3 = c0218i2.f693c;
        c0267s3.setOnKeyListener(this);
        if (c2830e == null && this.f9667v && menuC2838l.f9699m != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) c0267s3, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(menuC2838l.f9699m);
            c0267s3.addHeaderView(frameLayout, null, false);
            c0218i2.mo576a();
        }
    }

    @Override
    public final void mo710g(Parcelable parcelable) {
    }
}
