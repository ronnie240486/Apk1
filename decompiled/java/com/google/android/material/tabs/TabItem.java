package com.google.android.material.tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import p002a1.C0026b;
import p250x5.AbstractC4121a;

public class TabItem extends View {

    public final CharSequence f6686a;

    public final Drawable f6687b;

    public final int f6688c;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0026b c0026bM110B = C0026b.m110B(context, attributeSet, AbstractC4121a.f13980X);
        TypedArray typedArray = (TypedArray) c0026bM110B.f55c;
        this.f6686a = typedArray.getText(2);
        this.f6687b = c0026bM110B.m140t(0);
        this.f6688c = typedArray.getResourceId(1, 0);
        c0026bM110B.m120F();
    }
}
