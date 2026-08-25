package p256y;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import androidx.media3.extractor.text.ttml.TtmlNode;

public final class C4195l {

    public final float f14259a;

    public final float f14260b;

    public final float f14261c;

    public final float f14262d;

    public final int f14263e;

    public C4195l(Context context, XmlResourceParser xmlResourceParser) {
        this.f14259a = Float.NaN;
        this.f14260b = Float.NaN;
        this.f14261c = Float.NaN;
        this.f14262d = Float.NaN;
        this.f14263e = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), AbstractC4193j.f14255u);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            if (index == 0) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f14263e);
                this.f14263e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                TtmlNode.TAG_LAYOUT.equals(resourceTypeName);
            } else if (index == 1) {
                this.f14262d = typedArrayObtainStyledAttributes.getDimension(index, this.f14262d);
            } else if (index == 2) {
                this.f14260b = typedArrayObtainStyledAttributes.getDimension(index, this.f14260b);
            } else if (index == 3) {
                this.f14261c = typedArrayObtainStyledAttributes.getDimension(index, this.f14261c);
            } else if (index == 4) {
                this.f14259a = typedArrayObtainStyledAttributes.getDimension(index, this.f14259a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final boolean m8248a(float f, float f3) {
        float f4 = this.f14259a;
        if (!Float.isNaN(f4) && f < f4) {
            return false;
        }
        float f5 = this.f14260b;
        if (!Float.isNaN(f5) && f3 < f5) {
            return false;
        }
        float f10 = this.f14261c;
        if (!Float.isNaN(f10) && f > f10) {
            return false;
        }
        float f11 = this.f14262d;
        return Float.isNaN(f11) || f3 <= f11;
    }
}
