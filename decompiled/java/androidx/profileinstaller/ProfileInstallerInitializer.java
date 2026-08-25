package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.appcompat.app.RunnableC0147m0;
import java.util.Collections;
import java.util.List;
import p171q.C3388b;
import p207t1.AbstractC3794f;
import p238w1.InterfaceC4047b;

public class ProfileInstallerInitializer implements InterfaceC4047b {
    @Override
    public final List mo1180a() {
        return Collections.emptyList();
    }

    @Override
    public final Object mo1181b(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new C3388b(4);
        }
        AbstractC3794f.m7563a(new RunnableC0147m0(this, 17, context.getApplicationContext()));
        return new C3388b(4);
    }
}
