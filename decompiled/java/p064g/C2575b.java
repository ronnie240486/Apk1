package p064g;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.util.StateSet;
import com.alibaba.fastjson.asm.Opcodes;
import p065g0.AbstractC2581a;
import p143n5.AbstractC3198d;
import p160p.AbstractC3346j;
import p160p.C3345i;
import p160p.C3348l;
import p171q.AbstractC3387a;

public final class C2575b extends Drawable.ConstantState {

    public boolean f8953A;

    public ColorFilter f8954B;

    public boolean f8955C;

    public ColorStateList f8956D;

    public PorterDuff.Mode f8957E;

    public boolean f8958F;

    public boolean f8959G;

    public int[][] f8960H;

    public C3345i f8961I;

    public C3348l f8962J;

    public final C2578e f8963a;

    public Resources f8964b;

    public int f8965c;

    public int f8966d;

    public int f8967e;

    public SparseArray f8968f;

    public Drawable[] f8969g;

    public int f8970h;

    public boolean f8971i;

    public boolean f8972j;

    public Rect f8973k;

    public boolean f8974l;

    public boolean f8975m;

    public int f8976n;

    public int f8977o;

    public int f8978p;

    public int f8979q;

    public boolean f8980r;

    public int f8981s;

    public boolean f8982t;

    public boolean f8983u;

    public boolean f8984v;

    public boolean f8985w;

    public int f8986x;

    public int f8987y;

    public int f8988z;

    public C2575b(C2575b c2575b, C2578e c2578e, Resources resources) {
        this.f8971i = false;
        this.f8974l = false;
        this.f8985w = true;
        this.f8987y = 0;
        this.f8988z = 0;
        this.f8963a = c2578e;
        this.f8964b = resources != null ? resources : c2575b != null ? c2575b.f8964b : null;
        int i6 = c2575b != null ? c2575b.f8965c : 0;
        int i10 = AbstractC2580g.f9003m;
        i6 = resources != null ? resources.getDisplayMetrics().densityDpi : i6;
        i6 = i6 == 0 ? Opcodes.IF_ICMPNE : i6;
        this.f8965c = i6;
        if (c2575b != null) {
            this.f8966d = c2575b.f8966d;
            this.f8967e = c2575b.f8967e;
            this.f8983u = true;
            this.f8984v = true;
            this.f8971i = c2575b.f8971i;
            this.f8974l = c2575b.f8974l;
            this.f8985w = c2575b.f8985w;
            this.f8986x = c2575b.f8986x;
            this.f8987y = c2575b.f8987y;
            this.f8988z = c2575b.f8988z;
            this.f8953A = c2575b.f8953A;
            this.f8954B = c2575b.f8954B;
            this.f8955C = c2575b.f8955C;
            this.f8956D = c2575b.f8956D;
            this.f8957E = c2575b.f8957E;
            this.f8958F = c2575b.f8958F;
            this.f8959G = c2575b.f8959G;
            if (c2575b.f8965c == i6) {
                if (c2575b.f8972j) {
                    this.f8973k = c2575b.f8973k != null ? new Rect(c2575b.f8973k) : null;
                    this.f8972j = true;
                }
                if (c2575b.f8975m) {
                    this.f8976n = c2575b.f8976n;
                    this.f8977o = c2575b.f8977o;
                    this.f8978p = c2575b.f8978p;
                    this.f8979q = c2575b.f8979q;
                    this.f8975m = true;
                }
            }
            if (c2575b.f8980r) {
                this.f8981s = c2575b.f8981s;
                this.f8980r = true;
            }
            if (c2575b.f8982t) {
                this.f8982t = true;
            }
            Drawable[] drawableArr = c2575b.f8969g;
            this.f8969g = new Drawable[drawableArr.length];
            this.f8970h = c2575b.f8970h;
            SparseArray sparseArray = c2575b.f8968f;
            if (sparseArray != null) {
                this.f8968f = sparseArray.clone();
            } else {
                this.f8968f = new SparseArray(this.f8970h);
            }
            int i11 = this.f8970h;
            for (int i12 = 0; i12 < i11; i12++) {
                Drawable drawable = drawableArr[i12];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f8968f.put(i12, constantState);
                    } else {
                        this.f8969g[i12] = drawableArr[i12];
                    }
                }
            }
        } else {
            this.f8969g = new Drawable[10];
            this.f8970h = 0;
        }
        if (c2575b != null) {
            this.f8960H = c2575b.f8960H;
        } else {
            this.f8960H = new int[this.f8969g.length][];
        }
        if (c2575b != null) {
            this.f8961I = c2575b.f8961I;
            this.f8962J = c2575b.f8962J;
        } else {
            this.f8961I = new C3345i();
            this.f8962J = new C3348l();
        }
    }

    public final int m5564a(Drawable drawable) {
        int i6 = this.f8970h;
        if (i6 >= this.f8969g.length) {
            int i10 = i6 + 10;
            Drawable[] drawableArr = new Drawable[i10];
            Drawable[] drawableArr2 = this.f8969g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i6);
            }
            this.f8969g = drawableArr;
            int[][] iArr = new int[i10][];
            System.arraycopy(this.f8960H, 0, iArr, 0, i6);
            this.f8960H = iArr;
        }
        drawable.mutate();
        drawable.setVisible(false, true);
        drawable.setCallback(this.f8963a);
        this.f8969g[i6] = drawable;
        this.f8970h++;
        this.f8967e = drawable.getChangingConfigurations() | this.f8967e;
        this.f8980r = false;
        this.f8982t = false;
        this.f8973k = null;
        this.f8972j = false;
        this.f8975m = false;
        this.f8983u = false;
        return i6;
    }

    public final void m5565b() {
        this.f8975m = true;
        m5566c();
        int i6 = this.f8970h;
        Drawable[] drawableArr = this.f8969g;
        this.f8977o = -1;
        this.f8976n = -1;
        this.f8979q = 0;
        this.f8978p = 0;
        for (int i10 = 0; i10 < i6; i10++) {
            Drawable drawable = drawableArr[i10];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth > this.f8976n) {
                this.f8976n = intrinsicWidth;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight > this.f8977o) {
                this.f8977o = intrinsicHeight;
            }
            int minimumWidth = drawable.getMinimumWidth();
            if (minimumWidth > this.f8978p) {
                this.f8978p = minimumWidth;
            }
            int minimumHeight = drawable.getMinimumHeight();
            if (minimumHeight > this.f8979q) {
                this.f8979q = minimumHeight;
            }
        }
    }

    public final void m5566c() {
        SparseArray sparseArray = this.f8968f;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i6 = 0; i6 < size; i6++) {
                int iKeyAt = this.f8968f.keyAt(i6);
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f8968f.valueAt(i6);
                Drawable[] drawableArr = this.f8969g;
                Drawable drawableNewDrawable = constantState.newDrawable(this.f8964b);
                if (Build.VERSION.SDK_INT >= 23) {
                    AbstractC3198d.m6442Q(drawableNewDrawable, this.f8986x);
                }
                Drawable drawableMutate = drawableNewDrawable.mutate();
                drawableMutate.setCallback(this.f8963a);
                drawableArr[iKeyAt] = drawableMutate;
            }
            this.f8968f = null;
        }
    }

    @Override
    public final boolean canApplyTheme() {
        int i6 = this.f8970h;
        Drawable[] drawableArr = this.f8969g;
        for (int i10 = 0; i10 < i6; i10++) {
            Drawable drawable = drawableArr[i10];
            if (drawable == null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f8968f.get(i10);
                if (constantState != null && constantState.canApplyTheme()) {
                    return true;
                }
            } else if (AbstractC2581a.m5580b(drawable)) {
                return true;
            }
        }
        return false;
    }

    public final Drawable m5567d(int i6) {
        int iIndexOfKey;
        Drawable drawable = this.f8969g[i6];
        if (drawable != null) {
            return drawable;
        }
        SparseArray sparseArray = this.f8968f;
        if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i6)) < 0) {
            return null;
        }
        Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f8968f.valueAt(iIndexOfKey)).newDrawable(this.f8964b);
        if (Build.VERSION.SDK_INT >= 23) {
            AbstractC3198d.m6442Q(drawableNewDrawable, this.f8986x);
        }
        Drawable drawableMutate = drawableNewDrawable.mutate();
        drawableMutate.setCallback(this.f8963a);
        this.f8969g[i6] = drawableMutate;
        this.f8968f.removeAt(iIndexOfKey);
        if (this.f8968f.size() == 0) {
            this.f8968f = null;
        }
        return drawableMutate;
    }

    public final int m5568e(int i6) {
        Object obj;
        if (i6 < 0) {
            return 0;
        }
        C3348l c3348l = this.f8962J;
        Object obj2 = 0;
        int iM6876a = AbstractC3387a.m6876a(c3348l.f11337c, i6, c3348l.f11335a);
        if (iM6876a >= 0 && (obj = c3348l.f11336b[iM6876a]) != AbstractC3346j.f11331b) {
            obj2 = obj;
        }
        return ((Integer) obj2).intValue();
    }

    public final int m5569f(int[] iArr) {
        int[][] iArr2 = this.f8960H;
        int i6 = this.f8970h;
        for (int i10 = 0; i10 < i6; i10++) {
            if (StateSet.stateSetMatches(iArr2[i10], iArr)) {
                return i10;
            }
        }
        return -1;
    }

    @Override
    public final int getChangingConfigurations() {
        return this.f8966d | this.f8967e;
    }

    @Override
    public final Drawable newDrawable() {
        return new C2578e(this, null);
    }

    @Override
    public final Drawable newDrawable(Resources resources) {
        return new C2578e(this, resources);
    }
}
