package androidx.appcompat.app;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

public final class C0128d implements AdapterView.OnItemClickListener {

    public final C0136h f270a;

    public final C0130e f271b;

    public C0128d(C0130e c0130e, C0136h c0136h) {
        this.f271b = c0130e;
        this.f270a = c0136h;
    }

    @Override
    public final void onItemClick(AdapterView adapterView, View view, int i6, long j10) {
        C0130e c0130e = this.f271b;
        DialogInterface.OnClickListener onClickListener = c0130e.f280h;
        C0136h c0136h = this.f270a;
        onClickListener.onClick(c0136h.f358b, i6);
        if (c0130e.f282j) {
            return;
        }
        c0136h.f358b.dismiss();
    }
}
