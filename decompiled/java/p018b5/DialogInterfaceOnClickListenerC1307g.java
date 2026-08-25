package p018b5;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiActivity;

public final class DialogInterfaceOnClickListenerC1307g implements DialogInterface.OnClickListener {

    public final int f4088a;

    public final Intent f4089b;

    public final Object f4090c;

    public DialogInterfaceOnClickListenerC1307g(Intent intent, Object obj, int i6) {
        this.f4088a = i6;
        this.f4089b = intent;
        this.f4090c = obj;
    }

    public final void m3185a() {
        switch (this.f4088a) {
            case 0:
                Intent intent = this.f4089b;
                if (intent != null) {
                    ((GoogleApiActivity) this.f4090c).startActivityForResult(intent, 2);
                }
                break;
            default:
                Intent intent2 = this.f4089b;
                if (intent2 != null) {
                    this.f4090c.m8365a(intent2, 2);
                }
                break;
        }
    }

    @Override
    public final void onClick(DialogInterface dialogInterface, int i6) {
        try {
            try {
                m3185a();
            } catch (ActivityNotFoundException e5) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e5);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
