package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.extractor.flac.FlacConstants;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.alibaba.fastjson.asm.Opcodes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.internal.http2.Http2Connection;
import p138n0.C3112e;
import p187r4.C3621k;
import p215u.C3882e;
import p225v.C3958e;
import p225v.C3959f;
import p225v.C3961h;
import p225v.C3962i;
import p225v.C3963j;
import p225v.EnumC3957d;
import p236w.AbstractC4039n;
import p236w.C4029d;
import p236w.C4031f;
import p236w.C4033h;
import p236w.C4034i;
import p236w.C4036k;
import p236w.C4038m;
import p236w.InterfaceC4028c;
import p256y.AbstractC4191h;
import p256y.AbstractC4193j;

public class ConstraintLayout extends ViewGroup {

    public static final int f1299p = 0;

    public final SparseArray f1300a;

    public final ArrayList f1301b;

    public final C3959f f1302c;

    public int f1303d;

    public int f1304e;

    public int f1305f;

    public int f1306g;

    public boolean f1307h;

    public int f1308i;

    public C0308d f1309j;

    public C3112e f1310k;

    public int f1311l;

    public HashMap f1312m;

    public final SparseArray f1313n;

    public final C0306b f1314o;

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1300a = new SparseArray();
        this.f1301b = new ArrayList(4);
        this.f1302c = new C3959f();
        this.f1303d = 0;
        this.f1304e = 0;
        this.f1305f = Integer.MAX_VALUE;
        this.f1306g = Integer.MAX_VALUE;
        this.f1307h = true;
        this.f1308i = 263;
        this.f1309j = null;
        this.f1310k = null;
        this.f1311l = -1;
        this.f1312m = new HashMap();
        this.f1313n = new SparseArray();
        this.f1314o = new C0306b(this);
        m880h(attributeSet, 0);
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public final void m877c(boolean z7, View view, C3958e c3958e, LayoutParams layoutParams, SparseArray sparseArray) {
        int i6;
        int i10;
        C3958e c3958e2;
        C3958e c3958e3;
        C3958e c3958e4;
        C3958e c3958e5;
        int i11;
        int i12;
        float fAbs;
        int i13;
        layoutParams.m884a();
        c3958e.f13347X = view.getVisibility();
        if (layoutParams.f1342a0) {
            c3958e.f13379x = true;
            c3958e.f13347X = 8;
        }
        c3958e.f13346W = view;
        if (view instanceof ConstraintHelper) {
            ((ConstraintHelper) view).mo843i(c3958e, this.f1302c.f13386k0);
        }
        int i14 = -1;
        if (layoutParams.f1339Y) {
            C3962i c3962i = (C3962i) c3958e;
            int i15 = layoutParams.f1358i0;
            int i16 = layoutParams.f1360j0;
            float f = layoutParams.f1362k0;
            if (f != -1.0f) {
                if (f > -1.0f) {
                    c3962i.f13451g0 = f;
                    c3962i.f13452h0 = -1;
                    c3962i.f13453i0 = -1;
                    return;
                }
                return;
            }
            if (i15 != -1) {
                if (i15 > -1) {
                    c3962i.f13451g0 = -1.0f;
                    c3962i.f13452h0 = i15;
                    c3962i.f13453i0 = -1;
                    return;
                }
                return;
            }
            if (i16 == -1 || i16 <= -1) {
                return;
            }
            c3962i.f13451g0 = -1.0f;
            c3962i.f13452h0 = -1;
            c3962i.f13453i0 = i16;
            return;
        }
        int i17 = layoutParams.f1344b0;
        int i18 = layoutParams.f1346c0;
        int i19 = layoutParams.f1348d0;
        int i20 = layoutParams.f1350e0;
        int i21 = layoutParams.f1352f0;
        int i22 = layoutParams.f1354g0;
        float f3 = layoutParams.f1356h0;
        int i23 = layoutParams.f1365m;
        if (i23 != -1) {
            C3958e c3958e6 = (C3958e) sparseArray.get(i23);
            if (c3958e6 != null) {
                float f4 = layoutParams.f1367o;
                c3958e.m7908p(7, c3958e6, 7, layoutParams.f1366n, 0);
                c3958e.f13377v = f4;
            }
        } else {
            if (i17 != -1) {
                C3958e c3958e7 = (C3958e) sparseArray.get(i17);
                if (c3958e7 != null) {
                    i6 = 2;
                    i10 = 4;
                    c3958e.m7908p(2, c3958e7, 2, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i21);
                } else {
                    i6 = 2;
                    i10 = 4;
                }
            } else {
                i6 = 2;
                i10 = 4;
                if (i18 != -1 && (c3958e2 = (C3958e) sparseArray.get(i18)) != null) {
                    c3958e.m7908p(2, c3958e2, 4, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i21);
                }
            }
            if (i19 != -1) {
                C3958e c3958e8 = (C3958e) sparseArray.get(i19);
                if (c3958e8 != null) {
                    c3958e.m7908p(i10, c3958e8, i6, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i22);
                }
            } else if (i20 != -1 && (c3958e3 = (C3958e) sparseArray.get(i20)) != null) {
                c3958e.m7908p(i10, c3958e3, i10, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i22);
            }
            int i24 = layoutParams.f1355h;
            if (i24 != -1) {
                C3958e c3958e9 = (C3958e) sparseArray.get(i24);
                if (c3958e9 != null) {
                    c3958e.m7908p(3, c3958e9, 3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.f1373u);
                }
            } else {
                int i25 = layoutParams.f1357i;
                if (i25 != -1 && (c3958e4 = (C3958e) sparseArray.get(i25)) != null) {
                    c3958e.m7908p(3, c3958e4, 5, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.f1373u);
                }
            }
            int i26 = layoutParams.f1359j;
            if (i26 != -1) {
                C3958e c3958e10 = (C3958e) sparseArray.get(i26);
                if (c3958e10 != null) {
                    c3958e.m7908p(5, c3958e10, 3, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.f1375w);
                }
            } else {
                int i27 = layoutParams.f1361k;
                if (i27 != -1 && (c3958e5 = (C3958e) sparseArray.get(i27)) != null) {
                    c3958e.m7908p(5, c3958e5, 5, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.f1375w);
                }
            }
            int i28 = layoutParams.f1363l;
            if (i28 != -1) {
                View view2 = (View) this.f1300a.get(i28);
                C3958e c3958e11 = (C3958e) sparseArray.get(layoutParams.f1363l);
                if (c3958e11 != null && view2 != null && (view2.getLayoutParams() instanceof LayoutParams)) {
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    layoutParams.f1338X = true;
                    layoutParams2.f1338X = true;
                    c3958e.mo7900h(6).m7886b(c3958e11.mo7900h(6), 0, -1, true);
                    c3958e.f13378w = true;
                    layoutParams2.f1364l0.f13378w = true;
                    c3958e.mo7900h(3).m7892h();
                    c3958e.mo7900h(5).m7892h();
                }
            }
            if (f3 >= 0.0f) {
                c3958e.f13344U = f3;
            }
            float f5 = layoutParams.f1315A;
            if (f5 >= 0.0f) {
                c3958e.f13345V = f5;
            }
        }
        if (z7 && ((i13 = layoutParams.f1330P) != -1 || layoutParams.f1331Q != -1)) {
            int i29 = layoutParams.f1331Q;
            c3958e.f13339P = i13;
            c3958e.f13340Q = i29;
        }
        boolean z10 = layoutParams.f1336V;
        EnumC3957d enumC3957d = EnumC3957d.f13320b;
        EnumC3957d enumC3957d2 = EnumC3957d.f13319a;
        EnumC3957d enumC3957d3 = EnumC3957d.f13322d;
        EnumC3957d enumC3957d4 = EnumC3957d.f13321c;
        if (z10) {
            c3958e.m7916x(enumC3957d2);
            c3958e.m7918z(((ViewGroup.MarginLayoutParams) layoutParams).width);
            if (((ViewGroup.MarginLayoutParams) layoutParams).width == -2) {
                c3958e.m7916x(enumC3957d);
            }
        } else if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
            if (layoutParams.f1333S) {
                c3958e.m7916x(enumC3957d4);
            } else {
                c3958e.m7916x(enumC3957d3);
            }
            c3958e.mo7900h(2).f13316e = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            c3958e.mo7900h(4).f13316e = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            c3958e.m7916x(enumC3957d4);
            c3958e.m7918z(0);
        }
        if (layoutParams.f1337W) {
            c3958e.m7917y(enumC3957d2);
            c3958e.m7915w(((ViewGroup.MarginLayoutParams) layoutParams).height);
            if (((ViewGroup.MarginLayoutParams) layoutParams).height == -2) {
                c3958e.m7917y(enumC3957d);
            }
        } else if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
            if (layoutParams.f1334T) {
                c3958e.m7917y(enumC3957d4);
            } else {
                c3958e.m7917y(enumC3957d3);
            }
            c3958e.mo7900h(3).f13316e = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            c3958e.mo7900h(5).f13316e = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        } else {
            c3958e.m7917y(enumC3957d4);
            c3958e.m7915w(0);
        }
        String str = layoutParams.f1316B;
        if (str == null || str.length() == 0) {
            c3958e.f13337N = 0.0f;
        } else {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                i11 = 1;
                i12 = 0;
            } else {
                String strSubstring = str.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase("W")) {
                    i11 = 1;
                    i14 = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    i11 = 1;
                    i14 = 1;
                } else {
                    i11 = 1;
                }
                i12 = iIndexOf + i11;
            }
            int iIndexOf2 = str.indexOf(58);
            if (iIndexOf2 < 0 || iIndexOf2 >= length - i11) {
                String strSubstring2 = str.substring(i12);
                if (strSubstring2.length() > 0) {
                    try {
                        fAbs = Float.parseFloat(strSubstring2);
                    } catch (NumberFormatException unused) {
                        fAbs = 0.0f;
                    }
                } else {
                    fAbs = 0.0f;
                }
            } else {
                String strSubstring3 = str.substring(i12, iIndexOf2);
                String strSubstring4 = str.substring(iIndexOf2 + i11);
                if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                    fAbs = 0.0f;
                } else {
                    try {
                        float f10 = Float.parseFloat(strSubstring3);
                        float f11 = Float.parseFloat(strSubstring4);
                        if (f10 <= 0.0f || f11 <= 0.0f) {
                            fAbs = 0.0f;
                        } else {
                            fAbs = i14 == 1 ? Math.abs(f11 / f10) : Math.abs(f10 / f11);
                        }
                    } catch (NumberFormatException unused2) {
                    }
                }
            }
            if (fAbs > 0.0f) {
                c3958e.f13337N = fAbs;
                c3958e.f13338O = i14;
            }
        }
        float f12 = layoutParams.f1318D;
        float[] fArr = c3958e.f13353b0;
        fArr[0] = f12;
        fArr[1] = layoutParams.f1319E;
        c3958e.f13349Z = layoutParams.f1320F;
        c3958e.f13351a0 = layoutParams.f1321G;
        int i30 = layoutParams.f1322H;
        int i31 = layoutParams.f1324J;
        int i32 = layoutParams.f1326L;
        float f13 = layoutParams.f1328N;
        c3958e.f13365j = i30;
        c3958e.f13368m = i31;
        if (i32 == Integer.MAX_VALUE) {
            i32 = 0;
        }
        c3958e.f13369n = i32;
        c3958e.f13370o = f13;
        if (f13 > 0.0f && f13 < 1.0f && i30 == 0) {
            c3958e.f13365j = 2;
        }
        int i33 = layoutParams.f1323I;
        int i34 = layoutParams.f1325K;
        int i35 = layoutParams.f1327M;
        float f14 = layoutParams.f1329O;
        c3958e.f13366k = i33;
        c3958e.f13371p = i34;
        c3958e.f13372q = i35 != Integer.MAX_VALUE ? i35 : 0;
        c3958e.f13373r = f14;
        if (f14 <= 0.0f || f14 >= 1.0f || i33 != 0) {
            return;
        }
        c3958e.f13366k = 2;
    }

    @Override
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final View m878d(int i6) {
        return (View) this.f1300a.get(i6);
    }

    @Override
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f1301b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                ((ConstraintHelper) arrayList.get(i6)).mo846k(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i11 = Integer.parseInt(strArrSplit[0]);
                        int i12 = Integer.parseInt(strArrSplit[1]);
                        int i13 = Integer.parseInt(strArrSplit[2]);
                        int i14 = (int) ((i11 / 1080.0f) * width);
                        int i15 = (int) ((i12 / 1920.0f) * height);
                        int i16 = (int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i14;
                        float f3 = i15;
                        float f4 = i14 + ((int) ((i13 / 1080.0f) * width));
                        canvas.drawLine(f, f3, f4, f3, paint);
                        float f5 = i15 + i16;
                        canvas.drawLine(f4, f3, f4, f5, paint);
                        canvas.drawLine(f4, f5, f, f5, paint);
                        canvas.drawLine(f, f5, f, f3, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f3, f4, f5, paint);
                        canvas.drawLine(f, f5, f4, f3, paint);
                    }
                }
            }
        }
    }

    public final C3958e m879e(View view) {
        if (view == this) {
            return this.f1302c;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f1364l0;
    }

    @Override
    public final void forceLayout() {
        this.f1307h = true;
        super.forceLayout();
    }

    @Override
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getMaxHeight() {
        return this.f1306g;
    }

    public int getMaxWidth() {
        return this.f1305f;
    }

    public int getMinHeight() {
        return this.f1304e;
    }

    public int getMinWidth() {
        return this.f1303d;
    }

    public int getOptimizationLevel() {
        return this.f1302c.f13394s0;
    }

    public final void m880h(AttributeSet attributeSet, int i6) {
        C3959f c3959f = this.f1302c;
        c3959f.f13346W = this;
        C0306b c0306b = this.f1314o;
        c3959f.f13385j0 = c0306b;
        c3959f.f13384i0.f13660f = c0306b;
        this.f1300a.put(getId(), this);
        this.f1309j = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC4193j.f14236b, i6, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == 9) {
                    this.f1303d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1303d);
                } else if (index == 10) {
                    this.f1304e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1304e);
                } else if (index == 7) {
                    this.f1305f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1305f);
                } else if (index == 8) {
                    this.f1306g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1306g);
                } else if (index == 89) {
                    this.f1308i = typedArrayObtainStyledAttributes.getInt(index, this.f1308i);
                } else if (index == 38) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            mo852l(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f1310k = null;
                        }
                    }
                } else if (index == 18) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        C0308d c0308d = new C0308d();
                        this.f1309j = c0308d;
                        c0308d.m898h(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f1309j = null;
                    }
                    this.f1311l = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        int i11 = this.f1308i;
        c3959f.f13394s0 = i11;
        C3882e.f13030p = (i11 & 256) == 256;
    }

    public final boolean m881k() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    public void mo852l(int i6) {
        this.f1310k = new C3112e(getContext(), this, i6);
    }

    public final void m882m(int i6, int i10, int i11, int i12, boolean z7, boolean z10) {
        C0306b c0306b = this.f1314o;
        int i13 = c0306b.f1403e;
        int iResolveSizeAndState = View.resolveSizeAndState(i11 + c0306b.f1402d, i6, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i12 + i13, i10, 0) & 16777215;
        int iMin = Math.min(this.f1305f, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.f1306g, iResolveSizeAndState2);
        if (z7) {
            iMin |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        if (z10) {
            iMin2 |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        setMeasuredDimension(iMin, iMin2);
    }

    public final void m883n(C3959f c3959f, int i6, int i10, int i11) {
        int iMax;
        int iMax2;
        EnumC3957d enumC3957d;
        EnumC3957d enumC3957d2;
        int iM7905m;
        C4031f c4031f;
        int i12;
        int i13;
        C3621k c3621k;
        InterfaceC4028c interfaceC4028c;
        int size;
        int iM7905m2;
        int iM7902j;
        boolean z7;
        boolean z10;
        EnumC3957d enumC3957d3;
        int i14;
        EnumC3957d enumC3957d4;
        C3959f c3959f2;
        C3621k c3621k2;
        InterfaceC4028c interfaceC4028c2;
        int i15;
        int i16;
        int i17;
        EnumC3957d enumC3957d5;
        EnumC3957d enumC3957d6;
        int i18;
        boolean zM7921E;
        C3621k c3621k3;
        int i19;
        ArrayList arrayList;
        int size2;
        int i20;
        int i21;
        int i22;
        C3959f c3959f3;
        int i23;
        boolean z11;
        EnumC3957d[] enumC3957dArr;
        boolean z12;
        boolean z13;
        int iMax3;
        int iMax4;
        int i24;
        boolean zM7333j;
        InterfaceC4028c interfaceC4028c3;
        int i25;
        boolean z14;
        int i26;
        C3958e c3958e;
        int iM7905m3;
        int iM7902j2;
        ArrayList arrayList2;
        int i27;
        int iM7905m4;
        InterfaceC4028c interfaceC4028c4;
        int iM7902j3;
        C3958e c3958e2;
        int iM7905m5;
        int iM7902j4;
        InterfaceC4028c interfaceC4028c5;
        int iM7905m6;
        boolean z15;
        int iM7902j5;
        int size3;
        InterfaceC4028c interfaceC4028c6;
        int i28;
        ConstraintLayout constraintLayout;
        int childCount;
        int i29;
        ArrayList arrayList3;
        int size4;
        int i30;
        View childAt;
        Placeholder placeholder;
        LayoutParams layoutParams;
        C3958e c3958e3;
        C3958e c3958e4;
        C3958e c3958e5;
        C3958e c3958e6;
        EnumC3957d enumC3957dM7901i;
        EnumC3957d enumC3957d7;
        C3621k c3621k4;
        int iMin;
        int iMin2;
        int i31;
        boolean z16;
        C3959f c3959f4;
        int i32;
        int i33;
        int i34;
        boolean z17;
        boolean z18;
        int i35;
        boolean z19;
        boolean z20;
        int i36;
        C3958e c3958e7;
        EnumC3957d[] enumC3957dArr2;
        boolean z21;
        boolean z22;
        boolean z23;
        int mode = View.MeasureSpec.getMode(i10);
        int size5 = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size6 = View.MeasureSpec.getSize(i11);
        int iMax5 = Math.max(0, getPaddingTop());
        int iMax6 = Math.max(0, getPaddingBottom());
        int i37 = iMax5 + iMax6;
        int paddingWidth = getPaddingWidth();
        C0306b c0306b = this.f1314o;
        c0306b.f1400b = iMax5;
        c0306b.f1401c = iMax6;
        c0306b.f1402d = paddingWidth;
        c0306b.f1403e = i37;
        c0306b.f1404f = i10;
        c0306b.f1405g = i11;
        int iMax7 = Math.max(0, getPaddingStart());
        int iMax8 = Math.max(0, getPaddingEnd());
        if (iMax7 <= 0 && iMax8 <= 0) {
            iMax7 = Math.max(0, getPaddingLeft());
        } else if (m881k()) {
            iMax7 = iMax8;
        }
        int i38 = size5 - paddingWidth;
        int i39 = size6 - i37;
        int i40 = c0306b.f1403e;
        int i41 = c0306b.f1402d;
        EnumC3957d enumC3957d8 = EnumC3957d.f13319a;
        int childCount2 = getChildCount();
        enumC3957d8 = EnumC3957d.f13320b;
        int i42 = Integer.MIN_VALUE;
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    iMax = Math.min(this.f1305f - i41, i38);
                    enumC3957d8 = enumC3957d8;
                }
                if (mode2 != i42) {
                    if (mode2 != 0) {
                        if (mode2 != 1073741824) {
                            enumC3957d = enumC3957d8;
                            enumC3957d2 = enumC3957d8;
                            iMax2 = 0;
                        } else {
                            iMax2 = Math.min(this.f1306g - i40, i39);
                            enumC3957d2 = enumC3957d8;
                            enumC3957d = enumC3957d8;
                        }
                    } else if (childCount2 == 0) {
                        enumC3957d = enumC3957d8;
                        enumC3957d2 = enumC3957d;
                        iMax2 = Math.max(0, this.f1304e);
                    } else {
                        iMax2 = 0;
                    }
                    iM7905m = c3959f.m7905m();
                    c4031f = c3959f.f13384i0;
                    if (iMax == iM7905m || iMax2 != c3959f.m7902j()) {
                        c4031f.f13657c = true;
                    }
                    c3959f.f13339P = 0;
                    c3959f.f13340Q = 0;
                    int i43 = this.f1305f - i41;
                    int[] iArr = c3959f.f13376u;
                    iArr[0] = i43;
                    iArr[1] = this.f1306g - i40;
                    c3959f.f13342S = 0;
                    c3959f.f13343T = 0;
                    c3959f.m7916x(enumC3957d8);
                    c3959f.m7918z(iMax);
                    c3959f.m7917y(enumC3957d);
                    c3959f.m7915w(iMax2);
                    i12 = this.f1303d - i41;
                    if (i12 < 0) {
                        c3959f.f13342S = 0;
                    } else {
                        c3959f.f13342S = i12;
                    }
                    i13 = this.f1304e - i40;
                    if (i13 < 0) {
                        c3959f.f13343T = 0;
                    } else {
                        c3959f.f13343T = i13;
                    }
                    c3959f.f13388m0 = iMax7;
                    c3959f.f13389n0 = iMax5;
                    c3621k = c3959f.f13383h0;
                    c3621k.getClass();
                    interfaceC4028c = c3959f.f13385j0;
                    size = c3959f.f13382g0.size();
                    iM7905m2 = c3959f.m7905m();
                    iM7902j = c3959f.m7902j();
                    if ((i6 & 128) == 128) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (!z7 || (i6 & 64) == 64) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    enumC3957d3 = EnumC3957d.f13321c;
                    if (z10) {
                        i36 = 0;
                        while (true) {
                            if (i36 < size) {
                                c3958e7 = (C3958e) c3959f.f13382g0.get(i36);
                                enumC3957dArr2 = c3958e7.f13333J;
                                if (enumC3957dArr2[0] == enumC3957d3) {
                                    z21 = true;
                                } else {
                                    z21 = false;
                                }
                                if (enumC3957dArr2[1] == enumC3957d3) {
                                    z22 = true;
                                } else {
                                    z22 = false;
                                }
                                if (z21 || !z22 || c3958e7.f13337N <= 0.0f) {
                                    z23 = false;
                                } else {
                                    z23 = true;
                                }
                                if ((!c3958e7.m7910r() && z23) || ((c3958e7.m7911s() && z23) || (c3958e7 instanceof C3961h) || c3958e7.m7910r() || c3958e7.m7911s())) {
                                    i14 = 1073741824;
                                    z10 = false;
                                }
                            } else {
                                i14 = 1073741824;
                            }
                        }
                    } else {
                        i14 = 1073741824;
                    }
                    if (((mode != i14 && mode2 == i14) || z7) && z10) {
                        iMin = Math.min(c3959f.f13376u[0], i38);
                        iMin2 = Math.min(c3959f.f13376u[1], i39);
                        if (mode == 1073741824 && c3959f.m7905m() != iMin) {
                            c3959f.m7918z(iMin);
                            c3959f.f13384i0.f13656b = true;
                        }
                        if (mode2 == 1073741824 && c3959f.m7902j() != iMin2) {
                            c3959f.m7915w(iMin2);
                            c3959f.f13384i0.f13656b = true;
                        }
                        if (mode == 1073741824 || mode2 != 1073741824) {
                            c3621k2 = c3621k;
                            interfaceC4028c2 = interfaceC4028c;
                            i15 = size;
                            i16 = iM7905m2;
                            enumC3957d5 = enumC3957d3;
                            enumC3957d6 = enumC3957d2;
                            i31 = mode2;
                            i17 = iM7902j;
                            enumC3957d4 = enumC3957d8;
                            z16 = c4031f.f13656b;
                            c3959f4 = c4031f.f13655a;
                            if (z16) {
                                for (C3958e c3958e8 : c3959f4.f13382g0) {
                                    c3958e8.f13350a = false;
                                    C4036k c4036k = c3958e8.f13356d;
                                    c4036k.f13685e.f13672j = false;
                                    c4036k.f13687g = false;
                                    c4036k.m8034n();
                                    C4038m c4038m = c3958e8.f13358e;
                                    c4038m.f13685e.f13672j = false;
                                    c4038m.f13687g = false;
                                    c4038m.m8037m();
                                }
                                i32 = 0;
                                c3959f4.f13350a = false;
                                C4036k c4036k2 = c3959f4.f13356d;
                                c4036k2.f13685e.f13672j = false;
                                c4036k2.f13687g = false;
                                c4036k2.m8034n();
                                C4038m c4038m2 = c3959f4.f13358e;
                                c4038m2.f13685e.f13672j = false;
                                c4038m2.f13687g = false;
                                c4038m2.m8037m();
                                c4031f.m8023c();
                            } else {
                                i32 = 0;
                            }
                            c4031f.m8022b(c4031f.f13658d);
                            c3959f4.f13339P = i32;
                            c3959f4.f13340Q = i32;
                            c3959f4.f13356d.f13688h.mo8030d(i32);
                            c3959f4.f13358e.f13688h.mo8030d(i32);
                            i33 = mode;
                            i34 = 1073741824;
                            c3959f2 = c3959f;
                            if (i33 == 1073741824) {
                                zM7921E = c3959f2.m7921E(i32, z7);
                                i18 = 1;
                            } else {
                                i18 = 0;
                                zM7921E = true;
                            }
                            if (i31 == 1073741824) {
                                zM7921E &= c3959f2.m7921E(1, z7);
                                i18++;
                            }
                        } else {
                            boolean z24 = c4031f.f13656b;
                            C3959f c3959f5 = c4031f.f13655a;
                            if (z24 || c4031f.f13657c) {
                                for (C3958e c3958e9 : c3959f5.f13382g0) {
                                    c3958e9.f13350a = false;
                                    c3958e9.f13356d.m8034n();
                                    c3958e9.f13358e.m8037m();
                                }
                                i35 = 0;
                                c3959f5.f13350a = false;
                                c3959f5.f13356d.m8034n();
                                c3959f5.f13358e.m8037m();
                                c4031f.f13657c = false;
                            } else {
                                i35 = 0;
                            }
                            c4031f.m8022b(c4031f.f13658d);
                            c3959f5.f13339P = i35;
                            c3959f5.f13340Q = i35;
                            EnumC3957d enumC3957dM7901i2 = c3959f5.m7901i(i35);
                            EnumC3957d enumC3957dM7901i3 = c3959f5.m7901i(1);
                            if (c4031f.f13656b) {
                                c4031f.m8023c();
                            }
                            int iM7906n = c3959f5.m7906n();
                            int iM7907o = c3959f5.m7907o();
                            interfaceC4028c2 = interfaceC4028c;
                            C4036k c4036k3 = c3959f5.f13356d;
                            i16 = iM7905m2;
                            c4036k3.f13688h.mo8030d(iM7906n);
                            C4038m c4038m3 = c3959f5.f13358e;
                            i17 = iM7902j;
                            c4038m3.f13688h.mo8030d(iM7907o);
                            c4031f.m8027g();
                            ArrayList<AbstractC4039n> arrayList4 = c4031f.f13659e;
                            c3621k2 = c3621k;
                            C4033h c4033h = c4036k3.f13685e;
                            enumC3957d5 = enumC3957d3;
                            C4033h c4033h2 = c4038m3.f13685e;
                            i15 = size;
                            enumC3957d6 = enumC3957d2;
                            if (enumC3957dM7901i2 == enumC3957d6 || enumC3957dM7901i3 == enumC3957d6) {
                                if (z7) {
                                    Iterator it = arrayList4.iterator();
                                    while (it.hasNext()) {
                                        if (!((AbstractC4039n) it.next()).mo8018k()) {
                                            z7 = false;
                                            break;
                                        }
                                    }
                                }
                                if (z7 && enumC3957dM7901i2 == enumC3957d6) {
                                    enumC3957d4 = enumC3957d8;
                                    c3959f5.m7916x(enumC3957d4);
                                    c3959f5.m7918z(c4031f.m8024d(c3959f5, 0));
                                    c4033h.mo8030d(c3959f5.m7905m());
                                } else {
                                    enumC3957d4 = enumC3957d8;
                                }
                                if (z7 && enumC3957dM7901i3 == enumC3957d6) {
                                    c3959f5.m7917y(enumC3957d4);
                                    c3959f5.m7915w(c4031f.m8024d(c3959f5, 1));
                                    c4033h2.mo8030d(c3959f5.m7902j());
                                }
                            } else {
                                mode = mode;
                                mode2 = mode2;
                                enumC3957d4 = enumC3957d8;
                            }
                            EnumC3957d enumC3957d9 = c3959f5.f13333J[0];
                            EnumC3957d enumC3957d10 = EnumC3957d.f13322d;
                            if (enumC3957d9 == enumC3957d4 || enumC3957d9 == enumC3957d10) {
                                int iM7905m7 = c3959f5.m7905m() + iM7906n;
                                c4036k3.f13689i.mo8030d(iM7905m7);
                                c4033h.mo8030d(iM7905m7 - iM7906n);
                                c4031f.m8027g();
                                EnumC3957d enumC3957d11 = c3959f5.f13333J[1];
                                if (enumC3957d11 == enumC3957d4 || enumC3957d11 == enumC3957d10) {
                                    int iM7902j6 = c3959f5.m7902j() + iM7907o;
                                    c4038m3.f13689i.mo8030d(iM7902j6);
                                    c4033h2.mo8030d(iM7902j6 - iM7907o);
                                }
                                c4031f.m8027g();
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            for (AbstractC4039n abstractC4039n : arrayList4) {
                                if (abstractC4039n.f13682b != c3959f5 || abstractC4039n.f13687g) {
                                    abstractC4039n.mo8015e();
                                }
                            }
                            Iterator it2 = arrayList4.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z20 = true;
                                    break;
                                }
                                AbstractC4039n abstractC4039n2 = (AbstractC4039n) it2.next();
                                if (z19 || abstractC4039n2.f13682b != c3959f5) {
                                    if (!abstractC4039n2.f13688h.f13672j || ((!abstractC4039n2.f13689i.f13672j && !(abstractC4039n2 instanceof C4034i)) || (!abstractC4039n2.f13685e.f13672j && !(abstractC4039n2 instanceof C4029d) && !(abstractC4039n2 instanceof C4034i)))) {
                                        z20 = false;
                                        break;
                                    }
                                }
                            }
                            c3959f5.m7916x(enumC3957dM7901i2);
                            c3959f5.m7917y(enumC3957dM7901i3);
                            c3959f2 = c3959f;
                            zM7921E = z20;
                            i31 = mode2;
                            i33 = mode;
                            i34 = 1073741824;
                            i18 = 2;
                        }
                        if (zM7921E) {
                            if (i33 == i34) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (i31 == i34) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            c3959f2.mo7894A(z17, z18);
                        }
                    } else {
                        enumC3957d4 = enumC3957d8;
                        c3959f2 = c3959f;
                        c3621k2 = c3621k;
                        interfaceC4028c2 = interfaceC4028c;
                        i15 = size;
                        i16 = iM7905m2;
                        i17 = iM7902j;
                        enumC3957d5 = enumC3957d3;
                        enumC3957d6 = enumC3957d2;
                        i18 = 0;
                        zM7921E = false;
                    }
                    if (zM7921E || i18 != 2) {
                        if (i15 > 0) {
                            size3 = c3959f2.f13382g0.size();
                            interfaceC4028c6 = c3959f2.f13385j0;
                            i28 = 0;
                            while (i28 < size3) {
                                c3958e6 = (C3958e) c3959f2.f13382g0.get(i28);
                                if ((c3958e6 instanceof C3962i) && !(c3958e6.f13356d.f13685e.f13672j && c3958e6.f13358e.f13685e.f13672j)) {
                                    enumC3957dM7901i = c3958e6.m7901i(0);
                                    EnumC3957d enumC3957dM7901i4 = c3958e6.m7901i(1);
                                    enumC3957d7 = enumC3957d5;
                                    if (enumC3957dM7901i == enumC3957d7 || c3958e6.f13365j == 1 || enumC3957dM7901i4 != enumC3957d7 || c3958e6.f13366k == 1) {
                                        c3621k4 = c3621k2;
                                        c3621k4.m7333j(interfaceC4028c6, c3958e6, false);
                                    } else {
                                        c3621k4 = c3621k2;
                                    }
                                } else {
                                    c3621k4 = c3621k2;
                                    enumC3957d7 = enumC3957d5;
                                }
                                i28++;
                                c3621k2 = c3621k4;
                                enumC3957d5 = enumC3957d7;
                            }
                            c3621k3 = c3621k2;
                            constraintLayout = ((C0306b) interfaceC4028c6).f1399a;
                            childCount = constraintLayout.getChildCount();
                            for (i29 = 0; i29 < childCount; i29++) {
                                childAt = constraintLayout.getChildAt(i29);
                                if (childAt instanceof Placeholder) {
                                    placeholder = (Placeholder) childAt;
                                    if (placeholder.f1394b == null) {
                                        LayoutParams layoutParams2 = (LayoutParams) placeholder.getLayoutParams();
                                        layoutParams = (LayoutParams) placeholder.f1394b.getLayoutParams();
                                        c3958e3 = layoutParams.f1364l0;
                                        c3958e3.f13347X = 0;
                                        c3958e4 = layoutParams2.f1364l0;
                                        if (c3958e4.f13333J[0] != enumC3957d4) {
                                            c3958e4.m7918z(c3958e3.m7905m());
                                        }
                                        c3958e5 = layoutParams2.f1364l0;
                                        if (c3958e5.f13333J[1] != enumC3957d4) {
                                            c3958e5.m7915w(layoutParams.f1364l0.m7902j());
                                        }
                                        layoutParams.f1364l0.f13347X = 8;
                                    }
                                }
                            }
                            arrayList3 = constraintLayout.f1301b;
                            size4 = arrayList3.size();
                            if (size4 > 0) {
                                for (i30 = 0; i30 < size4; i30++) {
                                    ((ConstraintHelper) arrayList3.get(i30)).getClass();
                                }
                            }
                        } else {
                            c3621k3 = c3621k2;
                        }
                        i19 = c3959f2.f13394s0;
                        arrayList = (ArrayList) c3621k3.f12170b;
                        size2 = arrayList.size();
                        i20 = i16;
                        i21 = i17;
                        if (i15 > 0) {
                            c3621k3.m7335l(c3959f2, i20, i21);
                        }
                        if (size2 > 0) {
                            enumC3957dArr = c3959f2.f13333J;
                            if (enumC3957dArr[0] == enumC3957d6) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (enumC3957dArr[1] == enumC3957d6) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            int iM7905m8 = c3959f.m7905m();
                            C3959f c3959f6 = (C3959f) c3621k3.f12172d;
                            iMax3 = Math.max(iM7905m8, c3959f6.f13342S);
                            iMax4 = Math.max(c3959f.m7902j(), c3959f6.f13343T);
                            i24 = 0;
                            zM7333j = false;
                            while (i24 < size2) {
                                c3958e2 = (C3958e) arrayList.get(i24);
                                if (c3958e2 instanceof C3961h) {
                                    iM7905m5 = c3958e2.m7905m();
                                    iM7902j4 = c3958e2.m7902j();
                                    interfaceC4028c5 = interfaceC4028c2;
                                    boolean zM7333j2 = zM7333j | c3621k3.m7333j(interfaceC4028c5, c3958e2, true);
                                    iM7905m6 = c3958e2.m7905m();
                                    z15 = zM7333j2;
                                    iM7902j5 = c3958e2.m7902j();
                                    if (iM7905m6 != iM7905m5) {
                                        c3958e2.m7918z(iM7905m6);
                                        if (z12 && c3958e2.m7906n() + c3958e2.f13335L > iMax3) {
                                            iMax3 = Math.max(iMax3, c3958e2.mo7900h(4).m7887c() + c3958e2.m7906n() + c3958e2.f13335L);
                                        }
                                        z15 = true;
                                    }
                                    if (iM7902j5 != iM7902j4) {
                                        c3958e2.m7915w(iM7902j5);
                                        if (z13 && c3958e2.m7907o() + c3958e2.f13336M > iMax4) {
                                            iMax4 = Math.max(iMax4, c3958e2.mo7900h(5).m7887c() + c3958e2.m7907o() + c3958e2.f13336M);
                                        }
                                        z15 = true;
                                    }
                                    zM7333j = z15 | ((C3961h) c3958e2).f13439o0;
                                } else {
                                    interfaceC4028c5 = interfaceC4028c2;
                                }
                                i24++;
                                interfaceC4028c2 = interfaceC4028c5;
                                i19 = i19;
                            }
                            i22 = i19;
                            interfaceC4028c3 = interfaceC4028c2;
                            i25 = 0;
                            while (i25 < 2) {
                                i26 = 0;
                                while (i26 < size2) {
                                    c3958e = (C3958e) arrayList.get(i26);
                                    if (((c3958e instanceof C3963j) || (c3958e instanceof C3961h)) && !(c3958e instanceof C3962i)) {
                                        if (c3958e.f13347X == 8 && ((!c3958e.f13356d.f13685e.f13672j || !c3958e.f13358e.f13685e.f13672j) && !(c3958e instanceof C3961h))) {
                                            iM7905m3 = c3958e.m7905m();
                                            iM7902j2 = c3958e.m7902j();
                                            arrayList2 = arrayList;
                                            int i44 = c3958e.f13341R;
                                            i27 = size2;
                                            zM7333j |= c3621k3.m7333j(interfaceC4028c3, c3958e, true);
                                            iM7905m4 = c3958e.m7905m();
                                            interfaceC4028c4 = interfaceC4028c3;
                                            iM7902j3 = c3958e.m7902j();
                                            if (iM7905m4 != iM7905m3) {
                                                c3958e.m7918z(iM7905m4);
                                                if (!z12 && c3958e.m7906n() + c3958e.f13335L > iMax3) {
                                                    iMax3 = Math.max(iMax3, c3958e.mo7900h(4).m7887c() + c3958e.m7906n() + c3958e.f13335L);
                                                }
                                                zM7333j = true;
                                            }
                                            if (iM7902j3 != iM7902j2) {
                                                c3958e.m7915w(iM7902j3);
                                                if (!z13 && c3958e.m7907o() + c3958e.f13336M > iMax4) {
                                                    iMax4 = Math.max(iMax4, c3958e.mo7900h(5).m7887c() + c3958e.m7907o() + c3958e.f13336M);
                                                }
                                                zM7333j = true;
                                            }
                                            if (!c3958e.f13378w && i44 != c3958e.f13341R) {
                                                zM7333j = true;
                                            }
                                        }
                                        i26++;
                                        arrayList = arrayList2;
                                        size2 = i27;
                                        interfaceC4028c3 = interfaceC4028c4;
                                    }
                                    interfaceC4028c4 = interfaceC4028c3;
                                    arrayList2 = arrayList;
                                    i27 = size2;
                                    i26++;
                                    arrayList = arrayList2;
                                    size2 = i27;
                                    interfaceC4028c3 = interfaceC4028c4;
                                }
                                InterfaceC4028c interfaceC4028c7 = interfaceC4028c3;
                                ArrayList arrayList5 = arrayList;
                                int i45 = size2;
                                if (zM7333j) {
                                    c3621k3.m7335l(c3959f, i20, i21);
                                    zM7333j = false;
                                }
                                i25++;
                                interfaceC4028c3 = interfaceC4028c7;
                                arrayList = arrayList5;
                                size2 = i45;
                            }
                            c3959f3 = c3959f;
                            if (zM7333j) {
                                c3621k3.m7335l(c3959f3, i20, i21);
                                if (c3959f.m7905m() < iMax3) {
                                    c3959f3.m7918z(iMax3);
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                if (c3959f.m7902j() < iMax4) {
                                    c3959f3.m7915w(iMax4);
                                    z14 = true;
                                }
                                if (z14) {
                                    c3621k3.m7335l(c3959f3, i20, i21);
                                }
                            }
                        } else {
                            i22 = i19;
                            c3959f3 = c3959f2;
                        }
                        i23 = i22;
                        c3959f3.f13394s0 = i23;
                        if ((i23 & 256) == 256) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        C3882e.f13030p = z11;
                    }
                    return;
                }
                if (childCount2 == 0) {
                    iMax2 = Math.max(0, this.f1304e);
                } else {
                    iMax2 = i39;
                }
                enumC3957d = enumC3957d8;
                enumC3957d2 = enumC3957d;
                iM7905m = c3959f.m7905m();
                c4031f = c3959f.f13384i0;
                if (iMax == iM7905m) {
                    c4031f.f13657c = true;
                } else {
                    c4031f.f13657c = true;
                }
                c3959f.f13339P = 0;
                c3959f.f13340Q = 0;
                int i46 = this.f1305f - i41;
                int[] iArr2 = c3959f.f13376u;
                iArr2[0] = i46;
                iArr2[1] = this.f1306g - i40;
                c3959f.f13342S = 0;
                c3959f.f13343T = 0;
                c3959f.m7916x(enumC3957d8);
                c3959f.m7918z(iMax);
                c3959f.m7917y(enumC3957d);
                c3959f.m7915w(iMax2);
                i12 = this.f1303d - i41;
                if (i12 < 0) {
                    c3959f.f13342S = 0;
                } else {
                    c3959f.f13342S = i12;
                }
                i13 = this.f1304e - i40;
                if (i13 < 0) {
                    c3959f.f13343T = 0;
                } else {
                    c3959f.f13343T = i13;
                }
                c3959f.f13388m0 = iMax7;
                c3959f.f13389n0 = iMax5;
                c3621k = c3959f.f13383h0;
                c3621k.getClass();
                interfaceC4028c = c3959f.f13385j0;
                size = c3959f.f13382g0.size();
                iM7905m2 = c3959f.m7905m();
                iM7902j = c3959f.m7902j();
                if ((i6 & 128) == 128) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    z10 = true;
                } else {
                    z10 = true;
                }
                enumC3957d3 = EnumC3957d.f13321c;
                if (z10) {
                    i36 = 0;
                    while (true) {
                        if (i36 < size) {
                            c3958e7 = (C3958e) c3959f.f13382g0.get(i36);
                            enumC3957dArr2 = c3958e7.f13333J;
                            if (enumC3957dArr2[0] == enumC3957d3) {
                                z21 = true;
                            } else {
                                z21 = false;
                            }
                            if (enumC3957dArr2[1] == enumC3957d3) {
                                z22 = true;
                            } else {
                                z22 = false;
                            }
                            if (z21) {
                                z23 = false;
                            } else {
                                z23 = false;
                            }
                            i36 = !c3958e7.m7910r() ? i36 + 1 : i36 + 1;
                            i14 = 1073741824;
                            z10 = false;
                        } else {
                            i14 = 1073741824;
                        }
                    }
                } else {
                    i14 = 1073741824;
                }
                if (((mode != i14 && mode2 == i14) || z7) && z10) {
                    iMin = Math.min(c3959f.f13376u[0], i38);
                    iMin2 = Math.min(c3959f.f13376u[1], i39);
                    if (mode == 1073741824) {
                        c3959f.m7918z(iMin);
                        c3959f.f13384i0.f13656b = true;
                    }
                    if (mode2 == 1073741824) {
                        c3959f.m7915w(iMin2);
                        c3959f.f13384i0.f13656b = true;
                    }
                    if (mode == 1073741824) {
                        c3621k2 = c3621k;
                        interfaceC4028c2 = interfaceC4028c;
                        i15 = size;
                        i16 = iM7905m2;
                        enumC3957d5 = enumC3957d3;
                        enumC3957d6 = enumC3957d2;
                        i31 = mode2;
                        i17 = iM7902j;
                        enumC3957d4 = enumC3957d8;
                        z16 = c4031f.f13656b;
                        c3959f4 = c4031f.f13655a;
                        if (z16) {
                            while (r1.hasNext()) {
                                c3958e8.f13350a = false;
                                C4036k c4036k4 = c3958e8.f13356d;
                                c4036k4.f13685e.f13672j = false;
                                c4036k4.f13687g = false;
                                c4036k4.m8034n();
                                C4038m c4038m4 = c3958e8.f13358e;
                                c4038m4.f13685e.f13672j = false;
                                c4038m4.f13687g = false;
                                c4038m4.m8037m();
                            }
                            i32 = 0;
                            c3959f4.f13350a = false;
                            C4036k c4036k5 = c3959f4.f13356d;
                            c4036k5.f13685e.f13672j = false;
                            c4036k5.f13687g = false;
                            c4036k5.m8034n();
                            C4038m c4038m5 = c3959f4.f13358e;
                            c4038m5.f13685e.f13672j = false;
                            c4038m5.f13687g = false;
                            c4038m5.m8037m();
                            c4031f.m8023c();
                        } else {
                            i32 = 0;
                        }
                        c4031f.m8022b(c4031f.f13658d);
                        c3959f4.f13339P = i32;
                        c3959f4.f13340Q = i32;
                        c3959f4.f13356d.f13688h.mo8030d(i32);
                        c3959f4.f13358e.f13688h.mo8030d(i32);
                        i33 = mode;
                        i34 = 1073741824;
                        c3959f2 = c3959f;
                        if (i33 == 1073741824) {
                            zM7921E = c3959f2.m7921E(i32, z7);
                            i18 = 1;
                        } else {
                            i18 = 0;
                            zM7921E = true;
                        }
                        if (i31 == 1073741824) {
                            zM7921E &= c3959f2.m7921E(1, z7);
                            i18++;
                        }
                    } else {
                        c3621k2 = c3621k;
                        interfaceC4028c2 = interfaceC4028c;
                        i15 = size;
                        i16 = iM7905m2;
                        enumC3957d5 = enumC3957d3;
                        enumC3957d6 = enumC3957d2;
                        i31 = mode2;
                        i17 = iM7902j;
                        enumC3957d4 = enumC3957d8;
                        z16 = c4031f.f13656b;
                        c3959f4 = c4031f.f13655a;
                        if (z16) {
                            while (r1.hasNext()) {
                                c3958e8.f13350a = false;
                                C4036k c4036k6 = c3958e8.f13356d;
                                c4036k6.f13685e.f13672j = false;
                                c4036k6.f13687g = false;
                                c4036k6.m8034n();
                                C4038m c4038m6 = c3958e8.f13358e;
                                c4038m6.f13685e.f13672j = false;
                                c4038m6.f13687g = false;
                                c4038m6.m8037m();
                            }
                            i32 = 0;
                            c3959f4.f13350a = false;
                            C4036k c4036k7 = c3959f4.f13356d;
                            c4036k7.f13685e.f13672j = false;
                            c4036k7.f13687g = false;
                            c4036k7.m8034n();
                            C4038m c4038m7 = c3959f4.f13358e;
                            c4038m7.f13685e.f13672j = false;
                            c4038m7.f13687g = false;
                            c4038m7.m8037m();
                            c4031f.m8023c();
                        } else {
                            i32 = 0;
                        }
                        c4031f.m8022b(c4031f.f13658d);
                        c3959f4.f13339P = i32;
                        c3959f4.f13340Q = i32;
                        c3959f4.f13356d.f13688h.mo8030d(i32);
                        c3959f4.f13358e.f13688h.mo8030d(i32);
                        i33 = mode;
                        i34 = 1073741824;
                        c3959f2 = c3959f;
                        if (i33 == 1073741824) {
                            zM7921E = c3959f2.m7921E(i32, z7);
                            i18 = 1;
                        } else {
                            i18 = 0;
                            zM7921E = true;
                        }
                        if (i31 == 1073741824) {
                            zM7921E &= c3959f2.m7921E(1, z7);
                            i18++;
                        }
                    }
                    if (zM7921E) {
                        if (i33 == i34) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (i31 == i34) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        c3959f2.mo7894A(z17, z18);
                    }
                } else {
                    enumC3957d4 = enumC3957d8;
                    c3959f2 = c3959f;
                    c3621k2 = c3621k;
                    interfaceC4028c2 = interfaceC4028c;
                    i15 = size;
                    i16 = iM7905m2;
                    i17 = iM7902j;
                    enumC3957d5 = enumC3957d3;
                    enumC3957d6 = enumC3957d2;
                    i18 = 0;
                    zM7921E = false;
                }
                if (zM7921E) {
                }
                if (i15 > 0) {
                    size3 = c3959f2.f13382g0.size();
                    interfaceC4028c6 = c3959f2.f13385j0;
                    i28 = 0;
                    while (i28 < size3) {
                        c3958e6 = (C3958e) c3959f2.f13382g0.get(i28);
                        if (c3958e6 instanceof C3962i) {
                            c3621k4 = c3621k2;
                            enumC3957d7 = enumC3957d5;
                        } else {
                            enumC3957dM7901i = c3958e6.m7901i(0);
                            EnumC3957d enumC3957dM7901i5 = c3958e6.m7901i(1);
                            enumC3957d7 = enumC3957d5;
                            if (enumC3957dM7901i == enumC3957d7) {
                                c3621k4 = c3621k2;
                                c3621k4.m7333j(interfaceC4028c6, c3958e6, false);
                            } else {
                                c3621k4 = c3621k2;
                                c3621k4.m7333j(interfaceC4028c6, c3958e6, false);
                            }
                        }
                        i28++;
                        c3621k2 = c3621k4;
                        enumC3957d5 = enumC3957d7;
                    }
                    c3621k3 = c3621k2;
                    constraintLayout = ((C0306b) interfaceC4028c6).f1399a;
                    childCount = constraintLayout.getChildCount();
                    while (i29 < childCount) {
                        childAt = constraintLayout.getChildAt(i29);
                        if (childAt instanceof Placeholder) {
                            placeholder = (Placeholder) childAt;
                            if (placeholder.f1394b == null) {
                                LayoutParams layoutParams3 = (LayoutParams) placeholder.getLayoutParams();
                                layoutParams = (LayoutParams) placeholder.f1394b.getLayoutParams();
                                c3958e3 = layoutParams.f1364l0;
                                c3958e3.f13347X = 0;
                                c3958e4 = layoutParams3.f1364l0;
                                if (c3958e4.f13333J[0] != enumC3957d4) {
                                    c3958e4.m7918z(c3958e3.m7905m());
                                }
                                c3958e5 = layoutParams3.f1364l0;
                                if (c3958e5.f13333J[1] != enumC3957d4) {
                                    c3958e5.m7915w(layoutParams.f1364l0.m7902j());
                                }
                                layoutParams.f1364l0.f13347X = 8;
                            }
                        }
                    }
                    arrayList3 = constraintLayout.f1301b;
                    size4 = arrayList3.size();
                    if (size4 > 0) {
                        while (i30 < size4) {
                            ((ConstraintHelper) arrayList3.get(i30)).getClass();
                        }
                    }
                } else {
                    c3621k3 = c3621k2;
                }
                i19 = c3959f2.f13394s0;
                arrayList = (ArrayList) c3621k3.f12170b;
                size2 = arrayList.size();
                i20 = i16;
                i21 = i17;
                if (i15 > 0) {
                    c3621k3.m7335l(c3959f2, i20, i21);
                }
                if (size2 > 0) {
                    enumC3957dArr = c3959f2.f13333J;
                    if (enumC3957dArr[0] == enumC3957d6) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (enumC3957dArr[1] == enumC3957d6) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    int iM7905m9 = c3959f.m7905m();
                    C3959f c3959f7 = (C3959f) c3621k3.f12172d;
                    iMax3 = Math.max(iM7905m9, c3959f7.f13342S);
                    iMax4 = Math.max(c3959f.m7902j(), c3959f7.f13343T);
                    i24 = 0;
                    zM7333j = false;
                    while (i24 < size2) {
                        c3958e2 = (C3958e) arrayList.get(i24);
                        if (c3958e2 instanceof C3961h) {
                            interfaceC4028c5 = interfaceC4028c2;
                        } else {
                            iM7905m5 = c3958e2.m7905m();
                            iM7902j4 = c3958e2.m7902j();
                            interfaceC4028c5 = interfaceC4028c2;
                            boolean zM7333j3 = zM7333j | c3621k3.m7333j(interfaceC4028c5, c3958e2, true);
                            iM7905m6 = c3958e2.m7905m();
                            z15 = zM7333j3;
                            iM7902j5 = c3958e2.m7902j();
                            if (iM7905m6 != iM7905m5) {
                                c3958e2.m7918z(iM7905m6);
                                if (z12) {
                                    iMax3 = Math.max(iMax3, c3958e2.mo7900h(4).m7887c() + c3958e2.m7906n() + c3958e2.f13335L);
                                }
                                z15 = true;
                            }
                            if (iM7902j5 != iM7902j4) {
                                c3958e2.m7915w(iM7902j5);
                                if (z13) {
                                    iMax4 = Math.max(iMax4, c3958e2.mo7900h(5).m7887c() + c3958e2.m7907o() + c3958e2.f13336M);
                                }
                                z15 = true;
                            }
                            zM7333j = z15 | ((C3961h) c3958e2).f13439o0;
                        }
                        i24++;
                        interfaceC4028c2 = interfaceC4028c5;
                        i19 = i19;
                    }
                    i22 = i19;
                    interfaceC4028c3 = interfaceC4028c2;
                    i25 = 0;
                    while (i25 < 2) {
                        i26 = 0;
                        while (i26 < size2) {
                            c3958e = (C3958e) arrayList.get(i26);
                            if (c3958e instanceof C3963j) {
                                if (c3958e.f13347X == 8) {
                                    interfaceC4028c4 = interfaceC4028c3;
                                    arrayList2 = arrayList;
                                    i27 = size2;
                                } else {
                                    iM7905m3 = c3958e.m7905m();
                                    iM7902j2 = c3958e.m7902j();
                                    arrayList2 = arrayList;
                                    int i47 = c3958e.f13341R;
                                    i27 = size2;
                                    zM7333j |= c3621k3.m7333j(interfaceC4028c3, c3958e, true);
                                    iM7905m4 = c3958e.m7905m();
                                    interfaceC4028c4 = interfaceC4028c3;
                                    iM7902j3 = c3958e.m7902j();
                                    if (iM7905m4 != iM7905m3) {
                                        c3958e.m7918z(iM7905m4);
                                        if (!z12) {
                                        }
                                        zM7333j = true;
                                    }
                                    if (iM7902j3 != iM7902j2) {
                                        c3958e.m7915w(iM7902j3);
                                        if (!z13) {
                                        }
                                        zM7333j = true;
                                    }
                                    if (!c3958e.f13378w) {
                                    }
                                }
                            } else if (c3958e.f13347X == 8) {
                                interfaceC4028c4 = interfaceC4028c3;
                                arrayList2 = arrayList;
                                i27 = size2;
                            } else {
                                iM7905m3 = c3958e.m7905m();
                                iM7902j2 = c3958e.m7902j();
                                arrayList2 = arrayList;
                                int i48 = c3958e.f13341R;
                                i27 = size2;
                                zM7333j |= c3621k3.m7333j(interfaceC4028c3, c3958e, true);
                                iM7905m4 = c3958e.m7905m();
                                interfaceC4028c4 = interfaceC4028c3;
                                iM7902j3 = c3958e.m7902j();
                                if (iM7905m4 != iM7905m3) {
                                    c3958e.m7918z(iM7905m4);
                                    if (!z12) {
                                    }
                                    zM7333j = true;
                                }
                                if (iM7902j3 != iM7902j2) {
                                    c3958e.m7915w(iM7902j3);
                                    if (!z13) {
                                    }
                                    zM7333j = true;
                                }
                                if (!c3958e.f13378w) {
                                }
                            }
                            i26++;
                            arrayList = arrayList2;
                            size2 = i27;
                            interfaceC4028c3 = interfaceC4028c4;
                        }
                        InterfaceC4028c interfaceC4028c8 = interfaceC4028c3;
                        ArrayList arrayList6 = arrayList;
                        int i49 = size2;
                        if (zM7333j) {
                            c3621k3.m7335l(c3959f, i20, i21);
                            zM7333j = false;
                        }
                        i25++;
                        interfaceC4028c3 = interfaceC4028c8;
                        arrayList = arrayList6;
                        size2 = i49;
                    }
                    c3959f3 = c3959f;
                    if (zM7333j) {
                        c3621k3.m7335l(c3959f3, i20, i21);
                        if (c3959f.m7905m() < iMax3) {
                            c3959f3.m7918z(iMax3);
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (c3959f.m7902j() < iMax4) {
                            c3959f3.m7915w(iMax4);
                            z14 = true;
                        }
                        if (z14) {
                            c3621k3.m7335l(c3959f3, i20, i21);
                        }
                    }
                } else {
                    i22 = i19;
                    c3959f3 = c3959f2;
                }
                i23 = i22;
                c3959f3.f13394s0 = i23;
                if ((i23 & 256) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                C3882e.f13030p = z11;
            }
            if (childCount2 == 0) {
                iMax = Math.max(0, this.f1303d);
            } else {
                enumC3957d8 = enumC3957d8;
                i42 = Integer.MIN_VALUE;
            }
            iMax = 0;
            if (mode2 != i42) {
                if (mode2 != 0) {
                    if (mode2 != 1073741824) {
                        enumC3957d = enumC3957d8;
                        enumC3957d2 = enumC3957d8;
                        iMax2 = 0;
                    } else {
                        iMax2 = Math.min(this.f1306g - i40, i39);
                        enumC3957d2 = enumC3957d8;
                        enumC3957d = enumC3957d8;
                    }
                } else if (childCount2 == 0) {
                    enumC3957d = enumC3957d8;
                    enumC3957d2 = enumC3957d;
                    iMax2 = Math.max(0, this.f1304e);
                } else {
                    iMax2 = 0;
                }
                iM7905m = c3959f.m7905m();
                c4031f = c3959f.f13384i0;
                if (iMax == iM7905m) {
                    c4031f.f13657c = true;
                } else {
                    c4031f.f13657c = true;
                }
                c3959f.f13339P = 0;
                c3959f.f13340Q = 0;
                int i410 = this.f1305f - i41;
                int[] iArr3 = c3959f.f13376u;
                iArr3[0] = i410;
                iArr3[1] = this.f1306g - i40;
                c3959f.f13342S = 0;
                c3959f.f13343T = 0;
                c3959f.m7916x(enumC3957d8);
                c3959f.m7918z(iMax);
                c3959f.m7917y(enumC3957d);
                c3959f.m7915w(iMax2);
                i12 = this.f1303d - i41;
                if (i12 < 0) {
                    c3959f.f13342S = 0;
                } else {
                    c3959f.f13342S = i12;
                }
                i13 = this.f1304e - i40;
                if (i13 < 0) {
                    c3959f.f13343T = 0;
                } else {
                    c3959f.f13343T = i13;
                }
                c3959f.f13388m0 = iMax7;
                c3959f.f13389n0 = iMax5;
                c3621k = c3959f.f13383h0;
                c3621k.getClass();
                interfaceC4028c = c3959f.f13385j0;
                size = c3959f.f13382g0.size();
                iM7905m2 = c3959f.m7905m();
                iM7902j = c3959f.m7902j();
                if ((i6 & 128) == 128) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    z10 = true;
                } else {
                    z10 = true;
                }
                enumC3957d3 = EnumC3957d.f13321c;
                if (z10) {
                    i36 = 0;
                    while (true) {
                        if (i36 < size) {
                            c3958e7 = (C3958e) c3959f.f13382g0.get(i36);
                            enumC3957dArr2 = c3958e7.f13333J;
                            if (enumC3957dArr2[0] == enumC3957d3) {
                                z21 = true;
                            } else {
                                z21 = false;
                            }
                            if (enumC3957dArr2[1] == enumC3957d3) {
                                z22 = true;
                            } else {
                                z22 = false;
                            }
                            if (z21) {
                                z23 = false;
                            } else {
                                z23 = false;
                            }
                            if (!c3958e7.m7910r()) {
                            }
                            i14 = 1073741824;
                            z10 = false;
                        } else {
                            i14 = 1073741824;
                        }
                    }
                } else {
                    i14 = 1073741824;
                }
                if (((mode != i14 && mode2 == i14) || z7) && z10) {
                    iMin = Math.min(c3959f.f13376u[0], i38);
                    iMin2 = Math.min(c3959f.f13376u[1], i39);
                    if (mode == 1073741824) {
                        c3959f.m7918z(iMin);
                        c3959f.f13384i0.f13656b = true;
                    }
                    if (mode2 == 1073741824) {
                        c3959f.m7915w(iMin2);
                        c3959f.f13384i0.f13656b = true;
                    }
                    if (mode == 1073741824) {
                        c3621k2 = c3621k;
                        interfaceC4028c2 = interfaceC4028c;
                        i15 = size;
                        i16 = iM7905m2;
                        enumC3957d5 = enumC3957d3;
                        enumC3957d6 = enumC3957d2;
                        i31 = mode2;
                        i17 = iM7902j;
                        enumC3957d4 = enumC3957d8;
                        z16 = c4031f.f13656b;
                        c3959f4 = c4031f.f13655a;
                        if (z16) {
                            while (r1.hasNext()) {
                                c3958e8.f13350a = false;
                                C4036k c4036k8 = c3958e8.f13356d;
                                c4036k8.f13685e.f13672j = false;
                                c4036k8.f13687g = false;
                                c4036k8.m8034n();
                                C4038m c4038m8 = c3958e8.f13358e;
                                c4038m8.f13685e.f13672j = false;
                                c4038m8.f13687g = false;
                                c4038m8.m8037m();
                            }
                            i32 = 0;
                            c3959f4.f13350a = false;
                            C4036k c4036k9 = c3959f4.f13356d;
                            c4036k9.f13685e.f13672j = false;
                            c4036k9.f13687g = false;
                            c4036k9.m8034n();
                            C4038m c4038m9 = c3959f4.f13358e;
                            c4038m9.f13685e.f13672j = false;
                            c4038m9.f13687g = false;
                            c4038m9.m8037m();
                            c4031f.m8023c();
                        } else {
                            i32 = 0;
                        }
                        c4031f.m8022b(c4031f.f13658d);
                        c3959f4.f13339P = i32;
                        c3959f4.f13340Q = i32;
                        c3959f4.f13356d.f13688h.mo8030d(i32);
                        c3959f4.f13358e.f13688h.mo8030d(i32);
                        i33 = mode;
                        i34 = 1073741824;
                        c3959f2 = c3959f;
                        if (i33 == 1073741824) {
                            zM7921E = c3959f2.m7921E(i32, z7);
                            i18 = 1;
                        } else {
                            i18 = 0;
                            zM7921E = true;
                        }
                        if (i31 == 1073741824) {
                            zM7921E &= c3959f2.m7921E(1, z7);
                            i18++;
                        }
                    } else {
                        c3621k2 = c3621k;
                        interfaceC4028c2 = interfaceC4028c;
                        i15 = size;
                        i16 = iM7905m2;
                        enumC3957d5 = enumC3957d3;
                        enumC3957d6 = enumC3957d2;
                        i31 = mode2;
                        i17 = iM7902j;
                        enumC3957d4 = enumC3957d8;
                        z16 = c4031f.f13656b;
                        c3959f4 = c4031f.f13655a;
                        if (z16) {
                            while (r1.hasNext()) {
                                c3958e8.f13350a = false;
                                C4036k c4036k10 = c3958e8.f13356d;
                                c4036k10.f13685e.f13672j = false;
                                c4036k10.f13687g = false;
                                c4036k10.m8034n();
                                C4038m c4038m10 = c3958e8.f13358e;
                                c4038m10.f13685e.f13672j = false;
                                c4038m10.f13687g = false;
                                c4038m10.m8037m();
                            }
                            i32 = 0;
                            c3959f4.f13350a = false;
                            C4036k c4036k11 = c3959f4.f13356d;
                            c4036k11.f13685e.f13672j = false;
                            c4036k11.f13687g = false;
                            c4036k11.m8034n();
                            C4038m c4038m11 = c3959f4.f13358e;
                            c4038m11.f13685e.f13672j = false;
                            c4038m11.f13687g = false;
                            c4038m11.m8037m();
                            c4031f.m8023c();
                        } else {
                            i32 = 0;
                        }
                        c4031f.m8022b(c4031f.f13658d);
                        c3959f4.f13339P = i32;
                        c3959f4.f13340Q = i32;
                        c3959f4.f13356d.f13688h.mo8030d(i32);
                        c3959f4.f13358e.f13688h.mo8030d(i32);
                        i33 = mode;
                        i34 = 1073741824;
                        c3959f2 = c3959f;
                        if (i33 == 1073741824) {
                            zM7921E = c3959f2.m7921E(i32, z7);
                            i18 = 1;
                        } else {
                            i18 = 0;
                            zM7921E = true;
                        }
                        if (i31 == 1073741824) {
                            zM7921E &= c3959f2.m7921E(1, z7);
                            i18++;
                        }
                    }
                    if (zM7921E) {
                        if (i33 == i34) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (i31 == i34) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        c3959f2.mo7894A(z17, z18);
                    }
                } else {
                    enumC3957d4 = enumC3957d8;
                    c3959f2 = c3959f;
                    c3621k2 = c3621k;
                    interfaceC4028c2 = interfaceC4028c;
                    i15 = size;
                    i16 = iM7905m2;
                    i17 = iM7902j;
                    enumC3957d5 = enumC3957d3;
                    enumC3957d6 = enumC3957d2;
                    i18 = 0;
                    zM7921E = false;
                }
                if (zM7921E) {
                }
                if (i15 > 0) {
                    size3 = c3959f2.f13382g0.size();
                    interfaceC4028c6 = c3959f2.f13385j0;
                    i28 = 0;
                    while (i28 < size3) {
                        c3958e6 = (C3958e) c3959f2.f13382g0.get(i28);
                        if (c3958e6 instanceof C3962i) {
                            c3621k4 = c3621k2;
                            enumC3957d7 = enumC3957d5;
                        } else {
                            enumC3957dM7901i = c3958e6.m7901i(0);
                            EnumC3957d enumC3957dM7901i6 = c3958e6.m7901i(1);
                            enumC3957d7 = enumC3957d5;
                            if (enumC3957dM7901i == enumC3957d7) {
                                c3621k4 = c3621k2;
                                c3621k4.m7333j(interfaceC4028c6, c3958e6, false);
                            } else {
                                c3621k4 = c3621k2;
                                c3621k4.m7333j(interfaceC4028c6, c3958e6, false);
                            }
                        }
                        i28++;
                        c3621k2 = c3621k4;
                        enumC3957d5 = enumC3957d7;
                    }
                    c3621k3 = c3621k2;
                    constraintLayout = ((C0306b) interfaceC4028c6).f1399a;
                    childCount = constraintLayout.getChildCount();
                    while (i29 < childCount) {
                        childAt = constraintLayout.getChildAt(i29);
                        if (childAt instanceof Placeholder) {
                            placeholder = (Placeholder) childAt;
                            if (placeholder.f1394b == null) {
                                LayoutParams layoutParams4 = (LayoutParams) placeholder.getLayoutParams();
                                layoutParams = (LayoutParams) placeholder.f1394b.getLayoutParams();
                                c3958e3 = layoutParams.f1364l0;
                                c3958e3.f13347X = 0;
                                c3958e4 = layoutParams4.f1364l0;
                                if (c3958e4.f13333J[0] != enumC3957d4) {
                                    c3958e4.m7918z(c3958e3.m7905m());
                                }
                                c3958e5 = layoutParams4.f1364l0;
                                if (c3958e5.f13333J[1] != enumC3957d4) {
                                    c3958e5.m7915w(layoutParams.f1364l0.m7902j());
                                }
                                layoutParams.f1364l0.f13347X = 8;
                            }
                        }
                    }
                    arrayList3 = constraintLayout.f1301b;
                    size4 = arrayList3.size();
                    if (size4 > 0) {
                        while (i30 < size4) {
                            ((ConstraintHelper) arrayList3.get(i30)).getClass();
                        }
                    }
                } else {
                    c3621k3 = c3621k2;
                }
                i19 = c3959f2.f13394s0;
                arrayList = (ArrayList) c3621k3.f12170b;
                size2 = arrayList.size();
                i20 = i16;
                i21 = i17;
                if (i15 > 0) {
                    c3621k3.m7335l(c3959f2, i20, i21);
                }
                if (size2 > 0) {
                    enumC3957dArr = c3959f2.f13333J;
                    if (enumC3957dArr[0] == enumC3957d6) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (enumC3957dArr[1] == enumC3957d6) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    int iM7905m10 = c3959f.m7905m();
                    C3959f c3959f8 = (C3959f) c3621k3.f12172d;
                    iMax3 = Math.max(iM7905m10, c3959f8.f13342S);
                    iMax4 = Math.max(c3959f.m7902j(), c3959f8.f13343T);
                    i24 = 0;
                    zM7333j = false;
                    while (i24 < size2) {
                        c3958e2 = (C3958e) arrayList.get(i24);
                        if (c3958e2 instanceof C3961h) {
                            interfaceC4028c5 = interfaceC4028c2;
                        } else {
                            iM7905m5 = c3958e2.m7905m();
                            iM7902j4 = c3958e2.m7902j();
                            interfaceC4028c5 = interfaceC4028c2;
                            boolean zM7333j4 = zM7333j | c3621k3.m7333j(interfaceC4028c5, c3958e2, true);
                            iM7905m6 = c3958e2.m7905m();
                            z15 = zM7333j4;
                            iM7902j5 = c3958e2.m7902j();
                            if (iM7905m6 != iM7905m5) {
                                c3958e2.m7918z(iM7905m6);
                                if (z12) {
                                    iMax3 = Math.max(iMax3, c3958e2.mo7900h(4).m7887c() + c3958e2.m7906n() + c3958e2.f13335L);
                                }
                                z15 = true;
                            }
                            if (iM7902j5 != iM7902j4) {
                                c3958e2.m7915w(iM7902j5);
                                if (z13) {
                                    iMax4 = Math.max(iMax4, c3958e2.mo7900h(5).m7887c() + c3958e2.m7907o() + c3958e2.f13336M);
                                }
                                z15 = true;
                            }
                            zM7333j = z15 | ((C3961h) c3958e2).f13439o0;
                        }
                        i24++;
                        interfaceC4028c2 = interfaceC4028c5;
                        i19 = i19;
                    }
                    i22 = i19;
                    interfaceC4028c3 = interfaceC4028c2;
                    i25 = 0;
                    while (i25 < 2) {
                        i26 = 0;
                        while (i26 < size2) {
                            c3958e = (C3958e) arrayList.get(i26);
                            if (c3958e instanceof C3963j) {
                                if (c3958e.f13347X == 8) {
                                    interfaceC4028c4 = interfaceC4028c3;
                                    arrayList2 = arrayList;
                                    i27 = size2;
                                } else {
                                    iM7905m3 = c3958e.m7905m();
                                    iM7902j2 = c3958e.m7902j();
                                    arrayList2 = arrayList;
                                    int i411 = c3958e.f13341R;
                                    i27 = size2;
                                    zM7333j |= c3621k3.m7333j(interfaceC4028c3, c3958e, true);
                                    iM7905m4 = c3958e.m7905m();
                                    interfaceC4028c4 = interfaceC4028c3;
                                    iM7902j3 = c3958e.m7902j();
                                    if (iM7905m4 != iM7905m3) {
                                        c3958e.m7918z(iM7905m4);
                                        if (!z12) {
                                        }
                                        zM7333j = true;
                                    }
                                    if (iM7902j3 != iM7902j2) {
                                        c3958e.m7915w(iM7902j3);
                                        if (!z13) {
                                        }
                                        zM7333j = true;
                                    }
                                    if (!c3958e.f13378w) {
                                    }
                                }
                            } else if (c3958e.f13347X == 8) {
                                interfaceC4028c4 = interfaceC4028c3;
                                arrayList2 = arrayList;
                                i27 = size2;
                            } else {
                                iM7905m3 = c3958e.m7905m();
                                iM7902j2 = c3958e.m7902j();
                                arrayList2 = arrayList;
                                int i412 = c3958e.f13341R;
                                i27 = size2;
                                zM7333j |= c3621k3.m7333j(interfaceC4028c3, c3958e, true);
                                iM7905m4 = c3958e.m7905m();
                                interfaceC4028c4 = interfaceC4028c3;
                                iM7902j3 = c3958e.m7902j();
                                if (iM7905m4 != iM7905m3) {
                                    c3958e.m7918z(iM7905m4);
                                    if (!z12) {
                                    }
                                    zM7333j = true;
                                }
                                if (iM7902j3 != iM7902j2) {
                                    c3958e.m7915w(iM7902j3);
                                    if (!z13) {
                                    }
                                    zM7333j = true;
                                }
                                if (!c3958e.f13378w) {
                                }
                            }
                            i26++;
                            arrayList = arrayList2;
                            size2 = i27;
                            interfaceC4028c3 = interfaceC4028c4;
                        }
                        InterfaceC4028c interfaceC4028c9 = interfaceC4028c3;
                        ArrayList arrayList7 = arrayList;
                        int i413 = size2;
                        if (zM7333j) {
                            c3621k3.m7335l(c3959f, i20, i21);
                            zM7333j = false;
                        }
                        i25++;
                        interfaceC4028c3 = interfaceC4028c9;
                        arrayList = arrayList7;
                        size2 = i413;
                    }
                    c3959f3 = c3959f;
                    if (zM7333j) {
                        c3621k3.m7335l(c3959f3, i20, i21);
                        if (c3959f.m7905m() < iMax3) {
                            c3959f3.m7918z(iMax3);
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (c3959f.m7902j() < iMax4) {
                            c3959f3.m7915w(iMax4);
                            z14 = true;
                        }
                        if (z14) {
                            c3621k3.m7335l(c3959f3, i20, i21);
                        }
                    }
                } else {
                    i22 = i19;
                    c3959f3 = c3959f2;
                }
                i23 = i22;
                c3959f3.f13394s0 = i23;
                if ((i23 & 256) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                C3882e.f13030p = z11;
            }
            if (childCount2 == 0) {
                iMax2 = Math.max(0, this.f1304e);
            } else {
                iMax2 = i39;
            }
            enumC3957d = enumC3957d8;
            enumC3957d2 = enumC3957d;
            iM7905m = c3959f.m7905m();
            c4031f = c3959f.f13384i0;
            if (iMax == iM7905m) {
                c4031f.f13657c = true;
            } else {
                c4031f.f13657c = true;
            }
            c3959f.f13339P = 0;
            c3959f.f13340Q = 0;
            int i414 = this.f1305f - i41;
            int[] iArr4 = c3959f.f13376u;
            iArr4[0] = i414;
            iArr4[1] = this.f1306g - i40;
            c3959f.f13342S = 0;
            c3959f.f13343T = 0;
            c3959f.m7916x(enumC3957d8);
            c3959f.m7918z(iMax);
            c3959f.m7917y(enumC3957d);
            c3959f.m7915w(iMax2);
            i12 = this.f1303d - i41;
            if (i12 < 0) {
                c3959f.f13342S = 0;
            } else {
                c3959f.f13342S = i12;
            }
            i13 = this.f1304e - i40;
            if (i13 < 0) {
                c3959f.f13343T = 0;
            } else {
                c3959f.f13343T = i13;
            }
            c3959f.f13388m0 = iMax7;
            c3959f.f13389n0 = iMax5;
            c3621k = c3959f.f13383h0;
            c3621k.getClass();
            interfaceC4028c = c3959f.f13385j0;
            size = c3959f.f13382g0.size();
            iM7905m2 = c3959f.m7905m();
            iM7902j = c3959f.m7902j();
            if ((i6 & 128) == 128) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                z10 = true;
            } else {
                z10 = true;
            }
            enumC3957d3 = EnumC3957d.f13321c;
            if (z10) {
                i36 = 0;
                while (true) {
                    if (i36 < size) {
                        c3958e7 = (C3958e) c3959f.f13382g0.get(i36);
                        enumC3957dArr2 = c3958e7.f13333J;
                        if (enumC3957dArr2[0] == enumC3957d3) {
                            z21 = true;
                        } else {
                            z21 = false;
                        }
                        if (enumC3957dArr2[1] == enumC3957d3) {
                            z22 = true;
                        } else {
                            z22 = false;
                        }
                        if (z21) {
                            z23 = false;
                        } else {
                            z23 = false;
                        }
                        if (!c3958e7.m7910r()) {
                        }
                        i14 = 1073741824;
                        z10 = false;
                    } else {
                        i14 = 1073741824;
                    }
                }
            } else {
                i14 = 1073741824;
            }
            if (((mode != i14 && mode2 == i14) || z7) && z10) {
                iMin = Math.min(c3959f.f13376u[0], i38);
                iMin2 = Math.min(c3959f.f13376u[1], i39);
                if (mode == 1073741824) {
                    c3959f.m7918z(iMin);
                    c3959f.f13384i0.f13656b = true;
                }
                if (mode2 == 1073741824) {
                    c3959f.m7915w(iMin2);
                    c3959f.f13384i0.f13656b = true;
                }
                if (mode == 1073741824) {
                    c3621k2 = c3621k;
                    interfaceC4028c2 = interfaceC4028c;
                    i15 = size;
                    i16 = iM7905m2;
                    enumC3957d5 = enumC3957d3;
                    enumC3957d6 = enumC3957d2;
                    i31 = mode2;
                    i17 = iM7902j;
                    enumC3957d4 = enumC3957d8;
                    z16 = c4031f.f13656b;
                    c3959f4 = c4031f.f13655a;
                    if (z16) {
                        while (r1.hasNext()) {
                            c3958e8.f13350a = false;
                            C4036k c4036k12 = c3958e8.f13356d;
                            c4036k12.f13685e.f13672j = false;
                            c4036k12.f13687g = false;
                            c4036k12.m8034n();
                            C4038m c4038m12 = c3958e8.f13358e;
                            c4038m12.f13685e.f13672j = false;
                            c4038m12.f13687g = false;
                            c4038m12.m8037m();
                        }
                        i32 = 0;
                        c3959f4.f13350a = false;
                        C4036k c4036k13 = c3959f4.f13356d;
                        c4036k13.f13685e.f13672j = false;
                        c4036k13.f13687g = false;
                        c4036k13.m8034n();
                        C4038m c4038m13 = c3959f4.f13358e;
                        c4038m13.f13685e.f13672j = false;
                        c4038m13.f13687g = false;
                        c4038m13.m8037m();
                        c4031f.m8023c();
                    } else {
                        i32 = 0;
                    }
                    c4031f.m8022b(c4031f.f13658d);
                    c3959f4.f13339P = i32;
                    c3959f4.f13340Q = i32;
                    c3959f4.f13356d.f13688h.mo8030d(i32);
                    c3959f4.f13358e.f13688h.mo8030d(i32);
                    i33 = mode;
                    i34 = 1073741824;
                    c3959f2 = c3959f;
                    if (i33 == 1073741824) {
                        zM7921E = c3959f2.m7921E(i32, z7);
                        i18 = 1;
                    } else {
                        i18 = 0;
                        zM7921E = true;
                    }
                    if (i31 == 1073741824) {
                        zM7921E &= c3959f2.m7921E(1, z7);
                        i18++;
                    }
                } else {
                    c3621k2 = c3621k;
                    interfaceC4028c2 = interfaceC4028c;
                    i15 = size;
                    i16 = iM7905m2;
                    enumC3957d5 = enumC3957d3;
                    enumC3957d6 = enumC3957d2;
                    i31 = mode2;
                    i17 = iM7902j;
                    enumC3957d4 = enumC3957d8;
                    z16 = c4031f.f13656b;
                    c3959f4 = c4031f.f13655a;
                    if (z16) {
                        while (r1.hasNext()) {
                            c3958e8.f13350a = false;
                            C4036k c4036k14 = c3958e8.f13356d;
                            c4036k14.f13685e.f13672j = false;
                            c4036k14.f13687g = false;
                            c4036k14.m8034n();
                            C4038m c4038m14 = c3958e8.f13358e;
                            c4038m14.f13685e.f13672j = false;
                            c4038m14.f13687g = false;
                            c4038m14.m8037m();
                        }
                        i32 = 0;
                        c3959f4.f13350a = false;
                        C4036k c4036k15 = c3959f4.f13356d;
                        c4036k15.f13685e.f13672j = false;
                        c4036k15.f13687g = false;
                        c4036k15.m8034n();
                        C4038m c4038m15 = c3959f4.f13358e;
                        c4038m15.f13685e.f13672j = false;
                        c4038m15.f13687g = false;
                        c4038m15.m8037m();
                        c4031f.m8023c();
                    } else {
                        i32 = 0;
                    }
                    c4031f.m8022b(c4031f.f13658d);
                    c3959f4.f13339P = i32;
                    c3959f4.f13340Q = i32;
                    c3959f4.f13356d.f13688h.mo8030d(i32);
                    c3959f4.f13358e.f13688h.mo8030d(i32);
                    i33 = mode;
                    i34 = 1073741824;
                    c3959f2 = c3959f;
                    if (i33 == 1073741824) {
                        zM7921E = c3959f2.m7921E(i32, z7);
                        i18 = 1;
                    } else {
                        i18 = 0;
                        zM7921E = true;
                    }
                    if (i31 == 1073741824) {
                        zM7921E &= c3959f2.m7921E(1, z7);
                        i18++;
                    }
                }
                if (zM7921E) {
                    if (i33 == i34) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (i31 == i34) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    c3959f2.mo7894A(z17, z18);
                }
            } else {
                enumC3957d4 = enumC3957d8;
                c3959f2 = c3959f;
                c3621k2 = c3621k;
                interfaceC4028c2 = interfaceC4028c;
                i15 = size;
                i16 = iM7905m2;
                i17 = iM7902j;
                enumC3957d5 = enumC3957d3;
                enumC3957d6 = enumC3957d2;
                i18 = 0;
                zM7921E = false;
            }
            if (zM7921E) {
            }
            if (i15 > 0) {
                size3 = c3959f2.f13382g0.size();
                interfaceC4028c6 = c3959f2.f13385j0;
                i28 = 0;
                while (i28 < size3) {
                    c3958e6 = (C3958e) c3959f2.f13382g0.get(i28);
                    if (c3958e6 instanceof C3962i) {
                        c3621k4 = c3621k2;
                        enumC3957d7 = enumC3957d5;
                    } else {
                        enumC3957dM7901i = c3958e6.m7901i(0);
                        EnumC3957d enumC3957dM7901i7 = c3958e6.m7901i(1);
                        enumC3957d7 = enumC3957d5;
                        if (enumC3957dM7901i == enumC3957d7) {
                            c3621k4 = c3621k2;
                            c3621k4.m7333j(interfaceC4028c6, c3958e6, false);
                        } else {
                            c3621k4 = c3621k2;
                            c3621k4.m7333j(interfaceC4028c6, c3958e6, false);
                        }
                    }
                    i28++;
                    c3621k2 = c3621k4;
                    enumC3957d5 = enumC3957d7;
                }
                c3621k3 = c3621k2;
                constraintLayout = ((C0306b) interfaceC4028c6).f1399a;
                childCount = constraintLayout.getChildCount();
                while (i29 < childCount) {
                    childAt = constraintLayout.getChildAt(i29);
                    if (childAt instanceof Placeholder) {
                        placeholder = (Placeholder) childAt;
                        if (placeholder.f1394b == null) {
                            LayoutParams layoutParams5 = (LayoutParams) placeholder.getLayoutParams();
                            layoutParams = (LayoutParams) placeholder.f1394b.getLayoutParams();
                            c3958e3 = layoutParams.f1364l0;
                            c3958e3.f13347X = 0;
                            c3958e4 = layoutParams5.f1364l0;
                            if (c3958e4.f13333J[0] != enumC3957d4) {
                                c3958e4.m7918z(c3958e3.m7905m());
                            }
                            c3958e5 = layoutParams5.f1364l0;
                            if (c3958e5.f13333J[1] != enumC3957d4) {
                                c3958e5.m7915w(layoutParams.f1364l0.m7902j());
                            }
                            layoutParams.f1364l0.f13347X = 8;
                        }
                    }
                }
                arrayList3 = constraintLayout.f1301b;
                size4 = arrayList3.size();
                if (size4 > 0) {
                    while (i30 < size4) {
                        ((ConstraintHelper) arrayList3.get(i30)).getClass();
                    }
                }
            } else {
                c3621k3 = c3621k2;
            }
            i19 = c3959f2.f13394s0;
            arrayList = (ArrayList) c3621k3.f12170b;
            size2 = arrayList.size();
            i20 = i16;
            i21 = i17;
            if (i15 > 0) {
                c3621k3.m7335l(c3959f2, i20, i21);
            }
            if (size2 > 0) {
                enumC3957dArr = c3959f2.f13333J;
                if (enumC3957dArr[0] == enumC3957d6) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (enumC3957dArr[1] == enumC3957d6) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                int iM7905m11 = c3959f.m7905m();
                C3959f c3959f9 = (C3959f) c3621k3.f12172d;
                iMax3 = Math.max(iM7905m11, c3959f9.f13342S);
                iMax4 = Math.max(c3959f.m7902j(), c3959f9.f13343T);
                i24 = 0;
                zM7333j = false;
                while (i24 < size2) {
                    c3958e2 = (C3958e) arrayList.get(i24);
                    if (c3958e2 instanceof C3961h) {
                        interfaceC4028c5 = interfaceC4028c2;
                    } else {
                        iM7905m5 = c3958e2.m7905m();
                        iM7902j4 = c3958e2.m7902j();
                        interfaceC4028c5 = interfaceC4028c2;
                        boolean zM7333j5 = zM7333j | c3621k3.m7333j(interfaceC4028c5, c3958e2, true);
                        iM7905m6 = c3958e2.m7905m();
                        z15 = zM7333j5;
                        iM7902j5 = c3958e2.m7902j();
                        if (iM7905m6 != iM7905m5) {
                            c3958e2.m7918z(iM7905m6);
                            if (z12) {
                                iMax3 = Math.max(iMax3, c3958e2.mo7900h(4).m7887c() + c3958e2.m7906n() + c3958e2.f13335L);
                            }
                            z15 = true;
                        }
                        if (iM7902j5 != iM7902j4) {
                            c3958e2.m7915w(iM7902j5);
                            if (z13) {
                                iMax4 = Math.max(iMax4, c3958e2.mo7900h(5).m7887c() + c3958e2.m7907o() + c3958e2.f13336M);
                            }
                            z15 = true;
                        }
                        zM7333j = z15 | ((C3961h) c3958e2).f13439o0;
                    }
                    i24++;
                    interfaceC4028c2 = interfaceC4028c5;
                    i19 = i19;
                }
                i22 = i19;
                interfaceC4028c3 = interfaceC4028c2;
                i25 = 0;
                while (i25 < 2) {
                    i26 = 0;
                    while (i26 < size2) {
                        c3958e = (C3958e) arrayList.get(i26);
                        if (c3958e instanceof C3963j) {
                            if (c3958e.f13347X == 8) {
                                interfaceC4028c4 = interfaceC4028c3;
                                arrayList2 = arrayList;
                                i27 = size2;
                            } else {
                                iM7905m3 = c3958e.m7905m();
                                iM7902j2 = c3958e.m7902j();
                                arrayList2 = arrayList;
                                int i415 = c3958e.f13341R;
                                i27 = size2;
                                zM7333j |= c3621k3.m7333j(interfaceC4028c3, c3958e, true);
                                iM7905m4 = c3958e.m7905m();
                                interfaceC4028c4 = interfaceC4028c3;
                                iM7902j3 = c3958e.m7902j();
                                if (iM7905m4 != iM7905m3) {
                                    c3958e.m7918z(iM7905m4);
                                    if (!z12) {
                                    }
                                    zM7333j = true;
                                }
                                if (iM7902j3 != iM7902j2) {
                                    c3958e.m7915w(iM7902j3);
                                    if (!z13) {
                                    }
                                    zM7333j = true;
                                }
                                if (!c3958e.f13378w) {
                                }
                            }
                        } else if (c3958e.f13347X == 8) {
                            interfaceC4028c4 = interfaceC4028c3;
                            arrayList2 = arrayList;
                            i27 = size2;
                        } else {
                            iM7905m3 = c3958e.m7905m();
                            iM7902j2 = c3958e.m7902j();
                            arrayList2 = arrayList;
                            int i416 = c3958e.f13341R;
                            i27 = size2;
                            zM7333j |= c3621k3.m7333j(interfaceC4028c3, c3958e, true);
                            iM7905m4 = c3958e.m7905m();
                            interfaceC4028c4 = interfaceC4028c3;
                            iM7902j3 = c3958e.m7902j();
                            if (iM7905m4 != iM7905m3) {
                                c3958e.m7918z(iM7905m4);
                                if (!z12) {
                                }
                                zM7333j = true;
                            }
                            if (iM7902j3 != iM7902j2) {
                                c3958e.m7915w(iM7902j3);
                                if (!z13) {
                                }
                                zM7333j = true;
                            }
                            if (!c3958e.f13378w) {
                            }
                        }
                        i26++;
                        arrayList = arrayList2;
                        size2 = i27;
                        interfaceC4028c3 = interfaceC4028c4;
                    }
                    InterfaceC4028c interfaceC4028c10 = interfaceC4028c3;
                    ArrayList arrayList8 = arrayList;
                    int i417 = size2;
                    if (zM7333j) {
                        c3621k3.m7335l(c3959f, i20, i21);
                        zM7333j = false;
                    }
                    i25++;
                    interfaceC4028c3 = interfaceC4028c10;
                    arrayList = arrayList8;
                    size2 = i417;
                }
                c3959f3 = c3959f;
                if (zM7333j) {
                    c3621k3.m7335l(c3959f3, i20, i21);
                    if (c3959f.m7905m() < iMax3) {
                        c3959f3.m7918z(iMax3);
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (c3959f.m7902j() < iMax4) {
                        c3959f3.m7915w(iMax4);
                        z14 = true;
                    }
                    if (z14) {
                        c3621k3.m7335l(c3959f3, i20, i21);
                    }
                }
            } else {
                i22 = i19;
                c3959f3 = c3959f2;
            }
            i23 = i22;
            c3959f3.f13394s0 = i23;
            if ((i23 & 256) == 256) {
                z11 = true;
            } else {
                z11 = false;
            }
            C3882e.f13030p = z11;
        }
        iMax = childCount2 == 0 ? Math.max(0, this.f1303d) : i38;
        i42 = Integer.MIN_VALUE;
        if (mode2 != i42) {
            if (mode2 != 0) {
                if (mode2 != 1073741824) {
                    enumC3957d = enumC3957d8;
                    enumC3957d2 = enumC3957d8;
                    iMax2 = 0;
                } else {
                    iMax2 = Math.min(this.f1306g - i40, i39);
                    enumC3957d2 = enumC3957d8;
                    enumC3957d = enumC3957d8;
                }
            } else if (childCount2 == 0) {
                enumC3957d = enumC3957d8;
                enumC3957d2 = enumC3957d;
                iMax2 = Math.max(0, this.f1304e);
            } else {
                iMax2 = 0;
            }
            iM7905m = c3959f.m7905m();
            c4031f = c3959f.f13384i0;
            if (iMax == iM7905m) {
                c4031f.f13657c = true;
            } else {
                c4031f.f13657c = true;
            }
            c3959f.f13339P = 0;
            c3959f.f13340Q = 0;
            int i418 = this.f1305f - i41;
            int[] iArr5 = c3959f.f13376u;
            iArr5[0] = i418;
            iArr5[1] = this.f1306g - i40;
            c3959f.f13342S = 0;
            c3959f.f13343T = 0;
            c3959f.m7916x(enumC3957d8);
            c3959f.m7918z(iMax);
            c3959f.m7917y(enumC3957d);
            c3959f.m7915w(iMax2);
            i12 = this.f1303d - i41;
            if (i12 < 0) {
                c3959f.f13342S = 0;
            } else {
                c3959f.f13342S = i12;
            }
            i13 = this.f1304e - i40;
            if (i13 < 0) {
                c3959f.f13343T = 0;
            } else {
                c3959f.f13343T = i13;
            }
            c3959f.f13388m0 = iMax7;
            c3959f.f13389n0 = iMax5;
            c3621k = c3959f.f13383h0;
            c3621k.getClass();
            interfaceC4028c = c3959f.f13385j0;
            size = c3959f.f13382g0.size();
            iM7905m2 = c3959f.m7905m();
            iM7902j = c3959f.m7902j();
            if ((i6 & 128) == 128) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                z10 = true;
            } else {
                z10 = true;
            }
            enumC3957d3 = EnumC3957d.f13321c;
            if (z10) {
                i36 = 0;
                while (true) {
                    if (i36 < size) {
                        c3958e7 = (C3958e) c3959f.f13382g0.get(i36);
                        enumC3957dArr2 = c3958e7.f13333J;
                        if (enumC3957dArr2[0] == enumC3957d3) {
                            z21 = true;
                        } else {
                            z21 = false;
                        }
                        if (enumC3957dArr2[1] == enumC3957d3) {
                            z22 = true;
                        } else {
                            z22 = false;
                        }
                        if (z21) {
                            z23 = false;
                        } else {
                            z23 = false;
                        }
                        if (!c3958e7.m7910r()) {
                        }
                        i14 = 1073741824;
                        z10 = false;
                    } else {
                        i14 = 1073741824;
                    }
                }
            } else {
                i14 = 1073741824;
            }
            if (((mode != i14 && mode2 == i14) || z7) && z10) {
                iMin = Math.min(c3959f.f13376u[0], i38);
                iMin2 = Math.min(c3959f.f13376u[1], i39);
                if (mode == 1073741824) {
                    c3959f.m7918z(iMin);
                    c3959f.f13384i0.f13656b = true;
                }
                if (mode2 == 1073741824) {
                    c3959f.m7915w(iMin2);
                    c3959f.f13384i0.f13656b = true;
                }
                if (mode == 1073741824) {
                    c3621k2 = c3621k;
                    interfaceC4028c2 = interfaceC4028c;
                    i15 = size;
                    i16 = iM7905m2;
                    enumC3957d5 = enumC3957d3;
                    enumC3957d6 = enumC3957d2;
                    i31 = mode2;
                    i17 = iM7902j;
                    enumC3957d4 = enumC3957d8;
                    z16 = c4031f.f13656b;
                    c3959f4 = c4031f.f13655a;
                    if (z16) {
                        while (r1.hasNext()) {
                            c3958e8.f13350a = false;
                            C4036k c4036k16 = c3958e8.f13356d;
                            c4036k16.f13685e.f13672j = false;
                            c4036k16.f13687g = false;
                            c4036k16.m8034n();
                            C4038m c4038m16 = c3958e8.f13358e;
                            c4038m16.f13685e.f13672j = false;
                            c4038m16.f13687g = false;
                            c4038m16.m8037m();
                        }
                        i32 = 0;
                        c3959f4.f13350a = false;
                        C4036k c4036k17 = c3959f4.f13356d;
                        c4036k17.f13685e.f13672j = false;
                        c4036k17.f13687g = false;
                        c4036k17.m8034n();
                        C4038m c4038m17 = c3959f4.f13358e;
                        c4038m17.f13685e.f13672j = false;
                        c4038m17.f13687g = false;
                        c4038m17.m8037m();
                        c4031f.m8023c();
                    } else {
                        i32 = 0;
                    }
                    c4031f.m8022b(c4031f.f13658d);
                    c3959f4.f13339P = i32;
                    c3959f4.f13340Q = i32;
                    c3959f4.f13356d.f13688h.mo8030d(i32);
                    c3959f4.f13358e.f13688h.mo8030d(i32);
                    i33 = mode;
                    i34 = 1073741824;
                    c3959f2 = c3959f;
                    if (i33 == 1073741824) {
                        zM7921E = c3959f2.m7921E(i32, z7);
                        i18 = 1;
                    } else {
                        i18 = 0;
                        zM7921E = true;
                    }
                    if (i31 == 1073741824) {
                        zM7921E &= c3959f2.m7921E(1, z7);
                        i18++;
                    }
                } else {
                    c3621k2 = c3621k;
                    interfaceC4028c2 = interfaceC4028c;
                    i15 = size;
                    i16 = iM7905m2;
                    enumC3957d5 = enumC3957d3;
                    enumC3957d6 = enumC3957d2;
                    i31 = mode2;
                    i17 = iM7902j;
                    enumC3957d4 = enumC3957d8;
                    z16 = c4031f.f13656b;
                    c3959f4 = c4031f.f13655a;
                    if (z16) {
                        while (r1.hasNext()) {
                            c3958e8.f13350a = false;
                            C4036k c4036k18 = c3958e8.f13356d;
                            c4036k18.f13685e.f13672j = false;
                            c4036k18.f13687g = false;
                            c4036k18.m8034n();
                            C4038m c4038m18 = c3958e8.f13358e;
                            c4038m18.f13685e.f13672j = false;
                            c4038m18.f13687g = false;
                            c4038m18.m8037m();
                        }
                        i32 = 0;
                        c3959f4.f13350a = false;
                        C4036k c4036k19 = c3959f4.f13356d;
                        c4036k19.f13685e.f13672j = false;
                        c4036k19.f13687g = false;
                        c4036k19.m8034n();
                        C4038m c4038m19 = c3959f4.f13358e;
                        c4038m19.f13685e.f13672j = false;
                        c4038m19.f13687g = false;
                        c4038m19.m8037m();
                        c4031f.m8023c();
                    } else {
                        i32 = 0;
                    }
                    c4031f.m8022b(c4031f.f13658d);
                    c3959f4.f13339P = i32;
                    c3959f4.f13340Q = i32;
                    c3959f4.f13356d.f13688h.mo8030d(i32);
                    c3959f4.f13358e.f13688h.mo8030d(i32);
                    i33 = mode;
                    i34 = 1073741824;
                    c3959f2 = c3959f;
                    if (i33 == 1073741824) {
                        zM7921E = c3959f2.m7921E(i32, z7);
                        i18 = 1;
                    } else {
                        i18 = 0;
                        zM7921E = true;
                    }
                    if (i31 == 1073741824) {
                        zM7921E &= c3959f2.m7921E(1, z7);
                        i18++;
                    }
                }
                if (zM7921E) {
                    if (i33 == i34) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (i31 == i34) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    c3959f2.mo7894A(z17, z18);
                }
            } else {
                enumC3957d4 = enumC3957d8;
                c3959f2 = c3959f;
                c3621k2 = c3621k;
                interfaceC4028c2 = interfaceC4028c;
                i15 = size;
                i16 = iM7905m2;
                i17 = iM7902j;
                enumC3957d5 = enumC3957d3;
                enumC3957d6 = enumC3957d2;
                i18 = 0;
                zM7921E = false;
            }
            if (zM7921E) {
            }
            if (i15 > 0) {
                size3 = c3959f2.f13382g0.size();
                interfaceC4028c6 = c3959f2.f13385j0;
                i28 = 0;
                while (i28 < size3) {
                    c3958e6 = (C3958e) c3959f2.f13382g0.get(i28);
                    if (c3958e6 instanceof C3962i) {
                        c3621k4 = c3621k2;
                        enumC3957d7 = enumC3957d5;
                    } else {
                        enumC3957dM7901i = c3958e6.m7901i(0);
                        EnumC3957d enumC3957dM7901i8 = c3958e6.m7901i(1);
                        enumC3957d7 = enumC3957d5;
                        if (enumC3957dM7901i == enumC3957d7) {
                            c3621k4 = c3621k2;
                            c3621k4.m7333j(interfaceC4028c6, c3958e6, false);
                        } else {
                            c3621k4 = c3621k2;
                            c3621k4.m7333j(interfaceC4028c6, c3958e6, false);
                        }
                    }
                    i28++;
                    c3621k2 = c3621k4;
                    enumC3957d5 = enumC3957d7;
                }
                c3621k3 = c3621k2;
                constraintLayout = ((C0306b) interfaceC4028c6).f1399a;
                childCount = constraintLayout.getChildCount();
                while (i29 < childCount) {
                    childAt = constraintLayout.getChildAt(i29);
                    if (childAt instanceof Placeholder) {
                        placeholder = (Placeholder) childAt;
                        if (placeholder.f1394b == null) {
                            LayoutParams layoutParams6 = (LayoutParams) placeholder.getLayoutParams();
                            layoutParams = (LayoutParams) placeholder.f1394b.getLayoutParams();
                            c3958e3 = layoutParams.f1364l0;
                            c3958e3.f13347X = 0;
                            c3958e4 = layoutParams6.f1364l0;
                            if (c3958e4.f13333J[0] != enumC3957d4) {
                                c3958e4.m7918z(c3958e3.m7905m());
                            }
                            c3958e5 = layoutParams6.f1364l0;
                            if (c3958e5.f13333J[1] != enumC3957d4) {
                                c3958e5.m7915w(layoutParams.f1364l0.m7902j());
                            }
                            layoutParams.f1364l0.f13347X = 8;
                        }
                    }
                }
                arrayList3 = constraintLayout.f1301b;
                size4 = arrayList3.size();
                if (size4 > 0) {
                    while (i30 < size4) {
                        ((ConstraintHelper) arrayList3.get(i30)).getClass();
                    }
                }
            } else {
                c3621k3 = c3621k2;
            }
            i19 = c3959f2.f13394s0;
            arrayList = (ArrayList) c3621k3.f12170b;
            size2 = arrayList.size();
            i20 = i16;
            i21 = i17;
            if (i15 > 0) {
                c3621k3.m7335l(c3959f2, i20, i21);
            }
            if (size2 > 0) {
                enumC3957dArr = c3959f2.f13333J;
                if (enumC3957dArr[0] == enumC3957d6) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (enumC3957dArr[1] == enumC3957d6) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                int iM7905m12 = c3959f.m7905m();
                C3959f c3959f10 = (C3959f) c3621k3.f12172d;
                iMax3 = Math.max(iM7905m12, c3959f10.f13342S);
                iMax4 = Math.max(c3959f.m7902j(), c3959f10.f13343T);
                i24 = 0;
                zM7333j = false;
                while (i24 < size2) {
                    c3958e2 = (C3958e) arrayList.get(i24);
                    if (c3958e2 instanceof C3961h) {
                        interfaceC4028c5 = interfaceC4028c2;
                    } else {
                        iM7905m5 = c3958e2.m7905m();
                        iM7902j4 = c3958e2.m7902j();
                        interfaceC4028c5 = interfaceC4028c2;
                        boolean zM7333j6 = zM7333j | c3621k3.m7333j(interfaceC4028c5, c3958e2, true);
                        iM7905m6 = c3958e2.m7905m();
                        z15 = zM7333j6;
                        iM7902j5 = c3958e2.m7902j();
                        if (iM7905m6 != iM7905m5) {
                            c3958e2.m7918z(iM7905m6);
                            if (z12) {
                                iMax3 = Math.max(iMax3, c3958e2.mo7900h(4).m7887c() + c3958e2.m7906n() + c3958e2.f13335L);
                            }
                            z15 = true;
                        }
                        if (iM7902j5 != iM7902j4) {
                            c3958e2.m7915w(iM7902j5);
                            if (z13) {
                                iMax4 = Math.max(iMax4, c3958e2.mo7900h(5).m7887c() + c3958e2.m7907o() + c3958e2.f13336M);
                            }
                            z15 = true;
                        }
                        zM7333j = z15 | ((C3961h) c3958e2).f13439o0;
                    }
                    i24++;
                    interfaceC4028c2 = interfaceC4028c5;
                    i19 = i19;
                }
                i22 = i19;
                interfaceC4028c3 = interfaceC4028c2;
                i25 = 0;
                while (i25 < 2) {
                    i26 = 0;
                    while (i26 < size2) {
                        c3958e = (C3958e) arrayList.get(i26);
                        if (c3958e instanceof C3963j) {
                            if (c3958e.f13347X == 8) {
                                interfaceC4028c4 = interfaceC4028c3;
                                arrayList2 = arrayList;
                                i27 = size2;
                            } else {
                                iM7905m3 = c3958e.m7905m();
                                iM7902j2 = c3958e.m7902j();
                                arrayList2 = arrayList;
                                int i419 = c3958e.f13341R;
                                i27 = size2;
                                zM7333j |= c3621k3.m7333j(interfaceC4028c3, c3958e, true);
                                iM7905m4 = c3958e.m7905m();
                                interfaceC4028c4 = interfaceC4028c3;
                                iM7902j3 = c3958e.m7902j();
                                if (iM7905m4 != iM7905m3) {
                                    c3958e.m7918z(iM7905m4);
                                    if (!z12) {
                                    }
                                    zM7333j = true;
                                }
                                if (iM7902j3 != iM7902j2) {
                                    c3958e.m7915w(iM7902j3);
                                    if (!z13) {
                                    }
                                    zM7333j = true;
                                }
                                if (!c3958e.f13378w) {
                                }
                            }
                        } else if (c3958e.f13347X == 8) {
                            interfaceC4028c4 = interfaceC4028c3;
                            arrayList2 = arrayList;
                            i27 = size2;
                        } else {
                            iM7905m3 = c3958e.m7905m();
                            iM7902j2 = c3958e.m7902j();
                            arrayList2 = arrayList;
                            int i4110 = c3958e.f13341R;
                            i27 = size2;
                            zM7333j |= c3621k3.m7333j(interfaceC4028c3, c3958e, true);
                            iM7905m4 = c3958e.m7905m();
                            interfaceC4028c4 = interfaceC4028c3;
                            iM7902j3 = c3958e.m7902j();
                            if (iM7905m4 != iM7905m3) {
                                c3958e.m7918z(iM7905m4);
                                if (!z12) {
                                }
                                zM7333j = true;
                            }
                            if (iM7902j3 != iM7902j2) {
                                c3958e.m7915w(iM7902j3);
                                if (!z13) {
                                }
                                zM7333j = true;
                            }
                            if (!c3958e.f13378w) {
                            }
                        }
                        i26++;
                        arrayList = arrayList2;
                        size2 = i27;
                        interfaceC4028c3 = interfaceC4028c4;
                    }
                    InterfaceC4028c interfaceC4028c11 = interfaceC4028c3;
                    ArrayList arrayList9 = arrayList;
                    int i4111 = size2;
                    if (zM7333j) {
                        c3621k3.m7335l(c3959f, i20, i21);
                        zM7333j = false;
                    }
                    i25++;
                    interfaceC4028c3 = interfaceC4028c11;
                    arrayList = arrayList9;
                    size2 = i4111;
                }
                c3959f3 = c3959f;
                if (zM7333j) {
                    c3621k3.m7335l(c3959f3, i20, i21);
                    if (c3959f.m7905m() < iMax3) {
                        c3959f3.m7918z(iMax3);
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (c3959f.m7902j() < iMax4) {
                        c3959f3.m7915w(iMax4);
                        z14 = true;
                    }
                    if (z14) {
                        c3621k3.m7335l(c3959f3, i20, i21);
                    }
                }
            } else {
                i22 = i19;
                c3959f3 = c3959f2;
            }
            i23 = i22;
            c3959f3.f13394s0 = i23;
            if ((i23 & 256) == 256) {
                z11 = true;
            } else {
                z11 = false;
            }
            C3882e.f13030p = z11;
        }
        if (childCount2 == 0) {
            iMax2 = Math.max(0, this.f1304e);
        } else {
            iMax2 = i39;
        }
        enumC3957d = enumC3957d8;
        enumC3957d2 = enumC3957d;
        iM7905m = c3959f.m7905m();
        c4031f = c3959f.f13384i0;
        if (iMax == iM7905m) {
            c4031f.f13657c = true;
        } else {
            c4031f.f13657c = true;
        }
        c3959f.f13339P = 0;
        c3959f.f13340Q = 0;
        int i4112 = this.f1305f - i41;
        int[] iArr6 = c3959f.f13376u;
        iArr6[0] = i4112;
        iArr6[1] = this.f1306g - i40;
        c3959f.f13342S = 0;
        c3959f.f13343T = 0;
        c3959f.m7916x(enumC3957d8);
        c3959f.m7918z(iMax);
        c3959f.m7917y(enumC3957d);
        c3959f.m7915w(iMax2);
        i12 = this.f1303d - i41;
        if (i12 < 0) {
            c3959f.f13342S = 0;
        } else {
            c3959f.f13342S = i12;
        }
        i13 = this.f1304e - i40;
        if (i13 < 0) {
            c3959f.f13343T = 0;
        } else {
            c3959f.f13343T = i13;
        }
        c3959f.f13388m0 = iMax7;
        c3959f.f13389n0 = iMax5;
        c3621k = c3959f.f13383h0;
        c3621k.getClass();
        interfaceC4028c = c3959f.f13385j0;
        size = c3959f.f13382g0.size();
        iM7905m2 = c3959f.m7905m();
        iM7902j = c3959f.m7902j();
        if ((i6 & 128) == 128) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            z10 = true;
        } else {
            z10 = true;
        }
        enumC3957d3 = EnumC3957d.f13321c;
        if (z10) {
            i36 = 0;
            while (true) {
                if (i36 < size) {
                    c3958e7 = (C3958e) c3959f.f13382g0.get(i36);
                    enumC3957dArr2 = c3958e7.f13333J;
                    if (enumC3957dArr2[0] == enumC3957d3) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    if (enumC3957dArr2[1] == enumC3957d3) {
                        z22 = true;
                    } else {
                        z22 = false;
                    }
                    if (z21) {
                        z23 = false;
                    } else {
                        z23 = false;
                    }
                    if (!c3958e7.m7910r()) {
                    }
                    i14 = 1073741824;
                    z10 = false;
                } else {
                    i14 = 1073741824;
                }
            }
        } else {
            i14 = 1073741824;
        }
        if (((mode != i14 && mode2 == i14) || z7) && z10) {
            iMin = Math.min(c3959f.f13376u[0], i38);
            iMin2 = Math.min(c3959f.f13376u[1], i39);
            if (mode == 1073741824) {
                c3959f.m7918z(iMin);
                c3959f.f13384i0.f13656b = true;
            }
            if (mode2 == 1073741824) {
                c3959f.m7915w(iMin2);
                c3959f.f13384i0.f13656b = true;
            }
            if (mode == 1073741824) {
                c3621k2 = c3621k;
                interfaceC4028c2 = interfaceC4028c;
                i15 = size;
                i16 = iM7905m2;
                enumC3957d5 = enumC3957d3;
                enumC3957d6 = enumC3957d2;
                i31 = mode2;
                i17 = iM7902j;
                enumC3957d4 = enumC3957d8;
                z16 = c4031f.f13656b;
                c3959f4 = c4031f.f13655a;
                if (z16) {
                    while (r1.hasNext()) {
                        c3958e8.f13350a = false;
                        C4036k c4036k110 = c3958e8.f13356d;
                        c4036k110.f13685e.f13672j = false;
                        c4036k110.f13687g = false;
                        c4036k110.m8034n();
                        C4038m c4038m110 = c3958e8.f13358e;
                        c4038m110.f13685e.f13672j = false;
                        c4038m110.f13687g = false;
                        c4038m110.m8037m();
                    }
                    i32 = 0;
                    c3959f4.f13350a = false;
                    C4036k c4036k111 = c3959f4.f13356d;
                    c4036k111.f13685e.f13672j = false;
                    c4036k111.f13687g = false;
                    c4036k111.m8034n();
                    C4038m c4038m111 = c3959f4.f13358e;
                    c4038m111.f13685e.f13672j = false;
                    c4038m111.f13687g = false;
                    c4038m111.m8037m();
                    c4031f.m8023c();
                } else {
                    i32 = 0;
                }
                c4031f.m8022b(c4031f.f13658d);
                c3959f4.f13339P = i32;
                c3959f4.f13340Q = i32;
                c3959f4.f13356d.f13688h.mo8030d(i32);
                c3959f4.f13358e.f13688h.mo8030d(i32);
                i33 = mode;
                i34 = 1073741824;
                c3959f2 = c3959f;
                if (i33 == 1073741824) {
                    zM7921E = c3959f2.m7921E(i32, z7);
                    i18 = 1;
                } else {
                    i18 = 0;
                    zM7921E = true;
                }
                if (i31 == 1073741824) {
                    zM7921E &= c3959f2.m7921E(1, z7);
                    i18++;
                }
            } else {
                c3621k2 = c3621k;
                interfaceC4028c2 = interfaceC4028c;
                i15 = size;
                i16 = iM7905m2;
                enumC3957d5 = enumC3957d3;
                enumC3957d6 = enumC3957d2;
                i31 = mode2;
                i17 = iM7902j;
                enumC3957d4 = enumC3957d8;
                z16 = c4031f.f13656b;
                c3959f4 = c4031f.f13655a;
                if (z16) {
                    while (r1.hasNext()) {
                        c3958e8.f13350a = false;
                        C4036k c4036k112 = c3958e8.f13356d;
                        c4036k112.f13685e.f13672j = false;
                        c4036k112.f13687g = false;
                        c4036k112.m8034n();
                        C4038m c4038m112 = c3958e8.f13358e;
                        c4038m112.f13685e.f13672j = false;
                        c4038m112.f13687g = false;
                        c4038m112.m8037m();
                    }
                    i32 = 0;
                    c3959f4.f13350a = false;
                    C4036k c4036k113 = c3959f4.f13356d;
                    c4036k113.f13685e.f13672j = false;
                    c4036k113.f13687g = false;
                    c4036k113.m8034n();
                    C4038m c4038m113 = c3959f4.f13358e;
                    c4038m113.f13685e.f13672j = false;
                    c4038m113.f13687g = false;
                    c4038m113.m8037m();
                    c4031f.m8023c();
                } else {
                    i32 = 0;
                }
                c4031f.m8022b(c4031f.f13658d);
                c3959f4.f13339P = i32;
                c3959f4.f13340Q = i32;
                c3959f4.f13356d.f13688h.mo8030d(i32);
                c3959f4.f13358e.f13688h.mo8030d(i32);
                i33 = mode;
                i34 = 1073741824;
                c3959f2 = c3959f;
                if (i33 == 1073741824) {
                    zM7921E = c3959f2.m7921E(i32, z7);
                    i18 = 1;
                } else {
                    i18 = 0;
                    zM7921E = true;
                }
                if (i31 == 1073741824) {
                    zM7921E &= c3959f2.m7921E(1, z7);
                    i18++;
                }
            }
            if (zM7921E) {
                if (i33 == i34) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (i31 == i34) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                c3959f2.mo7894A(z17, z18);
            }
        } else {
            enumC3957d4 = enumC3957d8;
            c3959f2 = c3959f;
            c3621k2 = c3621k;
            interfaceC4028c2 = interfaceC4028c;
            i15 = size;
            i16 = iM7905m2;
            i17 = iM7902j;
            enumC3957d5 = enumC3957d3;
            enumC3957d6 = enumC3957d2;
            i18 = 0;
            zM7921E = false;
        }
        if (zM7921E) {
        }
        if (i15 > 0) {
            size3 = c3959f2.f13382g0.size();
            interfaceC4028c6 = c3959f2.f13385j0;
            i28 = 0;
            while (i28 < size3) {
                c3958e6 = (C3958e) c3959f2.f13382g0.get(i28);
                if (c3958e6 instanceof C3962i) {
                    c3621k4 = c3621k2;
                    enumC3957d7 = enumC3957d5;
                } else {
                    enumC3957dM7901i = c3958e6.m7901i(0);
                    EnumC3957d enumC3957dM7901i9 = c3958e6.m7901i(1);
                    enumC3957d7 = enumC3957d5;
                    if (enumC3957dM7901i == enumC3957d7) {
                        c3621k4 = c3621k2;
                        c3621k4.m7333j(interfaceC4028c6, c3958e6, false);
                    } else {
                        c3621k4 = c3621k2;
                        c3621k4.m7333j(interfaceC4028c6, c3958e6, false);
                    }
                }
                i28++;
                c3621k2 = c3621k4;
                enumC3957d5 = enumC3957d7;
            }
            c3621k3 = c3621k2;
            constraintLayout = ((C0306b) interfaceC4028c6).f1399a;
            childCount = constraintLayout.getChildCount();
            while (i29 < childCount) {
                childAt = constraintLayout.getChildAt(i29);
                if (childAt instanceof Placeholder) {
                    placeholder = (Placeholder) childAt;
                    if (placeholder.f1394b == null) {
                        LayoutParams layoutParams7 = (LayoutParams) placeholder.getLayoutParams();
                        layoutParams = (LayoutParams) placeholder.f1394b.getLayoutParams();
                        c3958e3 = layoutParams.f1364l0;
                        c3958e3.f13347X = 0;
                        c3958e4 = layoutParams7.f1364l0;
                        if (c3958e4.f13333J[0] != enumC3957d4) {
                            c3958e4.m7918z(c3958e3.m7905m());
                        }
                        c3958e5 = layoutParams7.f1364l0;
                        if (c3958e5.f13333J[1] != enumC3957d4) {
                            c3958e5.m7915w(layoutParams.f1364l0.m7902j());
                        }
                        layoutParams.f1364l0.f13347X = 8;
                    }
                }
            }
            arrayList3 = constraintLayout.f1301b;
            size4 = arrayList3.size();
            if (size4 > 0) {
                while (i30 < size4) {
                    ((ConstraintHelper) arrayList3.get(i30)).getClass();
                }
            }
        } else {
            c3621k3 = c3621k2;
        }
        i19 = c3959f2.f13394s0;
        arrayList = (ArrayList) c3621k3.f12170b;
        size2 = arrayList.size();
        i20 = i16;
        i21 = i17;
        if (i15 > 0) {
            c3621k3.m7335l(c3959f2, i20, i21);
        }
        if (size2 > 0) {
            enumC3957dArr = c3959f2.f13333J;
            if (enumC3957dArr[0] == enumC3957d6) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (enumC3957dArr[1] == enumC3957d6) {
                z13 = true;
            } else {
                z13 = false;
            }
            int iM7905m13 = c3959f.m7905m();
            C3959f c3959f11 = (C3959f) c3621k3.f12172d;
            iMax3 = Math.max(iM7905m13, c3959f11.f13342S);
            iMax4 = Math.max(c3959f.m7902j(), c3959f11.f13343T);
            i24 = 0;
            zM7333j = false;
            while (i24 < size2) {
                c3958e2 = (C3958e) arrayList.get(i24);
                if (c3958e2 instanceof C3961h) {
                    interfaceC4028c5 = interfaceC4028c2;
                } else {
                    iM7905m5 = c3958e2.m7905m();
                    iM7902j4 = c3958e2.m7902j();
                    interfaceC4028c5 = interfaceC4028c2;
                    boolean zM7333j7 = zM7333j | c3621k3.m7333j(interfaceC4028c5, c3958e2, true);
                    iM7905m6 = c3958e2.m7905m();
                    z15 = zM7333j7;
                    iM7902j5 = c3958e2.m7902j();
                    if (iM7905m6 != iM7905m5) {
                        c3958e2.m7918z(iM7905m6);
                        if (z12) {
                            iMax3 = Math.max(iMax3, c3958e2.mo7900h(4).m7887c() + c3958e2.m7906n() + c3958e2.f13335L);
                        }
                        z15 = true;
                    }
                    if (iM7902j5 != iM7902j4) {
                        c3958e2.m7915w(iM7902j5);
                        if (z13) {
                            iMax4 = Math.max(iMax4, c3958e2.mo7900h(5).m7887c() + c3958e2.m7907o() + c3958e2.f13336M);
                        }
                        z15 = true;
                    }
                    zM7333j = z15 | ((C3961h) c3958e2).f13439o0;
                }
                i24++;
                interfaceC4028c2 = interfaceC4028c5;
                i19 = i19;
            }
            i22 = i19;
            interfaceC4028c3 = interfaceC4028c2;
            i25 = 0;
            while (i25 < 2) {
                i26 = 0;
                while (i26 < size2) {
                    c3958e = (C3958e) arrayList.get(i26);
                    if (c3958e instanceof C3963j) {
                        if (c3958e.f13347X == 8) {
                            interfaceC4028c4 = interfaceC4028c3;
                            arrayList2 = arrayList;
                            i27 = size2;
                        } else {
                            iM7905m3 = c3958e.m7905m();
                            iM7902j2 = c3958e.m7902j();
                            arrayList2 = arrayList;
                            int i4113 = c3958e.f13341R;
                            i27 = size2;
                            zM7333j |= c3621k3.m7333j(interfaceC4028c3, c3958e, true);
                            iM7905m4 = c3958e.m7905m();
                            interfaceC4028c4 = interfaceC4028c3;
                            iM7902j3 = c3958e.m7902j();
                            if (iM7905m4 != iM7905m3) {
                                c3958e.m7918z(iM7905m4);
                                if (!z12) {
                                }
                                zM7333j = true;
                            }
                            if (iM7902j3 != iM7902j2) {
                                c3958e.m7915w(iM7902j3);
                                if (!z13) {
                                }
                                zM7333j = true;
                            }
                            if (!c3958e.f13378w) {
                            }
                        }
                    } else if (c3958e.f13347X == 8) {
                        interfaceC4028c4 = interfaceC4028c3;
                        arrayList2 = arrayList;
                        i27 = size2;
                    } else {
                        iM7905m3 = c3958e.m7905m();
                        iM7902j2 = c3958e.m7902j();
                        arrayList2 = arrayList;
                        int i4114 = c3958e.f13341R;
                        i27 = size2;
                        zM7333j |= c3621k3.m7333j(interfaceC4028c3, c3958e, true);
                        iM7905m4 = c3958e.m7905m();
                        interfaceC4028c4 = interfaceC4028c3;
                        iM7902j3 = c3958e.m7902j();
                        if (iM7905m4 != iM7905m3) {
                            c3958e.m7918z(iM7905m4);
                            if (!z12) {
                            }
                            zM7333j = true;
                        }
                        if (iM7902j3 != iM7902j2) {
                            c3958e.m7915w(iM7902j3);
                            if (!z13) {
                            }
                            zM7333j = true;
                        }
                        if (!c3958e.f13378w) {
                        }
                    }
                    i26++;
                    arrayList = arrayList2;
                    size2 = i27;
                    interfaceC4028c3 = interfaceC4028c4;
                }
                InterfaceC4028c interfaceC4028c12 = interfaceC4028c3;
                ArrayList arrayList10 = arrayList;
                int i4115 = size2;
                if (zM7333j) {
                    c3621k3.m7335l(c3959f, i20, i21);
                    zM7333j = false;
                }
                i25++;
                interfaceC4028c3 = interfaceC4028c12;
                arrayList = arrayList10;
                size2 = i4115;
            }
            c3959f3 = c3959f;
            if (zM7333j) {
                c3621k3.m7335l(c3959f3, i20, i21);
                if (c3959f.m7905m() < iMax3) {
                    c3959f3.m7918z(iMax3);
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (c3959f.m7902j() < iMax4) {
                    c3959f3.m7915w(iMax4);
                    z14 = true;
                }
                if (z14) {
                    c3621k3.m7335l(c3959f3, i20, i21);
                }
            }
        } else {
            i22 = i19;
            c3959f3 = c3959f2;
        }
        i23 = i22;
        c3959f3.f13394s0 = i23;
        if ((i23 & 256) == 256) {
            z11 = true;
        } else {
            z11 = false;
        }
        C3882e.f13030p = z11;
    }

    @Override
    public void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            C3958e c3958e = layoutParams.f1364l0;
            if ((childAt.getVisibility() != 8 || layoutParams.f1339Y || layoutParams.f1340Z || zIsInEditMode) && !layoutParams.f1342a0) {
                int iM7906n = c3958e.m7906n();
                int iM7907o = c3958e.m7907o();
                int iM7905m = c3958e.m7905m() + iM7906n;
                int iM7902j = c3958e.m7902j() + iM7907o;
                childAt.layout(iM7906n, iM7907o, iM7905m, iM7902j);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iM7906n, iM7907o, iM7905m, iM7902j);
                }
            }
        }
        ArrayList arrayList = this.f1301b;
        int size = arrayList.size();
        if (size > 0) {
            for (int i14 = 0; i14 < size; i14++) {
                ((ConstraintHelper) arrayList.get(i14)).mo845j();
            }
        }
    }

    @Override
    public void onMeasure(int i6, int i10) {
        boolean z7;
        C3958e c3958e;
        boolean zM881k = m881k();
        C3959f c3959f = this.f1302c;
        c3959f.f13386k0 = zM881k;
        if (this.f1307h) {
            int i11 = 0;
            this.f1307h = false;
            int childCount = getChildCount();
            int i12 = 0;
            while (true) {
                if (i12 >= childCount) {
                    z7 = false;
                    break;
                } else {
                    if (getChildAt(i12).isLayoutRequested()) {
                        z7 = true;
                        break;
                    }
                    i12++;
                }
            }
            if (z7) {
                boolean zIsInEditMode = isInEditMode();
                int childCount2 = getChildCount();
                for (int i13 = 0; i13 < childCount2; i13++) {
                    C3958e c3958eM879e = m879e(getChildAt(i13));
                    if (c3958eM879e != null) {
                        c3958eM879e.mo7912t();
                    }
                }
                Object obj = null;
                if (zIsInEditMode) {
                    for (int i14 = 0; i14 < childCount2; i14++) {
                        View childAt = getChildAt(i14);
                        try {
                            String resourceName = getResources().getResourceName(childAt.getId());
                            Integer numValueOf = Integer.valueOf(childAt.getId());
                            if (resourceName instanceof String) {
                                if (this.f1312m == null) {
                                    this.f1312m = new HashMap();
                                }
                                int iIndexOf = resourceName.indexOf("/");
                                this.f1312m.put(iIndexOf != -1 ? resourceName.substring(iIndexOf + 1) : resourceName, numValueOf);
                            }
                            int iIndexOf2 = resourceName.indexOf(47);
                            if (iIndexOf2 != -1) {
                                resourceName = resourceName.substring(iIndexOf2 + 1);
                            }
                            int id = childAt.getId();
                            if (id != 0) {
                                View viewFindViewById = (View) this.f1300a.get(id);
                                if (viewFindViewById == null && (viewFindViewById = findViewById(id)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
                                    onViewAdded(viewFindViewById);
                                }
                                c3958e = viewFindViewById == this ? c3959f : viewFindViewById == null ? null : ((LayoutParams) viewFindViewById.getLayoutParams()).f1364l0;
                            }
                            c3958e.f13348Y = resourceName;
                        } catch (Resources.NotFoundException unused) {
                        }
                    }
                }
                if (this.f1311l != -1) {
                    for (int i15 = 0; i15 < childCount2; i15++) {
                        View childAt2 = getChildAt(i15);
                        if (childAt2.getId() == this.f1311l && (childAt2 instanceof Constraints)) {
                            this.f1309j = ((Constraints) childAt2).getConstraintSet();
                        }
                    }
                }
                C0308d c0308d = this.f1309j;
                if (c0308d != null) {
                    c0308d.m895c(this);
                }
                c3959f.f13382g0.clear();
                ArrayList arrayList = this.f1301b;
                int size = arrayList.size();
                if (size > 0) {
                    int i16 = 0;
                    while (i16 < size) {
                        ConstraintHelper constraintHelper = (ConstraintHelper) arrayList.get(i16);
                        if (constraintHelper.isInEditMode()) {
                            constraintHelper.setIds(constraintHelper.f1296e);
                        }
                        C3963j c3963j = constraintHelper.f1295d;
                        if (c3963j != null) {
                            c3963j.f13457h0 = i11;
                            Arrays.fill(c3963j.f13456g0, obj);
                            for (int i17 = 0; i17 < constraintHelper.f1293b; i17++) {
                                int i18 = constraintHelper.f1292a[i17];
                                View viewM878d = m878d(i18);
                                if (viewM878d == null) {
                                    Integer numValueOf2 = Integer.valueOf(i18);
                                    HashMap map = constraintHelper.f1298g;
                                    String str = (String) map.get(numValueOf2);
                                    int iM873d = constraintHelper.m873d(this, str);
                                    if (iM873d != 0) {
                                        constraintHelper.f1292a[i17] = iM873d;
                                        map.put(Integer.valueOf(iM873d), str);
                                        viewM878d = m878d(iM873d);
                                    }
                                }
                                if (viewM878d != null) {
                                    constraintHelper.f1295d.m7935C(m879e(viewM878d));
                                }
                            }
                            constraintHelper.f1295d.mo7930D();
                        }
                        i16++;
                        i11 = 0;
                        obj = null;
                    }
                }
                for (int i19 = 0; i19 < childCount2; i19++) {
                    View childAt3 = getChildAt(i19);
                    if (childAt3 instanceof Placeholder) {
                        Placeholder placeholder = (Placeholder) childAt3;
                        if (placeholder.f1393a == -1 && !placeholder.isInEditMode()) {
                            placeholder.setVisibility(placeholder.f1395c);
                        }
                        View viewFindViewById2 = findViewById(placeholder.f1393a);
                        placeholder.f1394b = viewFindViewById2;
                        if (viewFindViewById2 != null) {
                            ((LayoutParams) viewFindViewById2.getLayoutParams()).f1342a0 = true;
                            placeholder.f1394b.setVisibility(0);
                            placeholder.setVisibility(0);
                        }
                    }
                }
                SparseArray sparseArray = this.f1313n;
                sparseArray.clear();
                sparseArray.put(0, c3959f);
                sparseArray.put(getId(), c3959f);
                for (int i20 = 0; i20 < childCount2; i20++) {
                    View childAt4 = getChildAt(i20);
                    sparseArray.put(childAt4.getId(), m879e(childAt4));
                }
                for (int i21 = 0; i21 < childCount2; i21++) {
                    View childAt5 = getChildAt(i21);
                    C3958e c3958eM879e2 = m879e(childAt5);
                    if (c3958eM879e2 != null) {
                        LayoutParams layoutParams = (LayoutParams) childAt5.getLayoutParams();
                        c3959f.f13382g0.add(c3958eM879e2);
                        C3958e c3958e2 = c3958eM879e2.f13334K;
                        if (c3958e2 != null) {
                            ((C3959f) c3958e2).f13382g0.remove(c3958eM879e2);
                            c3958eM879e2.f13334K = null;
                        }
                        c3958eM879e2.f13334K = c3959f;
                        m877c(zIsInEditMode, childAt5, c3958eM879e2, layoutParams, sparseArray);
                    }
                }
            }
            if (z7) {
                c3959f.m7923G();
            }
        }
        m883n(c3959f, this.f1308i, i6, i10);
        m882m(i6, i10, c3959f.m7905m(), c3959f.m7902j(), c3959f.f13395t0, c3959f.f13396u0);
    }

    @Override
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        C3958e c3958eM879e = m879e(view);
        if ((view instanceof Guideline) && !(c3958eM879e instanceof C3962i)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            C3962i c3962i = new C3962i();
            layoutParams.f1364l0 = c3962i;
            layoutParams.f1339Y = true;
            c3962i.m7934C(layoutParams.f1332R);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.m876l();
            ((LayoutParams) view.getLayoutParams()).f1340Z = true;
            ArrayList arrayList = this.f1301b;
            if (!arrayList.contains(constraintHelper)) {
                arrayList.add(constraintHelper);
            }
        }
        this.f1300a.put(view.getId(), view);
        this.f1307h = true;
    }

    @Override
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f1300a.remove(view.getId());
        C3958e c3958eM879e = m879e(view);
        this.f1302c.f13382g0.remove(c3958eM879e);
        c3958eM879e.f13334K = null;
        this.f1301b.remove(view);
        this.f1307h = true;
    }

    @Override
    public void requestLayout() {
        this.f1307h = true;
        super.requestLayout();
    }

    public void setConstraintSet(C0308d c0308d) {
        this.f1309j = c0308d;
    }

    @Override
    public void setId(int i6) {
        int id = getId();
        SparseArray sparseArray = this.f1300a;
        sparseArray.remove(id);
        super.setId(i6);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i6) {
        if (i6 == this.f1306g) {
            return;
        }
        this.f1306g = i6;
        requestLayout();
    }

    public void setMaxWidth(int i6) {
        if (i6 == this.f1305f) {
            return;
        }
        this.f1305f = i6;
        requestLayout();
    }

    public void setMinHeight(int i6) {
        if (i6 == this.f1304e) {
            return;
        }
        this.f1304e = i6;
        requestLayout();
    }

    public void setMinWidth(int i6) {
        if (i6 == this.f1303d) {
            return;
        }
        this.f1303d = i6;
        requestLayout();
    }

    public void setOnConstraintsChanged(AbstractC4191h abstractC4191h) {
        C3112e c3112e = this.f1310k;
        if (c3112e != null) {
            c3112e.getClass();
        }
    }

    public void setOptimizationLevel(int i6) {
        this.f1308i = i6;
        this.f1302c.f13394s0 = i6;
        C3882e.f13030p = (i6 & 256) == 256;
    }

    @Override
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1300a = new SparseArray();
        this.f1301b = new ArrayList(4);
        this.f1302c = new C3959f();
        this.f1303d = 0;
        this.f1304e = 0;
        this.f1305f = Integer.MAX_VALUE;
        this.f1306g = Integer.MAX_VALUE;
        this.f1307h = true;
        this.f1308i = 263;
        this.f1309j = null;
        this.f1310k = null;
        this.f1311l = -1;
        this.f1312m = new HashMap();
        this.f1313n = new SparseArray();
        this.f1314o = new C0306b(this);
        m880h(attributeSet, i6);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        public float f1315A;

        public String f1316B;

        public final int f1317C;

        public float f1318D;

        public float f1319E;

        public int f1320F;

        public int f1321G;

        public int f1322H;

        public int f1323I;

        public int f1324J;

        public int f1325K;

        public int f1326L;

        public int f1327M;

        public float f1328N;

        public float f1329O;

        public int f1330P;

        public int f1331Q;

        public int f1332R;

        public boolean f1333S;

        public boolean f1334T;

        public String f1335U;

        public boolean f1336V;

        public boolean f1337W;

        public boolean f1338X;

        public boolean f1339Y;

        public boolean f1340Z;

        public int f1341a;

        public boolean f1342a0;

        public int f1343b;

        public int f1344b0;

        public float f1345c;

        public int f1346c0;

        public int f1347d;

        public int f1348d0;

        public int f1349e;

        public int f1350e0;

        public int f1351f;

        public int f1352f0;

        public int f1353g;

        public int f1354g0;

        public int f1355h;

        public float f1356h0;

        public int f1357i;

        public int f1358i0;

        public int f1359j;

        public int f1360j0;

        public int f1361k;

        public float f1362k0;

        public int f1363l;

        public C3958e f1364l0;

        public int f1365m;

        public int f1366n;

        public float f1367o;

        public int f1368p;

        public int f1369q;

        public int f1370r;

        public int f1371s;

        public final int f1372t;

        public int f1373u;

        public final int f1374v;

        public int f1375w;

        public int f1376x;

        public int f1377y;

        public float f1378z;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            int i6;
            super(context, attributeSet);
            this.f1341a = -1;
            this.f1343b = -1;
            this.f1345c = -1.0f;
            this.f1347d = -1;
            this.f1349e = -1;
            this.f1351f = -1;
            this.f1353g = -1;
            this.f1355h = -1;
            this.f1357i = -1;
            this.f1359j = -1;
            this.f1361k = -1;
            this.f1363l = -1;
            this.f1365m = -1;
            this.f1366n = 0;
            this.f1367o = 0.0f;
            this.f1368p = -1;
            this.f1369q = -1;
            this.f1370r = -1;
            this.f1371s = -1;
            this.f1372t = -1;
            this.f1373u = -1;
            this.f1374v = -1;
            this.f1375w = -1;
            this.f1376x = -1;
            this.f1377y = -1;
            this.f1378z = 0.5f;
            this.f1315A = 0.5f;
            this.f1316B = null;
            this.f1317C = 1;
            this.f1318D = -1.0f;
            this.f1319E = -1.0f;
            this.f1320F = 0;
            this.f1321G = 0;
            this.f1322H = 0;
            this.f1323I = 0;
            this.f1324J = 0;
            this.f1325K = 0;
            this.f1326L = 0;
            this.f1327M = 0;
            this.f1328N = 1.0f;
            this.f1329O = 1.0f;
            this.f1330P = -1;
            this.f1331Q = -1;
            this.f1332R = -1;
            this.f1333S = false;
            this.f1334T = false;
            this.f1335U = null;
            this.f1336V = true;
            this.f1337W = true;
            this.f1338X = false;
            this.f1339Y = false;
            this.f1340Z = false;
            this.f1342a0 = false;
            this.f1344b0 = -1;
            this.f1346c0 = -1;
            this.f1348d0 = -1;
            this.f1350e0 = -1;
            this.f1352f0 = -1;
            this.f1354g0 = -1;
            this.f1356h0 = 0.5f;
            this.f1364l0 = new C3958e();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4193j.f14236b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                int i11 = AbstractC0305a.f1398a.get(index);
                switch (i11) {
                    case 1:
                        this.f1332R = typedArrayObtainStyledAttributes.getInt(index, this.f1332R);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f1365m);
                        this.f1365m = resourceId;
                        if (resourceId == -1) {
                            this.f1365m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 3:
                        this.f1366n = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1366n);
                        break;
                    case 4:
                        float f = typedArrayObtainStyledAttributes.getFloat(index, this.f1367o) % 360.0f;
                        this.f1367o = f;
                        if (f < 0.0f) {
                            this.f1367o = (360.0f - f) % 360.0f;
                        }
                        break;
                    case 5:
                        this.f1341a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1341a);
                        break;
                    case 6:
                        this.f1343b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1343b);
                        break;
                    case 7:
                        this.f1345c = typedArrayObtainStyledAttributes.getFloat(index, this.f1345c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1347d);
                        this.f1347d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f1347d = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1349e);
                        this.f1349e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f1349e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1351f);
                        this.f1351f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f1351f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1353g);
                        this.f1353g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f1353g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1355h);
                        this.f1355h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f1355h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1357i);
                        this.f1357i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f1357i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1359j);
                        this.f1359j = resourceId8;
                        if (resourceId8 == -1) {
                            this.f1359j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1361k);
                        this.f1361k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f1361k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1363l);
                        this.f1363l = resourceId10;
                        if (resourceId10 == -1) {
                            this.f1363l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1368p);
                        this.f1368p = resourceId11;
                        if (resourceId11 == -1) {
                            this.f1368p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1369q);
                        this.f1369q = resourceId12;
                        if (resourceId12 == -1) {
                            this.f1369q = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1370r);
                        this.f1370r = resourceId13;
                        if (resourceId13 == -1) {
                            this.f1370r = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1371s);
                        this.f1371s = resourceId14;
                        if (resourceId14 == -1) {
                            this.f1371s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 21:
                        this.f1372t = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1372t);
                        break;
                    case 22:
                        this.f1373u = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1373u);
                        break;
                    case 23:
                        this.f1374v = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1374v);
                        break;
                    case 24:
                        this.f1375w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1375w);
                        break;
                    case 25:
                        this.f1376x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1376x);
                        break;
                    case 26:
                        this.f1377y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1377y);
                        break;
                    case 27:
                        this.f1333S = typedArrayObtainStyledAttributes.getBoolean(index, this.f1333S);
                        break;
                    case 28:
                        this.f1334T = typedArrayObtainStyledAttributes.getBoolean(index, this.f1334T);
                        break;
                    case 29:
                        this.f1378z = typedArrayObtainStyledAttributes.getFloat(index, this.f1378z);
                        break;
                    case 30:
                        this.f1315A = typedArrayObtainStyledAttributes.getFloat(index, this.f1315A);
                        break;
                    case 31:
                        int i12 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f1322H = i12;
                        if (i12 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        }
                        break;
                    case 32:
                        int i13 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f1323I = i13;
                        if (i13 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        }
                        break;
                    case 33:
                        try {
                            this.f1324J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1324J);
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f1324J) == -2) {
                                this.f1324J = -2;
                            }
                        }
                        break;
                    case 34:
                        try {
                            this.f1326L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1326L);
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f1326L) == -2) {
                                this.f1326L = -2;
                            }
                        }
                        break;
                    case 35:
                        this.f1328N = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f1328N));
                        this.f1322H = 2;
                        break;
                    case TsExtractor.TS_STREAM_TYPE_H265:
                        try {
                            this.f1325K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1325K);
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f1325K) == -2) {
                                this.f1325K = -2;
                            }
                        }
                        break;
                    case 37:
                        try {
                            this.f1327M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1327M);
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f1327M) == -2) {
                                this.f1327M = -2;
                            }
                        }
                        break;
                    case FlacConstants.STREAM_INFO_BLOCK_SIZE:
                        this.f1329O = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f1329O));
                        this.f1323I = 2;
                        break;
                    default:
                        switch (i11) {
                            case 44:
                                String string = typedArrayObtainStyledAttributes.getString(index);
                                this.f1316B = string;
                                this.f1317C = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int iIndexOf = this.f1316B.indexOf(44);
                                    if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                        i6 = 0;
                                    } else {
                                        String strSubstring = this.f1316B.substring(0, iIndexOf);
                                        if (strSubstring.equalsIgnoreCase("W")) {
                                            this.f1317C = 0;
                                        } else if (strSubstring.equalsIgnoreCase("H")) {
                                            this.f1317C = 1;
                                        }
                                        i6 = iIndexOf + 1;
                                    }
                                    int iIndexOf2 = this.f1316B.indexOf(58);
                                    if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                                        String strSubstring2 = this.f1316B.substring(i6);
                                        if (strSubstring2.length() > 0) {
                                            Float.parseFloat(strSubstring2);
                                        }
                                    } else {
                                        String strSubstring3 = this.f1316B.substring(i6, iIndexOf2);
                                        String strSubstring4 = this.f1316B.substring(iIndexOf2 + 1);
                                        if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                                            try {
                                                float f3 = Float.parseFloat(strSubstring3);
                                                float f4 = Float.parseFloat(strSubstring4);
                                                if (f3 > 0.0f && f4 > 0.0f) {
                                                    if (this.f1317C == 1) {
                                                        Math.abs(f4 / f3);
                                                    } else {
                                                        Math.abs(f3 / f4);
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                            }
                                        }
                                    }
                                }
                                break;
                            case TsExtractor.TS_STREAM_TYPE_MHAS:
                                this.f1318D = typedArrayObtainStyledAttributes.getFloat(index, this.f1318D);
                                break;
                            case 46:
                                this.f1319E = typedArrayObtainStyledAttributes.getFloat(index, this.f1319E);
                                break;
                            case 47:
                                this.f1320F = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case NalUnitUtil.H265_NAL_UNIT_TYPE_UNSPECIFIED:
                                this.f1321G = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case Opcodes.V1_5:
                                this.f1330P = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1330P);
                                break;
                            case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                                this.f1331Q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1331Q);
                                break;
                            case 51:
                                this.f1335U = typedArrayObtainStyledAttributes.getString(index);
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            m884a();
        }

        public final void m884a() {
            this.f1339Y = false;
            this.f1336V = true;
            this.f1337W = true;
            int i6 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i6 == -2 && this.f1333S) {
                this.f1336V = false;
                if (this.f1322H == 0) {
                    this.f1322H = 1;
                }
            }
            int i10 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i10 == -2 && this.f1334T) {
                this.f1337W = false;
                if (this.f1323I == 0) {
                    this.f1323I = 1;
                }
            }
            if (i6 == 0 || i6 == -1) {
                this.f1336V = false;
                if (i6 == 0 && this.f1322H == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f1333S = true;
                }
            }
            if (i10 == 0 || i10 == -1) {
                this.f1337W = false;
                if (i10 == 0 && this.f1323I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f1334T = true;
                }
            }
            if (this.f1345c == -1.0f && this.f1341a == -1 && this.f1343b == -1) {
                return;
            }
            this.f1339Y = true;
            this.f1336V = true;
            this.f1337W = true;
            if (!(this.f1364l0 instanceof C3962i)) {
                this.f1364l0 = new C3962i();
            }
            ((C3962i) this.f1364l0).m7934C(this.f1332R);
        }

        @Override
        public final void resolveLayoutDirection(int i6) {
            int i10;
            int i11;
            int i12;
            int i13;
            int i14 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i15 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i6);
            boolean z7 = false;
            boolean z10 = 1 == getLayoutDirection();
            this.f1348d0 = -1;
            this.f1350e0 = -1;
            this.f1344b0 = -1;
            this.f1346c0 = -1;
            this.f1352f0 = this.f1372t;
            this.f1354g0 = this.f1374v;
            float f = this.f1378z;
            this.f1356h0 = f;
            int i16 = this.f1341a;
            this.f1358i0 = i16;
            int i17 = this.f1343b;
            this.f1360j0 = i17;
            float f3 = this.f1345c;
            this.f1362k0 = f3;
            if (z10) {
                int i18 = this.f1368p;
                if (i18 != -1) {
                    this.f1348d0 = i18;
                } else {
                    int i19 = this.f1369q;
                    if (i19 != -1) {
                        this.f1350e0 = i19;
                    } else {
                        i10 = this.f1370r;
                        if (i10 != -1) {
                            this.f1346c0 = i10;
                            z7 = true;
                        }
                        i11 = this.f1371s;
                        if (i11 != -1) {
                            this.f1344b0 = i11;
                            z7 = true;
                        }
                        i12 = this.f1376x;
                        if (i12 != -1) {
                            this.f1354g0 = i12;
                        }
                        i13 = this.f1377y;
                        if (i13 != -1) {
                            this.f1352f0 = i13;
                        }
                        if (z7) {
                            this.f1356h0 = 1.0f - f;
                        }
                        if (this.f1339Y && this.f1332R == 1) {
                            if (f3 != -1.0f) {
                                this.f1362k0 = 1.0f - f3;
                                this.f1358i0 = -1;
                                this.f1360j0 = -1;
                            } else if (i16 != -1) {
                                this.f1360j0 = i16;
                                this.f1358i0 = -1;
                                this.f1362k0 = -1.0f;
                            } else if (i17 != -1) {
                                this.f1358i0 = i17;
                                this.f1360j0 = -1;
                                this.f1362k0 = -1.0f;
                            }
                        }
                    }
                }
                z7 = true;
                i10 = this.f1370r;
                if (i10 != -1) {
                    this.f1346c0 = i10;
                    z7 = true;
                }
                i11 = this.f1371s;
                if (i11 != -1) {
                    this.f1344b0 = i11;
                    z7 = true;
                }
                i12 = this.f1376x;
                if (i12 != -1) {
                    this.f1354g0 = i12;
                }
                i13 = this.f1377y;
                if (i13 != -1) {
                    this.f1352f0 = i13;
                }
                if (z7) {
                    this.f1356h0 = 1.0f - f;
                }
                if (this.f1339Y) {
                    if (f3 != -1.0f) {
                        this.f1362k0 = 1.0f - f3;
                        this.f1358i0 = -1;
                        this.f1360j0 = -1;
                    } else if (i16 != -1) {
                        this.f1360j0 = i16;
                        this.f1358i0 = -1;
                        this.f1362k0 = -1.0f;
                    } else if (i17 != -1) {
                        this.f1358i0 = i17;
                        this.f1360j0 = -1;
                        this.f1362k0 = -1.0f;
                    }
                }
            } else {
                int i20 = this.f1368p;
                if (i20 != -1) {
                    this.f1346c0 = i20;
                }
                int i21 = this.f1369q;
                if (i21 != -1) {
                    this.f1344b0 = i21;
                }
                int i22 = this.f1370r;
                if (i22 != -1) {
                    this.f1348d0 = i22;
                }
                int i23 = this.f1371s;
                if (i23 != -1) {
                    this.f1350e0 = i23;
                }
                int i24 = this.f1376x;
                if (i24 != -1) {
                    this.f1352f0 = i24;
                }
                int i25 = this.f1377y;
                if (i25 != -1) {
                    this.f1354g0 = i25;
                }
            }
            if (this.f1370r == -1 && this.f1371s == -1 && this.f1369q == -1 && this.f1368p == -1) {
                int i26 = this.f1351f;
                if (i26 != -1) {
                    this.f1348d0 = i26;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i15 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i15;
                    }
                } else {
                    int i27 = this.f1353g;
                    if (i27 != -1) {
                        this.f1350e0 = i27;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i15 > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = i15;
                        }
                    }
                }
                int i28 = this.f1347d;
                if (i28 != -1) {
                    this.f1344b0 = i28;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i14 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i14;
                    return;
                }
                int i29 = this.f1349e;
                if (i29 != -1) {
                    this.f1346c0 = i29;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i14 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i14;
                }
            }
        }

        public LayoutParams() {
            super(-2, -2);
            this.f1341a = -1;
            this.f1343b = -1;
            this.f1345c = -1.0f;
            this.f1347d = -1;
            this.f1349e = -1;
            this.f1351f = -1;
            this.f1353g = -1;
            this.f1355h = -1;
            this.f1357i = -1;
            this.f1359j = -1;
            this.f1361k = -1;
            this.f1363l = -1;
            this.f1365m = -1;
            this.f1366n = 0;
            this.f1367o = 0.0f;
            this.f1368p = -1;
            this.f1369q = -1;
            this.f1370r = -1;
            this.f1371s = -1;
            this.f1372t = -1;
            this.f1373u = -1;
            this.f1374v = -1;
            this.f1375w = -1;
            this.f1376x = -1;
            this.f1377y = -1;
            this.f1378z = 0.5f;
            this.f1315A = 0.5f;
            this.f1316B = null;
            this.f1317C = 1;
            this.f1318D = -1.0f;
            this.f1319E = -1.0f;
            this.f1320F = 0;
            this.f1321G = 0;
            this.f1322H = 0;
            this.f1323I = 0;
            this.f1324J = 0;
            this.f1325K = 0;
            this.f1326L = 0;
            this.f1327M = 0;
            this.f1328N = 1.0f;
            this.f1329O = 1.0f;
            this.f1330P = -1;
            this.f1331Q = -1;
            this.f1332R = -1;
            this.f1333S = false;
            this.f1334T = false;
            this.f1335U = null;
            this.f1336V = true;
            this.f1337W = true;
            this.f1338X = false;
            this.f1339Y = false;
            this.f1340Z = false;
            this.f1342a0 = false;
            this.f1344b0 = -1;
            this.f1346c0 = -1;
            this.f1348d0 = -1;
            this.f1350e0 = -1;
            this.f1352f0 = -1;
            this.f1354g0 = -1;
            this.f1356h0 = 0.5f;
            this.f1364l0 = new C3958e();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1341a = -1;
            this.f1343b = -1;
            this.f1345c = -1.0f;
            this.f1347d = -1;
            this.f1349e = -1;
            this.f1351f = -1;
            this.f1353g = -1;
            this.f1355h = -1;
            this.f1357i = -1;
            this.f1359j = -1;
            this.f1361k = -1;
            this.f1363l = -1;
            this.f1365m = -1;
            this.f1366n = 0;
            this.f1367o = 0.0f;
            this.f1368p = -1;
            this.f1369q = -1;
            this.f1370r = -1;
            this.f1371s = -1;
            this.f1372t = -1;
            this.f1373u = -1;
            this.f1374v = -1;
            this.f1375w = -1;
            this.f1376x = -1;
            this.f1377y = -1;
            this.f1378z = 0.5f;
            this.f1315A = 0.5f;
            this.f1316B = null;
            this.f1317C = 1;
            this.f1318D = -1.0f;
            this.f1319E = -1.0f;
            this.f1320F = 0;
            this.f1321G = 0;
            this.f1322H = 0;
            this.f1323I = 0;
            this.f1324J = 0;
            this.f1325K = 0;
            this.f1326L = 0;
            this.f1327M = 0;
            this.f1328N = 1.0f;
            this.f1329O = 1.0f;
            this.f1330P = -1;
            this.f1331Q = -1;
            this.f1332R = -1;
            this.f1333S = false;
            this.f1334T = false;
            this.f1335U = null;
            this.f1336V = true;
            this.f1337W = true;
            this.f1338X = false;
            this.f1339Y = false;
            this.f1340Z = false;
            this.f1342a0 = false;
            this.f1344b0 = -1;
            this.f1346c0 = -1;
            this.f1348d0 = -1;
            this.f1350e0 = -1;
            this.f1352f0 = -1;
            this.f1354g0 = -1;
            this.f1356h0 = 0.5f;
            this.f1364l0 = new C3958e();
        }
    }
}
