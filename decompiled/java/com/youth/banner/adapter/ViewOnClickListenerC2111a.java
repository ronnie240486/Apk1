package com.youth.banner.adapter;

import android.view.View;
import androidx.recyclerview.widget.AbstractC1174p1;
import p091i9.InterfaceC2724l;

public final class ViewOnClickListenerC2111a implements View.OnClickListener {

    public final int f7719a;

    public final Object f7720b;

    public final Object f7721c;

    public ViewOnClickListenerC2111a(Object obj, int i6, Object obj2) {
        this.f7719a = i6;
        this.f7720b = obj;
        this.f7721c = obj2;
    }

    @Override
    public final void onClick(View view) {
        switch (this.f7719a) {
            case 0:
                ((BannerAdapter) this.f7720b).lambda$onCreateViewHolder$1((AbstractC1174p1) this.f7721c, view);
                break;
            default:
                InterfaceC2724l interfaceC2724l = (InterfaceC2724l) this.f7720b;
                if (interfaceC2724l != null) {
                    interfaceC2724l.invoke(this.f7721c);
                }
                break;
        }
    }
}
