package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import p000a.AbstractC0004e;
import p018b5.AbstractC1312l;
import p249x4.C4109b;
import p271z4.C4334e;

@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    public static final int f4987b = 0;

    public int f4988a = 0;

    @Override
    public final void onActivityResult(int i6, int i10, Intent intent) {
        super.onActivityResult(i6, i10, intent);
        if (i6 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f4988a = 0;
            setResult(i10, intent);
            if (booleanExtra) {
                C4334e c4334eM8359f = C4334e.m8359f(this);
                if (i10 == -1) {
                    HandlerC1731y0 handlerC1731y0 = c4334eM8359f.f14710m;
                    handlerC1731y0.sendMessage(handlerC1731y0.obtainMessage(3));
                } else if (i10 == 0) {
                    c4334eM8359f.m8364g(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i6 == 2) {
            this.f4988a = 0;
            setResult(i10, intent);
        }
        finish();
    }

    @Override
    public final void onCancel(DialogInterface dialogInterface) {
        this.f4988a = 0;
        setResult(0);
        finish();
    }

    @Override
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f4988a = bundle.getInt("resolution");
        }
        if (this.f4988a != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                Log.e("GoogleApiActivity", "Activity started without extras");
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get("error_code");
            if (pendingIntent == null && num == null) {
                Log.e("GoogleApiActivity", "Activity started without resolution");
                finish();
                return;
            }
            if (pendingIntent == null) {
                AbstractC1312l.m3198e(num);
                C4109b.f13933d.m8125c(this, num.intValue(), this);
                this.f4988a = 1;
                return;
            }
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                this.f4988a = 1;
            } catch (ActivityNotFoundException e5) {
                if (extras.getBoolean("notify_manager", true)) {
                    C4334e.m8359f(this).m8364g(new ConnectionResult(22, null), getIntent().getIntExtra("failing_client_id", -1));
                } else {
                    String strM24r = AbstractC0004e.m24r("Activity not found while launching ", pendingIntent.toString(), ".");
                    if (Build.FINGERPRINT.contains("generic")) {
                        strM24r = strM24r.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                    }
                    Log.e("GoogleApiActivity", strM24r, e5);
                }
                this.f4988a = 1;
                finish();
            } catch (IntentSender.SendIntentException e10) {
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e10);
                finish();
            }
        }
    }

    @Override
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f4988a);
        super.onSaveInstanceState(bundle);
    }
}
