package androidx.appcompat.widget;

import android.widget.EditText;
import java.lang.ref.WeakReference;
import p014b1.AbstractC1233g;
import p035d1.C2130h;

public final class C0219i3 extends AbstractC1233g {

    public final int f950a = 1;

    public final WeakReference f951b;

    public C0219i3(EditText editText) {
        this.f951b = new WeakReference(editText);
    }

    @Override
    public void mo700a() {
        switch (this.f950a) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) this.f951b.get();
                if (switchCompat != null) {
                    switchCompat.m607c();
                }
                break;
        }
    }

    @Override
    public final void mo701b() {
        switch (this.f950a) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) this.f951b.get();
                if (switchCompat != null) {
                    switchCompat.m607c();
                }
                break;
            default:
                C2130h.m5080a((EditText) this.f951b.get(), 1);
                break;
        }
    }

    public C0219i3(SwitchCompat switchCompat) {
        this.f951b = new WeakReference(switchCompat);
    }
}
