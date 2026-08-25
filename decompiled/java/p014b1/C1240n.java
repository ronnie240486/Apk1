package p014b1;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import p024c1.C1377a;
import p160p.C3341e;
import p196s1.C3692b;
import p196s1.C3693c;
import p196s1.C3694d;
import p196s1.C3695e;
import p196s1.C3696f;

public final class C1240n {

    public int f3941a;

    public int f3942b;

    public int f3943c;

    public final Object f3944d;

    public Object f3945e;

    public Object f3946f;

    public C1240n(C1243q c1243q) {
        this.f3941a = 1;
        this.f3944d = c1243q;
        this.f3945e = c1243q;
    }

    public int m3116a(int i6) {
        SparseArray sparseArray = ((C1243q) this.f3945e).f3959a;
        C1243q c1243q = sparseArray == null ? null : (C1243q) sparseArray.get(i6);
        int i10 = 1;
        if (this.f3941a == 2) {
            if (c1243q != null) {
                this.f3945e = c1243q;
                this.f3943c++;
            } else if (i6 == 65038) {
                m3118c();
            } else if (i6 != 65039) {
                C1243q c1243q2 = (C1243q) this.f3945e;
                if (c1243q2.f3960b != null) {
                    if (this.f3943c != 1) {
                        this.f3946f = c1243q2;
                        m3118c();
                    } else if (m3119d()) {
                        this.f3946f = (C1243q) this.f3945e;
                        m3118c();
                    } else {
                        m3118c();
                    }
                    i10 = 3;
                } else {
                    m3118c();
                }
            }
            i10 = 2;
        } else if (c1243q == null) {
            m3118c();
        } else {
            this.f3941a = 2;
            this.f3945e = c1243q;
            this.f3943c = 1;
            i10 = 2;
        }
        this.f3942b = i6;
        return i10;
    }

    public C3695e m3117b() {
        int iMax;
        int i6;
        Bitmap bitmap = (Bitmap) this.f3944d;
        if (bitmap == null) {
            throw new AssertionError();
        }
        int i10 = this.f3942b;
        double dSqrt = -1.0d;
        if (i10 > 0) {
            int height = bitmap.getHeight() * bitmap.getWidth();
            if (height > i10) {
                dSqrt = Math.sqrt(((double) i10) / ((double) height));
            }
        } else {
            int i11 = this.f3943c;
            if (i11 > 0 && (iMax = Math.max(bitmap.getWidth(), bitmap.getHeight())) > i11) {
                dSqrt = ((double) i11) / ((double) iMax);
            }
        }
        char c5 = 0;
        Bitmap bitmapCreateScaledBitmap = dSqrt <= 0.0d ? bitmap : Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dSqrt), (int) Math.ceil(((double) bitmap.getHeight()) * dSqrt), false);
        int width = bitmapCreateScaledBitmap.getWidth();
        int height2 = bitmapCreateScaledBitmap.getHeight();
        int[] iArr = new int[width * height2];
        bitmapCreateScaledBitmap.getPixels(iArr, 0, width, 0, 0, width, height2);
        int i12 = this.f3941a;
        ArrayList arrayList = (ArrayList) this.f3946f;
        C3692b c3692b = new C3692b(iArr, i12, arrayList.isEmpty() ? null : (C3693c[]) arrayList.toArray(new C3693c[arrayList.size()]));
        if (bitmapCreateScaledBitmap != bitmap) {
            bitmapCreateScaledBitmap.recycle();
        }
        ArrayList arrayList2 = c3692b.f12357c;
        ArrayList arrayList3 = (ArrayList) this.f3945e;
        C3695e c3695e = new C3695e(arrayList2, arrayList3);
        int size = arrayList3.size();
        int i13 = 0;
        while (true) {
            SparseBooleanArray sparseBooleanArray = c3695e.f12372c;
            if (i13 >= size) {
                sparseBooleanArray.clear();
                return c3695e;
            }
            C3696f c3696f = (C3696f) arrayList3.get(i13);
            float[] fArr = c3696f.f12382c;
            float f = 0.0f;
            for (float f3 : fArr) {
                if (f3 > 0.0f) {
                    f += f3;
                }
            }
            if (f != 0.0f) {
                int length = fArr.length;
                for (int i14 = 0; i14 < length; i14++) {
                    float f4 = fArr[i14];
                    if (f4 > 0.0f) {
                        fArr[i14] = f4 / f;
                    }
                }
            }
            C3341e c3341e = c3695e.f12371b;
            ArrayList arrayList4 = c3695e.f12370a;
            int size2 = arrayList4.size();
            int i15 = 0;
            C3694d c3694d = null;
            float f5 = 0.0f;
            while (i15 < size2) {
                C3694d c3694d2 = (C3694d) arrayList4.get(i15);
                float[] fArrM7448b = c3694d2.m7448b();
                float f10 = fArrM7448b[1];
                float[] fArr2 = c3696f.f12380a;
                if (f10 < fArr2[c5] || f10 > fArr2[2]) {
                    i6 = size;
                    arrayList3 = arrayList3;
                } else {
                    float f11 = fArrM7448b[2];
                    float[] fArr3 = c3696f.f12381b;
                    if (f11 < fArr3[c5] || f11 > fArr3[2] || sparseBooleanArray.get(c3694d2.f12363d)) {
                        i6 = size;
                        arrayList3 = arrayList3;
                    } else {
                        float[] fArrM7448b2 = c3694d2.m7448b();
                        i6 = size;
                        C3694d c3694d3 = c3695e.f12373d;
                        int i16 = c3694d3 != null ? c3694d3.f12364e : 1;
                        float[] fArr4 = c3696f.f12382c;
                        float f12 = fArr4[0];
                        float fAbs = f12 > 0.0f ? (1.0f - Math.abs(fArrM7448b2[1] - fArr2[1])) * f12 : 0.0f;
                        float f13 = fArr4[1];
                        float fAbs2 = f13 > 0.0f ? (1.0f - Math.abs(fArrM7448b2[2] - fArr3[1])) * f13 : 0.0f;
                        float f14 = fArr4[2];
                        float f15 = fAbs + fAbs2 + (f14 > 0.0f ? (c3694d2.f12364e / i16) * f14 : 0.0f);
                        if (c3694d == null || f15 > f5) {
                            f5 = f15;
                            c3694d = c3694d2;
                        }
                    }
                }
                i15++;
                size = i6;
                arrayList3 = arrayList3;
                c5 = 0;
            }
            int i17 = size;
            ArrayList arrayList5 = arrayList3;
            if (c3694d != null) {
                sparseBooleanArray.append(c3694d.f12363d, true);
            }
            c3341e.put(c3696f, c3694d);
            i13++;
            size = i17;
            arrayList3 = arrayList5;
            c5 = 0;
        }
    }

    public void m3118c() {
        this.f3941a = 1;
        this.f3945e = (C1243q) this.f3944d;
        this.f3943c = 0;
    }

    public boolean m3119d() {
        C1377a c1377aM3115c = ((C1243q) this.f3945e).f3960b.m3115c();
        int iM3244a = c1377aM3115c.m3244a(6);
        return !(iM3244a == 0 || ((ByteBuffer) c1377aM3115c.f4194d).get(iM3244a + c1377aM3115c.f4191a) == 0) || this.f3942b == 65039;
    }

    public C1240n(Bitmap bitmap) {
        ArrayList arrayList = new ArrayList();
        this.f3945e = arrayList;
        this.f3941a = 16;
        this.f3942b = 12544;
        this.f3943c = -1;
        ArrayList arrayList2 = new ArrayList();
        this.f3946f = arrayList2;
        if (!bitmap.isRecycled()) {
            arrayList2.add(C3695e.f12369e);
            this.f3944d = bitmap;
            arrayList.add(C3696f.f12374d);
            arrayList.add(C3696f.f12375e);
            arrayList.add(C3696f.f12376f);
            arrayList.add(C3696f.f12377g);
            arrayList.add(C3696f.f12378h);
            arrayList.add(C3696f.f12379i);
            return;
        }
        throw new IllegalArgumentException("Bitmap is not valid");
    }
}
