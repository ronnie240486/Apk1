package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public final class C0354t extends AbstractC0337k0 {

    public final int f1543a;

    public Object f1544b;

    public C0354t(int i6) {
        this.f1543a = i6;
        switch (i6) {
            case 1:
                this.f1544b = new ArrayList();
                break;
        }
    }

    @Override
    public final void apply(InterfaceC0342n interfaceC0342n) {
        switch (this.f1543a) {
            case 0:
                Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(((C0355t0) interfaceC0342n).f1546b).setBigContentTitle(this.mBigContentTitle).bigText((CharSequence) this.f1544b);
                if (this.mSummaryTextSet) {
                    bigTextStyleBigText.setSummaryText(this.mSummaryText);
                }
                break;
            default:
                Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(((C0355t0) interfaceC0342n).f1546b).setBigContentTitle(this.mBigContentTitle);
                if (this.mSummaryTextSet) {
                    bigContentTitle.setSummaryText(this.mSummaryText);
                }
                Iterator it = ((ArrayList) this.f1544b).iterator();
                while (it.hasNext()) {
                    bigContentTitle.addLine((CharSequence) it.next());
                }
                break;
        }
    }

    @Override
    public final void clearCompatExtraKeys(Bundle bundle) {
        switch (this.f1543a) {
            case 0:
                super.clearCompatExtraKeys(bundle);
                bundle.remove("android.bigText");
                break;
            default:
                super.clearCompatExtraKeys(bundle);
                bundle.remove("android.textLines");
                break;
        }
    }

    @Override
    public final String getClassName() {
        switch (this.f1543a) {
            case 0:
                return "androidx.core.app.NotificationCompat$BigTextStyle";
            default:
                return "androidx.core.app.NotificationCompat$InboxStyle";
        }
    }

    @Override
    public final void restoreFromCompatExtras(Bundle bundle) {
        switch (this.f1543a) {
            case 0:
                super.restoreFromCompatExtras(bundle);
                this.f1544b = bundle.getCharSequence("android.bigText");
                break;
            default:
                super.restoreFromCompatExtras(bundle);
                ArrayList arrayList = (ArrayList) this.f1544b;
                arrayList.clear();
                if (bundle.containsKey("android.textLines")) {
                    Collections.addAll(arrayList, bundle.getCharSequenceArray("android.textLines"));
                }
                break;
        }
    }
}
