package com.google.android.gms.internal.cast;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.media3.common.util.RunnableC0624i;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;
import p000a.AbstractC0004e;
import p002a1.C0026b;
import p005a4.C0049h;
import p005a4.C0050i;
import p005a4.C0051j;
import p005a4.C0055n;
import p005a4.C0060s;
import p005a4.C0061t;
import p007a7.C0069f;
import p013b0.AbstractC1226a;
import p018b5.AbstractC1312l;
import p046e0.AbstractC2343b;
import p046e0.AbstractC2344c;
import p069g4.C2611a;
import p242w5.InterfaceC4055c;
import p248x3.C4105a;
import p248x3.C4106b;
import p248x3.EnumC4107c;

public final class C1552f0 implements InterfaceC4055c {

    public int f5291a;

    public Object f5292b;

    public Object f5293c;

    public C1552f0(int i6) {
        this.f5291a = i6;
    }

    public static C1552f0 m3814a(Resources resources, int i6, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        float f;
        float f3;
        float f4;
        int i10;
        Object radialGradient;
        Shader.TileMode tileMode;
        Shader.TileMode tileMode2;
        XmlResourceParser xml = resources.getXml(i6);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.getClass();
        Object obj = null;
        if (!name.equals("gradient")) {
            if (name.equals("selector")) {
                ColorStateList colorStateListM5330b = AbstractC2344c.m5330b(resources, xml, attributeSetAsAttributeSet, theme);
                return new C1552f0(obj, colorStateListM5330b.getDefaultColor(), colorStateListM5330b);
            }
            throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
        String name2 = xml.getName();
        if (!name2.equals("gradient")) {
            throw new XmlPullParserException(xml.getPositionDescription() + ": invalid gradient color tag " + name2);
        }
        TypedArray typedArrayM5322h = AbstractC2343b.m5322h(resources, theme, attributeSetAsAttributeSet, AbstractC1226a.f3913d);
        float f5 = !AbstractC2343b.m5319e(xml, "startX") ? 0.0f : typedArrayM5322h.getFloat(8, 0.0f);
        float f10 = !AbstractC2343b.m5319e(xml, "startY") ? 0.0f : typedArrayM5322h.getFloat(9, 0.0f);
        float f11 = !AbstractC2343b.m5319e(xml, "endX") ? 0.0f : typedArrayM5322h.getFloat(10, 0.0f);
        float f12 = !AbstractC2343b.m5319e(xml, "endY") ? 0.0f : typedArrayM5322h.getFloat(11, 0.0f);
        float f13 = !AbstractC2343b.m5319e(xml, "centerX") ? 0.0f : typedArrayM5322h.getFloat(3, 0.0f);
        float f14 = !AbstractC2343b.m5319e(xml, "centerY") ? 0.0f : typedArrayM5322h.getFloat(4, 0.0f);
        int i11 = !AbstractC2343b.m5319e(xml, SessionDescription.ATTR_TYPE) ? 0 : typedArrayM5322h.getInt(2, 0);
        int color = !AbstractC2343b.m5319e(xml, "startColor") ? 0 : typedArrayM5322h.getColor(0, 0);
        boolean zM5319e = AbstractC2343b.m5319e(xml, "centerColor");
        int color2 = !AbstractC2343b.m5319e(xml, "centerColor") ? 0 : typedArrayM5322h.getColor(7, 0);
        int color3 = !AbstractC2343b.m5319e(xml, "endColor") ? 0 : typedArrayM5322h.getColor(1, 0);
        int i12 = !AbstractC2343b.m5319e(xml, "tileMode") ? 0 : typedArrayM5322h.getInt(6, 0);
        float f15 = !AbstractC2343b.m5319e(xml, "gradientRadius") ? 0.0f : typedArrayM5322h.getFloat(5, 0.0f);
        typedArrayM5322h.recycle();
        int depth = xml.getDepth() + 1;
        float f16 = f15;
        ArrayList arrayList = new ArrayList(20);
        float f17 = f12;
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next2 = xml.next();
            f = f11;
            if (next2 == 1) {
                f3 = f10;
                break;
            }
            int depth2 = xml.getDepth();
            f3 = f10;
            if (depth2 < depth && next2 == 3) {
                break;
            }
            if (next2 == 2 && depth2 <= depth && xml.getName().equals("item")) {
                TypedArray typedArrayM5322h2 = AbstractC2343b.m5322h(resources, theme, attributeSetAsAttributeSet, AbstractC1226a.f3914e);
                boolean zHasValue = typedArrayM5322h2.hasValue(0);
                boolean zHasValue2 = typedArrayM5322h2.hasValue(1);
                if (!zHasValue || !zHasValue2) {
                    throw new XmlPullParserException(xml.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                int color4 = typedArrayM5322h2.getColor(0, 0);
                float f18 = typedArrayM5322h2.getFloat(1, 0.0f);
                typedArrayM5322h2.recycle();
                arrayList2.add(Integer.valueOf(color4));
                arrayList.add(Float.valueOf(f18));
            }
            f11 = f;
            f10 = f3;
        }
        C0069f c0069f = arrayList2.size() > 0 ? new C0069f(arrayList2, arrayList) : null;
        if (c0069f == null) {
            c0069f = zM5319e ? new C0069f(color, color2, color3) : new C0069f(color, color3);
        }
        if (i11 == 1) {
            float f19 = f13;
            i10 = 0;
            if (f16 <= 0.0f) {
                f4 = f14;
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            }
            if (i12 == 1) {
                f4 = f14;
                tileMode = Shader.TileMode.REPEAT;
            } else if (i12 != 2) {
                f4 = f14;
                tileMode = Shader.TileMode.CLAMP;
            } else {
                f4 = f14;
                tileMode = Shader.TileMode.MIRROR;
            }
            radialGradient = new RadialGradient(f19, f4, f16, (int[]) c0069f.f196b, (float[]) c0069f.f197c, tileMode);
        } else if (i11 != 2) {
            if (i12 != 1) {
                tileMode2 = i12 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
            } else {
                tileMode2 = Shader.TileMode.REPEAT;
            }
            Shader.TileMode tileMode3 = tileMode2;
            i10 = 0;
            radialGradient = new LinearGradient(f5, f3, f, f17, (int[]) c0069f.f196b, (float[]) c0069f.f197c, tileMode3);
        } else {
            i10 = 0;
            radialGradient = new SweepGradient(f13, f14, (int[]) c0069f.f196b, (float[]) c0069f.f197c);
        }
        return new C1552f0(radialGradient, i10, null);
    }

    public boolean m3815b() {
        ColorStateList colorStateList;
        return ((Shader) this.f5292b) == null && (colorStateList = (ColorStateList) this.f5293c) != null && colorStateList.isStateful();
    }

    @Override
    public void onSuccess(Object obj) {
        int i6 = 0;
        if (((Boolean) obj).booleanValue()) {
            C1575h3 c1575h3M3849n = C1585i3.m3849n((C1585i3) this.f5293c);
            C1678s1 c1678s1 = (C1678s1) this.f5292b;
            String str = c1678s1.f5607d;
            c1575h3M3849n.m3841c();
            C1585i3.m3859x((C1585i3) c1575h3M3849n.f5338b, str);
            c1575h3M3849n.m3841c();
            C1585i3.m3853r((C1585i3) c1575h3M3849n.f5338b, str);
            Long l9 = c1678s1.f5608e;
            if (l9 != null) {
                int iLongValue = (int) l9.longValue();
                c1575h3M3849n.m3841c();
                C1585i3.m3856u((C1585i3) c1575h3M3849n.f5338b, iLongValue);
            }
            C1585i3 c1585i3 = (C1585i3) c1575h3M3849n.m3839a();
            int i10 = c1678s1.f5612i;
            int i11 = i10 - 1;
            C4105a c4105a = null;
            if (i10 == 0) {
                throw null;
            }
            int i12 = this.f5291a;
            if (i11 == 0) {
                c4105a = new C4105a(Integer.valueOf(i12 - 1), c1585i3, EnumC4107c.f13926b);
            } else if (i11 == 1) {
                c4105a = new C4105a(Integer.valueOf(i12 - 1), c1585i3, EnumC4107c.f13925a);
            }
            C1678s1.f5602j.m7975b("analytics event: %s", c4105a);
            AbstractC1312l.m3198e(c4105a);
            C0026b c0026b = c1678s1.f5610g;
            if (c0026b != null) {
                C0060s c0060s = new C0060s(i6);
                C0051j c0051j = (C0051j) c0026b.f54b;
                C4106b c4106b = (C4106b) c0026b.f55c;
                C0061t c0061t = (C0061t) c0026b.f56d;
                C0026b c0026bM203a = C0051j.m203a();
                c0026bM203a.m121G(c0051j.f151a);
                c0026bM203a.f56d = c4105a.f13923c;
                c0026bM203a.f55c = c0051j.f152b;
                C0051j c0051jM130h = c0026bM203a.m130h();
                C0049h c0049h = new C0049h();
                c0049h.f144f = new HashMap();
                c0049h.f142d = Long.valueOf(c0061t.f171a.mo5893c());
                c0049h.f143e = Long.valueOf(c0061t.f172b.mo5893c());
                c0049h.f139a = "CAST_SENDER_SDK";
                C1585i3 c1585i4 = c4105a.f13922b;
                try {
                    int iM3870i = c1585i4.m3870i();
                    byte[] bArr = new byte[iM3870i];
                    C1539d7 c1539d7 = new C1539d7(bArr, iM3870i);
                    InterfaceC1520b8 interfaceC1520b8M4060a = C1738y7.f5738c.m4060a(C1585i3.class);
                    C1675r7 c1675r7 = c1539d7.f5249d;
                    if (c1675r7 == null) {
                        c1675r7 = new C1675r7(c1539d7);
                    }
                    interfaceC1520b8M4060a.mo3735a(c1585i4, c1675r7);
                    if (iM3870i - c1539d7.f5252g != 0) {
                        throw new IllegalStateException("Did not write as much data as expected.");
                    }
                    c0049h.f141c = new C0055n(c4106b, bArr);
                    c0049h.f140b = c4105a.f13921a;
                    C0050i c0050iM198c = c0049h.m198c();
                    C2611a c2611a = (C2611a) c0061t.f173c;
                    c2611a.getClass();
                    c2611a.f9086b.execute(new RunnableC0624i(c2611a, c0051jM130h, c0060s, c0050iM198c));
                } catch (IOException e5) {
                    throw new RuntimeException(AbstractC0004e.m24r("Serializing ", C1585i3.class.getName(), " to a byte array threw an IOException (should never happen)."), e5);
                }
            }
        }
    }

    public C1552f0(Object obj, int i6, Object obj2) {
        this.f5292b = obj;
        this.f5293c = obj2;
        this.f5291a = i6;
    }
}
