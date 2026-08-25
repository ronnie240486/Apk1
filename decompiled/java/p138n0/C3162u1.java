package p138n0;

import android.view.View;
import android.view.Window;
import androidx.media3.common.C0565C;

public final class C3162u1 extends C3159t1 {
    @Override
    public final void mo6357F(boolean z7) {
        Window window = this.f10649f;
        if (!z7) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-17));
        } else {
            window.clearFlags(C0565C.BUFFER_FLAG_FIRST_SAMPLE);
            window.addFlags(Integer.MIN_VALUE);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 16);
        }
    }
}
