package p205t;

import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

public final class C3764j {

    public static final HashMap f12617b;

    public final HashMap f12618a = new HashMap();

    static {
        HashMap map = new HashMap();
        f12617b = map;
        try {
            map.put("KeyAttribute", AbstractC3748b.class.getConstructor(null));
            map.put("KeyPosition", AbstractC3766k.class.getConstructor(null));
            map.put("KeyCycle", AbstractC3750c.class.getConstructor(null));
            map.put("KeyTimeCycle", AbstractC3768l.class.getConstructor(null));
            map.put("KeyTrigger", AbstractC3770m.class.getConstructor(null));
        } catch (NoSuchMethodException e5) {
            Log.e("KeyFrames", "unable to load", e5);
        }
    }

    public C3764j(XmlResourceParser xmlResourceParser) {
        try {
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlResourceParser.getName();
                    HashMap map = f12617b;
                    if (map.containsKey(name)) {
                        try {
                            if (((Constructor) map.get(name)).newInstance(null) != null) {
                                throw new ClassCastException();
                            }
                            Xml.asAttributeSet(xmlResourceParser);
                            throw null;
                        } catch (Exception e5) {
                            Log.e("KeyFrames", "unable to create ", e5);
                            eventType = xmlResourceParser.next();
                        }
                    } else {
                        name.equalsIgnoreCase("CustomAttribute");
                    }
                } else if (eventType == 3 && "KeyFrameSet".equals(xmlResourceParser.getName())) {
                    return;
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    public final void m7511a(C3774o c3774o) {
        HashMap map = this.f12618a;
        ArrayList arrayList = (ArrayList) map.get(Integer.valueOf(c3774o.f12649b));
        if (arrayList != null) {
            c3774o.f12668u.addAll(arrayList);
        }
        ArrayList arrayList2 = (ArrayList) map.get(-1);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            if (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
                String str = ((ConstraintLayout.LayoutParams) c3774o.f12648a.getLayoutParams()).f1335U;
                throw null;
            }
        }
    }
}
