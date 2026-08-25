package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.C0209g3;
import com.p2serv.android.p032ds.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import p046e0.AbstractC2343b;
import p124l6.C2987m;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p187r4.C3624n;
import p258y1.AbstractC4210g0;
import p258y1.AbstractC4228q;
import p258y1.AbstractC4233v;
import p258y1.C4206e0;
import p258y1.C4209g;
import p258y1.C4211h;
import p258y1.C4213i;
import p258y1.C4215j;
import p258y1.C4223n;
import p258y1.C4225o;
import p258y1.InterfaceC4221m;

public class ChangeTransform extends Transition {

    public static final String[] f3767A = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};

    public static final C0209g3 f3768B = new C0209g3("nonTranslations", float[].class, 16);

    public static final C0209g3 f3769C = new C0209g3("translations", PointF.class, 17);

    public static final boolean f3770D = true;

    public final boolean f3771x;

    public final boolean f3772y;

    public final Matrix f3773z;

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3771x = true;
        this.f3772y = true;
        this.f3773z = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4233v.f14375e);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.f3771x = !AbstractC2343b.m5319e(xmlPullParser, "reparentWithOverlay") ? true : typedArrayObtainStyledAttributes.getBoolean(1, true);
        this.f3772y = AbstractC2343b.m5319e(xmlPullParser, "reparent") ? typedArrayObtainStyledAttributes.getBoolean(0, true) : true;
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void m3037F(C4206e0 c4206e0) {
        View view = c4206e0.f14293b;
        if (view.getVisibility() == 8) {
            return;
        }
        HashMap map = c4206e0.f14292a;
        map.put("android:changeTransform:parent", view.getParent());
        map.put("android:changeTransform:transforms", new C4215j(view));
        Matrix matrix = view.getMatrix();
        map.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.f3772y) {
            Matrix matrix2 = new Matrix();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            AbstractC4210g0.f14313a.mo8262n(viewGroup, matrix2);
            matrix2.preTranslate(-viewGroup.getScrollX(), -viewGroup.getScrollY());
            map.put("android:changeTransform:parentMatrix", matrix2);
            map.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.transition_transform));
            map.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.parent_matrix));
        }
    }

    @Override
    public final void mo3030c(C4206e0 c4206e0) {
        m3037F(c4206e0);
    }

    @Override
    public final void mo3031f(C4206e0 c4206e0) {
        m3037F(c4206e0);
        if (f3770D) {
            return;
        }
        View view = c4206e0.f14293b;
        ((ViewGroup) view.getParent()).startViewTransition(view);
    }

    @Override
    public final Animator mo3032j(ViewGroup viewGroup, C4206e0 c4206e0, C4206e0 c4206e1) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder;
        View view;
        Object obj;
        ViewGroup viewGroup2;
        ObjectAnimator objectAnimator;
        int i6;
        C4225o c4225o;
        boolean z7;
        View view2;
        C4225o c4225o2;
        C4223n c4223n;
        ArrayList arrayList;
        Class<ViewGroup> cls;
        int i10;
        View view3;
        ObjectAnimator objectAnimator2;
        int i11;
        int iIntValue;
        View childAt;
        C4223n c4223n2;
        InterfaceC4221m interfaceC4221m;
        char c5;
        C3624n c3624n;
        C4206e0 c4206e0M3060m;
        if (c4206e0 == null || c4206e1 == null) {
            return null;
        }
        HashMap map = c4206e0.f14292a;
        if (!map.containsKey("android:changeTransform:parent")) {
            return null;
        }
        HashMap map2 = c4206e1.f14292a;
        if (!map2.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup3 = (ViewGroup) map.get("android:changeTransform:parent");
        ViewGroup viewGroup4 = (ViewGroup) map2.get("android:changeTransform:parent");
        boolean z10 = this.f3772y && (!(m3063r(viewGroup3) && m3063r(viewGroup4)) ? viewGroup3 == viewGroup4 : !((c4206e0M3060m = m3060m(viewGroup3, true)) == null || viewGroup4 != c4206e0M3060m.f14293b));
        Matrix matrix = (Matrix) map.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            map.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) map.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            map.put("android:changeTransform:parentMatrix", matrix2);
        }
        View view4 = c4206e1.f14293b;
        if (z10) {
            Matrix matrix3 = (Matrix) map2.get("android:changeTransform:parentMatrix");
            view4.setTag(R.id.parent_matrix, matrix3);
            Matrix matrix4 = this.f3773z;
            matrix4.reset();
            matrix3.invert(matrix4);
            Matrix matrix5 = (Matrix) map.get("android:changeTransform:matrix");
            if (matrix5 == null) {
                matrix5 = new Matrix();
                map.put("android:changeTransform:matrix", matrix5);
            }
            matrix5.postConcat((Matrix) map.get("android:changeTransform:parentMatrix"));
            matrix5.postConcat(matrix4);
        }
        Matrix matrix6 = (Matrix) map.get("android:changeTransform:matrix");
        Matrix matrix7 = (Matrix) map2.get("android:changeTransform:matrix");
        if (matrix6 == null) {
            matrix6 = AbstractC4228q.f14367a;
        }
        if (matrix7 == null) {
            matrix7 = AbstractC4228q.f14367a;
        }
        Matrix matrix8 = matrix7;
        if (matrix6.equals(matrix8)) {
            view = view4;
            viewGroup2 = viewGroup3;
            objectAnimatorOfPropertyValuesHolder = null;
            obj = "android:changeTransform:parentMatrix";
        } else {
            C4215j c4215j = (C4215j) map2.get("android:changeTransform:transforms");
            view4.setTranslationX(0.0f);
            view4.setTranslationY(0.0f);
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            AbstractC3119g0.m6184w(view4, 0.0f);
            view4.setScaleX(1.0f);
            view4.setScaleY(1.0f);
            view4.setRotationX(0.0f);
            view4.setRotationY(0.0f);
            view4.setRotation(0.0f);
            float[] fArr = new float[9];
            matrix6.getValues(fArr);
            float[] fArr2 = new float[9];
            matrix8.getValues(fArr2);
            C4213i c4213i = new C4213i(view4, fArr);
            C2987m c2987m = new C2987m(1);
            c2987m.f10247b = new float[9];
            objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(c4213i, PropertyValuesHolder.ofObject(f3768B, c2987m, fArr, fArr2), PropertyValuesHolder.ofObject(f3769C, (TypeConverter) null, this.f3810t.m8278a(fArr[2], fArr[5], fArr2[2], fArr2[5])));
            view = view4;
            obj = "android:changeTransform:parentMatrix";
            viewGroup2 = viewGroup3;
            C4209g c4209g = new C4209g(this, z10, matrix8, view, c4215j, c4213i);
            objectAnimatorOfPropertyValuesHolder.addListener(c4209g);
            objectAnimatorOfPropertyValuesHolder.addPauseListener(c4209g);
        }
        View view5 = c4206e0.f14293b;
        boolean z11 = f3770D;
        if (z10 && objectAnimatorOfPropertyValuesHolder != null && this.f3771x) {
            Matrix matrix9 = new Matrix((Matrix) map2.get(obj));
            AbstractC4210g0.f14313a.mo8263o(viewGroup, matrix9);
            Class<ViewGroup> cls2 = ViewGroup.class;
            if (Build.VERSION.SDK_INT == 28) {
                if (C3624n.f12178f) {
                    c5 = 1;
                } else {
                    try {
                        C3624n.m7336f();
                        Method declaredMethod = C3624n.f12175c.getDeclaredMethod("addGhost", View.class, cls2, Matrix.class);
                        C3624n.f12177e = declaredMethod;
                        declaredMethod.setAccessible(true);
                    } catch (NoSuchMethodException e5) {
                        Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e5);
                    }
                    c5 = 1;
                    C3624n.f12178f = true;
                }
                Method method = C3624n.f12177e;
                if (method != null) {
                    try {
                        Object[] objArr = new Object[3];
                        objArr[0] = view;
                        objArr[c5] = viewGroup;
                        objArr[2] = matrix9;
                        c3624n = new C3624n(10, (View) method.invoke(null, objArr));
                    } catch (IllegalAccessException unused) {
                        c3624n = null;
                    } catch (InvocationTargetException e10) {
                        throw new RuntimeException(e10.getCause());
                    }
                } else {
                    c3624n = null;
                }
                z7 = z11;
                objectAnimator = objectAnimatorOfPropertyValuesHolder;
                view2 = view;
                interfaceC4221m = c3624n;
            } else {
                int i12 = C4225o.f14359g;
                if (!(view.getParent() instanceof ViewGroup)) {
                    throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
                }
                int i13 = C4223n.f14350c;
                C4223n c4223n3 = (C4223n) viewGroup.getTag(R.id.ghost_view_holder);
                C4225o c4225o3 = (C4225o) view.getTag(R.id.ghost_view);
                if (c4225o3 == null || (c4223n2 = (C4223n) c4225o3.getParent()) == c4223n3) {
                    i6 = 0;
                    c4225o = c4225o3;
                } else {
                    i6 = c4225o3.f14363d;
                    c4223n2.removeView(c4225o3);
                    c4225o = null;
                }
                if (c4225o == null) {
                    C4225o c4225o4 = new C4225o(view);
                    c4225o4.f14364e = matrix9;
                    if (c4223n3 == null) {
                        C4223n c4223n4 = new C4223n(viewGroup.getContext());
                        c4223n4.setClipChildren(false);
                        c4223n4.f14351a = viewGroup;
                        viewGroup.setTag(R.id.ghost_view_holder, c4223n4);
                        viewGroup.getOverlay().add(c4223n4);
                        c4223n4.f14352b = true;
                        c4223n = c4223n4;
                    } else {
                        if (!c4223n3.f14352b) {
                            throw new IllegalStateException("This GhostViewHolder is detached!");
                        }
                        ViewGroup viewGroup5 = c4223n3.f14351a;
                        viewGroup5.getOverlay().remove(c4223n3);
                        viewGroup5.getOverlay().add(c4223n3);
                        c4223n = c4223n3;
                    }
                    AbstractC4210g0.m8256a(c4223n, c4223n.getLeft(), c4223n.getTop(), viewGroup.getWidth() + c4223n.getLeft(), viewGroup.getHeight() + c4223n.getTop());
                    AbstractC4210g0.m8256a(c4225o4, c4225o4.getLeft(), c4225o4.getTop(), viewGroup.getWidth() + c4225o4.getLeft(), viewGroup.getHeight() + c4225o4.getTop());
                    ArrayList arrayList2 = new ArrayList();
                    C4223n.m8269a(c4225o4.f14362c, arrayList2);
                    ArrayList arrayList3 = new ArrayList();
                    int childCount = c4223n.getChildCount() - 1;
                    int i14 = 0;
                    while (i14 <= childCount) {
                        int i15 = (i14 + childCount) / 2;
                        C4223n.m8269a(((C4225o) c4223n.getChildAt(i15)).f14362c, arrayList3);
                        if (arrayList2.isEmpty() || arrayList3.isEmpty()) {
                            arrayList = arrayList2;
                            z11 = z11;
                            cls = cls2;
                            i10 = childCount;
                        } else {
                            i10 = childCount;
                            if (arrayList2.get(0) != arrayList3.get(0)) {
                                arrayList = arrayList2;
                            } else {
                                int iMin = Math.min(arrayList2.size(), arrayList3.size());
                                int i16 = 1;
                                while (true) {
                                    if (i16 < iMin) {
                                        View view6 = (View) arrayList2.get(i16);
                                        arrayList = arrayList2;
                                        View view7 = (View) arrayList3.get(i16);
                                        if (view6 != view7) {
                                            ViewGroup viewGroup6 = (ViewGroup) view6.getParent();
                                            int childCount2 = viewGroup6.getChildCount();
                                            if (view6.getZ() == view7.getZ()) {
                                                int i17 = 0;
                                                while (true) {
                                                    if (i17 < childCount2) {
                                                        int i18 = childCount2;
                                                        objectAnimator2 = objectAnimatorOfPropertyValuesHolder;
                                                        if (Build.VERSION.SDK_INT >= 29) {
                                                            iIntValue = viewGroup6.getChildDrawingOrder(i17);
                                                            z11 = z11;
                                                            cls = cls2;
                                                            view3 = view;
                                                        } else {
                                                            if (AbstractC4233v.f14387q) {
                                                                view3 = view;
                                                            } else {
                                                                try {
                                                                    Class<?>[] clsArr = new Class[2];
                                                                    Class<?> cls3 = Integer.TYPE;
                                                                    clsArr[0] = cls3;
                                                                    view3 = view;
                                                                    try {
                                                                        clsArr[1] = cls3;
                                                                        Method declaredMethod2 = cls2.getDeclaredMethod("getChildDrawingOrder", clsArr);
                                                                        AbstractC4233v.f14386p = declaredMethod2;
                                                                        declaredMethod2.setAccessible(true);
                                                                    } catch (NoSuchMethodException unused2) {
                                                                    }
                                                                } catch (NoSuchMethodException unused3) {
                                                                    view3 = view;
                                                                }
                                                                AbstractC4233v.f14387q = true;
                                                            }
                                                            Method method2 = AbstractC4233v.f14386p;
                                                            if (method2 != null) {
                                                                try {
                                                                    Integer numValueOf = Integer.valueOf(viewGroup6.getChildCount());
                                                                    Integer numValueOf2 = Integer.valueOf(i17);
                                                                    cls = cls2;
                                                                    try {
                                                                        Object[] objArr2 = new Object[2];
                                                                        try {
                                                                            objArr2[0] = numValueOf;
                                                                            objArr2[1] = numValueOf2;
                                                                            iIntValue = ((Integer) method2.invoke(viewGroup6, objArr2)).intValue();
                                                                        } catch (IllegalAccessException | InvocationTargetException unused4) {
                                                                            iIntValue = i17;
                                                                        }
                                                                    } catch (IllegalAccessException | InvocationTargetException unused5) {
                                                                        iIntValue = i17;
                                                                        childAt = viewGroup6.getChildAt(iIntValue);
                                                                        if (childAt == view6) {
                                                                            i11 = 1;
                                                                            childCount = i15 - i11;
                                                                            arrayList3.clear();
                                                                            arrayList2 = arrayList;
                                                                            objectAnimatorOfPropertyValuesHolder = objectAnimator2;
                                                                            z11 = z11;
                                                                            cls2 = cls;
                                                                            view = view3;
                                                                        } else if (childAt == view7) {
                                                                            i11 = 1;
                                                                            i14 = i15 + i11;
                                                                            childCount = i10;
                                                                            arrayList3.clear();
                                                                            arrayList2 = arrayList;
                                                                            objectAnimatorOfPropertyValuesHolder = objectAnimator2;
                                                                            z11 = z11;
                                                                            cls2 = cls;
                                                                            view = view3;
                                                                        } else {
                                                                            i17++;
                                                                            childCount2 = i18;
                                                                            objectAnimatorOfPropertyValuesHolder = objectAnimator2;
                                                                            z11 = z11;
                                                                            cls2 = cls;
                                                                            view = view3;
                                                                        }
                                                                    }
                                                                } catch (IllegalAccessException | InvocationTargetException unused6) {
                                                                    cls = cls2;
                                                                }
                                                            } else {
                                                                cls = cls2;
                                                            }
                                                            iIntValue = i17;
                                                        }
                                                        childAt = viewGroup6.getChildAt(iIntValue);
                                                        if (childAt == view6) {
                                                            i11 = 1;
                                                            childCount = i15 - i11;
                                                        } else if (childAt == view7) {
                                                            i11 = 1;
                                                        } else {
                                                            i17++;
                                                            childCount2 = i18;
                                                            objectAnimatorOfPropertyValuesHolder = objectAnimator2;
                                                            z11 = z11;
                                                            cls2 = cls;
                                                            view = view3;
                                                        }
                                                    }
                                                }
                                            } else if (view6.getZ() <= view7.getZ()) {
                                                z11 = z11;
                                                cls = cls2;
                                                objectAnimator2 = objectAnimatorOfPropertyValuesHolder;
                                                view3 = view;
                                                i11 = 1;
                                                childCount = i15 - i11;
                                            }
                                            i14 = i15 + i11;
                                            childCount = i10;
                                        } else {
                                            i16++;
                                            arrayList2 = arrayList;
                                            z11 = z11;
                                            view = view;
                                        }
                                    } else {
                                        arrayList = arrayList2;
                                        z11 = z11;
                                        cls = cls2;
                                        objectAnimator2 = objectAnimatorOfPropertyValuesHolder;
                                        view3 = view;
                                        i11 = 1;
                                        if (arrayList3.size() == iMin) {
                                            i14 = i15 + i11;
                                            childCount = i10;
                                        } else {
                                            childCount = i15 - i11;
                                        }
                                    }
                                    arrayList3.clear();
                                    arrayList2 = arrayList;
                                    objectAnimatorOfPropertyValuesHolder = objectAnimator2;
                                    z11 = z11;
                                    cls2 = cls;
                                    view = view3;
                                }
                            }
                            z11 = z11;
                            cls = cls2;
                        }
                        objectAnimator2 = objectAnimatorOfPropertyValuesHolder;
                        view3 = view;
                        i11 = 1;
                        i14 = i15 + i11;
                        childCount = i10;
                        arrayList3.clear();
                        arrayList2 = arrayList;
                        objectAnimatorOfPropertyValuesHolder = objectAnimator2;
                        z11 = z11;
                        cls2 = cls;
                        view = view3;
                    }
                    z7 = z11;
                    objectAnimator = objectAnimatorOfPropertyValuesHolder;
                    view2 = view;
                    if (i14 < 0 || i14 >= c4223n.getChildCount()) {
                        c4223n.addView(c4225o4);
                    } else {
                        c4223n.addView(c4225o4, i14);
                    }
                    c4225o4.f14363d = i6;
                    c4225o2 = c4225o4;
                } else {
                    z7 = z11;
                    objectAnimator = objectAnimatorOfPropertyValuesHolder;
                    view2 = view;
                    c4225o.f14364e = matrix9;
                    c4225o2 = c4225o;
                }
                c4225o2.f14363d++;
                interfaceC4221m = c4225o2;
            }
            if (interfaceC4221m != null) {
                interfaceC4221m.mo7337a((ViewGroup) map.get("android:changeTransform:parent"), view5);
                Transition transition = this;
                while (true) {
                    TransitionSet transitionSet = transition.f3799i;
                    if (transitionSet == null) {
                        break;
                    }
                    transition = transitionSet;
                }
                C4211h c4211h = new C4211h();
                View view8 = view2;
                c4211h.f14317b = view8;
                c4211h.f14318c = interfaceC4221m;
                transition.m3052a(c4211h);
                if (z7) {
                    if (view5 != view8) {
                        AbstractC4210g0.m8257b(view5, 0.0f);
                    }
                    AbstractC4210g0.m8257b(view8, 1.0f);
                }
            }
        } else {
            objectAnimator = objectAnimatorOfPropertyValuesHolder;
            if (!z11) {
                viewGroup2.endViewTransition(view5);
            }
        }
        return objectAnimator;
    }

    @Override
    public final String[] mo3033o() {
        return f3767A;
    }
}
