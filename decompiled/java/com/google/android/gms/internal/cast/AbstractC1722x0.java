package com.google.android.gms.internal.cast;

import android.os.Build;
import androidx.media3.common.C0565C;

public abstract class AbstractC1722x0 {

    public static final int f5722a;

    static {
        f5722a = Build.VERSION.SDK_INT >= 23 ? C0565C.BUFFER_FLAG_NOT_DEPENDED_ON : 0;
    }
}
