package p205t;

import android.util.Log;
import android.view.View;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import p187r4.AbstractC3612b;

public abstract class AbstractC3771m0 {

    public AbstractC3612b f12624a;

    public String f12625b;

    public final float[] f12626c;

    public boolean f12627d;

    public long f12628e;

    public float f12629f;

    public AbstractC3771m0() {
        this.f12626c = new float[3];
        this.f12627d = false;
        this.f12629f = Float.NaN;
    }

    public final float m7513a(float f, long j10, View view, C3781u c3781u) {
        float[] fArr = this.f12626c;
        this.f12624a.mo7277s(f, fArr);
        boolean z7 = true;
        float f3 = fArr[1];
        if (f3 == 0.0f) {
            this.f12627d = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f12629f)) {
            String str = this.f12625b;
            HashMap map = (HashMap) c3781u.f12723a;
            float f4 = Float.NaN;
            if (map.containsKey(view)) {
                HashMap map2 = (HashMap) map.get(view);
                if (map2.containsKey(str)) {
                    float[] fArr2 = (float[]) map2.get(str);
                    if (fArr2.length > 0) {
                        f4 = fArr2[0];
                    }
                }
            }
            this.f12629f = f4;
            if (Float.isNaN(f4)) {
                this.f12629f = 0.0f;
            }
        }
        float f5 = (float) (((((j10 - this.f12628e) * 1.0E-9d) * ((double) f3)) + ((double) this.f12629f)) % 1.0d);
        this.f12629f = f5;
        String str2 = this.f12625b;
        HashMap map3 = (HashMap) c3781u.f12723a;
        if (map3.containsKey(view)) {
            HashMap map4 = (HashMap) map3.get(view);
            if (map4.containsKey(str2)) {
                float[] fArrCopyOf = (float[]) map4.get(str2);
                if (fArrCopyOf.length <= 0) {
                    fArrCopyOf = Arrays.copyOf(fArrCopyOf, 1);
                }
                fArrCopyOf[0] = f5;
                map4.put(str2, fArrCopyOf);
            } else {
                map4.put(str2, new float[]{f5});
                map3.put(view, map4);
            }
        } else {
            HashMap map5 = new HashMap();
            map5.put(str2, new float[]{f5});
            map3.put(view, map5);
        }
        this.f12628e = j10;
        float f10 = fArr[0];
        float fSin = (((float) Math.sin(this.f12629f * 6.2831855f)) * f10) + fArr[2];
        if (f10 == 0.0f && f3 == 0.0f) {
            z7 = false;
        }
        this.f12627d = z7;
        return fSin;
    }

    public abstract boolean mo7510b(float f, long j10, View view, C3781u c3781u);

    public void mo7512c(int i6) {
        Log.e("SplineSet", "Error no points added to " + this.f12625b);
    }

    public final String toString() {
        String str = this.f12625b;
        new DecimalFormat("##.##");
        return str;
    }
}
