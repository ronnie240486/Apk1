package p093j;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import androidx.appcompat.widget.AbstractC0237m1;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import p002a1.C0026b;
import p045e.AbstractC2341a;
import p105k.ActionProviderVisibilityListenerC2841o;
import p105k.MenuC2838l;
import p138n0.AbstractC3106c;

public final class C2748i extends MenuInflater {

    public static final Class[] f9457e;

    public static final Class[] f9458f;

    public final Object[] f9459a;

    public final Object[] f9460b;

    public final Context f9461c;

    public Object f9462d;

    static {
        Class[] clsArr = {Context.class};
        f9457e = clsArr;
        f9458f = clsArr;
    }

    public C2748i(Context context) {
        super(context);
        this.f9461c = context;
        Object[] objArr = {context};
        this.f9459a = objArr;
        this.f9460b = objArr;
    }

    public static Object m5712a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m5712a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public final void m5713b(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        ?? r10;
        int i6;
        ColorStateList colorStateList;
        C2747h c2747h = new C2747h(this, menu);
        int eventType = xmlResourceParser.getEventType();
        do {
            r10 = 1;
            i6 = 2;
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlResourceParser.next();
                break;
            }
            eventType = xmlResourceParser.next();
        } while (eventType != 1);
        boolean z7 = false;
        boolean z10 = false;
        String str = null;
        while (!z7) {
            if (eventType == r10) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != i6) {
                if (eventType == 3) {
                    String name2 = xmlResourceParser.getName();
                    if (z10 && name2.equals(str)) {
                        z10 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        c2747h.f9432b = 0;
                        c2747h.f9433c = 0;
                        c2747h.f9434d = 0;
                        c2747h.f9435e = 0;
                        c2747h.f9436f = r10;
                        c2747h.f9437g = r10;
                    } else if (name2.equals("item")) {
                        if (!c2747h.f9438h) {
                            AbstractC3106c abstractC3106c = c2747h.f9456z;
                            if (abstractC3106c == null || !((ActionProviderVisibilityListenerC2841o) abstractC3106c).f9743b.hasSubMenu()) {
                                c2747h.f9438h = r10;
                                c2747h.m5711b(c2747h.f9431a.add(c2747h.f9432b, c2747h.f9439i, c2747h.f9440j, c2747h.f9441k));
                            } else {
                                c2747h.f9438h = r10;
                                c2747h.m5711b(c2747h.f9431a.addSubMenu(c2747h.f9432b, c2747h.f9439i, c2747h.f9440j, c2747h.f9441k).getItem());
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z7 = true;
                    }
                }
            } else if (!z10) {
                String name3 = xmlResourceParser.getName();
                boolean zEquals = name3.equals("group");
                C2748i c2748i = c2747h.f9430E;
                if (zEquals) {
                    TypedArray typedArrayObtainStyledAttributes = c2748i.f9461c.obtainStyledAttributes(attributeSet, AbstractC2341a.f8169q);
                    c2747h.f9432b = typedArrayObtainStyledAttributes.getResourceId(r10, 0);
                    c2747h.f9433c = typedArrayObtainStyledAttributes.getInt(3, 0);
                    c2747h.f9434d = typedArrayObtainStyledAttributes.getInt(4, 0);
                    c2747h.f9435e = typedArrayObtainStyledAttributes.getInt(5, 0);
                    c2747h.f9436f = typedArrayObtainStyledAttributes.getBoolean(2, r10);
                    c2747h.f9437g = typedArrayObtainStyledAttributes.getBoolean(0, r10);
                    typedArrayObtainStyledAttributes.recycle();
                } else if (name3.equals("item")) {
                    C0026b c0026bM110B = C0026b.m110B(c2748i.f9461c, attributeSet, AbstractC2341a.f8170r);
                    TypedArray typedArray = (TypedArray) c0026bM110B.f55c;
                    c2747h.f9439i = typedArray.getResourceId(2, 0);
                    c2747h.f9440j = (typedArray.getInt(5, c2747h.f9433c) & (-65536)) | (typedArray.getInt(6, c2747h.f9434d) & 65535);
                    c2747h.f9441k = typedArray.getText(7);
                    c2747h.f9442l = typedArray.getText(8);
                    c2747h.f9443m = typedArray.getResourceId(0, 0);
                    String string = typedArray.getString(9);
                    c2747h.f9444n = string == null ? (char) 0 : string.charAt(0);
                    c2747h.f9445o = typedArray.getInt(16, 4096);
                    String string2 = typedArray.getString(10);
                    c2747h.f9446p = string2 == null ? (char) 0 : string2.charAt(0);
                    c2747h.f9447q = typedArray.getInt(20, 4096);
                    if (typedArray.hasValue(11)) {
                        c2747h.f9448r = typedArray.getBoolean(11, false) ? 1 : 0;
                    } else {
                        c2747h.f9448r = c2747h.f9435e;
                    }
                    c2747h.f9449s = typedArray.getBoolean(3, false);
                    c2747h.f9450t = typedArray.getBoolean(4, c2747h.f9436f);
                    c2747h.f9451u = typedArray.getBoolean(1, c2747h.f9437g);
                    c2747h.f9452v = typedArray.getInt(21, -1);
                    c2747h.f9455y = typedArray.getString(12);
                    c2747h.f9453w = typedArray.getResourceId(13, 0);
                    c2747h.f9454x = typedArray.getString(15);
                    String string3 = typedArray.getString(14);
                    boolean z11 = string3 != null;
                    if (z11 && c2747h.f9453w == 0 && c2747h.f9454x == null) {
                        c2747h.f9456z = (AbstractC3106c) c2747h.m5710a(string3, f9458f, c2748i.f9460b);
                    } else {
                        if (z11) {
                            Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                        }
                        c2747h.f9456z = null;
                    }
                    c2747h.f9426A = typedArray.getText(17);
                    c2747h.f9427B = typedArray.getText(22);
                    if (typedArray.hasValue(19)) {
                        c2747h.f9429D = AbstractC0237m1.m737c(typedArray.getInt(19, -1), c2747h.f9429D);
                        colorStateList = null;
                    } else {
                        colorStateList = null;
                        c2747h.f9429D = null;
                    }
                    if (typedArray.hasValue(18)) {
                        c2747h.f9428C = c0026bM110B.m139s(18);
                    } else {
                        c2747h.f9428C = colorStateList;
                    }
                    c0026bM110B.m120F();
                    c2747h.f9438h = false;
                } else if (name3.equals("menu")) {
                    c2747h.f9438h = true;
                    SubMenu subMenuAddSubMenu = c2747h.f9431a.addSubMenu(c2747h.f9432b, c2747h.f9439i, c2747h.f9440j, c2747h.f9441k);
                    c2747h.m5711b(subMenuAddSubMenu.getItem());
                    m5713b(xmlResourceParser, attributeSet, subMenuAddSubMenu);
                } else {
                    str = name3;
                    z10 = true;
                }
            }
            eventType = xmlResourceParser.next();
            r10 = 1;
            i6 = 2;
        }
    }

    @Override
    public final void inflate(int i6, Menu menu) {
        if (!(menu instanceof MenuC2838l)) {
            super.inflate(i6, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f9461c.getResources().getLayout(i6);
                    m5713b(layout, Xml.asAttributeSet(layout), menu);
                    layout.close();
                } catch (IOException e5) {
                    throw new InflateException("Error inflating menu XML", e5);
                }
            } catch (XmlPullParserException e10) {
                throw new InflateException("Error inflating menu XML", e10);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
