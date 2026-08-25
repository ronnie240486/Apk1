package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import p105k.InterfaceC2823a0;
import p105k.MenuC2838l;

public class NavigationMenuView extends RecyclerView implements InterfaceC2823a0 {
    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        setLayoutManager(new LinearLayoutManager(1));
    }

    @Override
    public final void mo536d(MenuC2838l menuC2838l) {
    }
}
