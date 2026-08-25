package p035d1;

import android.text.Editable;
import p014b1.C1245s;

public final class C2123a extends Editable.Factory {

    public static final Object f7729a = new Object();

    public static volatile C2123a f7730b;

    public static Class f7731c;

    @Override
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f7731c;
        return cls != null ? new C1245s(cls, charSequence) : super.newEditable(charSequence);
    }
}
