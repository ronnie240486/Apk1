package p259y2;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import p055ea.AbstractC2460q;
import p124l6.C2982h;
import p186r3.AbstractC3610n;

public final class C4248k {

    public static final Bitmap.Config[] f14426d;

    public static final Bitmap.Config[] f14427e;

    public static final Bitmap.Config[] f14428f;

    public static final Bitmap.Config[] f14429g;

    public static final Bitmap.Config[] f14430h;

    public final C4242e f14431a = new C4242e(1);

    public final C2982h f14432b = new C2982h(13);

    public final HashMap f14433c = new HashMap();

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f14426d = configArr;
        f14427e = configArr;
        f14428f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f14429g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f14430h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String m8296c(int i6, Bitmap.Config config) {
        return "[" + i6 + "](" + config + ")";
    }

    public final void m8297a(Integer num, Bitmap bitmap) {
        NavigableMap navigableMapM8299d = m8299d(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapM8299d.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapM8299d.remove(num);
                return;
            } else {
                navigableMapM8299d.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + m8296c(AbstractC3610n.m7235c(bitmap), bitmap.getConfig()) + ", this: " + this);
    }

    public final Bitmap m8298b(int i6, int i10, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int iM7236d = AbstractC3610n.m7236d(config) * i6 * i10;
        C4242e c4242e = this.f14431a;
        InterfaceC4245h interfaceC4245hM8283e = (InterfaceC4245h) ((ArrayDeque) c4242e.f7850a).poll();
        if (interfaceC4245hM8283e == null) {
            interfaceC4245hM8283e = c4242e.m8283e();
        }
        C4247j c4247j = (C4247j) interfaceC4245hM8283e;
        c4247j.f14424b = iM7236d;
        c4247j.f14425c = config;
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
            int i11 = AbstractC4246i.f14422a[config.ordinal()];
            if (i11 == 1) {
                configArr = f14426d;
            } else if (i11 == 2) {
                configArr = f14428f;
            } else if (i11 != 3) {
                configArr = i11 != 4 ? new Bitmap.Config[]{config} : f14430h;
            } else {
                configArr = f14429g;
            }
        } else {
            configArr = f14427e;
        }
        for (Bitmap.Config config2 : configArr) {
            Integer num = (Integer) m8299d(config2).ceilingKey(Integer.valueOf(iM7236d));
            if (num != null && num.intValue() <= iM7236d * 8) {
                if (num.intValue() == iM7236d && (config2 != null ? config2.equals(config) : config == null)) {
                    break;
                    break;
                }
                c4242e.m5119c(c4247j);
                int iIntValue = num.intValue();
                InterfaceC4245h interfaceC4245hM8283e2 = (InterfaceC4245h) ((ArrayDeque) c4242e.f7850a).poll();
                if (interfaceC4245hM8283e2 == null) {
                    interfaceC4245hM8283e2 = c4242e.m8283e();
                }
                c4247j = (C4247j) interfaceC4245hM8283e2;
                c4247j.f14424b = iIntValue;
                c4247j.f14425c = config2;
                break;
            }
        }
        Bitmap bitmap = (Bitmap) this.f14432b.m6044q(c4247j);
        if (bitmap != null) {
            m8297a(Integer.valueOf(c4247j.f14424b), bitmap);
            bitmap.reconfigure(i6, i10, config);
        }
        return bitmap;
    }

    public final NavigableMap m8299d(Bitmap.Config config) {
        HashMap map = this.f14433c;
        NavigableMap navigableMap = (NavigableMap) map.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        map.put(config, treeMap);
        return treeMap;
    }

    public final void m8300e(Bitmap bitmap) {
        int iM7235c = AbstractC3610n.m7235c(bitmap);
        Bitmap.Config config = bitmap.getConfig();
        C4242e c4242e = this.f14431a;
        InterfaceC4245h interfaceC4245hM8283e = (InterfaceC4245h) ((ArrayDeque) c4242e.f7850a).poll();
        if (interfaceC4245hM8283e == null) {
            interfaceC4245hM8283e = c4242e.m8283e();
        }
        C4247j c4247j = (C4247j) interfaceC4245hM8283e;
        c4247j.f14424b = iM7235c;
        c4247j.f14425c = config;
        this.f14432b.m6052y(c4247j, bitmap);
        NavigableMap navigableMapM8299d = m8299d(bitmap.getConfig());
        Integer num = (Integer) navigableMapM8299d.get(Integer.valueOf(c4247j.f14424b));
        navigableMapM8299d.put(Integer.valueOf(c4247j.f14424b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public final String toString() {
        StringBuilder sbM5498l = AbstractC2460q.m5498l("SizeConfigStrategy{groupedMap=");
        sbM5498l.append(this.f14432b);
        sbM5498l.append(", sortedSizes=(");
        HashMap map = this.f14433c;
        for (Map.Entry entry : map.entrySet()) {
            sbM5498l.append(entry.getKey());
            sbM5498l.append('[');
            sbM5498l.append(entry.getValue());
            sbM5498l.append("], ");
        }
        if (!map.isEmpty()) {
            sbM5498l.replace(sbM5498l.length() - 2, sbM5498l.length(), "");
        }
        sbM5498l.append(")}");
        return sbM5498l.toString();
    }
}
