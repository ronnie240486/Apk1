package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.media3.exoplayer.hls.offline.ExecutorC0785a;
import java.io.File;
import p187r4.C3624n;
import p207t1.AbstractC3792d;

public class ProfileInstallReceiver extends BroadcastReceiver {
    @Override
    public final void onReceive(Context context, Intent intent) throws Throwable {
        Bundle extras;
        File codeCacheDir;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            AbstractC3792d.m7560s(context, new ExecutorC0785a(), new C3624n(3, this), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if (!"WRITE_SKIP_FILE".equals(string)) {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        Log.d("ProfileInstaller", "RESULT_DELETE_SKIP_FILE_SUCCESS");
                        setResultCode(11);
                        return;
                    }
                    return;
                }
                C3624n c3624n = new C3624n(3, this);
                try {
                    AbstractC3792d.m7546e(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                    c3624n.mo6880b(10, null);
                    return;
                } catch (PackageManager.NameNotFoundException e5) {
                    c3624n.mo6880b(7, e5);
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            C3624n c3624n2 = new C3624n(3, this);
            if (Build.VERSION.SDK_INT < 24) {
                c3624n2.mo6880b(13, null);
                return;
            } else {
                Process.sendSignal(Process.myPid(), 10);
                c3624n2.mo6880b(12, null);
                return;
            }
        }
        if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
        C3624n c3624n3 = new C3624n(3, this);
        if (!"DROP_SHADER_CACHE".equals(string2)) {
            c3624n3.mo6880b(16, null);
            return;
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 24) {
            codeCacheDir = context.createDeviceProtectedStorageContext().getCodeCacheDir();
        } else {
            codeCacheDir = i6 >= 23 ? context.getCodeCacheDir() : context.getCacheDir();
        }
        if (AbstractC3792d.m7544c(codeCacheDir)) {
            c3624n3.mo6880b(14, null);
        } else {
            c3624n3.mo6880b(15, null);
        }
    }
}
