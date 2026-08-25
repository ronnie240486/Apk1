package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.customview.view.AbsSavedState;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import p001a0.AbstractC0024g;
import p001a0.C0019b;
import p001a0.C0022e;
import p001a0.C0023f;
import p001a0.ViewGroupOnHierarchyChangeListenerC0020c;
import p001a0.ViewTreeObserverOnPreDrawListenerC0021d;
import p034d0.AbstractC2115a;
import p128m0.C3028d;
import p138n0.AbstractC3113e0;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p138n0.C3151r;
import p138n0.C3153r1;
import p138n0.InterfaceC3145p;
import p138n0.InterfaceC3148q;
import p143n5.AbstractC3198d;
import p160p.C3347k;
import p266z.AbstractC4282a;

public class CoordinatorLayout extends ViewGroup implements InterfaceC3145p, InterfaceC3148q {

    public static final String f1417t;

    public static final Class[] f1418u;

    public static final ThreadLocal f1419v;

    public static final C0022e f1420w;

    public static final C3028d f1421x;

    public final ArrayList f1422a;

    public final C0023f f1423b;

    public final ArrayList f1424c;

    public final ArrayList f1425d;

    public final int[] f1426e;

    public final int[] f1427f;

    public boolean f1428g;

    public boolean f1429h;

    public final int[] f1430i;

    public View f1431j;

    public View f1432k;

    public ViewTreeObserverOnPreDrawListenerC0021d f1433l;

    public boolean f1434m;

    public C3153r1 f1435n;

    public boolean f1436o;

    public Drawable f1437p;

    public ViewGroup.OnHierarchyChangeListener f1438q;

    public C0019b f1439r;

    public final C3151r f1440s;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0312d();

        public SparseArray f1441c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i6 = parcel.readInt();
            int[] iArr = new int[i6];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f1441c = new SparseArray(i6);
            for (int i10 = 0; i10 < i6; i10++) {
                this.f1441c.append(iArr[i10], parcelableArray[i10]);
            }
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            SparseArray sparseArray = this.f1441c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i10 = 0; i10 < size; i10++) {
                iArr[i10] = this.f1441c.keyAt(i10);
                parcelableArr[i10] = (Parcelable) this.f1441c.valueAt(i10);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i6);
        }
    }

    static {
        int i6 = 0;
        Package r10 = CoordinatorLayout.class.getPackage();
        f1417t = r10 != null ? r10.getName() : null;
        f1420w = new C0022e(i6);
        f1418u = new Class[]{Context.class, AttributeSet.class};
        f1419v = new ThreadLocal();
        f1421x = new C3028d(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    public static void m900A(int i6, View view) {
        C0311c c0311c = (C0311c) view.getLayoutParams();
        int i10 = c0311c.f1450i;
        if (i10 != i6) {
            AbstractC3155s0.m6339i(i6 - i10, view);
            c0311c.f1450i = i6;
        }
    }

    public static void m901B(int i6, View view) {
        C0311c c0311c = (C0311c) view.getLayoutParams();
        int i10 = c0311c.f1451j;
        if (i10 != i6) {
            AbstractC3155s0.m6340j(i6 - i10, view);
            c0311c.f1451j = i6;
        }
    }

    public static Rect m902k() {
        Rect rect = (Rect) f1421x.mo6099a();
        return rect == null ? new Rect() : rect;
    }

    public static void m903q(int i6, Rect rect, Rect rect2, C0311c c0311c, int i10, int i11) {
        int iWidth;
        int iHeight;
        int i12 = c0311c.f1444c;
        if (i12 == 0) {
            i12 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i12, i6);
        int i13 = c0311c.f1445d;
        if ((i13 & 7) == 0) {
            i13 |= 8388611;
        }
        if ((i13 & 112) == 0) {
            i13 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i13, i6);
        int i14 = absoluteGravity & 7;
        int i15 = absoluteGravity & 112;
        int i16 = absoluteGravity2 & 7;
        int i17 = absoluteGravity2 & 112;
        if (i16 != 1) {
            iWidth = i16 != 5 ? rect.left : rect.right;
        } else {
            iWidth = rect.left + (rect.width() / 2);
        }
        if (i17 != 16) {
            iHeight = i17 != 80 ? rect.top : rect.bottom;
        } else {
            iHeight = rect.top + (rect.height() / 2);
        }
        if (i14 == 1) {
            iWidth -= i10 / 2;
        } else if (i14 != 5) {
            iWidth -= i10;
        }
        if (i15 == 16) {
            iHeight -= i11 / 2;
        } else if (i15 != 80) {
            iHeight -= i11;
        }
        rect2.set(iWidth, iHeight, i10 + iWidth, i11 + iHeight);
    }

    public static C0311c m904s(View view) {
        C0311c c0311c = (C0311c) view.getLayoutParams();
        if (!c0311c.f1443b) {
            if (view instanceof InterfaceC0309a) {
                Behavior behavior = ((InterfaceC0309a) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                Behavior behavior2 = c0311c.f1442a;
                if (behavior2 != behavior) {
                    if (behavior2 != null) {
                        behavior2.mo924f();
                    }
                    c0311c.f1442a = behavior;
                    c0311c.f1443b = true;
                    if (behavior != null) {
                        behavior.mo921c(c0311c);
                    }
                }
                c0311c.f1443b = true;
            } else {
                InterfaceC0310b interfaceC0310b = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    interfaceC0310b = (InterfaceC0310b) superclass.getAnnotation(InterfaceC0310b.class);
                    if (interfaceC0310b != null) {
                        break;
                    }
                }
                if (interfaceC0310b != null) {
                    try {
                        Behavior behavior3 = (Behavior) interfaceC0310b.value().getDeclaredConstructor(null).newInstance(null);
                        Behavior behavior4 = c0311c.f1442a;
                        if (behavior4 != behavior3) {
                            if (behavior4 != null) {
                                behavior4.mo924f();
                            }
                            c0311c.f1442a = behavior3;
                            c0311c.f1443b = true;
                            if (behavior3 != null) {
                                behavior3.mo921c(c0311c);
                            }
                        }
                    } catch (Exception e5) {
                        Log.e("CoordinatorLayout", "Default behavior class " + interfaceC0310b.value().getName() + " could not be instantiated. Did you forget a default constructor?", e5);
                    }
                }
                c0311c.f1443b = true;
            }
        }
        return c0311c;
    }

    public final void m905C() {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (!getFitsSystemWindows()) {
            AbstractC3119g0.m6182u(this, null);
            return;
        }
        if (this.f1439r == null) {
            this.f1439r = new C0019b(0, this);
        }
        AbstractC3119g0.m6182u(this, this.f1439r);
        setSystemUiVisibility(1280);
    }

    @Override
    public final void mo547a(View view, View view2, int i6, int i10) {
        C3151r c3151r = this.f1440s;
        if (i10 == 1) {
            c3151r.f10635b = i6;
        } else {
            c3151r.f10634a = i6;
        }
        this.f1432k = view2;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            ((C0311c) getChildAt(i11).getLayoutParams()).getClass();
        }
    }

    @Override
    public final void mo548b(View view, int i6, int i10, int[] iArr, int i11) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z7 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                C0311c c0311c = (C0311c) childAt.getLayoutParams();
                if (c0311c.m937a(i11) && (behavior = c0311c.f1442a) != null) {
                    int[] iArr2 = this.f1426e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.mo929k(this, childAt, view, i6, i10, iArr2, i11);
                    iMax = i6 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i10 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z7 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z7) {
            m913u(1);
        }
    }

    @Override
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0311c) && super.checkLayoutParams(layoutParams);
    }

    @Override
    public final boolean drawChild(Canvas canvas, View view, long j10) {
        Behavior behavior = ((C0311c) view.getLayoutParams()).f1442a;
        if (behavior != null) {
            behavior.getClass();
        }
        return super.drawChild(canvas, view, j10);
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1437p;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override
    public final void mo551f(int i6, View view) {
        C3151r c3151r = this.f1440s;
        if (i6 == 1) {
            c3151r.f10635b = 0;
        } else {
            c3151r.f10634a = 0;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            C0311c c0311c = (C0311c) childAt.getLayoutParams();
            if (c0311c.m937a(i6)) {
                Behavior behavior = c0311c.f1442a;
                if (behavior != null) {
                    behavior.mo935q(this, childAt, view, i6);
                }
                if (i6 == 0) {
                    c0311c.f1454m = false;
                } else if (i6 == 1) {
                    c0311c.f1455n = false;
                }
                c0311c.f1456o = false;
            }
        }
        this.f1432k = null;
    }

    @Override
    public final void mo552g(View view, int i6, int i10, int i11, int i12, int i13, int[] iArr) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z7 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                C0311c c0311c = (C0311c) childAt.getLayoutParams();
                if (c0311c.m937a(i13) && (behavior = c0311c.f1442a) != null) {
                    int[] iArr2 = this.f1426e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.mo930l(this, childAt, i10, i11, i12, iArr2);
                    iMax = i11 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i12 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z7 = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z7) {
            m913u(1);
        }
    }

    @Override
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0311c();
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0311c(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        m917y();
        return Collections.unmodifiableList(this.f1422a);
    }

    public final C3153r1 getLastWindowInsets() {
        return this.f1435n;
    }

    @Override
    public int getNestedScrollAxes() {
        C3151r c3151r = this.f1440s;
        return c3151r.f10635b | c3151r.f10634a;
    }

    public Drawable getStatusBarBackground() {
        return this.f1437p;
    }

    @Override
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    @Override
    public final void mo554i(View view, int i6, int i10, int i11, int i12, int i13) {
        mo552g(view, i6, i10, i11, i12, 0, this.f1427f);
    }

    @Override
    public final boolean mo555j(View view, View view2, int i6, int i10) {
        int childCount = getChildCount();
        boolean z7 = false;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                C0311c c0311c = (C0311c) childAt.getLayoutParams();
                Behavior behavior = c0311c.f1442a;
                if (behavior != null) {
                    boolean zMo934p = behavior.mo934p(this, childAt, view, view2, i6, i10);
                    z7 |= zMo934p;
                    if (i10 == 0) {
                        c0311c.f1454m = zMo934p;
                    } else if (i10 == 1) {
                        c0311c.f1455n = zMo934p;
                    }
                } else if (i10 == 0) {
                    c0311c.f1454m = false;
                } else if (i10 == 1) {
                    c0311c.f1455n = false;
                }
            }
        }
        return z7;
    }

    public final void m906l(C0311c c0311c, Rect rect, int i6, int i10) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0311c).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i6) - ((ViewGroup.MarginLayoutParams) c0311c).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0311c).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i10) - ((ViewGroup.MarginLayoutParams) c0311c).bottomMargin));
        rect.set(iMax, iMax2, i6 + iMax, i10 + iMax2);
    }

    public final void m907m(View view) {
        List list = (List) ((C3347k) this.f1423b.f45c).get(view);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            View view2 = (View) list.get(i6);
            Behavior behavior = ((C0311c) view2.getLayoutParams()).f1442a;
            if (behavior != null) {
                behavior.mo922d(this, view2, view);
            }
        }
    }

    public final void m908n(View view, Rect rect, boolean z7) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z7) {
            m910p(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList m909o(View view) {
        C3347k c3347k = (C3347k) this.f1423b.f45c;
        int i6 = c3347k.f11334c;
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < i6; i10++) {
            ArrayList arrayList2 = (ArrayList) c3347k.m6816j(i10);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(c3347k.m6812f(i10));
            }
        }
        ArrayList arrayList3 = this.f1425d;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i6 = 0;
        m918z(false);
        if (this.f1434m) {
            if (this.f1433l == null) {
                this.f1433l = new ViewTreeObserverOnPreDrawListenerC0021d(i6, this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1433l);
        }
        if (this.f1435n == null) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if (getFitsSystemWindows()) {
                AbstractC3113e0.m6130c(this);
            }
        }
        this.f1429h = true;
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m918z(false);
        if (this.f1434m && this.f1433l != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1433l);
        }
        View view = this.f1432k;
        if (view != null) {
            mo551f(0, view);
        }
        this.f1429h = false;
    }

    @Override
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f1436o || this.f1437p == null) {
            return;
        }
        C3153r1 c3153r1 = this.f1435n;
        int iM6328d = c3153r1 != null ? c3153r1.m6328d() : 0;
        if (iM6328d > 0) {
            this.f1437p.setBounds(0, 0, getWidth(), iM6328d);
            this.f1437p.draw(canvas);
        }
    }

    @Override
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m918z(true);
        }
        boolean zM916x = m916x(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            m918z(true);
        }
        return zM916x;
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        Behavior behavior;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.f1422a;
        int size = arrayList.size();
        for (int i13 = 0; i13 < size; i13++) {
            View view = (View) arrayList.get(i13);
            if (view.getVisibility() != 8 && ((behavior = ((C0311c) view.getLayoutParams()).f1442a) == null || !behavior.mo926h(this, view, layoutDirection))) {
                m914v(layoutDirection, view);
            }
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        boolean z7;
        int i11;
        int i12;
        int i13;
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        Behavior behavior;
        int i14;
        ArrayList arrayList;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int iMax;
        int i22 = 0;
        m917y();
        int childCount = getChildCount();
        int i23 = 0;
        loop0: while (true) {
            if (i23 >= childCount) {
                z7 = false;
                break;
            }
            View childAt = getChildAt(i23);
            C3347k c3347k = (C3347k) this.f1423b.f45c;
            int i24 = c3347k.f11334c;
            for (int i25 = 0; i25 < i24; i25++) {
                ArrayList arrayList2 = (ArrayList) c3347k.m6816j(i25);
                if (arrayList2 != null && arrayList2.contains(childAt)) {
                    z7 = true;
                    break loop0;
                }
            }
            i23++;
        }
        if (z7 != this.f1434m) {
            if (z7) {
                if (this.f1429h) {
                    if (this.f1433l == null) {
                        this.f1433l = new ViewTreeObserverOnPreDrawListenerC0021d(i22, this);
                    }
                    getViewTreeObserver().addOnPreDrawListener(this.f1433l);
                }
                this.f1434m = true;
            } else {
                if (this.f1429h && this.f1433l != null) {
                    getViewTreeObserver().removeOnPreDrawListener(this.f1433l);
                }
                this.f1434m = false;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        int layoutDirection = getLayoutDirection();
        boolean z10 = layoutDirection == 1;
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i10);
        int i26 = paddingLeft + paddingRight;
        int i27 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z11 = this.f1435n != null && getFitsSystemWindows();
        ArrayList arrayList3 = this.f1422a;
        int size3 = arrayList3.size();
        int i28 = suggestedMinimumWidth;
        int i29 = suggestedMinimumHeight;
        int iCombineMeasuredStates = 0;
        int i30 = 0;
        while (i30 < size3) {
            View view = (View) arrayList3.get(i30);
            if (view.getVisibility() == 8) {
                i16 = i30;
                i14 = size3;
                arrayList = arrayList3;
                i18 = paddingLeft;
                i20 = paddingRight;
                i15 = layoutDirection;
            } else {
                C0311c c0311c = (C0311c) view.getLayoutParams();
                int i31 = c0311c.f1446e;
                if (i31 < 0 || mode == 0) {
                    i11 = iCombineMeasuredStates;
                    i12 = i30;
                } else {
                    int iM911r = m911r(i31);
                    i11 = iCombineMeasuredStates;
                    int i32 = c0311c.f1444c;
                    if (i32 == 0) {
                        i32 = 8388661;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i32, layoutDirection) & 7;
                    i12 = i30;
                    if ((absoluteGravity != 3 || z10) && !(absoluteGravity == 5 && z10)) {
                        if ((absoluteGravity == 5 && !z10) || (absoluteGravity == 3 && z10)) {
                            iMax = Math.max(0, iM911r - paddingLeft);
                        }
                        if (z11 || view.getFitsSystemWindows()) {
                            iMakeMeasureSpec = i6;
                            iMakeMeasureSpec2 = i10;
                        } else {
                            int iM6327c = this.f1435n.m6327c() + this.f1435n.m6326b();
                            int iM6325a = this.f1435n.m6325a() + this.f1435n.m6328d();
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - iM6327c, mode);
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2 - iM6325a, mode2);
                        }
                        behavior = c0311c.f1442a;
                        if (behavior != null) {
                            i16 = i12;
                            i18 = paddingLeft;
                            i19 = i11;
                            i20 = paddingRight;
                            i21 = i29;
                            i15 = layoutDirection;
                            i17 = i28;
                            i14 = size3;
                            arrayList = arrayList3;
                            if (!behavior.mo927i(this, view, iMakeMeasureSpec, i13, iMakeMeasureSpec2)) {
                            }
                            int iMax2 = Math.max(i17, view.getMeasuredWidth() + i26 + ((ViewGroup.MarginLayoutParams) c0311c).leftMargin + ((ViewGroup.MarginLayoutParams) c0311c).rightMargin);
                            int iMax3 = Math.max(i21, view.getMeasuredHeight() + i27 + ((ViewGroup.MarginLayoutParams) c0311c).topMargin + ((ViewGroup.MarginLayoutParams) c0311c).bottomMargin);
                            i28 = iMax2;
                            iCombineMeasuredStates = View.combineMeasuredStates(i19, view.getMeasuredState());
                            i29 = iMax3;
                        } else {
                            i14 = size3;
                            arrayList = arrayList3;
                            i15 = layoutDirection;
                            i16 = i12;
                            i17 = i28;
                            i18 = paddingLeft;
                            i19 = i11;
                            i20 = paddingRight;
                            i21 = i29;
                        }
                        measureChildWithMargins(view, iMakeMeasureSpec, i13, iMakeMeasureSpec2, 0);
                        int iMax4 = Math.max(i17, view.getMeasuredWidth() + i26 + ((ViewGroup.MarginLayoutParams) c0311c).leftMargin + ((ViewGroup.MarginLayoutParams) c0311c).rightMargin);
                        int iMax5 = Math.max(i21, view.getMeasuredHeight() + i27 + ((ViewGroup.MarginLayoutParams) c0311c).topMargin + ((ViewGroup.MarginLayoutParams) c0311c).bottomMargin);
                        i28 = iMax4;
                        iCombineMeasuredStates = View.combineMeasuredStates(i19, view.getMeasuredState());
                        i29 = iMax5;
                    } else {
                        iMax = Math.max(0, (size - paddingRight) - iM911r);
                    }
                    i13 = iMax;
                    if (z11) {
                        iMakeMeasureSpec = i6;
                        iMakeMeasureSpec2 = i10;
                    } else {
                        iMakeMeasureSpec = i6;
                        iMakeMeasureSpec2 = i10;
                    }
                    behavior = c0311c.f1442a;
                    if (behavior != null) {
                        i16 = i12;
                        i18 = paddingLeft;
                        i19 = i11;
                        i20 = paddingRight;
                        i21 = i29;
                        i15 = layoutDirection;
                        i17 = i28;
                        i14 = size3;
                        arrayList = arrayList3;
                        if (!behavior.mo927i(this, view, iMakeMeasureSpec, i13, iMakeMeasureSpec2)) {
                        }
                        int iMax6 = Math.max(i17, view.getMeasuredWidth() + i26 + ((ViewGroup.MarginLayoutParams) c0311c).leftMargin + ((ViewGroup.MarginLayoutParams) c0311c).rightMargin);
                        int iMax7 = Math.max(i21, view.getMeasuredHeight() + i27 + ((ViewGroup.MarginLayoutParams) c0311c).topMargin + ((ViewGroup.MarginLayoutParams) c0311c).bottomMargin);
                        i28 = iMax6;
                        iCombineMeasuredStates = View.combineMeasuredStates(i19, view.getMeasuredState());
                        i29 = iMax7;
                    } else {
                        i14 = size3;
                        arrayList = arrayList3;
                        i15 = layoutDirection;
                        i16 = i12;
                        i17 = i28;
                        i18 = paddingLeft;
                        i19 = i11;
                        i20 = paddingRight;
                        i21 = i29;
                    }
                    measureChildWithMargins(view, iMakeMeasureSpec, i13, iMakeMeasureSpec2, 0);
                    int iMax8 = Math.max(i17, view.getMeasuredWidth() + i26 + ((ViewGroup.MarginLayoutParams) c0311c).leftMargin + ((ViewGroup.MarginLayoutParams) c0311c).rightMargin);
                    int iMax9 = Math.max(i21, view.getMeasuredHeight() + i27 + ((ViewGroup.MarginLayoutParams) c0311c).topMargin + ((ViewGroup.MarginLayoutParams) c0311c).bottomMargin);
                    i28 = iMax8;
                    iCombineMeasuredStates = View.combineMeasuredStates(i19, view.getMeasuredState());
                    i29 = iMax9;
                }
                i13 = 0;
                if (z11) {
                    iMakeMeasureSpec = i6;
                    iMakeMeasureSpec2 = i10;
                } else {
                    iMakeMeasureSpec = i6;
                    iMakeMeasureSpec2 = i10;
                }
                behavior = c0311c.f1442a;
                if (behavior != null) {
                    i16 = i12;
                    i18 = paddingLeft;
                    i19 = i11;
                    i20 = paddingRight;
                    i21 = i29;
                    i15 = layoutDirection;
                    i17 = i28;
                    i14 = size3;
                    arrayList = arrayList3;
                    if (!behavior.mo927i(this, view, iMakeMeasureSpec, i13, iMakeMeasureSpec2)) {
                    }
                    int iMax10 = Math.max(i17, view.getMeasuredWidth() + i26 + ((ViewGroup.MarginLayoutParams) c0311c).leftMargin + ((ViewGroup.MarginLayoutParams) c0311c).rightMargin);
                    int iMax11 = Math.max(i21, view.getMeasuredHeight() + i27 + ((ViewGroup.MarginLayoutParams) c0311c).topMargin + ((ViewGroup.MarginLayoutParams) c0311c).bottomMargin);
                    i28 = iMax10;
                    iCombineMeasuredStates = View.combineMeasuredStates(i19, view.getMeasuredState());
                    i29 = iMax11;
                } else {
                    i14 = size3;
                    arrayList = arrayList3;
                    i15 = layoutDirection;
                    i16 = i12;
                    i17 = i28;
                    i18 = paddingLeft;
                    i19 = i11;
                    i20 = paddingRight;
                    i21 = i29;
                }
                measureChildWithMargins(view, iMakeMeasureSpec, i13, iMakeMeasureSpec2, 0);
                int iMax12 = Math.max(i17, view.getMeasuredWidth() + i26 + ((ViewGroup.MarginLayoutParams) c0311c).leftMargin + ((ViewGroup.MarginLayoutParams) c0311c).rightMargin);
                int iMax13 = Math.max(i21, view.getMeasuredHeight() + i27 + ((ViewGroup.MarginLayoutParams) c0311c).topMargin + ((ViewGroup.MarginLayoutParams) c0311c).bottomMargin);
                i28 = iMax12;
                iCombineMeasuredStates = View.combineMeasuredStates(i19, view.getMeasuredState());
                i29 = iMax13;
            }
            i30 = i16 + 1;
            paddingLeft = i18;
            paddingRight = i20;
            layoutDirection = i15;
            size3 = i14;
            arrayList3 = arrayList;
        }
        int i33 = iCombineMeasuredStates;
        setMeasuredDimension(View.resolveSizeAndState(i28, i6, (-16777216) & i33), View.resolveSizeAndState(i29, i10, i33 << 16));
    }

    @Override
    public final boolean onNestedFling(View view, float f, float f3, boolean z7) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0311c c0311c = (C0311c) childAt.getLayoutParams();
                if (c0311c.m937a(0)) {
                    Behavior behavior = c0311c.f1442a;
                }
            }
        }
        return false;
    }

    @Override
    public final boolean onNestedPreFling(View view, float f, float f3) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean zMo928j = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0311c c0311c = (C0311c) childAt.getLayoutParams();
                if (c0311c.m937a(0) && (behavior = c0311c.f1442a) != null) {
                    zMo928j |= behavior.mo928j(view);
                }
            }
        }
        return zMo928j;
    }

    @Override
    public final void onNestedPreScroll(View view, int i6, int i10, int[] iArr) {
        mo548b(view, i6, i10, iArr, 0);
    }

    @Override
    public final void onNestedScroll(View view, int i6, int i10, int i11, int i12) {
        mo554i(view, i6, i10, i11, i12, 0);
    }

    @Override
    public final void onNestedScrollAccepted(View view, View view2, int i6) {
        mo547a(view, view2, i6, 0);
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1689a);
        SparseArray sparseArray = savedState.f1441c;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int id = childAt.getId();
            Behavior behavior = m904s(childAt).f1442a;
            if (id != -1 && behavior != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                behavior.mo932n(childAt, parcelable2);
            }
        }
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableMo933o;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int id = childAt.getId();
            Behavior behavior = ((C0311c) childAt.getLayoutParams()).f1442a;
            if (id != -1 && behavior != null && (parcelableMo933o = behavior.mo933o(childAt)) != null) {
                sparseArray.append(id, parcelableMo933o);
            }
        }
        savedState.f1441c = sparseArray;
        return savedState;
    }

    @Override
    public final boolean onStartNestedScroll(View view, View view2, int i6) {
        return mo555j(view, view2, i6, 0);
    }

    @Override
    public final void onStopNestedScroll(View view) {
        mo551f(0, view);
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zM916x;
        boolean zMo936r;
        MotionEvent motionEventObtain;
        int actionMasked = motionEvent.getActionMasked();
        if (this.f1431j == null) {
            zM916x = m916x(motionEvent, 1);
            if (!zM916x) {
                zMo936r = false;
            }
            motionEventObtain = null;
            if (this.f1431j == null) {
                zMo936r |= super.onTouchEvent(motionEvent);
            } else if (zM916x) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEventObtain);
            }
            if (motionEventObtain != null) {
                motionEventObtain.recycle();
            }
            if (actionMasked != 1 || actionMasked == 3) {
                m918z(false);
            }
            return zMo936r;
        }
        zM916x = false;
        Behavior behavior = ((C0311c) this.f1431j.getLayoutParams()).f1442a;
        if (behavior != null) {
            zMo936r = behavior.mo936r(this, this.f1431j, motionEvent);
        } else {
            zMo936r = false;
        }
        motionEventObtain = null;
        if (this.f1431j == null) {
            zMo936r |= super.onTouchEvent(motionEvent);
        } else if (zM916x) {
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            motionEventObtain = MotionEvent.obtain(jUptimeMillis2, jUptimeMillis2, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEventObtain);
        }
        if (motionEventObtain != null) {
            motionEventObtain.recycle();
        }
        if (actionMasked != 1) {
            m918z(false);
        } else {
            m918z(false);
        }
        return zMo936r;
    }

    public final void m910p(View view, Rect rect) {
        ThreadLocal threadLocal = AbstractC0024g.f48a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = AbstractC0024g.f48a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        AbstractC0024g.m109a(this, view, matrix);
        ThreadLocal threadLocal3 = AbstractC0024g.f49b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int m911r(int i6) {
        int[] iArr = this.f1430i;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i6);
            return 0;
        }
        if (i6 >= 0 && i6 < iArr.length) {
            return iArr[i6];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i6 + " out of range for " + this);
        return 0;
    }

    @Override
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z7) {
        Behavior behavior = ((C0311c) view.getLayoutParams()).f1442a;
        if (behavior == null || !behavior.mo931m(this, view, rect, z7)) {
            return super.requestChildRectangleOnScreen(view, rect, z7);
        }
        return true;
    }

    @Override
    public final void requestDisallowInterceptTouchEvent(boolean z7) {
        super.requestDisallowInterceptTouchEvent(z7);
        if (!z7 || this.f1428g) {
            return;
        }
        m918z(false);
        this.f1428g = true;
    }

    @Override
    public void setFitsSystemWindows(boolean z7) {
        super.setFitsSystemWindows(z7);
        m905C();
    }

    @Override
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f1438q = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f1437p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f1437p = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f1437p.setState(getDrawableState());
                }
                Drawable drawable3 = this.f1437p;
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                AbstractC3198d.m6442Q(drawable3, getLayoutDirection());
                this.f1437p.setVisible(getVisibility() == 0, false);
                this.f1437p.setCallback(this);
            }
            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i6) {
        setStatusBarBackground(new ColorDrawable(i6));
    }

    public void setStatusBarBackgroundResource(int i6) {
        setStatusBarBackground(i6 != 0 ? AbstractC2115a.m5069b(getContext(), i6) : null);
    }

    @Override
    public void setVisibility(int i6) {
        super.setVisibility(i6);
        boolean z7 = i6 == 0;
        Drawable drawable = this.f1437p;
        if (drawable == null || drawable.isVisible() == z7) {
            return;
        }
        this.f1437p.setVisible(z7, false);
    }

    public final boolean m912t(View view, int i6, int i10) {
        C3028d c3028d = f1421x;
        Rect rectM902k = m902k();
        m910p(view, rectM902k);
        try {
            return rectM902k.contains(i6, i10);
        } finally {
            rectM902k.setEmpty();
            c3028d.mo6101c(rectM902k);
        }
    }

    public final void m913u(int i6) {
        int i10;
        Rect rect;
        int i11;
        Rect rect2;
        boolean z7;
        int i12;
        Rect rect3;
        ArrayList arrayList;
        int i13;
        boolean zMo922d;
        boolean z10;
        boolean z11;
        int width;
        int i14;
        int i15;
        int i16;
        int height;
        int i17;
        int i18;
        int i19;
        C3028d c3028d;
        Behavior behavior;
        int i20 = i6;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList2 = this.f1422a;
        int size = arrayList2.size();
        Rect rectM902k = m902k();
        Rect rectM902k2 = m902k();
        Rect rectM902k3 = m902k();
        int i21 = 0;
        while (true) {
            C3028d c3028d2 = f1421x;
            if (i21 >= size) {
                Rect rect4 = rectM902k3;
                Rect rect5 = rectM902k2;
                Rect rect6 = rectM902k;
                rect6.setEmpty();
                c3028d2.mo6101c(rect6);
                rect5.setEmpty();
                c3028d2.mo6101c(rect5);
                rect4.setEmpty();
                c3028d2.mo6101c(rect4);
                return;
            }
            View view = (View) arrayList2.get(i21);
            C0311c c0311c = (C0311c) view.getLayoutParams();
            if (i20 != 0 || view.getVisibility() != 8) {
                int i22 = 0;
                while (i22 < i21) {
                    if (c0311c.f1453l == ((View) arrayList2.get(i22))) {
                        C0311c c0311c2 = (C0311c) view.getLayoutParams();
                        if (c0311c2.f1452k != null) {
                            Rect rectM902k4 = m902k();
                            Rect rectM902k5 = m902k();
                            Rect rectM902k6 = m902k();
                            m910p(c0311c2.f1452k, rectM902k4);
                            m908n(view, rectM902k5, false);
                            int measuredWidth = view.getMeasuredWidth();
                            int measuredHeight = view.getMeasuredHeight();
                            c3028d = c3028d2;
                            m903q(layoutDirection, rectM902k4, rectM902k6, c0311c2, measuredWidth, measuredHeight);
                            boolean z12 = (rectM902k6.left == rectM902k5.left && rectM902k6.top == rectM902k5.top) ? false : true;
                            m906l(c0311c2, rectM902k6, measuredWidth, measuredHeight);
                            int i23 = rectM902k6.left - rectM902k5.left;
                            int i24 = rectM902k6.top - rectM902k5.top;
                            if (i23 != 0) {
                                AbstractC3155s0.m6339i(i23, view);
                            }
                            if (i24 != 0) {
                                AbstractC3155s0.m6340j(i24, view);
                            }
                            if (z12 && (behavior = c0311c2.f1442a) != null) {
                                behavior.mo922d(this, view, c0311c2.f1452k);
                            }
                            rectM902k4.setEmpty();
                            c3028d.mo6101c(rectM902k4);
                            rectM902k5.setEmpty();
                            c3028d.mo6101c(rectM902k5);
                            rectM902k6.setEmpty();
                            c3028d.mo6101c(rectM902k6);
                        } else {
                            c3028d = c3028d2;
                        }
                    } else {
                        c3028d = c3028d2;
                    }
                    i22++;
                    c3028d2 = c3028d;
                    size = size;
                    arrayList2 = arrayList2;
                    layoutDirection = layoutDirection;
                    c0311c = c0311c;
                    i21 = i21;
                    rectM902k3 = rectM902k3;
                    rectM902k2 = rectM902k2;
                    rectM902k = rectM902k;
                }
                C0311c c0311c3 = c0311c;
                int i25 = layoutDirection;
                C3028d c3028d3 = c3028d2;
                i10 = i21;
                Rect rect7 = rectM902k3;
                rect = rectM902k2;
                Rect rect8 = rectM902k;
                ArrayList arrayList3 = arrayList2;
                int i26 = size;
                m908n(view, rect, true);
                if (c0311c3.f1448g == 0 || rect.isEmpty()) {
                    i11 = i25;
                    rect2 = rect8;
                } else {
                    i11 = i25;
                    int absoluteGravity = Gravity.getAbsoluteGravity(c0311c3.f1448g, i11);
                    int i27 = absoluteGravity & 112;
                    if (i27 == 48) {
                        rect2 = rect8;
                        rect2.top = Math.max(rect2.top, rect.bottom);
                    } else if (i27 != 80) {
                        rect2 = rect8;
                    } else {
                        rect2 = rect8;
                        rect2.bottom = Math.max(rect2.bottom, getHeight() - rect.top);
                    }
                    int i28 = absoluteGravity & 7;
                    if (i28 == 3) {
                        rect2.left = Math.max(rect2.left, rect.right);
                    } else if (i28 == 5) {
                        rect2.right = Math.max(rect2.right, getWidth() - rect.left);
                    }
                }
                if (c0311c3.f1449h == 0 || view.getVisibility() != 0) {
                    z7 = false;
                } else {
                    WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                    if (view.isLaidOut() && view.getWidth() > 0 && view.getHeight() > 0) {
                        C0311c c0311c4 = (C0311c) view.getLayoutParams();
                        Behavior behavior2 = c0311c4.f1442a;
                        Rect rectM902k7 = m902k();
                        Rect rectM902k8 = m902k();
                        rectM902k8.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                        if (behavior2 == null || !behavior2.mo919a(view, rectM902k7)) {
                            rectM902k7.set(rectM902k8);
                        } else if (!rectM902k8.contains(rectM902k7)) {
                            throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectM902k7.toShortString() + " | Bounds:" + rectM902k8.toShortString());
                        }
                        rectM902k8.setEmpty();
                        c3028d3.mo6101c(rectM902k8);
                        if (rectM902k7.isEmpty()) {
                            rectM902k7.setEmpty();
                            c3028d3.mo6101c(rectM902k7);
                            z7 = false;
                        } else {
                            int absoluteGravity2 = Gravity.getAbsoluteGravity(c0311c4.f1449h, i11);
                            if ((absoluteGravity2 & 48) != 48 || (i18 = (rectM902k7.top - ((ViewGroup.MarginLayoutParams) c0311c4).topMargin) - c0311c4.f1451j) >= (i19 = rect2.top)) {
                                z10 = false;
                            } else {
                                m901B(i19 - i18, view);
                                z10 = true;
                            }
                            if ((absoluteGravity2 & 80) == 80 && (height = ((getHeight() - rectM902k7.bottom) - ((ViewGroup.MarginLayoutParams) c0311c4).bottomMargin) + c0311c4.f1451j) < (i17 = rect2.bottom)) {
                                m901B(height - i17, view);
                                z10 = true;
                            }
                            if (z10) {
                                z7 = false;
                            } else {
                                z7 = false;
                                m901B(0, view);
                            }
                            if ((absoluteGravity2 & 3) != 3 || (i15 = (rectM902k7.left - ((ViewGroup.MarginLayoutParams) c0311c4).leftMargin) - c0311c4.f1450i) >= (i16 = rect2.left)) {
                                z11 = false;
                            } else {
                                m900A(i16 - i15, view);
                                z11 = true;
                            }
                            if ((absoluteGravity2 & 5) == 5 && (width = ((getWidth() - rectM902k7.right) - ((ViewGroup.MarginLayoutParams) c0311c4).rightMargin) + c0311c4.f1450i) < (i14 = rect2.right)) {
                                m900A(width - i14, view);
                                z11 = true;
                            }
                            if (!z11) {
                                m900A(z7 ? 1 : 0, view);
                            }
                            rectM902k7.setEmpty();
                            c3028d3.mo6101c(rectM902k7);
                        }
                    } else {
                        z7 = false;
                    }
                }
                i12 = i6;
                if (i12 != 2) {
                    rect3 = rect7;
                    rect3.set(((C0311c) view.getLayoutParams()).f1457p);
                    if (rect3.equals(rect)) {
                        size = i26;
                        arrayList = arrayList3;
                    } else {
                        ((C0311c) view.getLayoutParams()).f1457p.set(rect);
                    }
                } else {
                    rect3 = rect7;
                }
                int i29 = i10 + 1;
                size = i26;
                while (true) {
                    arrayList = arrayList3;
                    if (i29 >= size) {
                        break;
                    }
                    View view2 = (View) arrayList.get(i29);
                    C0311c c0311c5 = (C0311c) view2.getLayoutParams();
                    Behavior behavior3 = c0311c5.f1442a;
                    if (behavior3 == null || !behavior3.mo920b(view2, view)) {
                        i13 = 1;
                    } else if (i12 == 0 && c0311c5.f1456o) {
                        c0311c5.f1456o = z7;
                        i13 = 1;
                    } else {
                        if (i12 != 2) {
                            zMo922d = behavior3.mo922d(this, view2, view);
                        } else {
                            behavior3.mo923e(this, view);
                            zMo922d = true;
                        }
                        i13 = 1;
                        if (i12 == 1) {
                            c0311c5.f1456o = zMo922d;
                        }
                    }
                    i29 += i13;
                    arrayList3 = arrayList;
                }
            } else {
                i12 = i20;
                i11 = layoutDirection;
                i10 = i21;
                rect3 = rectM902k3;
                rect = rectM902k2;
                rect2 = rectM902k;
                arrayList = arrayList2;
            }
            i21 = i10 + 1;
            arrayList2 = arrayList;
            rectM902k2 = rect;
            i20 = i12;
            rectM902k = rect2;
            rectM902k3 = rect3;
            layoutDirection = i11;
        }
    }

    public final void m914v(int i6, View view) {
        int i10;
        C0311c c0311c = (C0311c) view.getLayoutParams();
        View view2 = c0311c.f1452k;
        if (view2 == null && c0311c.f1447f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        C3028d c3028d = f1421x;
        if (view2 != null) {
            Rect rectM902k = m902k();
            Rect rectM902k2 = m902k();
            try {
                m910p(view2, rectM902k);
                C0311c c0311c2 = (C0311c) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                m903q(i6, rectM902k, rectM902k2, c0311c2, measuredWidth, measuredHeight);
                m906l(c0311c2, rectM902k2, measuredWidth, measuredHeight);
                view.layout(rectM902k2.left, rectM902k2.top, rectM902k2.right, rectM902k2.bottom);
                return;
            } finally {
                rectM902k.setEmpty();
                c3028d.mo6101c(rectM902k);
                rectM902k2.setEmpty();
                c3028d.mo6101c(rectM902k2);
            }
        }
        int i11 = c0311c.f1446e;
        if (i11 < 0) {
            C0311c c0311c3 = (C0311c) view.getLayoutParams();
            Rect rectM902k3 = m902k();
            rectM902k3.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0311c3).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0311c3).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) c0311c3).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) c0311c3).bottomMargin);
            if (this.f1435n != null) {
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    rectM902k3.left = this.f1435n.m6326b() + rectM902k3.left;
                    rectM902k3.top = this.f1435n.m6328d() + rectM902k3.top;
                    rectM902k3.right -= this.f1435n.m6327c();
                    rectM902k3.bottom -= this.f1435n.m6325a();
                }
            }
            Rect rectM902k4 = m902k();
            int i12 = c0311c3.f1444c;
            if ((i12 & 7) == 0) {
                i12 |= 8388611;
            }
            if ((i12 & 112) == 0) {
                i12 |= 48;
            }
            Gravity.apply(i12, view.getMeasuredWidth(), view.getMeasuredHeight(), rectM902k3, rectM902k4, i6);
            view.layout(rectM902k4.left, rectM902k4.top, rectM902k4.right, rectM902k4.bottom);
            rectM902k3.setEmpty();
            c3028d.mo6101c(rectM902k3);
            rectM902k4.setEmpty();
            c3028d.mo6101c(rectM902k4);
            return;
        }
        C0311c c0311c4 = (C0311c) view.getLayoutParams();
        int i13 = c0311c4.f1444c;
        if (i13 == 0) {
            i13 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i13, i6);
        int i14 = absoluteGravity & 7;
        int i15 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i6 == 1) {
            i11 = width - i11;
        }
        int iM911r = m911r(i11) - measuredWidth2;
        if (i14 == 1) {
            iM911r += measuredWidth2 / 2;
        } else if (i14 == 5) {
            iM911r += measuredWidth2;
        }
        if (i15 != 16) {
            i10 = i15 != 80 ? 0 : measuredHeight2;
        } else {
            i10 = measuredHeight2 / 2;
        }
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0311c4).leftMargin, Math.min(iM911r, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) c0311c4).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0311c4).topMargin, Math.min(i10, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) c0311c4).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth2 + iMax, measuredHeight2 + iMax2);
    }

    @Override
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1437p;
    }

    public final void m915w(int i6, int i10, int i11, View view) {
        measureChildWithMargins(view, i6, i10, i11, 0);
    }

    public final boolean m916x(MotionEvent motionEvent, int i6) {
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f1424c;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i10) : i10));
        }
        C0022e c0022e = f1420w;
        if (c0022e != null) {
            Collections.sort(arrayList, c0022e);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        boolean zMo925g = false;
        for (int i11 = 0; i11 < size; i11++) {
            View view = (View) arrayList.get(i11);
            Behavior behavior = ((C0311c) view.getLayoutParams()).f1442a;
            if (zMo925g && actionMasked != 0) {
                if (behavior != null) {
                    if (motionEventObtain == null) {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i6 == 0) {
                        behavior.mo925g(this, view, motionEventObtain);
                    } else if (i6 == 1) {
                        behavior.mo936r(this, view, motionEventObtain);
                    }
                }
            } else if (!zMo925g && behavior != null) {
                if (i6 == 0) {
                    zMo925g = behavior.mo925g(this, view, motionEvent);
                } else if (i6 == 1) {
                    zMo925g = behavior.mo936r(this, view, motionEvent);
                }
                if (zMo925g) {
                    this.f1431j = view;
                }
            }
        }
        arrayList.clear();
        return zMo925g;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:40:0x0095
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final void m917y() {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.m917y():void");
    }

    public final void m918z(boolean z7) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            Behavior behavior = ((C0311c) childAt.getLayoutParams()).f1442a;
            if (behavior != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z7) {
                    behavior.mo925g(this, childAt, motionEventObtain);
                } else {
                    behavior.mo936r(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            ((C0311c) getChildAt(i10).getLayoutParams()).getClass();
        }
        this.f1431j = null;
        this.f1428g = false;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1422a = new ArrayList();
        this.f1423b = new C0023f(0);
        this.f1424c = new ArrayList();
        this.f1425d = new ArrayList();
        this.f1426e = new int[2];
        this.f1427f = new int[2];
        this.f1440s = new C3151r();
        int[] iArr = AbstractC4282a.f14506a;
        TypedArray typedArrayObtainStyledAttributes = i6 == 0 ? context.obtainStyledAttributes(attributeSet, iArr, 0, R.style.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, iArr, i6, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            if (i6 == 0) {
                saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, R.style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, i6, 0);
            }
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.f1430i = intArray;
            float f = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i10 = 0; i10 < length; i10++) {
                int[] iArr2 = this.f1430i;
                iArr2[i10] = (int) (iArr2[i10] * f);
            }
        }
        this.f1437p = typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.recycle();
        m905C();
        super.setOnHierarchyChangeListener(new ViewGroupOnHierarchyChangeListenerC0020c(this));
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C0311c) {
            return new C0311c((C0311c) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0311c((ViewGroup.MarginLayoutParams) layoutParams) : new C0311c(layoutParams);
    }

    public static abstract class Behavior<V extends View> {
        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public boolean mo919a(View view, Rect rect) {
            return false;
        }

        public boolean mo920b(View view, View view2) {
            return false;
        }

        public boolean mo922d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public boolean mo925g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean mo926h(CoordinatorLayout coordinatorLayout, View view, int i6) {
            return false;
        }

        public boolean mo927i(CoordinatorLayout coordinatorLayout, View view, int i6, int i10, int i11) {
            return false;
        }

        public boolean mo928j(View view) {
            return false;
        }

        public void mo930l(CoordinatorLayout coordinatorLayout, View view, int i6, int i10, int i11, int[] iArr) {
            iArr[0] = iArr[0] + i10;
            iArr[1] = iArr[1] + i11;
        }

        public boolean mo931m(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z7) {
            return false;
        }

        public Parcelable mo933o(View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean mo934p(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i6, int i10) {
            return false;
        }

        public boolean mo936r(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public void mo924f() {
        }

        public void mo921c(C0311c c0311c) {
        }

        public void mo923e(CoordinatorLayout coordinatorLayout, View view) {
        }

        public void mo932n(View view, Parcelable parcelable) {
        }

        public void mo935q(CoordinatorLayout coordinatorLayout, View view, View view2, int i6) {
        }

        public void mo929k(CoordinatorLayout coordinatorLayout, View view, View view2, int i6, int i10, int[] iArr, int i11) {
        }
    }
}
