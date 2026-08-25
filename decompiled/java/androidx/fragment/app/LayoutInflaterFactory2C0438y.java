package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import p000a.AbstractC0004e;
import p057f1.AbstractC2490a;

public final class LayoutInflaterFactory2C0438y implements LayoutInflater.Factory2 {

    public final AbstractC0410j0 f2022a;

    public LayoutInflaterFactory2C0438y(AbstractC0410j0 abstractC0410j0) {
        this.f2022a = abstractC0410j0;
    }

    @Override
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        C0422p0 c0422p0M1244f;
        View view2;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        AbstractC0410j0 abstractC0410j0 = this.f2022a;
        if (zEquals) {
            FragmentContainerView fragmentContainerView = new FragmentContainerView(context, attributeSet);
            fragmentContainerView.f1773d = true;
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2490a.f8707b);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(0);
            }
            String string = typedArrayObtainStyledAttributes.getString(1);
            typedArrayObtainStyledAttributes.recycle();
            int id = fragmentContainerView.getId();
            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427sM1263y = abstractC0410j0.m1263y(id);
            if (classAttribute != null && abstractComponentCallbacksC0427sM1263y == null) {
                if (id <= 0) {
                    throw new IllegalStateException(AbstractC0004e.m24r("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
                }
                C0398d0 c0398d0M1219C = abstractC0410j0.m1219C();
                context.getClassLoader();
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427sM1203a = c0398d0M1219C.m1203a(classAttribute);
                abstractComponentCallbacksC0427sM1203a.f1949D = true;
                C0433v c0433v = abstractComponentCallbacksC0427sM1203a.f1983t;
                if ((c0433v != null ? c0433v.f2002f : null) != null) {
                    abstractComponentCallbacksC0427sM1203a.f1949D = true;
                }
                C0391a c0391a = new C0391a(abstractC0410j0);
                c0391a.f1816p = true;
                abstractComponentCallbacksC0427sM1203a.f1950E = fragmentContainerView;
                c0391a.m1191f(fragmentContainerView.getId(), abstractComponentCallbacksC0427sM1203a, string, 1);
                if (c0391a.f1807g) {
                    throw new IllegalStateException("This transaction is already being added to the back stack");
                }
                c0391a.f1808h = false;
                c0391a.f1817q.m1260v(c0391a, true);
            }
            for (C0422p0 c0422p0 : abstractC0410j0.f1863c.m138r()) {
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = c0422p0.f1933c;
                if (abstractComponentCallbacksC0427s.f1987x == fragmentContainerView.getId() && (view2 = abstractComponentCallbacksC0427s.f1951F) != null && view2.getParent() == null) {
                    abstractComponentCallbacksC0427s.f1950E = fragmentContainerView;
                    c0422p0.m1289b();
                }
            }
            return fragmentContainerView;
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC2490a.f8706a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes2.getString(0);
        }
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(1, -1);
        String string2 = typedArrayObtainStyledAttributes2.getString(2);
        typedArrayObtainStyledAttributes2.recycle();
        if (attributeValue != null) {
            try {
                zIsAssignableFrom = AbstractComponentCallbacksC0427s.class.isAssignableFrom(C0398d0.m1201b(attributeValue, context.getClassLoader()));
            } catch (ClassNotFoundException unused) {
                zIsAssignableFrom = false;
            }
            if (zIsAssignableFrom) {
                int id2 = view != null ? view.getId() : 0;
                if (id2 == -1 && resourceId == -1 && string2 == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                }
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427sM1263y2 = resourceId != -1 ? abstractC0410j0.m1263y(resourceId) : null;
                if (abstractComponentCallbacksC0427sM1263y2 == null && string2 != null) {
                    abstractComponentCallbacksC0427sM1263y2 = abstractC0410j0.m1264z(string2);
                }
                if (abstractComponentCallbacksC0427sM1263y2 == null && id2 != -1) {
                    abstractComponentCallbacksC0427sM1263y2 = abstractC0410j0.m1263y(id2);
                }
                if (abstractComponentCallbacksC0427sM1263y2 == null) {
                    C0398d0 c0398d0M1219C2 = abstractC0410j0.m1219C();
                    context.getClassLoader();
                    abstractComponentCallbacksC0427sM1263y2 = c0398d0M1219C2.m1203a(attributeValue);
                    abstractComponentCallbacksC0427sM1263y2.f1977n = true;
                    abstractComponentCallbacksC0427sM1263y2.f1986w = resourceId != 0 ? resourceId : id2;
                    abstractComponentCallbacksC0427sM1263y2.f1987x = id2;
                    abstractComponentCallbacksC0427sM1263y2.f1988y = string2;
                    abstractComponentCallbacksC0427sM1263y2.f1978o = true;
                    abstractComponentCallbacksC0427sM1263y2.f1982s = abstractC0410j0;
                    C0433v c0433v2 = abstractC0410j0.f1874n;
                    abstractComponentCallbacksC0427sM1263y2.f1983t = c0433v2;
                    FragmentActivity fragmentActivity = c0433v2.f2003g;
                    abstractComponentCallbacksC0427sM1263y2.f1949D = true;
                    if ((c0433v2 != null ? c0433v2.f2002f : null) != null) {
                        abstractComponentCallbacksC0427sM1263y2.f1949D = true;
                    }
                    c0422p0M1244f = abstractC0410j0.m1239a(abstractComponentCallbacksC0427sM1263y2);
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "Fragment " + abstractComponentCallbacksC0427sM1263y2 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                    }
                } else {
                    if (abstractComponentCallbacksC0427sM1263y2.f1978o) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
                    }
                    abstractComponentCallbacksC0427sM1263y2.f1978o = true;
                    abstractComponentCallbacksC0427sM1263y2.f1982s = abstractC0410j0;
                    C0433v c0433v3 = abstractC0410j0.f1874n;
                    abstractComponentCallbacksC0427sM1263y2.f1983t = c0433v3;
                    FragmentActivity fragmentActivity2 = c0433v3.f2003g;
                    abstractComponentCallbacksC0427sM1263y2.f1949D = true;
                    if ((c0433v3 != null ? c0433v3.f2002f : null) != null) {
                        abstractComponentCallbacksC0427sM1263y2.f1949D = true;
                    }
                    c0422p0M1244f = abstractC0410j0.m1244f(abstractComponentCallbacksC0427sM1263y2);
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "Retained Fragment " + abstractComponentCallbacksC0427sM1263y2 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                    }
                }
                abstractComponentCallbacksC0427sM1263y2.f1950E = (ViewGroup) view;
                c0422p0M1244f.m1298k();
                c0422p0M1244f.m1297j();
                View view3 = abstractComponentCallbacksC0427sM1263y2.f1951F;
                if (view3 == null) {
                    throw new IllegalStateException(AbstractC0004e.m24r("Fragment ", attributeValue, " did not create a view."));
                }
                if (resourceId != 0) {
                    view3.setId(resourceId);
                }
                if (abstractComponentCallbacksC0427sM1263y2.f1951F.getTag() == null) {
                    abstractComponentCallbacksC0427sM1263y2.f1951F.setTag(string2);
                }
                abstractComponentCallbacksC0427sM1263y2.f1951F.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0437x(this, c0422p0M1244f));
                return abstractComponentCallbacksC0427sM1263y2.f1951F;
            }
        }
        return null;
    }
}
