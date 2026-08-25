package com.tencent.bugly.proguard;

import java.io.File;
import java.io.FilenameFilter;

public final class C2071d0 implements FilenameFilter {

    public final String f7595a;

    public final String f7596b;

    public C2071d0(String str, String str2) {
        this.f7595a = str;
        this.f7596b = str2;
    }

    @Override
    public final boolean accept(File file, String str) {
        return str != null && str.startsWith(this.f7595a) && str.endsWith(this.f7596b);
    }
}
