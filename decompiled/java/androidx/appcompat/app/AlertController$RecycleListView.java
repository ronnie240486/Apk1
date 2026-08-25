package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import p045e.AbstractC2341a;

public class AlertController$RecycleListView extends ListView {

    public final int f248a;

    public final int f249b;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2341a.f8173u);
        this.f249b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, -1);
        this.f248a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, -1);
    }
}
