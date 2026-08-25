package androidx.core.app;

import android.content.Intent;

public final class C0334j implements InterfaceC0336k {

    public final Intent f1511a;

    public final int f1512b;

    public final JobIntentService f1513c;

    public C0334j(JobIntentService jobIntentService, Intent intent, int i6) {
        this.f1513c = jobIntentService;
        this.f1511a = intent;
        this.f1512b = i6;
    }

    @Override
    public final void mo972a() {
        this.f1513c.stopSelf(this.f1512b);
    }

    @Override
    public final Intent getIntent() {
        return this.f1511a;
    }
}
