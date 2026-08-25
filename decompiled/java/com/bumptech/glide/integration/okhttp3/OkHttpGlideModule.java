package com.bumptech.glide.integration.okhttp3;

import android.content.Context;
import com.bumptech.glide.C1467e;
import com.bumptech.glide.C1472j;
import okhttp3.OkHttpClient;
import p121l3.InterfaceC2971a;
import p218u2.C3891b;

@Deprecated
public class OkHttpGlideModule implements InterfaceC2971a {
    @Override
    public final void mo3519a(C1472j c1472j) {
        if (C3891b.f13082b == null) {
            synchronized (C3891b.class) {
                try {
                    if (C3891b.f13082b == null) {
                        C3891b.f13082b = new OkHttpClient();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        c1472j.m3532l(new C3891b(C3891b.f13082b));
    }

    @Override
    public final void mo3520b(Context context, C1467e c1467e) {
    }
}
