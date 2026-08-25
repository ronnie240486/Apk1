package p206t0;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import androidx.appcompat.widget.ViewOnClickListenerC0204f3;

public final class C3787a extends ContentObserver {

    public final ViewOnClickListenerC0204f3 f12749a;

    public C3787a(ViewOnClickListenerC0204f3 viewOnClickListenerC0204f3) {
        super(new Handler());
        this.f12749a = viewOnClickListenerC0204f3;
    }

    @Override
    public final boolean deliverSelfNotifications() {
        return true;
    }

    @Override
    public final void onChange(boolean z7) {
        Cursor cursor;
        ViewOnClickListenerC0204f3 viewOnClickListenerC0204f3 = this.f12749a;
        if (!viewOnClickListenerC0204f3.f12751b || (cursor = viewOnClickListenerC0204f3.f12752c) == null || cursor.isClosed()) {
            return;
        }
        viewOnClickListenerC0204f3.f12750a = viewOnClickListenerC0204f3.f12752c.requery();
    }
}
