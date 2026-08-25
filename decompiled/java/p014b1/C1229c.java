package p014b1;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import p249x4.C4112e;

public final class C1229c extends C4112e {
    @Override
    public final Signature[] mo3105m(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }
}
