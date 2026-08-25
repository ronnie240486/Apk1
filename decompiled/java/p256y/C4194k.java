package p256y;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;

public final class C4194k {

    public final int f14256a;

    public final ArrayList f14257b = new ArrayList();

    public final int f14258c;

    public C4194k(Context context, XmlResourceParser xmlResourceParser) {
        this.f14258c = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), AbstractC4193j.f14251q);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            if (index == 0) {
                this.f14256a = typedArrayObtainStyledAttributes.getResourceId(index, this.f14256a);
            } else if (index == 1) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f14258c);
                this.f14258c = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                TtmlNode.TAG_LAYOUT.equals(resourceTypeName);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
