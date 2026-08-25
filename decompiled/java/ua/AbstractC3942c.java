package ua;

import org.greenrobot.eventbus.ThreadMode;

public abstract class AbstractC3942c {

    public static final int[] f13244a;

    static {
        int[] iArr = new int[ThreadMode.values().length];
        f13244a = iArr;
        try {
            iArr[ThreadMode.POSTING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f13244a[ThreadMode.MAIN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f13244a[ThreadMode.BACKGROUND.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f13244a[ThreadMode.ASYNC.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
