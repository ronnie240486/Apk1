package p138n0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.C0385r;
import com.p2serv.android.p032ds.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import p101j7.C2782c;
import p109k3.AbstractC2884p;
import p148o0.C3228c;
import p148o0.InterfaceC3244s;

public abstract class AbstractC3155s0 {

    public static WeakHashMap f10642a;

    public static Field f10643b;

    public static boolean f10644c;

    public static ThreadLocal f10645d;

    public static final int[] f10646e = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    public static final C3104b0 f10647f = new C3104b0();

    public static final ViewTreeObserverOnGlobalLayoutListenerC3110d0 f10648g = new ViewTreeObserverOnGlobalLayoutListenerC3110d0();

    public static C3102a1 m6331a(View view) {
        if (f10642a == null) {
            f10642a = new WeakHashMap();
        }
        C3102a1 c3102a1 = (C3102a1) f10642a.get(view);
        if (c3102a1 != null) {
            return c3102a1;
        }
        C3102a1 c3102a2 = new C3102a1(view);
        f10642a.put(view, c3102a2);
        return c3102a2;
    }

    public static C3153r1 m6332b(View view, C3153r1 c3153r1) {
        WindowInsets windowInsetsM6330g = c3153r1.m6330g();
        if (windowInsetsM6330g != null) {
            WindowInsets windowInsetsM6128a = AbstractC3113e0.m6128a(view, windowInsetsM6330g);
            if (!windowInsetsM6128a.equals(windowInsetsM6330g)) {
                return C3153r1.m6324h(windowInsetsM6128a, view);
            }
        }
        return c3153r1;
    }

    public static boolean m6333c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = C3152r0.f10636d;
        C3152r0 c3152r0 = (C3152r0) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (c3152r0 == null) {
            c3152r0 = new C3152r0();
            c3152r0.f10637a = null;
            c3152r0.f10638b = null;
            c3152r0.f10639c = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, c3152r0);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = c3152r0.f10637a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = C3152r0.f10636d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (c3152r0.f10637a == null) {
                            c3152r0.f10637a = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = C3152r0.f10636d;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                c3152r0.f10637a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    c3152r0.f10637a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        View viewM6322a = c3152r0.m6322a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewM6322a != null && !KeyEvent.isModifierKey(keyCode)) {
                if (c3152r0.f10638b == null) {
                    c3152r0.f10638b = new SparseArray();
                }
                c3152r0.f10638b.put(keyCode, new WeakReference(viewM6322a));
            }
        }
        return viewM6322a != null;
    }

    public static View.AccessibilityDelegate m6334d(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return AbstractC3137m0.m6266a(view);
        }
        if (f10644c) {
            return null;
        }
        if (f10643b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f10643b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f10644c = true;
                return null;
            }
        }
        try {
            Object obj = f10643b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f10644c = true;
            return null;
        }
    }

    public static ArrayList m6335e(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static Rect m6336f() {
        if (f10645d == null) {
            f10645d = new ThreadLocal();
        }
        Rect rect = (Rect) f10645d.get();
        if (rect == null) {
            rect = new Rect();
            f10645d.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static String[] m6337g(AppCompatEditText appCompatEditText) {
        return Build.VERSION.SDK_INT >= 31 ? AbstractC3143o0.m6288a(appCompatEditText) : (String[]) appCompatEditText.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void m6338h(int i6, View view) {
        Object tag;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            int i10 = Build.VERSION.SDK_INT;
            Object objM6242b = null;
            if (i10 >= 28) {
                tag = AbstractC3134l0.m6242b(view);
            } else {
                tag = view.getTag(R.id.tag_accessibility_pane_title);
                if (!CharSequence.class.isInstance(tag)) {
                    tag = null;
                }
            }
            boolean z7 = ((CharSequence) tag) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z7) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z7 ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i6);
                if (z7) {
                    List<CharSequence> text = accessibilityEventObtain.getText();
                    if (i10 >= 28) {
                        objM6242b = AbstractC3134l0.m6242b(view);
                    } else {
                        Object tag2 = view.getTag(R.id.tag_accessibility_pane_title);
                        if (CharSequence.class.isInstance(tag2)) {
                            objM6242b = tag2;
                        }
                    }
                    text.add((CharSequence) objM6242b);
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i6 != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i6);
                        return;
                    } catch (AbstractMethodError e5) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e5);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i6);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            List<CharSequence> text2 = accessibilityEventObtain2.getText();
            if (i10 >= 28) {
                objM6242b = AbstractC3134l0.m6242b(view);
            } else {
                Object tag3 = view.getTag(R.id.tag_accessibility_pane_title);
                if (CharSequence.class.isInstance(tag3)) {
                    objM6242b = tag3;
                }
            }
            text2.add((CharSequence) objM6242b);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static void m6339i(int i6, View view) {
        boolean z7;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i6);
            return;
        }
        Rect rectM6336f = m6336f();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectM6336f.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z7 = !rectM6336f.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z7 = false;
        }
        view.offsetLeftAndRight(i6);
        if (view.getVisibility() == 0) {
            m6351u(view);
            Object parent2 = view.getParent();
            if (parent2 instanceof View) {
                m6351u((View) parent2);
            }
        }
        if (z7 && rectM6336f.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectM6336f);
        }
    }

    public static void m6340j(int i6, View view) {
        boolean z7;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i6);
            return;
        }
        Rect rectM6336f = m6336f();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectM6336f.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z7 = !rectM6336f.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z7 = false;
        }
        view.offsetTopAndBottom(i6);
        if (view.getVisibility() == 0) {
            m6351u(view);
            Object parent2 = view.getParent();
            if (parent2 instanceof View) {
                m6351u((View) parent2);
            }
        }
        if (z7 && rectM6336f.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectM6336f);
        }
    }

    public static C3153r1 m6341k(View view, C3153r1 c3153r1) {
        WindowInsets windowInsetsM6330g = c3153r1.m6330g();
        if (windowInsetsM6330g != null) {
            WindowInsets windowInsetsM6129b = AbstractC3113e0.m6129b(view, windowInsetsM6330g);
            if (!windowInsetsM6129b.equals(windowInsetsM6330g)) {
                return C3153r1.m6324h(windowInsetsM6129b, view);
            }
        }
        return c3153r1;
    }

    public static C3118g m6342l(View view, C3118g c3118g) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + c3118g + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return AbstractC3143o0.m6289b(view, c3118g);
        }
        InterfaceC3157t interfaceC3157t = (InterfaceC3157t) view.getTag(R.id.tag_on_receive_content_listener);
        InterfaceC3160u interfaceC3160u = f10647f;
        if (interfaceC3157t == null) {
            if (view instanceof InterfaceC3160u) {
                interfaceC3160u = (InterfaceC3160u) view;
            }
            return interfaceC3160u.mo567a(c3118g);
        }
        C3118g c3118gM1157a = ((C0385r) interfaceC3157t).m1157a(view, c3118g);
        if (c3118gM1157a == null) {
            return null;
        }
        if (view instanceof InterfaceC3160u) {
            interfaceC3160u = (InterfaceC3160u) view;
        }
        return interfaceC3160u.mo567a(c3118gM1157a);
    }

    public static void m6343m(int i6, View view) {
        m6344n(i6, view);
        m6338h(0, view);
    }

    public static void m6344n(int i6, View view) {
        ArrayList arrayListM6335e = m6335e(view);
        for (int i10 = 0; i10 < arrayListM6335e.size(); i10++) {
            if (((C3228c) arrayListM6335e.get(i10)).m6512a() == i6) {
                arrayListM6335e.remove(i10);
                return;
            }
        }
    }

    public static void m6345o(View view, C3228c c3228c, InterfaceC3244s interfaceC3244s) {
        C3103b c3103b;
        if (interfaceC3244s == null) {
            m6343m(c3228c.m6512a(), view);
            return;
        }
        C3228c c3228c2 = new C3228c(null, c3228c.f10857b, null, interfaceC3244s, c3228c.f10858c);
        View.AccessibilityDelegate accessibilityDelegateM6334d = m6334d(view);
        if (accessibilityDelegateM6334d == null) {
            c3103b = null;
        } else {
            c3103b = accessibilityDelegateM6334d instanceof C3100a ? ((C3100a) accessibilityDelegateM6334d).f10568a : new C3103b(accessibilityDelegateM6334d);
        }
        if (c3103b == null) {
            c3103b = new C3103b();
        }
        m6347q(view, c3103b);
        m6344n(c3228c2.m6512a(), view);
        m6335e(view).add(c3228c2);
        m6338h(0, view);
    }

    public static void m6346p(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i6, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC3137m0.m6269d(view, context, iArr, attributeSet, typedArray, i6, i10);
        }
    }

    public static void m6347q(View view, C3103b c3103b) {
        if (c3103b == null && (m6334d(view) instanceof C3100a)) {
            c3103b = new C3103b();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(c3103b == null ? null : c3103b.f10577b);
    }

    public static void m6348r(View view, CharSequence charSequence) {
        new C3107c0(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).m3247d(view, charSequence);
        ViewTreeObserverOnGlobalLayoutListenerC3110d0 viewTreeObserverOnGlobalLayoutListenerC3110d0 = f10648g;
        if (charSequence == null) {
            viewTreeObserverOnGlobalLayoutListenerC3110d0.f10580a.remove(view);
            view.removeOnAttachStateChangeListener(viewTreeObserverOnGlobalLayoutListenerC3110d0);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC3110d0);
        } else {
            viewTreeObserverOnGlobalLayoutListenerC3110d0.f10580a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(viewTreeObserverOnGlobalLayoutListenerC3110d0);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC3110d0);
            }
        }
    }

    public static void m6349s(View view, ColorStateList colorStateList) {
        int i6 = Build.VERSION.SDK_INT;
        AbstractC3119g0.m6178q(view, colorStateList);
        if (i6 == 21) {
            Drawable background = view.getBackground();
            boolean z7 = (AbstractC3119g0.m6168g(view) == null && AbstractC3119g0.m6169h(view) == null) ? false : true;
            if (background == null || !z7) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    public static void m6350t(ViewGroup viewGroup, C2782c c2782c) {
        if (Build.VERSION.SDK_INT >= 24) {
            AbstractC3125i0.m6196d(viewGroup, AbstractC2884p.m5869d(c2782c != null ? (PointerIcon) c2782c.f9501b : null));
        }
    }

    public static void m6351u(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
