package org.bitspark.android.beans;

import androidx.annotation.Keep;
import com.nmmedit.protect.NativeUtil;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2796i;

@Keep
public class Menu implements ISeletor {
    private boolean isSelected;
    private final String name;

    static {
        NativeUtil.classesInit0(28);
    }

    public Menu(String str, boolean z7) {
        AbstractC2796i.m5785f(str, AbstractC0032a.m165s("IPf2lQ==\n", "Tpab8M/nP00=\n"));
        this.name = str;
        this.isSelected = z7;
    }

    public native String getName();

    @Override
    public native boolean isSelected();

    @Override
    public native void setSelected(boolean z7);
}
