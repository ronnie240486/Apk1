package p196s1;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import p001a0.C0022e;
import p056f0.AbstractC2478a;

public final class C3692b {

    public static final C0022e f12354f = new C0022e(6);

    public final int[] f12355a;

    public final int[] f12356b;

    public final ArrayList f12357c;

    public final C3693c[] f12358d;

    public final float[] f12359e = new float[3];

    public C3692b(int[] iArr, int i6, C3693c[] c3693cArr) {
        C3691a c3691a;
        this.f12358d = c3693cArr;
        int[] iArr2 = new int[32768];
        this.f12356b = iArr2;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            int i11 = iArr[i10];
            int iM7445b = m7445b(Color.blue(i11), 8, 5) | (m7445b(Color.red(i11), 8, 5) << 10) | (m7445b(Color.green(i11), 8, 5) << 5);
            iArr[i10] = iM7445b;
            iArr2[iM7445b] = iArr2[iM7445b] + 1;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < 32768; i13++) {
            if (iArr2[i13] > 0) {
                int iRgb = Color.rgb(m7445b((i13 >> 10) & 31, 5, 8), m7445b((i13 >> 5) & 31, 5, 8), m7445b(i13 & 31, 5, 8));
                ThreadLocal threadLocal = AbstractC2478a.f8679a;
                int iRed = Color.red(iRgb);
                int iGreen = Color.green(iRgb);
                int iBlue = Color.blue(iRgb);
                float[] fArr = this.f12359e;
                AbstractC2478a.m5506a(iRed, iGreen, iBlue, fArr);
                if (m7446c(fArr)) {
                    iArr2[i13] = 0;
                }
            }
            if (iArr2[i13] > 0) {
                i12++;
            }
        }
        int[] iArr3 = new int[i12];
        this.f12355a = iArr3;
        int i14 = 0;
        for (int i15 = 0; i15 < 32768; i15++) {
            if (iArr2[i15] > 0) {
                iArr3[i14] = i15;
                i14++;
            }
        }
        if (i12 <= i6) {
            this.f12357c = new ArrayList();
            for (int i16 = 0; i16 < i12; i16++) {
                int i17 = iArr3[i16];
                this.f12357c.add(new C3694d(Color.rgb(m7445b((i17 >> 10) & 31, 5, 8), m7445b((i17 >> 5) & 31, 5, 8), m7445b(i17 & 31, 5, 8)), iArr2[i17]));
            }
            return;
        }
        PriorityQueue<C3691a> priorityQueue = new PriorityQueue(i6, f12354f);
        priorityQueue.offer(new C3691a(this, 0, this.f12355a.length - 1));
        while (priorityQueue.size() < i6 && (c3691a = (C3691a) priorityQueue.poll()) != null) {
            int i18 = c3691a.f12345b;
            int iMin = c3691a.f12344a;
            if ((i18 + 1) - iMin <= 1) {
                break;
            }
            if ((i18 + 1) - iMin <= 1) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int i19 = c3691a.f12348e - c3691a.f12347d;
            int i20 = c3691a.f12350g - c3691a.f12349f;
            int i21 = c3691a.f12352i - c3691a.f12351h;
            int i22 = (i19 < i20 || i19 < i21) ? (i20 < i19 || i20 < i21) ? -1 : -2 : -3;
            C3692b c3692b = c3691a.f12353j;
            int[] iArr4 = c3692b.f12355a;
            m7444a(iArr4, i22, iMin, i18);
            Arrays.sort(iArr4, iMin, c3691a.f12345b + 1);
            m7444a(iArr4, i22, iMin, c3691a.f12345b);
            int i23 = c3691a.f12346c / 2;
            int i24 = iMin;
            int i25 = 0;
            while (true) {
                int i26 = c3691a.f12345b;
                if (i24 > i26) {
                    break;
                }
                i25 += c3692b.f12356b[iArr4[i24]];
                if (i25 >= i23) {
                    iMin = Math.min(i26 - 1, i24);
                    break;
                }
                i24++;
            }
            C3691a c3691a2 = new C3691a(c3692b, iMin + 1, c3691a.f12345b);
            c3691a.f12345b = iMin;
            c3691a.m7442a();
            priorityQueue.offer(c3691a2);
            priorityQueue.offer(c3691a);
        }
        ArrayList arrayList = new ArrayList(priorityQueue.size());
        for (C3691a c3691a3 : priorityQueue) {
            C3692b c3692b2 = c3691a3.f12353j;
            int[] iArr5 = c3692b2.f12355a;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            for (int i31 = c3691a3.f12344a; i31 <= c3691a3.f12345b; i31++) {
                int i32 = iArr5[i31];
                int i33 = c3692b2.f12356b[i32];
                i28 += i33;
                i27 = (((i32 >> 10) & 31) * i33) + i27;
                i29 = (((i32 >> 5) & 31) * i33) + i29;
                i30 += i33 * (i32 & 31);
            }
            float f = i28;
            C3694d c3694d = new C3694d(Color.rgb(m7445b(Math.round(i27 / f), 5, 8), m7445b(Math.round(i29 / f), 5, 8), m7445b(Math.round(i30 / f), 5, 8)), i28);
            if (!m7446c(c3694d.m7448b())) {
                arrayList.add(c3694d);
            }
        }
        this.f12357c = arrayList;
    }

    public static void m7444a(int[] iArr, int i6, int i10, int i11) {
        if (i6 == -2) {
            while (i10 <= i11) {
                int i12 = iArr[i10];
                iArr[i10] = (i12 & 31) | (((i12 >> 5) & 31) << 10) | (((i12 >> 10) & 31) << 5);
                i10++;
            }
            return;
        }
        if (i6 != -1) {
            return;
        }
        while (i10 <= i11) {
            int i13 = iArr[i10];
            iArr[i10] = ((i13 >> 10) & 31) | ((i13 & 31) << 10) | (((i13 >> 5) & 31) << 5);
            i10++;
        }
    }

    public static int m7445b(int i6, int i10, int i11) {
        return (i11 > i10 ? i6 << (i11 - i10) : i6 >> (i10 - i11)) & ((1 << i11) - 1);
    }

    public final boolean m7446c(float[] fArr) {
        C3693c[] c3693cArr = this.f12358d;
        if (c3693cArr != null && c3693cArr.length > 0) {
            for (C3693c c3693c : c3693cArr) {
                c3693c.getClass();
                float f = fArr[2];
                if (f < 0.95f && f > 0.05f) {
                    float f3 = fArr[0];
                    if (f3 < 10.0f || f3 > 37.0f || fArr[1] > 0.82f) {
                    }
                }
                return true;
            }
        }
        return false;
    }
}
