package androidx.leanback.widget;

import android.util.Property;

public final class C0464f1 extends Property {

    public final int f2331a;

    public C0464f1(String str, Class cls, int i6) {
        super(cls, str);
        this.f2331a = i6;
    }

    @Override
    public final Object get(Object obj) {
        switch (this.f2331a) {
            case 0:
                return Integer.valueOf(((StreamingTextView) obj).getStreamPosition());
            case 1:
                return Float.valueOf(((C0472i0) obj).f2335a);
            case 2:
                return Float.valueOf(((C0472i0) obj).f2339e);
            default:
                return Float.valueOf(((C0472i0) obj).f2337c);
        }
    }

    @Override
    public final void set(Object obj, Object obj2) {
        switch (this.f2331a) {
            case 0:
                ((StreamingTextView) obj).setStreamPosition(((Integer) obj2).intValue());
                break;
            case 1:
                C0472i0 c0472i0 = (C0472i0) obj;
                c0472i0.f2335a = ((Float) obj2).floatValue();
                c0472i0.m1438a();
                c0472i0.f2344j.invalidate();
                break;
            case 2:
                C0472i0 c0472i1 = (C0472i0) obj;
                float fFloatValue = ((Float) obj2).floatValue();
                c0472i1.f2339e = fFloatValue;
                float f = fFloatValue / 2.0f;
                c0472i1.f2340f = f;
                PagingIndicator pagingIndicator = c0472i1.f2344j;
                c0472i1.f2341g = f * pagingIndicator.f2204v;
                pagingIndicator.invalidate();
                break;
            default:
                C0472i0 c0472i2 = (C0472i0) obj;
                c0472i2.f2337c = ((Float) obj2).floatValue() * c0472i2.f2342h * c0472i2.f2343i;
                c0472i2.f2344j.invalidate();
                break;
        }
    }
}
