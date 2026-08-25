package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public abstract int mo3683j();

    public abstract long mo3684l();

    public abstract String mo3685m();

    public final String toString() {
        return mo3684l() + "\t" + mo3683j() + "\t-1" + mo3685m();
    }
}
