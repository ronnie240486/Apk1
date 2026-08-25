package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import java.util.List;
import p001a0.C0019b;
import p012b.C1224a;
import p109k3.C2888t;
import p141n3.C3191e;
import p160p.C3341e;
import p221u6.C3905e;
import p247x2.C4090l;
import p249x4.C4112e;
import p259y2.C4243f;

public final class C1468f extends ContextWrapper {

    public static final C1463a f4430k = new C1463a();

    public final C4243f f4431a;

    public final C1224a f4432b;

    public final C4112e f4433c;

    public final C3905e f4434d;

    public final List f4435e;

    public final C3341e f4436f;

    public final C4090l f4437g;

    public final C0019b f4438h;

    public final int f4439i;

    public C3191e f4440j;

    public C1468f(Context context, C4243f c4243f, C2888t c2888t, C4112e c4112e, C3905e c3905e, C3341e c3341e, List list, C4090l c4090l, C0019b c0019b, int i6) {
        super(context.getApplicationContext());
        this.f4431a = c4243f;
        this.f4433c = c4112e;
        this.f4434d = c3905e;
        this.f4435e = list;
        this.f4436f = c3341e;
        this.f4437g = c4090l;
        this.f4438h = c0019b;
        this.f4439i = i6;
        this.f4432b = new C1224a(c2888t);
    }

    public final synchronized C3191e m3517a() {
        try {
            if (this.f4440j == null) {
                this.f4434d.getClass();
                C3191e c3191e = new C3191e();
                c3191e.f10701o = true;
                this.f4440j = c3191e;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f4440j;
    }

    public final C1472j m3518b() {
        return (C1472j) this.f4432b.get();
    }
}
