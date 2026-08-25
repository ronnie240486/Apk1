package p205t;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.C0307c;
import androidx.constraintlayout.widget.C0308d;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.p2serv.android.p032ds.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
import p003a2.AbstractC0032a;
import p028c6.C1399b;
import p194s.C3681e;
import p256y.AbstractC4193j;
import p256y.C4187d;
import p256y.C4188e;
import p256y.C4189f;
import p256y.C4190g;

public final class C3751c0 {

    public final MotionLayout f12576a;

    public final C1399b f12577b;

    public C3749b0 f12578c;

    public final ArrayList f12579d;

    public final C3749b0 f12580e;

    public final ArrayList f12581f;

    public final SparseArray f12582g;

    public final HashMap f12583h;

    public final SparseIntArray f12584i;

    public int f12585j;

    public int f12586k;

    public MotionEvent f12587l;

    public boolean f12588m;

    public C3781u f12589n;

    public boolean f12590o;

    public float f12591p;

    public float f12592q;

    public C3751c0(Context context, MotionLayout motionLayout, int i6) {
        C3749b0 c3749b0 = null;
        this.f12577b = null;
        this.f12578c = null;
        ArrayList arrayList = new ArrayList();
        this.f12579d = arrayList;
        this.f12580e = null;
        this.f12581f = new ArrayList();
        this.f12582g = new SparseArray();
        this.f12583h = new HashMap();
        this.f12584i = new SparseIntArray();
        this.f12585j = 400;
        this.f12586k = 0;
        this.f12588m = false;
        this.f12576a = motionLayout;
        XmlResourceParser xml = context.getResources().getXml(i6);
        try {
            int eventType = xml.getEventType();
            while (true) {
                if (eventType != 1) {
                    if (eventType == 0) {
                        xml.getName();
                    } else if (eventType == 2) {
                        String name = xml.getName();
                        switch (name) {
                            case "MotionScene":
                                m7499i(context, xml);
                                break;
                            case "Transition":
                                c3749b0 = new C3749b0(this, context, xml);
                                arrayList.add(c3749b0);
                                if (this.f12578c == null && !c3749b0.f12559b) {
                                    this.f12578c = c3749b0;
                                    C3775o0 c3775o0 = c3749b0.f12569l;
                                    if (c3775o0 != null) {
                                        c3775o0.m7523b(this.f12590o);
                                    }
                                }
                                if (!c3749b0.f12559b) {
                                    break;
                                } else {
                                    if (c3749b0.f12560c == -1) {
                                        this.f12580e = c3749b0;
                                    } else {
                                        this.f12581f.add(c3749b0);
                                    }
                                    arrayList.remove(c3749b0);
                                    break;
                                }
                                break;
                            case "OnSwipe":
                                if (c3749b0 == null) {
                                    Log.v("MotionScene", " OnSwipe (" + context.getResources().getResourceEntryName(i6) + ".xml:" + xml.getLineNumber() + ")");
                                }
                                c3749b0.f12569l = new C3775o0(context, this.f12576a, xml);
                                break;
                            case "OnClick":
                                c3749b0.getClass();
                                c3749b0.f12570m.add(new ViewOnClickListenerC3747a0(context, c3749b0, xml));
                                break;
                            case "StateSet":
                                this.f12577b = new C1399b(context, xml);
                                break;
                            case "ConstraintSet":
                                m7498h(context, xml);
                                break;
                            case "KeyFrameSet":
                                c3749b0.f12568k.add(new C3764j(xml));
                                break;
                            default:
                                Log.v("MotionScene", "WARNING UNKNOWN ATTRIBUTE " + name);
                                break;
                        }
                    }
                    eventType = xml.next();
                }
                this.f12582g.put(R.id.motion_base, new C0308d());
                this.f12583h.put("motion_base", Integer.valueOf(R.id.motion_base));
                return;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        }
    }

    public final boolean m7491a(MotionLayout motionLayout, int i6) {
        if (this.f12589n != null) {
            return false;
        }
        for (C3749b0 c3749b0 : this.f12579d) {
            int i10 = c3749b0.f12571n;
            if (i10 != 0) {
                int i11 = c3749b0.f12561d;
                EnumC3784x enumC3784x = EnumC3784x.f12732d;
                EnumC3784x enumC3784x2 = EnumC3784x.f12731c;
                EnumC3784x enumC3784x3 = EnumC3784x.f12730b;
                if (i6 == i11 && (i10 == 4 || i10 == 2)) {
                    motionLayout.setState(enumC3784x);
                    motionLayout.setTransition(c3749b0);
                    if (c3749b0.f12571n == 4) {
                        motionLayout.m853o(1.0f);
                        motionLayout.setState(enumC3784x3);
                        motionLayout.setState(enumC3784x2);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.m854p(true);
                        motionLayout.setState(enumC3784x3);
                        motionLayout.setState(enumC3784x2);
                        motionLayout.setState(enumC3784x);
                    }
                    return true;
                }
                if (i6 == c3749b0.f12560c && (i10 == 3 || i10 == 1)) {
                    motionLayout.setState(enumC3784x);
                    motionLayout.setTransition(c3749b0);
                    if (c3749b0.f12571n == 3) {
                        motionLayout.m853o(0.0f);
                        motionLayout.setState(enumC3784x3);
                        motionLayout.setState(enumC3784x2);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.m854p(true);
                        motionLayout.setState(enumC3784x3);
                        motionLayout.setState(enumC3784x2);
                        motionLayout.setState(enumC3784x);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final C0308d m7492b(int i6) {
        int iM3271c;
        C1399b c1399b = this.f12577b;
        if (c1399b != null && (iM3271c = c1399b.m3271c(i6)) != -1) {
            i6 = iM3271c;
        }
        SparseArray sparseArray = this.f12582g;
        if (sparseArray.get(i6) != null) {
            return (C0308d) sparseArray.get(i6);
        }
        Log.e("MotionScene", "Warning could not find ConstraintSet id/" + AbstractC0032a.m170x(this.f12576a.getContext(), i6) + " In MotionScene");
        return (C0308d) sparseArray.get(sparseArray.keyAt(0));
    }

    public final int m7493c(Context context, String str) {
        int identifier;
        if (str.contains("/")) {
            identifier = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), TtmlNode.ATTR_ID, context.getPackageName());
        } else {
            identifier = -1;
        }
        if (identifier != -1) {
            return identifier;
        }
        if (str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e("MotionScene", "error in parsing id");
        return identifier;
    }

    public final Interpolator m7494d() {
        C3749b0 c3749b0 = this.f12578c;
        int i6 = c3749b0.f12562e;
        if (i6 == -2) {
            return AnimationUtils.loadInterpolator(this.f12576a.getContext(), this.f12578c.f12564g);
        }
        if (i6 == -1) {
            return new InterpolatorC3786z(C3681e.m7432c(c3749b0.f12563f));
        }
        if (i6 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i6 == 1) {
            return new AccelerateInterpolator();
        }
        if (i6 == 2) {
            return new DecelerateInterpolator();
        }
        if (i6 == 4) {
            return new AnticipateInterpolator();
        }
        if (i6 != 5) {
            return null;
        }
        return new BounceInterpolator();
    }

    public final void m7495e(C3774o c3774o) {
        C3749b0 c3749b0 = this.f12578c;
        if (c3749b0 != null) {
            Iterator it = c3749b0.f12568k.iterator();
            while (it.hasNext()) {
                ((C3764j) it.next()).m7511a(c3774o);
            }
        } else {
            C3749b0 c3749b1 = this.f12580e;
            if (c3749b1 != null) {
                Iterator it2 = c3749b1.f12568k.iterator();
                while (it2.hasNext()) {
                    ((C3764j) it2.next()).m7511a(c3774o);
                }
            }
        }
    }

    public final float m7496f() {
        C3775o0 c3775o0;
        C3749b0 c3749b0 = this.f12578c;
        if (c3749b0 == null || (c3775o0 = c3749b0.f12569l) == null) {
            return 0.0f;
        }
        return c3775o0.f12691q;
    }

    public final int m7497g() {
        C3749b0 c3749b0 = this.f12578c;
        if (c3749b0 == null) {
            return -1;
        }
        return c3749b0.f12561d;
    }

    public final void m7498h(Context context, XmlResourceParser xmlResourceParser) {
        C0308d c0308d = new C0308d();
        c0308d.f1415b = false;
        int attributeCount = xmlResourceParser.getAttributeCount();
        int iM7493c = -1;
        int iM7493c2 = -1;
        for (int i6 = 0; i6 < attributeCount; i6++) {
            String attributeName = xmlResourceParser.getAttributeName(i6);
            String attributeValue = xmlResourceParser.getAttributeValue(i6);
            attributeName.getClass();
            if (attributeName.equals("deriveConstraintsFrom")) {
                iM7493c2 = m7493c(context, attributeValue);
            } else if (attributeName.equals(TtmlNode.ATTR_ID)) {
                iM7493c = m7493c(context, attributeValue);
                int iIndexOf = attributeValue.indexOf(47);
                if (iIndexOf >= 0) {
                    attributeValue = attributeValue.substring(iIndexOf + 1);
                }
                this.f12583h.put(attributeValue, Integer.valueOf(iM7493c));
            }
        }
        if (iM7493c != -1) {
            int i10 = this.f12576a.f1202J;
            c0308d.m899i(context, xmlResourceParser);
            if (iM7493c2 != -1) {
                this.f12584i.put(iM7493c, iM7493c2);
            }
            this.f12582g.put(iM7493c, c0308d);
        }
    }

    public final void m7499i(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), AbstractC4193j.f14246l);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            if (index == 0) {
                this.f12585j = typedArrayObtainStyledAttributes.getInt(index, this.f12585j);
            } else if (index == 1) {
                this.f12586k = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void m7500j(int i6) {
        SparseIntArray sparseIntArray = this.f12584i;
        int i10 = sparseIntArray.get(i6);
        if (i10 > 0) {
            m7500j(sparseIntArray.get(i6));
            SparseArray sparseArray = this.f12582g;
            C0308d c0308d = (C0308d) sparseArray.get(i6);
            C0308d c0308d2 = (C0308d) sparseArray.get(i10);
            if (c0308d2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + AbstractC0032a.m170x(this.f12576a.getContext(), i10));
                return;
            }
            c0308d.getClass();
            HashMap map = c0308d2.f1416c;
            for (Integer num : map.keySet()) {
                num.getClass();
                C0307c c0307c = (C0307c) map.get(num);
                HashMap map2 = c0308d.f1416c;
                if (!map2.containsKey(num)) {
                    map2.put(num, new C0307c());
                }
                C0307c c0307c2 = (C0307c) map2.get(num);
                C4187d c4187d = c0307c2.f1409d;
                if (!c4187d.f14174b) {
                    c4187d.m8241a(c0307c.f1409d);
                }
                C4189f c4189f = c0307c2.f1407b;
                if (!c4189f.f14216a) {
                    C4189f c4189f2 = c0307c.f1407b;
                    c4189f.f14216a = c4189f2.f14216a;
                    c4189f.f14217b = c4189f2.f14217b;
                    c4189f.f14219d = c4189f2.f14219d;
                    c4189f.f14220e = c4189f2.f14220e;
                    c4189f.f14218c = c4189f2.f14218c;
                }
                C4190g c4190g = c0307c2.f1410e;
                if (!c4190g.f14222a) {
                    c4190g.m8246a(c0307c.f1410e);
                }
                C4188e c4188e = c0307c2.f1408c;
                if (!c4188e.f14209a) {
                    c4188e.m8243a(c0307c.f1408c);
                }
                for (String str : c0307c.f1411f.keySet()) {
                    if (!c0307c2.f1411f.containsKey(str)) {
                        c0307c2.f1411f.put(str, c0307c.f1411f.get(str));
                    }
                }
            }
            sparseIntArray.put(i6, -1);
        }
    }

    public final void m7501k(int i6, int i10) {
        int iM3271c;
        int iM3271c2;
        ArrayList arrayList;
        Iterator it;
        C3749b0 c3749b0;
        C3749b0 c3749b1;
        C3749b0 c3749b2;
        int i11;
        C3775o0 c3775o0;
        C1399b c1399b = this.f12577b;
        if (c1399b != null) {
            iM3271c = c1399b.m3271c(i6);
            if (iM3271c == -1) {
                iM3271c = i6;
            }
            iM3271c2 = this.f12577b.m3271c(i10);
            if (iM3271c2 == -1) {
            }
            arrayList = this.f12579d;
            it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    c3749b0 = this.f12580e;
                    for (C3749b0 c3749b3 : this.f12581f) {
                        if (c3749b3.f12560c == i10) {
                            c3749b0 = c3749b3;
                        }
                    }
                    c3749b1 = new C3749b0(this, c3749b0);
                    c3749b1.f12561d = iM3271c;
                    c3749b1.f12560c = iM3271c2;
                    if (iM3271c != -1) {
                        arrayList.add(c3749b1);
                    }
                    this.f12578c = c3749b1;
                    return;
                }
                c3749b2 = (C3749b0) it.next();
                i11 = c3749b2.f12560c;
                if ((i11 != iM3271c2 && c3749b2.f12561d == iM3271c) || (i11 == i10 && c3749b2.f12561d == i6)) {
                    break;
                }
            }
            this.f12578c = c3749b2;
            c3775o0 = c3749b2.f12569l;
            if (c3775o0 != null) {
                c3775o0.m7523b(this.f12590o);
            }
        }
        iM3271c = i6;
        iM3271c2 = i10;
        arrayList = this.f12579d;
        it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                c3749b0 = this.f12580e;
                while (r4.hasNext()) {
                    if (c3749b3.f12560c == i10) {
                        c3749b0 = c3749b3;
                    }
                }
                c3749b1 = new C3749b0(this, c3749b0);
                c3749b1.f12561d = iM3271c;
                c3749b1.f12560c = iM3271c2;
                if (iM3271c != -1) {
                    arrayList.add(c3749b1);
                }
                this.f12578c = c3749b1;
                return;
            }
            c3749b2 = (C3749b0) it.next();
            i11 = c3749b2.f12560c;
            if (i11 != iM3271c2) {
            }
        }
        this.f12578c = c3749b2;
        c3775o0 = c3749b2.f12569l;
        if (c3775o0 != null) {
            c3775o0.m7523b(this.f12590o);
        }
    }

    public final boolean m7502l() {
        Iterator it = this.f12579d.iterator();
        while (it.hasNext()) {
            if (((C3749b0) it.next()).f12569l != null) {
                return true;
            }
        }
        C3749b0 c3749b0 = this.f12578c;
        return (c3749b0 == null || c3749b0.f12569l == null) ? false : true;
    }
}
