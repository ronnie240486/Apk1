package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import p002a1.C0026b;
import p105k.C2840n;
import p105k.InterfaceC2823a0;
import p105k.InterfaceC2837k;
import p105k.MenuC2838l;

public final class ExpandedMenuView extends ListView implements InterfaceC2837k, InterfaceC2823a0, AdapterView.OnItemClickListener {

    public static final int[] f498b = {R.attr.background, R.attr.divider};

    public MenuC2838l f499a;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override
    public final boolean mo535a(C2840n c2840n) {
        return this.f499a.m5832q(c2840n, null, 0);
    }

    @Override
    public final void mo536d(MenuC2838l menuC2838l) {
        this.f499a = menuC2838l;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override
    public final void onItemClick(AdapterView adapterView, View view, int i6, long j10) {
        mo535a((C2840n) getAdapter().getItem(i6));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        C0026b c0026bM111C = C0026b.m111C(context, attributeSet, f498b, i6);
        TypedArray typedArray = (TypedArray) c0026bM111C.f55c;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(c0026bM111C.m140t(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(c0026bM111C.m140t(1));
        }
        c0026bM111C.m120F();
    }
}
