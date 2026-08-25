package androidx.appcompat.widget;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
import java.util.Arrays;
import java.util.WeakHashMap;
import p066g1.C2592a;
import p138n0.AbstractC3155s0;
import p156o9.AbstractC3281e;
import p178q6.AbstractC3515l;
import p178q6.C3511h;
import p178q6.C3520q;
import p178q6.C3522s;
import p258y1.AbstractC4210g0;
import p258y1.AbstractC4233v;
import p258y1.C4203d;
import p258y1.C4213i;
import p262y5.C4269b;

public final class C0209g3 extends Property {

    public final int f936a;

    public C0209g3(String str, Class cls, int i6) {
        super(cls, str);
        this.f936a = i6;
    }

    @Override
    public final Object get(Object obj) {
        switch (this.f936a) {
            case 0:
                return Float.valueOf(((SwitchCompat) obj).f806z);
            case 1:
                return Float.valueOf(((View) obj).getLayoutParams().width);
            case 2:
                return Float.valueOf(((View) obj).getLayoutParams().height);
            case 3:
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                return Float.valueOf(((View) obj).getPaddingStart());
            case 4:
                WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                return Float.valueOf(((View) obj).getPaddingEnd());
            case 5:
                return Float.valueOf(((C3511h) obj).f11831i);
            case 6:
                return Float.valueOf(((C3511h) obj).f11832j);
            case 7:
                return Float.valueOf(((AbstractC3515l) obj).m7163b());
            case 8:
                return Float.valueOf(((C3520q) obj).f11869i);
            case 9:
                return Float.valueOf(((C3522s) obj).f11881j);
            case 10:
                return null;
            case 11:
                return null;
            case 12:
                return null;
            case 13:
                return null;
            case 14:
                return null;
            case 15:
                return null;
            case 16:
                return null;
            case 17:
                return null;
            case 18:
                return Float.valueOf(AbstractC4210g0.f14313a.mo8259k((View) obj));
            default:
                WeakHashMap weakHashMap3 = AbstractC3155s0.f10642a;
                return ((View) obj).getClipBounds();
        }
    }

    @Override
    public final void set(Object obj, Object obj2) {
        switch (this.f936a) {
            case 0:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                break;
            case 1:
                View view = (View) obj;
                view.getLayoutParams().width = ((Float) obj2).intValue();
                view.requestLayout();
                break;
            case 2:
                View view2 = (View) obj;
                view2.getLayoutParams().height = ((Float) obj2).intValue();
                view2.requestLayout();
                break;
            case 3:
                View view3 = (View) obj;
                int iIntValue = ((Float) obj2).intValue();
                int paddingTop = view3.getPaddingTop();
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                view3.setPaddingRelative(iIntValue, paddingTop, view3.getPaddingEnd(), view3.getPaddingBottom());
                break;
            case 4:
                View view4 = (View) obj;
                WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                view4.setPaddingRelative(view4.getPaddingStart(), view4.getPaddingTop(), ((Float) obj2).intValue(), view4.getPaddingBottom());
                break;
            case 5:
                C3511h c3511h = (C3511h) obj;
                float fFloatValue = ((Float) obj2).floatValue();
                c3511h.f11831i = fFloatValue;
                int i6 = (int) (5400.0f * fFloatValue);
                float f = fFloatValue * 1520.0f;
                float[] fArr = c3511h.f11856b;
                fArr[0] = (-20.0f) + f;
                fArr[1] = f;
                int i10 = 0;
                while (true) {
                    C2592a c2592a = c3511h.f11828f;
                    if (i10 >= 4) {
                        float f3 = fArr[0];
                        float f4 = fArr[1];
                        float f5 = ((f4 - f3) * c3511h.f11832j) + f3;
                        fArr[0] = f5;
                        fArr[0] = f5 / 360.0f;
                        fArr[1] = f4 / 360.0f;
                        for (int i11 = 0; i11 < 4; i11++) {
                            float f10 = (i6 - C3511h.f11823n[i11]) / 333;
                            if (f10 >= 0.0f && f10 <= 1.0f) {
                                int i12 = i11 + c3511h.f11830h;
                                CircularProgressIndicatorSpec circularProgressIndicatorSpec = c3511h.f11829g;
                                int[] iArr = circularProgressIndicatorSpec.f11811c;
                                int length = i12 % iArr.length;
                                c3511h.f11857c[0] = C4269b.m8312a(c2592a.getInterpolation(f10), Integer.valueOf(AbstractC3281e.m6620j(iArr[length], c3511h.f11855a.f11852j)), Integer.valueOf(AbstractC3281e.m6620j(circularProgressIndicatorSpec.f11811c[(1 + length) % iArr.length], c3511h.f11855a.f11852j))).intValue();
                                c3511h.f11855a.invalidateSelf();
                            }
                            break;
                        }
                        c3511h.f11855a.invalidateSelf();
                    } else {
                        float f11 = 667;
                        fArr[1] = (c2592a.getInterpolation((i6 - C3511h.f11821l[i10]) / f11) * 250.0f) + fArr[1];
                        fArr[0] = (c2592a.getInterpolation((i6 - C3511h.f11822m[i10]) / f11) * 250.0f) + fArr[0];
                        i10++;
                    }
                    break;
                }
                break;
            case 6:
                ((C3511h) obj).f11832j = ((Float) obj2).floatValue();
                break;
            case 7:
                AbstractC3515l abstractC3515l = (AbstractC3515l) obj;
                float fFloatValue2 = ((Float) obj2).floatValue();
                if (abstractC3515l.f11850h != fFloatValue2) {
                    abstractC3515l.f11850h = fFloatValue2;
                    abstractC3515l.invalidateSelf();
                }
                break;
            case 8:
                C3520q c3520q = (C3520q) obj;
                float fFloatValue3 = ((Float) obj2).floatValue();
                c3520q.f11869i = fFloatValue3;
                float[] fArr2 = c3520q.f11856b;
                fArr2[0] = 0.0f;
                float f12 = ((int) (fFloatValue3 * 333.0f)) / 667;
                C2592a c2592a2 = c3520q.f11865e;
                float interpolation = c2592a2.getInterpolation(f12);
                fArr2[2] = interpolation;
                fArr2[1] = interpolation;
                float interpolation2 = c2592a2.getInterpolation(f12 + 0.49925038f);
                fArr2[4] = interpolation2;
                fArr2[3] = interpolation2;
                fArr2[5] = 1.0f;
                if (c3520q.f11868h && interpolation2 < 1.0f) {
                    int[] iArr2 = c3520q.f11857c;
                    iArr2[2] = iArr2[1];
                    iArr2[1] = iArr2[0];
                    iArr2[0] = AbstractC3281e.m6620j(c3520q.f11866f.f11811c[c3520q.f11867g], c3520q.f11855a.f11852j);
                    c3520q.f11868h = false;
                }
                c3520q.f11855a.invalidateSelf();
                break;
            case 9:
                C3522s c3522s = (C3522s) obj;
                float fFloatValue4 = ((Float) obj2).floatValue();
                c3522s.f11881j = fFloatValue4;
                int i13 = (int) (fFloatValue4 * 1800.0f);
                for (int i14 = 0; i14 < 4; i14++) {
                    c3522s.f11856b[i14] = Math.max(0.0f, Math.min(1.0f, c3522s.f11877f[i14].getInterpolation((i13 - C3522s.f11873m[i14]) / C3522s.f11872l[i14])));
                }
                if (c3522s.f11880i) {
                    Arrays.fill(c3522s.f11857c, AbstractC3281e.m6620j(c3522s.f11878g.f11811c[c3522s.f11879h], c3522s.f11855a.f11852j));
                    c3522s.f11880i = false;
                }
                c3522s.f11855a.invalidateSelf();
                break;
            case 10:
                C4203d c4203d = (C4203d) obj;
                PointF pointF = (PointF) obj2;
                c4203d.getClass();
                c4203d.f14282a = Math.round(pointF.x);
                int iRound = Math.round(pointF.y);
                c4203d.f14283b = iRound;
                int i15 = c4203d.f14287f + 1;
                c4203d.f14287f = i15;
                if (i15 == c4203d.f14288g) {
                    AbstractC4210g0.m8256a(c4203d.f14286e, c4203d.f14282a, iRound, c4203d.f14284c, c4203d.f14285d);
                    c4203d.f14287f = 0;
                    c4203d.f14288g = 0;
                }
                break;
            case 11:
                C4203d c4203d2 = (C4203d) obj;
                PointF pointF2 = (PointF) obj2;
                c4203d2.getClass();
                c4203d2.f14284c = Math.round(pointF2.x);
                int iRound2 = Math.round(pointF2.y);
                c4203d2.f14285d = iRound2;
                int i16 = c4203d2.f14288g + 1;
                c4203d2.f14288g = i16;
                if (c4203d2.f14287f == i16) {
                    AbstractC4210g0.m8256a(c4203d2.f14286e, c4203d2.f14282a, c4203d2.f14283b, c4203d2.f14284c, iRound2);
                    c4203d2.f14287f = 0;
                    c4203d2.f14288g = 0;
                }
                break;
            case 12:
                View view5 = (View) obj;
                PointF pointF3 = (PointF) obj2;
                AbstractC4210g0.m8256a(view5, view5.getLeft(), view5.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                break;
            case 13:
                View view6 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                AbstractC4210g0.m8256a(view6, Math.round(pointF4.x), Math.round(pointF4.y), view6.getRight(), view6.getBottom());
                break;
            case 14:
                View view7 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int iRound3 = Math.round(pointF5.x);
                int iRound4 = Math.round(pointF5.y);
                AbstractC4210g0.m8256a(view7, iRound3, iRound4, view7.getWidth() + iRound3, view7.getHeight() + iRound4);
                break;
            case 15:
                ImageView imageView = (ImageView) obj;
                Matrix matrix = (Matrix) obj2;
                if (Build.VERSION.SDK_INT >= 29) {
                    imageView.animateTransform(matrix);
                } else if (matrix == null) {
                    Drawable drawable = imageView.getDrawable();
                    if (drawable != null) {
                        drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
                        imageView.invalidate();
                    }
                } else if (AbstractC4233v.f14384n) {
                    try {
                        imageView.animateTransform(matrix);
                    } catch (NoSuchMethodError unused) {
                        AbstractC4233v.f14384n = false;
                        return;
                    }
                }
                break;
            case 16:
                C4213i c4213i = (C4213i) obj;
                float[] fArr3 = (float[]) obj2;
                c4213i.getClass();
                System.arraycopy(fArr3, 0, c4213i.f14325c, 0, fArr3.length);
                c4213i.m8264a();
                break;
            case 17:
                C4213i c4213i2 = (C4213i) obj;
                PointF pointF6 = (PointF) obj2;
                c4213i2.getClass();
                c4213i2.f14326d = pointF6.x;
                c4213i2.f14327e = pointF6.y;
                c4213i2.m8264a();
                break;
            case 18:
                AbstractC4210g0.m8257b((View) obj, ((Float) obj2).floatValue());
                break;
            default:
                WeakHashMap weakHashMap3 = AbstractC3155s0.f10642a;
                ((View) obj).setClipBounds((Rect) obj2);
                break;
        }
    }
}
