package p106k0;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;

public final class C2853a {

    public final int f9766a;

    public final ContentProviderClient f9767b;

    public C2853a(Context context, Uri uri, int i6) {
        this.f9766a = i6;
        switch (i6) {
            case 1:
                this.f9767b = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                break;
            default:
                this.f9767b = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                break;
        }
    }

    public final void m5857a() {
        switch (this.f9766a) {
            case 0:
                ContentProviderClient contentProviderClient = this.f9767b;
                if (contentProviderClient != null) {
                    contentProviderClient.release();
                }
                break;
            default:
                ContentProviderClient contentProviderClient2 = this.f9767b;
                if (contentProviderClient2 != null) {
                    contentProviderClient2.release();
                }
                break;
        }
    }
}
