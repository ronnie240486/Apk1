package p138n0;

import android.view.View;
import android.view.Window;
import androidx.media3.common.C0565C;

public class C3159t1 extends C3156s1 {
    @Override
    public final void mo6354G(boolean z7) {
        Window window = this.f10649f;
        if (!z7) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        } else {
            window.clearFlags(C0565C.BUFFER_FLAG_NOT_DEPENDED_ON);
            window.addFlags(Integer.MIN_VALUE);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 8192);
        }
    }
}
