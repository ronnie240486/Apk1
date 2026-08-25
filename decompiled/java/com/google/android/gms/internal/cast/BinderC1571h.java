package com.google.android.gms.internal.cast;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p230v4.C3988b;

public final class BinderC1571h extends AbstractBinderC1611l {

    public static final C3988b f5329g = new C3988b("AppVisibilityProxy", null);

    public static final int f5330h = 1;

    public final Set f5331e;

    public int f5332f;

    public BinderC1571h() {
        super("com.google.android.gms.cast.framework.IAppVisibilityListener", 1);
        this.f5331e = Collections.synchronizedSet(new HashSet());
        this.f5332f = f5330h;
    }
}
