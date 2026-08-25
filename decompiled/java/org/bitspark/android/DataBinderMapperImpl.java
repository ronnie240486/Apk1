package org.bitspark.android;

import android.util.SparseIntArray;
import android.view.View;
import com.nmmedit.protect.NativeUtil;
import com.p2serv.android.p032ds.R;
import java.util.List;
import p237w0.AbstractC4041b;
import p237w0.AbstractC4044e;

public class DataBinderMapperImpl extends AbstractC4041b {

    public static final SparseIntArray f11001a;

    @Override
    public final native List mo1160a();

    @Override
    public final native AbstractC4044e mo1158b(int i6, View view);

    static {
        NativeUtil.classesInit0(50);
        SparseIntArray sparseIntArray = new SparseIntArray(11);
        f11001a = sparseIntArray;
        sparseIntArray.put(R.layout.item_brand_rectangle, 1);
        sparseIntArray.put(R.layout.item_live_setting, 2);
        sparseIntArray.put(R.layout.item_live_setting_select, 3);
        sparseIntArray.put(R.layout.item_live_setting_subtitle, 4);
        sparseIntArray.put(R.layout.item_live_setting_subtitle_location, 5);
        sparseIntArray.put(R.layout.item_live_setting_subtitle_title, 6);
        sparseIntArray.put(R.layout.layout_live_setting_container, 7);
        sparseIntArray.put(R.layout.view_live_setting_fullscreen, 8);
        sparseIntArray.put(R.layout.view_live_setting_main, 9);
        sparseIntArray.put(R.layout.view_live_setting_source, 10);
        sparseIntArray.put(R.layout.view_live_setting_subtitle, 11);
    }
}
