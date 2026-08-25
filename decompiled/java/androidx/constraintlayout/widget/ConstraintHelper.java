package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Arrays;
import java.util.HashMap;
import p225v.C3958e;
import p225v.C3963j;
import p256y.AbstractC4192i;
import p256y.AbstractC4193j;
import p256y.C4187d;

public abstract class ConstraintHelper extends View {

    public int[] f1292a;

    public int f1293b;

    public Context f1294c;

    public C3963j f1295d;

    public String f1296e;

    public View[] f1297f;

    public HashMap f1298g;

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1292a = new int[32];
        this.f1297f = null;
        this.f1298g = new HashMap();
        this.f1294c = context;
        mo841g(attributeSet);
    }

    public final void m870a(String str) {
        if (str == null || str.length() == 0 || this.f1294c == null) {
            return;
        }
        String strTrim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int iM874e = m874e(strTrim);
        if (iM874e != 0) {
            this.f1298g.put(Integer.valueOf(iM874e), strTrim);
            m871b(iM874e);
        } else {
            Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
        }
    }

    public final void m871b(int i6) {
        if (i6 == getId()) {
            return;
        }
        int i10 = this.f1293b + 1;
        int[] iArr = this.f1292a;
        if (i10 > iArr.length) {
            this.f1292a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1292a;
        int i11 = this.f1293b;
        iArr2[i11] = i6;
        this.f1293b = i11 + 1;
    }

    public final void m872c() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) parent;
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i6 = 0; i6 < this.f1293b; i6++) {
            View viewM878d = constraintLayout.m878d(this.f1292a[i6]);
            if (viewM878d != null) {
                viewM878d.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewM878d.setTranslationZ(viewM878d.getTranslationZ() + elevation);
                }
            }
        }
    }

    public final int m873d(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String resourceEntryName;
        if (str == null || constraintLayout == null || (resources = this.f1294c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = constraintLayout.getChildAt(i6);
            if (childAt.getId() != -1) {
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = null;
                }
                if (str.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public final int m874e(String str) {
        int iM873d;
        HashMap map;
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (!isInEditMode() || constraintLayout == null) {
            iM873d = 0;
        } else {
            Object obj = ((str instanceof String) && (map = constraintLayout.f1312m) != null && map.containsKey(str)) ? constraintLayout.f1312m.get(str) : null;
            if (obj instanceof Integer) {
                iM873d = ((Integer) obj).intValue();
            } else {
                iM873d = 0;
            }
        }
        if (iM873d == 0 && constraintLayout != null) {
            iM873d = m873d(constraintLayout, str);
        }
        if (iM873d == 0) {
            try {
                iM873d = AbstractC4192i.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        if (iM873d != 0) {
            return iM873d;
        }
        Context context = this.f1294c;
        return context.getResources().getIdentifier(str, TtmlNode.ATTR_ID, context.getPackageName());
    }

    public final View[] m875f(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f1297f;
        if (viewArr == null || viewArr.length != this.f1293b) {
            this.f1297f = new View[this.f1293b];
        }
        for (int i6 = 0; i6 < this.f1293b; i6++) {
            this.f1297f[i6] = constraintLayout.m878d(this.f1292a[i6]);
        }
        return this.f1297f;
    }

    public void mo841g(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC4193j.f14236b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i6);
                if (index == 19) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f1296e = string;
                    setIds(string);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1292a, this.f1293b);
    }

    public void mo842h(C0307c c0307c, C3963j c3963j, Constraints.LayoutParams layoutParams, SparseArray sparseArray) {
        C4187d c4187d = c0307c.f1409d;
        int[] iArr = c4187d.f14181e0;
        int i6 = 0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = c4187d.f14183f0;
            if (str != null && str.length() > 0) {
                String[] strArrSplit = c4187d.f14183f0.split(",");
                getContext();
                int[] iArrCopyOf = new int[strArrSplit.length];
                int i10 = 0;
                for (String str2 : strArrSplit) {
                    int iM874e = m874e(str2.trim());
                    if (iM874e != 0) {
                        iArrCopyOf[i10] = iM874e;
                        i10++;
                    }
                }
                if (i10 != strArrSplit.length) {
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i10);
                }
                c4187d.f14181e0 = iArrCopyOf;
            }
        }
        c3963j.f13457h0 = 0;
        Arrays.fill(c3963j.f13456g0, (Object) null);
        if (c4187d.f14181e0 == null) {
            return;
        }
        while (true) {
            int[] iArr2 = c4187d.f14181e0;
            if (i6 >= iArr2.length) {
                return;
            }
            C3958e c3958e = (C3958e) sparseArray.get(iArr2[i6]);
            if (c3958e != null) {
                c3963j.m7935C(c3958e);
            }
            i6++;
        }
    }

    public final void m876l() {
        if (this.f1295d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).f1364l0 = this.f1295d;
        }
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f1296e;
        if (str != null) {
            setIds(str);
        }
    }

    @Override
    public void onMeasure(int i6, int i10) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String str) {
        this.f1296e = str;
        if (str == null) {
            return;
        }
        int i6 = 0;
        this.f1293b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i6);
            if (iIndexOf == -1) {
                m870a(str.substring(i6));
                return;
            } else {
                m870a(str.substring(i6, iIndexOf));
                i6 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1296e = null;
        this.f1293b = 0;
        for (int i6 : iArr) {
            m871b(i6);
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1292a = new int[32];
        this.f1297f = null;
        this.f1298g = new HashMap();
        this.f1294c = context;
        mo841g(attributeSet);
    }

    public void mo845j() {
    }

    public void mo846k(ConstraintLayout constraintLayout) {
    }

    @Override
    public final void onDraw(Canvas canvas) {
    }

    public void mo843i(C3958e c3958e, boolean z7) {
    }
}
