package androidx.core.app;

import android.os.Build;
import android.widget.RemoteViews;

public final class C0320c0 extends AbstractC0337k0 {
    @Override
    public final void apply(InterfaceC0342n interfaceC0342n) {
        if (Build.VERSION.SDK_INT >= 24) {
            ((C0355t0) interfaceC0342n).f1546b.setStyle(AbstractC0317b0.m947a());
        }
    }

    @Override
    public final boolean displayCustomViewInline() {
        return true;
    }

    @Override
    public final String getClassName() {
        return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
    }

    @Override
    public final RemoteViews makeBigContentView(InterfaceC0342n interfaceC0342n) {
        if (Build.VERSION.SDK_INT >= 24) {
            return null;
        }
        this.mBuilder.getClass();
        this.mBuilder.getClass();
        return null;
    }

    @Override
    public final RemoteViews makeContentView(InterfaceC0342n interfaceC0342n) {
        if (Build.VERSION.SDK_INT >= 24) {
            return null;
        }
        this.mBuilder.getClass();
        return null;
    }

    @Override
    public final RemoteViews makeHeadsUpContentView(InterfaceC0342n interfaceC0342n) {
        if (Build.VERSION.SDK_INT >= 24) {
            return null;
        }
        this.mBuilder.getClass();
        this.mBuilder.getClass();
        return null;
    }
}
