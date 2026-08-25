package p001a0;

import android.view.View;
import java.io.File;
import java.util.Comparator;
import java.util.WeakHashMap;
import org.bitspark.android.beans.GroupBeanModel;
import p015b2.C1255g;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p196s1.C3691a;
import p215u.C3886i;

public final class C0022e implements Comparator {

    public final int f42a;

    public C0022e(int i6) {
        this.f42a = i6;
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        switch (this.f42a) {
            case 0:
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                float fM6174m = AbstractC3119g0.m6174m((View) obj);
                float fM6174m2 = AbstractC3119g0.m6174m((View) obj2);
                if (fM6174m > fM6174m2) {
                    return -1;
                }
                return fM6174m < fM6174m2 ? 1 : 0;
            case 1:
                return ((C1255g) obj).f3979b - ((C1255g) obj2).f3979b;
            case 2:
                return ((View) obj).getTop() - ((View) obj2).getTop();
            case 3:
                return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
            case 4:
                return Integer.compare(((GroupBeanModel) obj).group_id, ((GroupBeanModel) obj2).group_id);
            case 5:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            case 6:
                return ((C3691a) obj2).m7443b() - ((C3691a) obj).m7443b();
            case 7:
                if (obj != null) {
                    throw new ClassCastException();
                }
                obj2.getClass();
                throw new ClassCastException();
            default:
                return ((C3886i) obj).f13052b - ((C3886i) obj2).f13052b;
        }
    }
}
