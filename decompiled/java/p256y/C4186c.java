package p256y;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.C0308d;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;

public final class C4186c {

    public final float f14139a;

    public final float f14140b;

    public final float f14141c;

    public final float f14142d;

    public final int f14143e;

    public final C0308d f14144f;

    public C4186c(Context context, XmlResourceParser xmlResourceParser) {
        this.f14139a = Float.NaN;
        this.f14140b = Float.NaN;
        this.f14141c = Float.NaN;
        this.f14142d = Float.NaN;
        this.f14143e = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), AbstractC4193j.f14255u);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            if (index == 0) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f14143e);
                this.f14143e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                    C0308d c0308d = new C0308d();
                    this.f14144f = c0308d;
                    c0308d.m896d((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            } else if (index == 1) {
                this.f14142d = typedArrayObtainStyledAttributes.getDimension(index, this.f14142d);
            } else if (index == 2) {
                this.f14140b = typedArrayObtainStyledAttributes.getDimension(index, this.f14140b);
            } else if (index == 3) {
                this.f14141c = typedArrayObtainStyledAttributes.getDimension(index, this.f14141c);
            } else if (index == 4) {
                this.f14139a = typedArrayObtainStyledAttributes.getDimension(index, this.f14139a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final boolean m8240a(float f, float f3) {
        float f4 = this.f14139a;
        if (!Float.isNaN(f4) && f < f4) {
            return false;
        }
        float f5 = this.f14140b;
        if (!Float.isNaN(f5) && f3 < f5) {
            return false;
        }
        float f10 = this.f14141c;
        if (!Float.isNaN(f10) && f > f10) {
            return false;
        }
        float f11 = this.f14142d;
        return Float.isNaN(f11) || f3 <= f11;
    }
}
