package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.appcompat.widget.C0275u;
import com.bumptech.glide.AbstractC1465c;
import com.bumptech.glide.AbstractC1466d;
import com.p2serv.android.p032ds.R;
import p250x5.AbstractC4121a;

public final class C1778c {

    public final C0275u f6150a;

    public final C0275u f6151b;

    public final C0275u f6152c;

    public final C0275u f6153d;

    public final C0275u f6154e;

    public final C0275u f6155f;

    public final C0275u f6156g;

    public final Paint f6157h;

    public C1778c(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC1465c.m3478m(context, R.attr.materialCalendarStyle, C1801r.class.getCanonicalName()), AbstractC4121a.f13957A);
        this.f6150a = C0275u.m772b(context, typedArrayObtainStyledAttributes.getResourceId(3, 0));
        this.f6156g = C0275u.m772b(context, typedArrayObtainStyledAttributes.getResourceId(1, 0));
        this.f6151b = C0275u.m772b(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
        this.f6152c = C0275u.m772b(context, typedArrayObtainStyledAttributes.getResourceId(4, 0));
        ColorStateList colorStateListM3493k = AbstractC1466d.m3493k(context, typedArrayObtainStyledAttributes, 6);
        this.f6153d = C0275u.m772b(context, typedArrayObtainStyledAttributes.getResourceId(8, 0));
        this.f6154e = C0275u.m772b(context, typedArrayObtainStyledAttributes.getResourceId(7, 0));
        this.f6155f = C0275u.m772b(context, typedArrayObtainStyledAttributes.getResourceId(9, 0));
        Paint paint = new Paint();
        this.f6157h = paint;
        paint.setColor(colorStateListM3493k.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
