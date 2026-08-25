package p205t;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.C0308d;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import p256y.AbstractC4193j;

public final class C3749b0 {

    public final int f12558a;

    public final boolean f12559b;

    public int f12560c;

    public int f12561d;

    public final int f12562e;

    public final String f12563f;

    public final int f12564g;

    public int f12565h;

    public final float f12566i;

    public final C3751c0 f12567j;

    public final ArrayList f12568k;

    public C3775o0 f12569l;

    public final ArrayList f12570m;

    public final int f12571n;

    public final boolean f12572o;

    public final int f12573p;

    public final int f12574q;

    public final int f12575r;

    public C3749b0(C3751c0 c3751c0, C3749b0 c3749b0) {
        this.f12558a = -1;
        this.f12559b = false;
        this.f12560c = -1;
        this.f12561d = -1;
        this.f12562e = 0;
        this.f12563f = null;
        this.f12564g = -1;
        this.f12565h = 400;
        this.f12566i = 0.0f;
        this.f12568k = new ArrayList();
        this.f12569l = null;
        this.f12570m = new ArrayList();
        this.f12571n = 0;
        this.f12572o = false;
        this.f12573p = -1;
        this.f12574q = 0;
        this.f12575r = 0;
        this.f12567j = c3751c0;
        if (c3749b0 != null) {
            this.f12573p = c3749b0.f12573p;
            this.f12562e = c3749b0.f12562e;
            this.f12563f = c3749b0.f12563f;
            this.f12564g = c3749b0.f12564g;
            this.f12565h = c3749b0.f12565h;
            this.f12568k = c3749b0.f12568k;
            this.f12566i = c3749b0.f12566i;
            this.f12574q = c3749b0.f12574q;
        }
    }

    public C3749b0(C3751c0 c3751c0, Context context, XmlResourceParser xmlResourceParser) {
        this.f12558a = -1;
        this.f12559b = false;
        this.f12560c = -1;
        this.f12561d = -1;
        this.f12562e = 0;
        this.f12563f = null;
        this.f12564g = -1;
        this.f12565h = 400;
        this.f12566i = 0.0f;
        this.f12568k = new ArrayList();
        this.f12569l = null;
        this.f12570m = new ArrayList();
        this.f12571n = 0;
        this.f12572o = false;
        this.f12573p = -1;
        this.f12574q = 0;
        this.f12575r = 0;
        this.f12565h = c3751c0.f12585j;
        this.f12574q = c3751c0.f12586k;
        this.f12567j = c3751c0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), AbstractC4193j.f14254t);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            SparseArray sparseArray = c3751c0.f12582g;
            if (index == 2) {
                this.f12560c = typedArrayObtainStyledAttributes.getResourceId(index, this.f12560c);
                if (TtmlNode.TAG_LAYOUT.equals(context.getResources().getResourceTypeName(this.f12560c))) {
                    C0308d c0308d = new C0308d();
                    c0308d.m898h(context, this.f12560c);
                    sparseArray.append(this.f12560c, c0308d);
                }
            } else if (index == 3) {
                this.f12561d = typedArrayObtainStyledAttributes.getResourceId(index, this.f12561d);
                if (TtmlNode.TAG_LAYOUT.equals(context.getResources().getResourceTypeName(this.f12561d))) {
                    C0308d c0308d2 = new C0308d();
                    c0308d2.m898h(context, this.f12561d);
                    sparseArray.append(this.f12561d, c0308d2);
                }
            } else if (index == 6) {
                int i10 = typedArrayObtainStyledAttributes.peekValue(index).type;
                if (i10 == 1) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    this.f12564g = resourceId;
                    if (resourceId != -1) {
                        this.f12562e = -2;
                    }
                } else if (i10 == 3) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f12563f = string;
                    if (string.indexOf("/") > 0) {
                        this.f12564g = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        this.f12562e = -2;
                    } else {
                        this.f12562e = -1;
                    }
                } else {
                    this.f12562e = typedArrayObtainStyledAttributes.getInteger(index, this.f12562e);
                }
            } else if (index == 4) {
                this.f12565h = typedArrayObtainStyledAttributes.getInt(index, this.f12565h);
            } else if (index == 8) {
                this.f12566i = typedArrayObtainStyledAttributes.getFloat(index, this.f12566i);
            } else if (index == 1) {
                this.f12571n = typedArrayObtainStyledAttributes.getInteger(index, this.f12571n);
            } else if (index == 0) {
                this.f12558a = typedArrayObtainStyledAttributes.getResourceId(index, this.f12558a);
            } else if (index == 9) {
                this.f12572o = typedArrayObtainStyledAttributes.getBoolean(index, this.f12572o);
            } else if (index == 7) {
                this.f12573p = typedArrayObtainStyledAttributes.getInteger(index, -1);
            } else if (index == 5) {
                this.f12574q = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == 10) {
                this.f12575r = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        if (this.f12561d == -1) {
            this.f12559b = true;
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
