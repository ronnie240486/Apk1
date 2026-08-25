package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.lzy.okgo.cache.CacheEntity;
import com.p2serv.android.p032ds.R;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p103j9.AbstractC2796i;
import p130m2.C3066n;
import p171q.C3388b;

public class C1498f {

    public final int f4825a;

    public final int f4826b;

    public int f4827c;

    public int f4828d;

    public int f4829e;

    public final Object f4830f;

    public final Object f4831g;

    public C1498f(C1497e c1497e) {
        this.f4825a = 0;
        this.f4830f = new Rect();
        this.f4831g = c1497e;
        Resources resources = c1497e.getResources();
        this.f4826b = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_inner_radius);
        this.f4827c = resources.getDimensionPixelOffset(R.dimen.cast_libraries_material_featurehighlight_inner_margin);
        this.f4828d = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_text_max_width);
        this.f4829e = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_text_horizontal_offset);
    }

    public void mo3611a(Object obj, Object obj2, Object obj3) {
        AbstractC2796i.m5785f(obj, CacheEntity.KEY);
        AbstractC2796i.m5785f(obj2, "oldValue");
    }

    public Object m3612b(Object obj) {
        AbstractC2796i.m5785f(obj, CacheEntity.KEY);
        synchronized (((C3388b) this.f4831g)) {
            C3066n c3066n = (C3066n) this.f4830f;
            c3066n.getClass();
            Object obj2 = c3066n.f10511a.get(obj);
            if (obj2 != null) {
                this.f4828d++;
                return obj2;
            }
            this.f4829e++;
            return null;
        }
    }

    public int m3613c() {
        int i6;
        synchronized (((C3388b) this.f4831g)) {
            i6 = this.f4826b;
        }
        return i6;
    }

    public Object m3614d(Object obj, Object obj2) {
        Object objPut;
        AbstractC2796i.m5785f(obj, CacheEntity.KEY);
        AbstractC2796i.m5785f(obj2, "value");
        synchronized (((C3388b) this.f4831g)) {
            this.f4827c += m3616f(obj, obj2);
            C3066n c3066n = (C3066n) this.f4830f;
            c3066n.getClass();
            objPut = c3066n.f10511a.put(obj, obj2);
            if (objPut != null) {
                this.f4827c -= m3616f(obj, objPut);
            }
        }
        if (objPut != null) {
            mo3611a(obj, objPut, obj2);
        }
        m3619i(this.f4826b);
        return objPut;
    }

    public Object m3615e(Object obj) {
        Object objRemove;
        AbstractC2796i.m5785f(obj, CacheEntity.KEY);
        synchronized (((C3388b) this.f4831g)) {
            C3066n c3066n = (C3066n) this.f4830f;
            c3066n.getClass();
            objRemove = c3066n.f10511a.remove(obj);
            if (objRemove != null) {
                this.f4827c -= m3616f(obj, objRemove);
            }
        }
        if (objRemove != null) {
            mo3611a(obj, objRemove, null);
        }
        return objRemove;
    }

    public int m3616f(Object obj, Object obj2) {
        int iMo3618h = mo3618h(obj, obj2);
        if (iMo3618h >= 0) {
            return iMo3618h;
        }
        throw new IllegalStateException(("Negative size: " + obj + '=' + obj2).toString());
    }

    public int m3617g() {
        int i6;
        synchronized (((C3388b) this.f4831g)) {
            i6 = this.f4827c;
        }
        return i6;
    }

    public int mo3618h(Object obj, Object obj2) {
        AbstractC2796i.m5785f(obj, CacheEntity.KEY);
        AbstractC2796i.m5785f(obj2, "value");
        return 1;
    }

    public void m3619i(int i6) {
        Object next;
        Object key;
        Object value;
        while (true) {
            synchronized (((C3388b) this.f4831g)) {
                try {
                    if (this.f4827c < 0 || (((C3066n) this.f4830f).f10511a.isEmpty() && this.f4827c != 0)) {
                        break;
                    }
                    if (this.f4827c > i6 && !((C3066n) this.f4830f).f10511a.isEmpty()) {
                        Set setEntrySet = ((C3066n) this.f4830f).f10511a.entrySet();
                        AbstractC2796i.m5784e(setEntrySet, "map.entries");
                        if (setEntrySet instanceof List) {
                            List list = (List) setEntrySet;
                            next = list.isEmpty() ? null : list.get(0);
                        } else {
                            Iterator it = setEntrySet.iterator();
                            if (it.hasNext()) {
                                next = it.next();
                            }
                        }
                        Map.Entry entry = (Map.Entry) next;
                        if (entry == null) {
                            return;
                        }
                        key = entry.getKey();
                        value = entry.getValue();
                        C3066n c3066n = (C3066n) this.f4830f;
                        c3066n.getClass();
                        AbstractC2796i.m5785f(key, CacheEntity.KEY);
                        c3066n.f10511a.remove(key);
                        this.f4827c -= m3616f(key, value);
                    }
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
            mo3611a(key, value, null);
        }
        throw new IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
    }

    public int m3620j(View view, int i6, int i10, int i11, int i12) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i13 = i12 - i6;
        int i14 = i10 - i12;
        int i15 = i12 - (i11 / 2);
        int i16 = this.f4829e;
        int i17 = i13 <= i14 ? i15 + i16 : i15 - i16;
        int i18 = marginLayoutParams.leftMargin;
        if (i17 - i18 < i6) {
            return i6 + i18;
        }
        int i19 = marginLayoutParams.rightMargin;
        return (i17 + i11) + i19 > i10 ? (i10 - i11) - i19 : i17;
    }

    public void m3621k(View view, int i6, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(Math.min((i6 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, this.f4828d), 1073741824), View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE));
    }

    public String toString() {
        String str;
        switch (this.f4825a) {
            case 1:
                synchronized (((C3388b) this.f4831g)) {
                    try {
                        int i6 = this.f4828d;
                        int i10 = this.f4829e + i6;
                        str = "LruCache[maxSize=" + this.f4826b + ",hits=" + this.f4828d + ",misses=" + this.f4829e + ",hitRate=" + (i10 != 0 ? (i6 * 100) / i10 : 0) + "%]";
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str;
            default:
                return super.toString();
        }
    }

    public C1498f(int i6) {
        this.f4825a = 1;
        this.f4826b = i6;
        if (i6 > 0) {
            this.f4830f = new C3066n();
            this.f4831g = new C3388b(0);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }
}
