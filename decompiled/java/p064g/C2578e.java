package p064g;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.C0233l2;
import com.alibaba.fastjson.asm.Opcodes;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import p046e0.AbstractC2343b;
import p065g0.InterfaceC2588h;
import p073h.AbstractC2636b;
import p073h.AbstractC2637c;
import p123l5.AbstractC2973a;
import p268z1.C4288c;
import p268z1.C4299n;

public final class C2578e extends AbstractC2580g implements InterfaceC2588h {

    public C2575b f8994n;

    public boolean f8995o;

    public C2575b f8996p;

    public AbstractC2973a f8997q;

    public int f8998r;

    public int f8999s;

    public boolean f9000t;

    public C2578e(C2575b c2575b, Resources resources) {
        this.f9008e = 255;
        this.f9010g = -1;
        this.f8998r = -1;
        this.f8999s = -1;
        mo5573d(new C2575b(c2575b, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static C2578e m5572e(Context context, Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int next;
        int next2;
        Context context2 = context;
        Resources resources2 = resources;
        XmlResourceParser xmlResourceParser2 = xmlResourceParser;
        String name = xmlResourceParser.getName();
        if (!name.equals("animated-selector")) {
            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": invalid animated-selector tag " + name);
        }
        C2578e c2578e = new C2578e(null, null);
        TypedArray typedArrayM5322h = AbstractC2343b.m5322h(resources2, theme, attributeSet, AbstractC2637c.f9154a);
        int i6 = 1;
        c2578e.setVisible(typedArrayM5322h.getBoolean(1, true), true);
        C2575b c2575b = c2578e.f8996p;
        c2575b.f8966d |= AbstractC2636b.m5657b(typedArrayM5322h);
        int i10 = 2;
        c2575b.f8971i = typedArrayM5322h.getBoolean(2, c2575b.f8971i);
        int i11 = 3;
        c2575b.f8974l = typedArrayM5322h.getBoolean(3, c2575b.f8974l);
        c2575b.f8987y = typedArrayM5322h.getInt(4, c2575b.f8987y);
        c2575b.f8988z = typedArrayM5322h.getInt(5, c2575b.f8988z);
        boolean z7 = false;
        c2578e.setDither(typedArrayM5322h.getBoolean(0, c2575b.f8985w));
        C2575b c2575b2 = c2578e.f9004a;
        if (resources2 != null) {
            c2575b2.f8964b = resources2;
            int i12 = resources.getDisplayMetrics().densityDpi;
            if (i12 == 0) {
                i12 = Opcodes.IF_ICMPNE;
            }
            int i13 = c2575b2.f8965c;
            c2575b2.f8965c = i12;
            if (i13 != i12) {
                c2575b2.f8975m = false;
                c2575b2.f8972j = false;
            }
        } else {
            c2575b2.getClass();
        }
        typedArrayM5322h.recycle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next3 = xmlResourceParser.next();
            if (next3 == i6 || ((depth = xmlResourceParser.getDepth()) < depth2 && next3 == i11)) {
                break;
            }
            if (next3 == i10 && depth <= depth2) {
                if (xmlResourceParser.getName().equals("item")) {
                    TypedArray typedArrayM5322h2 = AbstractC2343b.m5322h(resources2, theme, attributeSet, AbstractC2637c.f9155b);
                    int resourceId = typedArrayM5322h2.getResourceId(z7 ? 1 : 0, z7 ? 1 : 0);
                    int resourceId2 = typedArrayM5322h2.getResourceId(i6, -1);
                    Drawable drawableM727f = resourceId2 > 0 ? C0233l2.m720d().m727f(context2, resourceId2) : null;
                    typedArrayM5322h2.recycle();
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr = new int[attributeCount];
                    int i14 = 0;
                    for (int i15 = 0; i15 < attributeCount; i15++) {
                        int attributeNameResource = attributeSet.getAttributeNameResource(i15);
                        if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                            int i16 = i14 + 1;
                            if (!attributeSet.getAttributeBooleanValue(i15, z7)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr[i14] = attributeNameResource;
                            i14 = i16;
                        }
                    }
                    int[] iArrTrimStateSet = StateSet.trimStateSet(iArr, i14);
                    if (drawableM727f == null) {
                        do {
                            next2 = xmlResourceParser.next();
                        } while (next2 == 4);
                        if (next2 != 2) {
                            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                        if (xmlResourceParser.getName().equals("vector")) {
                            drawableM727f = new C4299n();
                            drawableM727f.inflate(resources2, xmlResourceParser2, attributeSet, theme);
                        } else {
                            drawableM727f = AbstractC2636b.m5656a(resources, xmlResourceParser, attributeSet, theme);
                        }
                    }
                    if (drawableM727f == null) {
                        throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                    C2575b c2575b3 = c2578e.f8996p;
                    int iM5564a = c2575b3.m5564a(drawableM727f);
                    c2575b3.f8960H[iM5564a] = iArrTrimStateSet;
                    c2575b3.f8962J.m6820d(iM5564a, Integer.valueOf(resourceId));
                } else {
                    if (xmlResourceParser.getName().equals("transition")) {
                        TypedArray typedArrayM5322h3 = AbstractC2343b.m5322h(resources2, theme, attributeSet, AbstractC2637c.f9156c);
                        int resourceId3 = typedArrayM5322h3.getResourceId(2, -1);
                        int resourceId4 = typedArrayM5322h3.getResourceId(1, -1);
                        int resourceId5 = typedArrayM5322h3.getResourceId(z7 ? 1 : 0, -1);
                        Drawable drawableM727f2 = resourceId5 > 0 ? C0233l2.m720d().m727f(context2, resourceId5) : null;
                        boolean z10 = typedArrayM5322h3.getBoolean(3, z7);
                        typedArrayM5322h3.recycle();
                        if (drawableM727f2 == null) {
                            do {
                                next = xmlResourceParser.next();
                            } while (next == 4);
                            if (next != 2) {
                                throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
                            }
                            if (xmlResourceParser.getName().equals("animated-vector")) {
                                drawableM727f2 = new C4288c(context2);
                                drawableM727f2.inflate(resources2, xmlResourceParser2, attributeSet, theme);
                            } else {
                                drawableM727f2 = AbstractC2636b.m5656a(resources, xmlResourceParser, attributeSet, theme);
                            }
                        }
                        if (drawableM727f2 == null) {
                            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                        if (resourceId3 == -1 || resourceId4 == -1) {
                            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
                        }
                        C2575b c2575b4 = c2578e.f8996p;
                        int iM5564a2 = c2575b4.m5564a(drawableM727f2);
                        long j10 = resourceId3;
                        long j11 = resourceId4;
                        long j12 = (j10 << 32) | j11;
                        long j13 = z10 ? 8589934592L : 0L;
                        long j14 = iM5564a2;
                        c2575b4.f8961I.m6794a(j12, Long.valueOf(j14 | j13));
                        if (z10) {
                            c2575b4.f8961I.m6794a((j11 << 32) | j10, Long.valueOf(j14 | 4294967296L | j13));
                        }
                        context2 = context;
                        resources2 = resources;
                        xmlResourceParser2 = xmlResourceParser;
                        i6 = 1;
                        z7 = false;
                    } else {
                        context2 = context;
                        resources2 = resources;
                        xmlResourceParser2 = xmlResourceParser;
                    }
                    i10 = 2;
                    i11 = 3;
                }
                i6 = 1;
                i10 = 2;
                i11 = 3;
            }
        }
        c2578e.onStateChange(c2578e.getState());
        return c2578e;
    }

    @Override
    public final void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override
    public final void mo5573d(C2575b c2575b) {
        this.f9004a = c2575b;
        int i6 = this.f9010g;
        if (i6 >= 0) {
            Drawable drawableM5567d = c2575b.m5567d(i6);
            this.f9006c = drawableM5567d;
            if (drawableM5567d != null) {
                m5577b(drawableM5567d);
            }
        }
        this.f9007d = null;
        this.f8994n = c2575b;
        this.f8996p = c2575b;
    }

    public final Drawable m5574f() {
        if (!this.f8995o) {
            super.mutate();
            C2575b c2575b = this.f8994n;
            c2575b.f8961I = c2575b.f8961I.clone();
            c2575b.f8962J = c2575b.f8962J.clone();
            this.f8995o = true;
        }
        return this;
    }

    @Override
    public final boolean isStateful() {
        return true;
    }

    @Override
    public final void jumpToCurrentState() {
        super.jumpToCurrentState();
        AbstractC2973a abstractC2973a = this.f8997q;
        if (abstractC2973a != null) {
            abstractC2973a.mo5563U();
            this.f8997q = null;
            m5578c(this.f8998r);
            this.f8998r = -1;
            this.f8999s = -1;
        }
    }

    @Override
    public final Drawable mutate() {
        if (!this.f9000t) {
            m5574f();
            C2575b c2575b = this.f8996p;
            c2575b.f8961I = c2575b.f8961I.clone();
            c2575b.f8962J = c2575b.f8962J.clone();
            this.f9000t = true;
        }
        return this;
    }

    @Override
    public final boolean onStateChange(int[] iArr) {
        int iM5568e;
        AbstractC2973a c2574a;
        C2575b c2575b = this.f8996p;
        int iM5569f = c2575b.m5569f(iArr);
        if (iM5569f < 0) {
            iM5569f = c2575b.m5569f(StateSet.WILD_CARD);
        }
        int i6 = this.f9010g;
        boolean z7 = false;
        if (iM5569f != i6) {
            AbstractC2973a abstractC2973a = this.f8997q;
            if (abstractC2973a == null) {
                this.f8997q = null;
                this.f8999s = -1;
                this.f8998r = -1;
                C2575b c2575b2 = this.f8996p;
                int iM5568e2 = c2575b2.m5568e(i6);
                iM5568e = c2575b2.m5568e(iM5569f);
                if (iM5568e == 0 && iM5568e2 != 0) {
                    long j10 = ((long) iM5568e) | (((long) iM5568e2) << 32);
                    int iLongValue = (int) ((Long) c2575b2.f8961I.m6798e(j10)).longValue();
                    if (iLongValue >= 0) {
                        boolean z10 = (((Long) c2575b2.f8961I.m6798e(j10)).longValue() & 8589934592L) != 0;
                        m5578c(iLongValue);
                        Object obj = this.f9006c;
                        if (obj instanceof AnimationDrawable) {
                            c2574a = new C2576c((AnimationDrawable) obj, (((Long) c2575b2.f8961I.m6798e(j10)).longValue() & 4294967296L) != 0, z10);
                        } else if (obj instanceof C4288c) {
                            c2574a = new C2574a((C4288c) obj, 1);
                        } else if (obj instanceof Animatable) {
                            c2574a = new C2574a((Animatable) obj, 0);
                        } else if (m5578c(iM5569f)) {
                            z7 = true;
                        }
                        c2574a.mo5562S();
                        this.f8997q = c2574a;
                        this.f8999s = i6;
                        this.f8998r = iM5569f;
                        z7 = true;
                    } else if (m5578c(iM5569f)) {
                        z7 = true;
                    }
                } else if (m5578c(iM5569f)) {
                    z7 = true;
                }
            } else {
                if (iM5569f != this.f8998r) {
                    if (iM5569f == this.f8999s && abstractC2973a.mo5571f()) {
                        abstractC2973a.mo5570I();
                        this.f8998r = this.f8999s;
                        this.f8999s = iM5569f;
                    } else {
                        i6 = this.f8998r;
                        abstractC2973a.mo5563U();
                        this.f8997q = null;
                        this.f8999s = -1;
                        this.f8998r = -1;
                        C2575b c2575b3 = this.f8996p;
                        int iM5568e3 = c2575b3.m5568e(i6);
                        iM5568e = c2575b3.m5568e(iM5569f);
                        if (iM5568e == 0) {
                            if (m5578c(iM5569f)) {
                            }
                        } else if (m5578c(iM5569f)) {
                        }
                    }
                }
                z7 = true;
            }
        }
        Drawable drawable = this.f9006c;
        return drawable != null ? z7 | drawable.setState(iArr) : z7;
    }

    @Override
    public final boolean setVisible(boolean z7, boolean z10) {
        boolean visible = super.setVisible(z7, z10);
        AbstractC2973a abstractC2973a = this.f8997q;
        if (abstractC2973a != null && (visible || z10)) {
            if (z7) {
                abstractC2973a.mo5562S();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }
}
