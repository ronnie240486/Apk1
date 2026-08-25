package p138n0;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public final class C3142o {

    public ViewParent f10626a;

    public ViewParent f10627b;

    public final ViewGroup f10628c;

    public boolean f10629d;

    public int[] f10630e;

    public C3142o(ViewGroup viewGroup) {
        this.f10628c = viewGroup;
    }

    public final boolean m6280a(float f, float f3, boolean z7) {
        ViewParent viewParentM6284e;
        if (!this.f10629d || (viewParentM6284e = m6284e(0)) == null) {
            return false;
        }
        try {
            return AbstractC3171y0.m6368a(viewParentM6284e, this.f10628c, f, f3, z7);
        } catch (AbstractMethodError e5) {
            Log.e("ViewParentCompat", "ViewParent " + viewParentM6284e + " does not implement interface method onNestedFling", e5);
            return false;
        }
    }

    public final boolean m6281b(float f, float f3) {
        ViewParent viewParentM6284e;
        if (!this.f10629d || (viewParentM6284e = m6284e(0)) == null) {
            return false;
        }
        try {
            return AbstractC3171y0.m6369b(viewParentM6284e, this.f10628c, f, f3);
        } catch (AbstractMethodError e5) {
            Log.e("ViewParentCompat", "ViewParent " + viewParentM6284e + " does not implement interface method onNestedPreFling", e5);
            return false;
        }
    }

    public final boolean m6282c(int i6, int i10, int[] iArr, int[] iArr2, int i11) {
        ViewParent viewParentM6284e;
        int i12;
        int i13;
        int[] iArr3;
        if (!this.f10629d || (viewParentM6284e = m6284e(i11)) == null) {
            return false;
        }
        if (i6 == 0 && i10 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        ViewGroup viewGroup = this.f10628c;
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            i12 = iArr2[0];
            i13 = iArr2[1];
        } else {
            i12 = 0;
            i13 = 0;
        }
        if (iArr == null) {
            if (this.f10630e == null) {
                this.f10630e = new int[2];
            }
            iArr3 = this.f10630e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        if (viewParentM6284e instanceof InterfaceC3145p) {
            ((InterfaceC3145p) viewParentM6284e).mo548b(viewGroup, i6, i10, iArr3, i11);
        } else if (i11 == 0) {
            try {
                AbstractC3171y0.m6370c(viewParentM6284e, viewGroup, i6, i10, iArr3);
            } catch (AbstractMethodError e5) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentM6284e + " does not implement interface method onNestedPreScroll", e5);
            }
        }
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i12;
            iArr2[1] = iArr2[1] - i13;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public final boolean m6283d(int i6, int i10, int i11, int i12, int[] iArr, int i13, int[] iArr2) {
        ViewParent viewParentM6284e;
        int i14;
        int i15;
        int[] iArr3;
        if (!this.f10629d || (viewParentM6284e = m6284e(i13)) == null) {
            return false;
        }
        if (i6 == 0 && i10 == 0 && i11 == 0 && i12 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        ViewGroup viewGroup = this.f10628c;
        if (iArr != null) {
            viewGroup.getLocationInWindow(iArr);
            i14 = iArr[0];
            i15 = iArr[1];
        } else {
            i14 = 0;
            i15 = 0;
        }
        if (iArr2 == null) {
            if (this.f10630e == null) {
                this.f10630e = new int[2];
            }
            int[] iArr4 = this.f10630e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        if (viewParentM6284e instanceof InterfaceC3148q) {
            ((InterfaceC3148q) viewParentM6284e).mo552g(viewGroup, i6, i10, i11, i12, i13, iArr3);
        } else {
            iArr3[0] = iArr3[0] + i11;
            iArr3[1] = iArr3[1] + i12;
            if (viewParentM6284e instanceof InterfaceC3145p) {
                ((InterfaceC3145p) viewParentM6284e).mo554i(viewGroup, i6, i10, i11, i12, i13);
            } else if (i13 == 0) {
                try {
                    AbstractC3171y0.m6371d(viewParentM6284e, viewGroup, i6, i10, i11, i12);
                } catch (AbstractMethodError e5) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentM6284e + " does not implement interface method onNestedScroll", e5);
                }
            }
        }
        if (iArr != null) {
            viewGroup.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i14;
            iArr[1] = iArr[1] - i15;
        }
        return true;
    }

    public final ViewParent m6284e(int i6) {
        if (i6 == 0) {
            return this.f10626a;
        }
        if (i6 != 1) {
            return null;
        }
        return this.f10627b;
    }

    public final boolean m6285f(int i6) {
        return m6284e(i6) != null;
    }

    public final boolean m6286g(int i6, int i10) {
        boolean zM6373f;
        if (m6285f(i10)) {
            return true;
        }
        if (this.f10629d) {
            ViewGroup viewGroup = this.f10628c;
            View view = viewGroup;
            for (ViewParent parent = viewGroup.getParent(); parent != null; parent = parent.getParent()) {
                boolean z7 = parent instanceof InterfaceC3145p;
                if (z7) {
                    zM6373f = ((InterfaceC3145p) parent).mo555j(view, viewGroup, i6, i10);
                } else if (i10 == 0) {
                    try {
                        zM6373f = AbstractC3171y0.m6373f(parent, view, viewGroup, i6);
                    } catch (AbstractMethodError e5) {
                        Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e5);
                        zM6373f = false;
                    }
                } else {
                    zM6373f = false;
                }
                if (zM6373f) {
                    if (i10 == 0) {
                        this.f10626a = parent;
                    } else if (i10 == 1) {
                        this.f10627b = parent;
                    }
                    if (z7) {
                        ((InterfaceC3145p) parent).mo547a(view, viewGroup, i6, i10);
                    } else if (i10 == 0) {
                        try {
                            AbstractC3171y0.m6372e(parent, view, viewGroup, i6);
                        } catch (AbstractMethodError e10) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e10);
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public final void m6287h(int i6) {
        ViewParent viewParentM6284e = m6284e(i6);
        if (viewParentM6284e != null) {
            boolean z7 = viewParentM6284e instanceof InterfaceC3145p;
            ViewGroup viewGroup = this.f10628c;
            if (z7) {
                ((InterfaceC3145p) viewParentM6284e).mo551f(i6, viewGroup);
            } else if (i6 == 0) {
                try {
                    AbstractC3171y0.m6374g(viewParentM6284e, viewGroup);
                } catch (AbstractMethodError e5) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentM6284e + " does not implement interface method onStopNestedScroll", e5);
                }
            }
            if (i6 == 0) {
                this.f10626a = null;
            } else {
                if (i6 != 1) {
                    return;
                }
                this.f10627b = null;
            }
        }
    }
}
