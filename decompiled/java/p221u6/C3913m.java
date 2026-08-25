package p221u6;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;
import p250x5.AbstractC4121a;

public final class C3913m {

    public static final C3910j f13163m = new C3910j(0.5f);

    public AbstractC3198d f13164a = new C3911k();

    public AbstractC3198d f13165b = new C3911k();

    public AbstractC3198d f13166c = new C3911k();

    public AbstractC3198d f13167d = new C3911k();

    public InterfaceC3903c f13168e = new C3901a(0.0f);

    public InterfaceC3903c f13169f = new C3901a(0.0f);

    public InterfaceC3903c f13170g = new C3901a(0.0f);

    public InterfaceC3903c f13171h = new C3901a(0.0f);

    public C3905e f13172i = new C3905e(0);

    public C3905e f13173j = new C3905e(0);

    public C3905e f13174k = new C3905e(0);

    public C3905e f13175l = new C3905e(0);

    public static C3912l m7821a(Context context, int i6, int i10, InterfaceC3903c interfaceC3903c) {
        if (i10 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i6);
            i6 = i10;
            context = contextThemeWrapper;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i6, AbstractC4121a.f13975S);
        try {
            int i11 = typedArrayObtainStyledAttributes.getInt(0, 0);
            int i12 = typedArrayObtainStyledAttributes.getInt(3, i11);
            int i13 = typedArrayObtainStyledAttributes.getInt(4, i11);
            int i14 = typedArrayObtainStyledAttributes.getInt(2, i11);
            int i15 = typedArrayObtainStyledAttributes.getInt(1, i11);
            InterfaceC3903c interfaceC3903cM7824d = m7824d(typedArrayObtainStyledAttributes, 5, interfaceC3903c);
            InterfaceC3903c interfaceC3903cM7824d2 = m7824d(typedArrayObtainStyledAttributes, 8, interfaceC3903cM7824d);
            InterfaceC3903c interfaceC3903cM7824d3 = m7824d(typedArrayObtainStyledAttributes, 9, interfaceC3903cM7824d);
            InterfaceC3903c interfaceC3903cM7824d4 = m7824d(typedArrayObtainStyledAttributes, 7, interfaceC3903cM7824d);
            InterfaceC3903c interfaceC3903cM7824d5 = m7824d(typedArrayObtainStyledAttributes, 6, interfaceC3903cM7824d);
            C3912l c3912l = new C3912l();
            AbstractC3198d abstractC3198dM6587e = AbstractC3280d.m6587e(i12);
            c3912l.f13151a = abstractC3198dM6587e;
            C3912l.m7818b(abstractC3198dM6587e);
            c3912l.f13155e = interfaceC3903cM7824d2;
            AbstractC3198d abstractC3198dM6587e2 = AbstractC3280d.m6587e(i13);
            c3912l.f13152b = abstractC3198dM6587e2;
            C3912l.m7818b(abstractC3198dM6587e2);
            c3912l.f13156f = interfaceC3903cM7824d3;
            AbstractC3198d abstractC3198dM6587e3 = AbstractC3280d.m6587e(i14);
            c3912l.f13153c = abstractC3198dM6587e3;
            C3912l.m7818b(abstractC3198dM6587e3);
            c3912l.f13157g = interfaceC3903cM7824d4;
            AbstractC3198d abstractC3198dM6587e4 = AbstractC3280d.m6587e(i15);
            c3912l.f13154d = abstractC3198dM6587e4;
            C3912l.m7818b(abstractC3198dM6587e4);
            c3912l.f13158h = interfaceC3903cM7824d5;
            return c3912l;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static C3912l m7822b(Context context, AttributeSet attributeSet, int i6, int i10) {
        return m7823c(context, attributeSet, i6, i10, new C3901a(0));
    }

    public static C3912l m7823c(Context context, AttributeSet attributeSet, int i6, int i10, InterfaceC3903c interfaceC3903c) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4121a.f13963G, i6, i10);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return m7821a(context, resourceId, resourceId2, interfaceC3903c);
    }

    public static InterfaceC3903c m7824d(TypedArray typedArray, int i6, InterfaceC3903c interfaceC3903c) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i6);
        if (typedValuePeekValue == null) {
            return interfaceC3903c;
        }
        int i10 = typedValuePeekValue.type;
        if (i10 == 5) {
            return new C3901a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i10 == 6 ? new C3910j(typedValuePeekValue.getFraction(1.0f, 1.0f)) : interfaceC3903c;
    }

    public final boolean m7825e(RectF rectF) {
        boolean z7 = this.f13175l.getClass().equals(C3905e.class) && this.f13173j.getClass().equals(C3905e.class) && this.f13172i.getClass().equals(C3905e.class) && this.f13174k.getClass().equals(C3905e.class);
        float fMo7794a = this.f13168e.mo7794a(rectF);
        return z7 && ((this.f13169f.mo7794a(rectF) > fMo7794a ? 1 : (this.f13169f.mo7794a(rectF) == fMo7794a ? 0 : -1)) == 0 && (this.f13171h.mo7794a(rectF) > fMo7794a ? 1 : (this.f13171h.mo7794a(rectF) == fMo7794a ? 0 : -1)) == 0 && (this.f13170g.mo7794a(rectF) > fMo7794a ? 1 : (this.f13170g.mo7794a(rectF) == fMo7794a ? 0 : -1)) == 0) && ((this.f13165b instanceof C3911k) && (this.f13164a instanceof C3911k) && (this.f13166c instanceof C3911k) && (this.f13167d instanceof C3911k));
    }

    public final C3912l m7826f() {
        C3912l c3912l = new C3912l();
        c3912l.f13151a = this.f13164a;
        c3912l.f13152b = this.f13165b;
        c3912l.f13153c = this.f13166c;
        c3912l.f13154d = this.f13167d;
        c3912l.f13155e = this.f13168e;
        c3912l.f13156f = this.f13169f;
        c3912l.f13157g = this.f13170g;
        c3912l.f13158h = this.f13171h;
        c3912l.f13159i = this.f13172i;
        c3912l.f13160j = this.f13173j;
        c3912l.f13161k = this.f13174k;
        c3912l.f13162l = this.f13175l;
        return c3912l;
    }
}
