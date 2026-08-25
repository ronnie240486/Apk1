package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.AbstractC1465c;
import com.bumptech.glide.AbstractC1466d;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    @Override
    public final void setTextAppearance(Context context, int i6) {
        super.setTextAppearance(context, i6);
        TypedValue typedValueM3477l = AbstractC1465c.m3477l(context, com.p2serv.android.p032ds.R.attr.textAppearanceLineHeightEnabled);
        if (typedValueM3477l != null && typedValueM3477l.type == 18 && typedValueM3477l.data == 0) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(i6, AbstractC4121a.f13964H);
        Context context2 = getContext();
        int[] iArr = {1, 2};
        int iM3494l = -1;
        for (int i10 = 0; i10 < 2 && iM3494l < 0; i10++) {
            iM3494l = AbstractC1466d.m3494l(context2, typedArrayObtainStyledAttributes, iArr[i10], -1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (iM3494l >= 0) {
            setLineHeight(iM3494l);
        }
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, 0), attributeSet, i6);
        Context context2 = getContext();
        TypedValue typedValueM3477l = AbstractC1465c.m3477l(context2, com.p2serv.android.p032ds.R.attr.textAppearanceLineHeightEnabled);
        if (typedValueM3477l != null && typedValueM3477l.type == 18 && typedValueM3477l.data == 0) {
            return;
        }
        Resources.Theme theme = context2.getTheme();
        int[] iArr = AbstractC4121a.f13965I;
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, i6, 0);
        int[] iArr2 = {1, 2};
        int iM3494l = -1;
        for (int i10 = 0; i10 < 2 && iM3494l < 0; i10++) {
            iM3494l = AbstractC1466d.m3494l(context2, typedArrayObtainStyledAttributes, iArr2[i10], -1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (iM3494l != -1) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, i6, 0);
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, -1);
        typedArrayObtainStyledAttributes2.recycle();
        if (resourceId != -1) {
            TypedArray typedArrayObtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, AbstractC4121a.f13964H);
            Context context3 = getContext();
            int[] iArr3 = {1, 2};
            int iM3494l2 = -1;
            for (int i11 = 0; i11 < 2 && iM3494l2 < 0; i11++) {
                iM3494l2 = AbstractC1466d.m3494l(context3, typedArrayObtainStyledAttributes3, iArr3[i11], -1);
            }
            typedArrayObtainStyledAttributes3.recycle();
            if (iM3494l2 >= 0) {
                setLineHeight(iM3494l2);
            }
        }
    }
}
