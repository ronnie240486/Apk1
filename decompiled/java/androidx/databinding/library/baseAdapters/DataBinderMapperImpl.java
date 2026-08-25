package androidx.databinding.library.baseAdapters;

import android.util.SparseIntArray;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import p237w0.AbstractC4041b;
import p237w0.AbstractC4044e;

public class DataBinderMapperImpl extends AbstractC4041b {

    public static final SparseIntArray f1703a = new SparseIntArray(0);

    @Override
    public final List mo1160a() {
        return new ArrayList(0);
    }

    @Override
    public final AbstractC4044e mo1158b(int i6, View view) {
        if (f1703a.get(i6) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
