package p249x4;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.media3.common.C0565C;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import java.util.concurrent.atomic.AtomicBoolean;

public final class HandlerC4114g extends HandlerC1731y0 {

    public final Context f13944b;

    public final C4109b f13945c;

    public HandlerC4114g(C4109b c4109b, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), 4);
        this.f13945c = c4109b;
        this.f13944b = context.getApplicationContext();
    }

    @Override
    public final void handleMessage(Message message) {
        PendingIntent activity;
        int i6 = message.what;
        if (i6 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i6);
            return;
        }
        int i10 = C4110c.f13934a;
        C4109b c4109b = this.f13945c;
        Context context = this.f13944b;
        int iM8129b = c4109b.m8129b(context, i10);
        AtomicBoolean atomicBoolean = AbstractC4111d.f13936a;
        if (iM8129b == 1 || iM8129b == 2 || iM8129b == 3 || iM8129b == 9) {
            Intent intentM8128a = c4109b.m8128a(context, iM8129b, "n");
            if (intentM8128a == null) {
                activity = null;
            } else {
                activity = PendingIntent.getActivity(context, 0, intentM8128a, Build.VERSION.SDK_INT >= 23 ? 201326592 : C0565C.BUFFER_FLAG_FIRST_SAMPLE);
            }
            c4109b.m8126f(context, iM8129b, activity);
        }
    }
}
