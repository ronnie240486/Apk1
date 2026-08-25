package androidx.emoji2.text;

import android.content.Context;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.InterfaceC0555w;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import p005a4.C0052k;
import p014b1.C1235i;
import p014b1.C1236j;
import p014b1.C1242p;
import p238w1.C4046a;
import p238w1.InterfaceC4047b;

public class EmojiCompatInitializer implements InterfaceC4047b {
    @Override
    public final List mo1180a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override
    public final Object mo1181b(Context context) {
        C1242p c1242p = new C1242p(new C0052k(context));
        c1242p.f3957b = 1;
        if (C1235i.f3923j == null) {
            synchronized (C1235i.f3922i) {
                try {
                    if (C1235i.f3923j == null) {
                        C1235i.f3923j = new C1235i(c1242p);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        m1182c(context);
        return Boolean.TRUE;
    }

    public final void m1182c(Context context) {
        Object objM8052b;
        C4046a c4046aM8050c = C4046a.m8050c(context);
        c4046aM8050c.getClass();
        synchronized (C4046a.f13704e) {
            try {
                objM8052b = c4046aM8050c.f13705a.get(ProcessLifecycleInitializer.class);
                if (objM8052b == null) {
                    objM8052b = c4046aM8050c.m8052b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        AbstractC0541p abstractC0541pMo360f = ((InterfaceC0555w) objM8052b).mo360f();
        abstractC0541pMo360f.mo1508a(new C1236j(this, abstractC0541pMo360f));
    }
}
