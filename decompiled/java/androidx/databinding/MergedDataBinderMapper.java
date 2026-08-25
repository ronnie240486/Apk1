package androidx.databinding;

import android.util.Log;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p237w0.AbstractC4041b;
import p237w0.AbstractC4044e;

public class MergedDataBinderMapper extends AbstractC4041b {

    public final HashSet f1691a = new HashSet();

    public final CopyOnWriteArrayList f1692b = new CopyOnWriteArrayList();

    public final CopyOnWriteArrayList f1693c = new CopyOnWriteArrayList();

    @Override
    public final AbstractC4044e mo1158b(int i6, View view) {
        Iterator it = this.f1692b.iterator();
        while (it.hasNext()) {
            AbstractC4044e abstractC4044eMo1158b = ((AbstractC4041b) it.next()).mo1158b(i6, view);
            if (abstractC4044eMo1158b != null) {
                return abstractC4044eMo1158b;
            }
        }
        CopyOnWriteArrayList<String> copyOnWriteArrayList = this.f1693c;
        boolean z7 = false;
        for (String str : copyOnWriteArrayList) {
            try {
                Class<?> cls = Class.forName(str);
                if (AbstractC4041b.class.isAssignableFrom(cls)) {
                    m1159c((AbstractC4041b) cls.newInstance());
                    copyOnWriteArrayList.remove(str);
                    z7 = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e5) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e5);
            } catch (InstantiationException e10) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e10);
            }
        }
        if (z7) {
            return mo1158b(i6, view);
        }
        return null;
    }

    public final void m1159c(AbstractC4041b abstractC4041b) {
        if (this.f1691a.add(abstractC4041b.getClass())) {
            this.f1692b.add(abstractC4041b);
            Iterator it = abstractC4041b.mo1160a().iterator();
            while (it.hasNext()) {
                m1159c((AbstractC4041b) it.next());
            }
        }
    }
}
