package org.bitspark.android.beans;

import androidx.annotation.Keep;
import com.nmmedit.protect.NativeUtil;
import java.util.List;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2796i;

@Keep
public final class SeasonMenu extends Menu {
    private boolean isSelected;
    private String name;
    private final List<ChannelBean.SourcesBean> sourceList;

    static {
        NativeUtil.classesInit0(44);
    }

    public SeasonMenu(String str, boolean z7, List<? extends ChannelBean.SourcesBean> list) {
        super(str, z7);
        AbstractC2796i.m5785f(str, AbstractC0032a.m165s("mUQYDg==\n", "9yV1a8bMmTk=\n"));
        AbstractC2796i.m5785f(list, AbstractC0032a.m165s("a3L0F3Qk2/VraQ==\n", "GB2BZRdBl5w=\n"));
        this.name = str;
        this.isSelected = z7;
        this.sourceList = list;
    }

    public static SeasonMenu copy$default(SeasonMenu seasonMenu, String str, boolean z7, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = seasonMenu.name;
        }
        if ((i6 & 2) != 0) {
            z7 = seasonMenu.isSelected;
        }
        if ((i6 & 4) != 0) {
            list = seasonMenu.sourceList;
        }
        return seasonMenu.copy(str, z7, list);
    }

    public final native String component1();

    public final native boolean component2();

    public final native List<ChannelBean.SourcesBean> component3();

    public final native SeasonMenu copy(String str, boolean z7, List<? extends ChannelBean.SourcesBean> list);

    public native boolean equals(Object obj);

    @Override
    public native String getName();

    public final native List<ChannelBean.SourcesBean> getSourceList();

    public native int hashCode();

    @Override
    public native boolean isSelected();

    public native void setName(String str);

    @Override
    public native void setSelected(boolean z7);

    public native String toString();
}
