package p138n0;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.p2serv.android.p032ds.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;

public final class C3152r0 {

    public static final ArrayList f10636d = new ArrayList();

    public WeakHashMap f10637a;

    public SparseArray f10638b;

    public WeakReference f10639c;

    public final View m6322a(View view) {
        int size;
        WeakHashMap weakHashMap = this.f10637a;
        if (weakHashMap != null && weakHashMap.containsKey(view)) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View viewM6322a = m6322a(viewGroup.getChildAt(childCount));
                    if (viewM6322a != null) {
                        return viewM6322a;
                    }
                }
            }
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList != null && (size = arrayList.size() - 1) >= 0) {
                throw AbstractC0004e.m17k(size, arrayList);
            }
        }
        return null;
    }
}
