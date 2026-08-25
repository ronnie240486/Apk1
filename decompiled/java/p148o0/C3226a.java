package p148o0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class C3226a extends ClickableSpan {

    public final int f10837a;

    public final C3233h f10838b;

    public final int f10839c;

    public C3226a(int i6, C3233h c3233h, int i10) {
        this.f10837a = i6;
        this.f10838b = c3233h;
        this.f10839c = i10;
    }

    @Override
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f10837a);
        this.f10838b.f10862a.performAction(this.f10839c, bundle);
    }
}
