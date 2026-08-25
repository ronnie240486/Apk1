package org.bitspark.android.beans;

import androidx.annotation.Keep;
import com.nmmedit.protect.NativeUtil;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2796i;

@Keep
public final class SpeedBean extends Menu {
    private boolean isSelected;
    private String name;
    private float speed;

    static {
        NativeUtil.classesInit0(43);
    }

    public SpeedBean(String str, float f, boolean z7) {
        super(str, z7);
        AbstractC2796i.m5785f(str, AbstractC0032a.m165s("ZmlJpg==\n", "CAgkw+7Bxpw=\n"));
        this.name = str;
        this.speed = f;
        this.isSelected = z7;
    }

    public static SpeedBean copy$default(SpeedBean speedBean, String str, float f, boolean z7, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = speedBean.name;
        }
        if ((i6 & 2) != 0) {
            f = speedBean.speed;
        }
        if ((i6 & 4) != 0) {
            z7 = speedBean.isSelected;
        }
        return speedBean.copy(str, f, z7);
    }

    public final native String component1();

    public final native float component2();

    public final native boolean component3();

    public final native SpeedBean copy(String str, float f, boolean z7);

    public native boolean equals(Object obj);

    @Override
    public native String getName();

    public final native float getSpeed();

    public native int hashCode();

    @Override
    public native boolean isSelected();

    public native void setName(String str);

    @Override
    public native void setSelected(boolean z7);

    public final native void setSpeed(float f);

    public native String toString();
}
