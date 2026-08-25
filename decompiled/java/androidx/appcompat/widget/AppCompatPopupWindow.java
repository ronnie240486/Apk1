package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.PopupWindow;
import p002a1.C0026b;
import p045e.AbstractC2341a;
import p123l5.AbstractC2973a;

class AppCompatPopupWindow extends PopupWindow {
    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        m568a(context, attributeSet, i6);
    }

    public final void m568a(Context context, AttributeSet attributeSet, int i6) {
        C0026b c0026bM111C = C0026b.m111C(context, attributeSet, AbstractC2341a.f8172t, i6);
        TypedArray typedArray = (TypedArray) c0026bM111C.f55c;
        if (typedArray.hasValue(2)) {
            AbstractC2973a.m6011M(this, typedArray.getBoolean(2, false));
        }
        setBackgroundDrawable(c0026bM111C.m140t(0));
        c0026bM111C.m120F();
    }
}
