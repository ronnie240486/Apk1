package org.bitspark.android.beans;

import androidx.annotation.Keep;
import com.nmmedit.protect.NativeUtil;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2796i;

@Keep
public final class VodMenu extends Menu {
    private boolean isEnable;
    private boolean isSelected;
    private String name;

    static {
        NativeUtil.classesInit0(51);
    }

    public VodMenu(String str, boolean z7, boolean z10) {
        super(str, z7);
        AbstractC2796i.m5785f(str, AbstractC0032a.m165s("+HKAoA==\n", "lhPtxWvaq5Y=\n"));
        this.name = str;
        this.isSelected = z7;
        this.isEnable = z10;
    }

    public static VodMenu copy$default(VodMenu vodMenu, String str, boolean z7, boolean z10, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = vodMenu.name;
        }
        if ((i6 & 2) != 0) {
            z7 = vodMenu.isSelected;
        }
        if ((i6 & 4) != 0) {
            z10 = vodMenu.isEnable;
        }
        return vodMenu.copy(str, z7, z10);
    }

    public final native String component1();

    public final native boolean component2();

    public final native boolean component3();

    public final native VodMenu copy(String str, boolean z7, boolean z10);

    public native boolean equals(Object obj);

    @Override
    public native String getName();

    public native int hashCode();

    public final native boolean isEnable();

    @Override
    public native boolean isSelected();

    public final native void setEnable(boolean z7);

    public native void setName(String str);

    @Override
    public native void setSelected(boolean z7);

    public native String toString();
}
