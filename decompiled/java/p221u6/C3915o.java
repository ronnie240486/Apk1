package p221u6;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.BitSet;
import p143n5.AbstractC3198d;
import p187r4.C3624n;

public final class C3915o {

    public final C3923w[] f13177a = new C3923w[4];

    public final Matrix[] f13178b = new Matrix[4];

    public final Matrix[] f13179c = new Matrix[4];

    public final PointF f13180d = new PointF();

    public final Path f13181e = new Path();

    public final Path f13182f = new Path();

    public final C3923w f13183g = new C3923w();

    public final float[] f13184h = new float[2];

    public final float[] f13185i = new float[2];

    public final Path f13186j = new Path();

    public final Path f13187k = new Path();

    public final boolean f13188l = true;

    public C3915o() {
        for (int i6 = 0; i6 < 4; i6++) {
            this.f13177a[i6] = new C3923w();
            this.f13178b[i6] = new Matrix();
            this.f13179c[i6] = new Matrix();
        }
    }

    public final void m7827a(C3913m c3913m, float f, RectF rectF, C3624n c3624n, Path path) {
        Matrix[] matrixArr;
        Matrix[] matrixArr2;
        C3923w[] c3923wArr;
        int i6;
        float[] fArr;
        C3905e c3905e;
        Path path2;
        InterfaceC3903c interfaceC3903c;
        AbstractC3198d abstractC3198d;
        C3915o c3915o = this;
        C3913m c3913m2 = c3913m;
        C3624n c3624n2 = c3624n;
        path.rewind();
        Path path3 = c3915o.f13181e;
        path3.rewind();
        Path path4 = c3915o.f13182f;
        path4.rewind();
        path4.addRect(rectF, Path.Direction.CW);
        int i10 = 0;
        while (true) {
            matrixArr = c3915o.f13179c;
            matrixArr2 = c3915o.f13178b;
            c3923wArr = c3915o.f13177a;
            fArr = c3915o.f13184h;
            if (i10 >= 4) {
                break;
            }
            if (i10 == 1) {
                interfaceC3903c = c3913m2.f13170g;
            } else if (i10 != 2) {
                interfaceC3903c = i10 != 3 ? c3913m2.f13169f : c3913m2.f13168e;
            } else {
                interfaceC3903c = c3913m2.f13171h;
            }
            if (i10 == 1) {
                abstractC3198d = c3913m2.f13166c;
            } else if (i10 != 2) {
                abstractC3198d = i10 != 3 ? c3913m2.f13165b : c3913m2.f13164a;
            } else {
                abstractC3198d = c3913m2.f13167d;
            }
            C3923w c3923w = c3923wArr[i10];
            abstractC3198d.getClass();
            abstractC3198d.mo6478u(c3923w, f, interfaceC3903c.mo7794a(rectF));
            int i11 = i10 + 1;
            float f3 = i11 * 90;
            matrixArr2[i10].reset();
            PointF pointF = c3915o.f13180d;
            if (i10 == 1) {
                pointF.set(rectF.right, rectF.bottom);
            } else if (i10 == 2) {
                pointF.set(rectF.left, rectF.bottom);
            } else if (i10 != 3) {
                pointF.set(rectF.right, rectF.top);
            } else {
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i10].setTranslate(pointF.x, pointF.y);
            matrixArr2[i10].preRotate(f3);
            C3923w c3923w2 = c3923wArr[i10];
            fArr[0] = c3923w2.f13208c;
            fArr[1] = c3923w2.f13209d;
            matrixArr2[i10].mapPoints(fArr);
            matrixArr[i10].reset();
            matrixArr[i10].setTranslate(fArr[0], fArr[1]);
            matrixArr[i10].preRotate(f3);
            i10 = i11;
            path3 = path3;
        }
        Path path5 = path3;
        int i12 = 0;
        for (i6 = 4; i12 < i6; i6 = 4) {
            C3923w c3923w3 = c3923wArr[i12];
            fArr[0] = c3923w3.f13206a;
            fArr[1] = c3923w3.f13207b;
            matrixArr2[i12].mapPoints(fArr);
            if (i12 == 0) {
                path.moveTo(fArr[0], fArr[1]);
            } else {
                path.lineTo(fArr[0], fArr[1]);
            }
            c3923wArr[i12].m7834c(matrixArr2[i12], path);
            if (c3624n2 != null) {
                C3923w c3923w4 = c3923wArr[i12];
                Matrix matrix = matrixArr2[i12];
                C3908h c3908h = (C3908h) c3624n2.f12182b;
                BitSet bitSet = c3908h.f13129d;
                c3923w4.getClass();
                bitSet.set(i12, false);
                c3923w4.m7833b(c3923w4.f13211f);
                c3908h.f13127b[i12] = new C3916p(new ArrayList(c3923w4.f13213h), new Matrix(matrix));
            }
            int i13 = i12 + 1;
            int i14 = i13 % 4;
            C3923w c3923w5 = c3923wArr[i12];
            fArr[0] = c3923w5.f13208c;
            fArr[1] = c3923w5.f13209d;
            matrixArr2[i12].mapPoints(fArr);
            C3923w c3923w6 = c3923wArr[i14];
            float f4 = c3923w6.f13206a;
            float[] fArr2 = c3915o.f13185i;
            fArr2[0] = f4;
            fArr2[1] = c3923w6.f13207b;
            matrixArr2[i14].mapPoints(fArr2);
            float fMax = Math.max(((float) Math.hypot(fArr[0] - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
            C3923w c3923w7 = c3923wArr[i12];
            fArr[0] = c3923w7.f13208c;
            fArr[1] = c3923w7.f13209d;
            matrixArr2[i12].mapPoints(fArr);
            float fAbs = (i12 == 1 || i12 == 3) ? Math.abs(rectF.centerX() - fArr[0]) : Math.abs(rectF.centerY() - fArr[1]);
            C3923w c3923w8 = c3915o.f13183g;
            c3923w8.m7836e(0.0f, 0.0f, 270.0f, 0.0f);
            if (i12 == 1) {
                c3905e = c3913m2.f13174k;
            } else if (i12 != 2) {
                c3905e = i12 != 3 ? c3913m2.f13173j : c3913m2.f13172i;
            } else {
                c3905e = c3913m2.f13175l;
            }
            c3905e.mo4119g(fMax, fAbs, f, c3923w8);
            Path path6 = c3915o.f13186j;
            path6.reset();
            c3923w8.m7834c(matrixArr[i12], path6);
            if (c3915o.f13188l && (c3905e.mo7796d() || c3915o.m7828b(path6, i12) || c3915o.m7828b(path6, i14))) {
                path6.op(path6, path4, Path.Op.DIFFERENCE);
                fArr[0] = c3923w8.f13206a;
                fArr[1] = c3923w8.f13207b;
                matrixArr[i12].mapPoints(fArr);
                path2 = path5;
                path2.moveTo(fArr[0], fArr[1]);
                c3923w8.m7834c(matrixArr[i12], path2);
            } else {
                path2 = path5;
                c3923w8.m7834c(matrixArr[i12], path);
            }
            if (c3624n != null) {
                Matrix matrix2 = matrixArr[i12];
                C3908h c3908h2 = (C3908h) c3624n.f12182b;
                c3908h2.f13129d.set(i12 + 4, false);
                c3923w8.m7833b(c3923w8.f13211f);
                c3908h2.f13128c[i12] = new C3916p(new ArrayList(c3923w8.f13213h), new Matrix(matrix2));
            }
            c3915o = this;
            c3913m2 = c3913m;
            c3624n2 = c3624n;
            path5 = path2;
            i12 = i13;
        }
        Path path7 = path5;
        path.close();
        path7.close();
        if (path7.isEmpty()) {
            return;
        }
        path.op(path7, Path.Op.UNION);
    }

    public final boolean m7828b(Path path, int i6) {
        Path path2 = this.f13187k;
        path2.reset();
        this.f13177a[i6].m7834c(this.f13178b[i6], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }
}
