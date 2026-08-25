package p195s0;

import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.media3.common.C0628x;
import p187r4.C3624n;

public final class C3687d extends InputConnectionWrapper {

    public final C0628x f12341a;

    public C3687d(InputConnection inputConnection, C0628x c0628x) {
        super(inputConnection, false);
        this.f12341a = c0628x;
    }

    @Override
    public final boolean commitContent(InputContentInfo inputContentInfo, int i6, Bundle bundle) {
        C3624n c3624n = null;
        if (inputContentInfo != null && Build.VERSION.SDK_INT >= 25) {
            c3624n = new C3624n(1, new C3689f(inputContentInfo));
        }
        if (this.f12341a.m1738d(c3624n, i6, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i6, bundle);
    }
}
