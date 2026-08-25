package p268z1;

import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.ArrayList;
import p160p.C3341e;

public final class C4293h extends AbstractC4294i {

    public final Matrix f14541a;

    public final ArrayList f14542b;

    public float f14543c;

    public float f14544d;

    public float f14545e;

    public float f14546f;

    public float f14547g;

    public float f14548h;

    public float f14549i;

    public final Matrix f14550j;

    public String f14551k;

    public C4293h() {
        this.f14541a = new Matrix();
        this.f14542b = new ArrayList();
        this.f14543c = 0.0f;
        this.f14544d = 0.0f;
        this.f14545e = 0.0f;
        this.f14546f = 1.0f;
        this.f14547g = 1.0f;
        this.f14548h = 0.0f;
        this.f14549i = 0.0f;
        this.f14550j = new Matrix();
        this.f14551k = null;
    }

    @Override
    public final boolean mo8348a() {
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.f14542b;
            if (i6 >= arrayList.size()) {
                return false;
            }
            if (((AbstractC4294i) arrayList.get(i6)).mo8348a()) {
                return true;
            }
            i6++;
        }
    }

    @Override
    public final boolean mo8349b(int[] iArr) {
        int i6 = 0;
        boolean zMo8349b = false;
        while (true) {
            ArrayList arrayList = this.f14542b;
            if (i6 >= arrayList.size()) {
                return zMo8349b;
            }
            zMo8349b |= ((AbstractC4294i) arrayList.get(i6)).mo8349b(iArr);
            i6++;
        }
    }

    public final void m8350c() {
        Matrix matrix = this.f14550j;
        matrix.reset();
        matrix.postTranslate(-this.f14544d, -this.f14545e);
        matrix.postScale(this.f14546f, this.f14547g);
        matrix.postRotate(this.f14543c, 0.0f, 0.0f);
        matrix.postTranslate(this.f14548h + this.f14544d, this.f14549i + this.f14545e);
    }

    public String getGroupName() {
        return this.f14551k;
    }

    public Matrix getLocalMatrix() {
        return this.f14550j;
    }

    public float getPivotX() {
        return this.f14544d;
    }

    public float getPivotY() {
        return this.f14545e;
    }

    public float getRotation() {
        return this.f14543c;
    }

    public float getScaleX() {
        return this.f14546f;
    }

    public float getScaleY() {
        return this.f14547g;
    }

    public float getTranslateX() {
        return this.f14548h;
    }

    public float getTranslateY() {
        return this.f14549i;
    }

    public void setPivotX(float f) {
        if (f != this.f14544d) {
            this.f14544d = f;
            m8350c();
        }
    }

    public void setPivotY(float f) {
        if (f != this.f14545e) {
            this.f14545e = f;
            m8350c();
        }
    }

    public void setRotation(float f) {
        if (f != this.f14543c) {
            this.f14543c = f;
            m8350c();
        }
    }

    public void setScaleX(float f) {
        if (f != this.f14546f) {
            this.f14546f = f;
            m8350c();
        }
    }

    public void setScaleY(float f) {
        if (f != this.f14547g) {
            this.f14547g = f;
            m8350c();
        }
    }

    public void setTranslateX(float f) {
        if (f != this.f14548h) {
            this.f14548h = f;
            m8350c();
        }
    }

    public void setTranslateY(float f) {
        if (f != this.f14549i) {
            this.f14549i = f;
            m8350c();
        }
    }

    public C4293h(C4293h c4293h, C3341e c3341e) {
        AbstractC4295j c4291f;
        this.f14541a = new Matrix();
        this.f14542b = new ArrayList();
        this.f14543c = 0.0f;
        this.f14544d = 0.0f;
        this.f14545e = 0.0f;
        this.f14546f = 1.0f;
        this.f14547g = 1.0f;
        this.f14548h = 0.0f;
        this.f14549i = 0.0f;
        Matrix matrix = new Matrix();
        this.f14550j = matrix;
        this.f14551k = null;
        this.f14543c = c4293h.f14543c;
        this.f14544d = c4293h.f14544d;
        this.f14545e = c4293h.f14545e;
        this.f14546f = c4293h.f14546f;
        this.f14547g = c4293h.f14547g;
        this.f14548h = c4293h.f14548h;
        this.f14549i = c4293h.f14549i;
        String str = c4293h.f14551k;
        this.f14551k = str;
        if (str != null) {
            c3341e.put(str, this);
        }
        matrix.set(c4293h.f14550j);
        ArrayList arrayList = c4293h.f14542b;
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            Object obj = arrayList.get(i6);
            if (obj instanceof C4293h) {
                this.f14542b.add(new C4293h((C4293h) obj, c3341e));
            } else {
                if (obj instanceof C4292g) {
                    C4292g c4292g = (C4292g) obj;
                    C4292g c4292g2 = new C4292g(c4292g);
                    c4292g2.f14531e = 0.0f;
                    c4292g2.f14533g = 1.0f;
                    c4292g2.f14534h = 1.0f;
                    c4292g2.f14535i = 0.0f;
                    c4292g2.f14536j = 1.0f;
                    c4292g2.f14537k = 0.0f;
                    c4292g2.f14538l = Paint.Cap.BUTT;
                    c4292g2.f14539m = Paint.Join.MITER;
                    c4292g2.f14540n = 4.0f;
                    c4292g2.f14530d = c4292g.f14530d;
                    c4292g2.f14531e = c4292g.f14531e;
                    c4292g2.f14533g = c4292g.f14533g;
                    c4292g2.f14532f = c4292g.f14532f;
                    c4292g2.f14554c = c4292g.f14554c;
                    c4292g2.f14534h = c4292g.f14534h;
                    c4292g2.f14535i = c4292g.f14535i;
                    c4292g2.f14536j = c4292g.f14536j;
                    c4292g2.f14537k = c4292g.f14537k;
                    c4292g2.f14538l = c4292g.f14538l;
                    c4292g2.f14539m = c4292g.f14539m;
                    c4292g2.f14540n = c4292g.f14540n;
                    c4291f = c4292g2;
                } else if (obj instanceof C4291f) {
                    c4291f = new C4291f((C4291f) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.f14542b.add(c4291f);
                Object obj2 = c4291f.f14553b;
                if (obj2 != null) {
                    c3341e.put(obj2, c4291f);
                }
            }
        }
    }
}
